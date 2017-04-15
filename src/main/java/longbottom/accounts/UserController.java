package longbottom.accounts;

import longbottom.DAO.DAO;
import longbottom.login.LoginController;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Japji on 4/7/2017.
 */
public class UserController {

        //this method is a Java 8 feature called a functional interface
        public static Route getAllUsers = (Request request, Response response) -> {
            LoginController.isAuthenticated(request, response);
            Map<String, Object> model = new HashMap<>();
            model.put("users", DAO.getAllUsers());

            return ViewUtil.render(model, "/velocity/admin_partial.vm");
        };

//        public static Route getOneUser = (Request request, Response response) -> {
//            LoginController.isAuthenticated(request, response);
//            HashMap<String, Object> model = new HashMap<>();
//            User user = userDao.getUserByName(getParamUser(request));
//            model.put("user", user);
//            return ViewUtil.render(request, model, "/velocity/test.vm");
//        };


}
