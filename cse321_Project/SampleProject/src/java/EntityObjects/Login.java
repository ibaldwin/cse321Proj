/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityObjects;

/**
 *
 * @author DELL
 */
public class Login {
    private String userName;
    private String password;
    private String email;
    private int uid;
    
    public Login(String userName, String Password){
        setUserName(userName);
        setPassword(Password);
    }
    
    public Login(String userName, String Password, String email){
        setUserName(userName);
        setPassword(Password);
        setEmail(email);
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    final public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    final public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    final public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(int uid) {
        this.uid = uid;
    }
    
   
}
