package com.whatsapp;

import com.whatsapp.util.Log;

final class apw
{
  private final int a;
  private final int b;
  private final int c;
  
  private apw(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public static apw a(String paramString)
  {
    try
    {
      Object localObject = paramString.split("\\.");
      localObject = new apw(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2]));
      return (apw)localObject;
    }
    catch (Exception localException)
    {
      Log.e("version/parse [" + paramString + "]");
    }
    return null;
  }
  
  public final int a(apw paramapw)
  {
    if (this.a < paramapw.a) {}
    do
    {
      do
      {
        return -1;
        if (this.a > paramapw.a) {
          return 1;
        }
      } while (this.b < paramapw.b);
      if (this.b > paramapw.b) {
        return 1;
      }
    } while (this.c < paramapw.c);
    if (this.c > paramapw.c) {
      return 1;
    }
    return 0;
  }
  
  public final String toString()
  {
    return this.a + "." + this.b + "." + this.c;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/apw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */