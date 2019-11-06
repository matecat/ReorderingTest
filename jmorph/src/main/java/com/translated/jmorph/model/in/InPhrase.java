package com.translated.jmorph.model.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 * Phrase object.
 *
 * @author sasha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InPhrase {

    @JsonProperty("collection_name")
    private String collectionName;
    private String value;
    @JsonProperty("source_locale")
    private String sourceLocale;
    @JsonProperty("target_locales")
    private ArrayList<TargetLocale> targetLocales = new ArrayList<>();
    @JsonProperty("created_at")
    private Date createdAt;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSourceLocale() {
        return sourceLocale;
    }

    public void setSourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
    }

    public ArrayList<TargetLocale> getTargetLocales() {
        return targetLocales;
    }

    public void setTargetLocales(ArrayList<TargetLocale> targetLocales) {
        this.targetLocales = targetLocales;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
