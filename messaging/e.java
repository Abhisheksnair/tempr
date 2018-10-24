package com.whatsapp.messaging;

import android.content.SharedPreferences;
import com.whatsapp.atv;
import com.whatsapp.l.f;
import com.whatsapp.util.Log;
import com.whatsapp.util.dns.DnsCacheEntrySerializable;
import com.whatsapp.util.dns.b;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

final class e
{
  private static final String[] l = { "e1.whatsapp.net.", "e2.whatsapp.net.", "e3.whatsapp.net.", "e4.whatsapp.net.", "e5.whatsapp.net.", "e6.whatsapp.net.", "e7.whatsapp.net.", "e8.whatsapp.net.", "e9.whatsapp.net.", "e10.whatsapp.net.", "e11.whatsapp.net.", "e12.whatsapp.net.", "e13.whatsapp.net.", "e14.whatsapp.net.", "e15.whatsapp.net.", "e16.whatsapp.net." };
  int a = 0;
  int b;
  final InetSocketAddress c;
  final String d;
  final List<DnsCacheEntrySerializable> e;
  final List<DnsCacheEntrySerializable> f;
  final Random g;
  final SSLSocketFactory h;
  final SocketFactory i;
  final int j;
  final int k;
  private final f m;
  
  public e(InetSocketAddress paramInetSocketAddress, String paramString, List<DnsCacheEntrySerializable> paramList, Random paramRandom, f paramf)
  {
    this.c = paramInetSocketAddress;
    this.d = paramString;
    this.g = paramRandom;
    this.e = new ArrayList();
    this.f = new ArrayList();
    if (paramList != null)
    {
      paramInetSocketAddress = paramList.iterator();
      while (paramInetSocketAddress.hasNext())
      {
        paramString = (DnsCacheEntrySerializable)paramInetSocketAddress.next();
        if (paramString.forceOverride) {
          this.e.add(paramString);
        } else {
          this.f.add(paramString);
        }
      }
    }
    this.h = ad.a();
    this.i = SocketFactory.getDefault();
    boolean bool = paramRandom.nextBoolean();
    if (bool)
    {
      n = 443;
      this.j = n;
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int n = i1;; n = 443)
    {
      this.k = n;
      this.m = paramf;
      return;
      n = 5222;
      break;
    }
  }
  
  final InetSocketAddress a(int paramInt)
  {
    Object localObject1 = this.m;
    ((f)localObject1).b();
    ((f)localObject1).c = "fb".equals(((f)localObject1).a.a.getString("routing_info_dns", null));
    int n;
    if ((((f)localObject1).c) && (((f)localObject1).b != null) && (((f)localObject1).b.length > 0))
    {
      n = 1;
      if (n == 0) {
        break label135;
      }
    }
    label135:
    for (localObject1 = "g.whatsapp.net";; localObject1 = l[this.g.nextInt(l.length)])
    {
      Object localObject2 = b.a().a((String)localObject1);
      localObject2 = (InetAddress)((List)localObject2).get(this.g.nextInt(((List)localObject2).size()));
      Log.i("ConnectionSequence/getInetSocketAddress; host=" + (String)localObject1);
      return new InetSocketAddress((InetAddress)localObject2, paramInt);
      n = 0;
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */