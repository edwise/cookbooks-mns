package com.edwise.cookbook.lombokexample;

import com.edwise.cookbook.lombokexample.lombok.MyLoggerClass;
import org.junit.Test;

public class MyLoggerClassTest {

    @Test
    public void testMyLoggerClassLombokedPutSomeLog() {
        MyLoggerClass loggerClass = new MyLoggerClass();

        loggerClass.putSomeLog();
    }

    @Test
    public void testMyLoggerClassNotLombokedPutSomeLog() {
        com.edwise.cookbook.lombokexample.nolombok.MyLoggerClass loggerClass =
                new com.edwise.cookbook.lombokexample.nolombok.MyLoggerClass();

        loggerClass.putSomeLog();
    }
}
