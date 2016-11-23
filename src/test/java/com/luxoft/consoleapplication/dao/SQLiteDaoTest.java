package com.luxoft.consoleapplication.dao;

import com.luxoft.consoleapplication.model.LineReport;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class SQLiteDaoTest {

    private static SQLiteDao dao;

    @BeforeClass
    public static void init(){
        dao = new SQLiteDao();
    }

    @Test
    public void insert() throws Exception {
        LineReport expectedReport = new LineReport();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);

        List<LineReport> reports = dao.getAllReports();

        LineReport actualReport = null;
        for (LineReport report : reports) {
            if (report.equals(expectedReport)){
                actualReport = report;
            }
        }
        assertEquals(expectedReport,actualReport);

        dao.delete(expectedReport);
    }

    @Test
    public void delete(){
        LineReport expectedReport = new LineReport();
        expectedReport.setLine("This is a test line!");
        dao.insert(expectedReport);

        dao.delete(expectedReport);

        List<LineReport> reports = dao.getAllReports();

        if(reports.contains(expectedReport)){
            fail();
        }
    }
}
