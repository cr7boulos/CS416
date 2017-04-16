package longbottom.accounts;

import spark.*;
import longbottom.DAO.*;

/**
 * Created by Jacob on 4/15/2017.
 */
public class deleteUserController {
    public static Route deleteUser = (Request request, Response response) -> {

        int userId = Integer.parseInt(request.queryParams("userId"));

        if (DAO.deleteUser(userId)) {
            return "1";
        } else {
            return "0";
        }
    };
}
