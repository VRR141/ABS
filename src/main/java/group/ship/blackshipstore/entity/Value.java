package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "values")
public class Value extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private Attribute attribute;

    // TODO: Rename column "value_name" to "name"
    @Column(name = "name")
    private String name;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
