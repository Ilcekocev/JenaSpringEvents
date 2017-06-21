package mk.ukim.finki.wbs.jena_event.repository;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;

/**
 * @author Riste Stojanov
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
