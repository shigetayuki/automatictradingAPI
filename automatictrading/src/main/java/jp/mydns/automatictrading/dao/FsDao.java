package jp.mydns.automatictrading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Fs;
import jp.mydns.automatictrading.repository.FsRepository;

@Repository
public class FsDao {
    @Autowired
    private FsRepository fsRepository;

    public void saveAll(List<Fs> fsList){
        fsRepository.saveAll(fsList);
    }
}
