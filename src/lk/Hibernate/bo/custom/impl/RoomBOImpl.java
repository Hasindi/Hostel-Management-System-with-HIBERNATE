package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.RoomBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dto.RoomDTO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomBOImpl implements RoomBO {

    RoomDAOImpl roomDAO = (RoomDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.add(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.update(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
    }

    @Override
    public boolean delete(String id) throws IOException {
        return roomDAO.delete(id);
    }

    @Override
    public List<RoomDTO> loadAllRooms() throws SQLException, ClassNotFoundException, IOException {
        List<Room> rooms = roomDAO.loadAll();
        ArrayList<RoomDTO> arrayList = new ArrayList<>();
        for (Room room : rooms) {
           arrayList.add(new RoomDTO(
                 room.getRoomId(),
                 room.getType(),
                 room.getKeyMoney(),
                 room.getQty()
           ));
        }
        return arrayList;
    }
}
