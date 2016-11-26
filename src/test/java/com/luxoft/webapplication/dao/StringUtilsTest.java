package com.luxoft.webapplication.dao;


import com.luxoft.webapplication.utils.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    private static String testString = "Сьешь еще этих мягких французких булок";
    private static String[] testArray;

    @BeforeClass
    public static void init() {
        testArray = testString.split(" ");
    }

    @Test
    public void getShortestWord() {
        String result = StringUtils.getShortestWord(testArray);
        assertEquals("еще", result);

    }

    @Test
    public void getLongestWord() {
        String result = StringUtils.getLongestWord(testArray);
        assertEquals("французких", result);

    }

    @Test
    public void getAverageWordLength() {
        int result = StringUtils.getAverageWordLength(testArray);
        assertEquals(4, result);

    }
}
