package za.co.nedj.app.nedj.catdogapi.rest;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.catdogapi.Client.DogClient;
import za.co.nedj.app.nedj.catdogapi.Client.DogClientImpl;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/")
@Api(value = "dog API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class DogRest {
    @EJB
    private DataService dataService;
    @EJB
    private DogClientImpl dogClientImpl;

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
    public Response addDog(Dog dog) {
        return Response.status(Response.Status.OK).entity(dataService.addDog(dog)).build();
    }

    @PUT
    @Path("/dog")
    public Response updateDog(Dog dog) {
        return Response.status(Response.Status.OK).entity(dataService.updateDog(dog)).build();
    }

    @DELETE
    @Path("/{dogId}/dog")
    public Response deleteDog(@PathParam("dogId") Long dogId) {
        return Response.status(Response.Status.OK).entity(dataService.deleteDog(dogId)).build();
    }

    @GET
    @Path("/dogBreeds")
    public Response getAllDogBreeds() {
        return Response.status(Response.Status.OK).entity(dogClientImpl.getDogs()).build();
    }


}

