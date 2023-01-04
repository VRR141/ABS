package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "values")
public class Value extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Attribute.class)
    @JoinTable(
            name = "factory",
            joinColumns = @JoinColumn(name = "value_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Attribute attribute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
