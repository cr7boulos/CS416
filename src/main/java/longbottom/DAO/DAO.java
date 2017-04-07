package longbottom.DAO;

import longbottom.accounts.*;

import java.util.ArrayList;

/**
    Some methods will return booleans to report whether or not there was an error.
    Check all returned ArrayLists or Objects if they are null. If the object is null then there was an error or it does not exist.
 */
public class DAO {

    public static ArrayList<User> getAllUsers(int pId){
        return null;
    }

    public static ProjectUsers getProjectUsers(int pId){
        return null;
    }

    //returns false if error.
    public static boolean createProject(String name, String description, long time, int manager){
        return false;
    }

    //Update project with set parameters. Set parameters to null to not change it. pId is required.
    public static boolean updateProject(int pId, String name, String description, long time, int manager){
        return false;
    }

    //returns false if error.
    public static boolean deleteProject(int pId){
        return false;
    }

    //User is added to project
    //returns false if error.
    public static boolean acceptUser(int pId, int uId){
        return false;
    }

    //returns false if error.
    public static boolean leaveProject(int pId, int uId){
        return false;
    }

    //User asks Manager to join project
    //returns false if error.
    public static boolean requestJoin(int pId, int uId){
        return false;
    }

    //Returns false for wrong username or password.
    //Returns true if login was successful.
    public static boolean login(String username, String password){
        return false;
    }

    //Create post for given project Id
    //returns false if error.
    public static boolean createPost(int pId, Post post){
        return false;
    }

    //returns false if error.
    public static boolean deletePost(int post){
        return false;
    }

    //returns false if error.
    public static boolean createChatMessage(ChatMessage chatMessage){
        return false;
    }

    //gets chat messages for given project Id
    public static ArrayList<ChatMessage> getChatMessages(int pId){
        return null;
    }

    //returns false if error.
    public static boolean sendEmail(Email email){
        return false;
    }

    //get emails for given user Id
    public static ArrayList<Email> getUserEmails(int uId){
        return null;
    }
}
