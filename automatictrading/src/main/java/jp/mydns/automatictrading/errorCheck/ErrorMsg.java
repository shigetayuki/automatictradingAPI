package jp.mydns.automatictrading.errorCheck;


public class ErrorMsg {

    /**
     * 埋め字有のエラーメッセージ
     * @param errorMsg　エラーメッセージ
     * @param msgStr　埋め字
     */
    public String getErrorMsg(String errorMsg,String... msgStr){
        int i=0;
        String errorStr;

        while(true){
            //埋め字を置換
            errorStr=errorMsg.replace("{"+i+"}",msgStr[i]);
            
            //埋め字が残っているかチェック
            if(!errorStr.contains("{")){
                break;
            }
        }
        return errorStr;
    }
}
