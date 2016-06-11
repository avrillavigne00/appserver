package com.yonyou.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class.getName());

    private final AtomicLong counter = new AtomicLong();

    protected final static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        counter.incrementAndGet();
        String response;
//        try {//mapper.writer().writeValueAsString(responseEntity);
//        } catch (JsonProcessingException e) {
//            return null;
//        }
        JSONObject responseEntity = new JSONObject();

        JSONObject status = new JSONObject();

        List<JSONObject> result = new ArrayList<>();
        status.put("status_code", Integer.valueOf(0));
        status.put("status_reason", "");

        JSONObject supplier = new JSONObject();
        supplier.put("id",1);
        supplier.put("supplier_name","天猫政企采购平台");
//        "supplier": {
//            "id": 1,
//                    "supplier_name": "天猫政企采购平台"
//        },

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("YWM_Name","PC32.5袋装");
        // TODO add service filed
        jsonObject.put("YWM_PicName","1.jpg");
        jsonObject.put("YWM_ID",1001);
        jsonObject.put("YWM_Unit","吨");
        jsonObject.put("YWM_Code","SC20160608001");
        jsonObject.put("YWM_Validate","2019-01-01 12:01:00");
        jsonObject.put("YWM_CDate","2016-03-03 12:01:00");
        jsonObject.put("YWM_Kind","2001001");
        // TODO add service filed
        jsonObject.put("YWM_Price",340.00);

//            jsonObject.put("supplier",supplier);
        result.add(jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("YWM_Name","PC42.5R袋装");
        // TODO add service filed
        jsonObject2.put("YWM_PicName","1.jpg");
        jsonObject2.put("YWM_ID",2001);
        jsonObject2.put("YWM_Unit","吨");
        jsonObject2.put("YWM_Code","FD20160608001");
        jsonObject2.put("YWM_Validate","2019-03-03 12:01:00");
        jsonObject2.put("YWM_CDate","2016-02-02 12:01:00");
        jsonObject2.put("YWM_Kind","2002001");
        // TODO add service filed
        jsonObject2.put("YWM_Price",340.00);
//            jsonObject2.put("supplier",supplier);
        result.add(jsonObject2);

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("YWM_Name","PC32.5袋装");
        // TODO add service filed
        jsonObject3.put("YWM_PicName","1.jpg");
        jsonObject3.put("YWM_ID",3001);
        jsonObject3.put("YWM_Unit","吨");
        jsonObject3.put("YWM_Code","SZ20160608001");
        jsonObject3.put("YWM_Validate","2019-03-03 12:01:00");
        jsonObject3.put("YWM_CDate","2015-03-03 12:01:00");
        jsonObject3.put("YWM_Kind","3001001");
        // TODO add service filed
        jsonObject3.put("YWM_Price",340.00);

//            jsonObject3.put("supplier",supplier);
        result.add(jsonObject3);


        Integer total = 3;
        responseEntity.put("total", total);
        responseEntity.put("status", status);
        responseEntity.put("result", result);

        response = responseEntity.toString();
        logger.info("respose:{}", response);
        return response;
    }

}