package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.RoomBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dto.RoomDTO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;


public class RoomBOImpl implements RoomBO {

    RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.add(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return roomDAO.delete(id);
    }
}
