package com.tabrizguliyev.app.ws.userservice.impl;

import com.tabrizguliyev.app.ws.shared.Utils;
import com.tabrizguliyev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tabrizguliyev.app.ws.ui.model.response.UserRest;
import com.tabrizguliyev.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;


    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }


    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

//        String userId = UUID.randomUUID().toString();
        String userId = utils.generateUserId();

        returnValue.setUserId(userId);
        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;

    }
}
