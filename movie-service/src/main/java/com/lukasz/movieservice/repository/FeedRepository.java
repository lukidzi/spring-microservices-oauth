package com.lukasz.movieservice.repository;

import com.lukasz.movieservice.model.Feed;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FeedRepository extends ReactiveMongoRepository<Feed, String> {
}
