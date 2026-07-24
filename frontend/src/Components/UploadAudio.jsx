import { useState } from "react";
import API from "../Services/api";
import ScoreCard from "./ScoreCard";
import MistakeList from './MistakeList';

function UploadAudio({ recordedBlob }) {
  const [selectedFile, setSelectedFile] = useState(null);
  const [result, setResult] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

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
    let audioFile = null;

    if (recordedBlob) {
      audioFile = new File([recordedBlob], "recording.wav", {
        type: "audio/wav",
      });
    } else if (selectedFile) {
      audioFile = selectedFile;
    } else {
      alert("Please record or upload an audio file.");
      return;
    }

    const formData = new FormData();
    formData.append("audio", audioFile);

    try {
      setLoading(true);
      setResult(null);

      const response = await API.post("/audio/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });

      setResult(response.data);
    } catch (error) {
      console.error(error);
      alert("Upload Failed");
    } finally {
      setLoading(false);
    }
  };

  const getAssessment = (score) => {
    if (score >= 90) {
      return {
        title: "Excellent Pronunciation",
        message: "Your pronunciation is very clear and natural. Excellent job!",
      };
    }

    if (score >= 75) {
      return {
        title: "Good Pronunciation",
        message:
          "Your pronunciation is good. Improving fluency and clarity will make it even better.",
      };
    }

    return {
      title: "Needs Improvement",
      message:
        "Continue practicing pronunciation, pacing, and word clarity to improve your speaking skills.",
    };
  };

  const assessment = result ? getAssessment(result.score) : null;

  return (
    <div>
      <p className="section-description">
        Upload an existing audio file or analyze the recording you created
        above.
      </p>

      <input
        className="fileInput"
        type="file"
        accept=".mp3,.wav,.m4a,.webm"
        onChange={handleFileChange}
      />

      {error && <p className="error">{error}</p>}

      {selectedFile && (
        <p className="success-status">
          📁 Selected File: <strong>{selectedFile.name}</strong>
        </p>
      )}

      {recordedBlob && (
        <p className="success-status">
          ✅ Browser recording ready for analysis
        </p>
      )}

      <button className="btn" disabled={loading} onClick={handleUpload}>
        {loading ? "Analyzing Pronunciation..." : "Analyze Pronunciation"}
      </button>

      {loading && (
        <div className="loading">
          <div className="spinner"></div>

          <p>Azure AI is analyzing your pronunciation...</p>
        </div>
      )}

      {result && (
        <div className="card fade-in">
          <div className="result-title">
            <h2>Pronunciation Report</h2>

            <span className="badge">Azure Speech AI</span>
          </div>

          <div className="grid">
            <ScoreCard title="Overall Score" value={result.score} />

            <ScoreCard title="Accuracy" value={result.accuracy} />

            <ScoreCard title="Fluency" value={result.fluency} />

            <ScoreCard title="Completeness" value={result.completeness} />
          </div>

          <div className="success-card" style={{ marginTop: "30px" }}>
            <h3
              style={{
                color: "#166534",
                marginBottom: "12px",
              }}
            >
              Overall Assessment
            </h3>

            <strong>{assessment.title}</strong>

            <p
              style={{
                marginTop: "10px",
                color: "#166534",
              }}
            >
              {assessment.message}
            </p>
          </div>

          <MistakeList mistakes={result.mistakes} />
        </div>
      )}
    </div>
  );
}

export default UploadAudio;
