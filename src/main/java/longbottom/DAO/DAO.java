package longbottom.DAO;

import longbottom.accounts.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static Sql2o sql2o;

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

    //Returns false for wrong email or password.
    //Returns true if login was successful.
    public static boolean login(String email, String password){
        return false;
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
