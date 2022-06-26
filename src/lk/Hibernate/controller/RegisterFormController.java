package lk.Hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterFormController {
    public JFXTextField txtRegisterNo;
    public JFXTextField txtRegisterdate;
    public TextField txtLastCustomerId;
    public TextField txtContactNo;
    public TextField txtName;
    public ComboBox<String> cmbStudentID;
    public TextField txtDOB;
    public TextField txtAddress;
    public TextField txtGender;
    public TextField txtQuntity;
    public TextField txtRoomType;
    public ComboBox<String> cmbRoomID;
    public TextField txtKeyMoney;
    public Label txtAvilability;
    public JFXButton btnRegister;


    public void RegisterOnAction(ActionEvent actionEvent) {
    }
}
