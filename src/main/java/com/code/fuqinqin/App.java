package com.code.fuqinqin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badger.logger.BadgerLoggerFactory;
import org.badger.logger.enums.LoggerLevel;
import org.badger.logger.enums.LoggerType;
import org.badger.logger.feature.config.Log4j2Config;
import org.badger.logger.util.BadgerLoggerEnvironment;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Hello world!
 *
 */
public class App {
//    private static final Logger LOGGER = BadgerLoggerFactory.getLogger(App.class);
    private static final Logger LOGGER;
    private static final AtomicLong NUMBER = new AtomicLong(0);

    static {
        BadgerLoggerEnvironment.setType(LoggerType.LOG4J2);
        Log4j2Config log4j2Config = new Log4j2Config();
        log4j2Config.setFilename("logging-learn");
        log4j2Config.setFilepath("/IdeaProjects/self/logging-learn/log");
        log4j2Config.setLoglevel(LoggerLevel.INFO);
        log4j2Config.setFilesize("1MB");
        log4j2Config.setFilecount(30);
        log4j2Config.setRetentiontime("30d");
        log4j2Config.setMaxsize("50GB");
        BadgerLoggerEnvironment.initLog4j2(log4j2Config);

//        LOGGER = BadgerLoggerFactory.getLogger(App.class);
        LOGGER = LogManager.getLogger(App.class);
    }

    public static void main( String[] args ) throws InterruptedException {
        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
            LOGGER.info("logging-learn number = {}", NUMBER.getAndIncrement());
        }
    }
}
