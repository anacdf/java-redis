package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RedisOperations<String, NeighborhoodRedis> redis;

	@Autowired
	private MongoOperations mongo;

	@Override
	public NeighborhoodRedis findInNeighborhood(double x, double y) {
		NeighborhoodMongo neighborhoodMongo = findByLocation(x,y);
		return null;
	}

	private NeighborhoodMongo findByLocation(double x, double y) {
		return null;
	}

}
