package jp.mydns.automatictrading.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.mydns.automatictrading.constant.CODE_CONST;
import jp.mydns.automatictrading.dto.ResultByMonthsDto;
import jp.mydns.automatictrading.entity.TradeSystem;
import jp.mydns.automatictrading.service.CodeService;
import jp.mydns.automatictrading.service.TradeSystemService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ResultByMonthsController {
    @Autowired
    HttpSession session;
    @Autowired 
    private TradeSystemService tradeSystemService;

    @Autowired 
    private CodeService codeService;
    
    @RequestMapping("/getMxListByMonths")
    public String getMxListByMonths(@RequestParam String year,@RequestParam String month) throws UnsupportedEncodingException{
        try{
            ResultByMonthsDto resultByMonthsDto = new ResultByMonthsDto();
            resultByMonthsDto.setResultByMonthsDto(year, month);
            List<TradeSystem> tradeSystemList = tradeSystemService.getMxListByMonths(resultByMonthsDto);
            Map<String,String> codeMap = codeService.getCodeNameBySymbol(CODE_CONST.SIGNAL);
            List<Map<String,Object>> json = tradeSystemService.tradeSystemDataToJson(tradeSystemList,codeMap);
            
            return new ObjectMapper().writeValueAsString(json);
        }catch(Exception e){
            return "";
        }
    }
}
