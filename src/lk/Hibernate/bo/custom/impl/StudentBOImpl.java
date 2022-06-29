package lk.Hibernate.bo.custom.impl;

import lk.Hibernate.bo.custom.StudentBO;
import lk.Hibernate.dao.DAOFactory;
import lk.Hibernate.dao.custom.impl.StudentDAOImpl;
import lk.Hibernate.dto.StudentDTO;
import lk.Hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException {
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
    public boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException {
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
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> loadAllStudents() throws SQLException, ClassNotFoundException, IOException {
        List<Student> students = studentDAO.loadAll();
        ArrayList<StudentDTO> arrayList = new ArrayList<>();
        for (Student student : students) {
            arrayList.add(new StudentDTO(
                    student.getStudentId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNo(),
                    student.getDob(),
                    student.getGender()
            ));
        }
        return arrayList;
    }
}
