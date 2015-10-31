package app.habbo.xyz.Avatars;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import app.habbo.xyz.Environment;
import app.habbo.xyz.R;

public class Avatar {
    public String Style ="";
    public Gender gender = Gender.Male;
    public int HeadDirection = 0;
    public int BodyDirection = 0;
    public Gesture gesture = Gesture.None;
    public AvatarSize avatarSize = AvatarSize.Medium;
    public Bitmap AvatarImage = getPlaceholderAvatar();
    public Bitmap HeadImage = getPlaceholderAvatar();
    public Actions Action = Actions.None;
    public Avatar(String _style, Gender _gender,int _HeadDirection, int _BodyDirection, Gesture _gesture,Actions action, AvatarSize _avatarSize)
    {
        Style = _style;
        gender = _gender;
        HeadDirection = _HeadDirection;
        BodyDirection = _BodyDirection;
        gesture = _gesture;
        avatarSize = _avatarSize;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            new DownloadImageTask(AvatarImage).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://www.habbo.de/habbo-imaging/avatarimage?figure=" + Style + "&direction=" + BodyDirection +"&head_direction=" + HeadDirection + "&gesture=" + getGesture() + "&action=" + getAction() + "&size=" + getAvatarSize());
            new DownloadImageTask(HeadImage).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://www.habbo.de/habbo-imaging/avatarimage?figure=" + Style + "&direction=" + BodyDirection +"&head_direction=" + HeadDirection + "&gesture=" + getGesture() + "&action=" + getAction() + "&size=" + getAvatarSize() + "&headonly=1");

        }else{
            new DownloadImageTask(AvatarImage).execute("https://www.habbo.de/habbo-imaging/avatarimage?figure=" + Style + "&direction=" + BodyDirection +"&head_direction=" + HeadDirection + "&gesture=" + getGesture() + "&action=" + getAction() + "&size=" + getAvatarSize());
            new DownloadImageTask(HeadImage).execute("https://www.habbo.de/habbo-imaging/avatarimage?figure=" + Style + "&direction=" + BodyDirection +"&head_direction=" + HeadDirection + "&gesture=" + getGesture() + "&action=" + getAction() + "&size=" + getAvatarSize() + "&headonly=1");
        }
    }
    public Bitmap getPlaceholderAvatar()
    {
        return BitmapFactory.decodeResource(Environment.getCurrentActivity().getResources(), R.drawable.ph_avatar);
    }
    public String getGesture()
    {
        switch(this.gesture)
        {
            case Smile:
                return "sml";
            case Sad:
                return "sad";
            case Speak:
                return "spk";
            case EyesClosed:
                return "eyb";
            case Angry:
                return "agr";
            case Surprised:
                return "srp";
            case None:
                return "std";
        }
        return "std";
    }
    public String getAction()
    {
        switch(this.Action)
        {
            case Sit:
                return "sit";
            case Wave:
                return "wav";
            case Lay:
                return "lay";
            case Walk:
                return "wlk";
            case Drink:
                return "drk=1";
        }
        return "std";
    }
    public String getAvatarSize()
    {
        switch(this.avatarSize)
        {
            case Large:
                return "l";
            case Medium:
                return "m";
            case Small:
                return "s";
        }
        return "s";
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap;

        public DownloadImageTask(Bitmap _bitmap) {
            this.bitmap = _bitmap;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bitmap = result;
        }
    }
}