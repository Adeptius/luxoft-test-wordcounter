package com.luxoft.webapplication.dao;

import com.luxoft.webapplication.model.LineStatistic;

import java.util.List;

public class DbController {

    private static StatisticDao dao;

    public void setDao(StatisticDao dao) {
        this.dao = dao;
    }

    public static List<LineStatistic> getAllFromBase(){
        return dao.getAllStatistic();
    }

    public static void saveStatistic(List<LineStatistic> list){
        for (LineStatistic lineStatistic : list) {
            dao.insert(lineStatistic);
        }
    }

    public static void deleteAll(){
        dao.deleteAll();
    }
}
