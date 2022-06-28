package lk.Hibernate.dao.custom.impl;

import lk.Hibernate.dao.custom.ReservationDAO;
import lk.Hibernate.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public boolean add(Reservation reservation) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public Reservation find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Reservation> loadAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
