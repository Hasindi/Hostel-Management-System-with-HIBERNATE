package lk.Hibernate.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.Hibernate.util.NavigationUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public void initialize() {
        DateTime();

        /*try {
            loadAllDashLabels();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
    }

    private void loadAllDashLabels() {
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
