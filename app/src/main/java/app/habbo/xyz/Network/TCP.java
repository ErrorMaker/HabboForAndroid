package app.habbo.xyz.Network;

import android.util.Log;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.CharBuffer;

import app.habbo.xyz.Messages.*;
public class TCP {

    private String serverMessage;
    public static final String SERVERIP = "direct.rootkit.ch";
    public static final int SERVERPORT = 1234;
    private OnMessageReceived mMessageListener = null;
    private boolean mRun = false;
    PrintWriter out;
    BufferedReader in;

    public TCP(OnMessageReceived listener) {
        mMessageListener = listener;
    }
    public void sendMessage(String message){
        if (out != null && !out.checkError()) {
            out.print("@" + message);
            out.flush();
        }
    }
    public void sendMessage(ClientMessage cm)
    {
        if(out != null && !out.checkError())
        {
            out.print(cm.toMessageString());
            out.flush();
        }
    }
    public void stopClient(){
        mRun = false;
    }
    public void run() {

        mRun = true;

        try {

            InetAddress serverAddr = InetAddress.getByName(SERVERIP);
            Log.e("TCP Client", "C: Connecting...");
            Socket socket = new Socket(serverAddr, SERVERPORT);
            Socket client;
            try {
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                InputStream instream = socket.getInputStream();
                while (true) {
                    serverMessage = "";
                    while(instream.available() > 0)
                    {
                        int x = instream.read();
                        serverMessage = serverMessage + String.valueOf(Character.toChars(x));
                    }
                    if(!serverMessage.equals("")) {
                        for (String message : serverMessage.split((char) 0 + "")) {
                            if (!message.equals("") && mMessageListener != null) {
                                mMessageListener.messageReceived(message);
                            }
                        }
                    }
                }



            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);

            } finally {
                socket.close();
            }

        } catch (Exception e) {

            Log.e("TCP", "C: Error", e);

        }

    }
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }
}