package jp.mydns.automatictrading.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultBySystemKey  implements Serializable {
    private String year;
    private String month;
}
