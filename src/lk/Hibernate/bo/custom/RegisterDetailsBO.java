package lk.Hibernate.bo.custom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegisterDetailsBO {
    List loadRoomIDs() throws SQLException, ClassNotFoundException, IOException;

}
