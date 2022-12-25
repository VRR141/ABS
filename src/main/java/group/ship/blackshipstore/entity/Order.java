package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Pirate.class, fetch = FetchType.LAZY)
    private Pirate pirate;

    @ManyToOne(targetEntity = Status.class, fetch = FetchType.LAZY)
    private Status status;

    private LocalDateTime orderDate;

    private LocalDateTime completedDate;

}
