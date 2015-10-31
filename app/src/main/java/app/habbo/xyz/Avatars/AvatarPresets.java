package app.habbo.xyz.Avatars;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dario_2 on 31.10.2015.
 */
public class AvatarPresets {
    public HashMap<String, AvatarPreset> avatarPresetList;
    public AvatarPresets()
    {
        this.avatarPresetList = new HashMap<String,AvatarPreset>();
        this.avatarPresetList.put("PRESET_WELCOME", new AvatarPreset(Gender.Male,3,3,Gesture.Smile,Actions.Wave,AvatarSize.Large));

    }
    public AvatarPreset getAvatarPreset(String preset)
    {
        return this.avatarPresetList.get(preset);
    }
}
