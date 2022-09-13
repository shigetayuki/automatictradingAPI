package jp.mydns.automatictrading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Refk;
import jp.mydns.automatictrading.repository.RefkRepository;

@Repository
public class RefkDao {
    @Autowired
    private RefkRepository refkRepository;

    public void saveAll(List<Refk> refkList){
        refkRepository.saveAll(refkList);
    }
}
