package com.sigsauer.asker.biz.repositories;

import com.sigsauer.asker.biz.bean.UserDO;
import com.sigsauer.asker.biz.repositories.shared.EntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends EntityRepository<UserDO, UUID> {

    Optional<UserDO> findByEmail(String email);

    Optional<UserDO> findByUsername(String username);

    UserDO findByEmailAndPassword(String email, String password);



    //todo in future
    default Optional<UserDO> findByLogin(String login) {
        throw new IllegalStateException("METHOD IS NOT IMPLEMENTED");
    };

    //todo in future
    default UserDO findByLoginAndPassword(String login, String password) {
        throw new IllegalStateException("METHOD IS NOT IMPLEMENTED");
    }
}
