package com.sigsauer.asker.biz.services;

import com.sigsauer.asker.biz.user.UserRepository;
import com.sigsauer.asker.biz.user.UserRepositoryImpl;
import com.sigsauer.asker.biz.user.bean.UserDO;
import com.sigsauer.asker.biz.user.exceptions.UserNotFoundException;

import java.util.List;
import java.util.UUID;


public class UserServiceImpl implements UserService {

    private final UserRepository repository = new UserRepositoryImpl();


    @Override
    public List<UserDO> findAll() {
        return null;
    }

    @Override
    public UserDO findById(UUID id) {
        return null;
    }

    @Override
    public UserDO save(UserDO user) {
        return this.repository.save(user);
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public UserDO findByEmail(String email) {
        return null;
    }

    @Override
    public UserDO findByUsername(String username) {
        return this.repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("username", username));
    }

    @Override
    public UserDO findByEmailAndPassword(String email, String password) {
        return null;
    }
}
