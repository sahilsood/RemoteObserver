/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserver.alpha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import remoteobserver.email.SendSMTP;
import remoteobserverserver.UserActivityReport;

/**
 *
 * @author Sood
 */
public class DBOperations {

    public UsermasterBean authUser(String un, String pass) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(pass)) {
                    objBean = new UsermasterBean();
                    objBean.setUserId(rs.getInt("user_id"));
                    objBean.setUserName(rs.getString("username"));
                    objBean.setPassword(rs.getString("password"));
                    objBean.setUserStatus(rs.getString("user_status"));
                    objBean.setUserType(rs.getString("user_type"));
                    objBean.setName(rs.getString("name"));
                    objBean.setContact(rs.getString("contact_number"));
                    objBean.setEmail(rs.getString("email"));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in authUser" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return objBean;
    }

    public UsermasterBean getDetailByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where user_id=?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objBean = new UsermasterBean();
                objBean.setUserId(rs.getInt("user_id"));
                objBean.setUserName(rs.getString("username"));
                objBean.setPassword(rs.getString("password"));
                objBean.setUserStatus(rs.getString("user_status"));
                objBean.setUserType(rs.getString("user_type"));
                objBean.setName(rs.getString("name"));
                objBean.setContact(rs.getString("contact_number"));
                objBean.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Exception in authUser" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return objBean;
    }
    public String retrievePass(String un) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objBean = new UsermasterBean();
                objBean.setUserId(rs.getInt("user_id"));
                objBean.setUserName(rs.getString("username"));
                objBean.setPassword(rs.getString("password"));
                objBean.setUserStatus(rs.getString("user_status"));
                objBean.setUserType(rs.getString("user_type"));
                objBean.setName(rs.getString("name"));
                objBean.setContact(rs.getString("contact_number"));
                objBean.setEmail(rs.getString("email"));
                SendSMTP obj=new SendSMTP();
                obj.sendMail(objBean.getEmail(), "Your password is  "+objBean.getPassword(),"");
                return "send";
            }
        } catch (Exception e) {
            
            System.out.println("Exception in authUser" + e);
            return "send";
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return "failed";
    }

    public String updateProfile(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=?,name=?,contact_number=?,email=? where user_id=?");
            pstmt.setString(1, objBean.getUserName());
            pstmt.setString(2, objBean.getPassword());
            pstmt.setString(3, objBean.getName());
            pstmt.setString(4, objBean.getContact());
            pstmt.setString(5, objBean.getEmail());
            pstmt.setInt(6, objBean.getUserId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "update";
            }
        } catch (Exception e) {
            System.out.println("Exception in Updation" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return result;

    }

    public String updateUserDetail(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=?,user_status=?,user_type=?,name=?,contact_number=?,email=? where user_id=?");
            pstmt.setString(1, objBean.getUserName());
            pstmt.setString(2, objBean.getPassword());
            pstmt.setString(3, objBean.getUserStatus());
            pstmt.setString(4, objBean.getUserType());
            pstmt.setString(5, objBean.getName());
            pstmt.setString(6, objBean.getContact());
            pstmt.setString(7, objBean.getEmail());
            pstmt.setInt(8, objBean.getUserId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "update";
            }
        } catch (Exception e) {
            System.out.println("Exception in Updation" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return result;
    }

    public String addNewUser(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where username=?");
            pstmt.setString(1, objBean.getUserName());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = "exists";
            } else {
                pstmt = conn.prepareStatement("insert into usermaster(username,password,user_status,user_type,name,contact_number,email)values(?,?,?,?,?,?,?)");
                pstmt.setString(1, objBean.getUserName());
                pstmt.setString(2, objBean.getPassword());
                pstmt.setString(3, objBean.getUserStatus());
                pstmt.setString(4, objBean.getUserType());
                pstmt.setString(5, objBean.getName());
                pstmt.setString(6, objBean.getContact());
                pstmt.setString(7, objBean.getEmail());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "update";
                }
            }
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
        return result;
    }

    public List<UsermasterBean> getAllUserDetails() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<UsermasterBean> alst = new ArrayList<>();
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new UsermasterBean();
                objBean.setUserId(rs.getInt("user_id"));
                objBean.setUserName(rs.getString("username"));
                objBean.setPassword(rs.getString("password"));
                objBean.setUserStatus(rs.getString("user_status"));
                objBean.setUserType(rs.getString("user_type"));
                objBean.setName(rs.getString("name"));
                objBean.setContact(rs.getString("contact_number"));
                objBean.setEmail(rs.getString("email"));
                alst.add(objBean);
            }
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
        return alst;
    }

    public int getMaxUserId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxUserId = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(user_id) from usermaster");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxUserId = rs.getInt(1);
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
        return maxUserId;
    }

    public List<UserActivityReportBean> getUserActivityReport(String username, String date) {

        UserActivityReport objUMA = new UserActivityReport();
        Connection conn = null;
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        List<UserActivityReportBean> alst = new ArrayList<>();
        UserActivityReportBean objABean = null;
        try {
            conn = DBConnection.getConnection();
            if (!username.equalsIgnoreCase("select") && !date.equalsIgnoreCase("")) {
                pstmt = conn.prepareStatement("select um.*,uam.* from usermaster um,useractivitymaster uam where um.user_id = uam.user_id and um.username=? and uam.Login_Time like ?");
                pstmt.setString(1, username);
                pstmt.setString(2, "%"+date+"%");
            } else if (!username.equalsIgnoreCase("select") && date.equalsIgnoreCase("")) {
                pstmt = conn.prepareStatement("select um.*,uam.* from usermaster um,useractivitymaster uam where um.user_id = uam.user_id and um.username=? and uam.Login_Time like ?");
                pstmt.setString(1, username);
                pstmt.setString(2, "%"+date+"%");
            } else if (username.equalsIgnoreCase("select") && !date.equalsIgnoreCase("")) {
                pstmt = conn.prepareStatement("select um.*,uam.* from usermaster um,useractivitymaster uam where um.user_id = uam.user_id and uam.Login_Time like ?");
                pstmt.setString(1, "%"+date+"%");
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objABean = new UserActivityReportBean();
                objABean.setUserId(rs.getInt("user_id"));
                objABean.setUserName(rs.getString("username"));
                objABean.setLoginTime(rs.getString("login_time"));
                objABean.setLogoutTime(rs.getString("logout_time"));
                objABean.setGrabFolder(rs.getString("grab_folder"));
                alst.add(objABean);

            }
        } catch (Exception e) {
            System.out.println("Exception in getUserrActivityReport" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return alst;
    }

    public List<UserActivityReportBean> getAllUserActivityReport() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<UserActivityReportBean> alst = new ArrayList<>();
        UserActivityReportBean objABean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select um.*,uam.* from usermaster um,useractivitymaster uam where um.user_id = uam.user_id ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objABean = new UserActivityReportBean();
                objABean.setUserId(rs.getInt("user_id"));
                objABean.setUserName(rs.getString("username"));
                objABean.setLoginTime(rs.getString("login_time"));
                objABean.setLogoutTime(rs.getString("logout_time"));
                objABean.setGrabFolder(rs.getString("grab_folder"));
                alst.add(objABean);

            }
        } catch (Exception e) {
            System.out.println("Exception in getUserrActivityReport" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Exception in Closing Connection" + ex);
            }
        }
        return alst;
    }
     public List<String> getAllUsername() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<String> alst = new ArrayList<String>();
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select username from usermaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                
                alst.add(rs.getString("username"));
               // alst.add(username);
            }
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
        return alst;
    }

}
