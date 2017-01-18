package tokenizing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oliver.eder on 1/17/2017.
 */
public class TokenizerTest {

    Tokenizer tokenizer = new TokenizerImpl();

    @Test
    public void testRemoveTextReferenceBrackets() {
        String testString = "[22][23]abc def";
        assertEquals("abc def", tokenizer.removeBrackets(testString, '[', ']'));
    }

    @Test
    public void testRemoveNestedSentenceBrackets() {
        String testString = "ab (c) d";
        assertEquals("ab  d", tokenizer.removeBrackets(testString, '(', ')'));
    }

    @Test
    public void testRemoveDoubleQuotes() {
        System.out.println("\"king's ships\"");
        assertEquals("king's ships", tokenizer.removeDoubleQuotes("\"king's ships\""));
        System.out.println(tokenizer.removeDoubleQuotes("\"king's ships\""));
    }

    @Test
    public void testRemoveEmptyStrings() {
        assertEquals("a bc d e", tokenizer.removeEmptyStrings("a   bc  d e"));
        System.out.println(tokenizer.removeEmptyStrings("a   bc  d e"));
//        assertEquals("bob dylan and bryan drink beer", tokenizer.removeEmptyStrings("bob\u0000 dylan and bryan drink beer"));
        System.out.println(tokenizer.removeEmptyStrings("bob\u0000 dylan and bryan drink beer"));
    }

    @Test
    public void testRemoveSemicolon(){
        assertEquals("test test", tokenizer.removeSemicolon("test; test"));
    }

    @Test
    public void testReplaceApostrophedSSuffix(){
        assertEquals("it 's ok", tokenizer.replaceApostrophedSSuffix("it's ok"));
    }

    @Test
    public void testReplaceApostrophedReSuffix(){
        assertEquals("they 're ok", tokenizer.replaceApostrophedReSuffix("they're ok"));
    }

    @Test
    public void testReplaceApostrophedVeSuffix(){
        assertEquals("I 've got it", tokenizer.replaceApostrophedVeSuffix("I've got it"));
    }

}
