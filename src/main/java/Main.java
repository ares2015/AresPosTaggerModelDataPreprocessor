import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by oliver.eder on 1/10/2017.
 */
public class Main {

    private Properties props;

    private StanfordCoreNLP pipeline;

    public Main() {
        props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos");
        pipeline = new StanfordCoreNLP(props);
    }


    public void tag(String inputSentence) {

        Annotation annotation = new Annotation(inputSentence);
        pipeline.annotate(annotation);
        if (annotation.get(CoreAnnotations.SentencesAnnotation.class).size() > 0) {
            CoreMap processedSentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
            System.out.println(processedSentence);
            for (CoreLabel token : processedSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String tag = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(word);
                System.out.println(tag);
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.tag("this is my first test");
    }
}
