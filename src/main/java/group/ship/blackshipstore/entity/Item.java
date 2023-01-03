package group.ship.blackshipstore.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

/*
Item is: Треуголка, Бандана, Рубашка
 */
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    // TODO: Rename column "item_name" to "name"
    @Column(name = "item_name")
    private UUID name;

    /*
    Each Item has list of Attributes
    Each Attribute may belong to different Items
    Each Attribute has list of Values
    */
    @ManyToMany(mappedBy = "items")
    @JoinTable(
            name = "item_attributes",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    List<Attribute> attributes;

    /*
    Each Item has unique Category
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getName() {
        return name;
    }

    public void setName(UUID name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
