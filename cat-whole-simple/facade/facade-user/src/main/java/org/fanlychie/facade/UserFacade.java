package org.fanlychie.facade;

import org.fanlychie.entity.User;

/**
 * Created by fanlychie on 2018/7/28.
 */
public interface UserFacade {

    User queryByUsername(String username);

}