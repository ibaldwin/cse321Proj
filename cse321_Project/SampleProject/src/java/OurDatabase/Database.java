package OurDatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import EntityObjects.*;
/**
 * Responsible for the Database connection
 *
 */
public class Database
{
    private Connection c;
    
    //Constructor which creates the database connection
    public Database(){
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:user.db");
                c.setAutoCommit(true);
                System.out.println("Opened database successfully");
        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.printStackTrace(System.out);
                c = null;
                //System.exit(0);
        }

    }
   
    //method to close the connection
    public void exterminate(){
        try {
                c.close();
        } catch (SQLException e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                c = null;
                //System.exit(0);
        }
    }
	
/**
 * Creates the initial table
 * Modified from code from http://www.tutorialspoint.com/sqlite/sqlite_java.htm
 */
  public void createTable( )
  {
    Statement stmt = null;
    try {
      stmt = c.createStatement();
      String sql = "CREATE TABLE USERS(" +
    		  	" UID			INTEGER PRIMARY KEY,"	+
    		  	" USERNAME		TEXT UNIQUE, " + 
    		  	" PASSWD		TEXT, " + 
    		  	" EMAIL 		TEXT)";
      
      stmt.executeUpdate(sql);
      stmt.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      e.getStackTrace();
      //System.exit(0);
    }
    System.out.println("USERS Table created successfully");
    
    try {
        stmt = c.createStatement();
        String sql = "CREATE TABLE STATES(" +
      		    	" CURRSTATE		INT, " + 
                        " HISTORY               TEXT, " +
                        " FRIENDLIST            TEXT, " +
                        " FRIENDREQ             TEXT," +
                        " UID                INT UNIQUE)";
        
        stmt.executeUpdate(sql);
        stmt.close();
        
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        e.getStackTrace();
        //System.exit(0);
      }
      System.out.println("STATES Table created successfully");         
    }
  
    
    public void createLogin(Login loginObj) {
        Statement stmt = null;
        try {
                stmt = c.createStatement();
                String sql = "INSERT INTO USERS (USERNAME, PASSWD, EMAIL) "
                                + "VALUES ('" + loginObj.getUserName()
                                + "', '" + loginObj.getPassword()
                                + "', '" + loginObj.getEmail() 
                                + "');"; 
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();

        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.getStackTrace();
                //System.exit(0);
        }
        System.out.println("user login created successfully");
    }
    
     public void createUserState(UserState stateObj) {
        Statement stmt = null;
        try {
                stmt = c.createStatement();
                String sql = "INSERT INTO STATES (UID) "
                                + "VALUES (" + stateObj.getUserId()
                                + ");"; 
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();

        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.getStackTrace();
                //System.exit(0);
        }
        System.out.println("user state created successfully");
    }
     
    public void updateUserState(UserState stateObj) {
        Statement stmt = null;
        try {
                stmt = c.createStatement();
                String sql = "UPDATE STATES SET CURRSTATE = " + stateObj.getCurrentState() +
                             ", HISTORY = '" + stateObj.getHistory() +
                             "', FRIENDLIST = '" + stateObj.getFriendList() +
                             "', FRIENDREQ = '" + stateObj.getRequestList() +
                             "' WHERE UID = " + stateObj.getUserId() +
                             ";"; 
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();

        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.getStackTrace();
                //System.exit(0);
        }
        System.out.println("user state created successfully");
    }
     
    public boolean checkUser(Login user){
			
        Statement stmt = null;
        try {
                stmt = c.createStatement();
                String sql = "SELECT * FROM USERS WHERE " 
                                + "USERNAME = '" + user.getUserName() + "';";
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                        if(rs.getString("PASSWD").equals(user.getPassword())) {
                            System.out.println("Login verified successfully");
                            user.setUid(Integer.parseInt(rs.getString("UID")));
                            return true;
                        }
                }
                stmt.close();

        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.getStackTrace();
                System.exit(0);
        }
        System.out.println("Login not verified successfully");
        return false;
    }
	
    public UserState selectUserStates(Login user){
			
        Statement stmt = null;
        UserState obj = new UserState(user.getUid());
        try {
                stmt = c.createStatement();
                String sql = "SELECT * FROM STATES WHERE " 
                                + "UID = '" + user.getUid() + "';";
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                     //user.setUid(Integer.parseInt(rs.getString("UID")));   
                    obj.setCurrentState(Integer.parseInt(rs.getString("CURRSTATE")));
                    obj.setFriendList(rs.getString("FRIENDLIST"));
                    obj.setHistory(rs.getString("HISTORY"));
                    obj.setRequestList(rs.getString("FRIENDREQ"));
                }
                stmt.close();

        } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.getStackTrace();
                System.exit(0);
        }
        System.out.println("Select from states query executed successfully");
        return obj;
    }
}
