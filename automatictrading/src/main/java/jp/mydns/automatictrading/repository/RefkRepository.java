package jp.mydns.automatictrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Refk;

@Repository
public interface RefkRepository  extends JpaRepository<Refk, Long> {
    
}
