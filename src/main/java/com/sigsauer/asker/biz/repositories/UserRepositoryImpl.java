package com.sigsauer.asker.biz.repositories;

import com.sigsauer.asker.biz.bean.UserDO;
import com.sigsauer.asker.biz.exceptions.UserCredentialsMismatchException;
import com.sigsauer.asker.biz.repositories.shared.AbstractEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;


@SuppressWarnings("unchecked")
public class UserRepositoryImpl extends AbstractEntityRepository<UserDO, UUID> implements UserRepository {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Optional<UserDO> findByEmail(String email) {
        return getEntityManager().createQuery("Select user from UserDO user where user.email = :email")
                .setParameter("email", email)
                .getResultList()
                .stream().findFirst();
    }

    @Override
    public Optional<UserDO> findByUsername(String username) {
        return getEntityManager().createQuery("Select user from UserDO user where user.username = :username")
                .setParameter("username", username)
                .getResultList()
                .stream().findFirst();
    }

    @Override
    public UserDO findByEmailAndPassword(String email, String password) {
        Optional<UserDO> userOptional = findByEmail(email);
        if (userOptional.isPresent() && encoder.matches(password, userOptional.get().getPassword())) {
            return userOptional.get();
        } else {
            log.error("UserCredentialsMismatchException");
            throw new UserCredentialsMismatchException();
        }
    }



}
