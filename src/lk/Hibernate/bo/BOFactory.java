package lk.Hibernate.bo;

import lk.Hibernate.dao.custom.impl.StudentDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    //singleton
    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    //public final static integer values
    public enum BOTypes {
        STUDENT
    }

    //method for hide the object creation logic and return what client wants
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            default:
                return null;
        }
    }
}
