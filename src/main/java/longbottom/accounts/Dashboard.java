package longbottom.accounts;

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
        Map<String, Object> model3 = new HashMap<>();
        if(userId != DAO.NA){

            model3.put("userId", userId);

            if(userId == DAO.ADMIN){
                model3.put("buttonOptions", "/velocity/adminView");
                model3.put("viewType", DAO.ADMIN); // this is a flag for the JS
            }
            else{ //user is a student or professor
                if(userId == DAO.PROFESSOR){
                    model3.put("buttonOptions", "/velocity/professorView");
                    model3.put("viewType", DAO.PROFESSOR); // this is a flag for the JS
                }
                if(userId == DAO.STUDENT){
                    model3.put("buttonOptions", "/velocity/studentView");
                    model3.put("viewType", DAO.STUDENT); // this is a flag for the JS
                }

                //both students and professors get access to the project view.
                List<Map<String, Object>> list = DAO.getAllProjects(userId);
                model3.put("dataList", list);
            }

            return ViewUtil.render(model3, "/velocity/dashboard.vm");

        }
        else{
            return ViewUtil.render(model3, "/velocity/dashboard.vm"); //login failed
        }




        // this will be removed; the userId will come from the Login service
//        int uid = Integer.parseInt(request.queryParams("userId"));

    };

    public static Route projectPartial = (Request request, Response response) -> {
        List<Map<String, Object>> list = DAO.getAllProjects(1);

        Map<String, Object> model3 = new HashMap<>();
        model3.put("dataList", list);

        return ViewUtil.render(model3, "/velocity/project_partial.vm");
    };
}
