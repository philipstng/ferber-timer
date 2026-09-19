# Ferber Baby Sleep Timer & Tracker

[![Android Build](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Capacitor Framework](https://img.shields.io/badge/Framework-Capacitor-blue.svg)](https://capacitorjs.com)
[![Google Play ASO Optimized](https://img.shields.io/badge/ASO-Optimized-brightgreen.svg)](docs/ASO_COPY_AND_KEYWORDS.md)

A simple, intuitive Ferber Method sleep training timer designed to help parents manage interval check-ins during bedtime and naptime routines. Built with Capacitor and Android Native tools for high stability and minimal resource footprint.

---

## 📱 Features

- **Automated Ferber Intervals:** Pre-configured schedules following Dr. Richard Ferber’s gradual extinction method (Day 1 through Day 7+).
- **One-Tap Controls:** Quick start, pause, and check-in adjustments optimized for low-light bedtime environments.
- **Customizable Intervals:** Easily tweak check-in timers to match your pediatrician's advice.
- **In-App Review Integration:** Smooth feedback flow using Google Play's native In-App Review API.

---

## 🛠 Project Structure

```text
.
├── app/                        # Android native app module
│   └── build.gradle.kts        # Module build configuration (ASO applicationId configured)
├── docs/                       # Store optimization and deployment docs
│   ├── ASO_COPY_AND_KEYWORDS.md# App Store Optimization metadata & keywords
│   └── ASO_RELEASE_CHECKLIST.md# Pre-launch and release checklist
├── capacitor.config.json       # Capacitor configuration
├── settings.gradle.kts         # Gradle project repositories & settings
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- [Node.js](https://nodejs.org/) (v18+)
- [Android Studio](https://developer.android.com/studio) (Ladybug or newer)
- Gradle 8.x+

### Local Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/ferber-sleep-timer.git
   cd ferber-sleep-timer
   ```

2. **Install web dependencies:**
   ```bash
   npm install
   ```

3. **Build web assets & sync with Capacitor:**
   ```bash
   npm run build
   npx cap sync android
   ```

4. **Open in Android Studio:**
   ```bash
   npx cap open android
   ```

---

## 📈 App Store Optimization (ASO)

All store listing metadata, copy variations, and keyword densities for Google Play Console can be found in **[`docs/ASO_COPY_AND_KEYWORDS.md`](docs/ASO_COPY_AND_KEYWORDS.md)**.

Before making a store submission or building a release bundle (`.aab`), follow the deployment steps in **[`docs/ASO_RELEASE_CHECKLIST.md`](docs/ASO_RELEASE_CHECKLIST.md)**.

---

## 📄 License

This project is licensed under the MIT License - see the `LICENSE` file for details.