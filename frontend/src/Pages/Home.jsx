import { useEffect, useState } from "react";
import UploadAudio from "../Components/UploadAudio";
import AudioRecorder from "../Components/AudioRecorder";
import API from "../Services/api";

function Home() {
  const [sentence, setSentence] = useState("");
  const [recordedBlob, setRecordedBlob] = useState(null);

  useEffect(() => {
    API.get("/sentence")
      .then((response) => {
        setSentence(response.data.sentence);
      })
      .catch((error) => {
        console.error("Failed to fetch sentence:", error);
      });
  }, []);

  return (
    <main className="home-container">
      <header className="hero">
        <h1 className="title">🎤 PronounceAI</h1>

        <p className="subtitle">
          AI Powered Pronunciation Assessment using Microsoft Azure Speech
        </p>
      </header>

      <section className="sentence-card">
        <div className="section-title">📖 Reading Passage</div>

        <p className="section-description">
          Read the passage naturally and clearly. Avoid unnecessary pauses and
          speak at a comfortable pace.
        </p>

        <p className="sentence-text">
          {sentence || "Loading reading passage..."}
        </p>
      </section>

      <section className="card">
        <div className="section-title">🎙 Voice Recording</div>

        <AudioRecorder
          recordedBlob={recordedBlob}
          setRecordedBlob={setRecordedBlob}
        />
      </section>

      <section className="card">
        <div className="section-title">📂 Pronunciation Assessment</div>

        <UploadAudio recordedBlob={recordedBlob} />
      </section>
      <footer className="footer">
        <p className="footer-title">PronounceAI</p>

        <p className="footer-text">
          AI Powered Pronunciation Assessment using Microsoft Azure Speech
        </p>

        <div className="footer-tech">
          <span>React</span>

          <span>Spring Boot</span>

          <span>Java</span>

          <span>Microsoft Azure Speech</span>
        </div>

        <p className="footer-copy">
          © 2026 PronounceAI • Built for learning and portfolio demonstration.
        </p>
      </footer>
    </main>
  );
}

export default Home;
