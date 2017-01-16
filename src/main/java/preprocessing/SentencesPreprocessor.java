package preprocessing;

import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public interface SentencesPreprocessor {

    List<String> preprocess(List<String> sentences);

}
