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

        // this will be removed; the userId will come from the Login service
        int uid = Integer.parseInt(request.queryParams("userId"));


        List<Map<String, Object>> list = DAO.getAllProjects(uid);

        Map<String, Object> model3 = new HashMap<>();
        model3.put("dataList", list);
        model3.put("userId", uid);

        /*for(Map<String,Object> m : list){
            System.out.println(m.keySet());
        }*/

        return ViewUtil.render(model3, "/velocity/dashboard.vm");

    };

    public static Route projectPartial = (Request request, Response response) -> {
        List<Map<String, Object>> list = DAO.getAllProjects(1);

        Map<String, Object> model3 = new HashMap<>();
        model3.put("dataList", list);

        return ViewUtil.render(model3, "/velocity/project_partial.vm");
    };
}
