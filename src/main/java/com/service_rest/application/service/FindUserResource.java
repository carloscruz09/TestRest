/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.service;

import com.fasterxml.jackson.annotation.JsonView;
import com.service_rest.application.Helpers.SourceHelper;
import com.service_rest.application.dao.UserDAO;
import com.service_rest.application.modelo.MensajeError;
import com.service_rest.application.modelo.Request;
import com.service_rest.application.modelo.User;
import com.service_rest.application.modelo.Views;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author amk-diseno
 */

@Path("/findUser/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class FindUserResource {
 private final SourceHelper helper = new SourceHelper();
    
    private UserDAO userDAO;

    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    public FindUserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    

    @GET
    @JsonView(Views.Public.class)
    public Response getUsers() {
        LOG.info("Getting all users");
        List<User> users = helper.getUsers();
        return Response.ok(users).build();
    }

    @GET
    @JsonView(Views.Public.class)
    @Path("{id}")
    public Response findUser(@PathParam("id") String id) {
        LOG.info("Finding a user: {}", id != null ? id : "null");
        User user = helper.findUser(id);
        if (user == null) {
            MensajeError error = new MensajeError("100", "No se encontro ningun usuario con el id proporcionado");

            return Response.ok(error).build();
        }
        return Response.ok(user).build();
    }

    @POST
    @JsonView(Views.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("buscar")
    public Response findUserPost(Request request) {
        LOG.info("Finding a user: {}", request.getId() != null ? request.getId() : "null");
        User user = helper.findUser(request.getId());
        if (user == null) {
            MensajeError error = new MensajeError("100", "No se encontro ningun usuario con el id proporcionado");

            return Response.ok(error).build();
        }
        return Response.ok(user).build();
    }

    @GET
    @JsonView(Views.Public.class)
    @Path("eliminar/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        LOG.info("Deleting a user: {}", id != null ? id : "null");
        if (id == null) {
            MensajeError error = new MensajeError("108", "Indique un id");

            return Response.ok(error).build();
        } else {
            User userExiste = helper.findUser(id);
            if (userExiste == null) {
                MensajeError error = new MensajeError("107", "El usuario que desea eliminar no existe");

                return Response.ok(error).build();
            }
        }
        helper.deleteUser(id);
        return Response.ok(id).build();
    }
    
    @POST
    @JsonView(Views.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminar")
    public Response deleteUserPost(Request request) {
        LOG.info("Finding a user: {}", request.getId() != null ? request.getId() : "null");
        if (request.getId() == null) {
            MensajeError error = new MensajeError("108", "Indique un id");

            return Response.ok(error).build();
        }else {
            User userExiste = helper.findUser(request.getId());
            if (userExiste == null) {
                MensajeError error = new MensajeError("107", "El usuario que desea eliminar no existe");

                return Response.ok(error).build();
            }
        }
        helper.deleteUser(request.getId());
        return Response.ok(request).build();
    }

    @POST
    @JsonView(Views.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("agregar")
    public Response addUser(User user) {
        LOG.info("Adding user");
        if (user == null || user.getId() == null) {
            MensajeError error = new MensajeError("105", "No se encontro ningun usuario con el id proporcionado");

            return Response.ok(error).build();
        } else if (user.getUsername() == null) {
            MensajeError error = new MensajeError("102", "Falta el nombre del usuario");

            return Response.ok(error).build();
        } else if (user.getPassword() == null) {
            MensajeError error = new MensajeError("103", "Falta la contraseña del usuario");

            return Response.ok(error).build();
        } else {
            User userExiste = helper.findUser(user.getId());
            if (userExiste != null) {
                MensajeError error = new MensajeError("106", "El usuario ya existe");

                return Response.ok(error).build();
            }
        }
        helper.addUser(user);
        return Response.ok(user).build();
    }

    
}
