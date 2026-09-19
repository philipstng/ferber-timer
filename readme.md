# Ferber Baby Sleep Timer & Tracker

[![Android Build](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Capacitor Framework](https://img.shields.io/badge/Framework-Capacitor-blue.svg)](https://capacitorjs.com)
[![Codemagic CI/CD](https://img.shields.io/badge/Build-Codemagic-orange.svg)](https://codemagic.io)
[![Google Play ASO Optimized](https://img.shields.io/badge/ASO-Optimized-brightgreen.svg)](ASO_COPY_AND_KEYWORDS.md)

A simple, intuitive Ferber Method sleep training timer designed to help parents manage interval check-ins during bedtime and naptime routines. Built with Capacitor and automated Codemagic CI/CD workflows for high stability and minimal resource footprint.

---

## 📱 Features

- **Automated Ferber Intervals:** Pre-configured schedules following Dr. Richard Ferber’s gradual extinction method (Day 1 through Day 7+).
- **One-Tap Controls:** Quick start, pause, and reset controls optimized for low-light bedtime environments.
- **Web Audio API Alerts:** Plays a gentle 3-second alarm tone upon timer completion without requiring external audio files.
- **Mute Toggle:** Instant speaker icon toggle for silent, visual-only notifications.
- **Mobile Responsive Design:** Sized specifically for portrait view on mobile phones with zero scrolling required.

---

## 🛠 Project Structure

```text
.
├── public/
│   └── index.html              # Main HTML5, CSS, and JS app code
├── capacitor.config.json       # Capacitor configuration (com.ferbersleeptimer.babytracker)
├── codemagic.yaml              # Codemagic CI/CD workflow configuration
├── package.json                # Project dependencies and Capacitor scripts
├── ASO_COPY_AND_KEYWORDS.md    # App Store Optimization metadata & keywords
├── ASO_RELEASE_CHECKLIST.md    # Pre-launch and release checklist
└── README.md
