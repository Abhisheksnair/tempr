package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.Log;
import com.whatsapp.util.MediaFileUtils;

public final class at
  extends v
  implements q
{
  protected at(ac paramac, ContentResolver paramContentResolver, long paramLong1, int paramInt, Uri paramUri, String paramString1, String paramString2, long paramLong2)
  {
    super(paramac, paramContentResolver, paramLong1, paramInt, paramUri, paramString1, paramString2, paramLong2);
  }
  
  public final Bitmap a(int paramInt)
  {
    if (paramInt < 144) {
      try
      {
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPurgeable = true;
        ((BitmapFactory.Options)localObject1).inInputShareable = true;
        localObject1 = a.a().a(this.a, this.c, 3, (BitmapFactory.Options)localObject1, true);
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = MediaFileUtils.g(this.d);
        }
        return (Bitmap)localObject3;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("Video", "miniThumbBitmap got exception", localThrowable);
          Object localObject2 = null;
        }
      }
    }
    return a(paramInt, paramInt * paramInt << 1);
  }
  
  public final Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = ThumbnailUtils.createVideoThumbnail(this.d, 1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = MediaFileUtils.g(this.d);
    }
    return localBitmap1;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof at)) && (a().equals(((at)paramObject).a()));
  }
  
  public final int hashCode()
  {
    return a().toString().hashCode();
  }
  
  public final String toString()
  {
    return "VideoObject" + this.c;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */