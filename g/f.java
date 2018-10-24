package com.whatsapp.g;

import android.net.NetworkInfo;
import b.a.a.c;

public final class f
{
  public final boolean a;
  public final boolean b;
  public final int c;
  public final long d;
  
  private f(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramInt;
    this.d = paramLong;
  }
  
  public static f a(NetworkInfo paramNetworkInfo)
  {
    long l = ((j)c.a().a(j.class)).a();
    if (paramNetworkInfo != null) {
      return new f(paramNetworkInfo.isConnected(), paramNetworkInfo.isRoaming(), paramNetworkInfo.getType(), l);
    }
    return new f(false, false, -1, l);
  }
  
  public final String toString()
  {
    return "Connectivity{connected=" + this.a + ", roaming=" + this.b + ", type=" + this.c + ", ntpEventTimeMillis=" + this.d + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */