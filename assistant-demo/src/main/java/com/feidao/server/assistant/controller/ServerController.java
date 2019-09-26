package com.feidao.server.assistant.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.feidao.server.assistant.entity.DefinitionParams;
import com.feidao.server.assistant.entity.TimeStampEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.startup.FailedContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * LN
 * 2019/9/10 0010 10:40
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/server")
public class ServerController {
    Logger logger = LoggerFactory.getLogger(getClass());


    @PostMapping("/paramVerify")
    @ApiOperation(value = "获取参数验证模板代码")
    private String getParamVerifyCodes(@ApiParam(value = "需要验证的参数，key是字段名，value是字段类型")
                                       @RequestBody JSONObject params) {
        StringBuilder result = new StringBuilder();
        result.append("/**\n" +
                " * 校验参数\n" +
                " * @param msgNode 传参\n" +
                " */\n" +
                "private void verifyParams(JSONObject msgNode) {\n");
        for (String param : params.keySet()) {
            String paramType = params.getString(param);
            result.append("if (!msgNode.containsKey(\"").append(param).append("\")) {\n").append("        throw new BadParamException(\"").append(param).append(" 是必要参数\");\n").append("    }");
            result.append(" if (!(msgNode.get(\"").append(param).append("\") instanceof ").append(paramType).append(")) {\n").append("        throw new BadParamException(\"").append(param).append("必须是").append(paramType).append("类型\");\n").append("    }");
        }
        result.append("\n}");
        return result.toString();
    }

    /*
   {
    "prefix":"public static",
    "params":["id","name","pw"]
}
     */
    @PostMapping("/paramDefinition")
    @ApiOperation(value = "获取参数定义模板代码")
    private String getParamDefinition(@ApiParam(value = "需要定义的参数的前缀")
                                      @RequestBody DefinitionParams param) {
        String prefix = param.getPrefix();
        String[] params = param.getParams();
        Set<String> result = new TreeSet<String>();
        for (String columnName : params) {
            String column = prefix + " String " +
                    columnName.toUpperCase() +
                    " = \"" +
                    columnName +
                    "\";";
            result.add(column);
        }
        return result.toString();
    }

    @GetMapping("/timestampToString/{timeStamp}")
    @ApiOperation(value = "将时间戳转换为字符串的格式")
    private TimeStampEntity timestampToString(@ApiParam(value = "时间戳")
                                     @PathVariable(name = "timeStamp") long timeStamp) {
        TimeStampEntity timeStampEntity = new TimeStampEntity();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStampEntity.setTimestamp(timeStamp+"");
        timeStampEntity.setTimestampStr(simpleDateFormat.format(timeStamp));

        return timeStampEntity;
    }

    @GetMapping("/stringToTimestamp")
    @ApiOperation(value = "将字符串转换为时间戳的格式")
    private TimeStampEntity stringToTimestamp(@ApiParam(value = "字符串格式的时间")
                                     @RequestParam(value = "timeStr") String timeStr,
                                     @RequestParam(value = "dateFormat") String dateFormat) {
        TimeStampEntity timeStampEntity = new TimeStampEntity();
        timeStampEntity.setTimestampFormat(dateFormat);
        timeStampEntity.setTimestampStr(timeStr);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String timeStamp;
        try {
            timeStamp = simpleDateFormat.parse(timeStr).getTime() + "";
            timeStampEntity.setTimestamp(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
            timeStamp = "时间转换异常，请检查\r\n" +
                    "时间字符串：" + timeStr + "\r\n" +
                    "转换格式：" + dateFormat + "\r\n" + "是否正确！";
        }
        return timeStampEntity;
    }



}
