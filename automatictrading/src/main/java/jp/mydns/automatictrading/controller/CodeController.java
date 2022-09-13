package jp.mydns.automatictrading.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.mydns.automatictrading.service.CodeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CodeController {
    @Autowired CodeService codeService;

    @RequestMapping(value= "/getCodeList")
    public String getCodeList() throws JsonProcessingException{
        Map<String,Map<String,String>> json = codeService.getCodeAll();
        return new ObjectMapper().writeValueAsString(json);
    }

    @RequestMapping(value="/getCodeListById")
    public String getCodeListById(@RequestParam String codeId) throws JsonProcessingException{
        List<Map<String,String>> json = codeService.getCodeById(codeId);
        return new ObjectMapper().writeValueAsString(json);
    }
}
