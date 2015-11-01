package app.habbo.xyz;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import app.habbo.xyz.Habbo.Habbo;
import app.habbo.xyz.Messages.PacketHandler;
import app.habbo.xyz.Network.TCP;
public class Environment {
    private static TCP tcpClient;
    private static PacketHandler packetHandler;
    private static Context currentAppContext;
    private static Activity currentActivity;
    private static boolean isLoggedin = false;
    private static Habbo thisUser;
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
    public static Habbo getUser()
    {
        return thisUser;
    }
    public static void setUser(Habbo habbo)
    {
        Environment.thisUser = habbo;
    }
    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getWidth());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }
}
