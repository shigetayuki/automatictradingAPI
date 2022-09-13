package jp.mydns.automatictrading.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.mydns.automatictrading.dto.UserDto;
import jp.mydns.automatictrading.entity.User;
import jp.mydns.automatictrading.errorCheck.ErrorCheck;
import jp.mydns.automatictrading.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login()throws JsonProcessingException, UnsupportedEncodingException{
        //パラメータから値を取得しDTOに設定する
        UserDto userDto=(UserDto)session.getAttribute("userDto");
        
        Map<String,Object> json = new HashMap<>();
        ErrorCheck errorcheck=new ErrorCheck();

        //エラーチェック
        if(!errorcheck.userFormatCheck(json,userDto)){
            //存在チェック
            User user = userService.getUserData(userDto.getUserName());
            user.setJson(json);
            session.setAttribute("user",user);
        }
        return new ObjectMapper().writeValueAsString(json);
    }
}
