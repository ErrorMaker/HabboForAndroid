package app.habbo.xyz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import app.habbo.xyz.Messages.PacketHandler;
import app.habbo.xyz.Avatars.AvatarSize;
import app.habbo.xyz.Network.TCP;

public class Environment {
    private static TCP tcpClient;
    private static PacketHandler packetHandler;
    private static Context currentAppContext;

    private static Activity currentActivity;
    private static boolean isLoggedin = false;

    public static void setTcpClient(TCP tcp) {
        Environment.tcpClient = tcp;
    }

    public static TCP getTcpClient() {
        return Environment.tcpClient;
    }

    public static void setPacketHandler(PacketHandler pHandler) {
        Environment.packetHandler = pHandler;
    }

    public static PacketHandler getPacketHandler() {
        return Environment.packetHandler;
    }

    public static void setCurrentAppContext(Context context) {
        Environment.currentAppContext = context;
    }

    public static Context getCurrentAppContext() {
        return Environment.currentAppContext;
    }

    public static void setCurrentActivity(Activity a) {
        Environment.currentActivity = a;
    }

    public static Activity getCurrentActivity() {
        return Environment.currentActivity;
    }

    public static boolean getLoginState() {
        return isLoggedin;
    }

    public static void setLoginState(boolean arg) {
        isLoggedin = arg;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 12;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    public static Bitmap downloadAvatar(String look, AvatarSize size)
    {
        String imageurl = "https://www.habbo.de/habbo-imaging/avatarimage?figure=" + look + "&direction=4&head_direction=4&gesture=sml&size=" + getAvatarSize(size);
        InputStream in = null;
        try {
            URL url = new URL(imageurl);
            URLConnection urlConn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.connect();
            in = httpConn.getInputStream();
        } catch (Exception ex){
            return getPlaceholderAvatar(); //Placeholder Avatar!!!!
        }
        Bitmap bmpimg = BitmapFactory.decodeStream(in);
        return bmpimg;
    }
    public static Bitmap getPlaceholderAvatar()
    {return null;
        //return BitmapFactory.decodeResource(Environment.getCurrentActivity().getResources(), R.drawable.);
    }
    public static String getAvatarSize(AvatarSize avatarSize)
    {
        switch(avatarSize)
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
}
