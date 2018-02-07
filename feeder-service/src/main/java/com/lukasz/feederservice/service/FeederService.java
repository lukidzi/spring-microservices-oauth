package com.lukasz.feederservice.service;

import com.lukasz.feederservice.model.FeedData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class FeederService {

    public Flux<FeedData> generateSomeData() {
        return Flux.interval(Duration.ofSeconds(1)).map(i -> new FeedData("Sample" + i));
    }
}
