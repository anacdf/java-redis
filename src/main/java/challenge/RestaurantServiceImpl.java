package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RedisOperations<String, NeighborhoodRedis> redisRedisOperations;

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public NeighborhoodRedis findInNeighborhood(double x, double y) {
		NeighborhoodMongo neighborhood = mongoOperations.findOne(Query.query(where("cordinates")
						.intersects(new GeoJsonPoint(new Point(x,y)))),
				NeighborhoodMongo.class);

		NeighborhoodRedis neighborhoodRedis = redisRedisOperations.opsForValue().get("neighborhood:"+neighborhood.getId());
		neighborhoodRedis.setId(neighborhood.getId());
		neighborhoodRedis.setName(neighborhood.getName());
		neighborhoodRedis.setRestaurantes(
				findRestaurantInNeighborhood(neighborhood).stream().sequential().map(this::mongoToRedis).collect(Collectors.toList()));

		redisRedisOperations.opsForValue().set(neighborhoodRedis.getId(), neighborhoodRedis);

		return neighborhoodRedis;
	}

	public List<RestaurantMongo> findRestaurantInNeighborhood(NeighborhoodMongo neighborhoodMongo){
		return mongoOperations.find(Query.query(where("location")
				              .within(neighborhoodMongo.getCordinates()))
				              .with(Sort.by("name").ascending()),
				               RestaurantMongo.class);
	}

	public RestaurantRedis mongoToRedis(RestaurantMongo restaurantMongo){
		RestaurantRedis restaurantRedis = new RestaurantRedis();
		restaurantRedis.setId(restaurantMongo.getId());
		restaurantRedis.setName(restaurantMongo.getName());
		restaurantRedis.setX(restaurantMongo.getLocation().getX());
		restaurantRedis.setY(restaurantMongo.getLocation().getY());
		return restaurantRedis;
	}

}
