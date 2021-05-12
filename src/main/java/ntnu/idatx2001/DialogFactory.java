package ntnu.idatx2001;

import javafx.scene.control.Alert;

/**
 * The type Dialog factory.
 */
public class DialogFactory {


    /**
     * Create a new instance of an alert.
     *
     * @param type    the type
     * @param title   the title
     * @param header  the header
     * @param message the message
     * @return the alert
     */
    public Alert createAlert(Alert.AlertType type, String title, String header, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        return alert;
    }
}
