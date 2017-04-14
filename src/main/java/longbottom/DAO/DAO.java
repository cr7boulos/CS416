package longbottom.DAO;

import longbottom.accounts.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DAO {

    public static Sql2o sql2o;

    //NA = Not Available.
    public final static int NA = -1;
    public final static int ADMIN = 0;
    public final static int PROFESSOR = 1;
    public final static int STUDENT = 2;


    public static List<Map<String, Object>> getAllProjects(int userId){


        String sql = "SELECT name, description, time_stamp, projectId, firstName, lastName ," +
                "(projectId in (select projectId from works_in where userId = :userId and accepted = 1)) as 'in'" +
                "from" +
                "(projects " +
                "inner join user on userId = manager)";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetchTable().asList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

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
    public static boolean createProject(String name, String description, int manager){
        String sql =
                "INSERT INTO projects (name, description, time_stamp,manager)\n" +
                        "VALUES (:name, :description, NOW(), :manager)";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
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
    public static boolean updateProjectName(int pId, String name, String description, String time, int manager){
        String sql = "UPDATE table_name" +
                "SET name = :name" +
                "WHERE projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pId", pId)
                    .addParameter("name", name)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateProjectDescription(int pId, String description){
        String sql = "UPDATE table_name" +
                "SET description = :description" +
                "WHERE projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pId", pId)
                    .addParameter("description", description)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Time format: YYYY-MM-DD HH-MM-SS Ex. "2010-12-30 15:30:12"
    public static boolean updateProjectTime(int pId, String time){
        String sql = "UPDATE table_name" +
                "SET time_stamp = :time_stamp" +
                "WHERE projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pId", pId)
                    .addParameter("time_stamp", time)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateProjectManager(int pId, int manager){
        String sql = "UPDATE table_name" +
                "SET manager = :manager" +
                "WHERE projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pId", pId)
                    .addParameter("manager", manager)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static boolean deleteProject(int pId){
        String sql = "DELETE FROM projects WHERE projectId = :projectId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("projectId", pId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //User is added to project
    public static boolean acceptUser(int pId, int uId){
        return false;
    }


    public static boolean leaveProject(int pId, int uId){
        String sql = "DELETE FROM projects WHERE projectId = :projectId AND userId = :userId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("projectId", pId)
                    .addParameter("userId", uId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //User asks Manager to join project
    public static boolean requestJoin(int pId, int uId){
        String sql = "INSERT INTO works_in (projectId, userId)" +
                "VALUES (:projectId, :userId)";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("projectId", pId)
                    .addParameter("userId", uId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Returns -1 if login failed (wrong email or password).
    //Returns user ID if login was successful.
    public static int login(String email, String password){
        String sql = "SELECT userId FROM users WHERE email = :email AND password = :password";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("email", email)
                    .addParameter("password", password)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    //Returns if the User is an Admin(0), Professor(1), or Student (2). If uID is not found it will return -1 which is equal to NA.
    public static int getIdentity(int uId){
        String sql_admin = "SELECT userId FROM admin WHERE userId = :userId";
        try(Connection con = sql2o.open()) {
            int rId = con.createQuery(sql_admin)
                    .addParameter("userId", uId)
                    .executeScalar(Integer.class);
            if(rId == uId){
                return ADMIN;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        String sql_prof = "SELECT userId FROM professor WHERE userId = :userId";
        try(Connection con = sql2o.open()) {
            int rId = con.createQuery(sql_prof)
                    .addParameter("userId", uId)
                    .executeScalar(Integer.class);
            if(rId == uId){
                return PROFESSOR;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        String sql_student = "SELECT userId FROM student WHERE userId = :userId";
        try(Connection con = sql2o.open()) {
            int rId = con.createQuery(sql_admin)
                    .addParameter("userId", uId)
                    .executeScalar(Integer.class);
            if(rId == uId){
                return STUDENT;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return -1;
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

    public static boolean sendEmail(int from, int to, String subject, String body){
        String sql =
                "INSERT INTO email (from, to, subject, body, time_stamp)" +
                        "VALUES (:from, :to, :subject, :body, NOW())";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("from", from)
                    .addParameter("to", to)
                    .addParameter("subject", subject)
                    .addParameter("body", body)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //get emails for given user Id
    public static List<Email> getUserEmails(int uId){
        String sql = "SELECT * FROM email WHERE userId = :userId";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("userId", uId)
                    .addColumnMapping("time_stamp", "time")
                    .executeAndFetch(Email.class);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
