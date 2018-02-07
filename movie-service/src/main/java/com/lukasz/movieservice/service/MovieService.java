package com.lukasz.movieservice.service;

import com.lukasz.movieservice.model.Movie;
import com.lukasz.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flux<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Mono<Movie> addToDb(final Movie movie) {
        return movieRepository.save(movie);
    }
}
