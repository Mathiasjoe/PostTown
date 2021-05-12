module ntnu.idatx2001 {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;

    exports ntnu.idatx2001.model;
    opens ntnu.idatx2001.model to javafx.fxml;
    exports ntnu.idatx2001.ui.controllers;
    opens ntnu.idatx2001.ui.controllers to javafx.fxml;
    exports ntnu.idatx2001.ui.views;
    opens ntnu.idatx2001.ui.views to javafx.fxml;
}