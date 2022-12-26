package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.sevices.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping()
    public List<Item> getItems() {
        return itemService.findAll();
    }

}
