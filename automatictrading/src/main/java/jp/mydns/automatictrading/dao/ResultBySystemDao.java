package jp.mydns.automatictrading.dao;

import java.util.List;

import jp.mydns.automatictrading.entity.ResultBySystem;
import jp.mydns.automatictrading.repository.ResultBySystemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResultBySystemDao {
    
    @Autowired
    private ResultBySystemRepository repository;

    public List<ResultBySystem> getFkList (){
        return repository.getFkList();
    }

    public List<ResultBySystem> getFsList (){
        return repository.getFsList();
    }

    public List<ResultBySystem> getRefkList (){
        return repository.getRefkList();
    }

    public List<ResultBySystem> getMxList (){
        return repository.getMxList();
    }
}
