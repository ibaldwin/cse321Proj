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
import OurDatabase.Database;
import EntityObjects.*;

public class TestDb {
    public static void main(String args[]) {
        Database db = new Database();
        //Login login = new Login("user","name","something");
        Login login1 = new Login("user","name");
        //UserState usr = new UserState(1);
        //public UserState(int userId, int currentState, String history, String friendList, String requestList) {
       // UserState usr2 = new UserState(1,1,"1","1","1");
        //db.createTable();
        //db.createLogin(login);
        //db.createUserState(usr);
        //db.updateUserState(usr2);
        db.checkUser(login1);
        UserState s = db.selectUserStates(login1);
        System.out.println("Values : " + s.getCurrentState() +"," + s.getFriendList());
        db.exterminate();
    }
}
