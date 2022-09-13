package jp.mydns.automatictrading.repository;


import jp.mydns.automatictrading.constant.SQL_CONST;
import jp.mydns.automatictrading.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value= SQL_CONST.R001,nativeQuery = true)
    public User getUserData(@Param("name") String name,@Param("password") String password);
}   
