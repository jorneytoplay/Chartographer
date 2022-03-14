package com.example.chartographer.workWithImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;


public class CreatePapyrus {
    public boolean create(int width, int height, String id) {
        BufferedImage bufferedImage = new BufferedImage(width, height, TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);

        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();

        // Save as PNG
        File file = new File("src/main/resources/static/image/papyrus" + id + ".bmp");
        try {
            ImageIO.write(bufferedImage, "bmp", file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
