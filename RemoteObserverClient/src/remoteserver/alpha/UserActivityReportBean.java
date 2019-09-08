/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobserver.alpha;

/**
 *
 * @author Sood
 */
public class UserActivityReportBean {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getGrabFolder() {
        return grabFolder;
    }

    public void setGrabFolder(String grabFolder) {
        this.grabFolder = grabFolder;
    }
    private String userName,loginTime,logoutTime,grabFolder;
}
