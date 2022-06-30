package lk.Hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXButton btnLogIn;
    public JFXPasswordField pwdPassword;
    public AnchorPane loginContext;

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("admin") & pwdPassword.getText().equals("1234") || txtUserName.getText().equals("cashier")& pwdPassword.getText().equals("4567") ){
            Stage stage=(Stage) loginContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"))));
            stage.centerOnScreen();
        }else{
            new Alert(Alert.AlertType.WARNING,"Invalid Login...!").show();
        }
    }
}
