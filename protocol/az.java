package com.whatsapp.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public final class az
{
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(8192);
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      localDeflaterOutputStream.write(paramArrayOfByte1, 0, paramInt);
      localDeflaterOutputStream.close();
      paramArrayOfByte1 = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte1;
    }
    catch (IOException paramArrayOfByte1)
    {
      throw new AssertionError(paramArrayOfByte1);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */