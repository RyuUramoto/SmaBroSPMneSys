package com.example.SmaBroSPMneSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index(Model model) {
		
		try {
//			List<User> userList = userService.searchAll();
			List<CharacterMaster> charaList = characterMasterService.searchAll();
			
//			model.addAttribute("userList", userList);
			model.addAttribute("charaList", charaList);
			
		}catch(Exception e){
			System.out.println(e.getMessage() + ":" + e.getStackTrace());
		}
		
		
		return "contents/index";
	}

}