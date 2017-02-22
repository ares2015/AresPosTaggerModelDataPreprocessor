package tagger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/14/2017.
 */
public class PosTaggerTest {

    @Test
    public void test(){
        PosTagger posTagger = new PosTagger();

        assertEquals("N N Ved N N PR N PR NR ", posTagger.tag("George Bush met Vladimir Putin in Bratislava in 2005"));

        assertEquals("N PR N N MV NOT V N PR N ", posTagger.tag("players of Slovak team could not score goal against Russia"));

        assertEquals("N IA N ", posTagger.tag("dog is animal"));

        assertEquals("N MV V AV AV ", posTagger.tag("dogs can smell very well"));

        assertEquals("AJ N V AJ ", posTagger.tag("smaller dogs live longer"));

        assertEquals("Q N IA Ved PR N ", posTagger.tag("all dogs are descended from wolves"));

        assertEquals("DET AJ Ved N PR DET AJ N IA PR NR N PR PR N ", posTagger.tag("the earliest known fossil of a domestic dog is from 31700 years ago in Belgium"));

        assertEquals("N MV V AJ PR AJ N CJ N ", posTagger.tag("dogs can see better in dim light than humans"));

        assertEquals("N IA DET N PR N N ", posTagger.tag("USA is a country in North America"));

        assertEquals("DET N N V DET N N TO V DET N N ", posTagger.tag("the Ottawa Redblacks defeat the Calgary Stampeders to win the Grey Cup"));

        assertEquals("N IA AV AJ, Ving DET AV AJ N ", posTagger.tag("Raphael was enormously productive, running an unusually large workshop"));

        assertEquals("N IA Ved PR DET AJ CJ AV AJ AJ N N PR N PR DET N N ", posTagger.tag("Raphael was born in the small but artistically significant central Italian city of Urbino in the Marche region"));

        assertEquals("PR DET N PR NR, N Ved TO N, WAV PRP Ved PR DET N PR PRPS N ", posTagger.tag("by the end of 1508, Raphael moved to Rome, where he lived for the rest of his life"));

        assertEquals("N N IA Ved PR Q AJ AJ N WP V PR DET N PR N PR Q NR PR N ", posTagger.tag("Earth's lithosphere is divided into several rigid tectonic plates that migrate across the surface over periods of many millions of years"));

        assertEquals("DET AJ N Ved PR DET N N IA Ved TO NR NR N PR ", posTagger.tag("the oldest material found in the Solar System is dated to 4.5672 billion years ago"));

        assertEquals("DET Q N V N, Ving WP PRPS AV AJ N IA Ved PR N Ved TO V DET N N ", posTagger.tag("a few scholars defend Louis, arguing that his highly negative reputation was based on propaganda meant to justify the French Revolution"));

        assertEquals("PR N NR, N N N N AV Ved ", posTagger.tag("in April 1711, Louis Le Grand Dauphin suddenly died"));

        assertEquals("PR N N N, N IA V PR DET N PR N WAV PRP Ved PRPS NR N ", posTagger.tag("by French royal tradition, princes were put in the care of men when they reached their seventh birthdays"));

        assertEquals("DET N PR DET N PR N V N WP Ved PR AJ AJ AO AJ N PR N ", posTagger.tag("the ministry of the Duke of Bourbon pursue policies that resulted in serious economic and social problems in France"));

        assertEquals("PR DET N, WAV, N N AV Ved N, AO N IA Ved PR AV PR NR ", posTagger.tag("in the west, however, French troops rapidly overran Lorraine, and peace was restored as early as 1735"));

        assertEquals("DET N N Ved PR N PR PRP Ved ", posTagger.tag("The queen’s eyes filled with tears as she answered"));
    }
}
