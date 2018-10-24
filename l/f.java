package com.whatsapp.l;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.whatsapp.atv;

public final class f
{
  private static f d;
  public final atv a;
  public byte[] b;
  public boolean c;
  
  private f(atv paramatv)
  {
    this.a = paramatv;
  }
  
  public static f a()
  {
    if (d == null) {
      d = new f(atv.a());
    }
    return d;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 256) {
      throw new IllegalArgumentException("The routing info should be smaller than 256 bytes.");
    }
    atv localatv = this.a;
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 3);
    localatv.c().putString("routing_info", paramArrayOfByte).apply();
  }
  
  public final byte[] b()
  {
    byte[] arrayOfByte = null;
    String str = this.a.a.getString("routing_info", null);
    if (!TextUtils.isEmpty(str)) {
      arrayOfByte = Base64.decode(str, 3);
    }
    this.b = arrayOfByte;
    return this.b;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */