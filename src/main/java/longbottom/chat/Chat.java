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

    //     Map<projectId, Map<Session, User>>>
    static Map<Integer, Map<Session, String>> chatMap = new ConcurrentHashMap<>();

    public static void broadcastMessage(String sender, String message, int projectId) {

        // Find the chat room and send a message to all users in that chat rooom
        chatMap.get(projectId).keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(sender, message))
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
                span().withClass("timestamp").withText(new SimpleDateFormat("hh:mm a").format(new Date()))
        ).render();
    }
}