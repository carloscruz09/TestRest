/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.main;
import com.service_rest.application.configurations.DropwizardConfiguration;
import com.service_rest.application.dao.ClientDAO;
import com.service_rest.application.dao.UserDAO;
import com.service_rest.application.service.ClientResource;
import com.service_rest.application.service.UserResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author amk-diseno
 */
public class DropwizardApplication  extends Application<DropwizardConfiguration> {
    
    private static final Logger LOG = LoggerFactory.getLogger(DropwizardApplication.class);
    
     /**
     * Getter for the application name.
     *
     * @return The name of the application.
     * @see io.dropwizard.Application#getName()
     */
    @Override
    public String getName() {
        return "Test Application";
    }
    
     @Override
    public void initialize(final Bootstrap<DropwizardConfiguration> bootstrap) {
        // para swagger
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(),
                new EnvironmentVariableSubstitutor(false)));
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new SwaggerBundle<DropwizardConfiguration>() {

            /**
             * Retrieves the swagger configuration.
             *
             * @param config The Swagger configurtion object.
             * @see io.federecio.dropwizard.swagger.SwaggerBundle#getSwaggerBundleConfiguration(io.dropwizard.Configuration)
             */

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(final DropwizardConfiguration config) {
                return config.getSwaggerConfig();
            }
        });
    }
 
    @Override
    public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final ClientDAO clientDAO = jdbi.onDemand(ClientDAO.class);
        LOG.info("Registering resources");
        environment.jersey().register(new UserResource(userDAO));
        environment.jersey().register(new ClientResource(clientDAO));
        environment.jersey().register(MultiPartFeature.class);
        LOG.info("Resources registered");
    }
 
    public static void main(String[] args) throws Exception {
        LOG.info("---------- Starting the Test Application. ----------");
        new DropwizardApplication().run(args);
    }
}
