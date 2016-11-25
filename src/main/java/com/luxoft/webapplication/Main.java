package com.luxoft.webapplication;


import com.luxoft.webapplication.dao.StatisticDao;
import com.luxoft.webapplication.model.LineStatistic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "src/webapp/WEB-INF/spring/application-context.xml");
        main = context.getBean(Main.class);
        main.start();
    }

    public void init() {
        main = this;
    }


    private static Main main;
    private static StatisticDao dao;

    public void setDao(StatisticDao dao) {
        this.dao = dao;
    }

    private void start() {
        List<LineStatistic> allReports = dao.getAllStatistic();
        allReports.forEach(System.out::println);

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
