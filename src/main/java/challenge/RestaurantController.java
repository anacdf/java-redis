package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
## GET /restaurants/findInNeighborhood

Lista os restaurantes do bairro de acordo com as coordenadas geográficas.
* Encontrar o bairro no MongoDB de acordo com as coordenadas geográficas
* Se está salvo no Redis retornar no response body
* Se não está salvo no Redis, encontrar todos os restaurantes deste bairro no MongoDB, salvar no Redis e retornar no response body
* Ordenar os restaurantes pelo campo `name` em ordem alfabética ascendente.
* Ex: /restaurants/findInNeighborhood?x=-73.9506635&y=40.7858944
 */

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@GetMapping(value = "/findInNeighborhood")
	public NeighborhoodRedis findInNeighborhood(@PathVariable double x, @PathVariable double y) {
		return service.findInNeighborhood(0, 0);
	}

}
