package org.example;

import org.example.exceptions.ValidationIndexException;
import org.example.exceptions.ValidationItemNullException;
import org.example.exceptions.ValidationSizeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    final int LENGTH = 5;
    final StringListImpl CORRECTED_LIST = new StringListImpl(LENGTH);
    final StringListImpl OTHER_LIST = new StringListImpl(LENGTH);
    final StringListImpl NULL_LIST = new StringListImpl(0);
    final String CORRECTED_STRING = "Hi";
    final String NULL_STRING = null;
    final int CORRECTED_INDEX = 2;


    @Test
    void addTest_success() {
        String actualString = CORRECTED_LIST.add(CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        String[] expectedList = new String[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void addTest_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.add(CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.add(NULL_STRING));
    }

    @Test
    void addTest_withIndex_success() {
        String actualString = CORRECTED_LIST.add(CORRECTED_INDEX, CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        String[] expectedList = new String[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void addTest_withIndex_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.add(CORRECTED_INDEX, CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.add(CORRECTED_INDEX, NULL_STRING));
    }

    @Test
    void set_success() {
        String actualString = CORRECTED_LIST.set(CORRECTED_INDEX, CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        String[] expectedList = new String[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void set_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.set(CORRECTED_INDEX, CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.set(CORRECTED_INDEX, NULL_STRING));

    }

    @Test
    void remove_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add("Три");

        String actualString = CORRECTED_LIST.remove(CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        String[] expectedList = new String[LENGTH];
        expectedList[0] = "Один";
        expectedList[1] = "Три";
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);

    }

    @Test
    void remove_Exception() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        assertThrows(ValidationItemNullException.class, () -> NULL_LIST.remove(CORRECTED_STRING));
    }

    @Test
    void remove_withIndex_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add("Три");

        String actualString = CORRECTED_LIST.remove(1);
        assertEquals(CORRECTED_STRING, actualString);

        String[] expectedList = new String[LENGTH];
        expectedList[0] = "Один";
        expectedList[1] = "Три";
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void remove_withIndex_Exception() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        assertThrows(ValidationIndexException.class, () -> NULL_LIST.remove(4));
    }

    @Test
    void contains_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        assertTrue(() -> CORRECTED_LIST.contains("Три"));
        assertFalse(() -> CORRECTED_LIST.contains("Четыре"));
    }

    @Test
    void indexOf_found() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        int expectedIndex = 2;
        int actualIndex = CORRECTED_LIST.indexOf("Три");
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void indexOf_notFound() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        int expectedIndex = -1;
        int actualIndex = CORRECTED_LIST.indexOf("Четыре");
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_found() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        int expectedIndex = 2;
        int actualIndex = CORRECTED_LIST.lastIndexOf("Три");
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_notFound() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        int expectedIndex = -1;
        int actualIndex = CORRECTED_LIST.lastIndexOf("Четыре");
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void get_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add("Три");

        String actualString = CORRECTED_LIST.get(1);
        assertEquals(CORRECTED_STRING, actualString);
    }

    @Test
    void get_Exception() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add("Три");

        assertThrows(ValidationIndexException.class, () -> CORRECTED_LIST.get(4));
    }

    @Test
    void testEquals_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");
        OTHER_LIST.add("Один");
        OTHER_LIST.add("Два");
        OTHER_LIST.add("Три");

        assertTrue(CORRECTED_LIST.equals(OTHER_LIST));

    }
    @Test
    void testEquals_false() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");
        OTHER_LIST.add("Один");
        OTHER_LIST.add("Два");
        OTHER_LIST.add("ЧЕТЫРЕ");

        assertFalse(CORRECTED_LIST.equals(OTHER_LIST));

    }

    @Test
    void size_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        assertEquals(3,CORRECTED_LIST.size());
    }

    @Test
    void isEmpty_false() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        assertFalse(CORRECTED_LIST.isEmpty());
    }
    @Test
    void isEmpty_true() {
        assertTrue(CORRECTED_LIST.isEmpty());
    }


    @Test
    void clear_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        StringListImpl NULL_LIST = new StringListImpl(LENGTH);
        CORRECTED_LIST.clear();
        assertArrayEquals(NULL_LIST.arr, CORRECTED_LIST.arr);
    }

    @Test
    void toArray_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");

        final StringListImpl NEW_LIST = new StringListImpl(3);
        NEW_LIST.add("Один");
        NEW_LIST.add("Два");
        NEW_LIST.add("Три");

        assertArrayEquals(NEW_LIST.arr, CORRECTED_LIST.toArray());
    }

    @Test
    void addNewPlace_success() {
        CORRECTED_LIST.add("Один");
        CORRECTED_LIST.add("Два");
        CORRECTED_LIST.add("Три");
        final StringListImpl NEW_LIST;
        String[] expectedArr = {"Один", "Два", "Три", null, null, null, null, null, null, null};
        NEW_LIST = CORRECTED_LIST.addNewPlace(10);
        assertArrayEquals(expectedArr, NEW_LIST.arr);
    }
}