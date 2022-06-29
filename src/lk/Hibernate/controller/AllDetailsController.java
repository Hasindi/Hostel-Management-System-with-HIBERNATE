package lk.Hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.Hibernate.bo.BOFactory;
import lk.Hibernate.bo.custom.ReservationBO;
import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;

public class AllDetailsController {
    public TableView tblRegisterDetails;
    public TableColumn colRegId;
    public TableColumn colRegDate;
    public TableColumn colSId;
    public TableColumn colSName;
    public TableColumn colContact;
    public TableColumn colOption;
    public JFXTextField txtRoomType;
    public JFXComboBox<String> cmbRoomId;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQuntity;

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize(){
        try{
            loadAllRoomIDs();
        }catch(Exception e){
            e.printStackTrace();
        }

        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try{

                setRoomData(newValue);

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void setRoomData(String id) throws SQLException, IOException, ClassNotFoundException {
        Room room = reservationBO.setRoomsData(id);
        txtRoomType.setText(room.getType());
        txtKeyMoney.setText(String.valueOf(room.getKeyMoney()));
        txtQuntity.setText(String.valueOf(room.getQty()));
    }

    private void loadAllRoomIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbRoomId.getItems().addAll(reservationBO.setRoomIDs());
    }

}
