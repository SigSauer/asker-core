package com.sigsauer.asker.app.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public static final String IMAGE_RESOURCES_DIRECTORY = System.getProperty("user.home") + "\\asker\\content\\images\\";

    public ApplicationConfig() {
        packages("com.sigsauer.asker.app.resources", "com.sigsauer.asker.app.exceptions");
//        register(new AuthenticationFilter());
//        register(new ApplicationBinder());
//        register(MultiPartFeature.class);
    }
}
