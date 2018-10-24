package com.whatsapp;

import android.support.annotation.Keep;
import java.io.Serializable;

@Keep
public class Me
  implements Serializable
{
  private static final long serialVersionUID = -1952119322404952662L;
  public final String cc;
  public String jabber_id;
  public final String number;
  
  public Me(String paramString1, String paramString2)
  {
    this.cc = paramString1;
    this.number = paramString2;
    this.jabber_id = null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */