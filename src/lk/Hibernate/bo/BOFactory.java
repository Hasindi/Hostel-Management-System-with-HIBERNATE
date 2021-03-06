package lk.Hibernate.bo;

import lk.Hibernate.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    //singleton
    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    //public final static integer values
    public enum BOTypes {
        STUDENT,ROOM,RESERVATION,REGISTERDETAILS,USER
    }

    //method for hide the object creation logic and return what client wants
    public SuperBO getBO(BOTypes boType){
        switch (boType){
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case REGISTERDETAILS:
                return new RegisterDetailsBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
