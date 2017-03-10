package com.intuit.exp;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.intuit.exp.provider.ObjectMapperFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/***
 *
 */

@Configuration
@ApplicationPath("/api/v1")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages(Boolean.TRUE, "com.intuit.exp.api");

        JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
        jsonProvider.setMapper(ObjectMapperFactory.getObjectMapper());

        register(jsonProvider, MessageBodyReader.class, MessageBodyWriter.class);
    }
}
