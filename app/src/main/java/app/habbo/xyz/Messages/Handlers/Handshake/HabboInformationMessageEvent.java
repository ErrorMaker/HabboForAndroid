package app.habbo.xyz.Messages.Handlers.Handshake;

import android.util.Log;

import app.habbo.xyz.Environment;
import app.habbo.xyz.Habbo.Habbo;
import app.habbo.xyz.Messages.MessageInterface;
import app.habbo.xyz.Messages.ServerMessage;

public class HabboInformationMessageEvent implements MessageInterface {
    @Override
    public void Handle(ServerMessage msg) throws Exception {
        try{
        int Id = msg.ReadInteger();
        String Username = msg.ReadString();
        String Look = msg.ReadString();
        String gender = msg.ReadString();
        String Motto = msg.ReadString();
        String RealName = msg.ReadString();
        msg.ReadBoolean();
        int Respect = msg.ReadInteger();
        int RespectPoints = msg.ReadInteger();
        int PetRespectPoints = msg.ReadInteger();
        msg.ReadBoolean();
        String last_online = msg.ReadString();
        boolean canflagme = msg.ReadBoolean();
        msg.ReadBoolean();
        Habbo h = new Habbo(Id,Username,Look,Motto);
        Environment.setUser(h);
        }catch(Exception ex) {
        Log.e("EXEPTION", ex.toString());
        }
    }
}
