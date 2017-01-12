package tagger;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import model.ConstantWordsModel;
import model.TagsConversionModel;
import tokenizing.Tokenizer;
import tokenizing.TokenizerImpl;

import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by oliver.eder on 1/10/2017.
 */
public class PosTaggerImpl {

    private Properties props;

    private StanfordCoreNLP pipeline;

    private Tokenizer tokenizer = new TokenizerImpl();

    public PosTaggerImpl() {
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
            System.out.println(processedSentence);
            int index = 0;
            for (CoreLabel token : processedSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String tag = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if (!",".equals(tag)) {
                    if (ConstantWordsModel.constantWordsModelMap.containsKey(word)) {
                        stringBuilder.append(ConstantWordsModel.constantWordsModelMap.get(word));
                        if (commaIndexes.contains(index)) {
                            stringBuilder.append(",");
                        }
                        if (index < sentenceLength) {
                            stringBuilder.append(" ");
                        }
                    } else {
                        stringBuilder.append(TagsConversionModel.model.get(tag));
                        if (commaIndexes.contains(index)) {
                            stringBuilder.append(",");
                        }
                        if (index < sentenceLength) {
                            stringBuilder.append(" ");
                        }
                    }
                }
                index++;
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        PosTaggerImpl posTaggerImpl = new PosTaggerImpl();
        String tags = posTaggerImpl.tag("dog is animal");
        System.out.println(tags);
    }
}
