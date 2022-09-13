package jp.mydns.automatictrading.entity;

import java.io.Serializable;

// import javax.persistence.Column;

import lombok.Data;

@Data
public class CodeKey implements Serializable {
    // @Column(name="code_id")
    private String codeId;

    // @Column(name="code_symbol")
    private String codeSymbol;
}
