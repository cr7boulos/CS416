package longbottom.chat;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.Session;
import org.json.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import longbottom.DAO.*;
import spark.*;

import static j2html.TagCreator.*;
import static spark.Spark.*;
public class Chat {

    // Map<projectId, all users in the project chat room>
    static Map<Integer, Map<Session, String>> chatMap = new ConcurrentHashMap<>();
    static int nextUserNumber = 1;

    public static void broadcastMessage(String userId, String message, int projectId) {
        //add chat message to the database
        //DAO.createChatMessage(userId, message);

        // Find the chat room and send a message to all users in that chat room
        chatMap.get(projectId).keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(userId, message))
                        .put("userlist", chatMap.get(projectId).values())
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //Creates HTML card for the message
    private static String createHtmlMessageFromSender(String sender, String message) {
        return article().with(
                b(sender + " says:"),
                p(message),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
}