package com.luxoft.consoleapplication;


import com.luxoft.consoleapplication.dao.SQLiteDao;
import com.luxoft.consoleapplication.dao.StringsDao;
import com.luxoft.consoleapplication.model.LineReport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * -  Read txt file and split it by lines
 * -  Calculate statistic for each line: longest word(symbols between 2 spaces),
 *    shortest word, line length, average word length. Unit test are mandatory
 * -  Aggregate these values for all lines from file(unit test)
 * -  Store line and file statistic into DB(with JDBC).
 *
 *    Using SQLite db for more simplicity
 */
public class ConsoleAppStarter {

    private StringsDao dao = new SQLiteDao();

    public static void main(String[] args) {
        ConsoleAppStarter appStarter = new ConsoleAppStarter();
        appStarter.run();
    }

    /**
     * Put your path to test file into String path.
     */
    private void run() {
        String path = "D:\\Text.txt";
        Path pathToFile = Paths.get(path);

        try {
            List<String> list = Files.readAllLines(pathToFile);
            for (String line : list) {
                LineReport lineReport = createReport(line);
                System.out.println(lineReport);
                dao.insert(lineReport);
            }
        } catch (IOException e) {
            System.out.println("Cant read the file " + pathToFile.toString());
        }
    }

    private LineReport createReport(String line) {
        String[] words = line.split(" ");
        LineReport lineReport = new LineReport();
        lineReport.setLine(line);
        lineReport.setLineLength(line.length());
        lineReport.setShortest(getShortestWord(words));
        lineReport.setLongest(getLongestWord(words));
        lineReport.setAverage(getAverageWordLength(words));
        return lineReport;
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
