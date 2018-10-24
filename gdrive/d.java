package com.whatsapp.gdrive;

import android.text.TextUtils;
import com.whatsapp.Statistics.a;
import com.whatsapp.Statistics.b;
import com.whatsapp.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class d
  extends SSLSocketFactory
{
  private final int a = 3;
  private final SSLSocketFactory b;
  private final ch.a<String, String> c;
  
  public d(SSLSocketFactory paramSSLSocketFactory, ch.a<String, String> parama)
  {
    this.b = paramSSLSocketFactory;
    this.c = parama;
  }
  
  public final Socket createSocket(String paramString, int paramInt)
  {
    if (this.c != null) {
      paramString = (String)this.c.a(paramString);
    }
    for (;;)
    {
      return new a((SSLSocket)this.b.createSocket(paramString, paramInt), this.a);
    }
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    if (this.c != null) {
      paramString = (String)this.c.a(paramString);
    }
    for (;;)
    {
      return new a((SSLSocket)this.b.createSocket(paramString, paramInt1, paramInetAddress, paramInt2), this.a);
    }
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return new a((SSLSocket)this.b.createSocket(paramInetAddress, paramInt), this.a);
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return new a((SSLSocket)this.b.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2), this.a);
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.c != null) {
      paramString = (String)this.c.a(paramString);
    }
    for (;;)
    {
      return new a((SSLSocket)this.b.createSocket(paramSocket, paramString, paramInt, paramBoolean), this.a);
    }
  }
  
  public final String[] getDefaultCipherSuites()
  {
    return this.b.getDefaultCipherSuites();
  }
  
  public final String[] getSupportedCipherSuites()
  {
    return this.b.getSupportedCipherSuites();
  }
  
  static final class a
    extends SSLSocket
  {
    private final int a;
    private final SSLSocket b;
    
    public a(SSLSocket paramSSLSocket, int paramInt)
    {
      this.a = paramInt;
      this.b = paramSSLSocket;
    }
    
    public final void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.b.addHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public final void bind(SocketAddress paramSocketAddress)
    {
      this.b.bind(paramSocketAddress);
    }
    
    public final void close()
    {
      try
      {
        this.b.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void connect(SocketAddress paramSocketAddress)
    {
      this.b.connect(paramSocketAddress);
    }
    
    public final void connect(SocketAddress paramSocketAddress, int paramInt)
    {
      this.b.connect(paramSocketAddress, paramInt);
    }
    
    public final SocketChannel getChannel()
    {
      return this.b.getChannel();
    }
    
    public final boolean getEnableSessionCreation()
    {
      return this.b.getEnableSessionCreation();
    }
    
    public final String[] getEnabledCipherSuites()
    {
      return this.b.getEnabledCipherSuites();
    }
    
    public final String[] getEnabledProtocols()
    {
      return this.b.getEnabledProtocols();
    }
    
    public final InetAddress getInetAddress()
    {
      return this.b.getInetAddress();
    }
    
    public final InputStream getInputStream()
    {
      return new Statistics.a(this.b.getInputStream(), this.a);
    }
    
    public final boolean getKeepAlive()
    {
      return this.b.getKeepAlive();
    }
    
    public final InetAddress getLocalAddress()
    {
      return this.b.getLocalAddress();
    }
    
    public final int getLocalPort()
    {
      return this.b.getLocalPort();
    }
    
    public final SocketAddress getLocalSocketAddress()
    {
      return this.b.getLocalSocketAddress();
    }
    
    public final boolean getNeedClientAuth()
    {
      return this.b.getNeedClientAuth();
    }
    
    public final boolean getOOBInline()
    {
      return this.b.getOOBInline();
    }
    
    public final OutputStream getOutputStream()
    {
      return new Statistics.b(this.b.getOutputStream(), this.a);
    }
    
    public final int getPort()
    {
      return this.b.getPort();
    }
    
    public final int getReceiveBufferSize()
    {
      try
      {
        int i = this.b.getReceiveBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final SocketAddress getRemoteSocketAddress()
    {
      return this.b.getRemoteSocketAddress();
    }
    
    public final boolean getReuseAddress()
    {
      return this.b.getReuseAddress();
    }
    
    public final SSLParameters getSSLParameters()
    {
      return this.b.getSSLParameters();
    }
    
    public final int getSendBufferSize()
    {
      try
      {
        int i = this.b.getSendBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final SSLSession getSession()
    {
      return this.b.getSession();
    }
    
    public final int getSoLinger()
    {
      return this.b.getSoLinger();
    }
    
    public final int getSoTimeout()
    {
      try
      {
        int i = this.b.getSoTimeout();
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final String[] getSupportedCipherSuites()
    {
      return this.b.getSupportedCipherSuites();
    }
    
    public final String[] getSupportedProtocols()
    {
      return this.b.getSupportedProtocols();
    }
    
    public final boolean getTcpNoDelay()
    {
      return this.b.getTcpNoDelay();
    }
    
    public final int getTrafficClass()
    {
      return this.b.getTrafficClass();
    }
    
    public final boolean getUseClientMode()
    {
      return this.b.getUseClientMode();
    }
    
    public final boolean getWantClientAuth()
    {
      return this.b.getWantClientAuth();
    }
    
    public final boolean isBound()
    {
      return this.b.isBound();
    }
    
    public final boolean isClosed()
    {
      return this.b.isClosed();
    }
    
    public final boolean isConnected()
    {
      return this.b.isConnected();
    }
    
    public final boolean isInputShutdown()
    {
      return this.b.isInputShutdown();
    }
    
    public final boolean isOutputShutdown()
    {
      return this.b.isOutputShutdown();
    }
    
    public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.b.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public final void sendUrgentData(int paramInt)
    {
      this.b.sendUrgentData(paramInt);
    }
    
    public final void setEnableSessionCreation(boolean paramBoolean)
    {
      this.b.setEnableSessionCreation(paramBoolean);
    }
    
    public final void setEnabledCipherSuites(String[] paramArrayOfString)
    {
      this.b.setEnabledCipherSuites(paramArrayOfString);
    }
    
    public final void setEnabledProtocols(String[] paramArrayOfString)
    {
      int i = 0;
      SSLSocket localSSLSocket = this.b;
      if ((paramArrayOfString.length <= 0) || ((paramArrayOfString.length == 1) && (!"SSLv3".equals(paramArrayOfString[0])))) {
        Log.i("gdrive/accounting-socket/set-enabled-protocols/current-list: " + TextUtils.join(", ", paramArrayOfString));
      }
      for (;;)
      {
        localSSLSocket.setEnabledProtocols(paramArrayOfString);
        return;
        if (paramArrayOfString.length == 1) {}
        ArrayList localArrayList;
        for (String[] arrayOfString = getSupportedProtocols();; arrayOfString = paramArrayOfString)
        {
          localArrayList = new ArrayList();
          int j = arrayOfString.length;
          while (i < j)
          {
            String str = arrayOfString[i];
            if (!"SSLv3".equals(str)) {
              localArrayList.add(str);
            }
            i += 1;
          }
        }
        if ((paramArrayOfString.length != localArrayList.size()) || (paramArrayOfString.length == 1))
        {
          Log.i("gdrive/accounting-socket/set-enabled-protocols/current-list: " + TextUtils.join(", ", paramArrayOfString));
          Log.i("gdrive/accounting-socket/set-enabled-protocols/modified-list: " + TextUtils.join(", ", localArrayList));
        }
        if (!localArrayList.isEmpty()) {
          paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
        }
      }
    }
    
    public final void setKeepAlive(boolean paramBoolean)
    {
      this.b.setKeepAlive(paramBoolean);
    }
    
    public final void setNeedClientAuth(boolean paramBoolean)
    {
      this.b.setNeedClientAuth(paramBoolean);
    }
    
    public final void setOOBInline(boolean paramBoolean)
    {
      this.b.setOOBInline(paramBoolean);
    }
    
    public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
    {
      this.b.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    }
    
    public final void setReceiveBufferSize(int paramInt)
    {
      try
      {
        this.b.setReceiveBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void setReuseAddress(boolean paramBoolean)
    {
      this.b.setReuseAddress(paramBoolean);
    }
    
    public final void setSSLParameters(SSLParameters paramSSLParameters)
    {
      this.b.setSSLParameters(paramSSLParameters);
    }
    
    public final void setSendBufferSize(int paramInt)
    {
      try
      {
        this.b.setSendBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void setSoLinger(boolean paramBoolean, int paramInt)
    {
      this.b.setSoLinger(paramBoolean, paramInt);
    }
    
    public final void setSoTimeout(int paramInt)
    {
      try
      {
        this.b.setSoTimeout(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void setTcpNoDelay(boolean paramBoolean)
    {
      this.b.setTcpNoDelay(paramBoolean);
    }
    
    public final void setTrafficClass(int paramInt)
    {
      this.b.setTrafficClass(paramInt);
    }
    
    public final void setUseClientMode(boolean paramBoolean)
    {
      this.b.setUseClientMode(paramBoolean);
    }
    
    public final void setWantClientAuth(boolean paramBoolean)
    {
      this.b.setWantClientAuth(paramBoolean);
    }
    
    public final void shutdownInput()
    {
      this.b.shutdownInput();
    }
    
    public final void shutdownOutput()
    {
      this.b.shutdownOutput();
    }
    
    public final void startHandshake()
    {
      try
      {
        this.b.startHandshake();
        return;
      }
      catch (SSLHandshakeException localSSLHandshakeException)
      {
        Log.e("gdrive/accounting-socket-factory/enabled suites " + Arrays.toString(getEnabledCipherSuites()) + " supported suites " + Arrays.toString(getSupportedCipherSuites()));
        throw localSSLHandshakeException;
      }
      catch (SSLProtocolException localSSLProtocolException)
      {
        for (;;) {}
      }
    }
    
    public final String toString()
    {
      return this.b.toString();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */