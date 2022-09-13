package jp.mydns.automatictrading.errorCheck;

import java.util.Map;
import java.util.regex.Pattern;

import jp.mydns.automatictrading.constant.MSG_CONST;
import jp.mydns.automatictrading.dto.UserDto;


// エラー有：true,エラー無：false
public class ErrorCheck {
    public boolean userFormatCheck(Map<String,Object> json,UserDto userDto){
        boolean errorFlg=false;
        
        //ユーザーネームのチェック
        if(commonCheck(json,userDto.getUserName(),"ユーザー名","errorUserName", true, true)){
            errorFlg=true;
        }

        //パスワードの必須チェック
        if(commonCheck(json,userDto.getPassword(),"パスワード","errorPassword", true, true)){
            errorFlg=true;
        }
        return errorFlg;
    }


    /**
     * 共通チェック（実際のチェックを行う）
     * @param mapList　エラーメッセージのリスト
     * @param checkTarget　チェック対象
     * @param targetLogicalName　チェック対象の論理名
     * @param targetPhysicalName　チェック対象の物理名（マップのキー）
     * @param inputCheck　必須チェック（true:チェックを行う、false:チェックを行わない）
     * @param illegalCheck　不正文字チェック（true:チェックを行う、false:チェックを行わない）
     * @return true:エラー有、false:エラー無
     */
    public boolean commonCheck(Map<String,Object> json,String checkTarget,String targetLogicalName,
                                String targetPhysicalName,boolean inputCheck,boolean illegalCheck){
        boolean errorFlg=false;
        //必須チェック
        if(!errorFlg){
            if(inputCheck(checkTarget)){
                ErrorMsg errorMsg=new ErrorMsg();
                json.put(targetPhysicalName,errorMsg.getErrorMsg(MSG_CONST.ERROR001,targetLogicalName));
                errorFlg=true;
            }
        }

        //不正文字チェック
        if(!errorFlg){
            if(illegalCheck(checkTarget)){
                json.put(targetPhysicalName,MSG_CONST.ERROR002);
                errorFlg=true;
            }
        }

        return errorFlg;
    }
    
    //必須チェック
    public boolean inputCheck(String checkTarget){
        if(checkTarget.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    //不正文字チェック
    public boolean illegalCheck(String checkTarget){
        String pattern = "[\\p{Punct}].";
        Pattern p = Pattern.compile(pattern);
        if(p.matcher(checkTarget).find()){
            return true;
        }else{
            return false;
        }
    }
}
