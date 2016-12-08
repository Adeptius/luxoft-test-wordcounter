package com.luxoft.webapplication.controllers;

import com.luxoft.webapplication.dao.DbController;
import com.luxoft.webapplication.model.LineStatistic;
import com.luxoft.webapplication.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        System.out.println("options");
        return "options";
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.GET)
    public String scan() {
        System.out.println("delete-all");
        DbController.deleteAll();
        return "options";
    }

    @RequestMapping(value = "/load-table", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public
    @ResponseBody
    String loadTable() {
        System.out.println("load-table");
        List<LineStatistic> list = DbController.getAllFromBase();
        return StringUtils.generateHtmlTable(list);
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        System.out.println("upload");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        try {
            byte[] bytes = mpf.getBytes();
            String filename = mpf.getOriginalFilename();
            String result = new String(bytes, "UTF-8");
            List<LineStatistic> stat = StringUtils.createList(filename, result);
            DbController.saveStatistic(stat);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
