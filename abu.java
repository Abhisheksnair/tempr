package com.whatsapp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.messaging.m;
import com.whatsapp.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class abu
{
  private static volatile abu d;
  final Handler a = new Handler(Looper.getMainLooper());
  final HashMap<String, c> b = new HashMap();
  final HashMap<String, d> c = new HashMap();
  private final m e;
  private final dh f;
  
  private abu(m paramm, dh paramdh)
  {
    this.e = paramm;
    this.f = paramdh;
  }
  
  public static abu a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new abu(m.a(), dh.a());
      }
      return d;
    }
    finally {}
  }
  
  static boolean a(long paramLong)
  {
    return (paramLong != 0L) && (25000L + paramLong > SystemClock.elapsedRealtime());
  }
  
  public final int a(String paramString1, String paramString2)
  {
    d locald = (d)this.c.get(paramString1);
    if (locald == null) {
      return -1;
    }
    if ((paramString2 != null) && (qz.e(paramString1)))
    {
      if (locald.e == null) {
        return -1;
      }
      paramString1 = (a)locald.e.get(paramString2);
      if (paramString1 == null) {
        return -1;
      }
      if (a(paramString1.a)) {
        return paramString1.b;
      }
      return -1;
    }
    if (a(locald.c)) {
      return locald.d;
    }
    return -1;
  }
  
  public final long a(String paramString)
  {
    paramString = (d)this.c.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.b;
  }
  
  public final String a(String paramString, long paramLong)
  {
    Object localObject2 = (d)this.c.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new d((byte)0);
      this.c.put(paramString, localObject1);
    }
    if (paramLong == 0L) {}
    for (((d)localObject1).b = 0L;; ((d)localObject1).b = paramLong)
    {
      ((d)localObject1).c = 0L;
      localObject1 = this.c.entrySet().iterator();
      Object localObject3;
      do
      {
        do
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
          } while (!qz.e((String)((Map.Entry)localObject2).getKey()));
          localObject3 = (d)((Map.Entry)localObject2).getValue();
        } while (((d)localObject3).e == null);
        localObject3 = (a)((d)localObject3).e.get(paramString);
      } while (localObject3 == null);
      ((a)localObject3).a = 0L;
      return (String)((Map.Entry)localObject2).getKey();
    }
    return null;
  }
  
  public final void a(cs paramcs)
  {
    if ((cs.e(paramcs.t)) || (paramcs.t.equals("Server@s.whatsapp.net")) || (e.b(paramcs.t))) {}
    for (;;)
    {
      return;
      Object localObject = paramcs.t;
      localObject = (d)this.c.get(localObject);
      if ((localObject != null) && (((d)localObject).a)) {}
      for (int i = 1; (i == 0) && (this.e.d); i = 0)
      {
        this.e.a(Message.obtain(null, 0, 12, 0, paramcs.t));
        a(paramcs.t, true);
        return;
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    d locald2 = (d)this.c.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d((byte)0);
      this.c.put(paramString, locald1);
    }
    locald1.a = paramBoolean;
    if (!paramBoolean) {
      locald1.b = 0L;
    }
  }
  
  public final void b()
  {
    Object localObject1 = new HashSet(this.c.keySet());
    this.c.clear();
    Object localObject2 = this.b.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      c localc = (c)((Iterator)localObject2).next();
      this.a.removeCallbacks(localc);
    }
    ((HashSet)localObject1).addAll(this.b.keySet());
    this.b.clear();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.f.d((String)localObject2);
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    d locald = (d)this.c.get(paramString1);
    if (locald == null)
    {
      locald = new d((byte)0);
      this.c.put(paramString1, locald);
    }
    for (;;)
    {
      if ((paramString2 != null) && (qz.e(paramString1)))
      {
        if (locald.e == null) {
          locald.e = new HashMap();
        }
        a locala2 = (a)locald.e.get(paramString2);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locald.e.put(paramString2, locala1);
        }
        locala1.a = 0L;
      }
      locald.c = 0L;
      paramString1 = paramString1 + paramString2;
      paramString1 = (c)this.b.get(paramString1);
      if (paramString1 != null) {
        this.a.removeCallbacks(paramString1);
      }
      return;
    }
  }
  
  public final boolean b(String paramString)
  {
    if (qz.e(paramString)) {
      return true;
    }
    paramString = (d)this.c.get(paramString);
    return (paramString != null) && (paramString.b == 1L);
  }
  
  static final class a
  {
    long a;
    int b;
  }
  
  public static final class b
  {
    public String a;
    public int b;
    
    b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
  
  final class c
    implements Runnable
  {
    private String b;
    private String c;
    
    c(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public final void run()
    {
      if ((abu.d)abu.a(abu.this).get(this.b) != null)
      {
        Log.i("presencemgr/timeout/" + this.b + " " + this.c);
        abu.this.b(this.b, this.c);
        abu.b(abu.this).d(this.b);
      }
    }
  }
  
  static final class d
  {
    boolean a;
    long b;
    long c;
    int d;
    HashMap<String, abu.a> e;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */