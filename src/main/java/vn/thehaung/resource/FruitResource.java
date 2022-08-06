package vn.thehaung.resource;

import vn.thehaung.dto.FruitDto;
import vn.thehaung.model.Fruit;
import vn.thehaung.service.FruitService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    public List<FruitDto> getAll() {
        return fruitService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @POST
    public void add(FruitDto fruit) {
        fruitService.save(convertFromDto(fruit));
    }

    private FruitDto convertToDto(Fruit fruit) {
        return new FruitDto(fruit.getName(), fruit.getDescription());
    }

    private Fruit convertFromDto(FruitDto fruitDto) {
        return new Fruit(fruitDto.getName(), fruitDto.getDescription());
    }
}
