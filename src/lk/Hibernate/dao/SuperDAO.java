package lk.Hibernate.dao;


import lk.Hibernate.entity.Super;

import java.sql.SQLException;
import java.util.List;

public interface SuperDAO<Entity extends Super,ID> {
    public boolean add(Entity entity) throws Exception;
    public boolean update(Entity entity) throws Exception;
    public boolean delete(ID id) throws Exception;
    public Entity find(ID id) throws Exception;
    public List<Entity> findAll() throws Exception;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
