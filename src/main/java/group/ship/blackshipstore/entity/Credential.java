package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

@Entity
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private String password;

    private boolean activityStatus;

    @OneToOne(mappedBy = "credential")
    private Pirate pirate;

    //type of login, password will be changed or not
}
