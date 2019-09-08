/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteserver.alpha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import remoteobserver.alpha.UserActivityReportBean;
import remoteobserverclient.LoginFrame;
import remoteobserverclient.MainFrame;

/**
 *
 * @author Sood
 */
public class DBOperations {

    public UsermasterBean authUser(String un, String pass) {
        Connection conn = null;
        UsermasterBean objBean = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(pass)) {
                    objBean = new UsermasterBean();
                    objBean.setUser_id(rs.getInt("user_id"));
                    objBean.setUserName(rs.getString("username"));
                    objBean.setUserStatus(rs.getString("user_status"));
                    objBean.setUserType(rs.getString("user_type"));
                    objBean.setName(rs.getString("name"));
                    objBean.setPassword(rs.getString("password"));
                    objBean.setContact(rs.getString("contact_number"));
                    objBean.setEmail(rs.getString("email"));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Login" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
                rs.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection file" + ex);
            }
        }
        return objBean;
    }

    public UsermasterBean getDetailByUserId(int userId) {

        Connection conn = null;
        UsermasterBean objBean = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where user_id=?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objBean = new UsermasterBean();
                objBean.setUserName(rs.getString("username"));
                objBean.setName(rs.getString("name"));
                objBean.setPassword(rs.getString("password"));
                objBean.setContact(rs.getString("contact_number"));
                objBean.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Exception in getting detail by user id" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
                rs.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection file" + ex);
            }
        }
        return objBean;
    }

    public String updateProfile(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=?,name=?,contact_number=?,email=? where user_id=?");
            pstmt.setString(1, objBean.getUserName());
            pstmt.setString(2, objBean.getPassword());
            pstmt.setString(3, objBean.getName());
            pstmt.setString(4, objBean.getContact());
            pstmt.setString(5, objBean.getEmail());
            pstmt.setInt(6, objBean.getUser_id());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "update";
            }
        } catch (Exception e) {
            System.out.println("Exception in Updating Detail in DBOperation" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection file" + ex);
            }
        }
        return result;
    }

    public void userActivity(UserActivityReportBean objABean) {

        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into useractivitymaster(user_id,login_time,grab_folder) values (?,sysdate(),?)");
            pstmt.setInt(1, objABean.getUserId());
            pstmt.setString(2, objABean.getGrabFolder());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in Adding New User" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
    }

    public int getMaxActivityId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxactivityId = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(activity_id) from useractivitymaster");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxactivityId = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Exception in Maximum UserId Details" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return (maxactivityId+1);
    }
    public void logoutTime() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update useractivitymaster set logout_time = sysdate() where activity_id=? and user_id=?");
            pstmt.setInt(1, LoginFrame.maxactivityId);
            pstmt.setInt(2,MainFrame.userId);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in Adding New User" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
    }
    /**
     *
     * @param f
     */
}