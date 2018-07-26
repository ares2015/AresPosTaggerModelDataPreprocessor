package main;

import preprocessing.SentencePreprocessorImpl;
import preprocessing.SentencesPreprocessor;
import reader.TextReader;
import reader.TextReaderImpl;
import tagger.PosTagger;
import tokenizing.Tokenizer;
import tokenizing.TokenizerImpl;
import writer.PreprocessedDataFileWriter;
import writer.PreprocessedDataFileWriterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 1/16/2017.
 */
public class AresPosTaggerModelDataPreprocessor {

    public TextReader textReader = new TextReaderImpl();

    public Tokenizer tokenizer = new TokenizerImpl();

    public SentencesPreprocessor sentencesPreprocessor = new SentencePreprocessorImpl(tokenizer);

    public PosTagger posTagger = new PosTagger();

    public PreprocessedDataFileWriter preprocessedDataFileWriter = new PreprocessedDataFileWriterImpl();


    public static void main(String[] args) {
        List<String> trainingDataRowList = new ArrayList<String>();
        AresPosTaggerModelDataPreprocessor aresPosTaggerModelDataPreprocessor = new AresPosTaggerModelDataPreprocessor();
        List<String> sentences = aresPosTaggerModelDataPreprocessor.textReader.read();
        List<String> preprocessedSentences = aresPosTaggerModelDataPreprocessor.sentencesPreprocessor.preprocess(sentences);
        for (String sentence : preprocessedSentences) {
            if (!"#".equals(sentence) && !"".equals(sentence)) {
                String tagSequence = aresPosTaggerModelDataPreprocessor.posTagger.tag(sentence);
                String trainingDataRow = sentence + "#" + tagSequence;
                trainingDataRowList.add(trainingDataRow);
            }
        }
        aresPosTaggerModelDataPreprocessor.preprocessedDataFileWriter.write(trainingDataRowList);
    }


}
