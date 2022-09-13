package jp.mydns.automatictrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="footkey_t")
public class Footkey {
    @Id
    @Column(name="fk_id")
    private int fkId;
    @Column(name="date")
    private String fkDate;
    @Column(name="time")
    private String fkTime;
    @Column(name="price")
    private int price;
    @Column(name="trend")
    private int trend;
    @Column(name="mountain")
    private int mountain;
    @Column(name="valley")
    private int valley;
    @Column(name="send_flg")
    private String sendFlg;
    
    public int getFkId() {
        return fkId;
    }
    public void setFkId(int fkId) {
        this.fkId = fkId;
    }
    public String getFkDate() {
        return fkDate;
    }
    public void setFkDate(String fkDate) {
        this.fkDate = fkDate;
    }
    public String getFkTime() {
        return fkTime;
    }
    public void setFkTime(String fkTime) {
        this.fkTime = fkTime;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getTrend() {
        return trend;
    }
    public void setTrend(int trend) {
        this.trend = trend;
    }
    public int getMountain() {
        return mountain;
    }
    public void setMountain(int mountain) {
        this.mountain = mountain;
    }
    public int getValley() {
        return valley;
    }
    public void setValley(int valley) {
        this.valley = valley;
    }
    public String getSendFlg() {
        return sendFlg;
    }
    public void setSendFlg(String sendFlg) {
        this.sendFlg = sendFlg;
    }
    
}
