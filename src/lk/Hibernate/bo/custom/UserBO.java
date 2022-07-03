package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    public boolean update(UserDTO userDTO) throws SQLException, ClassNotFoundException, IOException;

    List<UserDTO> loadAllUsers() throws SQLException, ClassNotFoundException, IOException;
}
