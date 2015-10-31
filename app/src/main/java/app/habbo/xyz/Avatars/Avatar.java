package app.habbo.xyz.Avatars;

import android.graphics.Bitmap;

/**
 * Created by Dario_2 on 31.10.2015.
 */
public class Avatar {
    public String Style ="";
    public Gender gender = Gender.Male;
    public int HeadDirection = 0;
    public int BodyDirection = 0;
    public Gesture gesture = Gesture.None;
    public AvatarSize avatarSize = AvatarSize.Medium;
    public Avatar(String _style, Gender _gender,int _HeadDirection, int _BodyDirection, Gesture _gesture, AvatarSize _avatarSize)
    {
        Style = _style;
        gender = _gender;
        HeadDirection = _HeadDirection;
        BodyDirection = _BodyDirection;
        gesture = _gesture;
        avatarSize = _avatarSize;
    }
    public Bitmap BuildBitmap()
    {
        return null;
    }
}
