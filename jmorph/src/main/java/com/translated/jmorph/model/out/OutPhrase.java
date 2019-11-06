package com.translated.jmorph.model.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Output phrase object.
 *
 * @author sasha
 */
public class OutPhrase implements Comparable<OutPhrase> {

    private String value;
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'")
    private Date createdAt;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(OutPhrase o) {
        return createdAt.compareTo(o.getCreatedAt());
    }

}
