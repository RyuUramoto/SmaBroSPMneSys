package com.example.SmaBroSPMneSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SmaBroSPMneSys.domain.CharacterMaster;
import com.example.SmaBroSPMneSys.service.CharacterMasterService;
import com.example.SmaBroSPMneSys.service.UserService;

@RequestMapping("home")
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

	@Autowired
	CharacterMasterService characterMasterService;
	
	@RequestMapping("index")
	public ModelAndView index(ModelAndView mav) {
		
		try {
			List<CharacterMaster> charaList = characterMasterService.searchAll();
			mav.addObject("charaList", charaList);
			
		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		mav.setViewName("contents/index");
		return mav;
	}

}