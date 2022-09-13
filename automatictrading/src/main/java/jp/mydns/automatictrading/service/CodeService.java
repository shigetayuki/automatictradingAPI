package jp.mydns.automatictrading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.mydns.automatictrading.dao.CodeDao;
import jp.mydns.automatictrading.entity.Code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
    @Autowired
    private CodeDao dao;

    /**
     * 使用禁止
     * @deprecated
     * @return
     */
    public Map<String,Map<String,String>> getCodeAll(){
        Map<String,Map<String,String>> results = new HashMap<>();
        List<Code> codeList = null;
        try {
            codeList = dao.findAll();
            
            //詰め替え処理
            String chkStr = codeList.get(0).getCodeId();
            Map<String,String> codeMap = new HashMap<>();
            for(Code c:codeList){
                //最後の要素またはコードIDが変わった場合
                if(codeList.get(codeList.size()-1).equals(c)
                || !chkStr.equals(c.getCodeId())){
                    
                    codeMap.put(c.getCodeSymbol(),c.getCodeName());
                    results.put(c.getCodeId(),codeMap);
                    codeMap = new HashMap<>();
                    chkStr = c.getCodeId();
                //コードIDが同じだった場合
                }else if(chkStr.equals(c.getCodeId())){
                    codeMap.put(c.getCodeSymbol(),c.getCodeName());
                }

                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Map<String,String>> getCodeById(String codeId){
        List<Code> codeList = null;
        List<Map<String,String>> mapList = new ArrayList<>();
        Map<String,String> codeMap = null;
        try {
            codeList = dao.getCodeById(codeId);
            //詰め替え
            for(Code c:codeList){
                codeMap = new HashMap<>();
                codeMap.put("codeSymbol", c.getCodeSymbol());
                codeMap.put("codeName", c.getCodeName());
                mapList.add(codeMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapList;
    }

    public Map<String,String> getCodeNameBySymbol(String codeId){
        List<Code> codeList = null;
        Map<String,String> codeMap = new HashMap<>();;
        try {
            codeList = dao.getCodeById(codeId);
            //詰め替え
            for(Code c:codeList){
                codeMap.put(c.getCodeSymbol(),c.getCodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return codeMap;
    }
}
