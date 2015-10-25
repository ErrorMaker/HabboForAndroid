package app.habbo.xyz.Messages;

public class ServerMessage {

    public int Id;
    public String[] Content;
    private int Pointer = 0;
    public ServerMessage(int id, String[] content)
    {
        Id = id;
        Content = content;
    }
    public String ReadString()
    {
        return Content[Pointer++];
    }
    public Integer ReadInteger()
    {
        return Integer.parseInt(Content[Pointer++]);
    }
    public boolean ReadBoolean()
    {
        return Content[Pointer++] == "true";
    }
}
