function ScoreCard({ title, value }) {
  const getColor = () => {
    if (value >= 90) return "#16a34a";
    if (value >= 75) return "#f59e0b";
    return "#dc2626";
  };

  const getIcon = () => {
    switch (title) {
      case "Overall Score":
        return "🏆";
      case "Accuracy":
        return "🎯";
      case "Fluency":
        return "🗣️";
      case "Completeness":
        return "✅";
      default:
        return "📊";
    }
  };

  return (
    <div className="scoreBox">
      <div className="scoreIcon">
        {getIcon()}
      </div>

      <div className="scoreNumber">
        {value}
        {title !== "Overall Score" ? "%" : ""}
      </div>

      <div className="scoreTitle">
        {title}
      </div>

      <div className="progress">
        <div
          className="progressFill"
          style={{
            width: `${value}%`,
            background: getColor(),
          }}
        ></div>
      </div>
    </div>
  );
}

export default ScoreCard;