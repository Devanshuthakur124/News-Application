<h1 align="center">
  📰 News Application
</h1>

<p align="center">
  <b>A clean and minimal Android news app that delivers real-time top headlines from India using the NewsAPI.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Min%20SDK-24-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Target%20SDK-34-green?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Version-1.0-purple?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge"/>
</p>

---

## 📖 About

**News Application** is an Android app built in **Java** that fetches and displays the latest top headlines from India using the [NewsAPI](https://newsapi.org/). It presents news articles in a clean scrollable list with article images, titles, descriptions, and authors. Tapping on any article opens the full story in a built-in WebView browser.

---

## ✨ Features

- 🗞️ **Real-Time Headlines** — Fetches top news articles for India from NewsAPI on launch
- 🖼️ **Article Images** — Loads article thumbnails directly from the network
- 📋 **Rich Article Cards** — Shows title, description, author, and published date per article
- 🌐 **Built-in Web Browser** — Opens full articles in a WebView without leaving the app
- ⚡ **Fast Networking** — Uses Fast Android Networking Library for optimized API calls
- 🔄 **Progress Indicator** — Displays a ProgressBar while news is loading
- 📱 **Clean RecyclerView UI** — Smooth, scrollable list of articles

---

## 📸 Screenshots

> _Coming soon — build and run the app to see it in action!_

---

## 🏗️ Project Structure

```
NewsApplication2/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/newsapplication/
│           │   ├── MainActivity.java              # Entry point, fetches & displays news
│           │   ├── WebActivity.java               # Renders full article in WebView
│           │   ├── ArticleAdapter.java            # RecyclerView adapter for news cards
│           │   ├── NewsArticle.java               # Data model for a news article
│           │   └── JSONObjectRequestListener.java # Network response listener
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml          # Main screen layout (RecyclerView)
│           │   │   ├── activity_web.xml           # WebView layout
│           │   │   └── article_item.xml           # Individual news card layout
│           │   └── values/
│           │       ├── strings.xml
│           │       ├── colors.xml
│           │       └── themes.xml
│           └── AndroidManifest.xml
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java** | Primary programming language |
| **Android SDK 34** | Target platform |
| **Fast Android Networking** | HTTP networking & image loading |
| **Jackson Android Networking** | JSON parsing via Jackson |
| **RecyclerView** | Efficient scrollable news list |
| **WebView** | In-app article browser |
| **NewsAPI** | Source of live news data |
| **Volley** | HTTP request support |
| **ConstraintLayout** | Responsive UI layouts |

---

## ⚙️ Getting Started

### Prerequisites

- Android Studio **Hedgehog** or later
- JDK 8+
- An active internet connection
- A free [NewsAPI](https://newsapi.org/register) API key

### 1. Clone the Repository

```bash
git clone https://github.com/Devanshuthakur124/News-Application.git
cd News-Application
```

### 2. Add Your API Key

Open `MainActivity.java` and replace the placeholder with your own API key:

```java
// TODO: Replace with your own NewsAPI key
private static String API_KEY = "YOUR_API_KEY_HERE";
```

> ⚠️ **Never commit your real API key to a public repository.** Consider using `local.properties` or environment variables for production apps.

### 3. Build & Run

1. Open the project in **Android Studio**
2. Let Gradle sync complete
3. Connect an Android device or start an emulator (API 24+)
4. Click ▶️ **Run**

---

## 📡 API Reference

This app uses the **NewsAPI** `top-headlines` endpoint:

```
GET https://newsapi.org/v2/top-headlines?country=in&apiKey=YOUR_API_KEY
```

**Response fields used:**

| Field | Description |
|---|---|
| `author` | Name of the article author |
| `title` | Headline of the article |
| `description` | Short summary of the article |
| `url` | Full URL to the original article |
| `urlToImage` | URL of the article thumbnail image |
| `publishedAt` | ISO 8601 publication timestamp |
| `content` | Article body preview |

---

## 📦 Dependencies

```kotlin
// Fast Android Networking
implementation("com.amitshekhar.android:android-networking:1.0.2")
implementation("com.amitshekhar.android:jackson-android-networking:1.0.2")

// Volley
implementation("com.android.volley:volley:1.2.1")

// AndroidX
implementation("androidx.appcompat:appcompat:1.7.1")
implementation("com.google.android.material:material:1.13.0")
implementation("androidx.constraintlayout:constraintlayout:2.2.1")
```

---

## 🔐 Permissions

The app requires the following permissions declared in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

---

## 🔄 How It Works

```
App Launch
    │
    ▼
MainActivity.onCreate()
    │
    ├── Initialize AndroidNetworking
    ├── Setup RecyclerView + ProgressBar
    │
    ▼
get_news_from_api()
    │
    ├── GET https://newsapi.org/v2/top-headlines?country=in
    │
    ├── onResponse()  ──► Parse JSON ──► Populate NewsArticle list
    │                                        │
    │                                        ▼
    │                               ArticleAdapter → RecyclerView
    │
    └── onError()     ──► Log error to Logcat
    
Article Click
    │
    ▼
WebActivity (loads article URL in WebView)
```

---

## 🤝 Contributing

Contributions are welcome! Here's how:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/your-feature-name`
3. **Commit** your changes: `git commit -m "Add: your feature description"`
4. **Push** to the branch: `git push origin feature/your-feature-name`
5. **Open** a Pull Request

---

## 🐛 Known Issues / TODO

- [ ] Secure API key storage (use `BuildConfig` or secrets plugin)
- [ ] Add error UI when network request fails
- [ ] Add pull-to-refresh functionality
- [ ] Support category-based news filtering
- [ ] Add search functionality
- [ ] Support Dark Mode

---

## 👨‍💻 Author

**Devanshu Thakur**

[![GitHub](https://img.shields.io/badge/GitHub-Devanshuthakur124-181717?style=for-the-badge&logo=github)](https://github.com/Devanshuthakur124)

---

## 📄 License

```
MIT License

Copyright (c) 2026 Devanshu Thakur

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/Devanshuthakur124">Devanshu Thakur</a>
</p>
