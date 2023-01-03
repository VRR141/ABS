package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.ItemDto;
import group.ship.blackshipstore.sevices.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<ItemDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/all/category/{id}")
    public List<ItemDto> getAllItemsyCategoryId(Long categoryId) {
        return itemService.findAllByCategoryId(categoryId);
    }
}
