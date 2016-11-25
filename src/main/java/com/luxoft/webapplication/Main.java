package com.luxoft.webapplication;


import com.luxoft.webapplication.dao.StatisticDao;
import com.luxoft.webapplication.model.LineStatistic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Main {


    /**
     * Description of the task is so ambiguous
     * that I have made an console application
     * and web application independent of each other
     */
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
        //String path = "D:\\Text.txt";
        //readFileForStatistic(path);

        //dao.insert(statistic);
        List<LineStatistic> allReports = dao.getAllStatistic();
        allReports.forEach(System.out::println);

    }

    public static List<LineStatistic> getAllFromBase(){
        return dao.getAllStatistic();
    }

    public static void scanFile(String path){

        List<LineStatistic> list = main.readFileForStatistic(path);
        for (LineStatistic lineStatistic : list) {
            dao.insert(lineStatistic);
        }
    }

    public static void deleteAll(){
        dao.deleteAll();
    }

    private List<LineStatistic> readFileForStatistic(String path) {
        Path pathToFile = Paths.get(path);
        List<LineStatistic> statisticList = new ArrayList<>();
        try {
            List<String> list = Files.readAllLines(pathToFile);
            for (String line : list) {
                LineStatistic statistic = createReport(line);
                statistic.setFilename(pathToFile.getFileName().toString());
                statisticList.add(statistic);
            }
        } catch (IOException e) {
            System.out.println("Cant read the file " + pathToFile.toString());
        }
        return statisticList;
    }


    public LineStatistic createReport(String line) {
        String[] words = line.split(" ");
        LineStatistic statistic = new LineStatistic();
        statistic.setLine(line);
        statistic.setLineLength(line.length());
        statistic.setShortest(getShortestWord(words));
        statistic.setLongest(getLongestWord(words));
        statistic.setAverage(getAverageWordLength(words));
        return statistic;
    }

    public String getShortestWord(String[] words) {
        if (words.length > 0) {
            String shorten = words[0];
            for (int i = 1; i < words.length; i++) {
                if (words[i].length() < shorten.length()) {
                    shorten = words[i];
                }
            }
            return shorten;
        } else return "";
    }


    public String getLongestWord(String[] words) {
        if (words.length > 0) {
            String longest = words[0];
            for (int i = 1; i < words.length; i++) {
                if (words[i].length() > longest.length()) {
                    longest = words[i];
                }
            }
            return longest;
        } else return "";
    }


    public int getAverageWordLength(String[] words) {
        if (words.length > 0) {
            int lenght = 0;
            for (int i = 1; i < words.length; i++) {
                lenght += words[i].length();
            }
            return lenght / words.length;
        } else return 0;
    }


}
