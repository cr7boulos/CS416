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
public class homePageController {

    public static Route serveHomePage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "velocity/index.vm");
    };
}
