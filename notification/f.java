package com.whatsapp.notification;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.whatsapp.auj;
import com.whatsapp.cc;
import com.whatsapp.cc.a;
import com.whatsapp.data.ad;
import com.whatsapp.data.d;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j.b;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static volatile f e;
  long a = System.currentTimeMillis() - 200L;
  final Map<String, List<com.whatsapp.protocol.j>> b = new HashMap();
  public boolean c;
  final ad d;
  private Handler f;
  private ag g;
  private final va h;
  private final d i;
  private final cc j;
  
  private f(va paramva, d paramd, ad paramad, cc paramcc)
  {
    this.h = paramva;
    this.i = paramd;
    this.d = paramad;
    this.j = paramcc;
  }
  
  public static f a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new f(va.a(), d.a(), ad.a(), cc.a());
      }
      return e;
    }
    finally {}
  }
  
  static String a(List<com.whatsapp.protocol.j> paramList)
  {
    if (paramList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((com.whatsapp.protocol.j)paramList.next()).e.c).append(' ');
    }
    return localStringBuilder.toString();
  }
  
  private Handler e()
  {
    if (this.f == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("Notifications", 10);
      localHandlerThread.start();
      this.f = new Handler(localHandlerThread.getLooper());
    }
    return this.f;
  }
  
  public final void a(com.whatsapp.protocol.j paramj, boolean paramBoolean)
  {
    a(paramj, paramBoolean, this.c, false);
  }
  
  public final void a(com.whatsapp.protocol.j paramj, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool2 = false;
    if ((paramj != null) && (paramj.a())) {
      return;
    }
    boolean bool3;
    if ((!paramBoolean1) && (paramj != null))
    {
      bool3 = auj.k();
      bool1 = bool3;
      if (bool3)
      {
        Log.d("notification update muted by web mute");
        auj.a(paramj, paramBoolean2, paramBoolean3);
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      StringBuilder localStringBuilder = new StringBuilder("messagenotification/refreshstatusbar newmsg=");
      if (paramj == null) {}
      for (String str = "null";; str = Log.a(paramj))
      {
        Log.d(str + " quiet=" + paramBoolean1 + " noPopup=" + paramBoolean2 + " isAndroidWearRefresh=" + paramBoolean3);
        if (!paramBoolean1)
        {
          paramBoolean1 = bool2;
          if (!bool1) {}
        }
        else
        {
          paramBoolean1 = true;
        }
        paramj = new ag(paramj, paramBoolean1, paramBoolean2, paramBoolean3);
        if ((this.g != null) && (this.g.equals(paramj))) {
          e().removeCallbacks(this.g);
        }
        this.g = paramj;
        e().post(this.g);
        return;
      }
    }
  }
  
  public final void a(String paramString)
  {
    e().post(h.a(paramString));
    auj.m();
  }
  
  public final void a(String paramString, com.whatsapp.protocol.j paramj)
  {
    e().post(i.a(this, paramString, paramj));
  }
  
  public final boolean a(com.whatsapp.protocol.j paramj)
  {
    int m = 1;
    if (this.i.d(paramj.e.a)) {}
    label171:
    label174:
    for (;;)
    {
      return false;
      if ((!e.b(paramj.e.a)) || (paramj.d != 0))
      {
        if (this.j.a(paramj.e.a).c()) {
          return true;
        }
        int k;
        if ((paramj.P != null) && (paramj.P.contains(this.h.b() + "@s.whatsapp.net")))
        {
          k = 1;
          if ((paramj.V == null) || (!TextUtils.isEmpty(paramj.V.f))) {
            break label171;
          }
        }
        for (;;)
        {
          if ((!qz.e(paramj.e.a)) || ((m == 0) && (k == 0))) {
            break label174;
          }
          return this.j.a(paramj.f).c();
          k = 0;
          break;
          m = 0;
        }
      }
    }
  }
  
  public final List<com.whatsapp.protocol.j> b(String paramString)
  {
    if (this.i.d(paramString)) {
      return new ArrayList();
    }
    Object localObject1 = (List)this.b.get(paramString);
    Object localObject2 = localObject1;
    int k;
    if (localObject1 == null)
    {
      k = this.d.o(paramString);
      if (k <= 0) {
        break label185;
      }
    }
    label185:
    for (localObject1 = this.d.b(paramString, Math.min(k, 7));; localObject1 = new ArrayList())
    {
      this.b.put(paramString, localObject1);
      localObject2 = localObject1;
      if (!((List)localObject1).isEmpty())
      {
        Log.d("messagenotification/get-messages/init " + paramString + " " + a((List)localObject1));
        localObject2 = localObject1;
      }
      paramString = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.whatsapp.protocol.j)((Iterator)localObject1).next();
        if (a((com.whatsapp.protocol.j)localObject2)) {
          paramString.add(localObject2);
        }
      }
    }
    return paramString;
  }
  
  public final void b()
  {
    a(null, true, true, false);
  }
  
  public final void b(String paramString, com.whatsapp.protocol.j paramj)
  {
    e().post(j.a(this, paramj, paramString));
  }
  
  public final void c()
  {
    e().post(g.a());
    auj.m();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */