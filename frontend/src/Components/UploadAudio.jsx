import { useState } from "react";
import API from "../Services/api";


function UploadAudio() {

  const [selectedFile, setSelectedFile] = useState(null);
  const [result, setResult] = useState(null);
  const [error, setError] = useState("");

  const handleFileChange = (event) => {

    const file = event.target.files[0];

    if (!file) return;

    const audio = document.createElement("audio");
    audio.preload = "metadata";

    audio.onloadedmetadata = () => {

      window.URL.revokeObjectURL(audio.src);

      const duration = audio.duration;

      if (duration < 30 || duration > 45) {
        setError("Audio must be between 30 and 45 seconds.");
        setSelectedFile(null);
        setResult(null);
        return;
      }

      setError("");
      setSelectedFile(file);

    };

    audio.src = URL.createObjectURL(file);

  };

  const handleUpload = async () => {

    if (!selectedFile) {
      alert("Please select a valid audio file.");
      return;
    }

    const formData = new FormData();
    formData.append("audio", selectedFile);

    try {

      const response = await API.post("/audio/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });

      setResult(response.data);

    } catch (error) {
      console.error(error);
      alert("Upload Failed");
    }

  };

  return (

    <div className="container">

      <h1 className="title">🎤 PronounceAI</h1>

      <p className="subtitle">
        AI Powered English Pronunciation Assessment
      </p>

      <input
        className="fileInput"
        type="file"
        accept=".mp3,.wav,.m4a"
        onChange={handleFileChange}
      />

      <br /><br />

      {error && (
        <p className="error">{error}</p>
      )}

      {selectedFile && (
        <p>
          <b>Selected File :</b> {selectedFile.name}
        </p>
      )}

      <button
        className="btn"
        onClick={handleUpload}
      >
        Analyze Pronunciation
      </button>

      {result && (

        <div className="card">

          <h2 style={{ textAlign: "center" }}>
            Pronunciation Report
          </h2>

          <div className="grid">

            <div className="scoreBox">
              <div className="scoreNumber">
                {result.score}
              </div>
              <div>Score</div>
            </div>

            <div className="scoreBox">
              <div className="scoreNumber">
                {result.accuracy}%
              </div>
              <div>Accuracy</div>
            </div>

            <div className="scoreBox">
              <div className="scoreNumber">
                {result.fluency}%
              </div>
              <div>Fluency</div>
            </div>

            <div className="scoreBox">
              <div className="scoreNumber">
                {result.completeness}%
              </div>
              <div>Completeness</div>
            </div>

          </div>

          <h3 style={{ marginTop: "30px" }}>
            Pronunciation Issues
          </h3>

          <ul>

            {result.mistakes.map((mistake, index) => (

              <li key={index}>

                ❌ <b>{mistake.word}</b>

                <br />

                {mistake.issue}

              </li>

            ))}

          </ul>

        </div>

      )}

    </div>

  );

}

export default UploadAudio;