package com.translated.jmorph;

import com.translated.jmorph.model.in.InPhrase;
import com.translated.jmorph.model.in.Input;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;

/**
 * Program unit tests.
 *
 * @author sasha
 */
public class MainTest {

    public MainTest() {
    }

    @org.junit.jupiter.api.Test
    public void testUnmarshall() {
        System.out.println("unmarshall");
        Input result = Main.unmarshall();
        Assertions.assertNotNull(result.getMetadata());
        ArrayList<InPhrase> exportPhrases = result.getExportPhrases();
        Assertions.assertFalse(exportPhrases.isEmpty());
    }

}
