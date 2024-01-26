package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientFormController {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox txtMassageBox;

    @FXML
    private TextField txtMessage;

    @FXML
    private Text txtName;

    private Socket socket;

    private DataInputStream dataInputStream;

    private DataOutputStream dataOutputStream;

    private String clientName = "Client";

    @FXML
    void btnAttachmentOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmojiOnAction(ActionEvent event) {

    }

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }

    @FXML
    void txtMessageOnAction(ActionEvent event) {

    }

    public void setClientName(String name) {
        clientName = name;
    }

    public void shutdown() {
       // ServerFormController.receiveMessage(clientName+" left.");
    }
}
