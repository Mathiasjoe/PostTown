package ntnu.idatx2001.model;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Post town register.
 */
public class PostTownRegister {

    private final ArrayList<PostTown> towns;

    /**
     * Instantiates a new Post town register.
     */
    public PostTownRegister() {
        this.towns = new ArrayList<>();
    }

    /**
     * Add a new town to the register.
     *
     * @param town the town
     * @Throws an IllegalArgumentException if the added Post Town is null.
     */
    public void addNewPostTown(PostTown town) {
        if (town == null) {
            throw new IllegalArgumentException("Town cannot be null");
        }
        this.towns.add(town);
    }

    /**
     * Get the list of all the towns in the register.
     *
     * @return the array list
     */
    public ArrayList<PostTown> getTowns() {
        return towns;
    }

    /**
     * Remove the Town from the register.
     *
     * @param town the town
     * @Throws an IllegalArgumentException if the Post town we are trying to remove isn't in the register.
     */
    public void removePostTown(PostTown town) {
        if (this.towns.contains(town)) {
            this.towns.remove(town);
        } else {
            throw new IllegalArgumentException("Town does not exist");
        }
    }

    /**
     * Read file the file that get imported. Split the Lines with tab(\t), And use the chosen file path.
     * Also set the Standard Character Set to UTF-8, so we can read the Norwegian letters Æ, Ø and Å.
     * Use the Index 0, 1 and 3 to get the correct elements from the imported list added to our Table.
     *
     * @param pathToFile the path to file
     * @throws IOException  the io exception
     * @throws CsvException the csv exception
     */
    public void readFile(String pathToFile) throws IOException, CsvException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(pathToFile, StandardCharsets.UTF_8)).withCSVParser(csvParser).withSkipLines(1).build()) {
            List<String[]> readList = reader.readAll();
            System.out.println(readList.get(0)[0]);
            readList.forEach(index -> this.towns.add(new PostTown(index[0], index[1], index[3])));
        }
    }


}
