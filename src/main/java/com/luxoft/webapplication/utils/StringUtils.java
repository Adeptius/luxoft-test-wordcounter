package com.luxoft.webapplication.utils;


import com.luxoft.webapplication.model.LineStatistic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class StringUtils {

    public static List<LineStatistic> createList(String filename, List<String> list) {
        List<LineStatistic> statisticList = new ArrayList<>();
        for (String line : list) {
            LineStatistic statistic = StringUtils.createReport(line);
            statistic.setFilename(filename);
            statisticList.add(statistic);
        }
        return statisticList;
    }

    public static LineStatistic createReport(String line) {
        String[] words = line.split(" ");
        LineStatistic statistic = new LineStatistic();
        statistic.setLine(line);
        statistic.setLineLength(line.length());
        statistic.setShortest(getShortestWord(words));
        statistic.setLongest(getLongestWord(words));
        statistic.setAverage(getAverageWordLength(words));
        return statistic;
    }

    public static String getShortestWord(String[] words) {

        String shorten = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(" ")) {
                continue;
            }
            if (shorten.equals("")) {
                shorten = words[i];
            }
            if (words[i].length() < shorten.length()) {
                shorten = words[i];
            }
        }
        return shorten;
    }


    public static String getLongestWord(String[] words) {
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


    public static int getAverageWordLength(String[] words) {
        if (words.length > 0) {
            int lenght = 0;
            for (int i = 1; i < words.length; i++) {
                lenght += words[i].length();
            }
            return lenght / words.length;
        } else return 0;
    }
}
