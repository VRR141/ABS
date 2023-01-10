package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.ItemResponseDto;
import group.ship.blackshipstore.sevices.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@PreAuthorize("hasAnyAuthority('Капитан', 'Помощник Капитана')")
@Tag(name = "Item Controller", description = "Controller to work with items")
public class AdminItemController {
    private final ItemService itemService;

    @Autowired
    public AdminItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @Operation(summary = "Get items", description = "return all items")
    public List<ItemResponseDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get items by category", description = "return all items")
    public List<ItemResponseDto> getAllItemsByCategoryId(@PathVariable Long categoryId) {
        return itemService.findAllByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get item", description = "return item by id")
    public ItemResponseDto getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }
}
