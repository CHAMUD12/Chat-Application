package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    private final String adminUserName = "abc";
    private final String adminPassword = "1022";

    private String enteredUserName;
    private String enteredPassword;

    public void initialize(){
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        enteredUserName = txtName.getText();
        enteredPassword = txtPassword.getText();

        if (!enteredUserName.isEmpty() && enteredUserName.matches("[A-Za-z0-9]+")) {
            try {
                boolean useIsExist = UserModel.isExistUser(enteredUserName, enteredPassword);
                if (useIsExist) {
                    navigateToClientWindow();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid credentials").show();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else if (enteredUserName.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your name").show();
        }
    }

    @FXML
    void hyperRegisterOnAction(ActionEvent event) throws IOException {
        if (adminUserName.equals(txtName.getText()) && adminPassword.equals(txtPassword.getText())) {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/register_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("User Registration");
            stage.centerOnScreen();
            stage.show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid credentials for registration").show();
        }
    }

    private void navigateToClientWindow() throws IOException {

        if (!enteredUserName.isEmpty() && enteredUserName.matches("[A-Za-z0-9]+" )) {
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/client_form.fxml"));

            ClientFormController controller = new ClientFormController();
            controller.setClientName(txtName.getText());
            fxmlLoader.setController(controller);

            primaryStage.setScene(new Scene(fxmlLoader.load()));
            primaryStage.setTitle(txtName.getText());
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.setOnCloseRequest(windowEvent -> {
                controller.shutdown();
            });
            primaryStage.show();

            txtName.clear();
            txtPassword.clear();

        } else {
            new Alert(Alert.AlertType.ERROR, "Please enter your name").show();
        }
    }
}
