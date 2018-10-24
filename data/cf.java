package com.whatsapp.data;

import a.a.a.a.d;
import com.whatsapp.r;
import com.whatsapp.util.r.b;

public final class cf
{
  public final byte[] a;
  public final byte[] b;
  
  public cf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
  
  public static int a(r.b paramb)
  {
    switch (ce.a[paramb.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("msgstore-integrity-checker/get-backup-footer-length/unknown-encryption-format: " + paramb);
    case 1: 
      return d.b(paramb);
    case 2: 
      return d.b(paramb) + 4;
    }
    return d.b(paramb) + 4;
  }
  
  public final String toString()
  {
    return "BackupFooter [ digest=" + r.c(this.a) + " ]";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */