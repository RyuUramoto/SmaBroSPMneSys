package com.example.SmaBroSPMneSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmaBroSPMneSys.domain.CharacterMaster;
import com.example.SmaBroSPMneSys.repository.CharacterMasterRepository;

@Service
public class CharacterMasterService {

    @Autowired
    CharacterMasterRepository characterMasterRepository;

    public List<CharacterMaster> searchAll() {
        return characterMasterRepository.findAll();
    }
    
}