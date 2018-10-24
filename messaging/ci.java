package com.whatsapp.messaging;

import com.whatsapp.auj.m;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j.b;
import java.util.HashMap;
import java.util.List;

public final class ci
{
  String a;
  String b;
  public String c;
  public j.b d;
  public List<av> e;
  List<String> f;
  List<j.b> g;
  public int h;
  public byte[] i;
  public ar j;
  auj.m k;
  public HashMap<String, String> l;
  
  public ci(String paramString, int paramInt, List<av> paramList, auj.m paramm)
  {
    this.a = paramString;
    this.h = paramInt;
    this.e = paramList;
    this.k = paramm;
  }
  
  public ci(String paramString, ar paramar, auj.m paramm)
  {
    this.a = paramString;
    this.j = paramar;
    this.k = paramm;
  }
  
  public ci(String paramString, j.b paramb, int paramInt, auj.m paramm)
  {
    this.a = paramString;
    this.d = paramb;
    this.k = paramm;
    this.h = paramInt;
  }
  
  public ci(String paramString1, String paramString2, auj.m paramm)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.k = paramm;
  }
  
  public ci(String paramString1, String paramString2, auj.m paramm, List<j.b> paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.g = paramList;
    this.k = paramm;
  }
  
  public ci(String paramString1, String paramString2, List<String> paramList, auj.m paramm)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.f = paramList;
    this.k = paramm;
  }
  
  public ci(String paramString1, List<av> paramList, int paramInt, String paramString2, auj.m paramm, HashMap<String, String> paramHashMap)
  {
    this.a = paramString1;
    this.e = paramList;
    this.h = paramInt;
    this.k = paramm;
    this.c = paramString2;
    this.l = paramHashMap;
  }
  
  public ci(String paramString1, List<av> paramList, String paramString2, auj.m paramm)
  {
    this.a = paramString1;
    this.e = paramList;
    this.k = paramm;
    this.c = paramString2;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */