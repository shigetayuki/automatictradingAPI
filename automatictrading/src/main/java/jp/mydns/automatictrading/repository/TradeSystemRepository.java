package jp.mydns.automatictrading.repository;

import java.util.List;

import jp.mydns.automatictrading.constant.SQL_CONST;
import jp.mydns.automatictrading.entity.TradeSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeSystemRepository extends JpaRepository<TradeSystem, Long> {
    @Query(value= SQL_CONST.R002,nativeQuery = true)
    List<TradeSystem> getMxListByMonths(@Param("yearMonth") String yearMonth);
    @Query(value=SQL_CONST.R009,nativeQuery =true)
    List<TradeSystem> getMxListByYear(@Param("year")String year);
}
