/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.mappers;

import com.service_rest.application.modelo.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author aco-ec-029
 */
public class ClientMapper implements ResultSetMapper<Client>{

    @Override
    public Client map(final int i, final ResultSet rs, final StatementContext sc) throws SQLException {
        Client client = new Client();
        client.setId(rs.getString("id_cliente"));
        client.setName(rs.getString("nombre"));
        client.setFirstName(rs.getString("apellido_paterno"));
        client.setLastName(rs.getString("apellido_materno"));
        client.setAddress(rs.getString("direccion"));
        client.setPhone(rs.getString("telefono_casa"));
        client.setMobilePhone(rs.getString("telefono_movil"));
        client.setStatus(rs.getString("estado"));
        client.setOffice(rs.getString("sucursal"));
        client.setDocument(rs.getString("document"));
        return client;
    }
}
