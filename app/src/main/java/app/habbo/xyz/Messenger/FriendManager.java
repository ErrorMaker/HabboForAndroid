package app.habbo.xyz.Messenger;

import java.util.ArrayList;
import java.util.List;

import app.habbo.xyz.Habbo.Habbo;

public class FriendManager {

    private List<Habbo> friends;
    private List<Habbo> friendrequests;
    public FriendManager(){
        friends = new ArrayList<Habbo>();
        friendrequests = new ArrayList<Habbo>();
    }
}
