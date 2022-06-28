package lk.Hibernate.dao.custom;

import lk.Hibernate.dao.SuperDAO;
import lk.Hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends SuperDAO<Student,String> {
    List setRoomIDs() throws SQLException, ClassNotFoundException, IOException;
}
