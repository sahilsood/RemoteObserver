/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserver.alpha;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sood
 */
public class DBConnection {
    public static Connection getConnection()
    {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///remoteobserver","root","");
        }
        catch(Exception e)
        {
            System.out.println("Exception in get Connection"+e);
        }
        return conn;
    }
}
