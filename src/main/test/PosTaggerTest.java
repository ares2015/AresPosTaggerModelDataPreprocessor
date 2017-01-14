import org.junit.Test;
import tagger.PosTagger;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/14/2017.
 */
public class PosTaggerTest {

    @Test
    public void test(){
        PosTagger posTagger = new PosTagger();

        assertEquals("N N Ved N N PR N PR NR", posTagger.tag("George Bush met Vladimir Putin in Bratislava in 2005"));

        assertEquals("N PR N N MV NOT V N PR N", posTagger.tag("players of Slovak team could not score goal against Russia"));

        assertEquals("N IA N", posTagger.tag("dog is animal"));

        assertEquals("N MV V AV AV", posTagger.tag("dogs can smell very well"));

        assertEquals("AJ N V AJ", posTagger.tag("smaller dogs live longer"));

        assertEquals("Q N IA Ved PR N", posTagger.tag("all dogs are descended from wolves"));

        assertEquals("DET AJ Ved N PR DET AJ N IA PR NR N PR PR N", posTagger.tag("the earliest known fossil of a domestic dog is from 31700 years ago in Belgium"));

        assertEquals("N MV V AJ PR AJ N CJ N", posTagger.tag("dogs can see better in dim light than humans"));

        assertEquals("N IA DET N PR N N", posTagger.tag("USA is a country in North America"));

        assertEquals("DET N N V DET N N TO V DET N N", posTagger.tag("the Ottawa Redblacks defeat the Calgary Stampeders to win the Grey Cup"));




    }
}
