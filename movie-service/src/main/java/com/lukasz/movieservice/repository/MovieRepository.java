package com.lukasz.movieservice.repository;

import com.lukasz.movieservice.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
