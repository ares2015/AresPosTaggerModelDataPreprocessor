package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextReaderImpl implements TextReader {

    public List<String> read() {
        List<String> sentences = new ArrayList<String>();
        String wholeText = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TaggerRawTextData.txt"));
//            br = new BufferedReader(new FileReader("C:\\Users\\oled\\Documents\\TaggerRawTextData.txt"));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String sentence = br.readLine();
            while (sentence != null) {
                if (!"".equals(sentence)) {
                    sentences.add(sentence);
                }
                sentence = br.readLine();
            }
        } catch (final IOException e) {
            e.printStackTrace();

        }
        return sentences;
    }
}








