### Abel Tesfa ...... UGR/3106/15

# 📱 Jetpack Compose TODO List App

An Android application built with **Jetpack Compose** that fetches a list of TODO items from the JSONPlaceholder API. The app supports offline caching using Room and follows the MVVM architecture for clean code structure.

---

## 🎯 Objective

- Fetch TODO items from a remote API and display them in a scrollable Compose UI.
- Show detailed information when a user selects a TODO item.
- Cache data using Room for offline use and faster loading.
- Implement navigation between list and detail screens using Jetpack Compose Navigation.

---

## ✅ Features

- 📡 **Remote API Integration**  
  Retrieves TODOs from [JSONPlaceholder](https://jsonplaceholder.typicode.com/todos) using Retrofit.

- 💾 **Offline Caching with Room**  
  Stores todos locally for offline access and faster app startup.

- 🧭 **Navigation with Jetpack Compose**  
  Navigates between screens with a smooth Compose-native experience.

- 📱 **Jetpack Compose UI**  
  Built entirely using Compose, including `LazyColumn` for efficient scrolling.

- 🔁 **Data Synchronization**  
  Loads cached data immediately, then refreshes from the network if possible.

- ⚙️ **MVVM Architecture**  
  Uses ViewModels and a Repository to separate UI from data/business logic.

- 🚫 **Robust Error Handling**  
  Displays error messages when network requests fail and falls back to local cache.

---

## 🛠️ Tech Stack

- **Language:** Kotlin  
- **UI:** Jetpack Compose  
- **Networking:** Retrofit + Kotlin Coroutines  
- **Persistence:** Room Database  
- **Architecture:** MVVM  
- **Navigation:** Jetpack Compose Navigation
