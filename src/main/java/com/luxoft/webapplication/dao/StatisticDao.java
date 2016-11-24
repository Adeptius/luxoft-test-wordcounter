package com.luxoft.webapplication.dao;


import com.luxoft.consoleapplication.model.LineReport;
import com.luxoft.webapplication.model.LineStatistic;

import java.util.List;

public interface StatisticDao {

    void insert(LineStatistic statistic);

    List<LineStatistic> getAllStatistic();

    void delete(LineStatistic statistic);

    void removeAll();

}
