package com.luxoft.webapplication.dao;


import com.luxoft.webapplication.model.LineStatistic;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-test-context.xml")
public class SQLiteDaoTest {

    private static StatisticDao dao;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-test-context.xml");
        dao = (StatisticDao) context.getBean("dao");
    }

    @Test
    public void insert() throws Exception {
        LineStatistic expectedReport = new LineStatistic();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);

        List<LineStatistic> reports = dao.getAllStatistic();

        LineStatistic actualReport = null;
        for (LineStatistic report : reports) {
            if (report.equals(expectedReport)) {
                actualReport = report;
            }
        }
        assertEquals(expectedReport, actualReport);
        dao.delete(expectedReport);
    }


    @Test
    public void delete() {
        LineStatistic expectedReport = new LineStatistic();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);
        dao.delete(expectedReport);

        List<LineStatistic> reports = dao.getAllStatistic();
        if (reports.contains(expectedReport)) {
            fail();
        }
    }
}
