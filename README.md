# 🎙️ PronounceAI

PronounceAI is an AI-powered pronunciation assessment web application that helps users evaluate and improve their English pronunciation. The application leverages Microsoft Azure Speech Services to analyze spoken audio and generate detailed pronunciation feedback, including overall pronunciation score, accuracy, fluency, completeness, and word-level pronunciation analysis.

This project was developed using React, Spring Boot, and Microsoft Azure Speech SDK to demonstrate modern full-stack development with cloud-based AI integration.

---

## ✨ Features

- 🎤 Record audio directly from the browser
- 📁 Upload WAV audio files for analysis
- 🤖 AI-powered pronunciation assessment
- 📊 Overall Pronunciation Score
- 🎯 Accuracy Score
- 🗣️ Fluency Score
- ✅ Completeness Score
- ❌ Word-level pronunciation feedback
- 📱 Responsive user interface
- ⚡ Fast REST API communication
- ☁️ Microsoft Azure Speech integration

---

## 🛠️ Tech Stack

### Frontend

- React
- Vite
- Axios
- CSS3

### Backend

- Java 21
- Spring Boot
- Maven

### AI Service

- Microsoft Azure Speech SDK
- Azure Pronunciation Assessment API

---

## 📂 Project Structure

```
PronounceAI
│
├── frontend
│   ├── src
│   │   ├── Components
│   │   ├── Pages
│   │   ├── Services
│   │   ├── App.jsx
│   │   └── App.css
│   │
│   └── package.json
│
├── backend
│   ├── controller
│   ├── service
│   ├── azure
│   ├── dto
│   ├── config
│   └── resources
│
└── README.md
```

---

# Application Workflow

```
                User
                  │
                  ▼
      Record / Upload Audio
                  │
                  ▼
          React Frontend
                  │
             Axios Request
                  │
                  ▼
       Spring Boot REST API
                  │
                  ▼
      Azure Speech SDK Service
                  │
                  ▼
 Microsoft Azure Speech Service
                  │
      Pronunciation Assessment
                  │
                  ▼
        JSON Assessment Result
                  │
                  ▼
         Spring Boot Backend
                  │
                  ▼
          React Dashboard
                  │
                  ▼
        Pronunciation Feedback
```

---

# Pronunciation Metrics

The application evaluates pronunciation using Microsoft's Pronunciation Assessment API.

The generated assessment includes:

- Overall Pronunciation Score
- Accuracy Score
- Fluency Score
- Completeness Score
- Word-Level Pronunciation Accuracy

---

## Screenshots

> Add screenshots of the application here.

Suggested screenshots:

- Home Page
- Voice Recording
- Audio Upload
- Assessment Results
- Pronunciation Feedback

---

# Installation

## Clone the repository

```bash
git clone <repository-url>
```

---

## Backend Setup

Navigate to the backend directory.

```bash
cd backend
```

Install dependencies.

```bash
mvn clean install
```

Configure your Azure Speech credentials inside your application configuration.

Run the backend.

```bash
mvn spring-boot:run
```

---

## Frontend Setup

Navigate to the frontend directory.

```bash
cd frontend
```

Install dependencies.

```bash
npm install
```

Run the development server.

```bash
npm run dev
```

---

# API Endpoint

### Upload Audio

```
POST /api/audio/upload
```

Accepts:

- WAV Audio File

Returns:

```json
{
  "score": 95,
  "accuracy": 94,
  "fluency": 96,
  "completeness": 100,
  "mistakes": [
    {
      "word": "technology",
      "issue": "Low pronunciation accuracy (76%)"
    }
  ]
}
```

---

# Future Improvements

Possible future enhancements include:

- User authentication
- Pronunciation history
- Progress tracking dashboard
- Support for multiple languages
- Reading difficulty levels
- AI-generated pronunciation tips
- Export assessment reports

---

# Learning Outcomes

This project demonstrates practical experience with:

- Full Stack Web Development
- REST API Design
- React Component Architecture
- Spring Boot Backend Development
- File Upload Handling
- Microsoft Azure Speech SDK
- Cloud AI Integration
- JSON Parsing
- Responsive UI Design

---

# Disclaimer

This project is intended for educational, learning, and portfolio purposes. Microsoft Azure Speech Services are used for AI-powered pronunciation assessment.

---

## Author

**Farhan Mahmood**

Full Stack Java Developer

Java • Spring Boot • React • Microsoft Azure • REST APIs