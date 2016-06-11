package com.yonyou.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by okay on 16/6/10.
 */
public class ResponseEntity {

    private static final Logger logger = LoggerFactory.getLogger(ResponseEntity.class.getName());

    JSONObject status = new JSONObject();

    List<JSONObject> result = new ArrayList<>();

//    private Integer total = 3;

    public ResponseEntity() {
        status.put("status_code", Integer.valueOf(0));
        status.put("status_reason", "1");
//        total = 3;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("YWM_Name","PC32.5袋装");
        jsonObject.put("YWM_ID",1001);
        jsonObject.put("YWM_Unit","吨");
        jsonObject.put("YWM_Code","SC20160608001");
        jsonObject.put("YWM_Validate","2019-01-01 12:01:00");
        jsonObject.put("YWM_CDate","2016-03-03 12:01:00");
        jsonObject.put("YWM_Kind","2001001");
        result.add(jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("YWM_Name","PC42.5R袋装");
        jsonObject2.put("YWM_ID",2001);
        jsonObject2.put("YWM_Unit","吨");
        jsonObject2.put("YWM_Code","FD20160608001");
        jsonObject2.put("YWM_Validate","2019-03-03 12:01:00");
        jsonObject2.put("YWM_CDate","2016-02-02 12:01:00");
        jsonObject2.put("YWM_Kind","2002001");
        result.add(jsonObject2);

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("YWM_Name","PC32.5袋装");
        jsonObject3.put("YWM_ID",3001);
        jsonObject3.put("YWM_Unit","吨");
        jsonObject3.put("YWM_Code","SZ20160608001");
        jsonObject3.put("YWM_Validate","2019-03-03 12:01:00");
        jsonObject3.put("YWM_CDate","2015-03-03 12:01:00");
        jsonObject3.put("YWM_Kind","3001001");
        result.add(jsonObject3);

        String js;
        try {
            js = new ObjectMapper().writer().writeValueAsString(result);
            logger.info("result:{}", js);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
