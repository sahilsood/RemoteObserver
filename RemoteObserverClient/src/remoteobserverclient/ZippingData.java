/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserverclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Sood
 */
public class ZippingData extends Thread {

    public void run() {
        byte[] buffer = new byte[4096];
        try {
            File rootFolder = new File("/Users/sahilsood/NetBeansProjects/Screenshots" + File.separator + MainFrame.username + LoginFrame.maxactivityId);
            
            FileOutputStream fos = new FileOutputStream("/Users/sahilsood/NetbeansProjects/Zip files"+File.separator +MainFrame.username+LoginFrame.maxactivityId+".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            File[] allFiles = rootFolder.listFiles();
            System.out.println("list of files "+allFiles.length);
            for (int i = 0; i < allFiles.length; i++) {

                File ff = allFiles[i];
                ZipEntry ze = new ZipEntry(ff.getName());
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(ff);
                int len = 0;
                while ((len = in.read(buffer, 0, 4096)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
                zos.flush();
            }
            zos.closeEntry();
            zos.close();
        } catch (Exception e) {
            System.out.println("Exception in Zipping File" + e);
        }
    }
}
