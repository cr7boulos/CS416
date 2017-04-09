package longbottom.accounts;

import longbottom.DAO.DAO;
import longbottom.login.LoginController;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;


import java.util.*;

/**
 * Created by cr7bo on 4/7/2017.
 */
public class Dashboard {

    public static Route userDashboard = (Request request, Response response) -> {
        //int userId = LoginController.isAuthenticated(request, response);

        //this is test code; will be deleted in final
        //implementation
        Map<String, Object> model1 = new HashMap<>();
        model1.put("name", "Random name");
        model1.put("description", "Random project");
        model1.put("manager", "Zhang");
        model1.put("startDate", "2012-3-12");
        model1.put("in", 0);
        Map<String, Object> model2 = new HashMap<>();
        model2.put("name", "Steering Elections");
        model2.put("description", "Emergence of consensus");
        model2.put("manager", "Zhang");
        model2.put("startDate", "2012-3-12");
        model2.put("in", 1);


        List<Map<String, Object>> list = new ArrayList<>();
        list.add(model1);
        list.add(model2);

        Map<String, Object> model3 = new HashMap<>();
        model3.put("dataList", list);

        return ViewUtil.render(model3, "/velocity/dashboard.vm");
        /*if(userId == 0){
            // DAO.getProjectRequests()
            //model.put("requests", //put requests here)
        }


        if(userId == 2){
            //List<Map<String,Object>> projectDetails = DAO.getAllProjects();
            model.put("projects", projectDetails);
        }
        */
    };

    public static Route projectPartial = (Request request, Response response) -> {
        Map<String, Object> model3 = new HashMap<>();
        return ViewUtil.render(model3, "/velocity/project_partial.vm");
    };
}
