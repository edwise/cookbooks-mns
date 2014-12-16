package com.edwise.cookbook.lombokexample;

import com.edwise.cookbook.lombokexample.nolombok.UserNoLombok;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UserTest {

    @Test
    public void testUserToString() {
        // TODO ...
        UserNoLombok user = new UserNoLombok();

        String userToString = user.toString();

        assertNotNull(userToString);
    }
}
