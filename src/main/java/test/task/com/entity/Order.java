package test.task.com.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@javax.persistence.Entity
@Table(name = "order", schema = "med_center")
public class Order implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    @Column(name = "name_of_manipulation")
    private String nameOfManipulation;
    private String status = "in progress";
    private String startTime;
    private String endTime;

    @OneToOne
    @JoinColumn(name = "id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "id")
    private Worker worker;

}
