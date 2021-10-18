package com.sigsauer.asker.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApiConfiguration extends ResourceConfig {

    public static final String IMAGE_RESOURCES_DIRECTORY = System.getProperty("user.home") + "\\asker\\content\\images\\";

    public ApiConfiguration() {
        packages("com.sigsauer.asker.extapi", "com.sigsauer.asker.config.providers");
        register(new ApiBinder());
//
//       register(new AuthenticationFilter());
//                register(MultiPartFeature.class);
    }
}
