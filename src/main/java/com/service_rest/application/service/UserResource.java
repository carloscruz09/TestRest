/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.service;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.service_rest.application.Helpers.UserHelper;
import com.service_rest.application.dao.UserDAO;
import com.service_rest.application.modelo.SendUser;
import com.service_rest.application.modelo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import org.slf4j.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.reflections.util.Utils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author amk-diseno
 */
@Path("/users")
@Api(value = "/users", tags = "users")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserResource {

    /**
     * Resource logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
    /**
     * User DAO.
     */
    private UserDAO dao;
    /**
     * User Helper.
     */
    private UserHelper userHelper;

    /**
     * Constructor with arguments.
     *
     * @param dao DAO for transactions.
     */
    public UserResource(final UserDAO dao) {
        this.dao = dao;
    }

    /**
     * Gets all users.
     *
     * @return The outcome of the process.
     */
    @GET
    @Path("/allUsers")
    @ApiOperation(value = "Find all users.",
            notes = "Returns a single object with all users.",
            response = User.class
    )
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "No users")
    })
    @Metered(name = "getUsers.metered")
    @Timed(name = "getUsers.timed")
    public Response getUsers() {
        final Response response;
        final List<User> listaUsuarios = dao.getUsers();
        if (listaUsuarios != null && !listaUsuarios.isEmpty()) {

            response = Response.ok().entity(listaUsuarios).build();
        } else {
            LOGGER.info("Obj NULL o VACIO");
            response = Response.status(404).build();
        }
        return response;
    }

    /**
     * Adds a new user.
     *
     * @param user Object CatUser to insert.
     * @return The outcome of the process.
     */
    @POST
    @Path("/addUser")
    @ApiOperation(value = "Add a new user.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "addUser.metered")
    @Timed(name = "addUser.timed")
    public Response addUser(@ApiParam(value = "Add user", required = true) final User user) {
        final Response response;
        SendUser sendUser = userHelper.converterUser(user);
        final int resultado = dao.addUser(sendUser);
        LOGGER.info("resultado (add):: " + resultado);
        response = Response.ok().build();
        return response;
    }

    /**
     * Updates an User.
     *
     * @param user Object antenna to insert.
     * @return The outcome of the process.
     */
    @PUT
    @Path("/update")
    @ApiOperation(value = "Update a given user.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "updateUser.metered")
    @Timed(name = "updateUser.timed")
    public Response updateUser(@ApiParam(value = "Update user", required = true) final User user) {
        final Response response;
        final int resultado = dao.updateUser(user);
        LOGGER.info("resultado (update):: " + resultado);
        response = Response.ok().build();
        return response;
    }

    /**
     * Updates an User.
     *
     * @param username Object antenna to insert.
     * @return The outcome of the process.
     */
    @PUT
    @Path("/updateToken/{username}")
    @ApiOperation(value = "Update a user's token.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "updateUser.metered")
    @Timed(name = "updateUser.timed")
    public Response updateUserToken(@ApiParam(value = "Update a user's token", required = true) @PathParam("username") final String username) {
        final Response response;
        final String token = RandomStringUtils.randomAlphanumeric(12);
        final int resultado = dao.updateUserToken(username, token);
        LOGGER.info("resultado (update):: " + resultado);
        response = Response.ok().build();
        return response;
    }

    /**
     * Deletes an user (logically).
     *
     * @param username It's username.
     * @return The outcome of the process.
     */
    @DELETE
    @Path("/delete/{username}")
    @ApiOperation(value = "Logical delete of an user.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "deleteUser.metered")
    @Timed(name = "deleteUser.timed")
    public Response deleteUser(@ApiParam(value = "Delete user", required = true) @PathParam("username") final String username) {
        final Response response;
        final int resultado = dao.deleteUser(username);
        LOGGER.info("resultado (delete):: " + resultado);
        response = Response.ok().build();
        return response;
    }

    /**
     *
     * @param fileInputStream
     * @param contentDispositionHeader
     * @return
     */
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Add a new event. Only if the timestamp is not registered previously.")
    @ApiResponses({
        @ApiResponse(code = 405, message = "Invalid input.")
        ,
        @ApiResponse(code = 501, message = "Server error.")
    })
    @Metered(name = "uploadFileCsv.metered")
    @Timed(name = "uploadFileCsv.timed")
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "file", name = "file", paramType = "formData", required = true))
    public Response uploadFileCsv(
            @ApiParam(hidden = true) @FormDataParam("file") final InputStream fileInputStream,
            @FormDataParam("file") final FormDataContentDisposition contentDispositionHeader) {
        Response response = null;
        final List<SendUser> users = new ArrayList<>();
        try {
//            Reader devices = new FileReader("/home/aco-ec-029/Documents/Devices.csv");
            final Reader usersFile = new InputStreamReader(fileInputStream);
            final CSVParser records = new org.apache.commons.csv.CSVParser(usersFile, CSVFormat.EXCEL.withHeader().withDelimiter(';'));
            try {
                for (CSVRecord record : records) {
                    final String username = record.get("username");
                    final String password = record.get("password");
                    final String roleName = record.get("rolename");
                    final String roleDescription = record.get("roleDescription");
                    final String addressStreet = record.get("addressStreet");
                    final String addressIntNumber = record.get("addressIntNumber");
                    final String addressExtNumber = record.get("addressExtNumber");
                    final String addressNeighbourhood = record.get("addressNeighbourhood");
                    if (!Utils.isEmpty(username)) {
                        users.add(new SendUser(username, password, roleName, roleDescription, addressStreet, addressIntNumber, addressExtNumber, addressNeighbourhood));
                    }
                }
            } finally {
                records.close();
                usersFile.close();
            }
        } catch (final FileNotFoundException e) {
            LOGGER.error("Error inserting file", e);
            response = Response.status(405).build();
        } catch (final IOException e) {
            LOGGER.error("Error inserting file", e);
            response = Response.status(405).build();
        }
        LOGGER.info("Numero de usuarios a registrar " + users.size());
        if (users != null && !users.isEmpty()) {
            for (SendUser user : users) {
                LOGGER.info("User: {}" + ReflectionToStringBuilder.toString(user));
                final int resultado = dao.addUser(user);
            }
        }

        LOGGER.info("archivos " + contentDispositionHeader);
        return response;
    }

}
