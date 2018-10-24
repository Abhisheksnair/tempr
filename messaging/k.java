package com.whatsapp.messaging;

import android.content.Context;
import com.whatsapp.util.Log;
import com.whatsapp.util.dns.DnsCacheEntrySerializable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class k
{
  private static final k a = new k();
  
  public static k a()
  {
    return a;
  }
  
  private static ArrayList<DnsCacheEntrySerializable> a(Context paramContext)
  {
    Object localObject = new ObjectInputStream(new BufferedInputStream(paramContext.openFileInput("fbips")));
    ArrayList localArrayList = (ArrayList)((ObjectInputStream)localObject).readObject();
    ((ObjectInputStream)localObject).close();
    localObject = new HashSet();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      DnsCacheEntrySerializable localDnsCacheEntrySerializable = (DnsCacheEntrySerializable)localIterator.next();
      if (localDnsCacheEntrySerializable.isExpired()) {
        ((Collection)localObject).add(localDnsCacheEntrySerializable);
      }
    }
    if (!((Collection)localObject).isEmpty())
    {
      localArrayList.removeAll((Collection)localObject);
      if (localArrayList.isEmpty()) {
        paramContext.deleteFile("fbips");
      }
    }
    else
    {
      return localArrayList;
    }
    a(paramContext, localArrayList);
    return localArrayList;
  }
  
  public static ArrayList<DnsCacheEntrySerializable> a(Context paramContext, String[] paramArrayOfString, ArrayList<DnsCacheEntrySerializable> paramArrayList)
  {
    if ((paramArrayOfString != null) || (new File(paramContext.getFilesDir(), "fbips").canRead())) {}
    try
    {
      paramContext = a(paramContext);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      Log.d("xmpp/service/fallback/loadFallbacks", paramContext);
      return new ArrayList();
      if ((paramArrayOfString.length == 1) && (paramArrayOfString[0].equalsIgnoreCase("CLEAR")))
      {
        paramContext.deleteFile("fbips");
        return new ArrayList();
      }
      try
      {
        a(paramContext, paramArrayList);
        return paramArrayList;
      }
      catch (IOException paramContext)
      {
        Log.d("xmpp/service/fallback/saveFallbacks", paramContext);
        return paramArrayList;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static ArrayList<DnsCacheEntrySerializable> a(String[] paramArrayOfString)
  {
    int i = 0;
    ArrayList localArrayList = null;
    Object localObject = localArrayList;
    if (paramArrayOfString != null)
    {
      localObject = localArrayList;
      if (paramArrayOfString.length > 0) {
        if (paramArrayOfString.length == 1)
        {
          localObject = localArrayList;
          if ("CLEAR".equalsIgnoreCase(paramArrayOfString[0])) {}
        }
        else
        {
          localArrayList = new ArrayList();
          int j = paramArrayOfString.length;
          localObject = localArrayList;
          if (i < j)
          {
            localObject = paramArrayOfString[i];
            DnsCacheEntrySerializable localDnsCacheEntrySerializable = DnsCacheEntrySerializable.parseFallbackIpString((String)localObject);
            if (localDnsCacheEntrySerializable == null) {
              Log.d("FallbackManager/getDnsCacheEntrySerializables/bad/" + (String)localObject);
            }
            for (;;)
            {
              i += 1;
              break;
              Log.d("FallbackManager/getDnsCacheEntrySerializables/good/" + localDnsCacheEntrySerializable);
              localArrayList.add(localDnsCacheEntrySerializable);
            }
          }
        }
      }
    }
    return (ArrayList<DnsCacheEntrySerializable>)localObject;
  }
  
  private static void a(Context paramContext, ArrayList<DnsCacheEntrySerializable> paramArrayList)
  {
    paramContext = new ObjectOutputStream(new BufferedOutputStream(paramContext.openFileOutput("fbips", 0)));
    paramContext.writeObject(paramArrayList);
    paramContext.close();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */