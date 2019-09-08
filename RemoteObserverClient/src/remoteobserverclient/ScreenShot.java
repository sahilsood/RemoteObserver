/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserverclient;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import remoteserver.alpha.DBOperations;

/**
 *
 * @author Sood
 */
public class ScreenShot extends Thread {

    DBOperations objDB;
    int i = 0;
    public static boolean flag = true;

    public void run() {

        while (flag) {

            try {
                Thread.sleep(2000);
                getScreens();
            } catch (Exception e) {
                System.out.println("Exception in ScreenShot" + e);
            }
        }
    }

    public void getScreens() {
        while (flag) {
            try {

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Rectangle screenRectangle = new Rectangle(screenSize);
                Robot robot = new Robot();
                BufferedImage image = robot.createScreenCapture(screenRectangle);
                File f = new File("/Users/sahilsood/NetBeansProjects/Screenshots" + File.separator + MainFrame.username + LoginFrame.maxactivityId + File.separator + i++ + ".png");
                File pF = f.getParentFile();
                if (!pF.exists()) {
                    pF.mkdirs();
                    
                }
                ImageIO.write(image, "png", f);
            } catch (Exception e) {
                System.out.println("Exception in ScreenShot" + e);
            }
        }
    }
}
