package longbottom.pages;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jacob on 4/9/2017.
 */
public class aboutPageController {
    public static Route serveAboutPage = (Request request, Response response) -> {

        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "velocity/contactpage.vm");
    };
}
