# 🌟 Spread Hope Foundation

> A community-driven Android application for the **Spread Hope Foundation** — connecting donors, volunteers, and communities to create meaningful social impact across Pakistan.

![Platform](https://img.shields.io/badge/Platform-Android-green?style=flat-square&logo=android)
![Language](https://img.shields.io/badge/Language-Kotlin-purple?style=flat-square&logo=kotlin)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-blue?style=flat-square)
![Firebase](https://img.shields.io/badge/Backend-Firebase-orange?style=flat-square&logo=firebase)
![License](https://img.shields.io/badge/License-MIT-red?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)

---

## 📖 About The Project

The **Spread Hope Foundation** app is the official mobile platform of a non-profit organization dedicated to uplifting communities through education, health, and social welfare. The app brings together donors, volunteers, and the public under one roof — making it easy to contribute, stay informed, and get involved.

From its early beginnings as a small initiative, Spread Hope Foundation has grown into a trusted organization driven by the belief that **collective effort can transform lives**. This app is the digital bridge between that mission and the people who believe in it.

### 🎯 Purpose

The app serves three core user needs:
- **Donors** — Easily discover and contribute to ongoing campaigns
- **Volunteers** — Get involved, stay updated on activities, and track participation
- **Community** — Stay connected with the foundation's latest projects and impact

---

## 📱 App Overview

When you open the app, you're greeted with a beautifully designed **Home Screen** that immediately communicates the foundation's mission:

- A **hero banner** with a real community photo and the message *"Together We Can Make a Difference"*
- An **inspirational quote card** — *"The best way to find yourself is to lose yourself in the service of others."* — Mahatma Gandhi
- **Quick-action cards** for Donate Now, Our Mission, Latest Activities, and Get Involved
- A live **Impact Counter** showing: `10,000+ Lives Touched`, `500+ Volunteers`, `50+ Projects`
- A rich **About Our History** section telling the foundation's journey

---

## ✨ Features

### 🏠 Home
- Foundation branding header with logo and tagline
- Full-width hero image card with overlay text
- Motivational quote card with gold star icon
- 2×2 grid of feature cards (Donate, Mission, Media, Volunteer)
- Impact statistics section (lives touched, volunteers, projects)
- Foundation history and about section

### 💳 Donate
- Browse active donation campaigns
- Donate to specific causes (food drives, education, health)
- View donation history via bottom sheet
- Track personal contribution records

### 📸 Media
- Gallery of latest foundation activities
- Photo and video content from field projects
- Community event highlights

### 👤 Profile
- User profile management
- Edit profile dialog with photo support
- View donation history
- Zoom-able profile image

### 🔐 Authentication
- Firebase Email/Password login
- New user signup with profile creation
- Branded splash screen on launch
- Session persistence across app restarts

### 🗺️ Navigation
- Smooth bottom navigation bar
- Fragment-based architecture
- Custom tab styling (selected/unselected states)

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | XML Layouts, Material Design, CardView |
| Architecture | MVVM (Model-View-ViewModel) |
| Navigation | Fragment-based with Bottom Navigation |
| Backend | Firebase Firestore |
| Authentication | Firebase Authentication |
| Storage | Firebase Storage |
| Build System | Gradle (Kotlin DSL) |
| IDE | Android Studio |

---

## 🏗️ Architecture (MVVM)

```
SpreadHopeFoundation
│
├── View (UI Layer)
│   ├── SplashScreen.kt          — Branded launch screen
│   ├── LoginActivity.kt         — Firebase auth login
│   ├── SignupActivity.kt        — New user registration
│   ├── MainActivity.kt          — Host with BottomNavigationView
│   ├── HomeFragment.kt          — Dashboard: hero, cards, impact stats
│   ├── DonateFragment.kt        — Donation campaigns and history
│   ├── MediaFragment.kt         — Foundation activities gallery
│   └── ProfileFragment.kt       — User profile and settings
│
└── Resources
    ├── 25+ custom drawables     — Buttons, badges, cards, shapes
    ├── 14 layout files          — Screens + dialogs + bottom sheets
    ├── Custom bottom navigation — Tab selected/unselected states
    └── Firebase integration     — Auth + Firestore + Storage
```

---

## 📁 Repository Structure

```
SpreadHopeFoundation/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/project_spreading_hope/
│   │   │   ├── DonateFragment.kt
│   │   │   ├── HomeFragment.kt
│   │   │   ├── LoginActivity.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── MediaFragment.kt
│   │   │   ├── ProfileFragment.kt
│   │   │   ├── SignupActivity.kt
│   │   │   └── SplashScreen.kt
│   │   ├── res/
│   │   │   ├── color/
│   │   │   │   └── nav_colors.xml
│   │   │   ├── drawable/          (25+ custom XML drawables + images)
│   │   │   ├── layout/            (14 layout XML files)
│   │   │   ├── menu/
│   │   │   │   └── bottom_menu.xml
│   │   │   ├── mipmap/            (all density icons)
│   │   │   └── values/
│   │   │       ├── colors.xml
│   │   │       ├── strings.xml
│   │   │       └── themes.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── google-services.json      ← NOT committed (see .gitignore)
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
├── CONTRIBUTING.md
├── LICENSE
└── README.md
```

---

## 📸 Screenshots

> Screenshots coming soon — the app features a complete, polished UI including home dashboard, donation flow, media gallery, and user profile.

| Splash | Login | Home |
|--------|-------|------|
| ![Splash](screenshots/splash.png) | ![Login](screenshots/login.png) | ![Home](screenshots/home.png) |

| Donate | Media | Profile |
|--------|-------|---------|
| ![Donate](screenshots/donate.png) | ![Media](screenshots/media.png) | ![Profile](screenshots/profile.png) |

> *Add your screenshots in a `/screenshots` folder in the repo root.*

---

## 🚀 Installation & Setup

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 24+
- Firebase project (Authentication + Firestore + Storage enabled)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Alikhoso81/SpreadHopeFoundation.git
   cd SpreadHopeFoundation
   ```

2. **Open in Android Studio**
   - `File > Open` → select the project folder

3. **Configure Firebase**
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project
   - Add Android app: `com.example.project_spreading_hope`
   - Download `google-services.json` → place it in `/app`
   - Enable **Authentication** (Email/Password)
   - Enable **Cloud Firestore**
   - Enable **Firebase Storage** (for profile images)

4. **Sync & Run**
   ```
   File > Sync Project with Gradle Files
   ```
   - Connect device or emulator (API 24+) → press ▶

---

## 🗄️ Firestore Data Model

```
users/
  {uid}/
    name: String
    email: String
    profileImageUrl: String
    joinedAt: Timestamp

donations/
  {donationId}/
    userId: String
    amount: Number
    campaign: String
    timestamp: Timestamp
    status: String

campaigns/
  {campaignId}/
    title: String
    description: String
    targetAmount: Number
    raisedAmount: Number
    imageUrl: String
    active: Boolean
```

---

## 🔮 Future Improvements

- [ ] Push notifications for new campaigns via Firebase Cloud Messaging
- [ ] Online payment gateway integration (JazzCash / EasyPaisa)
- [ ] Volunteer registration and activity tracking
- [ ] Multi-language support (Urdu 🇵🇰)
- [ ] Dark mode support
- [ ] Offline mode with Room database
- [ ] Admin panel for foundation staff
- [ ] Zakat calculator feature
- [ ] Impact map showing project locations across Pakistan
- [ ] UI redesign with Jetpack Compose

---

## 🧪 Testing

```bash
./gradlew test                    # Unit tests
./gradlew connectedAndroidTest    # Instrumented device tests
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit: `git commit -m "feat: your meaningful message"`
4. Push: `git push origin feature/your-feature`
5. Open a Pull Request

See [CONTRIBUTING.md](CONTRIBUTING.md) for full guidelines.

---

## 📄 License

MIT License — see [LICENSE](LICENSE) for details.

---

## 👨‍💻 Author

**Ali Khoso**

[![GitHub](https://img.shields.io/badge/GitHub-Alikhoso81-181717?style=flat-square&logo=github)](https://github.com/Alikhoso81)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-ali--ahmed--khoso-0A66C2?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/ali-ahmed-khoso)
[![Fiverr](https://img.shields.io/badge/Fiverr-Hire%20Me-1DBF73?style=flat-square&logo=fiverr&logoColor=white)](https://www.fiverr.com/s/7YPjRgW)
[![Email](https://img.shields.io/badge/Gmail-aliahmedkhoso17081-EA4335?style=flat-square&logo=gmail&logoColor=white)](mailto:aliahmedkhoso17081@gmail.com)

> AI Developer · UnitZero, Karachi 🇵🇰 · [unitzero.tech](https://www.unitzero.tech/)

---

> *"The best way to find yourself is to lose yourself in the service of others."*
> *— Mahatma Gandhi*
