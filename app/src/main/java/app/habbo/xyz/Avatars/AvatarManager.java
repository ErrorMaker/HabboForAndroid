package app.habbo.xyz.Avatars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dario_2 on 31.10.2015.
 */
public class AvatarManager {

    public List<Avatar> Avatars;
    public AvatarPresets avatarPresets;
    public HashMap<String, Avatar> avatarByPresets;
    public AvatarManager()
    {
        Avatars = new ArrayList<Avatar>();
        avatarPresets = new AvatarPresets();
        avatarByPresets = new HashMap<String, Avatar>();
    }
    public boolean HasAvatar(Avatar a)
    {
        for(Avatar avt : Avatars)
        {
            if(avt.Style.equals(a.Style))
                return true;
        }
        return false;
    }
    public Avatar getAvatarByStyle(String Style)
    {
        for(Avatar a : Avatars)
        {
            if(a.Style.equals(Style))
                return a;
        }
        return null;
    }
    public void addAvatar(Avatar a)
    {
        this.Avatars.add(a);
    }
    public Avatar createAvatarByPreset(String preset, String look)
    {
        AvatarPreset avatarPreset = avatarPresets.getAvatarPreset(preset);
        Avatar a =new Avatar(look,avatarPreset.gender, avatarPreset.HeadDirection, avatarPreset.BodyDirection, avatarPreset.gesture, avatarPreset.Action, avatarPreset.avatarSize);
        if(!avatarByPresets.containsKey(preset + "-" + look))
            avatarByPresets.put(preset + "-" + look,a);
        return a;
    }
}
