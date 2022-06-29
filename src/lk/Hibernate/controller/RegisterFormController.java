package lk.Hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.Hibernate.bo.BOFactory;
import lk.Hibernate.bo.custom.ReservationBO;
import lk.Hibernate.dto.ReservationDTO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RegisterFormController {
    public JFXTextField txtRegisterNo;
    public JFXTextField txtRegisterdate;
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
            generateNewRegisterId();
            loadDate();
        }catch(Exception e){
            e.printStackTrace();
        }

        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try{

                setStudentData(newValue);

            }catch (Exception e){
                e.printStackTrace();
            }
        });

        cmbRoomID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try{

                setRoomData(newValue);
                roomAvilability(newValue);

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void roomAvilability(String id) throws SQLException, IOException, ClassNotFoundException {
    }

    private void loadDate() {
        txtRegisterdate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    private void generateNewRegisterId() {
        try{
            txtRegisterNo.setText(reservationBO.generateNewRegisterId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setRoomData(String id) throws SQLException, ClassNotFoundException, IOException {
        Room room = reservationBO.setRoomsData(id);
        txtRoomType.setText(room.getType());
        txtKeyMoney.setText(String.valueOf(room.getKeyMoney()));
        txtQuntity.setText(String.valueOf(room.getQty()));

    }

    private void setStudentData(String id) throws SQLException, ClassNotFoundException, IOException {
        Student student = reservationBO.setStudentsData(id);
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtContactNo.setText(student.getContactNo());
        txtDOB.setText(String.valueOf(student.getDob()));
        txtGender.setText(student.getGender());

    }

    private void loadAllRoomIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbRoomID.getItems().addAll(reservationBO.setRoomIDs());
    }

    private void loadAllStudentIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbStudentID.getItems().addAll(reservationBO.setStudentIDs());
    }

    public void RegisterOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        if(reservationBO.registerStudent(new ReservationDTO(
                txtRegisterNo.getText(),
                LocalDate.parse(txtRegisterdate.getText()),
                cmbStudentID.getValue(),
                cmbRoomID.getValue(),
                txtAvilability.getText()
        ))){
            new Alert(Alert.AlertType.CONFIRMATION,"Data Added Succussfully...!!!").showAndWait();

        }else{
            new Alert(Alert.AlertType.WARNING,"UnSuccussfully...!!!").showAndWait();

        }
        generateNewRegisterId();
        clearText();
    }

    private void clearText() {
        cmbRoomID.setValue(null);
        cmbStudentID.setValue(null);
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDOB.clear();
        txtGender.clear();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQuntity.clear();
        txtAvilability.setText("");
    }
}
