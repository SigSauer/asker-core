package com.sigsauer.asker;

import com.sigsauer.asker.biz.bean.UserDO;
import com.sigsauer.asker.biz.services.UserService;
import com.sigsauer.asker.biz.services.UserServiceImpl;


public class HibernateStandAlone {

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        UserDO user = new UserDO("username", "email", "password", true, "photo", "locale");
        service.save(user);

    }

}
