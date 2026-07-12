# 🎤 PronounceAI

An AI-powered English Pronunciation Assessment web application built using **React** and **Spring Boot**.

---

## Live Demo

### Frontend
https://pronounce-ai-ap3b-phi.vercel.app

### Backend
https://pronounceai-production-fe5d.up.railway.app

---

## GitHub Repository

https://github.com/farhan2804/pronounce_AI

---

# Features

- Upload English audio (30–45 seconds)
- Audio validation
- Pronunciation assessment report
- Overall pronunciation score
- Accuracy score
- Fluency score
- Completeness score
- Highlight pronunciation mistakes
- Professional responsive UI
- REST API integration

---

# Technology Stack

## Frontend

- React
- Vite
- Axios
- CSS

## Backend

- Java 21
- Spring Boot
- REST API

## Deployment

- Vercel
- Railway
- GitHub

---

# Project Architecture

```
React Frontend
        │
        ▼
Axios REST API
        │
        ▼
Spring Boot Backend
        │
        ▼
Pronunciation Service
        │
        ▼
Assessment Result
```

---

# APIs

## Health

GET

```
/api/health
```

---

## Upload Audio

POST

```
/api/audio/upload
```

Request

```
multipart/form-data
```

Parameter

```
audio
```

---

# Folder Structure

```
pronounce_AI

│
├── backend
│
├── frontend
│
└── README.md
```

---

# Running Locally

## Backend

```bash
cd backend
./mvnw spring-boot:run
```

## Frontend

```bash
cd frontend
npm install
npm run dev
```

---

# Current Limitations

The current implementation demonstrates the complete application workflow using a modular pronunciation assessment service.

The pronunciation assessment engine is intentionally isolated behind the backend service layer so that it can be replaced with production-grade services such as Azure Speech Pronunciation Assessment or other speech evaluation engines without changing the frontend architecture.

---

# Future Improvements

- Azure Speech Pronunciation Assessment
- Whisper Speech-to-Text
- Phoneme comparison
- Database
- Authentication
- Dashboard
- Progress Tracking
- Docker Deployment

---

# Author

**Farhan Mahmood**