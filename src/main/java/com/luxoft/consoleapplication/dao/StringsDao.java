package com.luxoft.consoleapplication.dao;


import com.luxoft.consoleapplication.model.LineReport;

import java.util.List;

public interface StringsDao {

    void insert(LineReport report);

    List<LineReport> getAllReports();

    void delete(LineReport report);

}
