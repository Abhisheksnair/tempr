package com.whatsapp.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.InflaterInputStream;

public final class av
{
  private static final byte[] c = "%PDF-".getBytes();
  private static final byte[] d = "%FDF-".getBytes();
  private static final byte[] e = " obj".getBytes();
  private static final byte[] f = "endobj".getBytes();
  private static final byte[] g = "stream".getBytes();
  private static final byte[] h = "endstream".getBytes();
  private static final String[] i = { "/RichMedia", "/JS", "/JavaScript", "/AA", "/Launch", "/RichMediaInstance" };
  int a;
  public boolean b;
  private File j;
  private a k = new a((byte)0);
  
  public av(File paramFile)
  {
    this.j = paramFile;
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  private static void a(InputStream paramInputStream)
  {
    int m;
    do
    {
      for (;;)
      {
        m = paramInputStream.read();
        if (m != 92) {
          break;
        }
        paramInputStream.read();
      }
    } while ((m != 41) && (m != -1));
  }
  
  private void a(InputStream paramInputStream, boolean paramBoolean)
  {
    int m;
    if ((paramInputStream.read() != -1) && ((!paramBoolean) || (a(paramInputStream, e))))
    {
      m = d(paramInputStream);
      if (m != -1)
      {
        label33:
        if (m == -1) {
          break label408;
        }
        if ((m != 60) || (paramInputStream.read() != 60)) {}
      }
    }
    label172:
    label323:
    label387:
    label397:
    label408:
    for (Map localMap = c(paramInputStream);; localMap = null)
    {
      a(localMap);
      if (m != -1)
      {
        Object localObject1 = localMap.get("/Type");
        if (("/Pages".equals(localObject1)) && (!localMap.containsKey("/Parent")))
        {
          localObject2 = localMap.get("/Count");
          if (localObject2 != null)
          {
            localObject2 = localObject2.toString();
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).charAt(((String)localObject2).length() - 1) != 'R')) {
              break label323;
            }
            Log.i("pdfparser/indirectpagecount/" + (String)localObject2);
          }
        }
        Object localObject2 = (String)localMap.get("/Length");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).charAt(((String)localObject2).length() - 1) != 'R')) {}
        for (;;)
        {
          try
          {
            m = Integer.parseInt((String)localObject2);
            if (!"/ObjStm".equals(localObject1)) {
              break label397;
            }
            a(paramInputStream, g);
            if (paramInputStream.read() == 13) {
              paramInputStream.read();
            }
            localObject1 = new b(paramInputStream, m);
            if (!"/FlateDecode".equals(localMap.get("/Filter"))) {
              break label387;
            }
            a(new BufferedInputStream(new InflaterInputStream((InputStream)localObject1)), false);
            if (!paramBoolean) {
              break;
            }
            a(paramInputStream, f);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            Log.i("pdfparser/numberformat/" + (String)localObject2);
          }
          m = paramInputStream.read();
          break label33;
          try
          {
            this.a = Integer.parseInt((String)localObject2);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            Log.i("pdfparser/numberformat/" + (String)localObject2);
          }
          break label172;
          m = 0;
          continue;
          paramInputStream.skip(m);
          continue;
          paramInputStream.skip(m);
        }
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    paramString = b(paramString);
    String[] arrayOfString = i;
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfString[m].equals(paramString))
      {
        this.b = true;
        Log.i("pdfparser/checkname pdf contains suspicious name " + paramString);
      }
      m += 1;
    }
  }
  
  private void a(Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        a((String)((Map.Entry)localObject).getKey());
        localObject = ((Map.Entry)localObject).getValue();
        if ((localObject instanceof String)) {
          a((String)localObject);
        } else if ((localObject instanceof Map)) {
          a((Map)localObject);
        }
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 47) || (paramInt == 60) || (paramInt == 62) || (paramInt == 91) || (paramInt == 93) || (paramInt == 40) || (paramInt == 41) || (paramInt == -1);
  }
  
  private boolean a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    label151:
    label160:
    label166:
    for (int n = paramInputStream.read();; n = paramInputStream.read())
    {
      boolean bool1 = bool2;
      if (n >= 0)
      {
        a locala = this.k;
        int m = (byte)n;
        locala.a[locala.b] = m;
        locala.b += 1;
        locala.b %= locala.a.length;
        locala = this.k;
        n = 0;
        if (n >= paramArrayOfByte.length) {
          break label160;
        }
        int i2 = locala.b - n - 1;
        int i1 = i2;
        if (i2 < 0) {
          i1 = i2 + locala.a.length;
        }
        if (locala.a[i1] == paramArrayOfByte[(paramArrayOfByte.length - n - 1)]) {
          break label151;
        }
      }
      for (n = 0;; n = 1)
      {
        if (n == 0) {
          break label166;
        }
        bool1 = true;
        return bool1;
        n += 1;
        break;
      }
    }
  }
  
  private static String b(String paramString)
  {
    int m = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramString.charAt(0) != '/')) {}
    while (paramString.indexOf('#') < 0) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramString.length();
    if (m < n)
    {
      char c1 = paramString.charAt(m);
      String str;
      if ((c1 == '#') && (m <= n - 3)) {
        str = paramString.substring(m + 1, m + 3);
      }
      for (;;)
      {
        try
        {
          localStringBuilder.append((char)Integer.parseInt(str, 16));
          m += 2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localStringBuilder.append(c1);
          continue;
        }
        m += 1;
        break;
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void b(InputStream paramInputStream)
  {
    int n = d(paramInputStream);
    int m = n;
    if (n == -1) {
      return;
    }
    label13:
    if (m == 40) {
      a(paramInputStream);
    }
    for (;;)
    {
      m = paramInputStream.read();
      break label13;
      if (m == 60) {
        while (paramInputStream.read() != 62) {}
      } else if (m == 91) {
        b(paramInputStream);
      } else {
        if ((m == 93) || (m == -1)) {
          break;
        }
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 13) || (paramInt == 32);
  }
  
  private Map<String, Object> c(InputStream paramInputStream)
  {
    HashMap localHashMap = new HashMap();
    int m = d(paramInputStream);
    int n = m;
    if (b(m)) {
      n = d(paramInputStream);
    }
    if ((n != -1) && ((n != 62) || (paramInputStream.read() != 62)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      do
      {
        localStringBuilder.append((char)n);
        m = paramInputStream.read();
        if (a(m)) {
          break;
        }
        n = m;
      } while (!b(m));
      n = m;
      if (b(m)) {
        n = d(paramInputStream);
      }
      if (n != -1)
      {
        Object localObject = null;
        switch (n)
        {
        default: 
          localObject = new StringBuilder();
          m = n;
          if (n == 47)
          {
            ((StringBuilder)localObject).append((char)n);
            m = paramInputStream.read();
          }
        case 60: 
          for (;;)
          {
            if ((!a(m)) || (b(m)))
            {
              ((StringBuilder)localObject).append((char)m);
              m = paramInputStream.read();
              continue;
              n = paramInputStream.read();
              m = n;
              if (n == 60)
              {
                localObject = c(paramInputStream);
                m = paramInputStream.read();
              }
            }
          }
        }
        for (;;)
        {
          localHashMap.put(localStringBuilder.toString().trim(), localObject);
          break;
          b(paramInputStream);
          m = paramInputStream.read();
          continue;
          a(paramInputStream);
          m = paramInputStream.read();
          continue;
          localObject = ((StringBuilder)localObject).toString().trim();
        }
      }
    }
    return localHashMap;
  }
  
  private static int d(InputStream paramInputStream)
  {
    for (int m = paramInputStream.read(); b(m); m = paramInputStream.read()) {}
    return m;
  }
  
  public final void a()
  {
    this.a = 0;
    this.b = false;
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.j));
    byte[] arrayOfByte = new byte[5];
    localBufferedInputStream.read(arrayOfByte);
    if ((!Arrays.equals(arrayOfByte, c)) && (!Arrays.equals(arrayOfByte, d)))
    {
      a(localBufferedInputStream);
      throw new c();
    }
    try
    {
      a(localBufferedInputStream, true);
      return;
    }
    finally
    {
      a(localBufferedInputStream);
    }
  }
  
  static final class a
  {
    byte[] a = new byte['È'];
    int b;
  }
  
  static final class b
    extends InputStream
  {
    InputStream a;
    int b;
    
    b(InputStream paramInputStream, int paramInt)
    {
      this.a = paramInputStream;
      this.b = paramInt;
    }
    
    public final int read()
    {
      if (this.b <= 0) {
        return -1;
      }
      this.b -= 1;
      return this.a.read();
    }
  }
  
  public static final class c
    extends Exception
  {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */