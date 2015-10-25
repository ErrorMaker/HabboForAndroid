package app.habbo.xyz;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;

import app.habbo.xyz.Messages.PacketHandler;
import app.habbo.xyz.Network.TCP;

public class Environment {
    private static TCP tcpClient;
    private static PacketHandler packetHandler;
    private static Context currentAppContext;

    private static Activity currentActivity;
    private static boolean isLoggedin = false;
    public static void setTcpClient(TCP tcp)
    {
        Environment.tcpClient = tcp;
    }
    public static TCP getTcpClient()
    {
        return Environment.tcpClient;
    }
    public static void setPacketHandler(PacketHandler pHandler)
    {
        Environment.packetHandler = pHandler;
    }
    public static PacketHandler getPacketHandler()
    {
        return Environment.packetHandler;
    }
    public static void setCurrentAppContext(Context context)
    {
        Environment.currentAppContext = context;
    }
    public static Context getCurrentAppContext()
    {
        return Environment.currentAppContext;
    }
    public static void setCurrentActivity(Activity a)
    {
        Environment.currentActivity = a;
    }
    public static Activity getCurrentActivity()
    {
        return Environment.currentActivity;
    }
    public static boolean getLoginState()
    {
        return isLoggedin;
    }
    public static void setLoginState(boolean arg)
    {
       isLoggedin = arg;
    }
}
