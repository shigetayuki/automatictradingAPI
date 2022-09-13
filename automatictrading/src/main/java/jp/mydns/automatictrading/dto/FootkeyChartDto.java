package jp.mydns.automatictrading.dto;

public class FootkeyChartDto {
    private String year;
    private String systemId;

    public void setFootkeyChart(String year,String systemId){
        this.year = year;
        this.systemId = systemId;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getSystemId() {
        return systemId;
    }
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    
}
