package ro.siit.io;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class ReadInput {
    private static Logger logger = Logger.getLogger("log.txt");
    /**
     * Reads data from a csv file found on resources folder
     * and separate's the content by line and commas
     * The content is injected into the Athlete object on a sorted
     * Tree Set.
     * @return a Tree Set with all athlete data
     */
    public static Set<Athlete> readInputData(){
        final String COMMA_DELIMITER = ",";

        Set<Athlete> records = new TreeSet<>(new Sorter());
        try (BufferedReader br = new BufferedReader(new FileReader("D:/Java-Dev/incercariio/src/main/resources/input_date.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.info("Reading input data by line");
                String[] values = line.split(COMMA_DELIMITER);
                Athlete entry = new Athlete(Integer.valueOf(values[0]), values[1], values[2], values[3], values[4], values[5], values[6]);
                records.add(entry);
                logger.info("Input data succesfully added to Athlete object.");
            }
        } catch (FileNotFoundException e){
            logger.severe("The file is not Found or the path to file is incorrect!");
        } catch(IOException e){
            logger.severe("Can't read file! Format or layout is incorrect!");
        }
        return records;
    }
}
