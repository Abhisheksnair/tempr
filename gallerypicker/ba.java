package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.whatsapp.util.ag;
import java.io.File;

public final class ba
  extends bd
  implements q
{
  private final Uri b;
  private final r c;
  private final ContentResolver d;
  private final ag e;
  private long f;
  private long g;
  private String h;
  
  public ba(r paramr, ag paramag, ContentResolver paramContentResolver, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    this.c = paramr;
    this.e = paramag;
    this.d = paramContentResolver;
    this.b = Uri.fromFile(new File(paramString1));
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramString2;
  }
  
  public final Bitmap a(int paramInt)
  {
    return this.e.a(this.a);
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
    return this.f;
  }
  
  public final String d()
  {
    if (this.h == null) {
      return "application/*";
    }
    return this.h;
  }
  
  public final long e()
  {
    return this.g;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */