package se.dsve;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private static final String TEST_NOT_WRITTEN = "Test not written!";
//    fail(TEST_NOT_WRITTEN);


    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Disabled
    void userInput() {
        fail(TEST_NOT_WRITTEN);
    }

    @org.junit.jupiter.api.Test
    void toLowerCase() {
        String test = "TEST";
        assertEquals(test.toLowerCase(), Application.toLowerCase(test));
    }

    @org.junit.jupiter.api.Test
    void checkIfExit_True() {
        String test = "exit";
        assertTrue(Application.checkIfExit(test));
    }

    @org.junit.jupiter.api.Test
    void checkIfExit_False() {
        String test = "eXiT";
        assertFalse(Application.checkIfExit(test));
    }

    @org.junit.jupiter.api.Test
    void calculateValueForLetters_lowercaseLetter() {
        assertEquals(1, Application.calculateValueForLetters('a'));
    }

    @org.junit.jupiter.api.Test
    void calculateValueForLetters_character() {
        assertEquals(0, Application.calculateValueForLetters('?'));
    }

    @org.junit.jupiter.api.Test
    void calculateScore_lowercaseValidLetters() {
        assertEquals(6, Application.calculateScore("abc"));
    }

    @org.junit.jupiter.api.Test
    void calculateScore_validPlusNonValidLetters() {
        assertEquals(6, Application.calculateScore("a1b?c "));
    }

    @org.junit.jupiter.api.Test
    void integrationTest() {
        toLowerCase();
        checkIfExit_True();
        checkIfExit_False();
        calculateValueForLetters_lowercaseLetter();
        calculateValueForLetters_character();
        calculateScore_lowercaseValidLetters();
        calculateScore_validPlusNonValidLetters();
        smokeTest();
    }

    @org.junit.jupiter.api.Test
    void smokeTest() {
        toLowerCase();
        calculateValueForLetters_lowercaseLetter();
        calculateScore_lowercaseValidLetters();
    }
}