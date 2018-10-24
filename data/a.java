package com.whatsapp.data;

import a.a.a.a.d;
import android.os.Message;
import com.whatsapp.messaging.bt;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.r;
import com.whatsapp.r.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.util.r.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static volatile a b;
  final cb a;
  private final c c;
  private final w d;
  
  private a(c paramc, w paramw, ad paramad)
  {
    this.c = paramc;
    this.d = paramw;
    this.a = paramad.c;
  }
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a(c.a(), w.a(), ad.a());
      }
      return b;
    }
    finally {}
  }
  
  public final int a(Runnable paramRunnable)
  {
    Object localObject3 = this.a.g;
    Object localObject1 = cb.a(r.b.f);
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(d.a(this.c, (File)localObject3, 7, new String[] { localObject1 }));
    Object localObject4 = cb.a(r.b.g, r.b.a());
    int j = localObject4.length;
    int i = 0;
    r.a locala;
    while (i < j)
    {
      locala = localObject4[i];
      ((List)localObject2).addAll(d.a(this.c, (File)localObject3, -1, new String[] { locala }));
      i += 1;
    }
    localObject3 = new HashSet();
    localObject4 = ((List)localObject2).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (File)((Iterator)localObject4).next();
      locala = r.a((File)localObject5);
      if (locala != null)
      {
        boolean bool = ((File)localObject5).getName().endsWith((String)localObject1);
        localObject5 = r.a(locala.d, locala.a, bool);
        ((HashSet)localObject3).add(new cb.a(locala.b, locala.c, (byte[])localObject5));
      }
      else
      {
        Log.i("backupencryption/getkeysforbackups/no-cipher/skip");
      }
    }
    i = ((HashSet)localObject3).size();
    Log.i("backupencryption/getkeys/size " + i + " (backups=" + ((List)localObject2).size() + ")");
    this.a.b.clear();
    localObject1 = ((HashSet)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (cb.a)((Iterator)localObject1).next();
      localObject2 = this.d;
      localObject3 = Message.obtain(null, 0, 75, 0, new bt(((cb.a)localObject3).a, ((cb.a)localObject3).b, ((cb.a)localObject3).c, b.a(this, i, paramRunnable)));
      ((w)localObject2).b.a((Message)localObject3, null);
    }
    return i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */