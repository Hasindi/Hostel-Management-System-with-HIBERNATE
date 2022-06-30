package lk.Hibernate.dao;

import lk.Hibernate.dao.custom.impl.*;

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
        STUDENT,ROOM,RESERVATION,REGISTERDETAILS
    }

    //method for hide the object creation logic and return what client wants
    public Supper getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case REGISTERDETAILS:
                return new RegisterDetailsDAOImpl();
            default:
                return null;
        }
    }

}