package longbottom.DAO;

import longbottom.accounts.*;
import longbottom.email.Email;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

public class DAO {

    public static Sql2o sql2o;

    //NA = Not Available.
    public final static int NA = -1;
    public final static int ADMIN = 0;
    public final static int PROFESSOR = 1;
    public final static int STUDENT = 2;

    //Static constructor
    //See: http://www.sql2o.org/docs/configuration/
    static{
        //CONNECT TO MYSQL DATABASE
        //DAO.sql2o = new Sql2o("jdbc:mysql://localhost:3306/long_bottom_university", "admin", "$80k");

        //This connects to the hosted database
        DAO.sql2o = new Sql2o("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_d4c6b1cbcafb5a7", "b97ef38c93ad46", "9a133bff");
    }

    public static List<Map<String, Object>> getUsersFromProject(int pId){
        String sql = "SELECT u.userId, u.firstName, u.lastName, u.email FROM user u INNER JOIN works_in w ON u.userId = w.userId AND w.projectId = :pId";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("pId", pId)
                    .executeAndFetchTable().asList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

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

    public static User getUser(int userId){
        String sql = "SELECT * from user where userId = :userId";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).
                    addParameter("userId", userId).
                    executeAndFetchFirst(User.class);
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

    public static int getUserIdByEmail(String email){
        String sql = "SELECT userId from user WHERE email = :email";

        try(Connection con = sql2o.open()){
            return con.createQuery(sql).
                    addParameter("email", email).
                    executeScalar(Integer.class);
        }
    }

    public static String getEmailByUserId(int uid){
        String sql = "SELECT email from user WHERE userId = :userId";

        try(Connection con = sql2o.open()){
            return con.createQuery(sql).
                    addParameter("userId", uid).
                    executeScalar(String.class);
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

    public static List<Map<String, Object>> listProjectsForAdmin(){
        String sql = "select firstName, lastName, projectId, userId, name " +
                "from " +
                "projects " +
                "inner join user on manager = userId " +
                "where granted = 0 ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetchTable().asList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //Time format: YYYY-MM-DD HH-MM-SS Ex. "2010-12-30 15:30:12"
    public static boolean createProject(String name, String description, int manager){
        String sql =
                "INSERT INTO projects (name, description, time_stamp, manager) " +
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
    public static boolean updateProjectName(int pId, String name){
        String sql = "UPDATE projects " +
                "SET name = :name " +
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
        String sql = "UPDATE table_name " +
                "SET description = :description " +
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
        String sql = "UPDATE table_name " +
                "SET time_stamp = :time_stamp " +
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
        String sql = "UPDATE table_name " +
                "SET manager = :manager " +
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

    public static boolean updateUserFirstName(int uId, String firstname) {
        String sql = "UPDATE user " +
                "SET firstName = :firstname " +
                "WHERE userId = :uId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .addParameter("firstname", firstname)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUserLastName(int uId, String lastname) {
        String sql = "UPDATE user " +
                "SET lastName = :lastname " +
                "WHERE userId = :uId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .addParameter("lastname", lastname)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUserEmail(int uId, String email) {
        String sql = "UPDATE user " +
                "SET email = :email " +
                "WHERE userId = :uId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .addParameter("email", email)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUserPassword(int uId, String password) {
        String sql = "UPDATE user " +
                "SET password = :password " +
                "WHERE userId = :uId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .addParameter("password", password)
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

    public static List<Map<String, Object>> listJoinRequests(int userId){
        String sql = "select user.firstName as sFirst, user.lastName as sLast, works_in.id as wid, t.userId as profId, t.firstName as pFirst, t.lastName as pLast, works_in.projectId, user.userId as stuId, name " +
                "from " +
                "works_in " +
                "inner join user on works_in.userId = user.userId " +
                "inner join projects on projects.projectId = works_in.projectId " +
                "inner join user as t on projects.manager = t.userId " +
                "where accepted = 0 and projects.manager = :userId";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetchTable().asList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteUser(int uId){
        String sql = "DELETE FROM user WHERE userId = :uId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean confirmProject(int pID){
        String sql = "UPDATE projects " +
                "SET granted = 1 " +
                "WHERE projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pId", pID)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //User is added to project
    public static boolean acceptUser(int pId, int uId) {
        String sql = "UPDATE works_in " +
                "SET granted = 1 " +
                "WHERE userId = :uId AND projectId = :pId";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("uId", uId)
                    .addParameter("pId", pId)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //User is added to project
    public static boolean acceptUser(int wid) {
        String sql = "UPDATE works_in " +
                "SET accepted = 1 " +
                "WHERE id = :wid";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("wid", wid)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }





    public static boolean leaveProject(int wid){
        String sql = "DELETE FROM works_in WHERE id = :wid";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("wid", wid)
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
        String sql = "SELECT userId FROM user WHERE email = :email AND password = :password";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("email", email)
                    .addParameter("password", password)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            //e.printStackTrace();
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
            //System.out.println("Tripped on NullPointerException");
            //e.printStackTrace();
            //return -1;
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
            //e.printStackTrace();
            //return -1;
        }
        String sql_student = "SELECT userId FROM student WHERE userId = :userId";
        try(Connection con = sql2o.open()) {
            int rId = con.createQuery(sql_student)
                    .addParameter("userId", uId)
                    .executeScalar(Integer.class);
            if(rId == uId){
                return STUDENT;
            }
        }catch (Exception e){
            //e.printStackTrace();
            //return -1;
        }
        return -1;
    }

    //Create post for given project Id
    // message parameter has not been added
    public static boolean createPost(int pId, String header, String body){
        String sql =
                "INSERT INTO posts (projectId, header, body, time_stamp)" +
                        "VALUES (:pId, :header, :message, NOW())";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("pId" , pId)
                    .addParameter("header", header)
                    .addParameter("body", body)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletePost(int postId){
        String sql =
                "DELETE FROM posts WHERE id = :postId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("postId", postId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createChatMessage(int pId, int uId, String message){
        String sql =
                "INSERT INTO chat (projectId, userId, text, time_stamp)" +
                        "VALUES (:pId, :uId, :message, NOW())";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("pId" , pId)
                    .addParameter("uId", uId)
                    .addParameter("message", message)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //gets chat messages for given project Id
    public static List<Map<String, Object>> getChatMessages(int pId){
        String sql = "select * from " +
                "(SELECT u.userId, u.firstName, u.lastName, u.email, c.text, " +
                "c.time_stamp FROM user u " +
                "INNER JOIN chat c ON c.userId = u.userId AND c.projectId = :pId) as chat " +
                "order by chat.time_stamp desc";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("pId", pId)
                    .addColumnMapping("time_stamp", "time")
                    .executeAndFetchTable().asList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean sendEmail(int from, int to, String subject, String body){
        String sql =
                "INSERT INTO email (email.from, email.to, subject, body, time_stamp) " +
                        "VALUES (:from, :to, :subject, :body, now() )";
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

    public static boolean deleteEmail(int eId){
        String sql =
                "DELETE FROM email WHERE id = :eId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("eId", eId)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //get emails for given user Id
    public static List<Email> getUserEmails(int uId){
        String sql = "SELECT * FROM email WHERE email.to = :userId ORDER BY time_stamp DESC";
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
