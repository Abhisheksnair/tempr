package com.whatsapp.protocol;

import java.io.Serializable;

public final class ap
  implements Serializable
{
  public static int h = -1;
  public static float i = -1.0F;
  public static int j = -1;
  public String a;
  public double b;
  public double c;
  public int d = h;
  public float e = i;
  public int f = j;
  public long g;
  
  public final boolean a()
  {
    return this.g > 0L;
  }
  
  public final String toString()
  {
    return "[UserLocation jid=" + this.a + " latitude=" + this.b + " longitude=" + this.c + " accuracy=" + this.d + " speed=" + this.e + " bearing=" + this.f + " timestamp=" + this.g + "]";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */