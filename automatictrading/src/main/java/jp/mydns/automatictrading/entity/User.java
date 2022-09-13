package jp.mydns.automatictrading.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user_t")
public class User {

    @Id
    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="authority_flg")
    private String authorityFlg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorityFlg() {
        return authorityFlg;
    }

    public void setAuthorityFlg(String authorityFlg) {
        this.authorityFlg = authorityFlg;
    }
    public void setJson(Map<String,Object> json){
        json.put("userName",this.getUserName());
        json.put("authorityFlg",this.getAuthorityFlg());
    }
}
