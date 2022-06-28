package lk.Hibernate.bo;

import lk.Hibernate.bo.custom.impl.ReservationBOImpl;
import lk.Hibernate.bo.custom.impl.RoomBOImpl;
import lk.Hibernate.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    //singleton
    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    //public final static integer values
    public enum BOTypes {
        STUDENT,ROOM,RESERVATION
    }

    //method for hide the object creation logic and return what client wants
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            default:
                return null;
        }
    }
}
