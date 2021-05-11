package ntnu.idatx2001;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    private PostTownRegister postTownRegister;
    private ObservableList<PostTown> observableList;

    @FXML private TableView<PostTown> viewDetails;
    @FXML private TableColumn<PostTown, String> postCodeCol;
    @FXML private TableColumn<PostTown, String> cityCol;
    @FXML private TableColumn<PostTown, String> munCol;

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

    public ObservableList<PostTown> filterList(String searchText){
        List<PostTown> list = postTownRegister.getTowns();
        List<PostTown> filteredList = new ArrayList<>();
        for (PostTown postTown : list){
            if(searchOrder(postTown, searchText)) filteredList.add(postTown);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchOrder(PostTown postTown, String searchText){
        return (postTown.getPostalCode().toLowerCase().contains(searchText.toLowerCase())) ||
                (postTown.getCity().toLowerCase().contains(searchText.toLowerCase()));
    }

}
