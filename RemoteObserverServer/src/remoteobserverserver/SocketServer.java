/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserverserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sood
 */
public class SocketServer extends Thread {

    ServerSocket servsock = null;

    SocketServer() {

        try {
            servsock = new ServerSocket(1500);
        } catch (Exception e) {
            System.out.println("Exception in Connetion" + e);
        }
    }

    public void run() {
        try {
            System.out.println("Waiting......");
            Socket sock = servsock.accept();
            System.out.println("Accepted......");
            new RecieveThread(sock).start();
        } catch (Exception e) {
        }

    }
}

class RecieveThread extends Thread {

    DataOutputStream dos = null;
    DataInputStream dis = null;
    Socket skt;

    public RecieveThread(Socket skt) {
        this.skt = skt;
        try {
            dos = new DataOutputStream(skt.getOutputStream());
            dis = new DataInputStream(skt.getInputStream());
        } catch (Exception e) {
            System.out.println("Server : Exception in upload " + e);
        }
    }

    @Override
    public void run() {
        try {
            String msg = dis.readUTF();
            System.out.println("Server : " + msg);
            if (msg.equals("upload")) {
                uploadFile();
            }
        } catch (Exception e) {
            System.out.println("Server : Exception in run " + e);
        }

    }

    public void uploadFile() {
        FileOutputStream fos = null;
        try {
            dos.writeUTF("ok");
            String fileName = dis.readUTF();
            dos.writeUTF("send");
            System.out.println("server" + fileName);
            fos = new FileOutputStream(new File("/Users/sahilsood/NetBeansProjects/ServerData" + File.separator + fileName));
            int count = 0;
            byte[] buffer = new byte[4096];
            while ((count = dis.read(buffer, 0, 4096)) != -1) {
                fos.write(buffer, 0, count);
                fos.flush();
            }
        } catch (Exception e) {
        } finally {
            try {
                fos.close();

            } catch (Exception e) {
            }
        }

    }
}
