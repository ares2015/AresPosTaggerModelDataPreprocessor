package tokenizing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oliver.eder on 1/12/2017.
 */
public class TokenizerImpl implements Tokenizer {

    public List<String> getTokens(String sentence) {
        return Arrays.asList(sentence.split("\\ "));
    }

    public Set<Integer> getCommaIndexes(List<String> tokens) {
        Set<Integer> indexes = new HashSet<Integer>();
        int index = 0;
        for (String token : tokens) {
            if (token.endsWith(",")) {
                indexes.add(index);
            }
            index++;
        }
        return indexes;
    }


}
