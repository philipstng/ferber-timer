Google Play Search Optimization & Launch Checklist

Execute these tasks before and immediately after uploading your Android App Bundle (.aab) to maximize Google Play search algorithm visibility.

Phase 1: Pre-Launch Technical & Package Setup

[ ] Package ID Check: Confirm applicationId = "com.ferbersleeptimer.babytracker" in app/build.gradle.kts and appId in capacitor.config.json.

[ ] Capacitor Sync: Run npx cap sync android to ensure native files inherit the updated package ID and display name.

[ ] In-App Review Integration: Ensure the native Play Store review plugin/API triggers after successful sleep sessions to build ratings early.

[ ] Android Vitals Audit: Test performance locally to confirm zero Application Not Responding (ANR) issues or main thread blockage.

Phase 2: Google Play Console Metadata Setup

[ ] Main Store Listing Copy: Copy the finalized Title, Short Description, and Full Description from ASO_COPY_AND_KEYWORDS.md.

[ ] Category Selection: Set primary category to Parenting (or Health & Fitness as secondary fit).

[ ] Tags: Apply the 5 identified tags (Baby Tracker, Parenting, Infant Care, Sleep Tracker, Habit Tracker).

[ ] Visual Assets Optimization:

Icon: Clean icon featuring a simple crib/moon/timer design (avoid small text inside the icon).

Screenshots: Upload 1080p vertical screenshots with bold top-captions (e.g., "Preset Ferber Intervals", "One-Tap Bedtime Timer").

Feature Graphic (1024x500): High-contrast branding banner without promotional claims (Google rejects graphics with words like "#1" or "Free").

Phase 3: Post-Launch Rank Velocity

[ ] Initial Conversion Push: Drive 25–50 installs in the first 48 hours from friends, family, or targeted parenting communities (e.g., Reddit /r/sleeptrain).

[ ] Review Velocity: Encourage early adopters to leave qualitative reviews containing keywords like "great Ferber timer" or "easy sleep training".

[ ] Vitals Monitoring: Monitor Google Play Console > Android Vitals. Keep crash rate below 1.09% and ANR rate below 0.47% to avoid algorithmic demotion.
