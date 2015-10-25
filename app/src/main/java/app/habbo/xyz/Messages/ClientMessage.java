package app.habbo.xyz.Messages;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import app.habbo.xyz.Utils.BitConverter;

public class ClientMessage
{
    private List<Byte> Message;
    private int MessageId;
    private String finalMessage = "";
    public ClientMessage()
    {

        this.Message = new ArrayList<Byte>();
        this.MessageId = 0;
    }

    public ClientMessage(int Header)
    {
        this.Message = new ArrayList<Byte>();
        this.MessageId = 0;
        this.Init(Header);
    }

    public void AppendBoolean(boolean b)
    {
        this.finalMessage = finalMessage + (char)1 + b;
    }
    public void AppendInt32(int i)
    {
        this.finalMessage = finalMessage + (char)1 + i;
    }
    public void AppendShort(int i)
    {
        short num = (short)i;
        this.finalMessage = finalMessage + (char)1 + i;
    }

    public void AppendString(String s)
    {
        this.finalMessage = finalMessage + (char)1 + s.replace((char)1 +"","");
    }

    public void AppendString(String s, byte BreakChar)
    {
        this.AppendString(s);
    }
    public void AppendStringWithBreak(String s)
    {
        this.AppendString(s);
    }
    public void AppendStringWithBreak(String s, byte BreakChar)
    {
        this.AppendString(s, BreakChar);
    }
    public void AppendRawInt32(int i)
    {
        AppendString(i + "");
    }
    public Byte[] GetBytes()
    {
        return null;
    }
    public void Init(int Header)
    {
        try {
            this.Message = new ArrayList<Byte>();
            this.MessageId = (int) Header;
            this.finalMessage = "mobile"+ (char)1 + Header;
        }catch(Exception ex)
        {
            Log.e("EXCEPTION", ex.toString());
        }
    }
    public int getId()
    {
        return this.MessageId;
    }
    public String toMessageString()
    {
        return finalMessage;
    }
}

