package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface ReservationBO extends SuperBO {
    List setStudentIDs() throws SQLException,ClassNotFoundException;
    List setRoomIDs() throws SQLException,ClassNotFoundException;
    Student setStudentsData() throws SQLException,ClassNotFoundException;
    Room setRoomsData() throws SQLException,ClassNotFoundException;
    String generateNewRegisterId() throws SQLException,ClassNotFoundException;
}
