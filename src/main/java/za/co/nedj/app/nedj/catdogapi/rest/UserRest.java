package za.co.nedj.app.nedj.catdogapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.User;
import za.co.nedj.app.nedj.catdogapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/")
@Api(value = "catdog API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class UserRest {
    @EJB
    private DataService dataService;

    @GET
    @Path("/{userId}/user")
    public Response getUser(@PathParam("dogName") Long userId) {
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
}
