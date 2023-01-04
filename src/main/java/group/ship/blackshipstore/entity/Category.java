package group.ship.blackshipstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

/*
Category is: Clothes, Weapons, Ships, etc.
 */
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

     /*
    Each Category has list of Items: Треуголка, Бандана, Шляпа etc.
    */
    @OneToMany(mappedBy = "category")
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
