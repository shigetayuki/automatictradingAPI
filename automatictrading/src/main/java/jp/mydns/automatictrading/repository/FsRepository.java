package jp.mydns.automatictrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.entity.Fs;

@Repository
public interface FsRepository  extends JpaRepository<Fs, Long> {
    
}
