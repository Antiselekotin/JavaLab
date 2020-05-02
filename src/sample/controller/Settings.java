package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.model.Lift;

public class Settings {
    private Lift lift = new Lift();
    @FXML
    private Text CURRENT_SPEED;

    @FXML
    private TextField SET_SPEED;

    @FXML
    private Button SPEED_BUTTON;

    @FXML
    private Text ErrorText;

    @FXML
    void initialize() {
        lift.getSpeedBar().changeUI(CURRENT_SPEED);
        SPEED_BUTTON.setOnAction(event -> {
            try {
                 Integer i =  new Integer(SET_SPEED.getText());
                 if (i > 10) {
                     ErrorText.setText("Слишком Быстро, до 10");
                     SET_SPEED.setText("");
                 } else if (i <= 0) {
                     ErrorText.setText("Это как?");
                     SET_SPEED.setText("");
                 }
                 else {
                    lift.getSpeedBar().setState(i);
                    SPEED_BUTTON.getScene().getWindow().hide();

                 }
            } catch (NumberFormatException e) {
                SET_SPEED.setText("");
                ErrorText.setText(lift.getErrorMessage().toString());
            }

        });
    }

}
