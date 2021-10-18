package com.sigsauer.asker.api.user;

import com.sigsauer.asker.api.user.bean.UserAO;
import com.sigsauer.asker.extapi.exceptions.ApiException;

import java.util.List;

public interface UserAPI {

    List<UserAO> getAllUsers();

    UserAO getById(String id) throws ApiException;

    UserAO getUserByUsername(String username) throws ApiException;

    UserAO getUserByEmail(String email) throws ApiException;

    UserAO createUser(UserAO user) throws ApiException;

    UserAO updateUser(String id, UserAO user) throws ApiException;

    void deleteUser(String id);
}
