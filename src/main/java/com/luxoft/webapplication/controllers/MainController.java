package com.luxoft.webapplication.controllers;

import com.luxoft.webapplication.Main;
import com.luxoft.webapplication.model.LineStatistic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        List<LineStatistic> list = Main.getAllFromBase();

        return new ModelAndView("alList", "list", list);
    }


    @RequestMapping(value = "/scan-file", method = RequestMethod.POST)
    public String scan(String path){
        System.out.println(path);
        Main.scanFile(path);
        return "alList";
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.POST)
    public String scan(){
        Main.deleteAll();
        return "alList";
    }

}
