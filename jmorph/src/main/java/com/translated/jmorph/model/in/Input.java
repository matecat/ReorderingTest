package com.translated.jmorph.model.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.translated.jmorph.model.Metadata;
import java.util.ArrayList;

/**
 * Input object.
 *
 * @author sasha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Input {

    private Metadata metadata;
    @JsonProperty("export_phrases")
    private ArrayList<InPhrase> exportPhrases = new ArrayList<>();

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ArrayList<InPhrase> getExportPhrases() {
        return exportPhrases;
    }

    public void setExportPhrases(ArrayList<InPhrase> exportPhrases) {
        this.exportPhrases = exportPhrases;
    }

}
