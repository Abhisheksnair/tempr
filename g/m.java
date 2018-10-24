package com.whatsapp.g;

import a.a.a.a.a.a.d;
import org.whispersystems.a.c;

public final class m
{
  public final String a;
  public final c b;
  public final c c;
  
  public m(String paramString, c paramc1, c paramc2)
  {
    this.a = ((String)a.d.a(paramString));
    if (!paramString.endsWith("@s.whatsapp.net")) {
      throw new IllegalArgumentException("incorrect jid: " + paramString);
    }
    this.b = paramc1;
    this.c = paramc2;
  }
  
  public final String toString()
  {
    return "SignalProtocolIdentityEvent{jid='" + this.a + '\'' + ", oldIdentity=" + this.b + ", newIdentity=" + this.c + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */