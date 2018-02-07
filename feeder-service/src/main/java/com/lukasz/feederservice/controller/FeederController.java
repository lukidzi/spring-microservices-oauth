package com.lukasz.feederservice.controller;

import com.lukasz.feederservice.model.FeedData;
import com.lukasz.feederservice.service.FeederService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("feeder")
public class FeederController {

    private final static Logger log = LoggerFactory.getLogger(FeederController.class);

    private final WebClient webClient;
    private final FeederService feederService;

    @Autowired
    public FeederController(WebClient.Builder webClient, FeederService feederService) {
        this.webClient = webClient.build();
        this.feederService = feederService;
    }

    @GetMapping(value = "initFeed")
    public void initFeed(@RequestHeader(value = "Authorization") String token) {
        feederService.generateSomeData().doOnEach(
                data -> webClient.post()
                        .uri("http://localhost:8090/feed")
                        .body(BodyInserters.fromObject(new FeedData(data.get().toString())))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .header(HttpHeaders.AUTHORIZATION, token)
                        .retrieve()
                        .bodyToMono(FeedData.class)
                        .subscribe()
        ).subscribe(i -> log.info("Data: {}", i));
    }
}
