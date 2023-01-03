package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Category is: Одежда, Протез, Оружие, etc.
 */
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
     /*
    Each Category has list of Items: Треуголка, Бандана, Шляпа etc.
    */
    @OneToMany(mappedBy = "category")
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<Item> items;

    @Column(name = "name")
    private String name;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
