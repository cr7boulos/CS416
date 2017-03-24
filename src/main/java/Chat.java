
import org.apache.commons.collections.map.HashedMap;
import org.eclipse.jetty.websocket.api.*;
import org.json.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import static spark.Spark.*;

import static j2html.TagCreator.*;



/**
 * The code for this chat application is taken from this tutorial:
 * https://sparktutorials.github.io/2015/11/08/spark-websocket-chat.html
 * Modifications to it were made for the CS416 project.
 */
public class Chat {
    // this map is shared between sessions and threads, so it needs to be thread-safe (http://stackoverflow.com/a/2688817)
    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    //static ArrayList<Map<Session, String>> chatRooms = new ArrayList<ConcurrentHashMap>;
    //use the above code for implementing the chat rooms. Note: should the ArrayList also be thread-safe?
    // See https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html
    //CopyOnWriteArrayList
    static int nextUserNumber = 0; //Used for creating the next username
    static ArrayList<String> users = new ArrayList<>();

    public static void main(String[] args) {

        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)

        webSocket("/chat", ChatWebSocketHandler.class);
        port(1150);

        get("/login", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "/velocity/login.vm");
        });



        post("/index/", (request, response) -> {
            System.out.println("Calling my method");
            //use the .queryParams method for getting POST values
            //See here: https://github.com/perwendel/spark/issues/389
            String email = request.queryParams("email");


            System.out.println("User is : " + email);
            Chat.users.add(email);
            Map<String, Object> model = new HashMap<>(); //this model is not used at the moment

                    return ViewUtil.render(request, model, "/velocity/index.vm");
                });
        //init();
    }

    //Sends a message from one user to all users, along with a list of current usernames
    public static void broadcastMessage(String sender, String message) {
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(sender, message))
                        .put("userlist", userUsernameMap.values())

                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //Builds a HTML element with a sender-name, a message, and a timestamp,
    private static String createHtmlMessageFromSender(String sender, String message) {
        return article().with(
                b(sender + " says:"),
                p(message),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
}
