/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserverclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

/**
 *
 * @author Sood
 */
public class UploadThread extends Thread {

    Socket skt;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    String fileToUpload = "";

    public UploadThread(String fileToUpload) {
        
        this.fileToUpload = fileToUpload;
        
        try {
            skt=new Socket("127.0.0.1",1500);
            dos = new DataOutputStream(skt.getOutputStream());
            dis = new DataInputStream(skt.getInputStream());
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            dos.writeUTF("upload");
            String msg=dis.readUTF();
            System.out.println("Client "+msg);
            dos.writeUTF(fileToUpload.substring(fileToUpload.lastIndexOf(File.separator) + 1));
            transferFile();
        } catch (Exception e) {
        }
    }

    public void transferFile() {

        FileInputStream fis = null;
        try {
            System.out.println("transfer file"+fileToUpload);
            String msg = dis.readUTF();
            System.out.println(fileToUpload +" "+msg);
            fis = new FileInputStream(new File(fileToUpload));
            int count = 0;
            byte[] buffer = new byte[4096];
            while ((count = fis.read(buffer, 0, 4096)) != -1) {
                dos.write(buffer, 0, count);
                dos.flush();
            }
        } catch (Exception e) {
        } finally {
            try {
               fis.close();

            } catch (Exception e) {
            }
        }
    }
}
