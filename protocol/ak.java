package com.whatsapp.protocol;

import a.a.a.a.a.a.d;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ak
{
  public final String a;
  public final z[] b;
  public final ak[] c;
  public final byte[] d;
  
  public ak(String paramString, z[] paramArrayOfz)
  {
    this(paramString, paramArrayOfz, null, null);
  }
  
  public ak(String paramString, z[] paramArrayOfz, ak paramak) {}
  
  public ak(String paramString1, z[] paramArrayOfz, String paramString2) {}
  
  public ak(String paramString, z[] paramArrayOfz, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfz, null, paramArrayOfByte);
  }
  
  public ak(String paramString, z[] paramArrayOfz, ak[] paramArrayOfak)
  {
    this(paramString, paramArrayOfz, paramArrayOfak, null);
  }
  
  private ak(String paramString, z[] paramArrayOfz, ak[] paramArrayOfak, byte[] paramArrayOfByte)
  {
    this.a = ((String)a.d.a(paramString));
    this.b = paramArrayOfz;
    this.c = paramArrayOfak;
    this.d = paramArrayOfByte;
    if ((paramArrayOfak != null) && (paramArrayOfByte != null)) {
      throw new IllegalArgumentException("node may not have both data and children");
    }
  }
  
  public static ak a(ak paramak)
  {
    if (paramak == null) {
      throw new c("failed require. node is null");
    }
    return paramak;
  }
  
  public static void a(ak paramak, String paramString)
  {
    if (!b(paramak, paramString)) {
      throw new c("failed require. node: " + paramak + " string: " + paramString);
    }
  }
  
  public static byte[] a(ak paramak, int paramInt)
  {
    if (paramak.d == null) {
      throw new c("failed require. node " + paramak + " missing data");
    }
    if (paramak.d.length != paramInt) {
      throw new c("failed require. node " + paramak + " data length " + paramak.d.length + " != required length " + paramInt);
    }
    return paramak.d;
  }
  
  public static boolean b(ak paramak, String paramString)
  {
    return (paramak != null) && (paramak.a.equals(paramString));
  }
  
  public final int a(String paramString, int paramInt)
  {
    String str = a(paramString, null);
    if (str == null) {
      return paramInt;
    }
    try
    {
      paramInt = Integer.parseInt(str);
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new c("attribute " + paramString + " is not integral: " + str);
    }
  }
  
  public final ak a()
  {
    if ((this.c == null) || (this.c.length <= 0)) {
      return null;
    }
    return this.c[0];
  }
  
  public final String a(String paramString)
  {
    String str = a(paramString, null);
    if (str == null) {
      throw new c("required attribute '" + paramString + "' missing");
    }
    return str;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return paramString2;
      z[] arrayOfz = this.b;
      int j = arrayOfz.length;
      int i = 0;
      while (i < j)
      {
        z localz = arrayOfz[i];
        if (TextUtils.equals(paramString1, localz.a)) {
          return localz.b;
        }
        i += 1;
      }
    }
  }
  
  public final long b(String paramString, int paramInt)
  {
    String str = a(paramString, null);
    if (str == null) {
      return paramInt;
    }
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new c("attribute " + paramString + " is not integral: " + str);
    }
  }
  
  public final String b()
  {
    if (this.d != null) {
      return s.a(this.d);
    }
    return null;
  }
  
  public final String b(String paramString)
  {
    return a(paramString, null);
  }
  
  public final int c(String paramString)
  {
    String str = a(paramString);
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new c("attribute " + paramString + " is not integral: " + str);
    }
  }
  
  public final long d(String paramString)
  {
    String str = a(paramString);
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new c("attribute " + paramString + " is not integral: " + str);
    }
  }
  
  public final ak e(String paramString)
  {
    if (this.c == null) {}
    for (;;)
    {
      return null;
      ak[] arrayOfak = this.c;
      int j = arrayOfak.length;
      int i = 0;
      while (i < j)
      {
        ak localak = arrayOfak[i];
        if (TextUtils.equals(paramString, localak.a)) {
          return localak;
        }
        i += 1;
      }
    }
  }
  
  public final List<ak> f(String paramString)
  {
    Object localObject;
    if (this.c == null)
    {
      localObject = Collections.emptyList();
      return (List<ak>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    ak[] arrayOfak = this.c;
    int j = arrayOfak.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localObject = arrayOfak[i];
      if (TextUtils.equals(paramString, ((ak)localObject).a)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */