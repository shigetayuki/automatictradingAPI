package jp.mydns.automatictrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="code_mst")
@IdClass(value=CodeKey.class)
public class Code {
    @Id
    @Column(name="code_id")
    private String codeId;

    @Id
    @Column(name="code_symbol")
    private String codeSymbol;

    @Column(name="code_name")
    private String codeName;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeSymbol() {
        return codeSymbol;
    }

    public void setCodeSymbol(String codeSymbol) {
        this.codeSymbol = codeSymbol;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    
}
