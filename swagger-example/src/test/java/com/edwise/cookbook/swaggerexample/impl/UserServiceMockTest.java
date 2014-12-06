package com.edwise.cookbook.swaggerexample.impl;

import com.edwise.cookbook.swaggerexample.entity.User;
import com.edwise.cookbook.swaggerexample.service.UserService;
import com.edwise.cookbook.swaggerexample.service.impl.UserServiceMock;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserServiceMockTest {
    private static final long USER_ID_12 = 12l;
    private static final String NAME_GANDALF = "Gandalf";
    private static final int TYPE_1 = 1;
    private static final String PHONE_661534411 = "661534411";

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceMock();
    }

    @Test
    public void findById() {
        User user = userService.findById(USER_ID_12);

        assertNotNull(user);
        assertThat(user.getId(), is(USER_ID_12));
    }

    @Test
    public void findAll() {
        List<User> users = userService.findAll();

        assertNotNull(users);
        assertThat(users, hasSize(3));
    }

    @Test
    public void save() {
        User user = userService.save(
                createUser(null, NAME_GANDALF, TYPE_1, PHONE_661534411)
        );

        assertNotNull(user);
        assertNotNull(user.getId());
    }

    @Test
    public void update() {
        User user = userService.update(
                createUser(USER_ID_12, NAME_GANDALF, TYPE_1, PHONE_661534411)
        );

        assertNotNull(user);
        assertThat(user.getId(), is(USER_ID_12));
    }

    @Test
    public void delete() {
        userService.delete(USER_ID_12);
    }

    @Test
    public void exists() {
        boolean exists = userService.exists(USER_ID_12);

        assertThat(exists, is(Boolean.TRUE));
    }

    private User createUser(Long id, String name, Integer type, String phone) {
        return new User()
                .setId(id)
                .setName(name)
                .setType(type)
                .setPhone(phone);
    }
}