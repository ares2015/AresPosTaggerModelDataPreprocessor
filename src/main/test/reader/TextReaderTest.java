package reader;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Oliver on 1/16/2017.
 */
public class TextReaderTest {

    @Test
    public void test(){
        TextReader textReader = new TextReaderImpl();
        List<String> sentences = textReader.read();
        assertTrue(sentences.size() > 0);
        assertEquals("Night of January 16th is a play by Russian-American author Ayn Rand, inspired by the death of Ivar Kreuger, an industrialist and accused swindler known as the Match King",
                sentences.get(0));
    }
}
