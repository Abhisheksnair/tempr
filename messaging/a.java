package com.whatsapp.messaging;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

abstract class a
  extends SSLSocketFactory
{
  private static final boolean a;
  private final SSLContext b;
  private final SSLSessionCache c;
  private SSLSocketFactory d;
  
  static
  {
    if (Build.VERSION.SDK_INT > 14) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  protected a()
  {
    Object localObject = a(a(a(null, "TLS"), "SSLv3"), "SSL");
    if (localObject == null)
    {
      localObject = new NoSuchAlgorithmException("No known algorithm available to provide SSL sockets");
      Log.e((Throwable)localObject);
      throw new RuntimeException((Throwable)localObject);
    }
    this.b = ((SSLContext)localObject);
    ((SSLContext)localObject).getClientSessionContext().setSessionTimeout(86400);
    ((SSLContext)localObject).getClientSessionContext().setSessionCacheSize(24);
    if (a)
    {
      this.c = a(u.a());
      return;
    }
    this.c = null;
  }
  
  private static SSLSessionCache a(Context paramContext)
  {
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext == null) {}
    while (!paramContext.exists()) {
      return null;
    }
    paramContext = new File(paramContext, "SSLSessionCache");
    try
    {
      paramContext = new SSLSessionCache(paramContext);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  private static SSLContext a(SSLContext paramSSLContext, String paramString)
  {
    SSLContext localSSLContext = paramSSLContext;
    if (paramSSLContext == null) {}
    try
    {
      localSSLContext = SSLContext.getInstance(paramString);
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Log.w(paramString + " algorithm not available for SSLContext: " + localNoSuchAlgorithmException);
    }
    return paramSSLContext;
  }
  
  private SSLSocketFactory a()
  {
    try
    {
      if (this.d == null) {
        this.d = a(this.b, this.c);
      }
      SSLSocketFactory localSSLSocketFactory = this.d;
      return localSSLSocketFactory;
    }
    finally {}
  }
  
  protected abstract SSLSocketFactory a(SSLContext paramSSLContext, SSLSessionCache paramSSLSessionCache);
  
  public Socket createSocket()
  {
    return a().createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    Socket localSocket = a().createSocket(paramString, paramInt);
    if ((localSocket instanceof SSLSocket)) {
      r.a().a(localSocket, paramString);
    }
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    paramInetAddress = a().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    if ((paramInetAddress instanceof SSLSocket)) {
      r.a().a(paramInetAddress, paramString);
    }
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    Socket localSocket = a().createSocket(paramInetAddress, paramInt);
    if ((localSocket instanceof SSLSocket)) {
      r.a().a(localSocket, paramInetAddress.getHostName());
    }
    return localSocket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    paramInetAddress2 = a().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    if ((paramInetAddress2 instanceof SSLSocket)) {
      r.a().a(paramInetAddress2, paramInetAddress1.getHostName());
    }
    return paramInetAddress2;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = a().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket)) {
      r.a().a(paramSocket, paramString);
    }
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return a().getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return a().getSupportedCipherSuites();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */