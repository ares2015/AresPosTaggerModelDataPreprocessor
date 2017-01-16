package tokenizing;

import java.util.*;

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

    public String removeBrackets(String token, char bracket1, char bracket2) {
        StringBuilder filteredSentence = new StringBuilder();
        char[] chars = token.toCharArray();
        boolean isNestedSequence = false;
        for (int i = 0; i < chars.length; i++) {
            if (bracket1 == chars[i]) {
                isNestedSequence = true;
            } else if (bracket2 == chars[i]) {
                isNestedSequence = false;
            } else if (bracket1 != chars[i] && !isNestedSequence) {
                filteredSentence.append(String.valueOf(chars[i]));
            }
        }
        return filteredSentence.toString();
    }

    public String removeDoubleQuotes(String string) {
        return string.replace("\"", "");
    }

    public String removeEmptyStrings(String string) {
        List<String> list = Arrays.asList(string.split("\\ "));
        final List<String> newList = new ArrayList<String>();
        StringBuilder newString = new StringBuilder();
        for (final String s : list) {
            if (!(s.equals(""))) {
                newList.add(s);
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            newString.append(newList.get(i));
            if (i < newList.size() - 1) {
                newString.append(" ");
            }
        }
        return newString.toString();
    }


}
