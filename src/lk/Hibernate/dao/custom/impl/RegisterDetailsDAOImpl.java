package lk.Hibernate.dao.custom.impl;

import lk.Hibernate.dao.custom.RegisterDetailsDAO;
import lk.Hibernate.entity.Custom;
import lk.Hibernate.entity.Room;
import lk.Hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegisterDetailsDAOImpl implements RegisterDetailsDAO {
    @Override
    public List<Custom> loadAllStudentData(String id) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT reg.registerID, reg.date, s.studentId, s.name, s.contactNo FROM Reservation reg INNER JOIN Student s ON reg.student=s.studentId WHERE reg.room=:Room");
        query.setParameter("Room",session.load(Room.class, id) );
        
        List<Object[]>list = query.list();

        ArrayList<Custom> allDetails = new ArrayList<>();
        for (Object[] objects : list) {
            allDetails.add(new Custom(
                    objects[0].toString(),
                    LocalDate.parse(objects[1].toString()),
                    objects[2].toString(),
                    objects[3].toString(),
                    objects[4].toString()
            ));
        }

        transaction.commit();
        return null;
    }
}