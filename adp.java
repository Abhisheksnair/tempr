package com.whatsapp;

import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.messaging.bb;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public class adp
{
  private static volatile adp a;
  private final att b;
  private final m c;
  private final atv d;
  
  private adp(att paramatt, m paramm, atv paramatv)
  {
    this.b = paramatt;
    this.c = paramm;
    this.d = paramatv;
  }
  
  public static adp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new adp(att.a(), m.a(), atv.a());
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 != null) {
      this.c.a(Message.obtain(null, 0, 28, 0, new bb(paramString1, paramString2, paramString3, paramString4)));
    }
  }
  
  public final void a(ad paramad, j paramj)
  {
    int i;
    if ((!paramj.k) && (paramj.d == 13)) {
      if ((a(paramj.e.a)) && (paramj.n >= 1415214000000L))
      {
        i = 1;
        if (i == 0) {
          break label62;
        }
        ado.a(paramad, this.b, paramj);
      }
    }
    label62:
    while (paramj.k)
    {
      return;
      i = 0;
      break;
    }
    this.c.a(Message.obtain(null, 0, 9, 0, paramj));
  }
  
  public final void a(al paramal)
  {
    if (!TextUtils.isEmpty(paramal.e)) {}
    for (String str = paramal.e;; str = null)
    {
      a(paramal.c, paramal.a, str, paramal.d);
      return;
    }
  }
  
  public final void a(j paramj, String paramString)
  {
    m localm;
    String str1;
    if (paramj != null)
    {
      localm = this.c;
      boolean bool = j.b(paramj.f);
      if (!bool) {
        break label75;
      }
      str1 = paramj.f;
      if (!bool) {
        break label87;
      }
    }
    label75:
    label87:
    for (String str2 = paramj.e.a;; str2 = paramj.f)
    {
      localm.a(Message.obtain(null, 0, 129, 0, new bb(paramj.e.c, str1, str2, paramString)));
      return;
      str1 = paramj.e.a;
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, null, paramString3);
  }
  
  public final boolean a(String paramString)
  {
    return (qz.e(paramString)) || (this.d.e());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/adp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */