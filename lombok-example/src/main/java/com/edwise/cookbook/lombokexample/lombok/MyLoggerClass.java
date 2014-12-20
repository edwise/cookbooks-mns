package com.edwise.cookbook.lombokexample.lombok;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyLoggerClass {

    public void putSomeLog() {
        log.error("This is a log!!");
    }
}
