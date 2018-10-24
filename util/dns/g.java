package com.whatsapp.util.dns;

import com.whatsapp.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

final class g
{
  private static final InetSocketAddress a;
  private static final InetSocketAddress b;
  
  static
  {
    try
    {
      a = new InetSocketAddress(InetAddress.getByAddress(new byte[] { 8, 8, 8, 8 }), 53);
      b = new InetSocketAddress(InetAddress.getByAddress(new byte[] { 8, 8, 4, 4 }), 53);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw new Error(localUnknownHostException);
    }
  }
  
  static a[] a(String paramString)
  {
    d locald = d.a(paramString);
    Object localObject1 = locald.a();
    Object localObject2 = new byte['Ȁ'];
    DatagramPacket localDatagramPacket = new DatagramPacket((byte[])localObject2, 512);
    try
    {
      DatagramSocket localDatagramSocket = new DatagramSocket();
      try
      {
        Log.i("querying " + a + " for " + paramString + " with 20000 ms timeout");
        localDatagramSocket.connect(a);
        localDatagramSocket.setSoTimeout(10000);
        localDatagramSocket.send(new DatagramPacket((byte[])localObject1, localObject1.length));
        localDatagramSocket.receive(localDatagramPacket);
        localObject1 = d.a((byte[])localObject2);
        if (((d)localObject1).a.a != locald.a.a) {
          throw new UnknownHostException("received response with unexpected id while trying to resolve " + paramString);
        }
      }
      catch (InterruptedIOException localInterruptedIOException2)
      {
        for (;;)
        {
          Log.i("timed out while querying " + a + " for " + paramString);
          localDatagramSocket.disconnect();
          try
          {
            Log.i("querying " + b + " for " + paramString + " with 20000 ms timeout");
            localDatagramSocket.connect(b);
            localDatagramSocket.setSoTimeout(10000);
            localDatagramSocket.send(new DatagramPacket((byte[])localObject1, localObject1.length));
            localDatagramSocket.receive(localDatagramPacket);
          }
          catch (InterruptedIOException localInterruptedIOException1)
          {
            Log.i("timed out while querying " + b + " for " + paramString);
            throw new UnknownHostException("timeout while trying to resolve " + paramString);
          }
        }
      }
      if (((d)localObject1).a.b) {
        break label429;
      }
    }
    catch (IOException localIOException)
    {
      Log.w("unexpected IOException " + localIOException + " while trying to resolve " + paramString);
      throw new UnknownHostException("ioexception while trying to resolve " + paramString);
    }
    throw new UnknownHostException("did not receive response from server while trying to resolve " + paramString);
    label429:
    if (((d)localObject1).a.e) {
      throw new UnknownHostException("received truncated response while trying to resolve " + paramString);
    }
    if (((d)localObject1).a.h != 0) {
      throw new UnknownHostException("error code was set in response while trying to resolve " + paramString);
    }
    if (((d)localObject1).b.length == 0) {
      throw new UnknownHostException("no answers received while trying to resolve " + paramString);
    }
    long l = System.currentTimeMillis();
    a[] arrayOfa = new a[((d)localObject1).b.length];
    int i = 0;
    while (i < ((d)localObject1).b.length)
    {
      localObject2 = localObject1.b[i];
      if (((a)localObject2).c != 1) {
        throw new UnknownHostException("unexpected class returned while trying to resolve " + paramString);
      }
      if (((a)localObject2).b != 1) {
        throw new UnknownHostException("unexpected type returned while trying to resolve " + paramString);
      }
      if ((short)((a)localObject2).e.length != 4) {
        throw new UnknownHostException("unexpected record length returned while trying to resolve " + paramString);
      }
      arrayOfa[i] = new a(InetAddress.getByAddress(((d)localObject1).a(((a)localObject2).a), ((a)localObject2).e), ((a)localObject2).d * 1000L + l);
      i += 1;
    }
    Log.i("resolved " + arrayOfa.length + " addresses using backup DNS for " + paramString);
    return arrayOfa;
  }
  
  static final class a
  {
    final InetAddress a;
    final long b;
    
    a(InetAddress paramInetAddress, long paramLong)
    {
      this.a = paramInetAddress;
      this.b = paramLong;
    }
    
    public final String toString()
    {
      return "InetAddressWithExpiry{address=" + this.a + ", expireTimeMillis=" + this.b + '}';
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/dns/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */