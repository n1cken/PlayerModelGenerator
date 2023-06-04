import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorChanger {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            generateImage(i);
        }
    }

    public static void generateImage(int index) {
        // Load the image using your image loading mechanism
        BufferedImage img = loadImage("assets/maleSwedenFootballPlayer4.png");

        int w = img.getWidth();
        int h = img.getHeight();

        Random random = new Random();
        Map<Integer, Color> colorMap = new HashMap<>();

        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int rgbValue = img.getRGB(xx, yy);

                Color pixelColor = new Color(rgbValue);
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();

                // Check the color cases and apply the color transformation
                Color newColor = null;
                switch (red) {
                    // BLUE STANDARD
                    case 17:
                        if (green == 104 && blue == 201) {
                            newColor = colorMap.getOrDefault(rgbValue, generateAnalogousColor(random));
                        }
                        break;

                    // LIGHT BLUE
                    case 7:
                        if (green == 100 && blue == 205) {
                            newColor = colorMap.getOrDefault(rgbValue, generateAnalogousColor(random));
                        }
                        break;

                    // BLUE SHADOWED
                    case 12:
                        if (green == 76 && blue == 150) {
                            newColor = colorMap.getOrDefault(rgbValue, generateAnalogousColor(random));
                        }
                        break;

                    // YELLOW
                    case 253:
                        if (green == 252 && blue == 89) {
                            newColor = colorMap.getOrDefault(rgbValue, generateAnalogousColor(random));
                        }
                        break;

                    // DARK YELLOW
                    case 209:
                        if (green == 208 && blue == 55) {
                            newColor = colorMap.getOrDefault(rgbValue, generateAnalogousColor(random));
                        }
                        break;
                }

                if (newColor != null) {
                    colorMap.put(rgbValue, newColor);
                    img.setRGB(xx, yy, newColor.getRGB());
                }
            }
        }


        // Save the modified image using your image saving mechanism
        saveImage(img, "modified_" + index + ".png");
    }

    public static Color generateAnalogousColor(Random random) {
        Color[] colorPalette = {
                new Color(0xFF7F50),  // Coral
                new Color(0xFF1493),  // DeepPink
                new Color(0x32CD32),  // LimeGreen
                new Color(0x9370DB),  // MediumPurple
                new Color(0xFFFF00),  // Yellow
                new Color(0xFFD700),  // Gold
                new Color(0x00CED1),  // DarkTurquoise
                new Color(0xFF4500),  // OrangeRed
                new Color(0x6B8E23),  // OliveDrab
                new Color(0xB22222),  // FireBrick
                new Color(0xFFFFFF),  // White
                new Color(0x000000)   // Black
        };

        int baseIndex = random.nextInt(colorPalette.length);
        Color baseColor = colorPalette[baseIndex];

        float hueOffset = (random.nextFloat() - 0.5f) * 0.1f;  // Adjust the range as desired
        float saturationOffset = (random.nextFloat() - 0.5f) * 0.2f;  // Adjust the range as desired
        float brightnessOffset = (random.nextFloat() - 0.5f) * 0.2f;  // Adjust the range as desired

        float[] hsbValues = Color.RGBtoHSB(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), null);
        float hue = wrapAround(hsbValues[0] + hueOffset, 0f, 1f);
        float saturation = clamp(hsbValues[1] + saturationOffset, 0f, 1f);
        float brightness = clamp(hsbValues[2] + brightnessOffset, 0f, 1f);

        return Color.getHSBColor(hue, saturation, brightness);
    }

    public static float wrapAround(float value, float min, float max) {
        float range = max - min;
        return (value - min) % range + min;
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(value, max));
    }


    public static BufferedImage loadImage(String filePath) {
        try {
            File input = new File(filePath);
            BufferedImage image = ImageIO.read(input);
            System.out.println("Image loaded successfully.");
            return image;
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String filePath) {
        try {
            File output = new File(filePath);
            ImageIO.write(image, "png", output);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}


// Implement your image loading
