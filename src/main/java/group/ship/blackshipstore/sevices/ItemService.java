package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.ItemResponseDto;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    /*
    Mapping Item entity to ItemDto
     */
    private final Function<Item, ItemResponseDto> itemDtoFunction = entity -> {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(entity.getId());
        itemResponseDto.setName(entity.getName());
//        itemResponseDto.setAttributes(entity.getAttributes());
//        itemResponseDto.getCategory(entity.getCategory());
        return itemResponseDto;
    };

    public List<ItemResponseDto> findAll() {
        return itemRepository.findAll().stream()
                .map(itemDtoFunction)
                .toList();
    }

    public List<ItemResponseDto> findAllByCategoryId(Long categoryId) {
        return itemRepository.findAllByCategoryId(categoryId).stream()
                .map(itemDtoFunction)
                .toList();
    }

    public ItemResponseDto findById(Long id) {
        return itemRepository.findById(id).map(itemDtoFunction).orElse(null);
    }
}
