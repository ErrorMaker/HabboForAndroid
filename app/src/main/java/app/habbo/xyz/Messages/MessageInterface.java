package app.habbo.xyz.Messages;

/**
 * Created by Dario_2 on 23.08.2015.
 */
public interface MessageInterface {
    public abstract void Handle(ServerMessage msg)throws Exception;
}
