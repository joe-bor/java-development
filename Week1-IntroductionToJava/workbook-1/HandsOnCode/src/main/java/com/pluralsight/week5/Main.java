package com.pluralsight.week5;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Hello");
        LOG.warn("Warning");
    }
}
