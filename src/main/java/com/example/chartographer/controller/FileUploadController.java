package com.example.chartographer.controller;

import com.example.chartographer.workWithImage.ImageOverlay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Controller
public class FileUploadController {

    ImageOverlay imageOverlay = new ImageOverlay();
    @GetMapping("/upload")
    public String provideUploadInfo() {
        return "upload";
    }



    @PostMapping("/upload")
    public ResponseEntity<byte[]> handleFileUpload(
                            @RequestParam("file") MultipartFile fragment,
                            @RequestParam("x") String x,
                            @RequestParam("y") String y,
                            @RequestParam("id") String id) throws IOException {
        if (!fragment.isEmpty()) {
            imageOverlay.impose(fragment,Integer.valueOf(x),Integer.valueOf(y),id);
        } else {
            return null;
        }
        byte[] bytes = Files.readAllBytes(Path.of("src/main/resources/static/image/papyrus" + id + ".bmp"));
        return ResponseEntity.ok(bytes);

    }

}
