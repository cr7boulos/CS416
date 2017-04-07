package longbottom.accounts;

import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cr7bo on 4/7/2017.
 */
public class Dashboard {

    public static Route userDashboard = (Request request, Response response) -> {

        //System.out.println(request.queryParams("test"));


        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "/velocity/dashboard.vm");
    };
}
