package lk.Hibernate.dao.custom.impl;

import lk.Hibernate.dao.custom.ReservationDAO;
import lk.Hibernate.entity.Reservation;
import lk.Hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public boolean add(Reservation reservation) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(reservation);

        transaction.commit();
        session.close();
        return true;
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

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT registerID FROM Reservation ORDER BY registerID desc Limit 1");
        transaction.commit();
        if (query.isCacheable()) {
            String id = query.getCacheRegion();
            int newRegisterId = Integer.parseInt(id.replace("REG-", "")) + 1;
            return String.format("REG-%03d", newRegisterId);
        } else {
            return "REG-001";
        }
    }

    @Override
    public String roomAvilability(String id) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
