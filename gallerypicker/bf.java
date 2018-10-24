package com.whatsapp.gallerypicker;

import android.graphics.Bitmap;
import android.net.Uri;
import com.whatsapp.util.MediaFileUtils;
import java.io.File;

public final class bf
  extends bd
  implements q
{
  private final Uri b;
  private final r c;
  private long d;
  private long e;
  
  public bf(r paramr, String paramString, long paramLong1, long paramLong2)
  {
    this.c = paramr;
    this.b = Uri.fromFile(new File(paramString));
    this.d = paramLong1;
    this.e = paramLong2;
  }
  
  public final Bitmap a(int paramInt)
  {
    return MediaFileUtils.g(this.b.getPath());
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
    return this.d;
  }
  
  public final String d()
  {
    return "video/*";
  }
  
  public final long e()
  {
    return this.e;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */