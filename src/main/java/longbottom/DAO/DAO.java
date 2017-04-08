package longbottom.DAO;

import longbottom.accounts.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static Sql2o sql2o;

    //NA = Not Available.
    public final static int NA = -1;
    public final static int ADMIN = 0;
    public final static int PROFESSOR = 1;
    public final static int STUDENT = 2;

    public static List<User> getAllUsers(){
        String sql =
                "SELECT userId, firstName, lastName, email, password " +
                        "FROM user";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public static List<works_in> getWorksIn(int pId){
        String sql =
                "SELECT projectId, userId, accepted FROM works_in WHERE projectId = :projectId";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("projectId", pId)
                    .executeAndFetch(works_in.class);
        }
    }

    public static void createProject(String name, String description, long time, int manager){
        String sql =
                "INSERT INTO projects (name,description,time_stamp,manager)\n" +
                        "VALUES (:name, :description, :time_stamp, :manager)";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("time_stamp", time)
                    .addParameter("manager", manager)
                    .executeAndFetch(works_in.class);
        }
    }

    //Update project with set parameters. Set parameters to null to not change it. pId is required.
    public static void updateProject(int pId, String name, String description, long time, int manager){

    }

    public static void deleteProject(int pId){

    }

    //User is added to project
    public static void acceptUser(int pId, int uId){

    }


    public static void leaveProject(int pId, int uId){

    }

    //User asks Manager to join project
    public static void requestJoin(int pId, int uId){

    }

    //Returns -1 if login failed (wrong email or password).
    //Returns user ID if login was successful.
    public static int login(String email, String password){
        return NA;
    }

    //Returns if the User is an Admin(0), Professor(1), or Student (2). If uID is not found it will return -1 which is equal to NA.
    public static int getIdentity(int uId){
        return NA;
    }

    //Create post for given project Id
    public static void createPost(int pId, Post post){

    }

    public static void deletePost(int post){

    }

    public static void createChatMessage(ChatMessage chatMessage){

    }

    //gets chat messages for given project Id
    public static ArrayList<ChatMessage> getChatMessages(int pId){
        return null;
    }

    public static void sendEmail(Email email){

    }

    //get emails for given user Id
    public static ArrayList<Email> getUserEmails(int uId){
        return null;
    }

}
