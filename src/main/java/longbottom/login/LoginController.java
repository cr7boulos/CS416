package longbottom.login;

import java.util.*;
import spark.*;
import longbottom.DAO.*;
import longbottom.util.ViewUtil;
import longbottom.util.RequestUtil;

public class LoginController {
    //If a user logs out
    //remove currentUser from attributes, set loggedOut to true, and redirect the user to the login page.
    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect("/velocity/test.vm");//redirect to login page
        return null;
    };

    //After login go to dashboard
    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        if(DAO.login(request.queryParams("email"), request.queryParams("password")) == DAO.NA){
            //authentication failed. Go back to login page
        }
        //valid username and password -> dashboard
        //add user email or id to model??
        model.put("currentUser", 1/*placeholder*/);
        return ViewUtil.render(model, "/velocity/dashboard.vm");


    };

    //Check if a user's email and password exist
    //returns true if user exists
    public static boolean isAuthenticated(Request request, Response response){
        return (DAO.login( request.queryParams("email"), request.queryParams("password")) != DAO.NA);
    }
}
