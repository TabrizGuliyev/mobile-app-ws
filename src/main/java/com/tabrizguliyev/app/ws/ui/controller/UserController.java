package com.tabrizguliyev.app.ws.ui.controller;

import com.tabrizguliyev.app.ws.exceptions.UserServiceException;
import com.tabrizguliyev.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.tabrizguliyev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tabrizguliyev.app.ws.ui.model.response.UserRest;
import com.tabrizguliyev.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users")  //http://localhost:8088/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;


    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called page = " + page + " and limit " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//        UserRest returnValue = new UserRest();
//        returnValue.setFirstName("Tabriz");
//        returnValue.setLastName("Guliyev");
//        returnValue.setEmail("tabrizguliyev@hotmail.com");

        if (true) throw new UserServiceException("A user service exception is thrown");

        /*String firstName=null;
        int firstNameLength=firstName.length();*/


        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }


//        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

//        UserRest returnValue = new  UserServiceImpl().createUser(userDetails);

        UserRest returnValue = userService.createUser(userDetails);


        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }


    @PutMapping(path = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public /* String*/ UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
//        return "update user was called";
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;


    }

    @DeleteMapping(path = "/{id}")
    public /*String*/ ResponseEntity<Void> deleteUser(@PathVariable String id) {
//        return "delete user was called";
        users.remove(id);
        return ResponseEntity.noContent().build();


    }


}
