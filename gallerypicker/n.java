package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.whatsapp.util.MediaFileUtils;

public final class n
  extends v
  implements q
{
  protected n(ac paramac, ContentResolver paramContentResolver, long paramLong1, int paramInt, Uri paramUri, String paramString1, String paramString2, long paramLong2)
  {
    super(paramac, paramContentResolver, paramLong1, paramInt, paramUri, paramString1, paramString2, paramLong2);
  }
  
  public final Bitmap a(int paramInt)
  {
    return MediaFileUtils.g(b());
  }
  
  public final Bitmap a(int paramInt1, int paramInt2)
  {
    return MediaFileUtils.g(b());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */