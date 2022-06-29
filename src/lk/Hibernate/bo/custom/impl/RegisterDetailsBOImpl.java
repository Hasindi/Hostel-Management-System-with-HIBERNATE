package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.RegisterDetailsBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegisterDetailsBOImpl implements RegisterDetailsBO {

    RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List loadRoomIDs() throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.setRoomIDs();
    }
}
