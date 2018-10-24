package com.whatsapp.messaging;

import com.whatsapp.util.Log;

final class l
{
  boolean a;
  private final int b = 3;
  private final String c;
  
  public l(String paramString)
  {
    this(paramString, false);
  }
  
  public l(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    Log.a(3, paramString + " initialize to " + paramBoolean);
    this.a = paramBoolean;
  }
  
  public final void a(boolean paramBoolean)
  {
    Log.a(this.b, this.c + " " + this.a + " change to " + paramBoolean);
    this.a = paramBoolean;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */