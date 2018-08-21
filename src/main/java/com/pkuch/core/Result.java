package com.pkuch.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Result {
    private long id;

    @Length (max = 3)
    private String content;

    public Result() {
        // Jackson deserialization
    }

    public Result(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
