package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.dto.RoomDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface RoomBO extends SuperBO {
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException;
}
