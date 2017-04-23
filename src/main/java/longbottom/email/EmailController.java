package longbottom.email;
import longbottom.DAO.DAO;
import spark.Response;
import spark.Request;
import spark.Route;
/**
 * Created by Brian on 4/21/2017.
 */
public class EmailController {

    //this method is a Java 8 feature called a functional interface


//    public static Route sendEmail = (Request request, Response response) -> {
//
//    };

    public static Route deleteEmail = (Request request, Response response) -> {

        int emailId = Integer.parseInt(request.queryParams("emailId"));

        if(DAO.deleteEmail(emailId))
            return "Delete successful.";
        else
            return "Delete failed.";
    };

}
