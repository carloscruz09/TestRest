/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 *
 * @author amk-diseno
 */
public class DropwizardConfiguration extends Configuration {
    
     /** Swagger configuration. */
    private SwaggerBundleConfiguration swaggerConfig;

    /** Database configuration. */
    private DataSourceFactory database = new DataSourceFactory();

     /**
     * Getter for swagger configuration.
     * @return the swaggerConfig.
     */
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration getSwaggerConfig() {
        return swaggerConfig;
    }

    /**
     * Setter for swagger configuration.
     * @param swaggerConfig the swaggerConfig to set.
     */
    public void setSwaggerConfig(final SwaggerBundleConfiguration swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    /**
     * Getter for database configuration.
     * @return the database.
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    /**
     * Setter for database configuration.
     * @param factory the properties to set.
     */
    public void setDataSourceFactory(final DataSourceFactory factory) {
        this.database = factory;
    }
}
