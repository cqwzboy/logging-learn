package com.code.fuqinqin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {
//    private static Logger log = BadgerLoggerFactory.getLogger(Person.class);

    public void say(Integer i){
        log.info("person say: {}, index = {}", "Hello World!", i);
    }
}
