package lk.Hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class StudentDTO {
    @Id
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

}
