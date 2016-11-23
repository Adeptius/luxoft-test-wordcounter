package com.luxoft.consoleapplication;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleAppTest {

    private static ConsoleAppStarter appStarter;
    private static String testString = "Сьешь еще этих мягких французких булок";
    private static String[] testArray;

    @BeforeClass
    public static void init(){
        appStarter = new ConsoleAppStarter();
        testArray = testString.split(" ");
    }

    @Test
    public void getShortestWord(){
        String result = appStarter.getShortestWord(testArray);
        assertEquals("еще", result);

    }

    @Test
    public void getLongestWord(){
        String result = appStarter.getLongestWord(testArray);
        assertEquals("французких", result);

    }

    @Test
    public  void getAverageWordLength(){
        int result = appStarter.getAverageWordLength(testArray);
        assertEquals(4, result);

    }
}
