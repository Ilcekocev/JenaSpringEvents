package mk.ukim.finki.wbs.jena_event.repository;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.tdb.TDBFactory;

import java.io.File;

/**
 * Created by Ilce on 7/13/2017.
 */
public class TdbHelper {

    private static final int MB = 1024 * 1024;
    private String datasetDirectoryPrefix="data/db";
    private Dataset dataset;


    public void openDataset() {
        if (dataset != null) {
            dataset.close();
        }
        dataset = loadDataset();
    }

    public void closeDataset() {
        dataset.close();
        dataset = null;
    }

    public Dataset getDataset() {
        return dataset;
    }


    private Dataset loadDataset() {
        String directory = datasetDirectoryPrefix;
        return TDBFactory.createDataset(directory);
    }
}
