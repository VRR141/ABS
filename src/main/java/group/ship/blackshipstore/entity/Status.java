package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private List<Order> orders;
}
