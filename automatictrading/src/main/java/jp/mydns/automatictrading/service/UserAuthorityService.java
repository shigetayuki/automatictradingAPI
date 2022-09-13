package jp.mydns.automatictrading.service;


import jp.mydns.automatictrading.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserAuthorityService implements UserDetailsService{
    
    @Autowired
    private UserDao dao;
    @Override
    public UserDetails loadUserByUsername(String userName){
        jp.mydns.automatictrading.entity.User user=null;
       
        user=dao.getUserData(userName);
        if(user == null){
            throw new UsernameNotFoundException(userName);
        }
        
        return User.withUsername(user.getUserName())
        .password(user.getPassword())
        .authorities("ROLE_USER") // ユーザの権限
        .build();
    }
}
