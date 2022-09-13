package jp.mydns.automatictrading.dao;

import java.util.List;

import jp.mydns.automatictrading.repository.TradeSystemRepository;
import jp.mydns.automatictrading.entity.TradeSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TradeSystemDao {

    @Autowired
	private TradeSystemRepository repository;

    public List<TradeSystem> getMxListByMonths (String yearMonth){
        return repository.getMxListByMonths(yearMonth);
    }
    public List<TradeSystem> getMxListByYear (String year){
        return repository.getMxListByYear(year);
    }

}
