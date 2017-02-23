package preprocessing;


import tokenizing.Tokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public class SentencePreprocessorImpl implements SentencesPreprocessor {

    private Tokenizer tokenizer;

    public SentencePreprocessorImpl(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public List<String> preprocess(List<String> sentences) {
        List<String> processedSentences = new ArrayList<String>();
        for (String sentence : sentences) {
            if (sentence.contains("(")) {
                sentence = tokenizer.removeBrackets(sentence, '(', ')');
            }
            if (sentence.contains("[")) {
                sentence = tokenizer.removeBrackets(sentence, '[', ']');
            }
            if (sentence.contains("{")) {
                sentence = tokenizer.removeBrackets(sentence, '{', '}');
            }
            if (sentence.contains("\"")) {
                sentence = tokenizer.removeDoubleQuotes(sentence);
            }
            if (sentence.contains(";")) {
                sentence = tokenizer.removeSemicolon(sentence);
            }
//            if (sentence.contains("'s")) {
//                sentence = tokenizer.replaceApostrophedSSuffix(sentence);
//            }
//            if (sentence.contains("'re")) {
//                sentence = tokenizer.replaceApostrophedReSuffix(sentence);
//            }
//            if (sentence.contains("'ve")) {
//                sentence = tokenizer.replaceApostrophedVeSuffix(sentence);
//            }
            sentence = tokenizer.removeEmptyStrings(sentence);
            processedSentences.add(sentence);
        }
        return processedSentences;
    }
}
