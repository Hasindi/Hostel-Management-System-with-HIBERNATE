package lk.Hibernate.dao.custom.impl;

import lk.Hibernate.dao.custom.RoomDAO;
import lk.Hibernate.entity.Room;
import lk.Hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room room) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public Room find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Room> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }



   /* @Override
    public boolean add(Room room) throws SQLException, ClassNotFoundException, IOException {
        *//*Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();
        return true;*//*
        return false;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException, IOException {
        *//*Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(room);

        transaction.commit();
        session.close();*//*
        return true;
    }

    @Override
    public boolean delete(String s) throws  IOException {
        *//*Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class, s);
        session.delete(room);

        transaction.commit();
        session.close();*//*
        return true;
    }

    @Override
    public Room find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Room> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exists(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }*/
}
