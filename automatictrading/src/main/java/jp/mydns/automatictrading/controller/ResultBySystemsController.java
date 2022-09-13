package jp.mydns.automatictrading.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.mydns.automatictrading.constant.CODE_CONST;
import jp.mydns.automatictrading.entity.ResultBySystem;
import jp.mydns.automatictrading.service.ResultBySystemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ResultBySystemsController {
    @Autowired 
    private ResultBySystemService resultBySystemService;

    @RequestMapping("/getMxListBySystems")
    public String getMxListBySystems(@RequestParam String systemId) throws UnsupportedEncodingException, JsonProcessingException{
        List<ResultBySystem> resultBySystemList = null;
        switch(systemId){
            case CODE_CONST.FK:
                resultBySystemList = resultBySystemService.getFkList();
                break;
            case CODE_CONST.FS:
                resultBySystemList = resultBySystemService.getFsList();
                break;
            case CODE_CONST.REFK:
                resultBySystemList = resultBySystemService.getRefkList();
                break;
            case CODE_CONST.MX:
                resultBySystemList = resultBySystemService.getMxList();
                break;
            default:
                break;
        }
        List<Map<String,Object>> json = resultBySystemService.resultBySystemResultToJson(resultBySystemList);
        return new ObjectMapper().writeValueAsString(json);
    }
}
