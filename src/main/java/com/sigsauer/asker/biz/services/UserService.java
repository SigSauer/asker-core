package com.sigsauer.asker.biz.services;

import com.sigsauer.asker.biz.services.shared.AbstractService;
import com.sigsauer.asker.biz.user.bean.UserDO;

import java.util.UUID;

public interface UserService extends AbstractService<UserDO, UUID> {

    UserDO findByEmail(String email);

    UserDO findByUsername(String username);

    UserDO findByEmailAndPassword(String email, String password);
}
