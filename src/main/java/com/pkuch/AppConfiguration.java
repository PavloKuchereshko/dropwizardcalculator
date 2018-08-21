package com.pkuch;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class AppConfiguration extends Configuration {
    @NotEmpty
    private String addTemplate;

    @NotEmpty
    private String multiplyTemplate;

    @NotEmpty
    private String defaultAnswer = "You haven't provided any values yet!";

    @JsonProperty
    public String getAddTemplate() {
        return addTemplate;
    }

    @JsonProperty
    public void setAddTemplate(String addTemplate) {
        this.addTemplate = addTemplate;
    }

    @JsonProperty
    public String getMultiplyTemplate() {
        return multiplyTemplate;
    }

    @JsonProperty
    public void setMultiplyTemplate(String multiplyTemplate) {
        this.multiplyTemplate = multiplyTemplate;
    }

    @JsonProperty
    public String getDefaultAnswer() {
        return defaultAnswer;
    }

    @JsonProperty
    public void setDefaultAnswer(String name) {
        this.defaultAnswer = name;
    }
}
