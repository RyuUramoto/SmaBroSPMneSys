package com.example.SmaBroSPMneSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.SmaBroSPMneSys.domain.BattleRecordRankMatch;
import com.example.SmaBroSPMneSys.domain.CharacterMaster;
import com.example.SmaBroSPMneSys.form.BattleRecordForm;
import com.example.SmaBroSPMneSys.service.BattleRecordRankMatchService;
import com.example.SmaBroSPMneSys.service.CharacterMasterService;

@RequestMapping("characterBattleRecord")
@Controller
public class CharacterBattleRecordController {
	
	@Autowired
	CharacterMasterService characterMasterService;
	
	@Autowired
	BattleRecordRankMatchService battleRecordRankService;
	
	@RequestMapping("charaHome")
	public String index(Integer charaId, Model model) {
		
		try {
			
			//引数キャラIDのキャラ情報とキャラ毎の勝率を取得する
			List<CharacterMaster> charaList = characterMasterService.searchAll();
			CharacterMaster chara = charaList.stream().filter(x->x.getCharaId().equals(charaId)).findFirst().get();
			List<BattleRecordRankMatch>battleRecordList = battleRecordRankService.searchMyRecord(charaId);
		
			model.addAttribute("chara", chara);			
			model.addAttribute("charaList", charaList);
			model.addAttribute("battleRecordCount", battleRecordList.size());
			model.addAttribute("battleRecordForm", new BattleRecordForm());

		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		return "contents/characterBattleRecord";
	}

	@RequestMapping(value = {"postRecord"}, method = {RequestMethod.POST})
	public String postRecord(@ModelAttribute BattleRecordForm battleRecordForm, Model model) {		
		try {
			battleRecordRankService.postBattleRecord(battleRecordForm);
		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		return index(battleRecordForm.getUsedCharaId(),model);
	}
}