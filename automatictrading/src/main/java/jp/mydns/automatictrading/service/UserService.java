package jp.mydns.automatictrading.service;


import jp.mydns.automatictrading.dao.UserDao;
import jp.mydns.automatictrading.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserDao dao;

    public User getUserData(String userName){
        User user=null;
        try{
            user=dao.getUserData(userName);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
