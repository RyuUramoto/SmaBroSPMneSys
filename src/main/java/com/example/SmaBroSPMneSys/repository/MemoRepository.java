package com.example.SmaBroSPMneSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmaBroSPMneSys.domain.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
}