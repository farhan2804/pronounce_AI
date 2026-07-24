import { useRef, useState } from "react";
import { MediaRecorder } from "extendable-media-recorder";

function AudioRecorder({ setRecordedBlob }) {
  const [isRecording, setIsRecording] = useState(false);
  const [audioURL, setAudioURL] = useState("");

  const mediaRecorderRef = useRef(null);
  const streamRef = useRef(null);
  const chunksRef = useRef([]);

  const startRecording = async () => {
    try {
      const stream = await navigator.mediaDevices.getUserMedia({
        audio: true,
      });

      streamRef.current = stream;

      chunksRef.current = [];

      const recorder = new MediaRecorder(stream, {
        mimeType: "audio/wav",
      });

      mediaRecorderRef.current = recorder;

      recorder.ondataavailable = (event) => {
        if (event.data.size > 0) {
          chunksRef.current.push(event.data);
        }
      };

      recorder.onstop = () => {
        const wavBlob = new Blob(chunksRef.current, {
          type: "audio/wav",
        });

        console.log("Blob Type:", wavBlob.type);
        console.log("Blob Size:", wavBlob.size);

        setRecordedBlob(wavBlob);
        setAudioURL(URL.createObjectURL(wavBlob));

        if (streamRef.current) {
          streamRef.current.getTracks().forEach((track) => track.stop());
        }
      };

      recorder.start();

      setIsRecording(true);
    } catch (err) {
      console.error(err);
      alert("Unable to access microphone.");
    }
  };

  const stopRecording = () => {
    if (mediaRecorderRef.current) {
      mediaRecorderRef.current.stop();
    }

    setIsRecording(false);
  };

  const recordAgain = () => {
    setRecordedBlob(null);
    setAudioURL("");
  };

  return (
    <div style={{ marginTop: "30px" }}>
      <h2>🎙 Record Your Voice</h2>

      <button onClick={startRecording} disabled={isRecording}>
        {isRecording ? "Recording..." : "🎙 Start Recording"}
      </button>

      <button
        onClick={stopRecording}
        disabled={!isRecording}
        style={{ marginLeft: "10px" }}
      >
        ⏹ Stop Recording
      </button>

      {audioURL && (
        <>
          <h3 style={{ marginTop: "20px" }}>Recorded Audio</h3>

          <audio controls src={audioURL}></audio>

          <br />
          <br />

          <button onClick={recordAgain}>🔄 Record Again</button>
        </>
      )}
    </div>
  );
}

export default AudioRecorder;