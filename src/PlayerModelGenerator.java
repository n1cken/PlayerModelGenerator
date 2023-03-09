import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayerModelGenerator {

    public static void main(String[] args) {

        BufferedImage img = null;

        try {
            File file = new File("assets/maleSwedenFootballPlayer4.png");
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int w = img.getWidth();
        int h = img.getHeight();


        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {

                int rgbValue = img.getRGB(xx, yy);

                Color pixelColor = new Color(rgbValue);
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();


                switch (red) {
                    //BLUE STANDARD
                    case 17:
                        if (green == 104) {
                            if (blue == 201) {
                                Color newColor = new Color(201, 17, 76);
                                img.setRGB(xx, yy, newColor.getRGB());
                                break;
                            }
                        }
                    //LIGHT BLUE SHADOWED
                    case 7:
                        if (green == 100) {
                            if (blue == 205) {
                                Color newColor = new Color(201, 17, 76);
                                img.setRGB(xx, yy, newColor.getRGB());
                                break;
                            }
                        }

                    //BLUE SHADOWED
                    case 12:
                        if (green == 76) {
                            if (blue == 150) {
                                Color newColor = new Color(201, 17, 76);
                                img.setRGB(xx, yy, newColor.getRGB());
                                break;
                            }
                        }
                    //YELLOW
                    case 253:
                        if (green == 252) {
                            if (blue == 89) {
                                Color newColor = new Color(201, 17, 76);
                                img.setRGB(xx, yy, newColor.getRGB());
                                break;
                            }
                        }

                        //YELLOW
                    case 209:
                        if (green == 208) {
                                if (blue == 55) {
                                Color newColor = new Color(201, 17, 76);
                                img.setRGB(xx, yy, newColor.getRGB());
                                break;
                            }
                        }
                }


                switch (green) {

                }

                switch (blue) {

                }

            }
        }

        File outputfile = new File("./newPlayerImage.png");

        try {
            outputfile.createNewFile();
            ImageIO.write(img, "png", outputfile);
            System.out.println("Created new image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}