package com.translated.jmorph.model.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * Output JSON collection object.
 *
 * @author sasha
 */
public class Collection {

    private String name;
    @JsonProperty("export_phrases")
    private ArrayList<OutPhrase> exportPhrases = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OutPhrase> getExportPhrases() {
        return exportPhrases;
    }

    public void setExportPhrases(ArrayList<OutPhrase> exportPhrases) {
        this.exportPhrases = exportPhrases;
    }

}
