package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.RegisterDetailsBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dao.custom.impl.RegisterDetailsDAOImpl;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;
import lk.Hibernate.entity.Custom;
import lk.Hibernate.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDetailsBOImpl implements RegisterDetailsBO {

    RoomDAOImpl roomDAO = (RoomDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    RegisterDetailsDAOImpl registerDetailsDAO = (RegisterDetailsDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTERDETAILS);

    @Override
    public List loadRoomIDs() throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.setRoomIDs();
    }

    @Override
    public Room setRoomData(String id) throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.find(id);
    }

    @Override
    public List<Custom> loadAllStudentData(String id) throws SQLException, ClassNotFoundException, IOException {
        List<Custom> list = registerDetailsDAO.loadAllStudentData(id);
        ArrayList<Custom> customArrayList = new ArrayList<>();

        for (Custom studentDetails : list) {
            customArrayList.add(studentDetails);
        }
        return customArrayList;
    }
}
