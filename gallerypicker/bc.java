package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

public final class bc
  extends bd
  implements q
{
  private as b;
  private long c;
  
  public bc(r paramr, ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    this.b = new as(paramr, paramContentResolver, Uri.fromFile(new File(paramString)));
    this.c = paramLong;
  }
  
  public final Bitmap a(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public final Uri a()
  {
    return this.b.a();
  }
  
  public final String b()
  {
    return this.b.b();
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final String d()
  {
    return this.b.d();
  }
  
  public final long e()
  {
    return 0L;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */