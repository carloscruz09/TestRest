/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.dao;

import com.service_rest.application.mappers.ClientMapper;
import com.service_rest.application.modelo.Client;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author aco-ec-029
 */
public interface ClientDAO {
    
     /**
     * Gets all clients.
     *
     * @return List of clients.
     */
    @SqlQuery("select * from CAT_CLIENTES")
    @Mapper(ClientMapper.class)
    List<Client> getClients();
    
    /**
     * Adds a client.
     *
     * @param client Client object.
     * @return an int result that represents success or error.
     */
    @SqlUpdate("insert into CAT_CLIENTES (id_cliente, nombre, apellido_paterno, apellido_materno, direccion, telefono_casa, "
            + "telefono_movil, estado, sucursal, document) "
            + "values (0, :name, :firstName, :lastName, :address, :phone, :mobilePhone,"
            +" :status, :office, :document)")
    @GetGeneratedKeys
    int addClient(@BindBean Client client);
    
}
