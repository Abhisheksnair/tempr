package com.whatsapp;

import android.util.Base64;
import com.whatsapp.protocol.ax;
import com.whatsapp.util.Log;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class atx
  implements ax
{
  private final SecureRandom a = new SecureRandom();
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return null;
    }
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "HmacSHA256");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(paramArrayOfByte1);
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("qr hmac fail " + paramArrayOfByte1);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte3 == null)) {
      return null;
    }
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      localCipher.init(1, paramArrayOfByte1, new IvParameterSpec(paramArrayOfByte2));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte3);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("qr aes fail " + paramArrayOfByte1);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte3 = auj.c;
    byte[] arrayOfByte1 = auj.d;
    if ((arrayOfByte3 == null) || (arrayOfByte1 == null) || (paramArrayOfByte == null)) {
      return null;
    }
    byte[] arrayOfByte2;
    try
    {
      arrayOfByte2 = new byte[16];
      this.a.nextBytes(arrayOfByte2);
      paramArrayOfByte = a(arrayOfByte3, arrayOfByte2, paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        Log.e("qr encrypt aes fail");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("qr encrypt fail " + paramArrayOfByte);
      return null;
    }
    paramArrayOfByte = b(arrayOfByte2, paramArrayOfByte);
    arrayOfByte1 = a(arrayOfByte1, paramArrayOfByte);
    if (arrayOfByte1 == null)
    {
      Log.e("qr encrypt mac fail");
      return null;
    }
    paramArrayOfByte = b(arrayOfByte1, paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject1 = auj.c;
    byte[] arrayOfByte2 = auj.d;
    if ((localObject1 == null) || (arrayOfByte2 == null) || (paramArrayOfByte == null)) {
      return null;
    }
    try
    {
      arrayOfByte1 = new byte[32];
      localObject2 = new byte[paramArrayOfByte.length - 32];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 32);
      System.arraycopy(paramArrayOfByte, 32, localObject2, 0, localObject2.length);
      paramArrayOfByte = a(arrayOfByte2, (byte[])localObject2);
      if (paramArrayOfByte == null)
      {
        Log.e("qr decrypt mac fail");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("qr decrypt fail " + paramArrayOfByte);
      return null;
    }
    if (!MessageDigest.isEqual(arrayOfByte1, paramArrayOfByte))
    {
      Log.e("qr decrypt hmac mismatch " + Base64.encodeToString(arrayOfByte1, 2) + ' ' + Base64.encodeToString(paramArrayOfByte, 2));
      return null;
    }
    paramArrayOfByte = new byte[16];
    byte[] arrayOfByte1 = new byte[localObject2.length - 16];
    System.arraycopy(localObject2, 0, paramArrayOfByte, 0, 16);
    System.arraycopy(localObject2, 16, arrayOfByte1, 0, arrayOfByte1.length);
    localObject1 = new SecretKeySpec((byte[])localObject1, "AES");
    Object localObject2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
    ((Cipher)localObject2).init(2, (Key)localObject1, new IvParameterSpec(paramArrayOfByte));
    paramArrayOfByte = ((Cipher)localObject2).doFinal(arrayOfByte1);
    return paramArrayOfByte;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */