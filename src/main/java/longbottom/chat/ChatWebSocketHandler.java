package longbottom.chat;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import longbottom.DAO.*;


@WebSocket
public class ChatWebSocketHandler {

    private String sender;
    private String message;

    // Integer represents the project ID of the project

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception{

        //if there are no more users in the chat room delete the chat room
        int projectId = Integer.parseInt(user.getUpgradeRequest().getParameterMap().get("projectId").get(0));
        int userId = Integer.parseInt(user.getUpgradeRequest().getParameterMap().get("username").get(1));
        String username = DAO.getEmailByUserId(userId);

        //chat room already exists
        if (Chat.chatMap.containsKey(projectId)){
            Chat.chatMap.get(projectId).put(user, Integer.toString(projectId));
        }
        else{
            Chat.chatMap.put(projectId, new HashMap(){{put(user, Integer.toString(userId));}});
        }

        Chat.broadcastMessage(sender = "Server", message = (username + " has joined the chat."), projectId);
    }

    @OnWebSocketClose
    public void onClose(Session user){
        int projectId = Integer.parseInt(user.getUpgradeRequest().getParameterMap().get("projectId").get(0));
        int userId = Integer.parseInt(user.getUpgradeRequest().getParameterMap().get("username").get(1));
        String username = DAO.getEmailByUserId(userId);

        if(Chat.chatMap.containsKey(projectId)){
            Chat.chatMap.get(projectId).remove(user);
            //if the chat room is empty delete the chat room
            if (Chat.chatMap.get(projectId).isEmpty()){
                Chat.chatMap.remove(projectId);
            }
            else{
                Chat.broadcastMessage(sender = "Server", message = (username + " has left the chat."), projectId);
            }
        }
    }


    @OnWebSocketMessage
    public void onMessage(Session user, String message){

    }
}
