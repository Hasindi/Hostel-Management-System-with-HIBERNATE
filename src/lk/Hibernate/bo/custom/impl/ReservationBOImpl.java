package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.ReservationBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;
import lk.Hibernate.dao.custom.impl.StudentDAOImpl;
import lk.Hibernate.entity.Room;
import lk.Hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List setStudentIDs() throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.setRoomIDs();
    }

    @Override
    public List setRoomIDs() throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.setRoomIDs();
    }

    @Override
    public Student setStudentsData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Room setRoomsData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewRegisterId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
