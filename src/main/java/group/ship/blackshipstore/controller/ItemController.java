package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.ItemResponseDTO;
import group.ship.blackshipstore.sevices.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Item Controller", description = "Controller to get Items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    @Operation(summary = "Get all Items", description = "Return list of all Items")
    public List<ItemResponseDTO> getItems() {
        return itemService.findAll();
    }

}
