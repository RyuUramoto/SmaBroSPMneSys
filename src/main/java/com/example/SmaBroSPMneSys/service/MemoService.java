package com.example.SmaBroSPMneSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmaBroSPMneSys.domain.Memo;
import com.example.SmaBroSPMneSys.repository.MemoRepository;

@Service
public class MemoService {

    @Autowired
    MemoRepository memoRepository;

    public List<Memo> searchAll() {
        return memoRepository.findAll();
    }
}