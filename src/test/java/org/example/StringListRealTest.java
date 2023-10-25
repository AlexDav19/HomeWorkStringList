package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListRealTest {

        StringListReal arr = new StringListReal(5);
        String CORRECTED_STRING = "Hi";

    @Test
    void add() {
        String expectedString = CORRECTED_STRING;
        String actualString = arr.add(CORRECTED_STRING);
        assertEquals(expectedString,actualString);
    }

    @Test
    void testAdd() {


    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}