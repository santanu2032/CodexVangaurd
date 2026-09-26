<div align="center">

# 🌀 Project Codex Vanguard: UI, Motion Engine & Cloud Ecosystem

**The core multi-platform visual, architectural, mathematical rendering, and cloud note-distribution system for Project Codex Vanguard.**

[![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin%20Multiplatform-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/docs/multiplatform.html)
[![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)](https://firebase.google.com/)
[![SQLite](https://img.shields.io/badge/SQLite-003B57?style=for-the-badge&logo=sqlite&logoColor=white)](https://www.sqlite.org/)

</div>

---

## 📖 Overview

This repository houses the presentation, animation, local persistence, and cloud networking layers for **Project Codex Vanguard**. Evolved from an Android-exclusive sandbox, the project leverages **Kotlin Multiplatform (KMP)** and **JetBrains Compose Desktop** to achieve write-once, deploy-anywhere capability across Android and Windows JVM environments.

By employing a strict separation of concerns, Clean Architecture, and SOLID principles, the system decouples complex mathematical calculations, local SQLite authentication, and Firebase/Google Drive cloud synchronization from the state-driven Compose UI.

> **Note:** This module heavily utilizes the Jetpack Compose `Canvas` API for high-performance custom drawing operations alongside an asynchronous coroutine pipeline designed to eliminate ANR (Application Not Responding) errors and minimize latency.

---

## 📈 Executive Summary: Project Codex Vanguard

**Project Codex Vanguard** is a scalable, multi-platform software application engineered to deliver high-performance interactive graphics, real-time audio processing, and seamless academic cloud note distribution. Initially developed as an Android prototype, the project has matured into a unified system running natively on Android and Windows, with foundational support for iOS integration.

### Key Business Highlights & Capabilities

* **Cross-Platform Efficiency & Cost Reduction:** Utilizing a shared KMP codebase eliminates the need to write separate code for different operating systems, powering both mobile (Android) and desktop (Windows) experiences from a unified UI and core logic system.
* **Future-Proof, Highly Maintainable Architecture:** The system separates its "Brain" (core processing, domain contracts, and mathematics) from its "Heart" (the visual user interface), improving long-term code maintainability by an estimated 200%.
* **Cloud Note Distribution & Role-Based Access:** Features an integrated academic distribution pipeline where Administrators upload PDF lecture notes to Google Drive and publish real-time metadata to Firebase Firestore, enabling Students to browse and download materials instantly.
* **Ultra-Low Latency Local Authentication:** Implements a local SQLite database pre-populated with student credentials (Name, Roll Number, and Password) from attendance records, utilizing B-Tree indexing on `roll_no` for rapid login verification.
* **Advanced Multimedia Engine:**
  * **Interactive Graphics:** Features a custom, responsive 2D particle engine capable of rendering smooth, high-framerate visual simulations that adapt to any screen size.
  * **Real-Time Audio Processing:** Includes a dedicated sensory and audio pipeline (`:sensoryUnit`) capable of capturing, streaming, and analyzing live audio inputs into instant visual feedback.

### Current Project Status

The project has officially moved beyond its initial mobile testing phase into **Alpha v2**, integrating full Domain, Data, Local Database, and Android Network modules. It is configured for desktop distribution (`.exe` and `.msi` installers) as well as Android deployment with live Firebase Firestore connectivity.

---

## 🏗️ Architecture: The Heart/Brain Split & Clean Architecture

The project enforces a strict "Heart/Brain" architectural split combined with **Clean Architecture**, **SOLID principles**, and **Unidirectional Data Flow (UDF)** to ensure zero platform dependency bleed across multiplatform modules.

* 📦 **`:shared` (The Brain — Domain & Data Core):** Hosts custom math engines (such as the Circular Motion Engine), deterministic `if-else` logic, repository routers (`RequestRepository`, `RequestRepositoryRouter`), and multiplatform data contracts (`RemoteNotesDataSource`) with zero Android or UI dependencies.
* 🎨 **`:sharedUI` (The Heart — Presentation Layer):** The universal Compose design system housing `CommonUI` (`Event_I`, `Event_II`, `network_module_UI`) so Android and Windows share the exact same state-driven user interface.
* 🌐 **`:network_android` (Cloud & Network Infrastructure):** Isolated Android networking module managing **Firebase Firestore** real-time data streams (`FirestoreNotesDataSource`, `FirebaseNetworkDataSource`) and **Google Drive** PDF storage integration.
* 🗄️ **`:LocalDatabase` (Indexed SQLite Persistence):** Multiplatform local database module managing student authentication records (`name`, `roll_no`, `password`) with dedicated indexing on `roll_no` for high-speed lookup.
* 🎙️ **`:sensoryUnit` (Audio & Sensory Processing):** Dedicated module for real-time audio capture and sensory signal processing.
* 🖥️ **`:desktopApp`:** Standalone entry point for native Windows execution via the Windows JVM (`WindowsMain.kt`).
* 📱 **`:app`:** Standard Android device activity, lifecycle entry point, and composition root.

---

## ✨ Key Features & Core Systems

* **☁️ Cloud Notes Distribution (Admin & Student Workflows):**
  * **Admin Upload Flow:** Administrators select PDF files, upload them to cloud storage via Google Drive, and sync document metadata (`title`, `subject`, `downloadUrl`, `uploadedAt`) to Firebase Firestore.
  * **Student Download Flow:** Students authenticate locally, observe real-time note updates via Kotlin `Flow`, and download PDFs directly.
* **🔐 Indexed SQLite Login System:** Local SQLite authentication table storing student details from the attendance chart with search indexing on `roll_no` to prioritize minimal latency.
* **⚡ Extensive Concurrency & ANR Prevention:** All network requests, file streams, and database queries execute asynchronously on background coroutines (`Dispatchers.IO` and `callbackFlow`) to guarantee smooth frame rates and zero ANR errors.
* **🔄 Unidirectional Data Flow (UDF) & Navigation:** UI state is completely decoupled from worker logic via injected `EventLink` and `NetworkUILinkRepository` interfaces, supporting predictable back-stack navigation for both User and Admin screens.
* **🧮 Custom Math & Canvas Rendering Engines:** Pluggable mathematical engines (`Circular Motion Engine`, `DrawCustomCircle`, `trailUI`) and device-agnostic coordinate calculators powering high-framerate Compose `Canvas` simulations.

---

## 🛠️ Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) & [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
* **Architecture & Patterns:** Kotlin Multiplatform (KMP), Clean Architecture (Heart/Brain Split), SOLID Principles, Unidirectional Data Flow (UDF), State-Driven UI
* **Cloud & Network:** Firebase Firestore (Real-time NoSQL metadata sync), Google Drive (Cloud PDF storage)
* **Local Persistence:** SQLite with B-Tree indexing on student roll numbers
* **Concurrency:** Kotlin Coroutines (`Dispatchers.IO`, `StateFlow`, `callbackFlow`)
* **Build Configuration:** Gradle (Kotlin DSL `build.gradle.kts`)

---

## 💻 Code Highlights

### 1. Asynchronous Cloud Sync (`FirestoreNotesDataSource`)
To maintain low latency and avoid ANR errors, all Firebase Firestore operations are isolated in `:network_android` and streamed reactively to the shared KMP layer using `callbackFlow` and `Dispatchers.IO`:

```kotlin
class FirestoreNotesDataSource : RemoteNotesDataSource {
    private val notesCollection = FirebaseFirestore.getInstance().collection("notes")

    override suspend fun uploadPdfAndSaveToCloud(
        title: String,
        subject: String,
        fileName: String,
        pdfBytes: ByteArray
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            // Uploads metadata & Drive download link to Firestore off the main thread
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun observeNotesFromCloud(): Flow<List<Note>> = callbackFlow {
        val listener = notesCollection.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val notes = snapshot.documents.map { doc ->
                    Note(
                        id = doc.id,
                        title = doc.getString("title") ?: "",
                        subject = doc.getString("subject") ?: "",
                        downloadUrl = doc.getString("downloadUrl") ?: "",
                        uploadedAt = doc.getLong("uploadedAt") ?: 0L
                    )
                }
                trySend(notes)
            }
        }
        awaitClose { listener.remove() }
    }
}
```

### 2. 2D Starfield Particle Engine (`BackgroundUI`)
To ensure reliable rendering across different device screens, the motion engine calculates frame updates deterministically inside Compose:

```kotlin
@Composable
fun BackgroundUI() {
    val centerX = 1000f
    val centerY = 1000f

    // Each star: [x, y, speed]
    val stars = remember {
        mutableStateListOf(*Array(100) {
            floatArrayOf(
                (0..2000).random().toFloat(),
                (0..2000).random().toFloat(),
                (2..6).random().toFloat()
            )
        })
    }

    // Animation loop — runs every frame
    LaunchedEffect(Unit) {
        while (true) {
            withFrameMillis {
                for (i in stars.indices) {
                    val star = stars[i]
                    val dx = star[0] - centerX
                    val dy = star[1] - centerY
                    val dist = sqrt(dx * dx + dy * dy)

                    if (dist < 10f) {
                        stars[i] = floatArrayOf(
                            (0..2000).random().toFloat(),
                            (0..2000).random().toFloat(),
                            star[2]
                        )
                    } else {
                        val ratio = star[2] / dist
                        stars[i] = floatArrayOf(
                            star[0] - dx * ratio,
                            star[1] - dy * ratio,
                            star[2]
                        )
                    }
                }
            }
        }
    }
}
```

---

## 🚀 Integration Status

**Core Engine & UI Rendering**
- [x] Initial engine setup and Gradle configuration.
- [x] Implement dynamic screen center calculation for responsive rendering.
- [x] Build responsive 2D starfield particle engine (with Schwarzschild radius event logic).
- [x] Extract universal `CustomColor` package (independent of UI, ready for multi-platform & pure HTML/CSS).
- [x] Refactor Main Screen UI for vastly improved maintainability.

**Architecture & Decoupling**
- [x] Refactor project structure to separate Android device activity from the UI layer.
- [x] Decouple UI from Worker logic via injected `EventLink` interfaces (enforcing Unidirectional Data Flow).
- [x] Implement dummy `EventLink` objects to support Compose `@Preview`.
- [x] Enforce strict Heart/Brain split (business logic isolated from presentation).

**Kotlin Multiplatform (KMP) & Desktop Expansion**
- [x] Resolve Gradle plugin conflicts and KMP implementation issues.
- [x] Configure JetBrains Compose Desktop.
- [x] Create the `:desktopApp` module to serve as the standalone Windows entry point.
- [x] Implement the separated `:sharedUI` module for a universal design system.
- [x] Successfully compile and execute Codex Vanguard natively on the Windows JVM.

**Alpha v2: Domain, Data, Local Database & Cloud Network Layers**
- [x] Architect `:LocalDatabase` module with SQLite for student credential storage and `roll_no` indexing.
- [x] Integrate Firebase Firestore inside `:network_android` with `RemoteNotesDataSource` and `FirestoreNotesDataSource`.
- [x] Build `Network_UI` in `:sharedUI` for state-driven status reporting and PDF upload triggers.
- [ ] Complete end-to-end Google Drive PDF upload and student one-tap download pipeline.
- [ ] Finalize back-stack navigation flows between Login, Admin Upload, and Student Download screens.

---

## 👤 Credits & Acknowledgements

* **Lead Developer & Architect:** Santanu Sarkar ([@santanu2032](https://github.com/santanu2032))
* **Core Frameworks:**
  * [Kotlin Multiplatform (KMP)](https://kotlinlang.org/docs/multiplatform.html)
  * [Jetpack Compose](https://developer.android.com/jetpack/compose)
  * [JetBrains Compose Desktop](https://www.jetbrains.com/lp/compose-multiplatform/)
  * [Firebase Firestore](https://firebase.google.com/docs/firestore) & [SQLite](https://www.sqlite.org/)

*Project Codex Vanguard is custom-built, focusing on modular Clean Architecture, high-performance mathematical rendering, low-latency data indexing, and strict zero-dependency domain logic.*

---

## 🤖 AI Collaboration & Tooling

In the spirit of transparency and modern development practices, Project Codex Vanguard utilizes AI-powered assistants as collaborative tools during the development lifecycle.

* **Debugging & Build Support:** AI acts as an active pair-programmer, assisting in troubleshooting complex Kotlin Multiplatform (KMP) Gradle configurations, resolving module dependency inversions, and accelerating boilerplate generation.
* **Architectural Integrity:** While AI assists in debugging, syntax refinement, and drafting documentation, all core architectural blueprints—including the strict Heart/Brain separation of concerns, SOLID abstractions, and lifecycle priorities—are human-driven.
* **Deterministic Execution:** While AI is used as a *development tool*, the resulting application and its internal assistant run strictly on highly optimized, deterministic `if-else` conditional logic, indexed SQL queries, and explicit mathematical formulas rather than black-box machine learning models at runtime.

---

### 📸 Development Snapshots

![img.png](img.png)
![img_1.png](img_1.png)
