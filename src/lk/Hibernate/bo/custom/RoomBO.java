package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.dto.RoomDTO;
import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RoomBO extends SuperBO {
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException;

    List<RoomDTO> loadAllRooms() throws SQLException, ClassNotFoundException, IOException;

    public Room getRoom(String id) throws SQLException, ClassNotFoundException, IOException;
}
