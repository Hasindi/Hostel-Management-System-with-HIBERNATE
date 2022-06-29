package lk.Hibernate.dao.custom;

import lk.Hibernate.dao.Supper;
import lk.Hibernate.entity.Custom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegisterDetailsDAO extends Supper {
    List<Custom> loadAllStudentData(String id) throws SQLException, ClassNotFoundException, IOException;
}
