package com.luxoft.webapplication.controllers;

import com.luxoft.webapplication.Main;
import com.luxoft.webapplication.model.LineStatistic;
import com.luxoft.webapplication.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "/load-file", method = RequestMethod.POST)
    public String fileUploaded(File file) {
        try{
            MultipartFile multipartFile = file.getFile();
            BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            List<String> strings = new ArrayList<>();
            while (reader.ready()) {
                byte[] buff = reader.readLine().getBytes("Windows-1251");
                strings.add(new String(buff, "UTF-8"));
            }
            Main.saveStatistic(StringUtils.createList(multipartFile.getOriginalFilename(), strings));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "options";
    }
}
