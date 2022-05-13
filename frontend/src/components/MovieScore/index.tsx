import MovieStars from "components/MovieStars"
import "./styles.css"

const count = 2;
const score = 4.5;

function MovieScore() {
    return (
        <div className="dsmovie-score-container">
            <p className="dsmovie-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
            <MovieStars />
            <p className="dsmovie-score-count">{count} avaliações</p>
        </div>
    )
}

export default MovieScore;