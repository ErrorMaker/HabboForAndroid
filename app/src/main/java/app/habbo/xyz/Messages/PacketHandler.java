package app.habbo.xyz.Messages;

import java.util.HashMap;

import app.habbo.xyz.Messages.Handlers.Handshake.*;
import app.habbo.xyz.Messages.Headers.Incoming;


public class PacketHandler {

    private HashMap<Integer, MessageInterface> handlers;
    public PacketHandler()
    {
        handlers = new HashMap<Integer,MessageInterface>();
        //Handshake
            handlers.put(Incoming.InvalidUsername, new InvalidUsernameMessageEvent());
            handlers.put(Incoming.InvalidPassword, new InvalidPasswordMessageEvent());
            handlers.put(Incoming.AuthenticationOK, new AuthenticationOKMessageEvent());
    }
    public MessageInterface GetHandlerById(int Id)
    {
        if(handlers.containsKey(Id))
            return handlers.get(Id);
        return null;
    }
}
