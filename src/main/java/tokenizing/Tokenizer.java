package tokenizing;

import java.util.List;
import java.util.Set;

/**
 * Created by oliver.eder on 1/12/2017.
 */
public interface Tokenizer {

    List<String> getTokens(String sentence);

    Set<Integer> getCommaIndexes(List<String> tokens);
}
