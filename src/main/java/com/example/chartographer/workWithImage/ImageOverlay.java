package com.example.chartographer.workWithImage;


import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageOverlay {


    public boolean impose(MultipartFile fragment,int x,int y,String id){
        File file = new File("src/main/resources/static/image/papyrus"+id+".bmp");

        try {
            byte[] file1 = fragment.getBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(file1);
            BufferedImage bi = ImageIO.read(file);
            BufferedImage pic = ImageIO.read(inputStream);
            Graphics2D graphics2D = bi.createGraphics();
            graphics2D.drawImage(pic, x, y, null);
            graphics2D.dispose();
            ImageIO.write(bi, "bmp", file);
            bi.flush();
            pic.flush();
            //graph.drawImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
