package app.habbo.xyz.Messages.Handlers.Handshake;

import android.widget.TextView;

import app.habbo.xyz.Environment;
import app.habbo.xyz.Messages.MessageInterface;
import app.habbo.xyz.Messages.ServerMessage;
import app.habbo.xyz.R;

public class InvalidPasswordMessageEvent implements MessageInterface{
    @Override
    public void Handle(ServerMessage msg) throws Exception {
        TextView tv = (TextView) Environment.getCurrentActivity().findViewById(R.id.textView);
        int height = tv.getHeight();
        int paddingT = tv.getPaddingTop();
        int paddingB = tv.getPaddingBottom();
        tv.setBackgroundDrawable( Environment.getCurrentActivity().getResources().getDrawable(R.drawable.errorbox) );
        tv.setText(Environment.getCurrentActivity().getResources().getText(R.string.wrongpassword));//"Benutzername eingeben!");
        tv.setHeight(height);
        tv.setPadding(tv.getPaddingLeft(),paddingT,tv.getPaddingRight(),paddingB);
    }
}
