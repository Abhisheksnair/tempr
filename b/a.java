package com.whatsapp.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Pair;
import b.a.a.c;
import com.google.protobuf.e;
import com.google.protobuf.q;
import com.whatsapp.aus;
import com.whatsapp.g.h;
import com.whatsapp.proto.a.b;
import com.whatsapp.proto.a.b.b;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class a
{
  private static volatile a e;
  public final b a;
  public final z<a, com.whatsapp.proto.a> b = new z(10);
  public final HashSet<a> c = new HashSet();
  public final HashMap<Pair<Locale[], String>, Long> d = new HashMap();
  
  private a(Context paramContext)
  {
    this.a = new b(paramContext);
  }
  
  public static a a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new a(u.a());
      }
      return e;
    }
    finally {}
  }
  
  public static a.b a(com.whatsapp.proto.a parama, String paramString)
  {
    if ((parama == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Iterator localIterator = parama.d.iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      if ((localb.b()) && (localb.c.b()))
      {
        a.b.b localb1 = localb.c;
        parama = localb1.c;
        if ((parama instanceof String)) {
          parama = (String)parama;
        }
        while (parama.equals(paramString))
        {
          return localb;
          e locale = (e)parama;
          parama = locale.e();
          if (locale.f()) {
            localb1.c = parama;
          }
        }
      }
    }
    return null;
  }
  
  public static Locale[] a(aus paramaus, Locale paramLocale)
  {
    Object localObject = paramaus.b();
    if (paramLocale != null)
    {
      paramaus = paramLocale;
      if (!TextUtils.isEmpty(paramLocale.getLanguage())) {}
    }
    else
    {
      paramaus = Locale.ENGLISH;
    }
    paramLocale = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = LocaleList.getDefault();
      int j = localLocaleList.size();
      i = 0;
      while (i < j)
      {
        localArrayList.add(localLocaleList.get(i));
        i += 1;
      }
      if (!localArrayList.contains(localObject)) {
        localArrayList.add(0, localObject);
      }
    }
    for (;;)
    {
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        localObject = ((Locale)localArrayList.get(i)).getLanguage();
        if (!paramLocale.contains(localObject))
        {
          localArrayList.add(i + 1, new Locale((String)localObject, ""));
          paramLocale.add(localObject);
        }
        i -= 1;
      }
      localArrayList.add(localObject);
    }
    if (!localArrayList.contains(paramaus)) {
      localArrayList.add(paramaus);
    }
    return (Locale[])localArrayList.toArray(new Locale[localArrayList.size()]);
  }
  
  public final com.whatsapp.proto.a a(Locale[] arg1, String arg2)
  {
    a locala;
    for (;;)
    {
      synchronized (this.b)
      {
        j = ???.length;
        localObject1 = null;
        i = 0;
        if (i < j)
        {
          locala = new a(???[i], ???);
          localObject1 = (com.whatsapp.proto.a)this.b.get(locala);
          if (localObject1 != null) {
            if (((com.whatsapp.proto.a)localObject1).f() <= 0) {
              break label109;
            }
          }
        }
        else
        {
          if (localObject1 == null) {
            break label123;
          }
          if (((com.whatsapp.proto.a)localObject1).f() <= 0) {
            break;
          }
          return (com.whatsapp.proto.a)localObject1;
        }
        localObject1 = null;
        if (!this.c.contains(locala)) {
          continue;
        }
        return null;
      }
      label109:
      i += 1;
    }
    Log.d("languagepackmanager/request-language-pack cache shows no packs for any locale");
    return null;
    label123:
    int j = ???.length;
    int i = 0;
    Locale localLocale;
    long l2;
    Object localObject3;
    long l1;
    if (i < j)
    {
      localLocale = ???[i];
      locala = new a(localLocale, ???);
      localObject1 = this.a;
      l2 = (System.currentTimeMillis() - 2592000000L) / 1000L;
      localObject1 = ((b)localObject1).a.getWritableDatabase();
      ??? = localLocale.getLanguage();
      localObject3 = localLocale.getCountry();
      localObject3 = ((SQLiteDatabase)localObject1).query("packs", new String[] { "hash", "timestamp", "data" }, "lg = ? AND lc = ? AND namespace = ?", new String[] { ???, localObject3, ??? }, null, null, null);
      if (!((Cursor)localObject3).moveToNext()) {
        break label770;
      }
      ??? = ((Cursor)localObject3).getString(0);
      l1 = ((Cursor)localObject3).getLong(1);
    }
    for (Object localObject1 = ((Cursor)localObject3).getBlob(2);; ??? = null)
    {
      ((Cursor)localObject3).close();
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        ??? = localObject1;
        if (localObject1 != null)
        {
          ??? = localObject1;
          if (localObject1.length != 0) {}
        }
      }
      else
      {
        ??? = localObject1;
        if (l1 < l2) {
          ??? = null;
        }
      }
      if ((??? != null) && (???.length > 0))
      {
        ??? = null;
        try
        {
          localObject1 = com.whatsapp.proto.a.a((byte[])???);
          ??? = (Locale[])localObject1;
        }
        catch (q localq)
        {
          for (;;)
          {
            Log.w("languagepackmanager/request-language-pack/invalidproto:" + localq);
          }
          Log.w("languagepackmanager/request-language-pack pack data is invalid");
          if (this.a.a.getWritableDatabase().delete("packs", "lg = ? AND lc = ? AND namespace = ?", new String[] { localLocale.getLanguage(), localLocale.getCountry(), ??? }) <= 0) {
            break label582;
          }
          Log.i("language-pack-store/delete-language-pack deleted pack for " + localLocale + " ns=" + ???);
          synchronized (this.b)
          {
            this.b.remove(locala);
            this.c.add(locala);
            return null;
          }
        }
        if ((??? != null) && (???.b()) && (???.f() > 0))
        {
          Log.i("languagepackmanager/request-language-pack loaded lg=" + ???.d() + " lc=" + ???.e() + " ns=" + ???.c() + " tcount=" + ???.f());
          synchronized (this.b)
          {
            this.b.put(locala, ???);
            this.c.remove(locala);
            return (com.whatsapp.proto.a)???;
          }
        }
      }
      label582:
      if ((??? != null) && (???.length == 0))
      {
        Log.d("languagepackmanager/request-language-pack server missing pack for loc=" + localLocale);
        synchronized (this.b)
        {
          this.b.put(locala, com.whatsapp.proto.a.g().a(???).b());
          this.c.remove(locala);
          i += 1;
        }
      }
      Log.d("languagepackmanager/request-language-pack no pack for loc=" + localLocale);
      synchronized (this.b)
      {
        this.b.remove(locala);
        this.c.add(locala);
        return null;
      }
      Log.d("languagepackmanager/request-language-pack no pack found for any locale");
      return null;
      label770:
      l1 = 0L;
      ??? = null;
    }
  }
  
  public final void a(Locale[] paramArrayOfLocale, String paramString, int paramInt)
  {
    int i = 0;
    Log.i("languagepackmanager/on-get-biz-language-pack-error code=" + paramInt);
    if (paramInt == 404)
    {
      int j = paramArrayOfLocale.length;
      paramInt = 0;
      while (paramInt < j)
      {
        ??? = paramArrayOfLocale[paramInt];
        this.a.a((Locale)???, null, paramString, null);
        paramInt += 1;
      }
      synchronized (this.b)
      {
        com.whatsapp.proto.a locala = com.whatsapp.proto.a.g().a(paramString).b();
        j = paramArrayOfLocale.length;
        paramInt = i;
        while (paramInt < j)
        {
          a locala1 = new a(paramArrayOfLocale[paramInt], paramString);
          this.b.put(locala1, locala);
          this.c.remove(locala1);
          paramInt += 1;
        }
        this.d.put(Pair.create(paramArrayOfLocale, paramString), Long.valueOf(System.currentTimeMillis()));
        c.a().b(new h(paramArrayOfLocale, paramString));
        return;
      }
    }
    synchronized (this.b)
    {
      this.d.put(Pair.create(paramArrayOfLocale, paramString), Long.valueOf(System.currentTimeMillis()));
      c.a().b(new h(paramArrayOfLocale, paramString));
      return;
    }
  }
  
  public final void a(Locale[] paramArrayOfLocale, Locale paramLocale, String arg3, String paramString2, byte[] paramArrayOfByte)
  {
    Log.i("languagepackmanager/on-get-biz-language-pack");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.w("languagepackmanager/on-get-biz-language-pack already have latest version");
      synchronized (this.b)
      {
        this.d.put(Pair.create(paramArrayOfLocale, paramString2), Long.valueOf(System.currentTimeMillis()));
        this.a.a(paramLocale, paramString2);
        c.a().b(new h(paramLocale, paramString2));
        return;
      }
    }
    Object localObject3 = new ArrayList(paramArrayOfLocale.length);
    int j = paramArrayOfLocale.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramArrayOfLocale[i];
      if (((Locale)localObject1).equals(paramLocale)) {
        break;
      }
      ((ArrayList)localObject3).add(localObject1);
      i += 1;
    }
    try
    {
      localObject1 = com.whatsapp.proto.a.a(paramArrayOfByte);
      if ((localObject1 != null) && (((com.whatsapp.proto.a)localObject1).b()) && (!TextUtils.isEmpty(???)))
      {
        this.a.a(paramLocale, ???, ((com.whatsapp.proto.a)localObject1).c(), paramArrayOfByte);
        if (((ArrayList)localObject3).size() < paramArrayOfLocale.length)
        {
          ??? = ((ArrayList)localObject3).iterator();
          while (???.hasNext())
          {
            paramArrayOfByte = (Locale)???.next();
            this.a.a(paramArrayOfByte, null, paramString2, null);
          }
        }
      }
    }
    catch (q localq)
    {
      Object localObject2;
      for (;;)
      {
        Log.w("languagepackmanager/on-get-biz-language-pack/invalidproto:" + localq);
        localObject2 = null;
      }
      synchronized (this.b)
      {
        paramArrayOfByte = new a(paramLocale, ((com.whatsapp.proto.a)localObject2).c());
        this.b.put(paramArrayOfByte, localObject2);
        this.c.remove(paramArrayOfByte);
        if (((ArrayList)localObject3).size() < paramArrayOfLocale.length)
        {
          paramArrayOfByte = com.whatsapp.proto.a.g().a(paramString2).b();
          localObject2 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = new a((Locale)((Iterator)localObject2).next(), paramString2);
            this.b.put(localObject3, paramArrayOfByte);
            this.c.remove(localObject3);
          }
        }
      }
      this.d.put(Pair.create(paramArrayOfLocale, paramString2), Long.valueOf(System.currentTimeMillis()));
      c.a().b(new h(paramLocale, paramString2));
      return;
    }
    Log.w("languagepackmanager/on-get-biz-language-pack pack data is invalid");
  }
  
  public final String[] b(Locale[] paramArrayOfLocale, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfLocale.length];
    int i = 0;
    Object localObject2;
    if (i < paramArrayOfLocale.length)
    {
      localObject2 = this.a;
      localObject1 = paramArrayOfLocale[i];
      localObject2 = ((b)localObject2).a.getWritableDatabase();
      String str = ((Locale)localObject1).getLanguage();
      localObject1 = ((Locale)localObject1).getCountry();
      localObject2 = ((SQLiteDatabase)localObject2).query("packs", new String[] { "hash" }, "lg = ? AND lc = ? AND namespace = ?", new String[] { str, localObject1, paramString }, null, null, null);
      if (!((Cursor)localObject2).moveToNext()) {
        break label134;
      }
    }
    label134:
    for (Object localObject1 = ((Cursor)localObject2).getString(0);; localObject1 = null)
    {
      ((Cursor)localObject2).close();
      arrayOfString[i] = localObject1;
      i += 1;
      break;
      return arrayOfString;
    }
  }
  
  public final long c(Locale[] paramArrayOfLocale, String paramString)
  {
    synchronized (this.b)
    {
      paramArrayOfLocale = (Long)this.d.get(Pair.create(paramArrayOfLocale, paramString));
      if (paramArrayOfLocale != null) {
        return paramArrayOfLocale.longValue();
      }
    }
    return 0L;
  }
  
  static final class a
  {
    final Locale a;
    final String b;
    
    public a(Locale paramLocale, String paramString)
    {
      this.a = paramLocale;
      this.b = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.a != null)
        {
          if (this.a.equals(((a)paramObject).a)) {}
        }
        else {
          while (((a)paramObject).a != null) {
            return false;
          }
        }
        if (this.b != null) {
          return this.b.equals(((a)paramObject).b);
        }
      } while (((a)paramObject).b == null);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (this.a != null) {}
      for (int i = this.a.hashCode();; i = 0)
      {
        if (this.b != null) {
          j = this.b.hashCode();
        }
        return i * 31 + j;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */