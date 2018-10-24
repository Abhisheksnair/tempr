package com.whatsapp.protocol;

import a.a.a.a.a.a.d;
import android.text.TextUtils;
import android.util.Base64;
import b.a.a.c;
import com.whatsapp.MediaData;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import com.whatsapp.va.a;
import com.whatsapp.vk;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public final class m
{
  private static final Random a = new Random();
  
  public static long a()
  {
    return ((com.whatsapp.g.j)c.a().a(com.whatsapp.g.j.class)).a();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 3);
  }
  
  public static boolean a(byte paramByte)
  {
    return (paramByte == 1) || (paramByte == 2) || (paramByte == 3) || (paramByte == 13) || (paramByte == 9);
  }
  
  public static boolean a(j paramj)
  {
    return (paramj.s == 0) && ((!TextUtils.isEmpty(paramj.z)) || (!TextUtils.isEmpty(paramj.y)));
  }
  
  public static byte[] a(va paramva)
  {
    long l;
    byte[] arrayOfByte;
    int i;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      l = a();
      arrayOfByte = new byte[8];
      i = 7;
    }
    catch (NoSuchAlgorithmException paramva)
    {
      MessageDigest localMessageDigest;
      Log.c("unable to provide message id hash due to missing md5 algorithm", paramva);
      return null;
    }
    localMessageDigest.update(arrayOfByte);
    localMessageDigest.update(paramva.c().t.getBytes());
    paramva = new byte[16];
    a.nextBytes(paramva);
    localMessageDigest.update(paramva);
    paramva = new byte[15];
    System.arraycopy(localMessageDigest.digest(), 0, paramva, 0, 15);
    return paramva;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(int)l);
      l >>= 8;
      i -= 1;
    }
  }
  
  public static String b(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      a.d.a(false, "unknown media type");
      return "WhatsApp Unknown Keys";
    case 1: 
      return "WhatsApp Image Keys";
    case 2: 
      return "WhatsApp Audio Keys";
    case 3: 
    case 13: 
      return "WhatsApp Video Keys";
    }
    return "WhatsApp Document Keys";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length << 1];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i] & 0xFF;
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static boolean b(j paramj)
  {
    if (a(paramj.s))
    {
      localMediaData = paramj.b();
      if (localMediaData == null) {
        Log.e("userActionForwardMessage/media_data is null");
      }
    }
    while (d(paramj))
    {
      MediaData localMediaData;
      return false;
      if (localMediaData.file == null)
      {
        Log.e("userActionForwardMessage/media_data.file is null");
        return false;
      }
      if (!localMediaData.file.exists())
      {
        Log.e("userActionForwardMessage/media_data.file does not exist");
        return false;
      }
      if ((localMediaData.fileSize != 0L) && (localMediaData.fileSize != localMediaData.file.length()))
      {
        Log.w("userActionForwardMessage/original_size:" + localMediaData.fileSize + " file_length:" + localMediaData.file.length());
        return false;
      }
    }
    return true;
  }
  
  public static boolean c(j paramj)
  {
    while (paramj != null)
    {
      int i;
      if ((paramj.f() != null) && (!paramj.f().a())) {
        i = 0;
      }
      while (i == 0)
      {
        return false;
        if ((paramj.g() != null) && (!paramj.g().c())) {
          i = 0;
        } else {
          i = 1;
        }
      }
      paramj = paramj.V;
    }
    return true;
  }
  
  public static boolean d(j paramj)
  {
    return (paramj != null) && (paramj.s == 16);
  }
  
  public static boolean e(j paramj)
  {
    MediaData localMediaData = paramj.b();
    return (localMediaData != null) && (vk.a(paramj)) && (!paramj.e.b) && (!localMediaData.transferred) && (localMediaData.suspiciousContent == MediaData.SUSPICIOUS_CONTENT_NO);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */