package com.whatsapp.data;

import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.vk;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aa
{
  private static volatile aa d;
  final z a;
  final Map<j.b, j> b;
  final AtomicBoolean c;
  private final d e;
  
  private aa(d paramd)
  {
    this.e = paramd;
    this.a = new z();
    this.b = new ConcurrentHashMap();
    this.c = new AtomicBoolean();
  }
  
  public static aa a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new aa(d.a());
      }
      return d;
    }
    finally {}
  }
  
  final void a(ad.k paramk)
  {
    this.a.a(paramk);
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      paramk.a((j)localIterator.next());
    }
    localIterator = this.e.a.values().iterator();
    while (localIterator.hasNext())
    {
      ad.d locald = (ad.d)localIterator.next();
      if (locald.b != null) {
        paramk.a(locald.b);
      }
    }
    localIterator = vk.a().iterator();
    while (localIterator.hasNext()) {
      paramk.a((j)localIterator.next());
    }
  }
  
  final void a(j.b paramb)
  {
    this.a.a(paramb);
    this.b.remove(paramb);
  }
  
  final void a(String paramString)
  {
    this.a.a(paramString);
    Iterator localIterator = new HashSet(this.b.keySet()).iterator();
    while (localIterator.hasNext())
    {
      j.b localb = (j.b)localIterator.next();
      if (paramString.equals(localb.a)) {
        this.b.remove(localb);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */