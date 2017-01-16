package writer;

import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public interface PreprocessedDataFileWriter {

    void write(List<String> trainingDataRowList);

}
