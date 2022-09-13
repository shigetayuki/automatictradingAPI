package jp.mydns.automatictrading.dto;

import java.util.List;

public class FootkeyCanvasDto {
    private int xSize;
    private int ySize;
    private List<CanvasContentsDto> footkeyList;
    private List<CanvasContentsDto> resultList;
    private List<CanvasTitileContentsDto> xLabelList;
    private List<CanvasTitileContentsDto> yLabelList;
    
    public int getxSize() {
        return xSize;
    }
    public void setxSize(int xSize) {
        this.xSize = xSize;
    }
    public int getySize() {
        return ySize;
    }
    public void setySize(int xSize) {
        this.ySize = xSize;
    }
    public List<CanvasContentsDto> getFootkeyList() {
        return footkeyList;
    }
    public void setFootkeyList(List<CanvasContentsDto> footkeyList) {
        this.footkeyList = footkeyList;
    }
    public List<CanvasContentsDto> getResultList() {
        return resultList;
    }
    public void setResultList(List<CanvasContentsDto> resultList) {
        this.resultList = resultList;
    }
    public List<CanvasTitileContentsDto> getxLabelList() {
        return xLabelList;
    }
    public void setxLabelList(List<CanvasTitileContentsDto> xLabelList) {
        this.xLabelList = xLabelList;
    }
    public List<CanvasTitileContentsDto> getyLabelList() {
        return yLabelList;
    }
    public void setyLabelList(List<CanvasTitileContentsDto> yLabelList) {
        this.yLabelList = yLabelList;
    }

    
}
