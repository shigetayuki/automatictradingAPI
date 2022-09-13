package jp.mydns.automatictrading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.mydns.automatictrading.constant.CODE_CONST;
import jp.mydns.automatictrading.dao.FootkeyChartDao;
import jp.mydns.automatictrading.dto.CanvasContentsDto;
import jp.mydns.automatictrading.dto.CanvasTitileContentsDto;
import jp.mydns.automatictrading.dto.FootkeyCanvasDto;
import jp.mydns.automatictrading.dto.FootkeyChartDto;
import jp.mydns.automatictrading.entity.TradeSystem;

@Service
public class FootkeyChartService {
    @Autowired
    private FootkeyChartDao dao;

    public List<Integer> getParameterList(FootkeyChartDto footkeyChartDto){
        List<Integer> parameterList = null;
        try{
            parameterList = dao.getParameterList(footkeyChartDto.getYear());
        }catch(Exception e){
            e.printStackTrace();
        }
        return parameterList;
    }

    public FootkeyCanvasDto getFootkeyChart(List<Integer> parameterList,List<TradeSystem> tradeSystemList,String systemId) {
        FootkeyCanvasDto footkeyCanvasDto = new FootkeyCanvasDto();
        footkeyCanvasDto.setySize(getYsize(parameterList));
        footkeyCanvasDto = getCanvasFootkeyChart(footkeyCanvasDto,tradeSystemList,parameterList,systemId);

        return footkeyCanvasDto;
    }

    
    private static int getYsize(List<Integer> parameterList){
        int max = parameterList.get(0);
        int min = parameterList.get(1);
        return (roundUp(max,500) - roundDown(min, 500))/5;
    }

    private static int roundUp(int num,int modulo){
        int remined = 0;
        remined = num % modulo;
        return num - remined + modulo;
    }

    private static int roundDown(int num,int modulo){
        int remined = 0;
        remined = num % modulo;
        return num - remined;
    }
    
    private static FootkeyCanvasDto getCanvasFootkeyChart(FootkeyCanvasDto footkeyCanvasDto,List<TradeSystem> tradeSystemList,List<Integer> parameterList,String systemId){
        List<CanvasContentsDto> footkeyChartList = new ArrayList<>();
        List<CanvasContentsDto> resultList = new ArrayList<>();
        List<CanvasTitileContentsDto> xLabelList = new ArrayList<>();
        List<CanvasTitileContentsDto> yLabelList = new ArrayList<>();

        final int xStartPoint = 0;
        int xPoint = xStartPoint;
        String brack = "brack";
        String red = "red";
        String blue = "blue";
        String month = "";
        int max = roundUp(parameterList.get(0),500);
        int min = roundDown(parameterList.get(1),500);
        boolean mxSettlementFlg = false;

        //yラベルの設定
        for(int i=0;i<max-min;i+=500){
            CanvasTitileContentsDto canvasTitileContentsDto = setLabel(String.valueOf(max-i),i/5);
            yLabelList.add(canvasTitileContentsDto);
        }
        footkeyCanvasDto.setyLabelList(yLabelList);
        
        for(int i=0;i<tradeSystemList.size();i++){
            //Y軸のポイントを設定
            int yPoint = (max - tradeSystemList.get(i).getPrice())/5;
            //xラベルの設定
            String nowMonth = tradeSystemList.get(i).getFkDate().substring(5, 7);
            if("".equals(month)){
                month=nowMonth;
                
                CanvasTitileContentsDto canvasTitileContentsDto = setLabel(Integer.parseInt(month)+"月", xPoint);
                xLabelList.add(canvasTitileContentsDto);
            }else if(!month.equals(nowMonth)){
                month=nowMonth;
                
                CanvasTitileContentsDto canvasTitileContentsDto = setLabel(Integer.parseInt(month)+"月", xPoint);
                xLabelList.add(canvasTitileContentsDto);
            }
            footkeyCanvasDto.setxLabelList(xLabelList);
            
            
            //鍵足情報格納
            CanvasContentsDto canvasContentsDto = null;
            if(i==0){
                canvasContentsDto = setResult(yPoint, xPoint, brack);
            }else{
                if(tradeSystemList.get(i).getTrend()==tradeSystemList.get(i-1).getTrend()){
                    canvasContentsDto = setResult(yPoint, xPoint, brack);
                    footkeyChartList.add(canvasContentsDto);
                }else{
                    xPoint+=3;
                    int point = (max - tradeSystemList.get(i-1).getPrice())/5;;
                    canvasContentsDto = setResult(point, xPoint, brack);
                    footkeyChartList.add(canvasContentsDto);
                    
                    canvasContentsDto = setResult(yPoint, xPoint, brack);
                    footkeyChartList.add(canvasContentsDto);
                }
            }

            //結果情報格納
            int interest = 0;
            switch(systemId){
                case CODE_CONST.FK:
                    interest = tradeSystemList.get(i).getFkInterest();
                    if(interest>0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,red);
                        resultList.add(result);
                    }else if(interest<0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,blue);
                        resultList.add(result);
                    }
                    break;
                case CODE_CONST.FS:
                    interest = tradeSystemList.get(i).getFsInterest();
                    if(interest>0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,red);
                        resultList.add(result);
                    }else if(interest<0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,blue);
                        resultList.add(result);
                    }
                    break;
                case CODE_CONST.REFK:
                    interest = tradeSystemList.get(i).getRefkInterest();
                    if(interest>0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,red);
                        resultList.add(result);
                    }else if(interest<0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,blue);
                        resultList.add(result);
                    }
                    break;
                case CODE_CONST.MX:
                    interest = tradeSystemList.get(i).getMxInterest();
                    if(mxSettlementFlg&&interest!=0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,"");
                        resultList.add(result);
                        mxSettlementFlg=false;
                    }else if(interest>0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,red);
                        resultList.add(result);
                    }else if(interest<0){
                        CanvasContentsDto result = setResult(yPoint,xPoint,blue);
                        resultList.add(result);
                    }
                    
                    if(tradeSystemList.get(i).getMxSign()<0){
                        mxSettlementFlg=true;
                    }
                    break;
                default:
                    break;
            }
        }
        footkeyCanvasDto.setxSize(xPoint);
        footkeyCanvasDto.setFootkeyList(footkeyChartList);
        footkeyCanvasDto.setResultList(resultList);
        return footkeyCanvasDto;
    }

    public Map<String, Object> footkeyCanvasDtoToJson(FootkeyCanvasDto footkeyCanvasDto) {
        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> xLabelJson = new ArrayList<>();
        List<Map<String, Object>> yLabelJson = new ArrayList<>();
        List<Map<String, Object>> footkeyJson = new ArrayList<>();
        List<Map<String, Object>> resultJson = new ArrayList<>();


        json.put("xSize",footkeyCanvasDto.getxSize());
        json.put("ySize",footkeyCanvasDto.getySize());

        //X軸ラベルを設定
        for(CanvasTitileContentsDto f:footkeyCanvasDto.getxLabelList()){
            Map<String, Object> xLabel = new HashMap<>();
            xLabel.put("label", f.getLabel());
            xLabel.put("labelPoint",f.getLabelPoint());
            xLabelJson.add(xLabel);
        }
        json.put("xLabelList", xLabelJson);

        //y軸ラベルを設定
        for(CanvasTitileContentsDto f:footkeyCanvasDto.getyLabelList()){
            Map<String, Object> yLabel = new HashMap<>();
            yLabel.put("label", f.getLabel());
            yLabel.put("labelPoint",f.getLabelPoint());
            yLabelJson.add(yLabel);
        }
        json.put("yLabelList", yLabelJson);

        //鍵足リストを設定
        for(CanvasContentsDto f:footkeyCanvasDto.getFootkeyList()){
            Map<String, Object> footkey = new HashMap<>();
            footkey.put("xPoint",f.getxPoint());
            footkey.put("yPoint",f.getyPoint());
            footkey.put("color",f.getColor());
            footkeyJson.add(footkey);
        }
        json.put("footkeyList",footkeyJson);

        //結果リストを設定
        for(CanvasContentsDto f:footkeyCanvasDto.getResultList()){
            Map<String, Object> result = new HashMap<>();
            result.put("xPoint",f.getxPoint());
            result.put("yPoint",f.getyPoint());
            result.put("color",f.getColor());
            resultJson.add(result);
        }
        json.put("resultList",resultJson);

        return json;
    }
    private static CanvasContentsDto setResult(int yPoint, int xPoint, String color){
        CanvasContentsDto result = new CanvasContentsDto();
        result.setyPoint(yPoint);
        result.setxPoint(xPoint);
        result.setColor(color);
        return result;
    }
    private static CanvasTitileContentsDto setLabel(String label, int labelPoint){
        CanvasTitileContentsDto titleLabel = new CanvasTitileContentsDto();
        titleLabel.setLabel(label);
        titleLabel.setLabelPoint(labelPoint);
        return titleLabel;
    }
}
