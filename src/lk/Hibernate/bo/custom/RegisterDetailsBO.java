package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.entity.Custom;
import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegisterDetailsBO extends SuperBO {
    List loadRoomIDs() throws SQLException, ClassNotFoundException, IOException;
    Room setRoomData(String id) throws SQLException, ClassNotFoundException, IOException;
    List<Custom> loadAllStudentData(String id) throws SQLException, ClassNotFoundException, IOException;

}
