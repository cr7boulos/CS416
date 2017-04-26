package longbottom.dashboard;

import longbottom.DAO.DAO;
import longbottom.login.LoginController;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;


import javax.swing.text.View;
import java.util.*;

/**
 * Created by cr7bo on 4/7/2017.
 */
public class Dashboard {

    public static Route userDashboard = (Request request, Response response) -> {
        int userId = DAO.login(request.queryParams("username"), request.queryParams("password"));
        request.session().attribute("userId", userId); //add userId to session

        Map<String, Object> model3 = new HashMap<>();

        int userIdentity = DAO.getIdentity(userId);
        System.out.println(userIdentity);
        if(userIdentity != DAO.NA){
            String username = DAO.getUser(userId).getFullName();
            String userType;

            model3.put("userId", userId);
            model3.put("username", username);

            if(userIdentity == DAO.ADMIN){
                model3.put("buttonOptions", "/velocity/adminView");
                model3.put("users", DAO.getAllUsers());
                model3.put("userType", "Admin");
                System.out.println("Got to admin");
                model3.put("viewType", DAO.ADMIN); // this is a flag for the JS
            }
            else{ //user is a student or professor
                if(userIdentity == DAO.PROFESSOR){
                    model3.put("buttonOptions", "/velocity/professorView");
                    model3.put("userType", "Professor");
                    System.out.println("Got to professor");
                    model3.put("viewType", DAO.PROFESSOR); // this is a flag for the JS
                }
                if(userIdentity == DAO.STUDENT){
                    model3.put("buttonOptions", "/velocity/studentView");
                    model3.put("userType", "Student");
                    System.out.println("Got to student");
                    model3.put("viewType", DAO.STUDENT); // this is a flag for the JS
                }

                //both students and professors get access to the project view.
                List<Map<String, Object>> list = DAO.getAllProjects(userId);
                model3.put("dataList", list);
            }

            return ViewUtil.render(model3, "/velocity/dashboard.vm");

        }
        else{
            response.redirect("/login");
            return ViewUtil.render(model3, "/velocity/login.vm"); //login failed
        }




        // this will be removed; the userId will come from the Login service
//        int uid = Integer.parseInt(request.queryParams("userId"));

    };

    public static Route projectPartial = (Request request, Response response) -> {
        int userId = Integer.parseInt(request.queryParams("userId"));

        int viewType = DAO.getIdentity(userId);

        List<Map<String, Object>> list = DAO.getAllProjects(userId);

        Map<String, Object> model3 = new HashMap<>();

        model3.put("dataList", list);
        model3.put("viewType", viewType);

        return ViewUtil.render(model3, "/velocity/project_partial.vm");
    };

    public static Route emailPartial = (Request request, Response response) -> {
        int userId = Integer.parseInt(request.queryParams("userId"));
        System.out.println(userId + " from emailPartial");
        Map<String, Object> model = new HashMap<>();
        model.put("DAO", DAO.class);
        model.put("email", DAO.getUserEmails(userId));

        return ViewUtil.render(model, "/velocity/email_partial.vm");
    };
}
