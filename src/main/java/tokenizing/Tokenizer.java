package tokenizing;

import java.util.List;
import java.util.Set;

/**
 * Created by oliver.eder on 1/12/2017.
 */
public interface Tokenizer {

    List<String> getTokens(String sentence);

    Set<Integer> getCommaIndexes(List<String> tokens);

    String removeBrackets(String string, char bracket1, char bracket2);

    String removeDoubleQuotes(String sentence);

    String removeEmptyStrings(String sentence);

    String removeSemicolon(String sentence);

    String replaceApostrophedSSuffix(String sentence);

    String replaceApostrophedReSuffix(String sentence);

    String replaceApostrophedVeSuffix(String sentence);
}
