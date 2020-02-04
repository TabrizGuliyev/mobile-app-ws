package com.tabrizguliyev.app.ws.userservice;

import com.tabrizguliyev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tabrizguliyev.app.ws.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);


}
