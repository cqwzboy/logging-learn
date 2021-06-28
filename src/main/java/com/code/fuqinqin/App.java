package com.code.fuqinqin;

import org.badger.common.lang.util.BeanUtil;
import org.badger.logger.BadgerLoggerFactory;
import org.badger.logger.enums.LoggerLevel;
import org.badger.logger.feature.config.Log4j2Config;
import org.badger.logger.util.BadgerLoggerInitializer;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Hello world!
 *
 */
public class App {
    private static Logger LOGGER;
    private static final AtomicLong NUMBER = new AtomicLong(0);

    public static void main( String[] args ) throws InterruptedException, ClassNotFoundException {
        BeanUtil.bean2Map(new Log4j2Config());

//        new Person().say(1);
//        Class.forName(Person.class.getName());

        Log4j2Config log4j2Config = new Log4j2Config();
        log4j2Config.setFilename("logging-learn");
        log4j2Config.setFilepath("/log/logging-learn/log-2");
        log4j2Config.setLoglevel(LoggerLevel.INFO);
        log4j2Config.setFilesize("1MB");
        log4j2Config.setFilecount(30);
        log4j2Config.setRetentiontime("30d");
        log4j2Config.setMaxsize("50GB");
//        log4j2Config.setLog4j2Path("default-badger-log4j3.xml");
//        log4j2Config.setLog4j2Path("log4j2-self.xml");
        BadgerLoggerInitializer.initLog4j2(log4j2Config);

        new Person().say(2);

        LOGGER = BadgerLoggerFactory.getLogger(App.class);
        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
            LOGGER.info("logging-learn number = {}", NUMBER.getAndIncrement());
        }
    }
}
