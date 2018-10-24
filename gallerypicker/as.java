package com.whatsapp.gallerypicker;

import a.a.a.a.d;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;

final class as
  implements q
{
  private final Uri a;
  private final r b;
  private final ContentResolver c;
  
  as(r paramr, ContentResolver paramContentResolver, Uri paramUri)
  {
    this.b = paramr;
    this.c = paramContentResolver;
    this.a = paramUri;
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = d.a(paramInt1, paramInt2, null, null, f());
      return localBitmap;
    }
    catch (Exception localException)
    {
      Log.e("UriImage", "got exception decoding bitmap ", localException);
    }
    return null;
  }
  
  private ParcelFileDescriptor f()
  {
    try
    {
      if (this.a.getScheme().equals("file")) {
        return ParcelFileDescriptor.open(new File(this.a.getPath()), 268435456);
      }
      ParcelFileDescriptor localParcelFileDescriptor = this.c.openFileDescriptor(this.a, "r");
      return localParcelFileDescriptor;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
  
  public final Bitmap a(int paramInt)
  {
    return a(paramInt, paramInt * paramInt << 1);
  }
  
  public final Uri a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.a.getPath();
  }
  
  public final long c()
  {
    return 0L;
  }
  
  public final String d()
  {
    return "image/*";
  }
  
  public final long e()
  {
    return 0L;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */