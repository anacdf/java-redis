package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o restaurante no MongoDB
 *
 */
@Document(collection = "restaurant")
public class RestaurantMongo {

    @Id
    private String id;
    private String name;

}
