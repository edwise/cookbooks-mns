package com.edwise.cookbook.swaggerexample.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private static final long USER_ID_12 = 12L;
    private static final String NAME_GANDALF = "Gandalf";
    private static final int TYPE_1 = 1;
    private static final String PHONE_661534411 = "661534411";

    @Test
    public void copyFrom() {
        User user = createUser(USER_ID_12, NAME_GANDALF, TYPE_1, PHONE_661534411);
        User userTo = createUser(USER_ID_12, null, null, null);

        userTo.copyFrom(user);

        assertEquals(userTo, user);
    }

    private User createUser(Long id, String name, Integer type, String phone) {
        return new User()
                .setId(id)
                .setName(name)
                .setType(type)
                .setPhone(phone);
    }
}