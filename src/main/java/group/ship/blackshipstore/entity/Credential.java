//package group.ship.blackshipstore.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "credentials")
//public class Credential {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "login")
//    private String login;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "activity_status")
//    private boolean activityStatus;
//
//    @OneToOne(mappedBy = "credential")
//    private Pirate pirate;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isActivityStatus() {
//        return activityStatus;
//    }
//
//    public void setActivityStatus(boolean activityStatus) {
//        this.activityStatus = activityStatus;
//    }
//
//    public Pirate getPirate() {
//        return pirate;
//    }
//
//    public void setPirate(Pirate pirate) {
//        this.pirate = pirate;
//    }
//}