package jp.mydns.automatictrading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Footkey;
import jp.mydns.automatictrading.repository.FootkeyRepository;

@Repository
public class FootkeyDao {
    @Autowired
    private FootkeyRepository footkeyRepository;

    public void saveAll(List<Footkey> footkeyList){
        footkeyRepository.saveAll(footkeyList);
    }
}
