package morphology;

import model.PrefixesModel;

/**
 * Created by oliver.eder on 1/16/2017.
 */
public class NumberPrefixDetectorImpl implements NumberPrefixDetector {

    public boolean detect(String token) {
        for (Integer constantPrefixLength : PrefixesModel.prefixesLengthsModelSet) {
            if (token.length() >= constantPrefixLength && modelContainsPrefix(token, constantPrefixLength)) {
                return true;
            }
        }
        return false;
    }

    private boolean modelContainsPrefix(String token, int endIndex) {
        return PrefixesModel.prefixesModelSet.contains(token.substring(0, endIndex));
    }

}
