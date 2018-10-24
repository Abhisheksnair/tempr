package com.whatsapp.messaging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public final class r
{
  private static r a;
  private Class<?> b;
  private Method c;
  private Method d;
  private boolean e;
  
  public r()
  {
    try
    {
      this.b = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        try
        {
          this.c = this.b.getMethod("setUseSessionTickets", new Class[] { Boolean.TYPE });
          this.d = this.b.getMethod("setHostname", new Class[] { String.class });
          this.e = true;
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          return;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        this.b = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static r a()
  {
    try
    {
      if (a == null) {
        a = new r();
      }
      r localr = a;
      return localr;
    }
    finally {}
  }
  
  public final void a(Socket paramSocket, String paramString)
  {
    if ((this.e) && (this.b.isInstance(paramSocket))) {}
    try
    {
      this.c.invoke(paramSocket, new Object[] { Boolean.valueOf(true) });
      this.d.invoke(paramSocket, new Object[] { paramString });
      return;
    }
    catch (InvocationTargetException paramSocket)
    {
      throw new RuntimeException(paramSocket);
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new AssertionError(paramSocket);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */