package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextReaderImpl implements TextReader {

    public List<String> read() {
        List<String> sentences = null;
        String wholeText = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TaggerRawTextData.txt"));
//            br = new BufferedReader(new FileReader("C:\\Users\\oliver.eder\\Documents\\TaggerRawTextData.txt"));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String rawTextDataRow = br.readLine();
            while (rawTextDataRow != null) {
                if(!"".equals(rawTextDataRow)){
                    wholeText += rawTextDataRow;
                    rawTextDataRow += " ";
                }
                rawTextDataRow = br.readLine();
            }
            sentences = Arrays.asList(wholeText.split("[\\.\\!\\?\\:]"));

        } catch (final IOException e) {
            e.printStackTrace();

        }
        return sentences;
    }
}








