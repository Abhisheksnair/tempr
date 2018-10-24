package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public final class ly
{
  private static boolean a = false;
  private static ArrayList<a> b;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int k = 1;
    b();
    Object localObject = b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.c == paramInt1)
      {
        if ((locala.e == null) || (locala.e.length == 0))
        {
          j = 5;
          if (paramInt2 >= j) {
            break label125;
          }
          paramInt1 = -1;
        }
        label125:
        do
        {
          return paramInt1;
          paramInt1 = locala.e[0];
          i = 1;
          for (;;)
          {
            j = paramInt1;
            if (i >= locala.e.length) {
              break;
            }
            j = paramInt1;
            if (locala.e[i] < paramInt1) {
              j = locala.e[i];
            }
            i += 1;
            paramInt1 = j;
          }
          if ((locala.e != null) && (locala.e.length != 0)) {
            break label172;
          }
          j = 14;
          paramInt1 = k;
        } while (paramInt2 > j);
        if ((locala.e == null) || (locala.e.length == 0))
        {
          return 0;
          label172:
          paramInt1 = locala.e[0];
          i = 1;
          for (;;)
          {
            j = paramInt1;
            if (i >= locala.e.length) {
              break;
            }
            j = paramInt1;
            if (locala.e[i] > paramInt1) {
              j = locala.e[i];
            }
            i += 1;
            paramInt1 = j;
          }
        }
        localObject = locala.e;
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          paramInt1 = k;
          if (i >= j) {
            break;
          }
          if (localObject[i] == paramInt2) {
            return 0;
          }
          i += 1;
        }
      }
    }
    return 0;
  }
  
  public static String a(int paramInt, String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    String str;
    a locala;
    do
    {
      str = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while (locala.c != paramInt);
    paramInt = 0;
    for (;;)
    {
      str = paramString;
      if (paramInt < paramString.length())
      {
        str = paramString;
        if (locala.f != null)
        {
          int i = 0;
          int j = 0;
          while ((i < locala.f.length) && (j == 0))
          {
            if (locala.f[i].charAt(0) == paramString.charAt(paramInt)) {
              j = 1;
            }
            i += 1;
          }
          if (j != 0) {
            break label129;
          }
          str = paramString.substring(paramInt);
        }
      }
      return str;
      label129:
      paramInt += 1;
    }
  }
  
  public static String a(String paramString)
  {
    b();
    String str = null;
    Iterator localIterator = b.iterator();
    Object localObject = str;
    if (localIterator.hasNext())
    {
      localObject = (a)localIterator.next();
      if (!Integer.toString(((a)localObject).c).equals(paramString)) {
        break label73;
      }
      if (((a)localObject).j) {
        localObject = ((a)localObject).a;
      }
    }
    else
    {
      return (String)localObject;
    }
    if (str == null) {
      str = ((a)localObject).a;
    }
    label73:
    for (;;)
    {
      break;
    }
  }
  
  public static ArrayList<a> a()
  {
    b();
    return b;
  }
  
  public static a b(String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.b)) {
        return locala;
      }
    }
    return null;
  }
  
  private static void b()
  {
    if (a) {
      return;
    }
    b = new ArrayList();
    Object localObject = u.a().getResources().openRawResource(2131165184);
    if (localObject == null) {
      throw new IOException("countries/open");
    }
    try
    {
      BufferedReader localBufferedReader1 = new BufferedReader(new InputStreamReader((InputStream)localObject, "UTF-8"));
      localObject = localBufferedReader1.readLine();
      if (localObject == null) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        try
        {
          String[] arrayOfString = TextUtils.split((String)localObject, "\t");
          if ((arrayOfString == null) || (arrayOfString.length < 12)) {
            throw new IllegalArgumentException();
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.e("countries/load/bad-number: " + (String)localObject);
          continue;
          localUnsupportedEncodingException = localUnsupportedEncodingException;
          Log.i("countries/load/unsupported-encoding: UTF-8");
          BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader((InputStream)localObject));
          continue;
          b.add(new a(localNumberFormatException, (byte)0));
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e("countries/load/bad-line: " + (String)localObject);
        }
      }
      a = true;
    }
  }
  
  public static String c(String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a.equals(paramString)) {
        return Integer.toString(locala.c);
      }
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    
    if (paramString == null) {
      return null;
    }
    a locala;
    switch (paramString.length())
    {
    default: 
      return null;
    case 2: 
      paramString = paramString.toUpperCase(Locale.US);
      localIterator = b.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (a)localIterator.next();
      } while (!locala.b.equals(paramString));
      return Integer.toString(locala.c);
    }
    if (paramString.equals("999")) {
      return null;
    }
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      int i = 0;
      while (i < locala.d.length)
      {
        if (paramString.equals(locala.d[i])) {
          return Integer.toString(locala.c);
        }
        i += 1;
      }
    }
  }
  
  public static String e(String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a.startsWith(paramString)) {
        return locala.b;
      }
    }
    return "";
  }
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final int c;
    public final int[] d;
    public final int[] e;
    public final String[] f;
    public final String[] g;
    public final String[] h;
    public final String[] i;
    public final boolean j;
    public final String k;
    public final String l;
    
    private a(String[] paramArrayOfString)
    {
      if (paramArrayOfString.length < 12) {
        throw new IllegalArgumentException();
      }
      Object localObject1 = paramArrayOfString[0];
      String str3 = paramArrayOfString[1];
      String str4 = paramArrayOfString[2];
      String str5 = paramArrayOfString[3];
      String str2 = paramArrayOfString[4];
      String str1 = paramArrayOfString[5];
      if ((str3 == null) || (str4 == null)) {
        throw new IllegalArgumentException();
      }
      this.a = str3;
      this.b = ((String)localObject1);
      this.c = Integer.parseInt(str4);
      label138:
      label167:
      boolean bool;
      if ((str5 != null) && (str5.trim().length() > 0))
      {
        localObject1 = ly.f(str5);
        this.d = ((int[])localObject1);
        if ((str2 == null) || (str2.trim().length() <= 0)) {
          break label300;
        }
        localObject1 = ly.f(str2);
        this.e = ((int[])localObject1);
        if ((str1 == null) || (str1.trim().length() <= 0)) {
          break label305;
        }
        localObject1 = TextUtils.split(str1, ",");
        this.f = ((String[])localObject1);
        if ((paramArrayOfString[7].length() <= 0) && (paramArrayOfString[8].length() <= 0) && (paramArrayOfString[9].length() <= 0)) {
          break label310;
        }
        bool = true;
        label204:
        this.j = bool;
        if (!this.j) {
          break label315;
        }
        localObject1 = TextUtils.split(paramArrayOfString[7], ";");
        label226:
        this.g = ((String[])localObject1);
        if (!this.j) {
          break label320;
        }
      }
      label300:
      label305:
      label310:
      label315:
      label320:
      for (localObject1 = TextUtils.split(paramArrayOfString[8], ";");; localObject1 = null)
      {
        this.h = ((String[])localObject1);
        localObject1 = localObject2;
        if (this.j) {
          localObject1 = TextUtils.split(paramArrayOfString[9], ";");
        }
        this.i = ((String[])localObject1);
        this.k = paramArrayOfString[10];
        this.l = paramArrayOfString[11];
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label138;
        localObject1 = null;
        break label167;
        bool = false;
        break label204;
        localObject1 = null;
        break label226;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */