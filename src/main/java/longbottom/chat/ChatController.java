package longbottom.chat;

import spark.*;
import java.util.*;
import longbottom.util.ViewUtil;


/**
 * Created by jacoford21 on 4/7/2017.
 */
public class ChatController implements DAO {

    public static Route chatHistory = (Request request, Response response) -> {

        //The request object will have a parameter containing a projectId.
        int projectId = Integer.parseInt(request.params("projectId"));

        //Next, the controller will then make the following DAO API call: getChatHistory(projectId)
        DAO.getChatMessages(projectId);

        //the resulting data of the API call will be stored in a model object and passed to the Velocity renderer along with the appropriate template.
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "/velocity/chatHistory.vm");
    };
}