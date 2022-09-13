package jp.mydns.automatictrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fs_t")
public class Fs {
    @Id
    @Column(name="fk_id")
    private int fkId;
    @Column(name="sign")
    private int sign;
    @Column(name="interest")
    private int interest;
    @Column(name="prev_order_location")
    private int prevOrderLocation;
    
    public int getFkId() {
        return fkId;
    }
    public void setFkId(int fkId) {
        this.fkId = fkId;
    }
    public int getSign() {
        return sign;
    }
    public void setSign(int sign) {
        this.sign = sign;
    }
    public int getInterest() {
        return interest;
    }
    public void setInterest(int interest) {
        this.interest = interest;
    }
    public int getPrevOrderLocation() {
        return prevOrderLocation;
    }
    public void setPrevOrderLocation(int prevOrderLocation) {
        this.prevOrderLocation = prevOrderLocation;
    }
    
}
