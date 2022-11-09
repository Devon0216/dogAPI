package za.co.nedj.app.nedj.catdogapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/")
@Api(value = "catdog API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class DogRest {
    @EJB
    private DataService dataService;

    @GET
    @Path("/{dogName}/dog")
    public Response getDog(@PathParam("dogName") String dogName) {
        Optional<Dog> response = dataService.getDog(dogName);
        return response
                .map(x -> Response.status(Response.Status.OK).entity(x).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/dog")
    public Response getAllDogs() {
        return Response.status(Response.Status.OK).entity(dataService.getAllDogs()).build();
    }

    @POST
    @Path("/dog")
    public Response addDog(Dog Dog) {
        return Response.status(Response.Status.OK).entity(dataService.addDog(Dog)).build();
    }
}
