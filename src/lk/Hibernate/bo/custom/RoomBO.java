package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.dto.RoomDTO;

public interface RoomBO extends SuperBO {
    public boolean add(RoomDTO roomDTO)throws Exception;

    public boolean update(RoomDTO roomDTO)throws Exception;

    public boolean delete(String id)throws Exception;
}
