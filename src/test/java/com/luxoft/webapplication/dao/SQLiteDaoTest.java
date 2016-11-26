package com.luxoft.webapplication.dao;


import com.luxoft.webapplication.model.LineStatistic;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class SQLiteDaoTest {

    private static StatisticDao dao;

    @BeforeClass
    public static void init(){
        dao = new SQLiteHibernateDao();
    }

    @Ignore
    @Test
    public void insert() throws Exception {
        LineStatistic expectedReport = new LineStatistic();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);

        List<LineStatistic> reports = dao.getAllStatistic();

        LineStatistic actualReport = null;
        for (LineStatistic report : reports) {
            if (report.equals(expectedReport)){
                actualReport = report;
            }
        }
        assertEquals(expectedReport,actualReport);

        dao.delete(expectedReport);
    }

    @Ignore
    @Test
    public void delete(){
        LineStatistic expectedReport = new LineStatistic();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);

        dao.delete(expectedReport);

        List<LineStatistic> reports = dao.getAllStatistic();

        if(reports.contains(expectedReport)){
            fail();
        }
    }
}
