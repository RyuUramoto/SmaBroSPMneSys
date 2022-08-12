package com.example.SmaBroSPMneSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmaBroSPMneSys.domain.BattleRecordRankMatch;

@Repository
public interface BattleRecordRankMatchRepository extends JpaRepository<BattleRecordRankMatch, Long> {

	public List<BattleRecordRankMatch> findByUsedCharaId(Integer id);

}