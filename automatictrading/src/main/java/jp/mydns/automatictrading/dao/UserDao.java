package jp.mydns.automatictrading.dao;


import jp.mydns.automatictrading.dto.UserDto;
import jp.mydns.automatictrading.entity.User;
import jp.mydns.automatictrading.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {    
    
    @Autowired
	private UserRepository repository;

    public User getUserData(UserDto userDto){
        return repository.getUserData(userDto.getUserName(),userDto.getPassword());
    }
    public User getUserData(String userName){
        return repository.findById(userName).get();
    }
}
