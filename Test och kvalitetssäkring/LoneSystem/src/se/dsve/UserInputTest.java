package se.dsve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
//    private static final String TEST_NOT_WRITTEN = "Test not written!";
//    fail(TEST_NOT_WRITTEN);

    @Test
    void readNumberTestAble_String_1() {
        assertEquals(-1, UserInput.readNumberTestAble("A regular string"));
    }

    @Test
    void readNumberTestAble_String_2() {
        assertEquals(-1, UserInput.readNumberTestAble("01Adam"));
    }

    @Test
    void readNumberTestAble_String_3() {
        assertEquals(-1, UserInput.readNumberTestAble("Adam01"));
    }

    @Test
    void readNumberTestAble_Double() {
        assertEquals(-1, UserInput.readNumberTestAble("365.024"));
    }

    @Test
    void readNumberTestAble_Int() {
        assertEquals(365, UserInput.readNumberTestAble("365"));
    }

    @Test
    void readNumberTestAble_ToBigInt() {
        assertEquals(-1, UserInput.readNumberTestAble("2147483648"));
    }

    // isInteger
    @Test
    void isInteger_String_1() {
        assertFalse(UserInput.isIntegerTest("A regular string"));
    }

    @Test
    void isInteger_String_2() {
        assertFalse(UserInput.isIntegerTest("01Adam"));
    }

    @Test
    void isInteger_String_3() {
        assertFalse(UserInput.isIntegerTest("Adam01"));
    }

    @Test
    void isInteger_Double() {
        assertFalse(UserInput.isIntegerTest("365.024"));
    }

    @Test
    void isInteger_Int() {
        assertTrue(UserInput.isIntegerTest("365"));
    }

    @Test
    void isInteger_ToBigInt() {
        assertFalse(UserInput.isIntegerTest("2147483648"));
    }

    // isDouble
    @Test
    void isDouble_String_1() {
        assertFalse(UserInput.isDoubleTest("A regular string"));
    }

    @Test
    void isDouble_String_2() {
        assertFalse(UserInput.isDoubleTest("01Adam"));
    }

    @Test
    void isDouble_String_3() {
        assertFalse(UserInput.isDoubleTest("Adam01"));
    }

    @Test
    void isDouble_Double() {
        assertTrue(UserInput.isDoubleTest("365.024"));
    }

    @Test
    void isDouble_Int() {
        assertTrue(UserInput.isDoubleTest("365"));
    }

    @Test
    void isDouble_ToBigInt() {
        assertTrue(UserInput.isDoubleTest("2147483648"));
    }
}