package com.lukasz.movieservice.service;

import com.lukasz.movieservice.model.Feed;
import com.lukasz.movieservice.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public Mono<Feed> addToDb(final Feed feed) {
        return feedRepository.save(feed);
    }
}
