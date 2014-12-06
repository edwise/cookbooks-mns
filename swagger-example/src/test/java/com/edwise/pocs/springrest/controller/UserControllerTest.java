package com.edwise.pocs.springrest.controller;

import com.edwise.pocs.springrest.entity.User;
import com.edwise.pocs.springrest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static final long USER_ID_12 = 12l;
    private static final long USER_ID_140 = 140l;
    private static final long USER_ID_453321 = 45332l;
    private static final String NAME_GANDALF = "Gandalf";
    private static final String NAME_ARAGORN = "Aragorn";
    private static final String NAME_FRODO = "Frodo";
    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;
    private static final String PHONE_666554433 = "666554433";
    private static final String PHONE_661534411 = "661534411";
    private static final String PHONE_666222211 = "666222211";

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers_withUsers_returnSeveralUsers() {
        when(userService.findAll()).thenReturn(Arrays.asList(
                createUser(USER_ID_12, NAME_GANDALF, TYPE_1, PHONE_666554433),
                createUser(USER_ID_140, NAME_ARAGORN, TYPE_1, PHONE_661534411),
                createUser(USER_ID_453321, NAME_FRODO, TYPE_2, PHONE_666222211)
        ));

        List<User> users = userController.getAllUsers();

        verify(userService).findAll();
        assertNotNull(users);
        assertThat(users, hasSize(3));
    }

    @Test
    public void getAllUsers_withoutUsers_returnEmptyList() {
        when(userService.findAll()).thenReturn(new ArrayList<>(0));

        List<User> users = userController.getAllUsers();

        verify(userService).findAll();
        assertNotNull(users);
        assertThat(users, hasSize(0));
    }

    @Test
    public void getUser_existUser_returnUser() {
        when(userService.findById(USER_ID_12)).thenReturn(
                createUser(USER_ID_12, NAME_GANDALF, TYPE_1, PHONE_661534411));

        ResponseEntity<User> response = userController.getUser(USER_ID_12);

        verify(userService).findById(USER_ID_12);
        assertNotNull(response);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), isA(User.class));
        assertThat(response.getBody().getId(), is(USER_ID_12));
    }

    @Test
    public void getUser_notExistUser_returnNotFound() {
        when(userService.findById(USER_ID_12)).thenReturn(null);

        ResponseEntity<User> response = userController.getUser(USER_ID_12);


        verify(userService).findById(USER_ID_12);
        assertNotNull(response);
        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
        assertNull(response.getBody());
    }

    @Test
    public void insertUser() {
        when(userService.save(any(User.class))).then(returnsFirstArg());
        User user = createUser(null, NAME_GANDALF, TYPE_1, PHONE_661534411);

        userController.insertUser(user);

        verify(userService).save(user);
    }

    @Test
    public void updateUser_existsUser_updateTheUser() {
        User userOld = createUser(USER_ID_12, NAME_GANDALF, TYPE_1, PHONE_661534411);
        User user = createUser(USER_ID_12, null, null, PHONE_666222211);
        when(userService.findById(USER_ID_12)).thenReturn(userOld);
        when(userService.update(any(User.class))).then(returnsFirstArg());

        userController.updateUser(USER_ID_12, user);

        verify(userService).findById(USER_ID_12);
        verify(userService).update(userOld.setPhone(PHONE_666222211));
    }

    @Test
    public void updateUser_notExistUser_noUpdateTheUser() {
        when(userService.findById(USER_ID_12)).thenReturn(null);
        User user = createUser(USER_ID_12, null, null, PHONE_666222211);

        userController.updateUser(USER_ID_12, user);

        verify(userService).findById(USER_ID_12);
        verify(userService, never()).update(any(User.class));
    }

    @Test
    public void deleteUser() {
        doNothing().when(userService).delete(anyLong());

        userController.deleteUser(USER_ID_12);

        verify(userService).delete(USER_ID_12);
    }

    private User createUser(Long id, String name, Integer type, String phone) {
        return new User()
                .setId(id)
                .setName(name)
                .setType(type)
                .setPhone(phone);
    }
}