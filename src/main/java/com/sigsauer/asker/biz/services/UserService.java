package com.sigsauer.asker.biz.services;

import com.sigsauer.asker.biz.bean.UserDO;
import com.sigsauer.asker.biz.exceptions.UserCredentialsMismatchException;
import com.sigsauer.asker.biz.exceptions.UserNotFoundException;
import com.sigsauer.asker.biz.services.shared.AbstractService;

import java.util.UUID;

public interface UserService extends AbstractService<UserDO, UUID> {

    UserDO findByEmail(String email) throws UserNotFoundException;

    UserDO findByUsername(String username) throws UserNotFoundException;

    UserDO findByEmailAndPassword(String email, String password) throws UserCredentialsMismatchException;
}
