package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Bitmap {
    int i =0;
    int j=0;
    int w = 110;
    int h = 125;
    byte data[];
    String black_And_white_status="no problem";
    String flip_status="no problem";
    String darken_status="no problem";

    String inputFile;
    String outputFile;
    public Bitmap(String inputFile,String outputFile) throws IOException {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        FileInputStream file_input = new FileInputStream(inputFile);
        this.data = file_input.readAllBytes();


    }

    public void black_white(Color color) throws IOException {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            BufferedImage img = ImageIO.read(bais);
            System.out.println(img.getWidth());
            BufferedImage result = new BufferedImage(
                    img.getWidth(),
                    img.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(img, 0, 0, color, null);
            graphic.dispose();

            ImageIO.write(result, "BMP", new File(outputFile));
        }catch (Exception e){
            black_And_white_status="error";
        }
    }
    public void flip(Double rotate_degree) throws IOException {
        try{
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage img = ImageIO.read(bais);
        BufferedImage result = new BufferedImage(
                img.getWidth(),
                img.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics2D graphic = result.createGraphics();

        graphic.rotate(rotate_degree, result.getWidth()/2, result.getHeight()/2);
        graphic.drawRenderedImage(img, null);
        graphic.dispose();

        ImageIO.write(result, "BMP", new File(outputFile));
    }catch(Exception e){
            flip_status="error";
    }}
    public void Darken(double value) throws IOException {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            BufferedImage img = ImageIO.read(bais);
            BufferedImage result = new BufferedImage(
                    img.getWidth(),
                    img.getHeight(),
                    img.getType());

            Graphics2D graphic = result.createGraphics();

            for (int y = 0; y < result.getHeight(); ++y) {

                for (int x = 0; x < result.getWidth(); ++x) {

                    Color pixelColor = new Color(result.getRGB(x, y));

                    int halfRed = (int) ((pixelColor.getRed() / value) + 0.5);
                    int halfGreen = (int) ((pixelColor.getGreen() / value) + 0.5);
                    int halfBlue = (int) ((pixelColor.getBlue() / value) + 0.5);


                    Color newPixelColor = new Color(halfRed, halfGreen, halfBlue);


                    result.setRGB(x, y, newPixelColor.getRGB());
                }
            }
            graphic.drawRenderedImage(img, null);
            graphic.dispose();

            ImageIO.write(result, "BMP", new File(outputFile));
        }catch (Exception e){
            darken_status="error";
        }
        }

}