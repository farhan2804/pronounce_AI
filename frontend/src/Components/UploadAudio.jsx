import { useState } from "react";
import API from "../services/api";

function UploadAudio() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [message, setMessage] = useState("");

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

      setMessage(response.data);

    } catch (error) {
      console.error(error);
      setMessage("Upload Failed");
    }

  };

  return (
    <div>

      <input
        type="file"
        accept=".mp3,.wav,.m4a"
        onChange={handleFileChange}
      />

      <br /><br />

      {selectedFile && (
        <p>
          Selected File: <b>{selectedFile.name}</b>
        </p>
      )}

      <button onClick={handleUpload}>
        Analyze Pronunciation
      </button>

      <br /><br />

      <h3>{message}</h3>

    </div>
  );
}

export default UploadAudio;