package com.whatsapp.gallerypicker;

import a.a.a.a.d;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;

public abstract class v
  implements q
{
  protected ContentResolver a;
  protected Uri b;
  protected long c;
  protected String d;
  protected final int e;
  protected String f;
  protected ac g;
  private final long h;
  
  protected v(ac paramac, ContentResolver paramContentResolver, long paramLong1, int paramInt, Uri paramUri, String paramString1, String paramString2, long paramLong2)
  {
    this.g = paramac;
    this.a = paramContentResolver;
    this.c = paramLong1;
    this.e = paramInt;
    this.b = paramUri;
    this.d = paramString1;
    this.f = paramString2;
    this.h = paramLong2;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject = this.g.a(this.c);
    if (localObject == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      localBitmap = d.a(paramInt1, paramInt2, (Uri)localObject, this.a);
      localObject = localBitmap;
    } while (localBitmap == null);
    return d.a(localBitmap, f());
  }
  
  public final Uri a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final long c()
  {
    return this.h;
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final long e()
  {
    return 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof v))) {
      return false;
    }
    return this.b.equals(((v)paramObject).b);
  }
  
  public int f()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */