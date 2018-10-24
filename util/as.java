package com.whatsapp.util;

import android.support.v4.f.h;
import java.util.HashSet;

public final class as
{
  private static final HashSet<h<String, String>> a;
  
  static
  {
    HashSet localHashSet = new HashSet();
    a = localHashSet;
    localHashSet.add(h.a("310410", "310150"));
    a.add(h.a("71203", "712030"));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return a.contains(h.a(paramString1, paramString2));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */