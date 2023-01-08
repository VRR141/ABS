//package group.ship.blackshipstore.utils;
//
//import group.ship.blackshipstore.dto.response.ArticleResponseDto;
//import group.ship.blackshipstore.dto.response.ItemResponseDto;
//import group.ship.blackshipstore.dto.response.OrderResponseDto;
//import group.ship.blackshipstore.entity.Article;
//import group.ship.blackshipstore.entity.Item;
//import group.ship.blackshipstore.entity.Order;
//import group.ship.blackshipstore.entity.Status;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderMapper {
//
//    public static OrderResponseDto mapToDTO(Order order){
//        Status orderStatus = order.getStatus();
//        List<Article> articleList = order.getArticles();
//        LocalDate orderStart = order.getOrderDate();
//        LocalDate orderEnd = order.getCompletedDate();
//
////        OrderResponseDto orderResponseDto = new OrderResponseDto();
////        orderResponseDto.setStatus(orderStatus);
//////        orderResponseDto.setArticleList(articleList);
////        orderResponseDto.setOrderDate(orderStart);
////        orderResponseDto.setCompletedDate(orderEnd);
////        return orderResponseDto;
//    }
////
////    private static ArticleResponseDto mapArticles(Article article){
////        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
////        articleResponseDto.setAmount(article.getAmount());
////        articleResponseDto.setPrice(article.getPrice());
////        article.getItems().stream().map(item -> itemResponseDto(item));
////
////
////    }
//
//    private static ItemResponseDto itemResponseDto(Item item){
//        ItemResponseDto itemResponseDto = new ItemResponseDto();
//        itemResponseDto.setName(item.getName());
//        return itemResponseDto;
//    }
//
//
//
//}
