package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment implements Serializable {

    @Id
    @ManyToOne(targetEntity = Driver.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Id
    @ManyToOne(targetEntity = Line.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    @Column(name = "turn_number")
    private int turnNumber;
}