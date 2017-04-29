package longbottom.login;

// based off code from here: https://github.com/tipsy/spark-basic-structure/blob/master/src/main/java/app/login/LoginController.java

import java.util.*;
import spark.*;
import longbottom.DAO.*;
import longbottom.util.ViewUtil;

public class LoginController {

    // Serves login page
    public static Route serveLoginPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "/velocity/login.vm");
    };

    // If a user logs out
    // remove currentUserId from session attributes, set loggedOut to true, and redirect the user to the login page.
    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUserId");
        request.session().attribute("loggedOut", true);
        response.redirect("/velocity/login.vm");
        return null;
    };

    // If credentials checkout goto the dashboard
    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        // valid username and password -> dashboard
        // Add the user email to the model
        // Add the user id to the session
        // goto dashboard
        if(DAO.login(request.queryParams("email"), request.queryParams("password")) != DAO.NA){
            model.put("currentUserEmail", request.queryParams("email"));
            request.session().attribute("currentUserId", "ID"/*placeholder*/);
            return ViewUtil.render(model, "/velocity/dashboard.vm");
        }
        else{
            // authentication failed. Go back to login page
            return ViewUtil.render(model, "/velocity/login.vm");
        }
    };

    // Check if a user's email and password exist
    // returns true if user exists
    public static boolean isAuthenticated(Request request, Response response){
        return (DAO.login( request.queryParams("email"), request.queryParams("password")) != DAO.NA);
    }

    public static void login(Request request, Response response){
        request.session().attribute("loggedin", true);
    }

    public static void logout(Request request, Response response){
        request.session().attribute("loggedin", false);
    }

    public static boolean isLoggedIn (Request request, Response response){

        return (boolean)request.session().attribute("loggedin");
    }
}
