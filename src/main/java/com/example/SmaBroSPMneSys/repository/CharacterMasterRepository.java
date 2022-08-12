package com.example.SmaBroSPMneSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmaBroSPMneSys.domain.CharacterMaster;

@Repository
public interface CharacterMasterRepository extends JpaRepository<CharacterMaster, Integer> {
}