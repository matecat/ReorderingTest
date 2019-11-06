package com.translated.jmorph.model.out;

import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * Test for consolidation logic.
 *
 * @author sasha
 */
public class OutputTest {

    @Test
    public void testConsolidate() {
        System.out.println("consolidate");
        Output instance = new Output();
        // TODO better test accumulation and consolidation logic
        OutPhrase phrase = new OutPhrase();
        phrase.setValue("some");
        phrase.setCreatedAt(new Date());
        instance.addPhrase("one", phrase);
        instance.consolidate();
    }

}
