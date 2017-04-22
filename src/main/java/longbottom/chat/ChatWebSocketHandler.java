package longbottom.chat;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebSocket
public class ChatWebSocketHandler {

    private String sender;
    private String message;

    // Integer represents the project ID of the project

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception{

        //if there are no more users in the chat room delete the chat room
        int projectId = Integer.parseInt(user.getUpgradeRequest().getParameterMap().get("projectId").get(0));
        String username = "User" + Chat.nextUserNumber++;


        Chat.broadcastMessage("Server", message = (username + " joined the chat."), projectId);
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason){
    }


    @OnWebSocketMessage
    public void onMessage(Session user, String message){

    }
}
