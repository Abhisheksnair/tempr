package com.whatsapp.data;

import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class cm
{
  private static volatile cm b;
  public final cj a;
  private final d c;
  
  private cm(d paramd, cj paramcj)
  {
    this.c = paramd;
    this.a = paramcj;
  }
  
  public static cm a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new cm(d.a(), cj.a());
      }
      return b;
    }
    finally {}
  }
  
  public final int a(String paramString)
  {
    if (e.b(paramString)) {
      return 1;
    }
    ad.d locald = (ad.d)this.c.a.get(paramString);
    int i;
    if (!b(paramString)) {
      i = 1;
    }
    while (locald == null) {
      if (i != 0)
      {
        return 0;
        i = 0;
      }
      else
      {
        return 1;
      }
    }
    if (i != 0) {
      return locald.i;
    }
    return 1;
  }
  
  public final List<String> b()
  {
    String str = this.a.a("call_not_spam_jids");
    if ((str != null) && (str.length() > 0)) {
      return Arrays.asList(str.split(","));
    }
    return null;
  }
  
  final boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      Log.e("spamManager/isCallNotSpamProp/invalid jid: " + paramString);
    }
    List localList;
    do
    {
      return false;
      localList = b();
    } while ((localList == null) || (!localList.contains(paramString)));
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */