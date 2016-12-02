package com.luxoft.webapplication.controllers;

import com.luxoft.webapplication.Main;
import com.luxoft.webapplication.model.LineStatistic;
import com.luxoft.webapplication.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.luxoft.webapplication.model.File;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "options";
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.POST)
    public String scan() {
        Main.deleteAll();
        return "options";
    }

    @RequestMapping(value = "/look-all", method = RequestMethod.POST)
    public ModelAndView look() {
        List<LineStatistic> list = Main.getAllFromBase();
        return new ModelAndView("alList", "list", list);
    }


    @RequestMapping(value = "/load-file", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public
    @ResponseBody
    String fileUploaded(Object file) {
        System.out.println(file);

        File file1 = (File) file;
        try {
            MultipartFile multipartFile = file1.getFile();
            BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            List<String> strings = new ArrayList<>();
            while (reader.ready()) {
                byte[] buff = reader.readLine().getBytes("Windows-1251");
                strings.add(new String(buff, "UTF-8"));
            }
            Main.saveStatistic(StringUtils.createList(multipartFile.getOriginalFilename(), strings));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "/load-table", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public
    @ResponseBody
    String loadTable() {
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
        List<LineStatistic> list = Main.getAllFromBase();
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
}
