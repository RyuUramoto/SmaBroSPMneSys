package com.example.SmaBroSPMneSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmaBroSPMneSys.domain.BattleRecordPrivateMatch;

@Repository
public interface BattleRecordPrivateMatchRepository extends JpaRepository<BattleRecordPrivateMatch, Long> {

	public List<BattleRecordPrivateMatch> findByUsedCharaId(Integer id);
}