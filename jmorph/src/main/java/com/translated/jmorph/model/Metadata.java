package com.translated.jmorph.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metadata header object.
 *
 * @author sasha
 */
public class Metadata {

    @JsonProperty("source_locale")
    private String sourceLocale;
    @JsonProperty("target_locale")
    private String targetLocale;

    public String getSourceLocale() {
        return sourceLocale;
    }

    public void setSourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
    }

    public String getTargetLocale() {
        return targetLocale;
    }

    public void setTargetLocale(String targetLocale) {
        this.targetLocale = targetLocale;
    }

}
