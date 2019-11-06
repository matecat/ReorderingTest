package com.translated.jmorph.model.out;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.translated.jmorph.model.Metadata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * JSON output object.
 *
 * @author sasha
 */
public class Output {

    private Metadata metadata;
    private ArrayList<Collection> collections = new ArrayList<>();
    @JsonIgnore
    private Map<String, SortedSet<OutPhrase>> accumMap = new HashMap<>();

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ArrayList<Collection> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<Collection> collections) {
        this.collections = collections;
    }

    public void addPhrase(String collectionName, OutPhrase phrase) {
        accumMap.putIfAbsent(collectionName, new TreeSet<>());
        accumMap.get(collectionName).add(phrase);
    }

    public void consolidate() {
        // sorts collections by name
        for (String collName : new TreeSet<>(accumMap.keySet())) {
            // build collection object from already sorted accumulated output phrases
            Collection coll = new Collection();
            coll.setName(collName);
            coll.setExportPhrases(new ArrayList<>(accumMap.get(collName)));
            collections.add(coll);
        }
    }
}
