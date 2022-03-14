package com.example.chartographer.controller;

import com.example.chartographer.entity.Papyrus;
import com.example.chartographer.service.UserService;
import com.example.chartographer.workWithImage.CreatePapyrus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chartas")
public class PapyrusController {


    @Autowired
    UserService userService;
    CreatePapyrus createPapyrus = new CreatePapyrus();

    @PostMapping("/bebr")
    public ResponseEntity<String> createPapyrus(int width, int height){
        Papyrus papyrus = userService.save(width,height);
        createPapyrus.create(width,height, String.valueOf(papyrus.getId()));
        return new ResponseEntity<>("Create papyrus with ID: "+papyrus.getId(),HttpStatus.CREATED);
    }
}
