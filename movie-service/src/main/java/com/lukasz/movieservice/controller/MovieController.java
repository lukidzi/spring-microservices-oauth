package com.lukasz.movieservice.controller;

import com.lukasz.movieservice.model.Movie;
import com.lukasz.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movies")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Flux<Movie> getAllMovies(){
        log.info("Receiving all movies from mongodb");
        return movieService.findAllMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Movie> addMovieToDb(@RequestBody Movie movie){
        log.info("Adding '{}' to database", movie);
        return movieService.addToDb(movie);
    }
}
