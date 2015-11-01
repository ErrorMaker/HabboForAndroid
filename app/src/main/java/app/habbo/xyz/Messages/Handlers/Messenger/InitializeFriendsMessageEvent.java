package app.habbo.xyz.Messages.Handlers.Messenger;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.habbo.xyz.Habbo.Habbo;
import app.habbo.xyz.Messages.MessageInterface;
import app.habbo.xyz.Messages.ServerMessage;

public class InitializeFriendsMessageEvent implements MessageInterface{
    @Override
    public void Handle(ServerMessage msg) throws Exception {
        int i = 0;
        try {
            while (i++ <= 4) {
                msg.ReadInteger();
            }
            i = msg.ReadInteger();
            while (i > 0) {
                i--;
                int id = msg.ReadInteger();
                String username = msg.ReadString();
                msg.ReadInteger();
                boolean online = msg.ReadBoolean();
                boolean inRoom = msg.ReadBoolean();
                String look = msg.ReadString();
                msg.ReadInteger();
                String motto = msg.ReadString();
                msg.ReadString();
                String lastonline = msg.ReadString();
                msg.ReadBoolean(); //maybe Pocket Habbo?
                int relationship = msg.ReadInteger();
                Habbo h = new Habbo(id, username, look, motto);
                h.setIsOnline(online);
                h.setLastOnline(lastonline);
                h.setRelationship(relationship);
            }
        }catch(Exception ex)
        {
            Log.e("InitFriends", ex.toString());
        }
    }
}
