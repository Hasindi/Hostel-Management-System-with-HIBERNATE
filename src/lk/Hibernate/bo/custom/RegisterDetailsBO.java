package lk.Hibernate.bo.custom;

import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegisterDetailsBO {
    List loadRoomIDs() throws SQLException, ClassNotFoundException, IOException;
    Room setRoomData(String id) throws SQLException, ClassNotFoundException, IOException;

}
