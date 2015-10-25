package app.habbo.xyz;

import android.support.v7.app.ActionBarActivity;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import app.habbo.xyz.Messages.Headers.Outgoing;
import app.habbo.xyz.Network.*;
import android.util.Log;
import app.habbo.xyz.Messages.*;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Environment.setPacketHandler(new PacketHandler());
        Environment.setCurrentAppContext(getApplicationContext());
        Environment.setCurrentActivity(this);
        setContentView(R.layout.activity_main);
        try {
            new connectTask().execute("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void onClickRegister(View v) {
        Toast.makeText(getApplicationContext(), "Register ist zurzeit nicht verfügbar. Bitte registrier dich auf unserer Homepage: " + getString(R.string.hplink), Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                if(!Environment.getLoginState()) {
                    onClickLogin(null);
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
    public void onClickLogin(View v){

        try {
            AutoCompleteTextView  emailtv = (AutoCompleteTextView)findViewById(R.id.email);
            AutoCompleteTextView passwordtv = (AutoCompleteTextView)findViewById(R.id.password);
            String username = emailtv.getText().toString();
            String password = passwordtv.getText().toString();
            TextView tv = (TextView)findViewById(R.id.textView);
            boolean alreadyfalse = false;
            if(username.length() <= 0)
            {
                int height = tv.getHeight();
                int paddingT = tv.getPaddingTop();
                int paddingB = tv.getPaddingBottom();
                tv.setBackgroundDrawable( getResources().getDrawable(R.drawable.errorbox) );
                tv.setText(getResources().getText(R.string.plsusername));//"Benutzername eingeben!");
                tv.setHeight(height);
                tv.setPadding(tv.getPaddingLeft(),paddingT,tv.getPaddingRight(),paddingB);
                alreadyfalse = true;
            }
            if(password.length() <= 0 && !alreadyfalse)
            {
                int height = tv.getHeight();
                int paddingT = tv.getPaddingTop();
                int paddingB = tv.getPaddingBottom();
                tv.setBackgroundDrawable( getResources().getDrawable(R.drawable.errorbox) );
                tv.setText(getResources().getText(R.string.plspassword));
                tv.setHeight(height);
                tv.setPadding(tv.getPaddingLeft(),paddingT,tv.getPaddingRight(),paddingB);
                alreadyfalse = true;
            }
            if(!alreadyfalse)
            {
                ClientMessage cm = new ClientMessage(Outgoing.LoginWithCredentials);
                cm.AppendString(username);
                cm.AppendString(password);
                Environment.getTcpClient().sendMessage(cm);
            }
        } catch (Exception ex) {

            Log.e("Login:", ex.toString());
        }
    }

    public class connectTask extends AsyncTask<String, String, TCP> {

        @Override
        protected TCP doInBackground(String... message) {

            TCP tcp = new TCP(new TCP.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    
                    publishProgress(message);
                }
            });
            Environment.setTcpClient(tcp);
            Environment.getTcpClient().run();
            return null;

        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            String msg = values[0];

            try{
                if(msg.startsWith("mobileMessage"+ (char)5)) {
                    msg = msg.replace("mobileMessage"+ (char)5,"");
                    int Id = Integer.parseInt(msg.split((char) 1 + "")[0]);
                    Log.i("onProgressUpdate", "New Incoming Message: " + Id);
                    ServerMessage message = new ServerMessage(Id, msg.split((char) 1 + ""));
                    MessageInterface messageInterface = Environment.getPacketHandler().GetHandlerById(Id);
                    if (messageInterface != null)
                    {
                        messageInterface.Handle(message);
                    }
                }
            }catch(Exception ex){
                if(ex instanceof NumberFormatException){return;}
                Log.e("onProgressUpdate", ex.toString());
                Toast.makeText(getApplicationContext(),"Es ist ein Fehler aufgetreten!", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
