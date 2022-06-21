package lk.Hibernate.bo.custom;

import lk.Hibernate.bo.SuperBO;
import lk.Hibernate.dto.StudentDTO;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO)throws Exception;

    public boolean update(StudentDTO studentDTO)throws Exception;

    public boolean delete(String id)throws Exception;

}
