package co.zero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Document(value = "models")
@Getter
@Setter
public class HelloModel {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

    private Map<String, Object> values;

    public HelloModel(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
