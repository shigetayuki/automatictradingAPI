package jp.mydns.automatictrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class TradeSystem {
    //FOOTKEY
    @Id
    @Column(name="fk_id")
    private int fkId;
    @Column(name="f_date")
    private String fkDate;
    @Column(name="f_time")
    private String fkTime;
    @Column(name="f_price")
    private int price;
    @Column(name="f_trend")
    private int trend;
    @Column(name="f_mountain")
    private int mountain;
    @Column(name="f_valley")
    private int valley;
    @Column(name="f_send_flg")
    private String sendFlg;
    //FK
    @Column(name="fk_sign")
    private int fkSign;
    @Column(name="fk_interest")
    private int fkInterest;
    @Column(name="fk_prev_order_location")
    private int fkPrevOrderLocation;
    //FS
    @Column(name="fs_sign")
    private int fsSign;
    @Column(name="fs_interest")
    private int fsInterest;
    @Column(name="fs_prev_order_location")
    private int fsPrevOrderLocation;
    //REFK
    @Column(name="refk_sign")
    private int refkSign;
    @Column(name="refk_interest")
    private int refkInterest;
    @Column(name="refk_prev_order_location")
    private int refkPrevOrderLocation;
    //MX
    @Column(name="mx_sign")
    private int mxSign;
    @Column(name="mx_interest")
    private int mxInterest;
    @Column(name="mx_prev_order_location")
    private int mxPrevOrderLocation;

    //
    @OneToOne
    @JoinColumn(name="fk_id")
    private TradeSystem preFootkeyData;
    public TradeSystem getPreFootkeyData() {
        return preFootkeyData;
    }
    public void setPreFootkeyData(TradeSystem preFootkeyData) {
        this.preFootkeyData = preFootkeyData;
    }
    //
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
    public int getFkSign() {
        return fkSign;
    }
    public void setFkSign(int fkSign) {
        this.fkSign = fkSign;
    }
    public int getFkInterest() {
        return fkInterest;
    }
    public void setFkInterest(int fkInterest) {
        this.fkInterest = fkInterest;
    }
    public int getFkPrevOrderLocation() {
        return fkPrevOrderLocation;
    }
    public void setFkPrevOrderLocation(int fkPrevOrderLocation) {
        this.fkPrevOrderLocation = fkPrevOrderLocation;
    }
    public int getFsSign() {
        return fsSign;
    }
    public void setFsSign(int fsSign) {
        this.fsSign = fsSign;
    }
    public int getFsInterest() {
        return fsInterest;
    }
    public void setFsInterest(int fsInterest) {
        this.fsInterest = fsInterest;
    }
    public int getFsPrevOrderLocation() {
        return fsPrevOrderLocation;
    }
    public void setFsPrevOrderLocation(int fsPrevOrderLocation) {
        this.fsPrevOrderLocation = fsPrevOrderLocation;
    }
    public int getRefkSign() {
        return refkSign;
    }
    public void setRefkSign(int refkSign) {
        this.refkSign = refkSign;
    }
    public int getRefkInterest() {
        return refkInterest;
    }
    public void setRefkInterest(int refkInterest) {
        this.refkInterest = refkInterest;
    }
    public int getRefkPrevOrderLocation() {
        return refkPrevOrderLocation;
    }
    public void setRefkPrevOrderLocation(int refkPrevOrderLocation) {
        this.refkPrevOrderLocation = refkPrevOrderLocation;
    }
    public int getMxSign() {
        return mxSign;
    }
    public void setMxSign(int mxSign) {
        this.mxSign = mxSign;
    }
    public int getMxInterest() {
        return mxInterest;
    }
    public void setMxInterest(int mxInterest) {
        this.mxInterest = mxInterest;
    }
    public int getMxPrevOrderLocation() {
        return mxPrevOrderLocation;
    }
    public void setMxPrevOrderLocation(int mxPrevOrderLocation) {
        this.mxPrevOrderLocation = mxPrevOrderLocation;
    }
}
