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

        // Method to delete a user
        public static Route deleteUser = (Request request, Response response) -> {

            int userId = Integer.parseInt(request.queryParams("userId"));

            if (DAO.deleteUser(userId)) {
                return "1";
            } else {
                return "0";
            }
        };

        // Method to update various user parameters
        public static Route updateUser = (Request request, Response response) -> {
            LoginController.isAuthenticated(request, response);

            int userId = Integer.parseInt(request.queryParams("userId"));
            String firstname = request.queryParams("firstname");
            String lastname = request.queryParams("lastname");
            String email = request.queryParams("email");
            String password = request.queryParams("password");

            if (firstname != null) {
                DAO.updateUserFirstName(userId, firstname);
            }

            if (lastname != null) {
                DAO.updateUserLastName(userId, lastname);
            }

            if (email != null) {
                DAO.updateUserEmail(userId, email);
            }

            if (password != null) {
                DAO.updateUserPassword(userId, password);
            }

            return "User updates finished.";
        };
}
