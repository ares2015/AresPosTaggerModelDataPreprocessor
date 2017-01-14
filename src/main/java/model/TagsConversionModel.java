package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oliver.eder on 1/12/2017.
 */
public class TagsConversionModel {

    public static Map<String,String> model = new HashMap<String, String>();

    static {
        model.put(StanfordTags.NOUN, Tags.NOUN);
        model.put(StanfordTags.NOUN_PLURAL, Tags.NOUN);
        model.put(StanfordTags.PROPER_NOUN_SINGULAR, Tags.NOUN);
        model.put(StanfordTags.PROPER_NOUN_PLURAL, Tags.NOUN);

        model.put(StanfordTags.VERB_BASE_FORM, Tags.VERB);
        model.put(StanfordTags.VERB_3RD_PERSON_SINGULAR_PRESENT, Tags.VERB);
        model.put(StanfordTags.VERB_GERUND_PRESENT_PARTICIPLE, Tags.VERB);
        model.put(StanfordTags.VERB_NON_3RD_PERSON_SINGULAR_PRESENT, Tags.VERB);

        model.put(StanfordTags.VERB_PAST_TENSE, Tags.VERB_ED);
        model.put(StanfordTags.VERB_PAST_PARTICIPLE, Tags.VERB_ED);

        model.put(StanfordTags.ADJECTIVE, Tags.ADJECTIVE);
        model.put(StanfordTags.ADJECTIVE_COMPARATIVE, Tags.ADJECTIVE);
        model.put(StanfordTags.ADJECTIVE_SUPERLATIVE, Tags.ADJECTIVE);

        model.put(StanfordTags.ADVERB, Tags.ADVERB);
        model.put(StanfordTags.ADVERB_COMPARATIVE, Tags.ADVERB);
        model.put(StanfordTags.ADVERB_SUPERLATIVE, Tags.ADVERB);

        model.put(StanfordTags.CARDINAL_NUMBER, Tags.NUMBER);

        model.put(StanfordTags.DETERMINER, Tags.DETERMINER);

        model.put(StanfordTags.EXISTENTIAL_THERE, Tags.THERE);

        model.put(StanfordTags.MODAL, Tags.MODAL_VERB);

        model.put(StanfordTags.TO, Tags.TO);

        model.put(StanfordTags.PERSONAL_PRONOUN, Tags.PRONOUN_PERSONAL);

        model.put(StanfordTags.POSSESIVE_PRONOUN, Tags.PRONOUN_POSSESIVE);

        model.put(StanfordTags.WH_PRONOUN, Tags.WH_PRONOUN);

        model.put(StanfordTags.WH_ADVERB, Tags.WH_ADVERB);



        model.put(",", "");

    }
}
