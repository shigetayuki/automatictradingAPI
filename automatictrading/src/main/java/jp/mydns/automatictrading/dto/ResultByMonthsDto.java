package jp.mydns.automatictrading.dto;

public class ResultByMonthsDto {
    private Integer year;
    private Integer month;

    public void setResultByMonthsDto(String year,String month)throws Exception{
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    
}
