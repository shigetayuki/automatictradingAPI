package jp.mydns.automatictrading.dao;

import java.util.List;

import jp.mydns.automatictrading.entity.Code;
import jp.mydns.automatictrading.repository.CodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {

    @Autowired
	private CodeRepository repository;

    public List<Code> findAll(){
        return repository.findAll();
    }
    public List<Code> getCodeById(String codeId){
        return repository.getCodeById(codeId);
    }
    
}
