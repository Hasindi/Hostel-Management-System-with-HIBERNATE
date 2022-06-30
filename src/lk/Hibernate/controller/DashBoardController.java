package lk.Hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.Hibernate.bo.BOFactory;
import lk.Hibernate.bo.custom.ReservationBO;
import lk.Hibernate.bo.custom.RoomBO;
import lk.Hibernate.bo.custom.StudentBO;
import lk.Hibernate.bo.custom.impl.StudentBOImpl;
import lk.Hibernate.dto.ReservationDTO;
import lk.Hibernate.dto.StudentDTO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.util.NavigationUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DashBoardController implements NavigationUtil {

    public AnchorPane AdminDashBoardContext;
    public Label lblStudentCount;
    public Label lblRoomAvilableCount1;
    public Label lblRoomReseivedCount1;
    public Label lblTotalIncome;
    public Label lblDay;
    public Label lblDate;
    public Label lblTime;
    public Button btnDashboard;
    public Button btnStudent;
    public Button btnRoom;
    public Button btnRegister;
    public Button btnReport1;
    public AnchorPane loardFormContext;
    public Label lblAllRooms;
    public JFXComboBox<String> cmbRoomIds;

    private final RoomBO roomBO = (RoomBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize() {
        try {
            loadAllDashLabels();
            DateTime();
            setRoomIDs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cmbRoomIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                Room room = null;

                try {

                    room = roomBO.getRoom(newValue);

                } catch (SQLException | ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
                int roomQTY = room.getQty();
                lblAllRooms.setText(String.valueOf(roomQTY));

                try {

                    List<ReservationDTO> reservationDTOS = reservationBO.reservedRoomByTD(newValue);

                    int registerCount = 0;
                    for (ReservationDTO reservationDTO : reservationDTOS) {
                        registerCount++;
                    }
                    int remaindQuntity = roomQTY-registerCount;
                    lblRoomReseivedCount1.setText(String.valueOf(registerCount));
                    lblRoomAvilableCount1.setText(String.valueOf(remaindQuntity));

                } catch (SQLException | ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setRoomIDs() throws SQLException, IOException, ClassNotFoundException {
        cmbRoomIds.getItems().addAll(reservationBO.setRoomIDs());
    }

    private void loadAllDashLabels() throws SQLException, IOException, ClassNotFoundException {
    }

    private void DateTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();

            lblDay.setText(LocalDate.now().getDayOfWeek().toString());
            lblDate.setText(currentDate.getYear()+"-"+ currentDate.getMonthValue()
                    +"-"+ currentDate.getDayOfMonth());

            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":"+ currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void LogoutOnAction(ActionEvent actionEvent) {
    }

    public void DashboardOnAction(ActionEvent actionEvent) throws IOException {
        CloseWindowUi(AdminDashBoardContext);
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void StudentOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("ManageStudentForm");
    }

    public void RoomOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("ManageRoomForm");
    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("RegisterForm");
    }

    public void ReportOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("AllDetails");
    }

    @Override
    public void loadUi(String location) throws IOException {
        loardFormContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"));
        loardFormContext.getChildren().add(parent);
    }

    @Override
    public void CloseWindowUi(AnchorPane a) throws IOException {
        Stage stage= (Stage)a.getScene().getWindow();
        stage.close();
    }
}
