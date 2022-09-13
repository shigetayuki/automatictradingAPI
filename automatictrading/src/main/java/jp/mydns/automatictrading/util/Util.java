package jp.mydns.automatictrading.util;

import java.security.MessageDigest;

public class Util {
    public static String passwordEncrypt(String password){
        //空文字の場合そのまま返却する
        if("".equals(password)){
            return "";
        }

        byte[] cipher_byte;
        StringBuilder sb = null;
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            cipher_byte = md.digest();
            sb = new StringBuilder(2 * cipher_byte.length);
            for(byte b: cipher_byte) {
                sb.append(String.format("%02x", b&0xff) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    } 
}
