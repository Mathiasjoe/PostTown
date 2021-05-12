package ntnu.idatx2001;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Post town register.
 */
public class PostTownRegister {

    private ArrayList<PostTown> towns;

    /**
     * Instantiates a new Post town register.
     */
    public PostTownRegister(){
        this.towns = new ArrayList<>();
    }

    /**
     * Add new town to the register.
     *
     * @param town the town
     */
    public void addNewPostTown(PostTown town){
        if(town == null){
            throw new IllegalArgumentException("Town cannot be null");
        }
        this.towns.add(town);
    }

    /**
     * Get the list of all the towns in the register.
     *
     * @return the array list
     */
    public ArrayList<PostTown> getTowns(){
        return towns;
    }

    /**
     * Remove the Town from the register.
     *
     * @param town the town
     */
    public void removePostTown(PostTown town){
        if(this.towns.contains(town)){
            this.towns.remove(town);
        }else{
            throw new IllegalArgumentException("Town does not exist");
        }
    }
    public void readFile (String pathToFile) throws IOException, CsvException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(pathToFile)).withCSVParser(csvParser).withSkipLines(1).build()) {
            List<String[]> readList = reader.readAll();
            System.out.println(readList.get(0)[0]);
            readList.forEach(index -> this.towns.add(new PostTown(index[0],index[1],index[2])));
        }
    }



}
