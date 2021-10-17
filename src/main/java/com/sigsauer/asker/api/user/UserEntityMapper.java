package com.sigsauer.asker.api.user;

import com.sigsauer.asker.api.user.bean.UserAO;
import com.sigsauer.asker.biz.user.bean.UserDO;

public class UserEntityMapper {

    public static UserDO map(UserAO user) {
        UserDO mapped = new UserDO();
        mapped.setId(user.getId());
        mapped.setUsername(user.getUsername());
        mapped.setEmail(user.getEmail());
        mapped.setVerified(user.isVerified());
        mapped.setPhoto(user.getPhoto());
        mapped.setLocale(user.getLocale());
        return mapped;
    }

    public static UserAO map(UserDO user) {
        UserAO mapped = new UserAO();
        mapped.setId(user.getId().toString());
        mapped.setUsername(user.getUsername());
        mapped.setEmail(user.getEmail());
        mapped.setVerified(user.isVerified());
        mapped.setPhoto(user.getPhoto());
        mapped.setLocale(user.getLocale());
        return mapped;
    }

}
