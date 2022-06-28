package lk.Hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.Hibernate.bo.BOFactory;
import lk.Hibernate.bo.custom.ReservationBO;

import java.io.IOException;
import java.sql.SQLException;

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

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize(){
        try{
            loadAllStudentIDs();
            loadAllRoomIDs();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void loadAllRoomIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbRoomID.getItems().addAll(reservationBO.setRoomIDs());
    }

    private void loadAllStudentIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbStudentID.getItems().addAll(reservationBO.setStudentIDs());
    }

    public void RegisterOnAction(ActionEvent actionEvent) {
    }
}
