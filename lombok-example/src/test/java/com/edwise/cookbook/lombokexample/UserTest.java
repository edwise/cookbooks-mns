package com.edwise.cookbook.lombokexample;

import com.edwise.cookbook.lombokexample.lombok.User;
import org.junit.Test;

import static org.junit.Assert.fail;

public class UserTest {

    @Test(expected = NullPointerException.class)
    public void testUserLombokedSetterNameWithNameNull() {
        User user = new User().setName(null);
    }

    @Test(expected = NullPointerException.class)
    public void testUserNotLombokedSetterNameWithNameNull() {
        com.edwise.cookbook.lombokexample.nolombok.User user =
                new com.edwise.cookbook.lombokexample.nolombok.User().setName(null);
    }
}
