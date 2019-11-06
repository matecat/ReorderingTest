package com.translated.jmorph;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.translated.jmorph.model.Metadata;
import com.translated.jmorph.model.in.InPhrase;
import com.translated.jmorph.model.in.Input;
import com.translated.jmorph.model.in.TargetLocale;
import com.translated.jmorph.model.out.OutPhrase;
import com.translated.jmorph.model.out.Output;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private static final String SOURCE_URL = "http://www.mocky.io/v2/5db8a72230000064005edf0d";

    public static void main(String[] args) {
        Input in = unmarshall();
        Map<String, Output> outMap = new HashMap<>();
        // scan input model
        for (InPhrase inPhrase : in.getExportPhrases()) {
            for (TargetLocale targetLocale : inPhrase.getTargetLocales()) {
                final String tgtLoc = targetLocale.getLocale();
                if (!outMap.containsKey(tgtLoc)) {
                    // initialize new output model for new target locale
                    final Output output = new Output();
                    Metadata meta = new Metadata();
                    meta.setTargetLocale(tgtLoc);
                    meta.setSourceLocale(inPhrase.getSourceLocale());
                    output.setMetadata(meta);
                    outMap.put(tgtLoc, output);
                }
                Output out = outMap.get(tgtLoc);
                // accumulate an output phrase in output object for given target locale
                OutPhrase outPhrase = new OutPhrase();
                outPhrase.setValue(inPhrase.getValue());
                outPhrase.setCreatedAt(inPhrase.getCreatedAt());
                out.addPhrase(inPhrase.getCollectionName(), outPhrase);
            }
        }
        // consolidate and serialize
        for (Output out : outMap.values()) {
            out.consolidate();
            marshall(out);
        }
    }

    /**
     * Retrieves URL and unmarshall JSON into object model.
     *
     * @return Input object
     */
    public static Input unmarshall() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            final URL url = new URL(SOURCE_URL);
            return mapper.readValue(url, Input.class);
        } catch (MalformedURLException ex) {
            LOG.log(Level.SEVERE, "Malformed URL", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "IO problem", ex);
        }
        return null;
    }

    /**
     * Serialize output object to file with indentation and according to target
     * locale.
     *
     * @param out
     */
    private static void marshall(Output out) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String fname = String.format("output_%s.json", out.getMetadata().getTargetLocale());
        try {
            mapper.writeValue(new File(fname), out);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "IO problem", ex);
        }
    }

}
