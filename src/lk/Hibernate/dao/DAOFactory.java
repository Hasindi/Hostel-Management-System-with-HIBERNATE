package lk.Hibernate.dao;

import lk.Hibernate.dao.custom.impl.RoomDAOImpl;
import lk.Hibernate.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    //singleton
    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    //public final static integer values
    public enum DAOTypes {
        STUDENT,ROOM
    }

    //method for hide the object creation logic and return what client wants
    public <T extends SuperDAO> T getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            default:
                return null;
        }
    }

}