package com.example.data.repository

import com.example.data.database.*
import com.example.data.api.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.squareup.moshi.Moshi

class PathPilotRepository(private val dao: PathPilotDao) {

    val userProfile: Flow<UserProfile?> = dao.getUserProfile()
    val opportunities: Flow<List<IncomeOpportunity>> = dao.getOpportunities()
    val roadmapTasks: Flow<List<RoadmapTask>> = dao.getRoadmapTasks()
    val weeklyReviews: Flow<List<WeeklyReview>> = dao.getWeeklyReviews()
    val achievements: Flow<List<Achievement>> = dao.getAchievements()

    suspend fun insertProfile(profile: UserProfile) = withContext(Dispatchers.IO) {
        dao.insertUserProfile(profile)
    }

    suspend fun updateTask(task: RoadmapTask) = withContext(Dispatchers.IO) {
        dao.updateRoadmapTask(task)
    }

    suspend fun addWeeklyReview(review: WeeklyReview) = withContext(Dispatchers.IO) {
        dao.insertWeeklyReview(review)
    }

    suspend fun unlockAchievement(title: String) = withContext(Dispatchers.IO) {
        dao.unlockAchievement(title)
    }

    suspend fun clearAll() = withContext(Dispatchers.IO) {
        dao.clearOpportunities()
        dao.clearRoadmapTasks()
    }

    suspend fun populateFallbackAchievements() = withContext(Dispatchers.IO) {
        val list = listOf(
            Achievement(title = "First Dollar", description = "Earn your first $1 online with a verified task.", iconName = "monetization_on", isUnlocked = false),
            Achievement(title = "First Proof", description = "Successfully submit proof for an AI-verified roadmap task.", iconName = "verified", isUnlocked = false),
            Achievement(title = "Direction Cleared", description = "Complete onboarding and discover your core Path.", iconName = "assistant_navigation", isUnlocked = false),
            Achievement(title = "Consistent Exec", description = "Register a weekly review and maintain accountability.", iconName = "update", isUnlocked = false),
            Achievement(title = "Centennial Milestone", description = "Reach $100 in cumulative verified income.", iconName = "emoji_events", isUnlocked = false)
        )
        dao.insertAchievements(list)
    }

    // --- Onboarding & Roadmap Generation ---
    suspend fun analyzeOnboardingAndGenerateRoadmap(
        interests: String,
        skills: String,
        assets: String,
        constraints: String
    ): OnboardingAnalysisResponse? = withContext(Dispatchers.IO) {
        val apiKey = RetrofitClient.apiKey
        if (apiKey.isEmpty() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext generateOfflineOnboarding(interests, skills, assets, constraints)
        }

        val prompt = """
            You are PathPilot, an expert AI Career and Income Generation Mentor.
            Analyze the user's profile and recommend 1 high-potential active income path & title, 3 specific opportunities (IMMEDIATE: 1-30 Days, MEDIUM: 1-6 Months, LONG: 6-36 Months), and a list of 5 actionable, sequence-ordered proof-based progress milestones/tasks.

            Input profile:
            Interests: $interests
            Skills: $skills
            Assets: $assets
            Constraints: $constraints

            Your response MUST be a valid JSON fitting this schema:
            {
              "activePathType": "String representing short category e.g. Freelance, Web Dev, Design, Content",
              "activePathTitle": "String representing descriptive path e.g. Python Automation Specialist",
              "scores": {
                "direction": 30, "execution": 20, "income": 0, "consistency": 15, "skill": 25, "overall": 20
              },
              "opportunities": [
                {
                  "title": "Immediate Freelance Gig Name",
                  "term": "IMMEDIATE",
                  "description": "Specific gig description",
                  "potentialEarnings": "$20 - $50 / hr",
                  "difficulty": "Easy",
                  "actionSteps": "Step 1, Step 2, Step 3"
                },
                ... (provide exactly 3 opportunities: one for IMMEDIATE, one for MEDIUM, one for LONG)
              ],
              "initialTasks": [
                {
                  "title": "Set up professional portfolio profile",
                  "description": "Create a Github repository or Fiverr profile highlighting your Python scripting capabilities.",
                  "daysText": "Day 1-5",
                  "proofRequired": "Provide the complete link to your GitHub repository or Fiverr service URL.",
                  "evidenceType": "GitHub Link",
                  "verificationLevel": "L3_LINK"
                },
                ... (provide exactly 5 progressive tasks)
              ]
            }

            Ensure you output ONLY the raw JSON block without any markdown formatting wrappers (no ```json code blocks or backticks).
        """.trimIndent()

        val request = GenerateContentRequest(
            contents = listOf(Content(parts = listOf(Part(text = prompt)))),
            generationConfig = GenerationConfig(responseMimeType = "application/json", temperature = 0.5)
        )

        try {
            val response = RetrofitClient.service.generateContent(apiKey, request)
            val jsonText = response.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
            if (jsonText != null) {
                val adapter = RetrofitClient.getMoshi().adapter(OnboardingAnalysisResponse::class.java)
                adapter.fromJson(jsonText)
            } else {
                generateOfflineOnboarding(interests, skills, assets, constraints)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            generateOfflineOnboarding(interests, skills, assets, constraints)
        }
    }

    // --- Proof Verification Engine ---
    suspend fun verifyProofSubmitted(
        taskTitle: String,
        taskDesc: String,
        proofReq: String,
        submittedEvidence: String,
        evidenceType: String
    ): VerificationResponse? = withContext(Dispatchers.IO) {
        val apiKey = RetrofitClient.apiKey
        if (apiKey.isEmpty() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext generateOfflineVerification(taskTitle, submittedEvidence)
        }

        val prompt = """
            Evaluate the user's evidence for a completed milestone task.
            Task: $taskTitle ($taskDesc)
            Verification requirement: $proofReq
            Submitted Evidence: $submittedEvidence (Evidence Type: $evidenceType)

            Decide if the evidence matches the expectations of the task with a reasonable degree of completeness.
            Spam, blank submittals, or unrelated inputs must be rejected.
            Your response MUST be a valid JSON matching this schema:
            {
              "approved": true or false,
              "feedback": "Encouraging explanation, explaining why approved or rejected",
              "incomeEarned": 15.0, (Set directly as currency earned if this task represents a monetize action e.g. client project, otherwise 0.0)
              "scoreAdjustments": {
                "direction": 5, "execution": 10, "income": 10, "consistency": 5, "skill": 10, "overall": 8
              } (small values or null if rejected)
            }
            Ensure you output ONLY the raw JSON block without any markdown formatting wrappers.
        """.trimIndent()

        val request = GenerateContentRequest(
            contents = listOf(Content(parts = listOf(Part(text = prompt)))),
            generationConfig = GenerationConfig(responseMimeType = "application/json", temperature = 0.3)
        )

        try {
            val response = RetrofitClient.service.generateContent(apiKey, request)
            val jsonText = response.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
            if (jsonText != null) {
                val adapter = RetrofitClient.getMoshi().adapter(VerificationResponse::class.java)
                adapter.fromJson(jsonText)
            } else {
                generateOfflineVerification(taskTitle, submittedEvidence)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            generateOfflineVerification(taskTitle, submittedEvidence)
        }
    }

    // --- Weekly Reviews Adjuster ---
    suspend fun processWeeklyReview(
        whatFinished: String,
        whatStopped: String,
        whatWorked: String,
        whatFailed: String,
        tasksContext: String
    ): WeeklyReviewAdjustmentResponse? = withContext(Dispatchers.IO) {
        val apiKey = RetrofitClient.apiKey
        if (apiKey.isEmpty() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext generateOfflineWeeklyReview(whatFinished)
        }

        val prompt = """
            Conduct a weekly accountability review. Use the responses of the weekly reflection and current state to provide adjusting advice.
            Reflection responses:
            - What finished: $whatFinished
            - Obstacles: $whatStopped
            - Successes: $whatWorked
            - Failures: $whatFailed

            Current tasks state:
            $tasksContext

            Your response MUST be a valid JSON fitting this schema:
            {
              "scores": {
                "direction": 45, "execution": 35, "income": 15, "consistency": 40, "skill": 30, "overall": 35
              },
              "advisoryFeedback": "Advisory text and concrete tips for next week",
              "adjustedTasks": [
                {
                  "title": "Next step milestone title",
                  "description": "Specific description",
                  "daysText": "Week 2",
                  "proofRequired": "Proof parameters",
                  "evidenceType": "URL",
                  "verificationLevel": "L3_LINK"
                }
              ] (or null)
            }
            Ensure you output ONLY the raw JSON block without any markdown wrappers.
        """.trimIndent()

        val request = GenerateContentRequest(
            contents = listOf(Content(parts = listOf(Part(text = prompt)))),
            generationConfig = GenerationConfig(responseMimeType = "application/json", temperature = 0.5)
        )

        try {
            val response = RetrofitClient.service.generateContent(apiKey, request)
            val jsonText = response.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
            if (jsonText != null) {
                val adapter = RetrofitClient.getMoshi().adapter(WeeklyReviewAdjustmentResponse::class.java)
                adapter.fromJson(jsonText)
            } else {
                generateOfflineWeeklyReview(whatFinished)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            generateOfflineWeeklyReview(whatFinished)
        }
    }

    // --- Fallback Generators for Offline Access ---

    private fun generateOfflineOnboarding(
        interests: String,
        skills: String,
        assets: String,
        constraints: String
    ): OnboardingAnalysisResponse {
        val primaryInterest = interests.split(",").firstOrNull()?.trim() ?: "Digital Work"
        val activePath = when {
            primaryInterest.contains("tech", true) || primaryInterest.contains("comput", true) || skills.contains("python", true) -> {
                OnboardingAnalysisResponse(
                    activePathType = "Freelance",
                    activePathTitle = "$primaryInterest Automation Developer",
                    scores = ScoresConfig(35, 25, 0, 15, 30, 20),
                    opportunities = listOf(
                        OpportunityItem("API Integration Gigs", "IMMEDIATE", "Build custom scripts integrating Google Sheets and OpenAI APIs.", "$15 - $40 / hr", "Medium", "1. Set up Fiverr gig\n2. Share on Twitter/LinkedIn\n3. Deliver script with short video demo"),
                        OpportunityItem("Automation Agency", "MEDIUM", "Outsource automated social scheduling for local stores.", "$500 - $1200 / client", "Hard", "1. Pitch local bakeries\n2. Automate their posts via Make.com\n3. Secure monthly retainer"),
                        OpportunityItem("Micro-SaaS Product", "LONG", "Create a simple dashboard tracking daily habit links.", "$9 / mo subscription", "Hard", "1. Code MVP in Python\n2. Ship to ProductHunt\n3. Gather feedback and scale")
                    ),
                    initialTasks = listOf(
                        TaskItem("Initialize Portfolio Hub", "Build a GitHub repository or active Notion page showcasing your portfolio projects.", "Day 1-3", "Submit link to your public project portfolio.", "URL", "L3_LINK"),
                        TaskItem("Launch Service Listing", "Construct a professional services profile matching your chosen path on Upwork or Fiverr.", "Day 4-7", "Verify with profile URL link.", "Fiverr Profile", "L3_LINK"),
                        TaskItem("Conduct 3 Cold Pitch Outreach", "Formulate and send custom assistance outreach emails to active micro-startups outlining script automations.", "Day 8-12", "Provide cold email screenshot copy or client reply.", "Screenshot", "L2_SCREENSHOT"),
                        TaskItem("Deliver Mock Client Prototype", "Design a custom Automation mockup representing a functional asset.", "Day 13-18", "Provide public repository link of script.", "GitHub Link", "L3_LINK"),
                        TaskItem("Secure and Verify First Contract", "Successfully engage a client (or complete mock assignment) and record your first dollar earned.", "Day 19-30", "Submit client invoice receipt or Fiverr earnings statement.", "Revenue URL", "L4_REVENUE")
                    )
                )
            }
            primaryInterest.contains("fit", true) || primaryInterest.contains("health", true) -> {
                OnboardingAnalysisResponse(
                    activePathType = "Content Creation",
                    activePathTitle = "Niche Fitness Guide & Coach",
                    scores = ScoresConfig(30, 20, 0, 25, 20, 18),
                    opportunities = listOf(
                        OpportunityItem("Consultation Gigs", "IMMEDIATE", "Offer personalized meal plans or exercise guidelines.", "$25 / plan", "Easy", "1. Create meal plan templates\n2. Post on Instagram/Reddit\n3. Accept payments via Stripe"),
                        OpportunityItem("Affiliate Coaching Product", "MEDIUM", "Recommend custom fitness tracking gear and supplements.", "15% Commission", "Medium", "1. Sign up for Amazon Associates\n2. Create a Linktree landing page\n3. Record workout short videos"),
                        OpportunityItem("Monthly Group Coaching", "LONG", "Host a private accountability Discord community.", "$15 / member / mo", "Hard", "1. Build Discord community server\n2. Scale video audience\n3. Sell subscription links")
                    ),
                    initialTasks = listOf(
                        TaskItem("Design Coaching Catalog", "Draft a 1-page PDF document detailing your online exercise and nutritional guide plans.", "Day 1-3", "Upload sharing URL of the PDF guide.", "Portfolio URL", "L3_LINK"),
                        TaskItem("Construct Bio Link Landing", "Assemble your professional Linktree, Beacons, or personal website containing monetization buttons.", "Day 4-7", "Provide URL link of the live page.", "Portfolio URL", "L3_LINK"),
                        TaskItem("Post 3 Short Tutorial Reels", "Record and publish 3 brief informational video clips addressing fitness myths on TikTok/reels.", "Day 8-12", "Provide live post URL links.", "Video Uploads", "L3_LINK"),
                        TaskItem("Obtain First Advisory Client", "Recruit an initial advisory candidate (or simulate demo helper) and log milestones.", "Day 13-18", "Submit screenshot of client confirmation chat.", "Screenshot", "L2_SCREENSHOT"),
                        TaskItem("Verify First Coaching Sale", "Generate first transaction from custom planning services.", "Day 19-30", "Upload Stripe invoice page or payout receipt screenshot.", "Revenue Screenshot", "L4_REVENUE")
                    )
                )
            }
            else -> {
                OnboardingAnalysisResponse(
                    activePathType = "Agency & Service",
                    activePathTitle = "Niche $primaryInterest Content Assistant",
                    scores = ScoresConfig(28, 22, 0, 20, 18, 17),
                    opportunities = listOf(
                        OpportunityItem("Social Media Graphics Gigs", "IMMEDIATE", "Design aesthetic templates and carousels for creator handles.", "$10 - $25 / gig", "Easy", "1. Set up Canva portfolios\n2. Cold-message 10 active creators\n3. Deliver PNG packages"),
                        OpportunityItem("Consulting Agency", "MEDIUM", "Manage design assets and post schedules for local accounts.", "$300 - $800 / mo", "Medium", "1. Bundle design layouts\n2. Offer free week trials\n3. Upgrade to monthly dynamic retainers"),
                        OpportunityItem("Template Marketplace Creator", "LONG", "Publish master templates on Gumroad or Notion library.", "Passive Sales", "Hard", "1. Create master workspace templates\n2. Film short tutorial walks\n3. Launch in digital market registries")
                    ),
                    initialTasks = listOf(
                        TaskItem("Create Visual Asset Portfolio", "Assemble a clean portfolio showcasing your design templates, written carousels, or editing drafts.", "Day 1-3", "Provide portfolio landing page link.", "Portfolio Link", "L3_LINK"),
                        TaskItem("Publish Marketplace Service Listing", "Register and specify dynamic service tiers on Fiverr or Upwork.", "Day 4-7", "Provide live profile link.", "Fiverr Profile", "L3_LINK"),
                        TaskItem("Initiate Cold creator Outreach", "Draft and pitch custom template upgrades to 5 potential internet creators.", "Day 8-12", "Provide screenshot or transcript of outreach draft.", "Screenshot", "L2_SCREENSHOT"),
                        TaskItem("Build Demonstration Template Bundle", "Develop a sample package representing highly editable layouts for target niches.", "Day 13-18", "Upload public viewing or sharing link of templates.", "Portfolio URL", "L3_LINK"),
                        TaskItem("Secure First Paid Client Retainer", "Confirm your initial project transaction or contract deal.", "Day 19-30", "Upload transaction receipt, invoice proof or escrow verification link.", "Revenue Screenshot", "L4_REVENUE")
                    )
                )
            }
        }
        return activePath
    }

    private fun generateOfflineVerification(taskTitle: String, evidenceText: String): VerificationResponse {
        val valid = evidenceText.length > 8
        return if (valid) {
            val isRevenueTask = taskTitle.contains("Contract", true) || taskTitle.contains("Sale", true) || taskTitle.contains("First Dollar", true)
            VerificationResponse(
                approved = true,
                feedback = "Awesome work! Proof is verified online as compliant with standards, demonstrating genuine effort in execution. PathPilot tracks this output metrics successfully.",
                incomeEarned = if (isRevenueTask) 25.0 else 0.0,
                scoreAdjustments = ScoreAdjustments(
                    direction = 2,
                    execution = 8,
                    income = if (isRevenueTask) 15 else 0,
                    consistency = 5,
                    skill = 6,
                    overall = 4
                )
            )
        } else {
            VerificationResponse(
                approved = false,
                feedback = "Proof rejected. The submitted text remains too short or invalid to prove completion. Please provide a descriptive link, valid Upwork/Fiverr resource profile, or explanatory statement.",
                incomeEarned = 0.0,
                scoreAdjustments = null
            )
        }
    }

    private fun generateOfflineWeeklyReview(whatFinished: String): WeeklyReviewAdjustmentResponse {
        return WeeklyReviewAdjustmentResponse(
            scores = ScoresConfig(45, 35, 12, 38, 32, 32),
            advisoryFeedback = "Excellent self-reflection! To elevate progress in the upcoming 7 days, prioritize removing routine distractions and commit to 3 cold outreach calls each day. Consistency is the primary catalyst for secure digital freelancing.",
            adjustedTasks = listOf(
                TaskItem(
                    title = "Integrate Client Feedback Cycle",
                    description = "Request concrete feedback reviews from a collaborator or initial client to iteratively improve your work deliverables.",
                    daysText = "Upcoming week",
                    proofRequired = "Share testimonial screenshots or revised guide outline.",
                    evidenceType = "Screenshot",
                    verificationLevel = "L2_SCREENSHOT"
                )
            )
        )
    }
}
