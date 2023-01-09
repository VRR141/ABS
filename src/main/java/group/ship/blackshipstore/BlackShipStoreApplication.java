package group.ship.blackshipstore;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Order;
import java.util.List;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class BlackShipStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlackShipStoreApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        Converter<List, Boolean> SET_TO_BOOLEAN_CONVERTER =
                mappingContext -> !mappingContext.getSource().isEmpty();
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Order.class, OrderResponseDto.class)
                .addMappings(m -> m.map(src -> src.getArticles(), OrderResponseDto::setArticleList));
        return mapper;
    }
}
