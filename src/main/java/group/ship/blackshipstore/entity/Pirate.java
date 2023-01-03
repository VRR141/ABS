package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pirates")
public class Pirate extends BaseEntity {
    @Column(name = "name")
    private String name;

    /*
    Each Pirate has a Role
    Each Role provides different opportunities
    */
    @ManyToMany(
            cascade = CascadeType.DETACH,
            mappedBy = "pirates",
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "pirates_roles",
            joinColumns = @JoinColumn(name = "pirate_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
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