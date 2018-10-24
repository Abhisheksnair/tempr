package com.whatsapp;

import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.util.w;
import java.net.URL;

public final class ace
{
  public String a;
  public byte[] b;
  public int c;
  public int d;
  public URL e;
  
  public ace(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  public ace(String paramString, byte[] paramArrayOfByte, URL paramURL, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.e = paramURL;
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  public static void a(pv parampv, ad paramad, e parame, mf parammf, dh paramdh, w paramw, ace paramace)
  {
    parammf.a(acf.a(parame, paramace, paramw, paramad, parampv, paramdh));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */