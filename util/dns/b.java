package com.whatsapp.util.dns;

import b.a.a.c;
import com.whatsapp.ce;
import com.whatsapp.g.f;
import com.whatsapp.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static volatile b a;
  private final HashMap<String, ArrayList<DnsCacheEntrySerializable>> b = new HashMap();
  
  private b()
  {
    c.a().a(this, false);
  }
  
  public static b a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        b localb2 = a;
        localObject = localb2;
        if (localb2 == null)
        {
          localObject = new b();
          a = (b)localObject;
        }
        return (b)localObject;
      }
      finally {}
    }
    return localb1;
  }
  
  private void a(String paramString, Iterable<InetAddress> paramIterable)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(new DnsCacheEntrySerializable(Long.valueOf(3600000L + l), (InetAddress)paramIterable.next()));
    }
    try
    {
      this.b.put(paramString, localArrayList);
      return;
    }
    finally {}
  }
  
  private List<InetAddress> b(String paramString)
  {
    for (;;)
    {
      List localList;
      ArrayList localArrayList;
      HashSet localHashSet;
      try
      {
        localList = (List)this.b.get(paramString);
        if (localList == null)
        {
          paramString = null;
          return paramString;
        }
        localArrayList = new ArrayList();
        localHashSet = new HashSet();
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label112;
        }
        DnsCacheEntrySerializable localDnsCacheEntrySerializable = (DnsCacheEntrySerializable)localIterator.next();
        if (localDnsCacheEntrySerializable.isExpired())
        {
          localHashSet.add(localDnsCacheEntrySerializable);
          continue;
        }
        localArrayList.add(localDnsCacheEntrySerializable.inetAddress);
      }
      finally {}
      continue;
      label112:
      localList.removeAll(localHashSet);
      if (localList.isEmpty()) {
        this.b.remove(paramString);
      }
      paramString = localArrayList;
    }
  }
  
  private List<InetAddress> c(String paramString)
  {
    Object localObject = g.a(paramString);
    InetAddress[] arrayOfInetAddress = new InetAddress[localObject.length];
    int i = 0;
    while (i < localObject.length)
    {
      arrayOfInetAddress[i] = localObject[i].a;
      i += 1;
    }
    localObject = Arrays.asList(arrayOfInetAddress);
    a(paramString, (Iterable)localObject);
    return (List<InetAddress>)localObject;
  }
  
  public final List<InetAddress> a(String paramString)
  {
    Log.i("resolving " + paramString);
    List localList1 = b(paramString);
    if ((localList1 != null) && (!localList1.isEmpty())) {
      return localList1;
    }
    try
    {
      localList1 = Arrays.asList(InetAddress.getAllByName(paramString));
      a(paramString, localList1);
      return localList1;
    }
    catch (UnknownHostException localUnknownHostException1)
    {
      Log.w("primary dns resolution failed for " + paramString + ' ' + localUnknownHostException1);
      try
      {
        List localList2 = c(paramString);
        return localList2;
      }
      catch (UnknownHostException localUnknownHostException2)
      {
        Log.w("secondary dns resolution failed for " + paramString + ' ' + localUnknownHostException2);
        try
        {
          List localList3 = (List)ce.a.get(paramString);
          if ((localList3 == null) || (localList3.isEmpty())) {
            throw new UnknownHostException("no hardcoded ips found for " + paramString);
          }
        }
        catch (UnknownHostException localUnknownHostException3)
        {
          Log.w("hardcoded ip resolution failed for " + paramString + ' ' + localUnknownHostException3);
          throw localUnknownHostException1;
        }
        a(paramString, localUnknownHostException3);
        return localUnknownHostException3;
      }
    }
  }
  
  public final void onEvent(f paramf)
  {
    try
    {
      this.b.clear();
      return;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/dns/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */