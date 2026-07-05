# 📱 Android Application Documentation: LettersInFourLanguages

## 🧾 General Information
**Project Name:**
LettersInFourLanguages

**Author(s):**
Zeev Fraiman

**Date:**
July 2024

**Language:**
Java

**Development Environment:**
Android Studio

**Android Version (minSdk / targetSdk):**
28 / 35

---

## 🎯 Project Objective
• **What task does the app solve:** It allows the user to explore the alphabets of four different languages (English, Russian, Georgian, Amharic) by generating random letters and analyzing their properties.
• **Why this task is important:** It is an educational tool for those starting to learn new languages and wanting to become familiar with the writing and order of letters in the alphabet.
• **Target Audience:** Students, linguists, and anyone interested in foreign languages.

---

## 📌 Application Requirements
### Functional Requirements
• Choice of one of four languages.
• Generation of a random letter from the selected alphabet.
• Display of adjacent letters (previous and next).
• Display of the letter's serial number in the alphabet.
• Letter case conversion (uppercase/lowercase).

### Non-functional Requirements
• **Performance:** Instant response to user actions.
• **Usability:** Simple interface using RadioGroup and CheckBox.
• **Reliability:** Stable operation without crashes when switching languages.

---

## 🧠 General Architecture
• **Chosen approach:**
– MVC (Model-View-Controller) in a simplified form (Activity acts as both controller and view).

• **Why it was chosen:**
The project is small, logic is focused on data processing within a single screen, making the use of complex patterns like MVVM redundant.

• **Main system components:**
- `MainActivity`: The heart of the app, handling user input and alphabet logic.
- `activity_main.xml`: User interface description.

---

## 🧩 UML Diagram
**Description:**
`[MainActivity]` –> `[Layout XML]`
`[MainActivity]` contains `char[]` arrays (data).

---

## Packages
- `zeev.fraiman.lettersinfourlanguages`: The main package containing the app logic.
- This helps logically separate the author's code from system libraries and ensures the uniqueness of the application ID.

---

## 🧩 Detailed Class Description
### 📌 Class: MainActivity
**Role:**
The main and only screen of the application.

**Responsibility:**
UI initialization, handling button clicks, generating random characters, and calculating their properties.

**Main Methods:**
- `onCreate()` — sets the layout and binds event listeners.
- `generateRandomLetter(char[] alphabet)` — selects a random index from the array.
- `getNeighbor(char letter, char[] alphabet, int offset)` — gets the adjacent character with boundary checks.
- `getAlphabetPosition(char letter, char[] alphabet)` — finds the character's index.

**Interaction with other classes:**
Interacts directly with Android system classes (AppCompatActivity, View, Widget).

---

## 🔄 Application Workflow Diagram
**Scenario:**
1. User selects "Russian" in the RadioGroup.
2. Checks the "Show adjacent letters" CheckBox.
3. Clicks "Perform analysis".
4. The app selects a random letter (e.g., 'B'), finds 'A' and 'V' (in Cyrillic), and displays the result on the screen.

---

## 🎨 UI/UX Analysis
• **Why the interface is designed this way:** Vertical orientation is used for readability on smartphones.
• **Principles used:**
– Simplicity: minimal elements, everything on one screen.
– Logic: language selection at the top, options in the middle, result at the bottom.
– Accessibility: standard Android controls.
• **What can be improved:** Add dark theme support and localization of strings in `strings.xml`.

---

## ⚙️ Threading
• **Used:**
- All operations are performed on the **UI Thread**.
• **Why this method was chosen:** Operations with character arrays are instantaneous and do not block the interface.
• **Prevention of:**
– Hanging (ANR): no heavy calculations.
– Memory leaks: Activity context is not passed to long-lived objects.

---

## 💾 Data Handling
• **Where data is stored:** In constant `char[]` arrays within `MainActivity`.
• **Why this method was chosen:** Alphabets are static and do not require a database or external storage.
• **How ensured:**
– Safety: data is hardcoded.
– Correctness: arrays contain reference character sets.

---

## 🌐 Networking
• The app works completely **offline**.

---

## 🔐 Security (Basic Level)
• The app does not collect or store sensitive data.

---

## 🧪 Testing
• **Existing tests:**
– Placeholders for Unit tests and UI tests (Espresso) are available.
• **What is checked:** Correctness of letter generation within specified alphabets.

---

## 🐞 Error Handling
• Language selection check: if no language is selected, a `Toast` message "Select language!" is displayed.

---

## ⚡ Performance
• **Optimizations:** Minimal use of memory resources.
• **Bottlenecks:** None detected with current data volume.

---

## 🚀 Expansion Opportunities
• Adding new languages (e.g., Hebrew or Arabic).
• Voice synthesis for letters.
• Adding a "Guess the letter" game mode.
