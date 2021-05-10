package ntnu.idatx2001.ui.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import ntnu.idatx2001.ui.views.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
