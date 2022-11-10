package za.co.nedj.app.nedj.catdogapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.User;
import za.co.nedj.app.nedj.catdogapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/")
@Api(value = "user API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class UserRest {
    @EJB
    private DataService dataService;

    @GET
    @Path("/{userId}/user")
    public Response getUser(@PathParam("userId") Long userId) {
        Optional<User> response = dataService.getUser(userId);
        return response
                .map(x -> Response.status(Response.Status.OK).entity(x).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/user")
    public Response getAllUsers() {
        return Response.status(Response.Status.OK).entity(dataService.getAllUsers()).build();
    }

    @POST
    @Path("/user")
    public Response addUser(User user) {
        return Response.status(Response.Status.OK).entity(dataService.addUser(user)).build();
    }

    @PUT
    @Path("/user")
    public Response updateUser(User user) {
        return Response.status(Response.Status.OK).entity(dataService.updateUser(user)).build();
    }

    @DELETE
    @Path("/{userId}/user")
    public Response deleteUser(@PathParam("userId") Long userId) {
        return Response.status(Response.Status.OK).entity(dataService.deleteUser(userId)).build();
    }
}
