package jp.mydns.automatictrading.constant;

public class CODE_CONST {
    //システムコード(コードID)
    public static final String SYSTEM = "1";
    //FK
    public static final String FK = "1";
    //FS
    public static final String FS = "2";
    //REFK
    public static final String REFK = "3";
    //MX
    public static final String MX = "4";

    //シグナル（コードID）
    public static final String SIGNAL = "2";
    //- 
    public static final String NON="0";
    //買 
    public static final String BUY="1";
    //売 
    public static final String SEL="2";
    //逆張り買 
    public static final String CONTRARAIN_BUY="3";
    //逆張り売 
    public static final String CONTRARAIN_SEL="4";
    //フォロー買 
    public static final String FOLLOW_BUY="5";
    //フォロー売
    public static final String FOLLOW_SEL="6";
    //決済買 
    public static final String SETTLEMENT_BUY="-1";
    //決済売 
    public static final String SETTLEMENT_SEL="-2";
}
