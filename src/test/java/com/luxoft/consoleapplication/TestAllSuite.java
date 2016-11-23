package com.luxoft.consoleapplication;


import com.luxoft.consoleapplication.dao.SQLiteDaoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SQLiteDaoTest.class,
        ConsoleAppTest.class
})
public class TestAllSuite {
}
