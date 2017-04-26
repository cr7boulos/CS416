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
            System.out.println(userId);
            String firstname = request.queryParams("firstname");
            System.out.println(firstname);
            String lastname = request.queryParams("lastname");
            System.out.println(lastname);
            String email = request.queryParams("email");
            System.out.println(email);
            String password = request.queryParams("password");
            System.out.println(password);

            if (firstname != null && (!firstname.equals(""))) {
                DAO.updateUserFirstName(userId, firstname);
            }

            if (lastname != null && (!lastname.equals(""))) {
                DAO.updateUserLastName(userId, lastname);
            }

            if (email != null && (!email.equals(""))) {
                DAO.updateUserEmail(userId, email);
            }

            if (password != null && (!password.equals(""))) {
                DAO.updateUserPassword(userId, password);
            }

            return "User updates finished.";
        };

    public static Route createUser = (Request request, Response response) -> {
        LoginController.isAuthenticated(request, response);

       int typeOfUser = Integer.parseInt(request.queryParams("userType"));


       boolean creationUser =   DAO.createUser(request.queryParams("firstname"),
                            request.queryParams("lastname"),
                            request.queryParams("email"),
                            request.queryParams("password"));

       if(creationUser == true)
       {
           int userId = DAO.getUserIdByEmail(request.queryParams("email"));

           if(typeOfUser == 0)
           {
               DAO.createAdmin(userId);
           }
           else if(typeOfUser == 1)
           {
               DAO.createProfessor(userId);
           }
           else
           {
               DAO.createStudent(userId);
           }

       }
       else
       {
           return "User not created.";
       }



        return "User creation finished.";
    };
}
