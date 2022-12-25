package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pirate_id")
    private List<Order> orders;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pirate_id")
    private Credential credential;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "piretes_roles",
            joinColumns = @JoinColumn(name = "pirate_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
