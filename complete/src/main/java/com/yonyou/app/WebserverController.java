package com.yonyou.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.apache.http.HttpRequest;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/webserver")
public class WebserverController {

    private static final Logger logger = LoggerFactory.getLogger(WebserverController.class.getName());

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        logger.info("");
        String response = "";
        // Execute a GET with timeout settings and return response content as String.
        try {
            String url = "http://151h286a02.iok.la:12230/wsd_cementapp/hello/getcementall?param={pageNum:0,pageSize:10}";
//            url = "http://www.baidu.com";
            response = Request.Get(url)
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asString();
        } catch (Exception e) {
            logger.error("");
            e.printStackTrace();
        }
        logger.info("response:{}", response);
        return response;
    }

    @RequestMapping(value="/productlist", method = RequestMethod.GET)
    public String products(HttpServletRequest request, HttpServletResponse response) {
        logger.info("");

        return null;
    }
}