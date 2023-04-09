# Mono

Mono is a simple, minimalistic Android app for notes. It allows you to create notes for a day and mark them. The app was built with Jetpack Compose, Firebase, and Hilt, and follows a multi-module Clean Architecture with MVI design pattern.

## Features

- Add notes for a day
- Mark notes as done
- Firebase authentication with Google
- Firestore realtime sinchronization

## Architecture

Mono follows a multi-module Clean Architecture with MVI design pattern. The app is divided into several features, and fuatures are divided into three modules, each with a specific responsibility:

- **ui module**: contains the UI and presentation layer, including the Jetpack Compose UI components, view models, and MVI implementation.
- **domain module**: contains the business logic and use cases of the app.
- **data module**: contains the implementation of the data layer, including the Firebase integration with Firestore.

## Tech Stack

- Jetpack Compose
- Firebase
- Hilt

## Screenshots

Here are a few screenshots of the app:

| Light mode | Dark mode |
| :---: | :---: |
| <img src="https://user-images.githubusercontent.com/97764208/230761272-2b2f17bb-5098-4825-84f5-49a1a77168aa.png" width="300" /> | <img src="https://user-images.githubusercontent.com/97764208/230761297-3173870f-029c-4664-8b88-d234489395b8.png" width="300" />|
| <img src="https://user-images.githubusercontent.com/97764208/230761388-ac54d03c-01f1-4bb9-a4b0-121627469152.png" width="300" /> | <img src="https://user-images.githubusercontent.com/97764208/230761302-d26f3c58-116b-4b9e-8c95-aac25755c4aa.png" width="300" />|

## Getting Started

To get started with Mono, follow these steps:

1. Clone the repository: `git clone https://github.com/Niqrs/Mono.git`
2. Open the project in Android Studio
3. Connect your Firebase account and configure the Firestore database
4. Run the app on an emulator or physical device

## License

Mono is licensed under the [MIT License](https://github.com/Niqrs/Mono/blob/master/LICENSE.md).
