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
public class RoomDTO {
    @Id
    private String roomId;
    private String type;
    private double keyMoney;
    private int qty;
}
