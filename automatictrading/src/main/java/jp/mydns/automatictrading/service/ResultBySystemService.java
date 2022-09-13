package jp.mydns.automatictrading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.mydns.automatictrading.dao.ResultBySystemDao;
import jp.mydns.automatictrading.entity.ResultBySystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultBySystemService {
    @Autowired
    private ResultBySystemDao dao;

    public List<ResultBySystem> getFkList(){
        List<ResultBySystem> systemList = null;
        try{
            systemList = dao.getFkList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }

    public List<ResultBySystem> getFsList(){
        List<ResultBySystem> systemList = null;
        try{
            systemList = dao.getFsList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }

    public List<ResultBySystem> getRefkList(){
        List<ResultBySystem> systemList = null;
        try{
            systemList = dao.getRefkList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }

    public List<ResultBySystem> getMxList(){
        List<ResultBySystem> systemList = null;
        try{
            systemList = dao.getMxList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }
    /**
     * システム別結果をjsonに変換する
     * @param ResultBySystemList
     * @return
     */
    public List<Map<String,Object>> resultBySystemResultToJson(List<ResultBySystem> ResultBySystemList){
        List<Map<String,Object>> json = new ArrayList<>();
        String year = "";
        int total = 0;
        Map<String,Object> map = null;
        for(ResultBySystem ResultBySystem:ResultBySystemList){
            //初回
            if(year.equals("")){
                year = ResultBySystem.getYear();
                map = new HashMap<>();
                map.put("year",ResultBySystem.getYear());
            }
            
            //月別の収益を設定
            if(year.equals(ResultBySystem.getYear())){
                map.put("interest" + ResultBySystem.getMonth(),ResultBySystem.getInterest());
                total+=Integer.parseInt(ResultBySystem.getInterest());
           
            //年が切り替わった際にjsonに格納する
            }else{
                map.put("total",total);
                json.add(map);
                total=Integer.parseInt(ResultBySystem.getInterest());

                year = ResultBySystem.getYear();
                map = new HashMap<>();
                map.put("year",ResultBySystem.getYear());
                map.put("interest" + ResultBySystem.getMonth(),ResultBySystem.getInterest());
            }
        }

        //取引されていない月を補完する
        int month = Integer.parseInt(ResultBySystemList.get(ResultBySystemList.size()-1).getMonth());
        for(int i=12-month;i>=0;i--){
            map.put("interest" + String.format("%02d", 12-i),"");
        }
        map.put("total",total);
        json.add(map);
        return json;
    }
}
