package challenge;

import java.util.List;

/**
 * Classe para mapear o bairro no Redis
 *
 */
public class NeighborhoodRedis {

    private String name;
    private String id;
    private List<RestaurantRedis> restaurantes;

    public NeighborhoodRedis() {
    }

    public NeighborhoodRedis(String name, String id, List<RestaurantRedis> restaurantes) {
        this.name = name;
        this.id = id;
        this.restaurantes = restaurantes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RestaurantRedis> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<RestaurantRedis> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
