package org.fanlychie.controller;

import org.fanlychie.entity.User;
import org.fanlychie.facade.ArticleFacade;
import org.fanlychie.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanlychie on 2017/7/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private ArticleFacade articleFacade;

    @GetMapping("/login")
    public Map<String, Object> login(String username, String password) {
        String errcode = "0";
        String errmsg = null;
        Object result = null;
        User user = userFacade.queryByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            result = articleFacade.queryByUserId(user.getId());
        } else {
            errcode = "1000";
            errmsg = "账户名或密码错误";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("errcode", errcode);
        map.put("errmsg", errmsg);
        map.put("result", result);
        return map;
    }

}