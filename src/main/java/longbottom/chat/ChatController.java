package longbottom.chat;

import spark.*;
import java.util.*;
import longbottom.util.ViewUtil;
import longbottom.DAO.*;


/**
 * Created by jacoford21 on 4/7/2017.
 */
public class ChatController {

    public static Route chatHistory = (Request request, Response response) -> {

        //The request object will have a parameter containing a projectId.
        int projectId = Integer.parseInt(request.queryParams("projectId"));
        //System.out.println(projectId);

        //Next, the controller will then make the following DAO API call: getChatHistory(projectId)
        List<Map<String, Object>> chatMessages = DAO.getChatMessages(projectId);
        int userId = request.session().attribute("userId");

        //the resulting data of the API call will be stored in a model object and passed to the Velocity renderer along with the appropriate template.
        Map<String, Object> model = new HashMap<>();
        model.put("messages", chatMessages);
        model.put("projectId", projectId);
        model.put("userId", userId);
        //System.out.println(chatMessages.get(0).keySet());
        return ViewUtil.render(model, "/velocity/project.vm");

    };
}