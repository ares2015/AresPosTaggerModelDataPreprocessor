package tagger;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import model.ConstantWordsModel;
import model.StanfordTags;
import model.Tags;
import model.TagsConversionModel;
import morphology.NumberPrefixDetector;
import morphology.NumberPrefixDetectorImpl;
import tokenizing.Tokenizer;
import tokenizing.TokenizerImpl;

import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by oliver.eder on 1/10/2017.
 */
public class PosTagger {

    private Properties props;

    private StanfordCoreNLP pipeline;

    private Tokenizer tokenizer = new TokenizerImpl();

    private NumberPrefixDetector numberPrefixDetector = new NumberPrefixDetectorImpl();

    public PosTagger() {
        props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos");
        pipeline = new StanfordCoreNLP(props);
    }


    public String tag(String inputSentence) {
        List<String> tokens = tokenizer.getTokens(inputSentence);
        Set<Integer> commaIndexes = tokenizer.getCommaIndexes(tokens);
        int sentenceLength = tokens.size();
        StringBuilder stringBuilder = new StringBuilder();
        Annotation annotation = new Annotation(inputSentence);
        pipeline.annotate(annotation);
        if (annotation.get(CoreAnnotations.SentencesAnnotation.class).size() > 0) {
            CoreMap processedSentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
            int index = 0;
            for (CoreLabel stfToken : processedSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = stfToken.get(CoreAnnotations.TextAnnotation.class);
                String tag = stfToken.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if (!",".equals(tag) && !StanfordTags.POSSESIVE_ENDING.equals(tag) && !"n't".equals(word)) {
                    if (numberPrefixDetector.detect(word)) {
                        stringBuilder.append(Tags.NUMBER);
                        if (commaIndexes.contains(index)) {
                            stringBuilder.append(",");
                        }
                        if (index <= sentenceLength - 1) {
                            stringBuilder.append(" ");
                        }
                    } else {
                        if (index > 0 && !Tags.PRONOUN_PERSONAL.equals(tag) && Character.isUpperCase(word.charAt(0))) {
                            stringBuilder.append(Tags.NOUN);
                            if (commaIndexes.contains(index)) {
                                stringBuilder.append(",");
                            }
                            if (index <= sentenceLength - 1) {
                                stringBuilder.append(" ");
                            }
                        } else {
                            String token = tokens.get(index);
                            if (token.contains(",")) {
                                token = tokenizer.removeCommaAndDot(token);
                            }
                            if (ConstantWordsModel.constantWordsModelMap.containsKey(tokenizer.decapitalize(token))) {
                                stringBuilder.append(ConstantWordsModel.constantWordsModelMap.get(tokenizer.decapitalize(token)));
                                if (commaIndexes.contains(index)) {
                                    stringBuilder.append(",");
                                }
                                if (index <= sentenceLength - 1) {
                                    stringBuilder.append(" ");
                                }
                            } else {
                                stringBuilder.append(TagsConversionModel.model.get(tag));
                                if (commaIndexes.contains(index)) {
                                    stringBuilder.append(",");
                                }
                                if (index <= sentenceLength - 1) {
                                    stringBuilder.append(" ");
                                }
                            }

                        }
                    }
                    index++;
                }
            }
        }
        return stringBuilder.toString();
    }

}
