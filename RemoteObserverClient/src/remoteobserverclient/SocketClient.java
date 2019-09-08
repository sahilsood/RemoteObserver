/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserverclient;

import java.net.Socket;

/**
 *
 * @author Sood
 */
public class SocketClient extends Thread{
    Socket  skt;
    SocketClient()
    {
        try
        {
            skt=new Socket("127.0.0.1",1500);
        }
        catch(Exception e)
        {
            System.out.println("Exception in connection of Client"+e);
        }
    }
    public void run()
    {
        System.out.println("Connecting......");
    }
}
