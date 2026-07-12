import { useState } from "react";

function UploadAudio() {
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  return (
    <div>
      <input
        type="file"
        accept=".mp3,.wav,.m4a"
        onChange={handleFileChange}
      />

      <br />
      <br />

      {selectedFile && (
        <p>
          Selected File: <b>{selectedFile.name}</b>
        </p>
      )}

      <button>Analyze Pronunciation</button>
    </div>
  );
}

export default UploadAudio;