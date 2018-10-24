package com.whatsapp.data;

import a.a.a.a.d;
import com.whatsapp.r;
import com.whatsapp.util.Log;
import com.whatsapp.util.r.b;
import com.whatsapp.va;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

public final class cd
  extends DigestOutputStream
{
  boolean a = false;
  private long d = 0L;
  
  public cd(OutputStream paramOutputStream, MessageDigest paramMessageDigest, va paramva, r.b paramb)
  {
    super(paramOutputStream, paramMessageDigest);
  }
  
  public final void close()
  {
    if (this.a)
    {
      Log.i("msgstore-integrity-checker/get-output-stream/close/already-closed");
      return;
    }
    flush();
    byte[] arrayOfByte = getMessageDigest().digest();
    Log.i("msgstore-integrity-checker/get-output-stream/close/writing-digest " + r.c(arrayOfByte) + " bytes written = " + this.d);
    Object localObject2 = this.b;
    Object localObject1 = this.c;
    if (localObject1 == r.b.j)
    {
      Log.i("msgstore-integrity-checker/get-jid-suffix/crypt10/no-jid-digits");
      localObject1 = null;
    }
    for (;;)
    {
      d.a(this, new cf(arrayOfByte, (byte[])localObject1));
      super.close();
      this.a = true;
      return;
      if ((localObject1 != r.b.k) && (localObject1 != r.b.l)) {
        break;
      }
      localObject1 = new byte[4];
      Arrays.fill((byte[])localObject1, (byte)45);
      if (((va)localObject2).b == null)
      {
        Log.e("msgstore-integrity-checker/get-jid-suffix App.me is null");
      }
      else
      {
        localObject2 = ((va)localObject2).b();
        if (localObject2 == null)
        {
          Log.e("msgstore-integrity-checker/get-jid-suffix App.me.jabber_id is null");
        }
        else if (((String)localObject2).length() < 2)
        {
          Log.e("msgstore-integrity-checker/get-jid-suffix/unexpected-phone-number " + (String)localObject2 + " it has less than 2 digits");
        }
        else
        {
          System.arraycopy(((String)localObject2).getBytes(), ((String)localObject2).length() - 2, localObject1, 2, 2);
          Log.i("msgstore-integrity-checker/get-jid-suffix " + (String)localObject2 + " suffix: " + new String((byte[])localObject1));
        }
      }
    }
    throw new IllegalArgumentException("msgstore-integrity-checker/get-jid-suffix/" + localObject1);
  }
  
  public final void write(int paramInt)
  {
    super.write(paramInt);
    this.d += 1L;
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    this.d += paramInt2 - paramInt1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */