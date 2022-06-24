package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.RoomBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dto.RoomDTO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.dao.custom.impl.RoomDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class RoomBOImpl implements RoomBO {

    RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    /*@Override
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        *//*return roomDAO.add(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));*//*
        return true;
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        *//*return roomDAO.update(
                new Room(
                        roomDTO.getRoomId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));*//*
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        *//*return roomDAO.delete(id);*//*
        return true;
    }*/
}
