module ntnu.idatx2001 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ntnu.idatx2001 to javafx.fxml;
    exports ntnu.idatx2001;
    exports ntnu.idatx2001.Model;
    opens ntnu.idatx2001.Model to javafx.fxml;
    exports ntnu.idatx2001.ui.Controllers;
    opens ntnu.idatx2001.ui.Controllers to javafx.fxml;
    exports ntnu.idatx2001.ui.views;
    opens ntnu.idatx2001.ui.views to javafx.fxml;
}