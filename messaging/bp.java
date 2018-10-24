package com.whatsapp.messaging;

import com.whatsapp.protocol.aq;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.as;
import com.whatsapp.protocol.at;
import com.whatsapp.protocol.au;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j.b;

public final class bp
{
  public String a;
  public String b;
  public j.b c;
  public String d;
  public int e;
  public av f;
  public aq g;
  public as h;
  public at i;
  public au j;
  public ar k;
  public String l;
  public int m;
  
  private bp(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public bp(String paramString1, String paramString2, int paramInt, av paramav)
  {
    this(paramString1, paramString2);
    this.e = paramInt;
    this.f = paramav;
  }
  
  public bp(String paramString1, String paramString2, aq paramaq)
  {
    this(paramString1, paramString2);
    this.g = paramaq;
  }
  
  public bp(String paramString1, String paramString2, ar paramar)
  {
    this(paramString1, paramString2);
    this.k = paramar;
  }
  
  public bp(String paramString1, String paramString2, as paramas)
  {
    this(paramString1, paramString2);
    this.h = paramas;
  }
  
  public bp(String paramString1, String paramString2, at paramat)
  {
    this(paramString1, paramString2);
    this.i = paramat;
  }
  
  public bp(String paramString1, String paramString2, au paramau)
  {
    this(paramString1, paramString2);
    this.j = paramau;
  }
  
  public bp(String paramString1, String paramString2, av paramav)
  {
    this(paramString1, paramString2);
    this.f = paramav;
  }
  
  public bp(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2);
    this.l = paramString3;
  }
  
  public bp(String paramString1, String paramString2, String paramString3, j.b paramb)
  {
    this(paramString1, paramString2);
    this.d = paramString3;
    this.c = paramb;
  }
  
  public bp(String paramString1, String paramString2, String paramString3, j.b paramb, int paramInt)
  {
    this(paramString1, paramString2);
    this.l = paramString3;
    this.c = paramb;
    this.m = paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */