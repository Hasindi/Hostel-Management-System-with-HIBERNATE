package lk.Hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private String registerID;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student studentID;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room roomID;

    private String status;

    public Reservation() {
    }

    public Reservation(String registerID, LocalDate date, Student studentID, Room roomID, String status) {
        this.registerID = registerID;
        this.date = date;
        this.studentID = studentID;
        this.roomID = roomID;
        this.status = status;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "registerID='" + registerID + '\'' +
                ", date=" + date +
                ", studentID=" + studentID +
                ", roomID=" + roomID +
                ", status='" + status + '\'' +
                '}';
    }
}
