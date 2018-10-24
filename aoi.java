package com.whatsapp;

import a.a.a.a.a.a.d;
import com.whatsapp.data.ad;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.l;
import com.whatsapp.util.Log;
import com.whatsapp.util.au;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class aoi
{
  final List<j> a;
  final boolean b;
  j c;
  
  public aoi(List<j> paramList)
  {
    this.a = new ArrayList(paramList);
    this.c = ((j)paramList.get(0));
    if (paramList.size() > 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      t();
      return;
    }
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private j b(j.b paramb)
  {
    if (paramb == null) {
      paramb = null;
    }
    for (;;)
    {
      return paramb;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            j localj = (j)localIterator.next();
            boolean bool = paramb.equals(localj.e);
            if (bool)
            {
              paramb = localj;
              break;
            }
          }
        }
        paramb = null;
      }
      finally {}
    }
  }
  
  private void t()
  {
    MediaData localMediaData1 = this.c.b();
    if (localMediaData1 != null)
    {
      bool = true;
      a.d.a(bool, "First media data is null");
      Iterator localIterator = this.a.iterator();
      label30:
      if (!localIterator.hasNext()) {
        return;
      }
      j localj = (j)localIterator.next();
      MediaData localMediaData2 = localj.b();
      if (localMediaData2 == null) {
        break label287;
      }
      bool = true;
      label64:
      a.d.a(bool, "Media data is null");
      if (this.c.s != localj.s) {
        break label292;
      }
      bool = true;
      label87:
      a.d.a(bool, "Media type mismatch");
      if (this.c.o != localj.o) {
        break label297;
      }
      bool = true;
      label110:
      a.d.a(bool, "Origin mismatch");
      a.d.a(a(this.c.z, localj.z), "Caption mismatch");
      a.d.a(a(this.c.u, localj.u), "Hash mismatch");
      a.d.a(a(this.c.v, localj.v), "Encrypted hash mismatch");
      if (this.c.w != localj.w) {
        break label302;
      }
      bool = true;
      label193:
      a.d.a(bool, "Duration mismatch");
      a.d.a(a(this.c.r, localj.r), "Mime mismatch");
      a.d.a(a(this.c.y, localj.y), "Name mismatch");
      a.d.a(a(this.c.W, localj.W), "Multicast id mismatch");
      if (localMediaData1.forward != localMediaData2.forward) {
        break label307;
      }
    }
    label287:
    label292:
    label297:
    label302:
    label307:
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool, "Forward mismatch");
      break label30;
      bool = false;
      break;
      bool = false;
      break label64;
      bool = false;
      break label87;
      bool = false;
      break label110;
      bool = false;
      break label193;
    }
  }
  
  public final void a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).t = paramLong;
      }
    }
    finally {}
  }
  
  public final void a(ad paramad)
  {
    a(new ahf(paramad));
  }
  
  public final void a(au<j> paramau)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        paramau.a((j)localIterator.next());
      }
    }
    finally {}
  }
  
  public final void a(va paramva, int paramInt)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (!localj.a(paramva)) {
          localj.d = paramInt;
        }
      }
    }
    finally {}
  }
  
  public final void a(xf paramxf)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b().transcoder = paramxf;
      }
    }
    finally {}
  }
  
  public final void a(xg paramxg)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b().uploader = paramxg;
      }
    }
    finally {}
  }
  
  public final void a(File paramFile)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b().file = paramFile;
      }
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).u = paramString;
      }
    }
    finally {}
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        MediaData localMediaData = ((j)localIterator.next()).b();
        localMediaData.mediaKey = paramArrayOfByte1;
        localMediaData.refKey = paramArrayOfByte2;
        localMediaData.cipherKey = paramArrayOfByte3;
        localMediaData.hmacKey = paramArrayOfByte4;
        localMediaData.iv = paramArrayOfByte5;
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(oz paramoz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/whatsapp/aoi:a	Ljava/util/List;
    //   6: invokeinterface 55 1 0
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface 61 1 0
    //   18: ifeq +27 -> 45
    //   21: aload_1
    //   22: aload_3
    //   23: invokeinterface 65 1 0
    //   28: checkcast 31	com/whatsapp/protocol/j
    //   31: invokestatic 205	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/oz;Lcom/whatsapp/protocol/j;)Z
    //   34: istore_2
    //   35: iload_2
    //   36: ifeq -24 -> 12
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: iconst_0
    //   46: istore_2
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	aoi
    //   0	55	1	paramoz	oz
    //   34	13	2	bool	boolean
    //   11	12	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	12	50	finally
    //   12	35	50	finally
  }
  
  public final boolean a(j.b paramb)
  {
    try
    {
      Log.i("messagelist/remove " + paramb + " from " + j());
      boolean bool = this.a.remove(b(paramb));
      if (!this.a.isEmpty()) {
        this.c = ((j)this.a.get(0));
      }
      return bool;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final boolean a(j paramj)
  {
    return b(paramj.e) != null;
  }
  
  /* Error */
  public final boolean a(va paramva)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/whatsapp/aoi:a	Ljava/util/List;
    //   6: invokeinterface 55 1 0
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface 61 1 0
    //   18: ifeq +27 -> 45
    //   21: aload_3
    //   22: invokeinterface 65 1 0
    //   27: checkcast 31	com/whatsapp/protocol/j
    //   30: aload_1
    //   31: invokevirtual 163	com/whatsapp/protocol/j:a	(Lcom/whatsapp/va;)Z
    //   34: istore_2
    //   35: iload_2
    //   36: ifne -24 -> 12
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: iconst_0
    //   46: istore_2
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	aoi
    //   0	55	1	paramva	va
    //   34	13	2	bool	boolean
    //   11	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	12	50	finally
    //   12	35	50	finally
  }
  
  public final byte[] a()
  {
    return n().b().cipherKey;
  }
  
  public final void b(ad paramad)
  {
    a(new ahg(paramad));
  }
  
  public final void b(String paramString)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).v = paramString;
      }
    }
    finally {}
  }
  
  public final boolean b(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
        {
          MediaData localMediaData = ((j)localIterator.next()).b();
          if (localMediaData.progress != paramLong)
          {
            bool = true;
            localMediaData.progress = paramLong;
          }
        }
        else
        {
          return bool;
        }
      }
      finally {}
    }
  }
  
  public final byte[] b()
  {
    return n().b().hmacKey;
  }
  
  public final void c(String paramString)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).r = paramString;
      }
    }
    finally {}
  }
  
  public final byte[] c()
  {
    return n().b().iv;
  }
  
  public final void d(String paramString)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).y = paramString;
      }
    }
    finally {}
  }
  
  public final byte[] d()
  {
    return n().b().refKey;
  }
  
  public final void e()
  {
    try
    {
      MediaData localMediaData1 = n().b();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        MediaData localMediaData2 = ((j)localIterator.next()).b();
        localMediaData2.mediaKey = localMediaData1.mediaKey;
        localMediaData2.refKey = localMediaData1.refKey;
        localMediaData2.cipherKey = localMediaData1.cipherKey;
        localMediaData2.hmacKey = localMediaData1.hmacKey;
        localMediaData2.iv = localMediaData1.iv;
      }
    }
    finally {}
  }
  
  public final void e(String paramString)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b().uploadUrl = paramString;
      }
    }
    finally {}
  }
  
  public final void f()
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        j localj = (j)this.a.get(i);
        localj.b().uploader.a(localj, false);
        i -= 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 267	com/whatsapp/aoi:p	()I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	aoi
    //   6	2	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final File h()
  {
    return n().b().file;
  }
  
  public final void i()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b().transferring = false;
      }
    }
    finally {}
  }
  
  public final String j()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(localj.e);
      }
      str = ((StringBuilder)localObject).toString();
    }
    finally {}
    String str;
    return str;
  }
  
  public final String k()
  {
    return n().b().doodleId;
  }
  
  public final long l()
  {
    return n().b().trimFrom;
  }
  
  public final long m()
  {
    return n().b().trimTo;
  }
  
  public final j n()
  {
    try
    {
      j localj = this.c;
      return localj;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final List<l> o()
  {
    label97:
    for (;;)
    {
      j localj;
      try
      {
        if (!l.a(n().s))
        {
          localObject1 = Collections.emptyList();
          return (List<l>)localObject1;
        }
        Object localObject1 = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label97;
        }
        localj = (j)localIterator.next();
        if (localj.f() == null) {
          throw new IllegalStateException("message thumb should not be null");
        }
      }
      finally {}
      ((List)localObject2).add(localj.f());
    }
  }
  
  public final int p()
  {
    try
    {
      int i = this.a.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/whatsapp/aoi:a	Ljava/util/List;
    //   6: invokeinterface 55 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 61 1 0
    //   18: ifeq +26 -> 44
    //   21: aload_2
    //   22: invokeinterface 65 1 0
    //   27: checkcast 31	com/whatsapp/protocol/j
    //   30: invokevirtual 319	com/whatsapp/protocol/j:a	()Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq -23 -> 12
    //   38: iconst_1
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_1
    //   46: goto -6 -> 40
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	aoi
    //   33	13	1	bool	boolean
    //   11	11	2	localIterator	Iterator
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	49	finally
    //   12	34	49	finally
  }
  
  public final int r()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((j.b(localj.e.a)) && (!j.c(localj.e.a)))
        {
          int j = localj.f.split(",").length;
          i = j + 1 + i;
        }
        else
        {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  public final boolean s()
  {
    return n().b().forward;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */