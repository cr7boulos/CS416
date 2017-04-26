package longbottom.pages;

import longbottom.DAO.DAO;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Japji on 4/9/2017.
 */
public class sponsorsPageController {


    public static Route serveSponsorsPage = (Request request, Response response) ->{
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "velocity/sponsor.vm");
    };
}
