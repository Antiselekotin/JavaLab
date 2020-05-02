package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.model.Lift;

import java.io.IOException;

public class Controller {
    Lift lift = new Lift();

    @FXML
    private Button button3;

    @FXML
    private Button button8;

    @FXML
    private Button button1;

    @FXML
    private Button button4;

    @FXML
    private Button button7;

    @FXML
    private Button button6;

    @FXML
    private Button button5;

    @FXML
    private Button button2;

    @FXML
    private Button button9;

    @FXML
    private Button buttonX;

    @FXML
    private Text floor;

    @FXML
    private Text door;

    @FXML
    void initialize() {
        lift = new Lift(floor, door);
        Button[] buttonArr = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        buttonX.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/settings.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        for (int i = 0; i < buttonArr.length; i++) {
            int finalI = i;
            buttonArr[i].setOnAction(event -> {
                lift.getTimerTool().PushTask(finalI + 1);
            });
        }
    }
}