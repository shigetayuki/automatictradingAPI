package jp.mydns.automatictrading.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.mydns.automatictrading.dto.FootkeyCanvasDto;
import jp.mydns.automatictrading.dto.FootkeyChartDto;
import jp.mydns.automatictrading.entity.TradeSystem;
import jp.mydns.automatictrading.service.FootkeyChartService;
import jp.mydns.automatictrading.service.TradeSystemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FootkeyChartController {
    @Autowired 
    private FootkeyChartService footkeyChartService;
    @Autowired
    private TradeSystemService tradeSystemService;
    
    @RequestMapping(value="/getFootkeyChart")
    public String getFootkeyChart(@RequestParam String year,@RequestParam String systemId) throws JsonProcessingException{
        FootkeyChartDto footkeyChartDto = new FootkeyChartDto();
        footkeyChartDto.setFootkeyChart(year, systemId);
        
        //最大値と最小値の取得
        List<Integer> parameterList = footkeyChartService.getParameterList(footkeyChartDto);
        //鍵足データの取得
        List<TradeSystem> tradeSystemList = tradeSystemService.getMxListByYear(footkeyChartDto);
        //取得した鍵足データの編集
        FootkeyCanvasDto footkeyCanvasDto = footkeyChartService.getFootkeyChart(parameterList,tradeSystemList,systemId);
        //jsonに変換できるようにMapに変換
        Map<String,Object> json = footkeyChartService.footkeyCanvasDtoToJson(footkeyCanvasDto);
        return new ObjectMapper().writeValueAsString(json);
    }
}
