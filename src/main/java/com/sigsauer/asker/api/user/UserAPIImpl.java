package com.sigsauer.asker.api.user;

import com.sigsauer.asker.api.user.bean.UserAO;
import com.sigsauer.asker.biz.services.UserService;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserAPIImpl implements UserAPI{



    private UserService userService;

    @Inject
    public UserAPIImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAO> getAllUsers() {
        return userService.findAll().stream().map(UserEntityMapper::map).collect(Collectors.toList());
    }

    @Override
    public UserAO getById(String id) {
        return UserEntityMapper.map(userService.findById(UUID.fromString(id)));
    }

    @Override
    public UserAO getUserByUsername(String username) {
        return UserEntityMapper.map(userService.findByUsername(username));
    }

    @Override
    public UserAO getUserByEmail(String email) {
        return UserEntityMapper.map(userService.findByEmail(email));
    }

    @Override
    public UserAO createUser(UserAO user) {
        return UserEntityMapper.map(userService.save(UserEntityMapper.map(user)));
    }

    @Override
    public UserAO updateUser(String id, UserAO user) {
        return UserEntityMapper.map(userService.update(UUID.fromString(id), UserEntityMapper.map(user)));
    }

    @Override
    public void deleteUser(String id) {
        userService.delete(UUID.fromString(id));
        return;
    }
}
