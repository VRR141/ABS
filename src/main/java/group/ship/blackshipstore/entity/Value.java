package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "values")
public class Value {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value_name" )
    private String valueName;

    @OneToMany(mappedBy = "value")
    List<Article> articleList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id",referencedColumnName = "id")
    private Attribute attribute;

    public Value() {
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
