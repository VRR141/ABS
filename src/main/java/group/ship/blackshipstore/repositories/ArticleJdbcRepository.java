package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.dto.response.LonelyArticle;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class ArticleJdbcRepository {

    private HashMap<Long, List<String>> attributes;

    private HashMap<Long, List<String>> values;

    private List<LonelyArticle> lonelyArticles;

    private HashMap<Long, LonelyArticle> result;

    public ArticleJdbcRepository() {
        attributes = new HashMap<>();
        values = new HashMap<>();
        lonelyArticles = new ArrayList<>();
        result = new HashMap<>();
    }

    public List<LonelyArticle> getAllArticles(){
        resultize();
        var res = result.values();
        List<LonelyArticle> resRes = new ArrayList<>();
        for (LonelyArticle lonelyArticle: res){
            resRes.add(lonelyArticle);
        }
        clean();
        return resRes;
    }

    private void clean(){
        attributes.clear();
        values.clear();
        lonelyArticles.clear();
        result.clear();
    }

    public LonelyArticle getArticle(Long id){
        resultize();
        LonelyArticle lonelyArticle = result.get(id);
        clean();
        return lonelyArticle;
    }

    private final String query = "select articles.id,\n" +
            "       articles.amount,\n" +
            "       articles.price,\n" +
            "       i.name as item_name,\n" +
            "       i.id as item_id,\n" +
            "       a.name as attribute_name,\n" +
            "       a.id as attribute_id,\n" +
            "       v.name as value_name,\n" +
            "       v.id as value_id\n" +
            "from articles\n" +
            "         join factory f on articles.id = f.article_id\n" +
            "         join items i on f.item_id = i.id\n" +
            "         join attributes a on f.attribute_id = a.id\n" +
            "         join values v on f.value_id = v.id\n" +
            "ORDER BY amount DESC;";

    private Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/black_ship",
                    "blackshipdeveloper",
                    "Mgy4Xn1Wkeul");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet getResultSet(){
        try {
            Statement statement = getConnection().createStatement();
            statement.execute(query);
            ResultSet resultSet  = statement.getResultSet();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void parse(){
        ResultSet resultSet = getResultSet();
        try {
            while (resultSet.next()) {
                LonelyArticle lonelyArticle = new LonelyArticle();
                Long id = (Long) resultSet.getObject("id");
                int amount = (int) resultSet.getObject("amount");
                Long price = (long) resultSet.getObject("price");
                String itemName = String.valueOf(resultSet.getObject("item_name"));
                String attributeName = String.valueOf(resultSet.getObject("attribute_name"));
                String valueName = String.valueOf(resultSet.getObject("value_name"));

                lonelyArticle.setId(id);
                lonelyArticle.setAmount(amount);
                lonelyArticle.setPrice(price);
                lonelyArticle.setItemName(itemName);

                if (attributes.containsKey(id)) {
                    if (attributes.get(id) == null) {
                        List<String> attr = new ArrayList<>();
                        attr.add(attributeName);
                        attributes.put(id, attr);
                    } else {
                        attributes.get(id).add(attributeName);
                    }
                } else {
                    List<String> attr = new ArrayList<>();
                    attr.add(attributeName);
                    attributes.put(id, attr);
                }

                if (values.containsKey(id)) {
                    if (values.get(id) == null) {
                        List<String> val = new ArrayList<>();
                        val.add(valueName);
                        values.put(id, val);
                    } else {
                        values.get(id).add(valueName);
                    }
                } else {
                    List<String> val = new ArrayList<>();
                    val.add(valueName);
                    values.put(id, val);
                }

                lonelyArticles.add(lonelyArticle);
            }
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    private void resultize() {
        parse();
        for (LonelyArticle lonelyArticle : lonelyArticles) {
            var id = lonelyArticle.getId();
            List<String> attrs = attributes.get(id);
            List<String> vals = values.get(id);
            lonelyArticle.setAttributeNames(attrs);
            lonelyArticle.setValueNames(vals);
            if (result.containsKey(id)) {
                continue;
            }
            result.put(id, lonelyArticle);
        }
    }

}
