/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.awt.*;
import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {
//        "app/build/resources/main/inputFile.bmp"
//        "app/build/resources/main/outputFile.bmp"

Bitmap p=new Bitmap(args[0],args[1]);
System.out.println(args[0]);
p.black_white(Color.WHITE);
Bitmap second=new Bitmap(args[0],args[1]);
second.flip (90.0);
Bitmap third=new Bitmap(args[0],args[1]);
third.Darken(2.0);
    }
}
