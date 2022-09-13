package jp.mydns.automatictrading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.mydns.automatictrading.dao.TradeSystemDao;
import jp.mydns.automatictrading.dto.FootkeyChartDto;
import jp.mydns.automatictrading.dto.ResultByMonthsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.mydns.automatictrading.entity.TradeSystem;

@Service
public class TradeSystemService {
    @Autowired
    private TradeSystemDao dao;

    public List<TradeSystem> getMxListByMonths(ResultByMonthsDto resultByMonthsDto){
        List<TradeSystem> systemList = null;
        try{
            StringBuilder sb = new StringBuilder();
            sb.append(resultByMonthsDto.getYear());
            sb.append("/");
            sb.append(String.format("%02d",resultByMonthsDto.getMonth()));
            sb.append("%");
            
            systemList = dao.getMxListByMonths(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }

    /**
     * 月別結果をjsonに変換する
     * @param tradeSystemList
     * @return
     */
    public List<Map<String,Object>> tradeSystemDataToJson(List<TradeSystem> tradeSystemList,Map<String,String> codeMap){
        List<Map<String,Object>> json = new ArrayList<>();
        
        for(TradeSystem tradeSystem:tradeSystemList){
            Map<String,Object> map = new HashMap<>();
            map.put("fkId",tradeSystem.getFkId());
            map.put("fkDate",tradeSystem.getFkDate());
            map.put("fkTime",tradeSystem.getFkTime());
            map.put("price",tradeSystem.getPrice());
            map.put("trend",tradeSystem.getTrend());
            map.put("mountain",tradeSystem.getMountain());
            map.put("valley",tradeSystem.getValley());
            map.put("fkSign",codeMap.get(((Integer)tradeSystem.getFkSign()).toString()));
            map.put("fkInterest",tradeSystem.getFkInterest());
            map.put("fkPrevOrderLocation",tradeSystem.getFkPrevOrderLocation());
            map.put("fsSign",codeMap.get(((Integer)tradeSystem.getFsSign()).toString()));
            map.put("fsInterest",tradeSystem.getFsInterest());
            map.put("fsPrevOrderLocation",tradeSystem.getFsPrevOrderLocation());
            map.put("refkSign",codeMap.get(((Integer)tradeSystem.getRefkSign()).toString()));
            map.put("refkInterest",tradeSystem.getRefkInterest());
            map.put("refkPrevOrderLocation",tradeSystem.getRefkPrevOrderLocation());
            map.put("mxSign",codeMap.get(((Integer)tradeSystem.getMxSign()).toString()));
            map.put("mxInterest",tradeSystem.getMxInterest());
            map.put("mxPrevOrderLocation",tradeSystem.getMxPrevOrderLocation());
            json.add(map);
        }
        return json;
    }

    public List<TradeSystem> getMxListByYear(FootkeyChartDto footkeyChartDto) {
        List<TradeSystem> systemList = null;
        try{
            systemList = dao.getMxListByYear(footkeyChartDto.getYear()+"%");
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }

}
