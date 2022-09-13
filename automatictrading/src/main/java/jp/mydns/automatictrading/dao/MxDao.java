package jp.mydns.automatictrading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Mx;
import jp.mydns.automatictrading.repository.MxRepository;

@Repository
public class MxDao {
    @Autowired
    private MxRepository mxRepository;

    public void saveAll(List<Mx> mxList){
        mxRepository.saveAll(mxList);
    }
}
