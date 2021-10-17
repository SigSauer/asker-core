package com.sigsauer.asker;

import com.sigsauer.asker.biz.services.UserService;
import com.sigsauer.asker.biz.services.UserServiceImpl;
import com.sigsauer.asker.biz.user.bean.UserDO;


public class HibernateStandAlone {

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        UserDO user = new UserDO("username", "email", "password", true, "photo", "locale");
        service.save(user);

    }

}
