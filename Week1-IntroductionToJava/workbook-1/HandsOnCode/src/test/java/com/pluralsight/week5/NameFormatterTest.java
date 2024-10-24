package com.pluralsight.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void format_emptyFirstName_throws() {
        String result = NameFormatter.format("", "last");
        assertNull(result);
    }

    @Test
    void format_emptyLastName_throws() {
        String result = NameFormatter.format("first", "");
        assertNull(result);
    }

    @Test
    void testFormat() {
    }
}