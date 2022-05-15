package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.DTO.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElse(userRepository.saveAndFlush(new User(dto.getEmail())));

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        repository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum += s.getValue();
        }

        movie.setScore(sum/movie.getScores().size());
        movie.setCount(movie.getScores().size());

        return new MovieDTO(movieRepository.saveAndFlush(movie));
    }

}
