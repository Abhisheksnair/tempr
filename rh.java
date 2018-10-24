package com.whatsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.data.ci;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.n;
import com.whatsapp.g.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class rh
{
  private static volatile rh f;
  public final ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  public final ConcurrentHashMap<String, rg> b = new ConcurrentHashMap();
  final va c;
  final com.whatsapp.a.c d;
  final ci e;
  private final e g;
  private final aus h;
  
  private rh(va paramva, e parame, aus paramaus, com.whatsapp.a.c paramc, ci paramci)
  {
    this.c = paramva;
    this.h = paramaus;
    this.g = parame;
    this.d = paramc;
    this.e = paramci;
  }
  
  public static rh a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new rh(va.a(), e.a(), aus.a(), com.whatsapp.a.c.a(), ci.a());
      }
      return f;
    }
    finally {}
  }
  
  public final rf a(String paramString1, String paramString2)
  {
    return a(paramString1).a(paramString2);
  }
  
  public final rg a(String paramString)
  {
    synchronized (this.b)
    {
      Object localObject2 = (rg)this.b.get(paramString);
      ??? = localObject2;
      if (localObject2 != null) {
        return ???;
      }
      ??? = new rg(paramString);
      ((rg)???).c = this.e.a(((rg)???).b);
      ((rg)???).f();
      localObject2 = ((rg)???).d().iterator();
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        ((rf)((Iterator)localObject2).next()).e = rg.a[(i % rg.a.length)];
        i += 1;
      }
    }
    this.b.putIfAbsent(paramString, ???);
    return (rg)???;
  }
  
  public final String a(Iterable<String> paramIterable)
  {
    Object localObject1 = new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      localObject2 = (String)paramIterable.next();
      if (this.c.a((String)localObject2))
      {
        i = 1;
      }
      else
      {
        localObject2 = this.g.d((String)localObject2);
        if (!((ArrayList)localObject1).contains(localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
    paramIterable = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cs localcs = (cs)((Iterator)localObject1).next();
      String str = localcs.a(u.a());
      if (str != null) {
        if (str.equals(cs.b(localcs.t))) {
          ((ArrayList)localObject2).add(str);
        } else {
          paramIterable.add(str);
        }
      }
    }
    Collections.sort(paramIterable);
    Collections.sort((List)localObject2);
    paramIterable.addAll((Collection)localObject2);
    if (i != 0) {
      paramIterable.add(u.a().getString(2131298216));
    }
    return a(paramIterable);
  }
  
  public final String a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    char c1 = al.a(this.h);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public final void a(rg paramrg)
  {
    a(paramrg, true);
  }
  
  final void a(rg paramrg, boolean paramBoolean)
  {
    Object localObject1 = paramrg.d().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((rf)((Iterator)localObject1).next()).d = paramBoolean;
    }
    localObject1 = paramrg.b;
    paramrg = this.e;
    Log.i("msgstore/setParticipantsHaveSenderKey/" + (String)localObject1 + " value:" + paramBoolean);
    paramrg.c.lock();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("sent_sender_key", Boolean.valueOf(paramBoolean));
      paramrg.b.getWritableDatabase().update("group_participants", localContentValues, "gjid=?", new String[] { localObject1 });
      paramrg.c.unlock();
      b.a.a.c.a().b(new b((String)localObject1));
      return;
    }
    finally
    {
      paramrg.c.unlock();
    }
  }
  
  public final void a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2)
  {
    rg localrg = a(paramString);
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext()) {
      localrg.a((String)paramCollection1.next(), false, false);
    }
    paramCollection1 = paramCollection2.iterator();
    while (paramCollection1.hasNext()) {
      localrg.b((String)paramCollection1.next());
    }
    if (!paramCollection2.isEmpty()) {
      com.whatsapp.a.c.a.submit(ri.a(this, localrg, paramString));
    }
  }
  
  public final void b(rg paramrg)
  {
    a(paramrg, false);
  }
  
  public final boolean b(String paramString)
  {
    return a(paramString).b(this.c);
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.b);
  }
  
  public final boolean c(String paramString)
  {
    Object localObject = a(paramString);
    paramString = this.c;
    localObject = ((rg)localObject).c.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      rf localrf = (rf)((Iterator)localObject).next();
      if (paramString.a(localrf.a)) {
        return localrf.b;
      }
    }
    return false;
  }
  
  public final void d(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public final boolean e(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public final String f(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  public final String g(String paramString)
  {
    Object localObject1 = f(paramString);
    if (localObject1 != null) {
      return (String)localObject1;
    }
    localObject1 = new ArrayList();
    Object localObject2 = a(paramString).b().iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (rf)((Iterator)localObject2).next();
      if (this.c.a(((rf)localObject3).a))
      {
        i = 1;
      }
      else
      {
        localObject3 = this.g.d(((rf)localObject3).a);
        if (!((ArrayList)localObject1).contains(localObject3)) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cs localcs = (cs)((Iterator)localObject1).next();
      String str = localcs.k();
      if (str != null) {
        if (str.equals(cs.b(localcs.t))) {
          ((ArrayList)localObject3).add(str);
        } else {
          ((ArrayList)localObject2).add(str);
        }
      }
    }
    Collections.sort((List)localObject2);
    Collections.sort((List)localObject3);
    ((ArrayList)localObject2).addAll((Collection)localObject3);
    if (i != 0) {
      ((ArrayList)localObject2).add(u.a().getString(2131298216));
    }
    localObject1 = a((ArrayList)localObject2);
    this.a.put(paramString, localObject1);
    return (String)localObject1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */