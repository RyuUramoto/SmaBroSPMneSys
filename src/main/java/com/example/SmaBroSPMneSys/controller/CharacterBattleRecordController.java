package com.example.SmaBroSPMneSys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView index(Integer charaId, ModelAndView mav) {
		
		try {
			
			//引数キャラIDのキャラ情報とキャラ毎の勝率を取得する
			List<CharacterMaster> charaList = characterMasterService.searchAll();
			CharacterMaster chara = charaList.stream().filter(x -> x.getCharaId().equals(charaId)).findFirst().get();
			List<BattleRecordRankMatch>battleRecordList = battleRecordRankService.searchMyRecord(charaId);
		
			mav.addObject("chara", chara);			
			mav.addObject("charaList", charaList);
			mav.addObject("battleRecordCount", battleRecordList.size());
			mav.addObject("battleRecordForm", new BattleRecordForm());

		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		mav.setViewName("contents/characterBattleRecord");
		
		return mav;
	}

	@RequestMapping(value = {"postRecord"}, method = {RequestMethod.POST})
	public ModelAndView postRecord(@Validated @ModelAttribute BattleRecordForm battleRecordForm, BindingResult result, ModelAndView mav) {		
		
		//入力チェック
		if(result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            errorList.addAll(result.getAllErrors().stream().map(x -> x.getDefaultMessage()).toList());
            mav.addObject("validationError", errorList);
			return index(battleRecordForm.getUsedCharaId(),mav);
		}
		
		//戦績登録
		try {
			battleRecordRankService.postBattleRecord(battleRecordForm);
		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		return index(battleRecordForm.getUsedCharaId(),mav);
	}
}