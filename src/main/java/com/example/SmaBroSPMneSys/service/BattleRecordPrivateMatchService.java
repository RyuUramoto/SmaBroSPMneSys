package com.example.SmaBroSPMneSys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmaBroSPMneSys.domain.BattleRecordPrivateMatch;
import com.example.SmaBroSPMneSys.form.BattleRecordForm;
import com.example.SmaBroSPMneSys.repository.BattleRecordPrivateMatchRepository;

@Service
public class BattleRecordPrivateMatchService {

    @Autowired
    BattleRecordPrivateMatchRepository battleRecordRepository;

    public BattleRecordPrivateMatch postBattleRecord(BattleRecordForm brf) {
    	return battleRecordRepository.save(createBattleRecord(brf));
    }
    
    public List<BattleRecordPrivateMatch> searchAll() {
        return battleRecordRepository.findAll();
    }

    public List<BattleRecordPrivateMatch> searchMyRecord(Integer usedCharaId){    	
    	return battleRecordRepository.findByUsedCharaId(usedCharaId);
    }
    
    private BattleRecordPrivateMatch createBattleRecord(BattleRecordForm battleRecord) {
    	Date now = new Date();
    	
    	BattleRecordPrivateMatch br = new BattleRecordPrivateMatch();
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

