package com.example.SmaBroSPMneSys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmaBroSPMneSys.domain.BattleRecordRankMatch;
import com.example.SmaBroSPMneSys.form.BattleRecordForm;
import com.example.SmaBroSPMneSys.repository.BattleRecordRankMatchRepository;

@Service
public class BattleRecordRankMatchService {

    @Autowired
    BattleRecordRankMatchRepository battleRecordRepository;

    public BattleRecordRankMatch postBattleRecord(BattleRecordForm brf) {
    	return battleRecordRepository.save(createBattleRecord(brf));
    }
    
    public List<BattleRecordRankMatch> searchAll() {
        return battleRecordRepository.findAll();
    }

    public List<BattleRecordRankMatch> searchMyRecord(Integer usedCharaId){    	
    	return battleRecordRepository.findByUsedCharaId(usedCharaId);
    }
    
    private BattleRecordRankMatch createBattleRecord(BattleRecordForm battleRecord) {
    	Date now = new Date();
    	
    	BattleRecordRankMatch br = new BattleRecordRankMatch();
    	br.setUsedCharaId(battleRecord.getUsedCharaId());
    	br.setEnemyCharaId(battleRecord.getEnemyCharaId());
    	br.setWinOrLose(battleRecord.getWinOrLose());
    	br.setCreateUser(1);
    	br.setCreateDate(now);
    	br.setUpdateUser(1);
    	br.setUpdateDate(now);
    	
    	return br;
    }
}

