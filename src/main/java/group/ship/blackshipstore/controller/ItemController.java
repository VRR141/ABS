package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.ItemResponseDto;
import group.ship.blackshipstore.sevices.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemResponseDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ItemResponseDto> getAllItemsByCategoryId(@PathVariable Long categoryId) {
        return itemService.findAllByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public ItemResponseDto getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }
}
