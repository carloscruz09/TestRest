/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.dao;

import com.service_rest.application.mappers.UserMapper;
import com.service_rest.application.modelo.SendUser;
import com.service_rest.application.modelo.User;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author aco-ec-029
 */
public interface UserDAO {
    
     /**
     * Gets all users.
     *
     * @return List of users.
     */
    @SqlQuery("select * from users")
    @Mapper(UserMapper.class)
    List<User> getUsers();

    /**
     * Adds an user.
     *
     * @param user User object.
     * @return an int result that represents success or error.
     */
    @SqlUpdate("insert into users (idUser, username, password, roleName, roleDescription, addressStreet, "
            + "addressIntNumber, addressExtNumber, addressNeighbourhood) "
            + "values (0, :username, :password, :roleName, :roleDescription, :addressStreet, :addressIntNumber,"
            +" :addressExtNumber, :addressNeighbourhood)")
    @GetGeneratedKeys
    int addUser(@BindBean SendUser user);

    /**
     * Updates an User.
     *
     * @param user User object.
     * @return an int result that represents success or error.
     */
    @SqlUpdate("update users set password = :password, descripcion = :description "
            + "WHERE username = :username")
    int updateUser(@BindBean User user);

    /**
     * Updates an User token.
     *
     * @param username user name to get.
     * @param token user name to get.
     * @return an int result that represents success or error.
     */
    @SqlUpdate("update users set token = :token "
            + "WHERE username = :username")
    int updateUserToken(@Bind("username") String username, @Bind("token") String token);

    /**
     * Deletes an User (logically).
     *
     * @param username Usernames.
     * @return an int result that represents success or error.
     */
    @SqlUpdate("update users set activo = \"N\" "
            + "WHERE username = :username")
    int deleteUser(@Bind("username") String username);

    /**
     * Gets all active users.
     *
     * @return List of active antennas.
     */
    @SqlQuery("select * from users where activo = 'Y'")
    @Mapper(UserMapper.class)
    List<User> getActiveUsers();
    
}
