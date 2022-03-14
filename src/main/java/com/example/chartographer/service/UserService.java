package com.example.chartographer.service;

import com.example.chartographer.entity.Papyrus;
import com.example.chartographer.repository.PapyrusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PapyrusRepository papyrusRepository;

    public Papyrus save(int width, int height) {
        Papyrus papyrus = new Papyrus();
        papyrus.setHeight(height);
        papyrus.setWidth(width);
        papyrusRepository.save(papyrus);
        return papyrus;
    }
}
