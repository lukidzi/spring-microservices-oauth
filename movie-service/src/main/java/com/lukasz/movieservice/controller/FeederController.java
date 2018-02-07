package com.lukasz.movieservice.controller;

import com.lukasz.movieservice.model.Feed;
import com.lukasz.movieservice.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("feed")
public class FeederController {

    private static final Logger log = LoggerFactory.getLogger(FeederController.class);
    private final FeedService feedService;

    public FeederController(FeedService feedService){
        this.feedService = feedService;
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Feed> addToDbSomeData(@RequestBody Feed feed){
        log.info("Feeder {}", feed.getName());
        return feedService.addToDb(feed);
    }

}
