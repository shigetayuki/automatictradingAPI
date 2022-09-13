package jp.mydns.automatictrading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Fk;
import jp.mydns.automatictrading.repository.FkRepository;

@Repository
public class FkDao {
    @Autowired
    private FkRepository fkRepository;

    public void saveAll(List<Fk> fkList){
        fkRepository.saveAll(fkList);
    }
}
