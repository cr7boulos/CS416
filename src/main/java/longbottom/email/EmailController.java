package longbottom.email;
import longbottom.DAO.DAO;
import longbottom.accounts.User;
import spark.Response;
import spark.Request;
import spark.Route;
/**
 * Created by Brian on 4/21/2017.
 */
public class EmailController {

  public static Route sendEmail = (Request request, Response response) -> {
      int from = Integer.parseInt(request.queryParams("userId"));
      int sendTo =  DAO.getUserIdByEmail(request.queryParams("email"));
      String subject = request.queryParams("subject");
      String body = request.queryParams("body");

      if(DAO.sendEmail(from, sendTo, subject, body))
          return "Message Sent";
      else
          return "Send Failure. Retry";


  };

    public static Route deleteEmail = (Request request, Response response) -> {

        int emailId = Integer.parseInt(request.queryParams("emailId"));

        if(DAO.deleteEmail(emailId))
            return "Delete successful.";
        else
            return "Delete failed.";
    };

}
