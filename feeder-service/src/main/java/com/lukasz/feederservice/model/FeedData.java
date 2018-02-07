package com.lukasz.feederservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class FeedData {

    private final String name;

    @JsonCreator
    public FeedData(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FeedData{" +
                "name='" + name + '\'' +
                '}';
    }
}
