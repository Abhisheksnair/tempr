package com.whatsapp;

import com.whatsapp.appwidget.WidgetProvider;
import com.whatsapp.data.d;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class lt
{
  private static volatile lt e;
  public final ArrayList<a> a = new ArrayList();
  public final adp b;
  public final att c;
  public final hx d;
  private final d f;
  private final w g;
  private final Comparator<a> h = lu.a();
  
  private lt(d paramd, w paramw, adp paramadp, att paramatt, hx paramhx)
  {
    this.f = paramd;
    this.g = paramw;
    this.b = paramadp;
    this.c = paramatt;
    this.d = paramhx;
  }
  
  public static lt a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new lt(d.a(), w.a(), adp.a(), att.a(), hx.a());
      }
      return e;
    }
    finally {}
  }
  
  public static ArrayList<j> a(Collection<j> paramCollection)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, lv.a());
    return paramCollection;
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool = false;
    synchronized (this.a)
    {
      a locala2 = b(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        locala1.a = paramString;
      }
      locala1.b = paramLong;
      int i = c(paramString);
      int j = Collections.binarySearch(this.a, locala1, this.h);
      this.a.add(-j - 1, locala1);
      if (-j - 1 != i) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final ArrayList<String> a(cc arg1)
  {
    ArrayList localArrayList = new ArrayList(this.a.size());
    Set localSet = ???.f();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((!this.f.d(locala.a)) && (!localSet.contains(locala.a))) {
          localArrayList.add(locala.a);
        }
      }
    }
    localArrayList1.addAll(0, localSet);
    return localArrayList1;
  }
  
  public final void a(String paramString)
  {
    boolean bool = true;
    if (this.f.a(paramString)) {
      bool = a(paramString, this.f.b(paramString));
    }
    while (bool)
    {
      this.d.b();
      return;
      c(paramString);
      WidgetProvider.a(u.a());
    }
    this.d.a(paramString);
  }
  
  public final void a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (this.f.a(str))
      {
        a(str, this.f.b(str));
        this.d.b();
        if ((!qz.e(str)) && (!j.a(str)) && (!j.b(str))) {
          localArrayList.add(str);
        }
      }
    }
    this.g.a((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
  
  public final a b(String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a.equals(paramString)) {
          return locala;
        }
      }
      return null;
    }
  }
  
  public final void b()
  {
    this.d.b();
    WidgetProvider.a(u.a());
  }
  
  public final int c(String paramString)
  {
    int j = -1;
    ArrayList localArrayList = this.a;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.a.size())
        {
          if (((a)this.a.get(i)).a.equals(paramString))
          {
            this.a.remove(i);
            j = i;
          }
        }
        else {
          return j;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final ArrayList<String> c()
  {
    ArrayList localArrayList2 = new ArrayList(this.a.size());
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (!this.f.d(locala.a)) {
          localArrayList2.add(locala.a);
        }
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<String> d()
  {
    ArrayList localArrayList2 = new ArrayList(this.a.size());
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (this.f.d(locala.a)) {
          localArrayList2.add(locala.a);
        }
      }
    }
    return localArrayList;
  }
  
  public final boolean d(String paramString)
  {
    return b(paramString) != null;
  }
  
  public final int e()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (this.f.d(locala.a)) {
            i += 1;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public final int f()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (!this.f.d(locala.a)) {
            i += 1;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public final boolean g()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (qz.e(((a)localIterator.next()).a)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public final ArrayList<String> h()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList(this.a.size());
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((qz.e(locala.a)) || (j.b(locala.a))) {
          localArrayList2.add(locala.a);
        }
      }
    }
    return localArrayList;
  }
  
  public final int i()
  {
    synchronized (this.a)
    {
      int i = this.a.size();
      return i;
    }
  }
  
  public final ArrayList<String> j()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList(this.a.size());
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        localArrayList2.add(((a)localIterator.next()).a);
      }
    }
    return localArrayList;
  }
  
  public final String k()
  {
    long l = System.currentTimeMillis() / 1000L;
    synchronized (this.a)
    {
      while (d(Long.toString(l) + "@broadcast")) {
        l += 1L;
      }
      return Long.toString(l) + "@broadcast";
    }
  }
  
  public static final class a
  {
    public String a;
    long b;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/lt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */