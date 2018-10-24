package com.whatsapp;

import a.a.a.a.a.a.d;
import android.util.Base64;
import com.whatsapp.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class rg
{
  static final int[] a = { -4929717, -8154166, -36820, -11617349, -2116080, -14714132, -1011271, -16605952, -8885824, -4946066, -99201, -10890392, 43386, -8544527, -3603591, -6036789, -5881812, -1752413, -6197331, -1094833 };
  public final String b;
  Map<String, rf> c = new ConcurrentHashMap();
  public String d;
  
  public rg(String paramString)
  {
    this.b = ((String)a.d.a(paramString));
  }
  
  public static String a(Collection<String> paramCollection)
  {
    Object localObject = new ArrayList(paramCollection);
    Collections.sort((List)localObject);
    try
    {
      paramCollection = MessageDigest.getInstance("SHA1");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramCollection.update(((String)((Iterator)localObject).next()).getBytes());
      }
      paramCollection = paramCollection.digest();
    }
    catch (NoSuchAlgorithmException paramCollection)
    {
      throw new RuntimeException(paramCollection);
    }
    localObject = new byte[6];
    System.arraycopy(paramCollection, 0, localObject, 0, 6);
    return "1:" + Base64.encodeToString((byte[])localObject, 2);
  }
  
  public final rf a(String paramString)
  {
    return (rf)this.c.get(paramString);
  }
  
  public final rf a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    rf localrf = (rf)this.c.get(paramString);
    if (localrf != null)
    {
      localrf.b = paramBoolean1;
      localrf.c = paramBoolean2;
      return localrf;
    }
    localrf = new rf(paramString, paramBoolean1, paramBoolean2, false);
    localrf.e = a[(this.c.size() % a.length)];
    this.c.put(paramString, localrf);
    f();
    return localrf;
  }
  
  public final Set<String> a()
  {
    return this.c.keySet();
  }
  
  public final Set<String> a(va paramva)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((!((rf)localEntry.getValue()).d) && (!paramva.a(((rf)localEntry.getValue()).a))) {
        localHashSet.add(localEntry.getKey());
      }
    }
    return localHashSet;
  }
  
  public final rf b(String paramString)
  {
    paramString = (rf)this.c.remove(paramString);
    if (paramString != null) {
      f();
    }
    return paramString;
  }
  
  public final Collection<rf> b()
  {
    return this.c.values();
  }
  
  public final boolean b(va paramva)
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      if (paramva.a(((rf)localIterator.next()).a)) {
        return true;
      }
    }
    return false;
  }
  
  public final int c()
  {
    return this.c.size();
  }
  
  public final Collection<rf> d()
  {
    return this.c.values();
  }
  
  public final ArrayList<rf> e()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      rf localrf = (rf)localIterator.next();
      if (localrf.b) {
        localArrayList.add(localrf);
      }
    }
    return localArrayList;
  }
  
  public final void f()
  {
    this.d = a(a());
    Log.d("computed participant hash for " + this.b + " as " + this.d);
  }
  
  public final String toString()
  {
    return "GroupParticipants{groupJid='" + this.b + '\'' + ", participants=" + this.c + ", participantHash='" + this.d + '\'' + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */