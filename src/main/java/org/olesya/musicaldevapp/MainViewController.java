package org.olesya.musicaldevapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.olesya.musicaldevapp.data.entity.User;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Label currentUserLabel;

    @FXML
    private Button exitButton;

    private User currentUser;

    public void initialize() {
        exitButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) exitButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        currentUserLabel.setText(currentUser.getUserName());
    }
}
