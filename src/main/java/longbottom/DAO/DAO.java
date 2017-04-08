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

    //Time format: YYYY-MM-DD HH-MM-SS Ex. "2010-12-30 15:30:12"
    public static boolean createProject(String name, String description, String time, int manager){
        String sql =
                "INSERT INTO projects (name,description,time_stamp,manager)\n" +
                        "VALUES (:name, :description, :time_stamp, :manager)";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("time_stamp", time)
                    .addParameter("manager", manager)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Update project with set parameters. Set parameters to null to not change it. pId is required.
    //Time format: YYYY-MM-DD HH-MM-SS Ex. "2010-12-30 15:30:12"
    public static boolean updateProject(int pId, String name, String description, String time, int manager){
        return false;
    }

    public static boolean deleteProject(int pId){
        return false;
    }

    //User is added to project
    public static boolean acceptUser(int pId, int uId){
        return false;
    }


    public static boolean leaveProject(int pId, int uId){
        return false;
    }

    //User asks Manager to join project
    public static boolean requestJoin(int pId, int uId){
        return false;
    }

    //Returns -1 if login failed (wrong email or password).
    //Returns user ID if login was successful.
    public static boolean login(String email, String password){
        return false;
    }

    //Returns if the User is an Admin(0), Professor(1), or Student (2). If uID is not found it will return -1 which is equal to NA.
    public static int getIdentity(int uId){
        return NA;
    }

    //Create post for given project Id
    public static boolean createPost(int pId, Post post){
        return false;
    }

    public static boolean deletePost(int post){
        return false;
    }

    public static boolean createChatMessage(ChatMessage chatMessage){
        return false;
    }

    //gets chat messages for given project Id
    public static ArrayList<ChatMessage> getChatMessages(int pId){
        return null;
    }

    public static boolean sendEmail(Email email){
        return false;
    }

    //get emails for given user Id
    public static ArrayList<Email> getUserEmails(int uId){
        return null;
    }

}
