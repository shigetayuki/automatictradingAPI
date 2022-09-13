package jp.mydns.automatictrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(value=ResultBySystemKey.class)
public class ResultBySystem {
    //FOOTKEY
    //システム別集計
    @Id
    @Column(name="year")
    private String year;

    @Id
    @Column(name="month")
    private String month;

    @Column(name="interest")
    private String interest;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
    
}
