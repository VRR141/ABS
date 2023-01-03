package group.ship.blackshipstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @ManyToMany(mappedBy = "roles")
    private List<Pirate> pirates;

    @Column(name = "name")
    private String name;

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}