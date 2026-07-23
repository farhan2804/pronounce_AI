import { useEffect, useState } from "react";
import UploadAudio from "../Components/UploadAudio";
import API from "../Services/api";

function Home() {
  const [sentence, setSentence] = useState("");

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
    <div className="home-container">
      <h1>🎤 PronounceAI</h1>

      <div className="sentence-card">
        <h2>Read the sentence below</h2>
        <p className="sentence-text">
          {sentence || "Loading sentence..."}
        </p>
      </div>

      <UploadAudio />
    </div>
  );
}

export default Home;