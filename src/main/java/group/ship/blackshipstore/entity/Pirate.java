package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pirates")
public class Pirate extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    /*
    Each Pirate has a Role
    Each Role provides different opportunities
    */
    @ManyToMany(
            targetEntity = Role.class,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "pirates_roles",
            joinColumns = @JoinColumn(name = "pirate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "pirate",
            fetch = FetchType.LAZY)
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}