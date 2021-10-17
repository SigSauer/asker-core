package com.sigsauer.asker.biz.user;

import com.sigsauer.asker.biz.shared.AbstractEntityRepository;
import com.sigsauer.asker.biz.user.bean.UserDO;
import com.sigsauer.asker.biz.user.exceptions.UserCredentialsMismatch;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unchecked")
public class UserRepositoryImpl extends AbstractEntityRepository<UserDO, UUID> implements UserRepository {

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
            throw new UserCredentialsMismatch();
        }
    }



}
