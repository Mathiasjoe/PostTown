module ntnu.idatx2001 {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;

    opens ntnu.idatx2001 to javafx.fxml;
    exports ntnu.idatx2001;
}