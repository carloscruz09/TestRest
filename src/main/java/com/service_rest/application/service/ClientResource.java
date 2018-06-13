/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.service;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonView;
import com.service_rest.application.dao.ClientDAO;
import com.service_rest.application.modelo.Client;
import com.service_rest.application.modelo.Views;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author aco-ec-029
 */
@Path("/clients")
@Api(value = "/clients", tags = "clients")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ClientResource {
    
    /**
     * Resource logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientResource.class);
    
     /**
     * Client DAO.
     */
    private ClientDAO dao;

    public ClientResource(final ClientDAO dao) {
        this.dao = dao;
    }
    
    @GET
     @ApiOperation(value = "Find all clients.",
            notes = "Returns a single object with all clients.",
            response = Client.class
    )
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "No clients")
    })
    @Metered(name = "getUsers.metered")
    @Timed(name = "getUsers.timed")
    @JsonView(Views.Public.class)
    @Path("/getAll")
    public Response getClients() {
        final Response response;
        LOGGER.info("Getting all users");
        List<Client> clients = dao.getClients();
        if (clients != null || !clients.isEmpty()) {

            response = Response.ok().entity(clients).header("Access-Control-Allow-Origin", "*").allow("OPTIONS").build();
        } else {
            LOGGER.info("Obj NULL o VACIO");
            response = Response.status(404).build();
        }

        return response;
    }

//    @GET
//    @JsonView(Views.Public.class)
//    @Path("{id}")
//    public Response findClient(@PathParam("id") String id) {
//        LOGGER.info("Finding a user: {}", id != null ? id : "null");
//        User user = helper.findUser(id);
//        if (user == null) {
//            MensajeError error = new MensajeError("100", "No se encontro ningun usuario con el id proporcionado");
//
//            return Response.ok(error).build();
//        }
//        return Response.ok(user).build();
//    }
    
    /**
     * Adds a new client.
     *
     * @param client Object Client to insert.
     * @return The outcome of the process.
     */
    @POST
    @Path("/addClient")
    @ApiOperation(value = "Add a new user.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "addUser.metered")
    @Timed(name = "addUser.timed")
    public Response addClient(@ApiParam(value = "Add client", required = true) final Client client) {
        final Response response;
        final int resultado = dao.addClient(client);
        LOGGER.info("resultado (add):: " + resultado);
        if(resultado == 0) {
            response = Response.status(404).build();
            return response;
        }
        client.setId(String.valueOf(resultado));
        response = Response.ok().entity(client).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        return response;
    }
    
}
