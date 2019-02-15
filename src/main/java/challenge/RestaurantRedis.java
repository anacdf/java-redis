package challenge;

/**
 * Classe para mapear o restaurante no Redis
 *
 */
public class RestaurantRedis {

    private String name;
    private String id;
    private Double x;
    private Double y;

    public RestaurantRedis() {
    }

    public RestaurantRedis(String name, String id, Double x, Double y) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
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

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }


}
