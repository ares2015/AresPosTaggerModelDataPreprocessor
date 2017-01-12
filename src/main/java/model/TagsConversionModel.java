package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oliver.eder on 1/12/2017.
 */
public class TagsConversionModel {

    public static Map<String,String> model = new HashMap<String, String>();

    static {
        model.put("NN", Tags.NOUN);
    }
}
