package com.pluralsight.week9.jdbc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App2{
//    final static Logger logger = Logger.getLogger(App2.class);
        final static Logger LOGGER = LogManager.getLogger(App2.class);
    public static void main(String[] args) {
        logMeLikeYouDo("☕ ");
    }

    private static void logMeLikeYouDo(String input){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("This is debug : " + input);
        }
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("This is info : " + input);
        }
        LOGGER.warn("This is warn : " + input);
        LOGGER.error("This is error : " + input);
        LOGGER.fatal("This is fatal : " + input);
    }
}