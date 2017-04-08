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

    //Check if a user's email and password exist
    public static boolean isAuthenticated(Request request, Response response){
        String email = request.queryParams("email");
        String password = request.queryParams("password");
        return (DAO.login(email,password) != -1);
    }
}
