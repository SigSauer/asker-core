package com.sigsauer.asker.config;

import com.sigsauer.asker.api.user.UserAPI;
import com.sigsauer.asker.api.user.UserAPIImpl;
import com.sigsauer.asker.biz.repositories.UserRepository;
import com.sigsauer.asker.biz.repositories.UserRepositoryImpl;
import com.sigsauer.asker.biz.services.UserService;
import com.sigsauer.asker.biz.services.UserServiceImpl;
import org.glassfish.jersey.internal.inject.AbstractBinder;

import javax.inject.Singleton;

public class ApiBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bindRepositories();
        bindServices();
        bindAPIs();
    }

    private void bindAPIs() {
        bind(UserAPIImpl.class).to(UserAPI.class).in(Singleton.class);
    }

    private void bindServices() {
        bind(UserServiceImpl.class).to(UserService.class).in(Singleton.class);
    }

    private void bindRepositories() {
        bind(UserRepositoryImpl.class).to(UserRepository.class).in(Singleton.class);
    }
}
