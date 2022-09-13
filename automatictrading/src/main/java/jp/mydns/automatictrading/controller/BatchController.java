package jp.mydns.automatictrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.mydns.automatictrading.entity.TradeSystem;
import jp.mydns.automatictrading.service.BatchService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BatchController {
    @Autowired
    private BatchService service;

    @RequestMapping(value="/setTradeData")
    public String setTradeData(@RequestBody String json) throws JsonProcessingException{
        try{
            List<TradeSystem> tradSystemList = new ObjectMapper().readValue(json, new TypeReference<>() {});
    
            service.insertTradeSystem(tradSystemList);
        }catch(Exception e){
            return e.getMessage();
        }
        return "OK";
    }
}
