package com.whatsapp.g;

import java.util.Arrays;
import java.util.Locale;

public final class h
{
  public final Locale[] a;
  public final String b;
  
  public h(Locale paramLocale, String paramString)
  {
    this(new Locale[] { paramLocale }, paramString);
  }
  
  public h(Locale[] paramArrayOfLocale, String paramString)
  {
    this.a = paramArrayOfLocale;
    this.b = paramString;
  }
  
  public final String toString()
  {
    return "HsmMessagePackEvent{locales=" + Arrays.toString(this.a) + ", namespace='" + this.b + '\'' + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */