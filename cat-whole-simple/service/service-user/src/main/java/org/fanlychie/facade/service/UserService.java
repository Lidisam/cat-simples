package org.fanlychie.facade.service;

import org.fanlychie.entity.User;
import org.fanlychie.facade.UserFacade;
import org.fanlychie.facade.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by fanlychie on 2018/7/28.
 */
@Service
public class UserService implements UserFacade {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException();
        }
        return userDao.queryByUsername(username);
    }

}