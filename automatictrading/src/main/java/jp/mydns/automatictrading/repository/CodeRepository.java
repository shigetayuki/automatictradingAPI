package jp.mydns.automatictrading.repository;


import jp.mydns.automatictrading.constant.SQL_CONST;
import jp.mydns.automatictrading.entity.Code;
import jp.mydns.automatictrading.entity.CodeKey;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, CodeKey> {
    @Query(value= SQL_CONST.R007,nativeQuery = true)
    List<Code> getCodeById(@Param("codeId") String codeId);
}
