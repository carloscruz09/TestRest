/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.mappers;

import com.service_rest.application.modelo.Domicilio;
import com.service_rest.application.modelo.Role;
import com.service_rest.application.modelo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author aco-ec-029
 */
public class UserMapper implements ResultSetMapper<User>{

    @Override
    public User map(final int i, final ResultSet rs, final StatementContext sc) throws SQLException {
        final User user = new User();
        user.setId(rs.getString("idUser"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        final Domicilio domicilio = new Domicilio();
        domicilio.setCalle(rs.getString("addressStreet"));
        domicilio.setColonia(rs.getString("addressNeighbourhood"));
        domicilio.setNumeroExt(rs.getString("addressExtNumber"));
        domicilio.setNumeroInt(rs.getString("addressIntNumber"));
        user.setDomicilio(domicilio);
        final Role role = new Role();
        role.setName(rs.getString("roleName"));
        role.setDescription(rs.getString("roleDescription"));
        user.setRole(role);
        return user;
    }
    
}
