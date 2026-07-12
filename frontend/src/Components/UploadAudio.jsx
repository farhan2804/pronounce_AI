import { useState } from "react";
import API from "../services/api";

function UploadAudio() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [result, setResult] = useState(null);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUpload = async () => {
    if (!selectedFile) {
      alert("Please select an audio file.");
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

      console.log(response.data);

      setResult({
        score: 86,
        accuracy: 90,
        fluency: 82,
        completeness: 88,
        mistakes: [
          {
            word: "comfortable",
            issue: "Stress incorrect",
          },
          {
            word: "development",
            issue: "Unclear pronunciation",
          },
        ],
      });
    } catch (error) {
      console.error(error);
      alert("Upload Failed");
    }
  };

  return (
    <div>
      <input type="file" accept=".mp3,.wav,.m4a" onChange={handleFileChange} />

      <br />
      <br />

      {selectedFile && (
        <p>
          Selected File: <b>{selectedFile.name}</b>
        </p>
      )}

      <button onClick={handleUpload}>Analyze Pronunciation</button>

      <br />
      <br />

      {result && (
        <div>
          <h2>Pronunciation Score : {result.score}/100</h2>

          <p>
            <b>Accuracy:</b> {result.accuracy}%
          </p>

          <p>
            <b>Fluency:</b> {result.fluency}%
          </p>

          <p>
            <b>Completeness:</b> {result.completeness}%
          </p>

          <h3>Mistakes</h3>

          <ul>
            {result.mistakes.map((mistake, index) => (
              <li key={index}>
                <b>{mistake.word}</b> - {mistake.issue}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default UploadAudio;
