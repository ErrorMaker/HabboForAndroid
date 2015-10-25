package app.habbo.xyz.Messages.Handlers.Handshake;

import android.widget.TextView;

import app.habbo.xyz.Environment;
import app.habbo.xyz.Messages.MessageInterface;
import app.habbo.xyz.Messages.ServerMessage;
import app.habbo.xyz.R;

/**
 * Created by Dario_2 on 23.08.2015.
 */
public class InvalidUsernameMessageEvent implements MessageInterface{

    @Override
    public void Handle(ServerMessage msg) throws Exception {
        TextView tv = (TextView) Environment.getCurrentActivity().findViewById(R.id.textView);
        int height = tv.getHeight();
        int paddingT = tv.getPaddingTop();
        int paddingB = tv.getPaddingBottom();
        tv.setBackgroundDrawable( Environment.getCurrentActivity().getResources().getDrawable(R.drawable.errorbox) );
        tv.setText(Environment.getCurrentActivity().getResources().getText(R.string.wrongusername));//"Benutzername eingeben!");
        tv.setHeight(height);
        tv.setPadding(tv.getPaddingLeft(),paddingT,tv.getPaddingRight(),paddingB);
    }
}
