package com.whatsapp.messaging;

import com.whatsapp.protocol.i;
import com.whatsapp.protocol.x;

public final class bs
{
  public final String a;
  public final byte[] b;
  public final Runnable c;
  public final x d;
  public final i e;
  
  public bs(String paramString, byte[] paramArrayOfByte, Runnable paramRunnable)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramRunnable;
    this.d = null;
    this.e = null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SendFieldStats{fieldStatsBlob=");
    if (this.b != null) {}
    for (int i = this.b.length;; i = 0) {
      return i + " bytes, successCallback=" + this.c + ", errorCallback=" + this.d + ", readErrorCallback=" + this.e + '}';
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */