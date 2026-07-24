function MistakeList({ mistakes }) {
  if (!mistakes || mistakes.length === 0) {
    return (
      <div className="success-card">
        <h3 className="feedback-title">
          🎉 Excellent Pronunciation
        </h3>

        <p>
          No significant pronunciation issues were detected.
        </p>

        <p className="small-text">
          Your speech was clear and closely matched the expected pronunciation.
        </p>
      </div>
    );
  }

  return (
    <div className="mistakes-container">

      <h3 className="feedback-title">
        Pronunciation Feedback
      </h3>

      {mistakes.map((mistake, index) => (
        <div
          key={index}
          className="mistake-card"
        >

          <div className="mistake-header">

            <span className="mistake-icon">
              ❌
            </span>

            <span className="mistake-word">
              {mistake.word}
            </span>

          </div>

          <div className="mistake-body">

            <div className="feedback-row">

              <strong>Issue</strong>

              <p>{mistake.issue}</p>

            </div>

            <div className="feedback-row">

              <strong>Recommendation</strong>

              <p>
                Practice this word slowly and pronounce each syllable clearly.
                Listen to a native pronunciation and repeat several times.
              </p>

            </div>

          </div>

        </div>
      ))}

    </div>
  );
}

export default MistakeList;