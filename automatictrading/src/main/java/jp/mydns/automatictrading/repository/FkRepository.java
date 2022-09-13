package jp.mydns.automatictrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Fk;

@Repository
public interface FkRepository  extends JpaRepository<Fk, Long> {
    
}
