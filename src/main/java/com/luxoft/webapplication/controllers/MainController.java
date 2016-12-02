package com.luxoft.webapplication.controllers;

import com.luxoft.webapplication.Main;
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
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "options";
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.GET)
    public String scan() {
        Main.deleteAll();
        return "options";
    }

    @RequestMapping(value = "/load-table", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public
    @ResponseBody
    String loadTable() {
        List<LineStatistic> list = Main.getAllFromBase();
        return StringUtils.generateHtmlTable(list);
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        try {
            int length = mpf.getBytes().length;
            byte[] bytes = mpf.getBytes();
            String type = mpf.getContentType();
            String filename = mpf.getOriginalFilename();

            String result = new String(bytes, "UTF-8");
            List<LineStatistic> stat = StringUtils.createList(filename, result);
            Main.saveStatistic(stat);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
