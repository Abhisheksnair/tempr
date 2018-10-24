package com.whatsapp;

import com.whatsapp.data.ad;
import com.whatsapp.jobqueue.job.SendReadReceiptJob;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class ado
{
  public j.b a;
  public String b;
  public String[] c;
  public int d = 0;
  
  public static void a(att paramatt, ad paramad, Collection<j> paramCollection)
  {
    Object localObject3 = new HashMap();
    Iterator localIterator = paramCollection.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.s == 11)
      {
        Log.i("skipping read receipt due to decryption failure; message.key=" + localj.e);
      }
      else
      {
        a locala = new a(localj.e.a, localj.f);
        localObject2 = (ArrayList)((HashMap)localObject3).get(locala);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          ((HashMap)localObject3).put(locala, localObject1);
        }
        ((ArrayList)localObject1).add(localj.e.c);
      }
    }
    Object localObject1 = ((HashMap)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (String[])((ArrayList)((Map.Entry)localObject2).getValue()).toArray(new String[((ArrayList)((Map.Entry)localObject2).getValue()).size()]);
      paramatt.a(new SendReadReceiptJob(((a)((Map.Entry)localObject2).getKey()).a, ((a)((Map.Entry)localObject2).getKey()).b, (String[])localObject3, -1L));
    }
    paramatt = new HashMap();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject1 = (j)paramCollection.next();
      localObject2 = (Long)paramatt.get(((j)localObject1).e.a);
      if (localObject2 == null) {
        paramatt.put(((j)localObject1).e.a, Long.valueOf(((j)localObject1).Q));
      } else {
        paramatt.put(((j)localObject1).e.a, Long.valueOf(Math.max(((Long)localObject2).longValue(), ((j)localObject1).Q)));
      }
    }
    paramatt = paramatt.entrySet().iterator();
    while (paramatt.hasNext())
    {
      paramCollection = (Map.Entry)paramatt.next();
      paramad.a((String)paramCollection.getKey(), ((Long)paramCollection.getValue()).longValue());
    }
  }
  
  public static void a(ad paramad, att paramatt, j paramj)
  {
    String str1 = paramj.e.a;
    String str2 = paramj.f;
    String str3 = paramj.e.c;
    long l = paramj.n;
    paramatt.a(new SendReadReceiptJob(str1, str2, new String[] { str3 }, l));
    if (!paramj.a()) {
      paramad.a(paramj.e.a, paramj.Q);
    }
  }
  
  static final class a
  {
    String a;
    String b;
    
    a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (!(paramObject instanceof a)) {
            return false;
          }
          paramObject = (a)paramObject;
          if (this.a == null)
          {
            if (((a)paramObject).a != null) {
              return false;
            }
          }
          else if (!this.a.equals(((a)paramObject).a)) {
            return false;
          }
          if (this.b != null) {
            break;
          }
        } while (((a)paramObject).b == null);
        return false;
      } while (this.b.equals(((a)paramObject).b));
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      int i;
      if (this.a == null)
      {
        i = 0;
        if (this.b != null) {
          break label39;
        }
      }
      for (;;)
      {
        return (i + 31) * 31 + j;
        i = this.a.hashCode();
        break;
        label39:
        j = this.b.hashCode();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ado.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */