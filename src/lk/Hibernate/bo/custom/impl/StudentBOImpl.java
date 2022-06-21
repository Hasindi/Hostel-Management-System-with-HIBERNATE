package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.StudentBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dao.custom.impl.StudentDAOImpl;
import lk.Hibernate.dto.StudentDTO;
import lk.Hibernate.entity.Student;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(
                new Student(
                        studentDTO.getStudentId(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getContactNo(),
                        studentDTO.getDob(),
                        studentDTO.getGender()
                )
        );
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(
                new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContactNo(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }
}
