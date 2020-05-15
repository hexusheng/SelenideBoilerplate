package helpers;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CsvDataProvider {

    public static Object[][] getCsvData(String fileName) {

        String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "dataproviders" + File.separator + fileName + ".csv";

        File file = new File(pathname);

        try {

            CSVReader reader = new CSVReader(new FileReader(file));

            // SKIP HEADERS
            reader.readNext();

            ArrayList<Object[]> csvList = new ArrayList<Object[]>();
            String[] csvRow = null;

            while ((csvRow = reader.readNext()) != null) {
                csvList.add(csvRow);
            }

            Object[][] results = new Object[csvList.size()][];

            for (int i = 0; i < csvList.size(); i++) {
                results[i] = csvList.get(i);
            }

            return results;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
        } catch (Exception e) {
            throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
        }

    }
}


