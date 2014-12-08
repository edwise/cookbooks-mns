package com.edwise.cookbook.swaggerexample.controller;

import com.edwise.cookbook.swaggerexample.entity.User;
import com.edwise.cookbook.swaggerexample.service.UserService;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "users", description = "Users API Rest")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get All Users", notes = "Returns all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!")
    })
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "Get one Users", response = ResponseEntity.class, notes = "Returns one user by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exists this user"),
            @ApiResponse(code = 404, message = "Not exists this user")
    })
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@ApiParam(defaultValue = "1", value = "The id of the user to return")
                                        @PathVariable long userId) {
        User user = userService.findById(userId);
        ResponseEntity<User> response;
        if (user == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(user, HttpStatus.OK);
        }
        return response;
    }

    @ApiOperation(value = "Create Users", notes = "Create a user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful create of a user")
    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUser(@RequestBody User user) {
        userService.save(user);
    }

    @ApiOperation(value = "Update User", notes = "Update a user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful update of this user"),
            @ApiResponse(code = 404, message = "Not exists this user")
    })
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@ApiParam(defaultValue = "1", value = "The id of the user to update")
                                           @PathVariable long userId, @RequestBody User user) {
        User userOld = userService.findById(userId);
        ResponseEntity<User> response;
        if (userOld != null) {
            User userUpdated = userService.update(userOld.copyFrom(user));
            response = new ResponseEntity<>(userUpdated, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Delete User", notes = "Delete a user")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Successful delete of a user"),
            @ApiResponse(code = 404, message = "Not exists this user")
    })
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@ApiParam(defaultValue = "1", value = "The id of the user to delete")
                                           @PathVariable long userId) {
        ResponseEntity<User> response;
        if (userService.exists(userId)) {
            userService.delete(userId);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
