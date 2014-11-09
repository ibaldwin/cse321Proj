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
public class UserState {
    
    private int userId;
    private int currentState;
    private String history;
    private String friendList;
    private String requestList;

    public UserState(int userId) {
        this.userId = userId;
    }

    public UserState(int userId, int currentState, String history, String friendList, String requestList) {
        this.userId = userId;
        this.currentState = currentState;
        this.history = history;
        this.friendList = friendList;
        this.requestList = requestList;
    }

    public UserState(int userId, int currentState, String history) {
        this.userId = userId;
        this.currentState = currentState;
        this.history = history;
    }

    
    /**
     * @return the currentState
     */
    public int getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * @return the friendList
     */
    public String getFriendList() {
        return friendList;
    }

    /**
     * @param friendList the friendList to set
     */
    public void setFriendList(String friendList) {
        this.friendList = friendList;
    }

    /**
     * @return the requestList
     */
    public String getRequestList() {
        return requestList;
    }

    /**
     * @param requestList the requestList to set
     */
    public void setRequestList(String requestList) {
        this.requestList = requestList;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
