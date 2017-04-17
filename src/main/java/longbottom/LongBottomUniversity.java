package longbottom;
import longbottom.projects.*;

import longbottom.DAO.DAO;
import longbottom.accounts.Dashboard;
import longbottom.accounts.UserController;
import longbottom.login.LoginController;
import longbottom.pages.homePageController;
import longbottom.pages.sponsorsPageController;
import longbottom.projects.requestJoinController;
import longbottom.util.DemoController; //import the needed controller classes here
import longbottom.chat.ChatController;
import longbottom.pages.contactPageController;
import longbottom.pages.aboutPageController;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class LongBottomUniversity {

    public static Sql2o sql2o;

    public static void main(String[] args){

        //which local port application binds to
        port(1250);
        staticFiles.location("/public");

        get("/hello", (req, res) -> {
            return "hello world!";
        });

        // Simple controller test.
        // to see the results of this controller
        // In Postman, set the request type to POST then
        // paste this URL below where is says "Enter request URL":
        // localhost:1250/post?test=456
        post("/post", DemoController.testing);
        get("/login", LoginController.serveLoginPage);
        get("/chat", ChatController.chatHistory);
        post("/projects", Dashboard.projectPartial);

        get("/dashboard", Dashboard.userDashboard);
        get("/contact", contactPageController.serveContactPage);
        get("/about", aboutPageController.serveAboutPage);
        get("/home", homePageController.serveHomePage);
        get("/sponsors", sponsorsPageController.serveSponsorsPage);
        post("/requestJoin", requestJoinController.serveToJoin);
        post("/deleteUser", UserController.deleteUser);
        post("/updateUser", UserController.updateUser);
        post("/updateProject", ProjectController.updateProject);
        post("/newProject", ProjectController.newProject);

    }
}
