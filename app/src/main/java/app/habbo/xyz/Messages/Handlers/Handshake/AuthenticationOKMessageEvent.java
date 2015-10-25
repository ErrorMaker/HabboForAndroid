package app.habbo.xyz.Messages.Handlers.Handshake;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import app.habbo.xyz.Environment;
import app.habbo.xyz.Messages.ClientMessage;
import app.habbo.xyz.Messages.Headers.Outgoing;
import app.habbo.xyz.Messages.MessageInterface;
import app.habbo.xyz.Messages.ServerMessage;
import app.habbo.xyz.R;

public class AuthenticationOKMessageEvent implements MessageInterface{
    @Override
    public void Handle(ServerMessage msg) throws Exception {
        Log.i("AuthOK", "Logged In!");
        Environment.setLoginState(true);
        //TODO: Create new View with online friends and offline friends & My Profile, set a new onProgressUpdate!!!
        //Environment.getCurrentActivity().setContentView(R.layout.friends_layout);
        View view = Environment.getCurrentActivity().findViewById(R.id.email_login_form);
        ViewGroup parent = (ViewGroup) view.getParent();
        view.animate().y(Environment.getCurrentActivity().getWindowManager().getDefaultDisplay().getHeight()).setDuration(750);
        ImageView logo = (ImageView)Environment.getCurrentActivity().findViewById(R.id.logoview);
        logo.animate().y((Environment.getCurrentActivity().getWindowManager().getDefaultDisplay().getHeight() - logo.getHeight()) / 2).setDuration(1500);
        ProgressBar pb = new ProgressBar(Environment.getCurrentActivity(),null, android.R.attr.progressBarStyleInverse);
        pb.setIndeterminate(true);
        LinearLayout ll = (LinearLayout)Environment.getCurrentActivity().findViewById(R.id.linlay);
        ll.addView(pb);
        pb.setY(logo.getY());
        // Requests Messenger / User Properties.
        Environment.getTcpClient().sendMessage(new ClientMessage(Outgoing.GetUserInformations));
    }
}
