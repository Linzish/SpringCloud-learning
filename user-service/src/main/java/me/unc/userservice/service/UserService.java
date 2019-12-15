package me.unc.userservice.service;

import me.unc.userservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public User getById(long id) {
        User user = new User();
        user.setId(id);
        user.setName("cxk");
        return user;
    }

}
