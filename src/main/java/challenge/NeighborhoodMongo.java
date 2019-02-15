package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o bairro no MongoDB
 *
 */
@Document(collection = "neighborhood")
public class NeighborhoodMongo {

    @Id
    private String id;
    private String name;

    private GeoJsonPolygon cordinates;

    public NeighborhoodMongo() {
    }

    public NeighborhoodMongo(String id, String name, GeoJsonPolygon cordinates) {
        this.id = id;
        this.name = name;
        this.cordinates = cordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJsonPolygon getCordinates() {
        return cordinates;
    }

    public void setCordinates(GeoJsonPolygon cordinates) {
        this.cordinates = cordinates;
    }
}
