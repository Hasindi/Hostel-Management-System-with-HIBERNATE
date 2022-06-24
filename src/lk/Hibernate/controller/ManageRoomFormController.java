package lk.Hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ManageRoomFormController {
    public TableView tblAllRooms;
    public TableColumn colId;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQTY;
    public TextField txtSearchId;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtId;
    public JFXTextField txtRoomType;
    public JFXTextField txtQTY;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;

    public void SearchOnKeyReleased(KeyEvent keyEvent) {
    }

    public void TextFieldsReleased(KeyEvent keyEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
    }
}
