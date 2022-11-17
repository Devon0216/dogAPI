package za.co.nedj.app.nedj.catdogapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.catdogapi.Client.DogClientImpl;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.DogDTO;
import za.co.nedj.app.nedj.catdogapi.service.DataService;
import za.co.nedj.app.nedj.catdogapi.service.DogService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/")
@Api(value = "dog API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class DogRest {

    @EJB
    private DogService dogService;

    @GET
    @Path("/{dogName}/dog")
    public Response getDog(@PathParam("dogName") String dogName) {
        Optional<DogDTO> response = dogService.getDogByBreed(dogName);
        return response
                .map(x -> Response.status(Response.Status.OK).entity(x).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/dog-breeds")
    public Response getAllDogBreeds() {
        return Response.status(Response.Status.OK).entity(dogService.getDogBreeds()).build();
    }

    @GET
    @Path("/dogs")
    public Response getAllDogs() {
        return Response.status(Response.Status.OK).entity(dogService.getAllDogs()).build();
    }

    @POST
    @Path("/dog")
    public Response addDog(DogDTO dogDTO) {
        return Response.status(Response.Status.OK).entity(dogService.addDog(dogDTO)).build();
    }
//
//    @PUT
//    @Path("/dog")
//    public Response updateDog(Dog dog) {
//        return Response.status(Response.Status.OK).entity(dataService.updateDog(dog)).build();
//    }
//
//    @DELETE
//    @Path("/{dogId}/dog")
//    public Response deleteDog(@PathParam("dogId") Long dogId) {
//        return Response.status(Response.Status.OK).entity(dataService.deleteDog(dogId)).build();
//    }



}

