package lk.Hibernate.dao.custom;

import lk.Hibernate.dao.SuperDAO;
import lk.Hibernate.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;

public interface ReservationDAO extends SuperDAO<Reservation,String> {
    String generateNewId() throws SQLException, ClassNotFoundException, IOException;
}
