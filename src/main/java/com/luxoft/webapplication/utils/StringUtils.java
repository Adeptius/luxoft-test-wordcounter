package com.luxoft.webapplication.utils;


import com.luxoft.webapplication.model.LineStatistic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class StringUtils {

    public static String generateHtmlTable(List<LineStatistic> list){
        StringBuilder builder = new StringBuilder();
        builder.append(
                "    <tr>\n" +
                        "        <th>String</th>\n" +
                        "        <th>length</th>\n" +
                        "        <th>Shortest</th>\n" +
                        "        <th>Longest</th>\n" +
                        "        <th>Word avg length</th>\n" +
                        "        <th>File name</th>\n" +
                        "    </tr>\n" +
                        "    \n");

        for (LineStatistic statistic : list) {
            builder.append("<tr>\n            ");
            builder.append("<td>" + statistic.getLine() + "</td>");
            builder.append("<td>" + statistic.getLineLength() + "</td>");
            builder.append("<td>" + statistic.getShortest() + "</td>");
            builder.append("<td>" + statistic.getLongest() + "</td>");
            builder.append("<td>" + statistic.getAverage() + "</td>");
            builder.append("<td>" + statistic.getFilename() + "</td>");
            builder.append("    </tr>\n");
        }
        return builder.toString();
    }

    public static List<LineStatistic> createList(String filename, String fileContent){
        String[] arr = fileContent.split("\n");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return createList(filename, list);
    }

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
