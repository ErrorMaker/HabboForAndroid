package app.habbo.xyz.Avatars;

public class AvatarPreset {
    public Gender gender = Gender.Male;
    public int HeadDirection = 0;
    public int BodyDirection = 0;
    public Gesture gesture = Gesture.None;
    public AvatarSize avatarSize = AvatarSize.Medium;
    public Actions Action = Actions.None;
    public AvatarPreset(Gender _gender,int _HeadDirection, int _BodyDirection, Gesture _gesture,Actions action, AvatarSize _avatarSize)
    {
        gender = _gender;
        HeadDirection = _HeadDirection;
        BodyDirection = _BodyDirection;
        gesture = _gesture;
        avatarSize = _avatarSize;
        Action = Actions.None;
    }
}
