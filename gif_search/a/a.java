package com.whatsapp.gif_search.a;

import android.os.AsyncTask;
import android.support.v4.f.h;
import com.whatsapp.ant;
import com.whatsapp.ape;
import com.whatsapp.aus;
import com.whatsapp.fieldstats.events.ab;
import com.whatsapp.gif_search.j;
import com.whatsapp.gif_search.j.a;
import com.whatsapp.gif_search.p;
import com.whatsapp.gif_search.r;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends p
{
  public a(ant paramant, aus paramaus)
  {
    super(paramant, paramaus);
  }
  
  static h<String, List<j>> a(String paramString)
  {
    long l = System.currentTimeMillis();
    int i;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestProperty("User-Agent", ape.a());
      localHttpURLConnection.setConnectTimeout(15000);
      localHttpURLConnection.setReadTimeout(30000);
      localHttpURLConnection.setRequestMethod("GET");
      i = localHttpURLConnection.getResponseCode();
      if (i != 200)
      {
        Log.e("gif/search/giphy/request failed " + i);
        return null;
      }
      Log.d("gif/search/giphy/data at " + paramString + " loaded in " + (System.currentTimeMillis() - l));
      locala = new com.google.a.b.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
      locala.c();
      localList = null;
      str1 = null;
      localHttpURLConnection = null;
    }
    catch (IOException localIOException)
    {
      com.google.a.b.a locala;
      List localList;
      String str1;
      String str2;
      Log.e(localIOException);
      for (;;)
      {
        return null;
        if (!str2.equals("meta")) {
          break label590;
        }
        i = 0;
        break label590;
        if (!str2.equals("pagination")) {
          break label590;
        }
        i = 1;
        break label590;
        if (!str2.equals("data")) {
          break label590;
        }
        i = 2;
        break label590;
        localh = f(locala);
        break;
        str1 = e(locala);
        break;
        localList = a(locala);
        break;
        locala.d();
        if ((localh == null) || (200 == ((Integer)localh.a).intValue())) {
          break label494;
        }
        Log.w("gif/search/giphy/got error: " + localh.a + "(" + (String)localh.b + ")");
        Log.d("gif/search/giphy/data at " + paramString + " processed in " + (System.currentTimeMillis() - l));
      }
      label494:
      if (localList != null) {
        break label541;
      }
      label541:
      for (localh = h.a(null, null);; localh = h.a(str1, localList)) {
        return localh;
      }
    }
    finally
    {
      Log.d("gif/search/giphy/data at " + paramString + " processed in " + (System.currentTimeMillis() - l));
    }
    if (locala.e())
    {
      str2 = locala.f();
      i = -1;
      switch (str2.hashCode())
      {
      }
    }
    for (;;)
    {
      Log.w("gif/search/giphy/unexpected key - " + str2);
      locala.j();
      break;
      h localh;
      label590:
      switch (i)
      {
      }
    }
  }
  
  private static List<j> a(com.google.a.b.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    label43:
    label184:
    label592:
    while (parama.e())
    {
      String str = null;
      Object localObject3 = null;
      Object localObject4 = null;
      j.a locala2 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      j.a locala1 = null;
      parama.c();
      while (parama.e())
      {
        Object localObject5 = parama.f();
        int i = -1;
        switch (((String)localObject5).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            parama.j();
            break label43;
            if (((String)localObject5).equals("id"))
            {
              i = 0;
              continue;
              if (((String)localObject5).equals("images")) {
                i = 1;
              }
            }
            break;
          }
        }
        str = parama.g();
        continue;
        parama.c();
        localObject5 = localObject1;
        Object localObject6 = localObject2;
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject4 = localObject5;
        localObject3 = localObject6;
        while (parama.e())
        {
          localObject5 = parama.f();
          i = -1;
          switch (((String)localObject5).hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              parama.j();
              break label184;
              if (((String)localObject5).equals("downsized_small"))
              {
                i = 0;
                continue;
                if (((String)localObject5).equals("fixed_width_still"))
                {
                  i = 1;
                  continue;
                  if (((String)localObject5).equals("fixed_height_still"))
                  {
                    i = 2;
                    continue;
                    if (((String)localObject5).equals("fixed_width_small_still"))
                    {
                      i = 3;
                      continue;
                      if (((String)localObject5).equals("fixed_height_small_still"))
                      {
                        i = 4;
                        continue;
                        if (((String)localObject5).equals("preview_gif")) {
                          i = 5;
                        }
                      }
                    }
                  }
                }
              }
              break;
            }
          }
          localObject1 = c(parama);
          continue;
          locala2 = b(parama);
          continue;
          localObject3 = b(parama);
          continue;
          localObject4 = b(parama);
          continue;
          locala1 = b(parama);
          continue;
          localObject2 = d(parama);
        }
        parama.d();
        localObject5 = localObject4;
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
      parama.d();
      if ((str != null) && (localObject4 != null) && (localObject3 != null))
      {
        if (((j.a)localObject3).b > ((j.a)localObject3).c) {
          if (localObject1 == null) {}
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label592;
          }
          localArrayList.add(new j(str, (j.a)localObject4, (j.a)localObject1, (j.a)localObject3, 1));
          break;
          if (locala1 != null)
          {
            localObject1 = locala1;
          }
          else
          {
            localObject1 = localObject2;
            if (locala2 != null)
            {
              do
              {
                localObject1 = locala2;
                break;
                if (locala1 != null)
                {
                  localObject1 = locala1;
                  break;
                }
                if (localObject1 != null) {
                  break;
                }
              } while (localObject2 == null);
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    parama.b();
    return localArrayList;
  }
  
  private static j.a b(com.google.a.b.a parama)
  {
    parama.c();
    int k = -1;
    int j = -1;
    String str1 = null;
    label11:
    while (parama.e())
    {
      String str2 = parama.f();
      label64:
      int i;
      switch (str2.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label11;
          if (!str2.equals("url")) {
            break label64;
          }
          i = 0;
          continue;
          if (!str2.equals("width")) {
            break label64;
          }
          i = 1;
          continue;
          if (!str2.equals("height")) {
            break label64;
          }
          i = 2;
        }
      }
      str1 = parama.g();
      continue;
      j = Integer.parseInt(parama.g());
      continue;
      k = Integer.parseInt(parama.g());
    }
    parama.d();
    if (str1 == null) {
      return null;
    }
    return new j.a(str1, j, k);
  }
  
  private static j.a c(com.google.a.b.a parama)
  {
    parama.c();
    int k = -1;
    int j = -1;
    String str1 = null;
    label11:
    while (parama.e())
    {
      String str2 = parama.f();
      label64:
      int i;
      switch (str2.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label11;
          if (!str2.equals("mp4")) {
            break label64;
          }
          i = 0;
          continue;
          if (!str2.equals("width")) {
            break label64;
          }
          i = 1;
          continue;
          if (!str2.equals("height")) {
            break label64;
          }
          i = 2;
        }
      }
      str1 = parama.g();
      continue;
      j = Integer.parseInt(parama.g());
      continue;
      k = Integer.parseInt(parama.g());
    }
    parama.d();
    if (str1 == null) {
      return null;
    }
    return new j.a(str1, j, k);
  }
  
  private static j.a d(com.google.a.b.a parama)
  {
    parama.c();
    int k = -1;
    int j = -1;
    String str1 = null;
    label11:
    while (parama.e())
    {
      String str2 = parama.f();
      label64:
      int i;
      switch (str2.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label11;
          if (!str2.equals("url")) {
            break label64;
          }
          i = 0;
          continue;
          if (!str2.equals("width")) {
            break label64;
          }
          i = 1;
          continue;
          if (!str2.equals("height")) {
            break label64;
          }
          i = 2;
        }
      }
      str1 = parama.g();
      continue;
      j = Integer.parseInt(parama.g());
      continue;
      k = Integer.parseInt(parama.g());
    }
    parama.d();
    if (str1 == null) {
      return null;
    }
    return new j.a(str1, j, k);
  }
  
  private static String e(com.google.a.b.a parama)
  {
    parama.c();
    int m = -1;
    int k = -1;
    int j = -1;
    label11:
    while (parama.e())
    {
      String str = parama.f();
      label64:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label11;
          if (!str.equals("count")) {
            break label64;
          }
          i = 0;
          continue;
          if (!str.equals("offset")) {
            break label64;
          }
          i = 1;
          continue;
          if (!str.equals("total_count")) {
            break label64;
          }
          i = 2;
        }
      }
      j = parama.i();
      continue;
      k = parama.i();
      continue;
      m = parama.i();
    }
    parama.d();
    if ((j > 0) && (k >= 0) && (m > 0))
    {
      if (m <= j + k) {
        return null;
      }
      return Integer.toString(k + j);
    }
    return null;
  }
  
  private static h<Integer, String> f(com.google.a.b.a parama)
  {
    String str1 = null;
    parama.c();
    int j = 0;
    label8:
    while (parama.e())
    {
      String str2 = parama.f();
      int i = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label8;
          if (str2.equals("status"))
          {
            i = 0;
            continue;
            if (str2.equals("msg")) {
              i = 1;
            }
          }
          break;
        }
      }
      j = parama.i();
      continue;
      str1 = parama.g();
    }
    parama.d();
    return h.a(Integer.valueOf(j), str1);
  }
  
  public final r a(final CharSequence paramCharSequence)
  {
    new r()
    {
      private void a(final String paramAnonymousString, final ab paramAnonymousab)
      {
        Log.d("gif/search/giphy/loading next search page \"" + paramAnonymousString + "\"");
        bu.a(new AsyncTask() {}, new Void[0]);
      }
      
      protected final boolean a(String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        a(paramAnonymousString, null);
        return true;
      }
    };
  }
  
  protected final r c()
  {
    new r()
    {
      private void b(final String paramAnonymousString)
      {
        Log.d("gif/search/giphy/loading next trending page \"" + paramAnonymousString + "\"");
        bu.a(new AsyncTask() {}, new Void[0]);
      }
      
      protected final boolean a(String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        b(paramAnonymousString);
        return true;
      }
    };
  }
  
  public final String d()
  {
    return "Giphy";
  }
  
  public final int e()
  {
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */