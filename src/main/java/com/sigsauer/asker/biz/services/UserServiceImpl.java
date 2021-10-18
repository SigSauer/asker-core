package com.sigsauer.asker.biz.services;

import com.sigsauer.asker.biz.bean.UserDO;
import com.sigsauer.asker.biz.exceptions.UserConflictException;
import com.sigsauer.asker.biz.exceptions.UserNotFoundException;
import com.sigsauer.asker.biz.repositories.UserRepository;
import com.sigsauer.asker.biz.repositories.UserRepositoryImpl;
import com.sigsauer.asker.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository = new UserRepositoryImpl();


    @Override
    public List<UserDO> findAll() {
        return this.repository.findAll();
    }

    @Override
    public UserDO findById(UUID id) {
        Optional<UserDO> userOptional = this.repository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            log.error(String.format("Unable to find User by %s = %s. ", "ID", id.toString()));
           throw new UserNotFoundException("ID", id.toString());
        }
    }

    @Override
    public UserDO save(UserDO user) throws UserConflictException {
        if (existByEmailOrUsername(user)) {
            log.error(String.format("Unable to %s User. : %s", "CREATE", "EMAIL or USERNAME already exist"));
            throw new UserConflictException("CREATE", "EMAIL or USERNAME already exist");
        }
        try {
            return this.repository.save(user);
        } catch (Exception e) {
            log.error(String.format("Unable to %s User. : %s", "CREATE", "EMAIL or USERNAME already exist"), e);
            throw new UserConflictException("CREATE", e);
        }

    }

    @Override
    public UserDO update(UUID id, UserDO user) throws UserConflictException {
        UserDO received = this.findById(id);
        if (received.equals(user)) {
            return user;
        }
        if (existByEmailOrUsername(user)) {
            log.error(String.format("Unable to %s User with ID = %s. : %s", "UPDATE", id, "EMAIL or USERNAME already exist"));
            throw new UserConflictException(id, "UPDATE", "EMAIL or USERNAME already exist");
        }
        user.setId(id);
        try {
            return this.repository.save(user);
        } catch (Exception e) {
            log.error(String.format("Unable to %s User with ID = %s. : ", "UPDATE", user.getId()), e);
            throw new UserConflictException(id, "UPDATE", e);
        }
    }

    @Override
    public void delete(UUID id) {
        if (!this.repository.delete(id)) {
            log.error(String.format("Unable to find User by %s = %s. ", "ID", id.toString()));
            throw new UserNotFoundException("id", id.toString());
        }
    }

    @Override
    public UserDO findByEmail(String email) {
        Optional<UserDO> userOptional = this.repository.findByEmail(email);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            log.error(String.format("Unable to find User by %s = %s. ", "EMAIL", email));
            throw new UserNotFoundException("EMAIL", email);
        }
    }

    @Override
    public UserDO findByUsername(String username) {
        Optional<UserDO> userOptional = this.repository.findByEmail(username);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            log.error(String.format("Unable to find User by %s = %s. ", "USERNAME", username));
            throw new UserNotFoundException("USERNAME", username);
        }
    }

    @Override
    public UserDO findByEmailAndPassword(String email, String password) {
        return this.repository.findByEmailAndPassword(email, password);
    }


    private boolean existByEmailOrUsername(UserDO user) {
        return StringUtils.isNotEmpty(user.getEmail()) && this.repository.findByEmail(user.getEmail()).isPresent() ||
                StringUtils.isNotEmpty(user.getUsername()) && this.repository.findByUsername(user.getUsername()).isPresent();
    }

}
