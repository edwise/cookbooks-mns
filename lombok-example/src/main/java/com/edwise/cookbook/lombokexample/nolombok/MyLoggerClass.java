package com.edwise.cookbook.lombokexample.nolombok;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLoggerClass {
    private static final Logger log = LogManager.getLogger(MyLoggerClass.class);

    public void putSomeLog() {
        log.error("This is a log!!");
    }
}
