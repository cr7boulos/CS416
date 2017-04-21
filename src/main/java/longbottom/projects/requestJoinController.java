package longbottom.projects;

import longbottom.DAO.DAO;
import spark.Request;
import spark.Response;
import spark.Route;
/**
 * Created by Japji on 4/14/2017.
 */
public class requestJoinController {

    public static Route serveToJoin = (Request request, Response response) -> {

        if(DAO.requestJoin(Integer.parseInt(request.queryParams("projectId")), Integer.parseInt(request.queryParams("userId"))))
        {
            return "1";
        }
        else
        {
            return "0";
        }
    };
}
