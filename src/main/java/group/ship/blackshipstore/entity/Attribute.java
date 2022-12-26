package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attribute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "attribute_name")
    private String attributeName;

    public Attribute() {
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    private List<Value> valueList;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
