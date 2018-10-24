package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

public final class az
  extends bd
  implements q
{
  private final Uri b;
  private final r c;
  private final ContentResolver d;
  private long e;
  private long f;
  
  public az(r paramr, ContentResolver paramContentResolver, String paramString, long paramLong1, long paramLong2)
  {
    this.c = paramr;
    this.d = paramContentResolver;
    this.b = Uri.fromFile(new File(paramString));
    this.e = paramLong1;
    this.f = paramLong2;
  }
  
  public final Bitmap a(int paramInt)
  {
    return null;
  }
  
  public final Uri a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.b.getPath();
  }
  
  public final long c()
  {
    return this.e;
  }
  
  public final String d()
  {
    return "audio/*";
  }
  
  public final long e()
  {
    return this.f;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */