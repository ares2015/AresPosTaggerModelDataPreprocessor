package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public class PreprocessedDataFileWriterImpl implements PreprocessedDataFileWriter {

    //    private static final String FILENAME = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\NlpTrainingData.txt";
    private static final String FILENAME = "C:\\Users\\oliver.eder\\Documents\\NlpTrainingData.txt";

    public void write(List<String> trainingDataRowList) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            int numberOfCorrectSentences = 0;
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            for (String trainingDataRow : trainingDataRowList) {
                if (!trainingDataRow.contains("null")) {
                    bw.write(trainingDataRow);
                    bw.newLine();
                    numberOfCorrectSentences++;
                    System.out.println(trainingDataRow);
                }
            }
            System.out.println(numberOfCorrectSentences + " sentences were written into the file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}