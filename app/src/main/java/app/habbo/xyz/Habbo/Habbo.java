package app.habbo.xyz.Habbo;

import java.util.HashMap;
import app.habbo.xyz.Environment;

public class Habbo {
    private int Id;
    private String Username;
    private String Look;
    private String Motto;
    private boolean isOnline = false;
    int relationship = 1;
    private String lastOnline ="01.01.1970";
    public Habbo(int id, String username, String look, String motto)
    {
        this.Id = id;
        this.Username = username;
        this.Look = look;
        this.Motto = motto;
    }
    public void setId(int id)
    {
        this.Id = id;
    }
    public int getId()
    {
        return this.Id;
    }
    public void setUsername(String username)
    {
        this.Username = username;
    }
    public String getUsername()
    {
        return this.Username;
    }
    public void setLook(String look)
    {
        this.Look = look;
    }
    public String getLook()
    {
        return this.Look;
    }
    public void setMotto(String m)
    {
        this.Motto = m;
    }
    public String getMotto()
    {
        return this.Motto;
    }
    public void setIsOnline(boolean isonline){
        this.isOnline = isonline;
    }
    public boolean getIsOnline(){
        return this.isOnline;
    }
    public void setRelationship(int i) {
        this.relationship = i;
    }
    public int getRelationship()
    {
        return this.relationship;
    }
    public void setLastOnline(String s){
        this.lastOnline = s;
    }
    public String getLastOnline(){
        return this.lastOnline;
    }

}
