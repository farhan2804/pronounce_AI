import UploadAudio from "../components/UploadAudio";

function Home() {
  return (
    <div
      style={{
        width: "600px",
        margin: "50px auto",
        textAlign: "center",
      }}
    >
      <h1>PronounceAI</h1>
      <p>Upload an English audio file (30-45 seconds)</p>

      <UploadAudio />
    </div>
  );
}

export default Home;