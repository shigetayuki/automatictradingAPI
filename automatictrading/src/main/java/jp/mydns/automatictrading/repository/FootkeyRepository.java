package jp.mydns.automatictrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Footkey;

@Repository
public interface FootkeyRepository  extends JpaRepository<Footkey, Long> {
    
}
