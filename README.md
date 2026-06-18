# 🧭 PathPilot — AI Life Direction, Income, Idea Validation & Resource Discovery Platform

<div align="center">

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Language](https://img.shields.io/badge/Kotlin-100%25-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![AI](https://img.shields.io/badge/Google%20Gemini-AI%20Powered-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Build](https://img.shields.io/badge/Build-Gradle%20Kotlin%20DSL-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![IDE](https://img.shields.io/badge/Android%20Studio-Required-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-00C853?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-MVP%20Development-orange?style=for-the-badge)

**PathPilot is a mobile-first AI platform that helps young people discover their direction, explore realistic earning paths, improve ideas without judgment, find free AI tools and learning resources, and track real progress with proof-based accountability — all powered by Google Gemini AI.**

 *"I know what to do next."* — what every PathPilot user should feel.

[📱 App Overview](#-overview) · [🧩 Modules](#-core-modules) · [🏗️ Architecture](#-architecture) · [🚀 Getting Started](#-getting-started) · [🔑 Environment Setup](#-environment-setup) · [📂 Project Structure](#-project-structure)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [The Problem PathPilot Solves](#-the-problem-pathpilot-solves)
- [Product Philosophy](#-product-philosophy)
- [Target Users](#-target-users)
- [Core Modules](#-core-modules)
  - [Direction Finder](#1--direction-finder)
  - [Earn Money Engine](#2--earn-money-engine)
  - [Idea Booster — Startup Lab](#3--idea-booster--startup-lab)
  - [AI Tools Vault](#4--ai-tools-vault)
  - [Resources Hub](#5--resources-hub)
  - [Progress Tracker](#6--progress-tracker)
  - [Proof Verification System](#7--proof-verification-system)
  - [Weekly Accountability Review](#8--weekly-accountability-review)
  - [Challenges & Missions](#9--challenges--missions)
  - [Community & Peer Groups](#10--community--peer-groups)
  - [Skill Builder Academy](#11--skill-builder-academy)
  - [Opportunity Marketplace](#12--opportunity-marketplace)
- [App Screens & Navigation](#-app-screens--navigation)
- [AI Behavior & Output Format](#-ai-behavior--output-format)
- [Architecture](#-architecture)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Environment Setup](#-environment-setup)
- [Feature Priority](#-feature-priority)
- [Success Metrics](#-success-metrics)
- [Data Models](#-data-models)
- [User Stories](#-user-stories)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [License](#-license)

---

## 📌 Overview

PathPilot is **not a chatbot**.

It is a personal operating system for life, money, skills, ideas, AI tools, and execution — built as a beautiful mobile-first Android application powered by **Google Gemini AI**.

Where most apps give generic advice, PathPilot learns who the user actually is — their skills, interests, goals, available time, financial pressure, and preferred work style — and then gives them a personalised, actionable path forward. Every output is specific, practical, and honest.

The platform was built for the millions of young people — students, fresh graduates, aspiring freelancers, confused adults — who know they want something better but don't know where to start. PathPilot answers the questions nobody in their life is equipped to answer:

- *What should I actually do with my life?*
- *How can I earn money using my skills and a laptop?*
- *Is my startup idea good, or is it just a dream?*
- *Which free AI tools should I be using?*
- *What should I learn next?*
- *How do I prove I actually did the work?*

Built with Kotlin for Android, powered by Google Gemini via the AI Studio API, and scaffolded from the Google AI Studio Android template.

---

## 🌍 The Problem PathPilot Solves

### The reality for most young people

| Problem | Impact |
|---|---|
| No access to mentorship or career guidance | Waste years in the wrong direction |
| Generic career advice that doesn't fit their situation | Advice doesn't translate to action |
| Embarrassment about sharing weak or "silly" ideas | Ideas die before they're explored |
| Overwhelmed by too many learning resources | Never start because of analysis paralysis |
| Self-reported progress with no accountability | Goal-setting without follow-through |
| No visibility into what free tools exist | Miss opportunities that could save weeks |
| Skills but no idea how to monetize them | Skill-rich, income-poor |

PathPilot directly addresses every single one of these problems through its twelve integrated modules.

### Why existing solutions fail

| Existing Tool | Why It Doesn't Work for This Audience |
|---|---|
| LinkedIn | Designed for established professionals, not confused beginners |
| Coursera / Udemy | Passive learning, no personalization, no accountability |
| Generic AI chatbots | No memory, no structure, no accountability, no proof system |
| Career counselors | Expensive, inaccessible, often give generic advice |
| YouTube | Great content, zero structure, no personalized path |
| Notion templates | Requires self-discipline to use consistently |

PathPilot is the first platform designed specifically for the person who needs all of this at once — direction, income, ideas, tools, resources, and accountability — in one mobile-first experience.

---

## 💡 Product Philosophy

PathPilot is built on ten non-negotiable principles:

1. **Understand the user deeply** — ask real, thoughtful questions before giving any guidance
2. **Give honest but kind feedback** — no empty validation, no cruel rejection
3. **Never embarrass bad ideas** — improve ideas, don't discard people
4. **Focus on outcomes, not just advice** — every session should end with a clear next action
5. **Use free tools first** — the user may have a laptop and internet, nothing more
6. **Track proof, not claims** — completion means nothing without evidence
7. **Stay simple and mobile-first** — work on a mid-range Android phone, not just flagships
8. **Personalise everything** — the same advice for everyone is advice for no one
9. **Support real progress** — roadmaps adjust automatically based on what actually happened
10. **Respect the user's situation** — financial pressure, time constraints, and language barriers are real

---

## 👥 Target Users

### Primary Users

| User Type | What They Need |
|---|---|
| **Students** | Direction, skills, and earning paths they can start now |
| **Fresh graduates** | Realistic income paths when jobs are scarce |
| **Confused young adults** | Someone to help them figure out what they actually want |
| **Job seekers** | Skills to build and alternative income while searching |
| **Aspiring freelancers** | First client strategy, pricing, and platform guidance |
| **Aspiring founders** | Idea validation, MVP planning, and launch roadmaps |
| **Creators** | Audience building, monetization, and tool discovery |
| **Online income seekers** | Practical steps from zero to first earning |
| **People who feel stuck** | Clarity, direction, and a confidence reset |

### Secondary Users

| User Type | How They Use PathPilot |
|---|---|
| Mentors | Share roadmaps and resources with mentees |
| Teachers | Assign structured challenges to students |
| Career coaches | Use as a structured supplement to 1:1 sessions |
| Startup communities | Recommend to early-stage founders for idea validation |
| Skill learning communities | Share the Resources Hub and Skill Builder Academy |

---

## 🧩 Core Modules

PathPilot is built around twelve deeply integrated modules, each designed to address a specific barrier to progress.

---

### 1. 🎯 Direction Finder

**Purpose:** Help users who are confused, lost, or unsure about their direction.

The Direction Finder conducts a deep, conversational interview with the user — asking questions that most people have never been asked about themselves. The AI doesn't ask "what's your dream job?" It asks what they genuinely enjoy, what drains them, what people always ask them for help with, and what kind of life they want to live.

**Questions the AI asks:**
- What do you enjoy doing for hours without noticing time pass?
- What topics do you keep returning to even when nobody asks you to?
- What kind of work do you hate? What drains your energy?
- What are you naturally good at, even if you don't think it's valuable?
- What have people always asked you for help with?
- What work style suits you — independent, collaborative, structured, creative?
- What kind of life do you want in 5 years?
- What do you want more of? What do you want less of?

**AI Output — Personalised Direction Report:**

```
┌─────────────────────────────────────────────────────┐
│  PERSONALITY SUMMARY                                │
│  Introverted · Analytical · Creative · Builder      │
├─────────────────────────────────────────────────────┤
│  STRENGTH SUMMARY                                   │
│  Problem-solving · Communication · Pattern recognition │
├─────────────────────────────────────────────────────┤
│  INTEREST CLUSTERS                                  │
│  Technology · Teaching · Design · Business          │
├─────────────────────────────────────────────────────┤
│  RECOMMENDED PATHS                                  │
│  1. AI Automation Freelancer                        │
│  2. Content Creator for Tech Topics                 │
│  3. No-Code Product Builder                         │
├─────────────────────────────────────────────────────┤
│  NEXT STEPS                                         │
│  Week 1: Learn [specific skill] with [free resource]│
│  Week 2: Build [specific portfolio piece]           │
│  Week 3: Apply to [specific platform]               │
└─────────────────────────────────────────────────────┘
```

---

### 2. 💰 Earn Money Engine

**Purpose:** Help every user understand how to make real money using their laptop, phone, skills, and available time.

This is a mandatory module — every user goes through the Earn Money Engine during onboarding because earning capacity is foundational to life direction. The AI builds a personalised income roadmap from the user's current reality, not an idealized future version of themselves.

**Information the AI collects:**
- What devices do you have? (Laptop, phone, both?)
- How many hours per day can you dedicate?
- What skills do you already have, even basic ones?
- What kind of work do you prefer?
- Do you need money quickly or can you build slowly?
- What languages do you speak?
- What tools or platforms have you used before?
- Are you open to freelancing, content, business, or employment?

**AI Output — Personalised Income Roadmap:**

The AI generates three earning tiers, each with specific milestones:

| Tier | Goal | Timeline | Strategy |
|---|---|---|---|
| **Fast Track** | First $10–$50 | 7–14 days | Immediate skill monetization (writing, VA work, data entry) |
| **Medium Build** | First $100–$500/month | 30–90 days | Freelance platform, consistent client acquisition |
| **Long-Term** | $1,000+/month | 3–12 months | Service agency, digital products, content monetization |

**Example earning paths PathPilot recommends:**
- Freelance writing, copywriting, and content creation
- Graphic design with Canva for social media clients
- Video editing for YouTube creators and businesses
- AI automation services for small businesses
- Prompt engineering and AI consulting
- Virtual assistant work (admin, scheduling, research)
- Coding services and no-code web building
- Tutoring in any subject the user knows
- Digital product creation (templates, e-books, presets)
- Local business support (social media, ads, website setup)
- Micro-agency setup around a single repeatable service

**Free tools the AI recommends for each path:** Canva, Pika, Runway, Copy.ai, Notion, Fiverr, Upwork, Toptal, LinkedIn, GitHub, Gumroad, LemonSqueezy.

---

### 3. 🚀 Idea Booster — Startup Lab

**Purpose:** Help users improve, validate, and refine startup or business ideas without judgment or embarrassment.

The Idea Booster operates on a fundamental principle: **no idea is too bad to explore**. Every rough, obvious, or "already been done" idea contains a signal. The AI's job is to find that signal, remove the noise, and give back something better.

**The AI never says:**
- ❌ "This is a bad idea."
- ❌ "That already exists."
- ❌ "This won't work."
- ❌ "You should think of something more original."

**The AI always says things like:**
- ✅ "The core signal here is strong — the execution needs narrowing."
- ✅ "The pain point isn't clear yet, but here's a better angle."
- ✅ "This already exists at scale, but there's a version that doesn't."
- ✅ "Here's a stronger version of this idea that could actually work."

**Input:** User describes their idea in plain language, however rough.

**AI Output — Idea Analysis Report:**

```
WHAT YOU SUBMITTED
"An app for people who want to learn coding"

WHAT IS STRONG
• Real, proven demand
• You have personal experience with this pain point
• Large addressable audience

WHAT IS WEAK OR RISKY
• Extremely broad — competes with Coursera, Udemy, freeCodeCamp at scale
• No differentiation identified yet
• Unclear which type of learner you're targeting

THE REAL SIGNAL
You're describing the problem of "I don't know where to start with coding
and generic platforms overwhelm me" — that's a much sharper problem.

IMPROVED IDEA
"AI-powered coding mentor for complete beginners who feel lost after
30 days on generic platforms" — niche, clear pain, defensible position.

SIMPLER MVP
A Telegram/WhatsApp bot that sends one 5-minute coding challenge per day
with AI feedback on the solution. Zero app needed. Test demand in 2 weeks.

MONETIZATION IDEAS
• $5/month subscription for premium challenges
• Affiliate revenue from developer tool recommendations
• Cohort-based micro-courses at $49 each

LAUNCH ROADMAP
Week 1: Build the bot. Week 2: Post in 3 coding communities. Week 3: 50 users.
Month 2: Charge $5/month. Month 3: First $500 MRR.

FREE TOOLS TO USE
Botpress, Gemini API, Notion for content, Twitter for distribution.
```

---

### 4. 🤖 AI Tools Vault

**Purpose:** Help users discover the right free AI tools for their specific use case, without wasting time on tools that don't fit.

The AI Tools Vault is a curated, searchable database of AI tools organized by category, with plain-language explanations that don't assume technical knowledge.

**Categories:**
- Vibe coding and no-code building
- Coding assistants and IDE tools
- Writing, copywriting, and content
- Image generation and editing
- Video creation and editing
- Research and knowledge tools
- Design and UI/UX tools
- Student and education tools
- Business and productivity tools
- Automation and workflow tools
- Social media and marketing tools

**For every tool, the app shows:**

| Field | Example |
|---|---|
| **Name** | Cursor |
| **What it does** | AI-powered code editor with inline suggestions |
| **Free tier** | 2,000 completions/month on free plan |
| **Best use case** | Building web apps faster, debugging, learning by doing |
| **Limitations** | Context window limited on free tier |
| **Alternatives** | GitHub Copilot, Windsurf, Claude Code |
| **Beginner guide** | Install → open project → Cmd+K to ask AI anything |
| **Learning resources** | Official docs, YouTube playlist, community forum |

**AI personalisation:** The Vault knows the user's interests, skills, and goals from their profile. Instead of showing all 200+ tools, it surfaces the 10 most relevant ones first with a "why this is for you" explanation.

---

### 5. 📚 Resources Hub

**Purpose:** Provide structured learning paths with the best free resources — so users spend less time searching and more time learning.

The Resources Hub solves the "I don't know where to start" and "I'm drowning in options" problems simultaneously. For each topic, it provides a curated beginner-to-advanced path.

**Resource types curated:**
- YouTube playlists (hand-picked, not algorithmic)
- GitHub repositories (starter kits, projects, boilerplates)
- Free courses (Coursera free tier, edX audit, freeCodeCamp, CS50)
- Official documentation
- Blog posts and tutorials
- Community forums (Discord, Reddit, Slack)
- Templates and starter kits
- Practice project ideas with increasing difficulty

**Topics covered:**
- AI and machine learning fundamentals
- Web development (frontend and backend)
- Mobile app development
- Graphic design and UI/UX
- Freelancing and client acquisition
- Business and entrepreneurship
- Marketing and growth
- Content creation and video editing
- Productivity and time management
- Career development and job searching
- Startup building and product thinking

**Output format for every topic:**

```
BEGINNER PATH (0 → First Project)
→ Resource 1: [Title] — [Platform] — [Why it's first]
→ Resource 2: [Title] — [Platform] — [What it unlocks]
→ Practice Project: Build [specific thing] using only these resources

INTERMEDIATE PATH (First Project → Job/Client-Ready)
→ Resource 3: [Title] — [Platform]
→ Resource 4: [Title] — [Platform]
→ Practice Project: Build [more complex thing]

ADVANCED PATH (Client-Ready → Expert)
→ Resource 5–7: [curated list]
→ Capstone Project: [real-world challenge]

FREE TOOLS FOR THIS PATH
→ [Tool 1], [Tool 2], [Tool 3]

COMMUNITY TO JOIN
→ [Discord/Reddit/Slack community name and link]
```

---

### 6. 📈 Progress Tracker

**Purpose:** Give users a single, visual view of their entire growth journey — goals, roadmaps, tasks, milestones, habits, and completion status.

Unlike traditional to-do apps or goal trackers, PathPilot's Progress Tracker is connected to everything else. When the Direction Finder creates a roadmap, it flows directly into the Progress Tracker. When the Earn Money Engine sets weekly targets, those targets appear as trackable milestones.

**What the Progress Tracker tracks:**
- Active roadmaps (from any module) with percentage completion
- Individual tasks within each roadmap
- Daily and weekly habits
- Milestones reached and outstanding
- Proof submission status per task
- Weekly consistency score
- Overall growth score
- Earning milestones ($10, $50, $100, $500, $1,000)
- Skill acquisition checkpoints
- Module usage patterns

**Visual elements:**
- Progress rings per active roadmap
- Weekly activity heatmap (GitHub contribution chart style)
- Streak counter with longest streak record
- Milestone celebration animations
- Proof submission percentage

**Score calculation:**

```
Weekly Consistency Score =
  (Tasks Completed / Tasks Assigned) × 0.4
+ (Proof Submitted / Proof Required) × 0.4
+ (Weekly Review Completed) × 0.2
× 100
```

---

### 7. ✅ Proof Verification System

**Purpose:** Ensure accountability through verified progress rather than self-reported claims.

This is PathPilot's most distinctive feature. Completion means nothing without evidence. The Proof Verification System requires users to submit tangible proof before the app marks important tasks as complete.

**The core rule:** You cannot tap "Done" on a significant task without submitting proof.

**Accepted proof types:**

| Proof Type | Example |
|---|---|
| **Screenshot** | Fiverr profile created, first message sent, account set up |
| **GitHub link** | Repository created, first commit pushed, project deployed |
| **Live URL** | Website live, landing page published, portfolio up |
| **Portfolio link** | Behance/Dribbble/Notion portfolio with work samples |
| **Video** | Screen recording of completed project or demo |
| **Certificate** | Course completion certificate |
| **Profile link** | Upwork, LinkedIn, Fiverr profile live and complete |
| **Revenue proof** | Screenshot of first payment received (amount blurred acceptable) |
| **Document upload** | Completed report, design file, or written work |

**Example flow:**

```
TASK: "Create your Fiverr profile"

User taps → "Mark as Complete"

System response:
"Before marking this complete, please submit proof.
Upload a screenshot of your live Fiverr profile URL,
or paste your profile link here."

User submits screenshot → Status: PENDING REVIEW

System verifies:
→ Screenshot shows Fiverr profile URL in browser bar ✓
→ Profile has a photo and description visible ✓
→ Status updated to: APPROVED ✓
→ +25 XP awarded, roadmap advances
```

**Verification states:**

| State | Meaning | Action Required |
|---|---|---|
| `pending` | Proof submitted, awaiting AI review | Wait for verification |
| `approved` | Proof accepted, task complete | Proceed to next task |
| `rejected` | Proof doesn't match the task | Resubmit valid proof |
| `needs_clarification` | Partially valid, more context needed | Add explanation |

---

### 8. 🧠 Weekly Accountability Review

**Purpose:** Conduct weekly AI-powered check-ins to evaluate actual progress and automatically adjust the user's roadmap.

Every week, PathPilot prompts the user for a structured review session. This isn't a journaling exercise — it's an operational review that feeds directly back into the user's active roadmaps.

**The AI asks seven questions:**

1. What tasks did you complete this week?
2. What did you avoid or push off?
3. What blocked you from completing what you planned?
4. What did you learn this week, planned or unplanned?
5. What should change about next week's plan?
6. What is your single most important focus next week?
7. On a scale of 1–10, how honest are you being with yourself right now?

**After the review, the AI:**
- Acknowledges genuine progress specifically ("You launched your Fiverr profile — that's a real milestone, not a small thing.")
- Names avoided tasks without judgment ("You skipped the client outreach. That's the hardest part. Let's figure out why.")
- Identifies patterns across multiple weeks ("For three weeks in a row, you've avoided cold outreach. This is the pattern blocking your first client.")
- Adjusts the roadmap automatically (pushes deadlines, breaks large tasks into smaller steps, removes tasks that are no longer relevant)
- Sets a specific focus for the coming week with one primary task

---

### 9. 🔥 Challenges & Missions

**Purpose:** Push users toward real-world action through structured, time-bound challenges with measurable outcomes.

Challenges bridge the gap between planning and doing. They are designed to be just uncomfortable enough to produce growth, without being so overwhelming that users give up.

**Challenge types:**

| Type | Frequency | Example |
|---|---|---|
| **Daily Mission** | Every day | "Send 3 connection requests to people in your target industry" |
| **Weekly Challenge** | Every week | "Complete your first freelance project, even for free" |
| **Monthly Mission** | Every month | "Earn your first $10 online from any skill" |
| **Milestone Challenge** | Triggered | "You've been active for 30 days — now apply to 5 real jobs" |

**Challenge mechanics:**
- Challenges are personalised based on the user's active path, skill level, and progress history
- Completing a challenge requires proof submission
- Challenges build on each other — completing Week 1 unlocks Week 2
- Missed challenges don't disappear — they queue and become "catch-up" challenges
- Streaks are tracked and celebrated

**Reward system:**
- XP (experience points) for completions
- Badges for milestone achievements
- Streak bonuses for consecutive completion
- Level progression (Beginner → Builder → Creator → Launcher → Founder)

---

### 10. 👥 Community & Peer Groups

**Purpose:** Connect users with like-minded learners, builders, freelancers, founders, and creators for accountability partnerships, collaboration, and shared learning.

Progress happens faster in community. PathPilot's community layer connects users who are at similar stages on similar paths — so a freelance copywriter connects with other freelance copywriters, not a random general audience.

**Community features:**
- **Peer groups** — small groups of 5–10 users on similar paths with weekly check-in rituals
- **Accountability partners** — 1:1 matching for mutual weekly accountability
- **Group discussions** — topic-based channels (Freelancing, Startups, AI Tools, Earning, Design, etc.)
- **Collaboration rooms** — find co-founders, collaborators, and teammates for projects
- **Shared wins** — users share proof of progress with their peer group
- **Resource sharing** — community members share free tools, resources, and opportunities they've found

**Matching algorithm:**
Users are matched based on:
- Path similarity (freelancing, founding, content, etc.)
- Stage similarity (beginner, intermediate, advanced)
- Time zone (for synchronous check-ins)
- Language preference

---

### 11. 🎓 Skill Builder Academy

**Purpose:** Create personalized skill-development journeys with beginner-to-advanced learning plans and practical projects that build portfolio-worthy work.

The Skill Builder Academy doesn't just recommend learning — it builds a complete curriculum and tracks execution. Every skill path ends with a portfolio-worthy project because learning without proof is invisible.

**How it works:**

1. User selects a skill to build (or AI recommends one based on their goals)
2. AI generates a personalized learning plan based on current level
3. Each stage has a clear learning resource + practice project
4. Projects get submitted as proof of completion
5. Completed projects are added to the user's PathPilot portfolio
6. AI evaluates projects and gives specific feedback

**Example Skill Path — "Freelance Copywriting":**

```
STAGE 1: Foundation (Week 1–2)
  Learn: "Copywriting Fundamentals" — CopyHackers (free)
  Practice: Rewrite 3 existing ads to be more compelling
  Proof required: Before/after comparison document

STAGE 2: First Work (Week 3–4)
  Learn: "Writing for the Web" — Nielsen Norman Group articles
  Practice: Write 3 complete landing pages for imaginary products
  Proof required: Google Doc with published pages

STAGE 3: Portfolio Ready (Week 5–6)
  Project: Write a complete email sequence for a real business (offer free)
  Proof required: Client testimonial or work sample with permission

STAGE 4: First Client (Week 7–8)
  Action: Publish Fiverr profile + apply to 10 job posts
  Proof required: Profile link + evidence of applications sent

GRADUATE: Earning-ready copywriter with 3-piece portfolio
```

---

### 12. 🏆 Opportunity Marketplace

**Purpose:** Match users with relevant jobs, internships, freelance gigs, hackathons, grants, scholarships, startup programs, and competitions aligned with their skills, goals, and interests.

The Opportunity Marketplace is PathPilot's connection to the real world. It surfaces opportunities the user would never have found on their own, filtered specifically for their current skills and stage.

**Opportunity types:**

| Type | Examples |
|---|---|
| **Jobs** | Entry-level, remote-first, skill-matched roles |
| **Internships** | Paid and unpaid, local and remote |
| **Freelance gigs** | Short-term projects matching current skills |
| **Hackathons** | Local, national, and online competitions |
| **Grants** | Startup grants, innovation funds, youth programs |
| **Scholarships** | Merit-based, need-based, skill-based awards |
| **Startup programs** | Incubators, accelerators, fellowship programs |
| **Competitions** | Business plan, design, coding, and content contests |
| **Open-source projects** | GitHub repos seeking contributors at beginner level |

**Matching logic:**
Every opportunity is scored against the user's:
- Current skill level and skill gaps
- Path preference (employment, freelance, founding)
- Location and remote preference
- Time availability
- Financial urgency level

High-match opportunities surface at the top. The AI explains why each opportunity is a match and what the user needs to do to qualify.

---

## 📱 App Screens & Navigation

### Bottom Navigation

```
[ Home ]  [ Explore ]  [ Progress ]  [ Challenges ]  [ Profile ]
```

### Screen Map

| Screen | Purpose | Key Components |
|---|---|---|
| **Home Dashboard** | Central hub — current focus, progress, next action | Progress ring, quick actions, module cards, weekly mission, recent proof |
| **Onboarding** | Learn about the user — interests, skills, goals, situation | Multi-step conversational form with AI-powered follow-ups |
| **Direction Finder** | Deep interview to find path | Chat-style step interview, results report, saved paths |
| **Earn Money** | Income paths and earning roadmap | Earning tiers, step-by-step roadmap, free tools, first client guide |
| **AI Tools Vault** | Curated AI tool discovery | Categories, search, filters, personalised tool cards, favourites |
| **Idea Booster** | Idea submission and improvement | Idea input, analysis report, improved version, MVP, launch roadmap |
| **Resources Hub** | Structured learning paths | Topic pages, resource cards, beginner/intermediate/advanced tabs |
| **Progress Tracker** | Visual growth tracking | Roadmap progress, task list, proof tasks, streaks, scores |
| **Proof Submission** | Evidence upload for task completion | File upload, URL input, screenshot capture, verification status |
| **Weekly Review** | AI-powered weekly check-in | 7-question interview, roadmap auto-adjustment, next focus |
| **Challenges** | Daily, weekly, and monthly missions | Challenge cards, timer, leaderboard, streak tracker |
| **Community** | Peer groups and collaboration | Group feed, discussion threads, accountability partner match |
| **Skill Builder** | Personalized skill-learning journeys | Skill path viewer, stage progress, project submission |
| **Opportunity Marketplace** | Matched jobs, grants, gigs, hackathons | Opportunity cards, match score, apply button |
| **Profile** | User settings, saved history, portfolio | Summary, saved paths, saved ideas, proof gallery, achievements |

### Home Dashboard Structure

```
┌─────────────────────────────────────────────┐
│  Good morning, [Name] 👋                    │
│  Focus this week: First Fiverr client       │
├─────────────────────────────────────────────┤
│  Progress Ring ████████░░  78%              │
│  Next task: Upload portfolio samples        │
├─────────────────────────────────────────────┤
│  QUICK ACTIONS                              │
│  [Find Path] [Earn] [AI Tools] [My Idea]    │
├─────────────────────────────────────────────┤
│  WEEKLY MISSION                             │
│  Send your first cold pitch this week 🔥   │
├─────────────────────────────────────────────┤
│  MODULE CARDS                               │
│  Direction · Earn · Ideas · Resources       │
├─────────────────────────────────────────────┤
│  RECENT PROOF                               │
│  ✅ Fiverr profile — Approved               │
│  ⏳ First client pitch — Pending            │
└─────────────────────────────────────────────┘
```

---

## 🤖 AI Behavior & Output Format

Every AI response from PathPilot follows a structured output format designed to be actionable, not just informational.

### Standard Output Structure

```
1. WHAT I UNDERSTOOD FROM YOU
   [Summary of what the user shared, reflecting it back]

2. WHAT IS STRONG
   [Genuine strengths in the user's situation, skills, or idea]

3. WHAT IS WEAK OR UNCLEAR
   [Honest but kind assessment — no sugarcoating, no cruelty]

4. BETTER DIRECTION
   [Where to focus instead, or how to improve what exists]

5. ROADMAP
   [Step-by-step path with time estimates]

6. FREE TOOLS & RESOURCES
   [Specific tools and links, not generic suggestions]

7. WHAT TO DO TODAY
   [One single action the user can take in the next 2 hours]

8. HOW TO PROVE PROGRESS
   [Specific proof the system will accept for each step]
```

### AI Tone Guidelines

| Situation | AI Tone |
|---|---|
| User shares a weak idea | Appreciative of the attempt, honest about the gap, constructive about improvement |
| User hasn't completed tasks | Curious (not accusatory), helps identify the real blocker |
| User is discouraged | Acknowledges the feeling, then grounds them in what has actually moved |
| User achieves a milestone | Specific and genuine celebration — not generic "Great job!" |
| User asks for blunt feedback | Switches to direct mode, clearly flags it's at their request |

---

## 🏗️ Architecture

PathPilot is built as a native Android application scaffolded from Google AI Studio's Android template.

```
┌─────────────────────────────────────────────────────────┐
│               Android App (Kotlin)                       │
│                                                         │
│  app/ — Main application module                         │
│  ├── UI Layer (Jetpack Compose screens)                 │
│  ├── ViewModel Layer (state management)                 │
│  ├── Repository Layer (data access)                     │
│  └── Module Layer (12 feature modules)                  │
└──────────────────┬──────────────────────────────────────┘
                   │ HTTPS / Gemini Android SDK
                   ▼
┌─────────────────────────────────────────────────────────┐
│           Google Gemini API (AI Studio)                  │
│                                                         │
│  Model: Gemini 2.0 Flash (primary)                      │
│  Input: Text + Images (multi-modal)                     │
│  Output: Structured JSON + natural language             │
│                                                         │
│  View app: ai.studio/apps/166603db-c6d6-45cf-8d58-...  │
└─────────────────────────────────────────────────────────┘
                   │
                   ▼
┌─────────────────────────────────────────────────────────┐
│           Local Data Layer                              │
│                                                         │
│  Room Database — user profile, roadmaps, tasks, proof   │
│  SharedPreferences — settings, language, theme          │
│  File storage — uploaded proof images and documents     │
└─────────────────────────────────────────────────────────┘
```

### Key Architecture Decisions

**Gemini as the AI backbone:** Google Gemini 2.0 Flash provides vision capability (for proof image verification), structured JSON output (for roadmap generation), and long-context conversation memory — all at low latency with a generous free tier.

**Kotlin-first, Jetpack Compose UI:** Modern Android development stack. Compose's declarative UI makes the mobile-first card-based dashboard design natural to implement and maintain.

**Local-first data:** All user data (profile, roadmaps, tasks, proof) is stored locally via Room. The app functions fully offline for all core features. Gemini API calls require connectivity but the app degrades gracefully.

**AI Studio scaffold:** The project was scaffolded from `google-gemini/aistudio-repository-template`, providing the Gemini SDK integration, Gradle configuration, and Android Studio project structure out of the box.

---

## ⚡ Tech Stack

| Layer | Technology | Purpose |
|---|---|---|
| **Language** | Kotlin 100% | Primary development language |
| **UI Framework** | Jetpack Compose | Declarative, modern Android UI |
| **AI Integration** | Google Gemini API (via AI Studio) | All AI features — conversation, analysis, generation |
| **Build System** | Gradle with Kotlin DSL (`build.gradle.kts`) | Dependency management, build configuration |
| **Local Database** | Room (SQLite) | User profiles, roadmaps, tasks, proof records |
| **State Management** | ViewModel + StateFlow | Reactive UI state across screens |
| **Navigation** | Jetpack Navigation Compose | Screen routing and back stack management |
| **Async** | Kotlin Coroutines + Flow | Non-blocking API calls and data streams |
| **Image Loading** | Coil | Efficient image loading and caching |
| **Charts** | MPAndroidChart / Vico | Progress rings, heatmaps, line charts |
| **PDF Generation** | PdfDocument API | Printable progress reports |
| **File Storage** | Android FileProvider | Proof image storage and sharing |
| **Security** | Android Keystore | API key storage |

---

## 📂 Project Structure

```
PathPilot/
│
├── app/                                    # Main Android application module
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/pathpilot/
│   │   │   │   ├── MainActivity.kt         # Entry point
│   │   │   │   ├── PathPilotApp.kt         # Application class
│   │   │   │   │
│   │   │   │   ├── ui/                     # Jetpack Compose screens
│   │   │   │   │   ├── home/               # Home dashboard
│   │   │   │   │   ├── onboarding/         # User discovery flow
│   │   │   │   │   ├── direction/          # Direction Finder
│   │   │   │   │   ├── earn/               # Earn Money Engine
│   │   │   │   │   ├── idea/               # Idea Booster
│   │   │   │   │   ├── tools/              # AI Tools Vault
│   │   │   │   │   ├── resources/          # Resources Hub
│   │   │   │   │   ├── progress/           # Progress Tracker
│   │   │   │   │   ├── proof/              # Proof Verification
│   │   │   │   │   ├── review/             # Weekly Review
│   │   │   │   │   ├── challenges/         # Challenges & Missions
│   │   │   │   │   ├── community/          # Community & Peer Groups
│   │   │   │   │   ├── skills/             # Skill Builder Academy
│   │   │   │   │   ├── opportunities/      # Opportunity Marketplace
│   │   │   │   │   ├── profile/            # User profile
│   │   │   │   │   └── theme/              # Design system, colors, typography
│   │   │   │   │
│   │   │   │   ├── viewmodel/              # ViewModels per module
│   │   │   │   ├── repository/             # Data access layer
│   │   │   │   ├── data/                   # Room entities + DAOs + database
│   │   │   │   ├── ai/                     # Gemini integration layer
│   │   │   │   │   ├── GeminiClient.kt     # API client initialization
│   │   │   │   │   ├── PromptBuilder.kt    # Module-specific prompt templates
│   │   │   │   │   └── ResponseParser.kt   # Structured output parsing
│   │   │   │   ├── model/                  # Domain models
│   │   │   │   └── util/                   # Helpers, extensions, constants
│   │   │   │
│   │   │   ├── res/                        # Android resources
│   │   │   └── AndroidManifest.xml
│   │   │
│   │   └── test/                           # Unit + integration tests
│   │
│   └── build.gradle.kts                    # App-level build config
│
├── assets/
│   └── .aistudio/                          # AI Studio project config
│
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
│
├── .env.example                            # Environment variable template
├── .gitignore
├── build.gradle.kts                        # Root build file
├── gradle.properties                       # Gradle settings
├── settings.gradle.kts                     # Module settings
├── metadata.json                           # AI Studio app metadata
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

| Requirement | Version | Notes |
|---|---|---|
| Android Studio | Ladybug (2024.2.1+) | Latest stable recommended |
| Android SDK | API 26+ (Android 8.0+) | Minimum supported version |
| JDK | 17+ | Bundled with Android Studio |
| Google Account | — | Required for Gemini API key |
| Android Device / Emulator | API 26+ | Physical device recommended |

### Step 1 — Clone the Repository

```bash
git clone https://github.com/ibtesaamaslam/PathPilot.git
cd PathPilot
```

### Step 2 — Open in Android Studio

1. Open **Android Studio**
2. Select **File → Open**
3. Choose the `PathPilot/` directory
4. Wait for Gradle sync to complete
5. Allow Android Studio to resolve any compatibility issues automatically

### Step 3 — Configure Environment Variables

```bash
# Create a .env file in the root project directory
cp .env.example .env
```

Open `.env` and add your Gemini API key:

```env
GEMINI_API_KEY=your_api_key_here
```

See [Environment Setup](#-environment-setup) for how to obtain a Gemini API key.

### Step 4 — Fix Signing Configuration (For Debug Builds)

Before running, remove the debug signing config line from `app/build.gradle.kts`:

Find and remove this line:
```kotlin
signingConfig = signingConfigs.getByName("debugConfig")
```

This line is included by AI Studio for their deployment but causes issues for local builds.

### Step 5 — Run the App

1. Connect a physical Android device via USB (or start an emulator)
2. Ensure **USB Debugging** is enabled on your device
3. Select your device in the Android Studio device toolbar
4. Click **Run ▶** or press `Shift + F10`

The app will build and install. The first run initialises the local Room database and prompts for onboarding.

---

## 🔑 Environment Setup

### Getting a Gemini API Key

1. Go to [Google AI Studio](https://ai.studio)
2. Sign in with your Google account
3. Click **Get API Key** in the top navigation
4. Select **Create API Key in new project** or choose an existing project
5. Copy the generated API key
6. Add it to your `.env` file as `GEMINI_API_KEY=your_key_here`

**Free tier limits:**
- Gemini 2.0 Flash: 15 requests/minute, 1,500 requests/day on the free tier
- This is more than sufficient for development and personal use

### Environment Variable Reference

```env
# Required
GEMINI_API_KEY=your_google_ai_studio_api_key

# Optional (for future backend sync features)
PATHPILOT_API_URL=https://api.pathpilot.app
PATHPILOT_API_KEY=your_backend_api_key
```

### Security Note

The `.env` file is in `.gitignore` and must **never be committed** to the repository. The API key is loaded at runtime via the Gradle build configuration and injected as a `BuildConfig` field.

---

## 📊 Feature Priority

### P0 — Must Have (MVP)

| Feature | Module | Status |
|---|---|---|
| Onboarding / Discovery Flow | All | 🔄 In Progress |
| Home Dashboard | Home | 🔄 In Progress |
| Direction Finder | Direction | 🔄 In Progress |
| Earn Money Engine | Earn | 🔄 In Progress |
| Idea Booster | Startup Lab | 🔄 In Progress |
| AI Tools Vault | Tools | 🔄 In Progress |
| Resources Hub | Resources | 🔄 In Progress |
| Progress Tracking | Progress | 🔄 In Progress |
| Proof Submission | Proof | 🔄 In Progress |
| Weekly Review | Review | 🔄 In Progress |
| Gemini AI Integration | Core | 🔄 In Progress |

### P1 — Should Have

- Saved paths and saved ideas
- AI conversation memory across sessions
- Search and filtering (Tools Vault, Resources Hub)
- Progress scores and consistency rating
- Push notification reminders
- Daily and weekly streaks
- Challenge system

### P2 — Nice to Have

- Community and peer groups
- Skill Builder Academy
- Opportunity Marketplace
- Badges and leaderboards
- Collaboration rooms
- Mentor marketplace

---

## 📏 Success Metrics

PathPilot tracks outcomes, not vanity metrics.

| Metric | Target (MVP) | Why It Matters |
|---|---|---|
| **Onboarding completion rate** | > 70% | Indicates perceived value from first session |
| **Module usage rate** | > 3 modules per user per week | Indicates depth of engagement |
| **Proof submission rate** | > 50% of completed tasks | Indicates real accountability |
| **Task completion rate** | > 40% | Indicates roadmap quality and achievability |
| **Weekly return rate** | > 60% | Indicates genuine utility, not one-time curiosity |
| **First earning milestone** | > 20% of Earn module users | Indicates the earning paths actually work |
| **Idea-to-MVP conversion** | > 15% | Indicates the Idea Booster drives real action |
| **Resource click-through rate** | > 60% | Indicates resource quality and relevance |
| **User satisfaction (1–10)** | > 8 | Indicates the emotional promise is being delivered |

---

## 🗃️ Data Models

### User Profile

```kotlin
data class UserProfile(
    val id: String,
    val name: String,
    val interests: List<String>,
    val skills: List<String>,
    val goals: List<String>,
    val availableDevices: List<String>,
    val dailyHoursAvailable: Int,
    val earningUrgency: EarningUrgency,   // immediate, building, exploratory
    val preferredWorkStyle: WorkStyle,     // independent, collaborative, mixed
    val languages: List<String>,
    val currentSituation: String,
    val createdAt: Long,
    val updatedAt: Long
)
```

### Roadmap

```kotlin
data class Roadmap(
    val id: String,
    val userId: String,
    val title: String,
    val category: RoadmapCategory,
    val steps: List<RoadmapStep>,
    val timelineWeeks: Int,
    val resources: List<Resource>,
    val progressPercentage: Float,
    val status: RoadmapStatus,            // active, paused, completed, abandoned
    val createdAt: Long
)
```

### Idea

```kotlin
data class Idea(
    val id: String,
    val userId: String,
    val rawIdea: String,
    val improvedIdea: String,
    val problemStatement: String,
    val targetAudience: String,
    val mvpDescription: String,
    val monetizationIdeas: List<String>,
    val risks: List<String>,
    val launchRoadmap: Roadmap,
    val recommendedTools: List<Tool>,
    val savedAt: Long
)
```

### Task with Proof

```kotlin
data class Task(
    val id: String,
    val roadmapId: String,
    val title: String,
    val description: String,
    val dueDate: Long,
    val proofRequired: Boolean,
    val proofType: ProofType,             // screenshot, url, document, video
    val proofSubmission: ProofSubmission?,
    val verificationStatus: VerificationStatus,
    val completedAt: Long?
)
```

### Resource

```kotlin
data class Resource(
    val id: String,
    val title: String,
    val type: ResourceType,               // video, course, repo, doc, community
    val category: String,
    val url: String,
    val difficultyLevel: DifficultyLevel, // beginner, intermediate, advanced
    val isFree: Boolean,
    val tags: List<String>
)
```

### Tool

```kotlin
data class Tool(
    val id: String,
    val name: String,
    val category: ToolCategory,
    val description: String,
    val freeTierDetails: String,
    val bestUseCase: String,
    val limitations: String,
    val alternatives: List<String>,
    val websiteUrl: String,
    val isFavorited: Boolean
)
```

---

## 📖 User Stories

### Story 1 — The Lost Student

> As a student who feels lost about their future, I want the app to ask me meaningful questions about who I am and what I want, so I can see a clear path forward instead of just generic career advice.

**Acceptance criteria:** Direction Finder completes a 10-question interview and returns a personalised path report with 3 recommended directions and specific next steps.

### Story 2 — The Graduate Without Income

> As a recent graduate who can't find a job, I want the app to show me realistic ways to earn using the skills I already have, so I can start moving forward financially while I continue searching.

**Acceptance criteria:** Earn Money Engine generates a personalised income roadmap with at least 3 earning paths, a beginner roadmap for each, and free tools to start immediately.

### Story 3 — The Idea Owner

> As someone with a startup idea I'm afraid to share because it might be stupid, I want the app to help me improve my idea without making me feel embarrassed, so I can figure out if it's worth pursuing.

**Acceptance criteria:** Idea Booster accepts any idea, identifies the useful signal, returns an improved version with a simplified MVP, and never uses dismissive language.

### Story 4 — The AI Curious Learner

> As someone excited about AI tools but overwhelmed by how many exist, I want the app to show me the best free tools for my specific use case, so I can stop wasting time searching and start building.

**Acceptance criteria:** AI Tools Vault surfaces the 5–10 most relevant tools for the user's profile with free tier details and beginner guides.

### Story 5 — The Person Who Can't Stay Accountable

> As someone who sets goals but never follows through, I want the app to require actual proof before marking tasks complete, so I stay honest about my real progress.

**Acceptance criteria:** Proof Verification System requires and validates evidence (screenshot, URL, or document) for all significant tasks before marking them complete.

### Story 6 — The Skill-Rich, Income-Poor Person

> As someone who has a skill (writing, design, video editing) but doesn't know how to charge for it, I want the app to show me how to monetize it step by step, so I can earn my first money within 30 days.

**Acceptance criteria:** Earn Money Engine generates a path-specific monetization roadmap with first client strategy, pricing guidance, and a 30-day action plan with proof checkpoints.

---

## 🗺️ Roadmap

### MVP v1.0 (Current Development)

- [ ] Onboarding / Discovery Flow
- [ ] Home Dashboard with progress ring and quick actions
- [ ] Direction Finder — 10-question AI interview with personalised report
- [ ] Earn Money Engine — skills-to-income roadmap generator
- [ ] Idea Booster — idea analysis and improvement
- [ ] AI Tools Vault — curated tool discovery
- [ ] Resources Hub — structured learning paths
- [ ] Progress Tracker — task and roadmap tracking
- [ ] Proof Verification System — evidence-based completion
- [ ] Weekly Accountability Review — AI check-in and roadmap adjustment
- [ ] Gemini AI integration for all modules

### v1.1 — Engagement Layer

- [ ] Challenge system — daily, weekly, monthly missions
- [ ] Streak tracking and XP system
- [ ] Saved paths and saved ideas
- [ ] Push notification reminders for tasks and weekly reviews
- [ ] AI conversation memory across sessions

### v1.2 — Learning & Growth

- [ ] Skill Builder Academy — personalized learning journeys with projects
- [ ] Opportunity Marketplace — matched jobs, hackathons, grants
- [ ] Portfolio page — collected proof items as public portfolio
- [ ] Certification tracking

### v2.0 — Community Layer

- [ ] Peer groups and accountability partners
- [ ] Community discussions
- [ ] Collaboration rooms
- [ ] Mentor marketplace
- [ ] Leaderboards and badges

---

## 🤝 Contributing

PathPilot is currently in active MVP development. Contributions are welcome for:

- UI/UX improvements
- AI prompt engineering for better module outputs
- New AI tool entries for the Vault
- New resource curation for the Hub
- Bug fixes and performance improvements
- Translations and localisation

### Development Setup

```bash
git clone https://github.com/ibtesaamaslam/PathPilot.git
cd PathPilot
# Open in Android Studio
# Create .env with your GEMINI_API_KEY
# Run on emulator or device
```

### Contribution Guidelines

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Make your changes
4. Run tests: `./gradlew test`
5. Submit a pull request with a clear description of what changed and why

---

## 📄 License

```
MIT License

Copyright (c) 2026 Ibtesaam Aslam — PathPilot

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```

---

<div align="center">

**Built by [Ibtesaam Aslam](https://github.com/ibtesaamaslam)**

*Powered by Google Gemini AI · Built with Kotlin · Designed for the ones who feel lost*

⭐ If PathPilot helped you find direction, give it a star!

**Status:** MVP Development &nbsp;|&nbsp; **Version:** 1.0.0-MVP &nbsp;|&nbsp; **Last Updated:** June 2026

</div>
