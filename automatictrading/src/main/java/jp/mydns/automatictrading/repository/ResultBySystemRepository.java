package jp.mydns.automatictrading.repository;

import java.util.List;

import jp.mydns.automatictrading.constant.SQL_CONST;
import jp.mydns.automatictrading.entity.ResultBySystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultBySystemRepository extends JpaRepository<ResultBySystem, Long>{
    @Query(value= SQL_CONST.R003,nativeQuery = true)
    List<ResultBySystem> getFkList();

    @Query(value= SQL_CONST.R004,nativeQuery = true)
    List<ResultBySystem> getFsList();

    @Query(value= SQL_CONST.R005,nativeQuery = true)
    List<ResultBySystem> getRefkList();
    
    @Query(value= SQL_CONST.R006,nativeQuery = true)
    List<ResultBySystem> getMxList();
}
