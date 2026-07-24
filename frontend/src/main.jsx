import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { register, MediaRecorder } from "extendable-media-recorder";
import { connect } from "extendable-media-recorder-wav-encoder";

import App from "./App.jsx";
import "./App.css";

async function bootstrap() {
  // Register the WAV encoder once
  await register(await connect());

  createRoot(document.getElementById("root")).render(
    <StrictMode>
      <App />
    </StrictMode>
  );
}

bootstrap();