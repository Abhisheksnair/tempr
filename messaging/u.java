package com.whatsapp.messaging;

import android.os.Message;
import com.whatsapp.av;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.b;
import com.whatsapp.protocol.c;
import com.whatsapp.util.Log;
import java.io.IOException;

final class u
  extends Thread
{
  private final a a;
  private final b b;
  
  public u(a parama, b paramb)
  {
    super("ReaderThread");
    this.a = parama;
    this.b = paramb;
  }
  
  public final void run()
  {
    try
    {
      boolean bool;
      do
      {
        bool = this.b.d();
      } while (bool);
      return;
    }
    catch (IOException localIOException)
    {
      Log.b("xmpp/reader/io-error", localIOException);
      return;
    }
    catch (c localc)
    {
      Log.i("xmpp/reader/corrupt-stream-error/stanza " + localc.a);
      Log.b("xmpp/reader/corrupt-stream-error", localc);
      if (av.d()) {
        throw new RuntimeException(localc);
      }
    }
    finally
    {
      Log.i("xmpp/reader/error");
      this.a.b();
    }
    Log.i("xmpp/reader/error");
    this.a.b();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(long paramLong);
    
    public abstract void a(Message paramMessage);
    
    public abstract void a(al paramal);
    
    public abstract void a(String paramString);
    
    public abstract void b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */