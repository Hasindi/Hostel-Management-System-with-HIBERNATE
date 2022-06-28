package lk.Hibernate.dao.custom;

import lk.Hibernate.dao.SuperDAO;
import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends SuperDAO<Room,String> {
    List setRoomIDs() throws SQLException, ClassNotFoundException, IOException;
}
