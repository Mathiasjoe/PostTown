package ntnu.idatx2001;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.opencsv.exceptions.CsvException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class PrimaryController implements Initializable {

    private PostTownRegister postTownRegister;
    private ObservableList<PostTown> observableList;

    @FXML private TableView<PostTown> viewDetails;
    @FXML private TableColumn<PostTown, String> postCodeCol;
    @FXML private TableColumn<PostTown, String> cityCol;
    @FXML private TableColumn<PostTown, String> munCol;
    @FXML private TextField searchField;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.postTownRegister = new PostTownRegister();
        this.fillWithDummies();

        postCodeCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
        munCol.setCellValueFactory(new PropertyValueFactory<>("Municipality"));

        this.observableList = FXCollections.observableArrayList(this.postTownRegister.getTowns());
        viewDetails.setItems(this.observableList);

    }

    private PostTownRegister fillWithDummies(){

        postTownRegister.addNewPostTown(new PostTown("6005", "Ålesund", "Ålesund"));
        postTownRegister.addNewPostTown(new PostTown("9602", "Hammerfest", "Hammerfest"));
        postTownRegister.addNewPostTown(new PostTown("9690", "Havøysund", "Måsøy"));
        postTownRegister.addNewPostTown(new PostTown("9515", "Alta", "Alta"));

        return postTownRegister;
    }

    private void updateObservableList(){
        this.observableList.setAll(this.postTownRegister.getTowns());
    }

    @FXML public void searchThroughList(KeyEvent actionEvent){
        FilteredList<PostTown> filteredData = new FilteredList<>(observableList, p -> true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(postTown -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return (postTown.getPostalCode().toLowerCase().contains(lowerCaseFilter)) ||
                    (postTown.getCity().toLowerCase().contains(lowerCaseFilter));

            });
        });
        SortedList<PostTown> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(viewDetails.comparatorProperty());
        viewDetails.setItems(sortedData);
    }

    /**
     * Import file.
     *
     * @throws IOException  the io exception
     */
    @FXML public void importFile() throws IOException, CsvException {
        String path;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();
        } else {
            path = null;
        }
        System.out.println(path);
        postTownRegister.readFile(path);
        this.updateObservableList();
    }





}
