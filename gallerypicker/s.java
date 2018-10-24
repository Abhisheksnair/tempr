package com.whatsapp.gallerypicker;

import a.a.a.a.d;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Thumbnails;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;

public final class s
  extends v
  implements q
{
  private static final String[] i = { "_id", "width", "height" };
  private int h;
  
  public s(ac paramac, ContentResolver paramContentResolver, long paramLong1, int paramInt1, Uri paramUri, String paramString1, String paramString2, long paramLong2, int paramInt2)
  {
    super(paramac, paramContentResolver, paramLong1, paramInt1, paramUri, paramString1, paramString2, paramLong2);
    this.h = paramInt2;
  }
  
  public final Bitmap a(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      try
      {
        Object localObject1 = new ExifInterface(this.d).getThumbnail();
        if (localObject1 == null) {
          break label469;
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject3);
        if ((((BitmapFactory.Options)localObject3).outWidth < paramInt) || (((BitmapFactory.Options)localObject3).outHeight < paramInt)) {
          break label469;
        }
        ((BitmapFactory.Options)localObject3).inSampleSize = d.a((BitmapFactory.Options)localObject3, paramInt, paramInt * paramInt << 1);
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject3).inDither = false;
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.ARGB_8888;
        ((BitmapFactory.Options)localObject3).inInputShareable = true;
        ((BitmapFactory.Options)localObject3).inPurgeable = true;
        localObject3 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject3);
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = d.a((Bitmap)localObject3, this.h);
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = a(paramInt, paramInt * paramInt << 1);
        }
        return (Bitmap)localObject3;
      }
      catch (Throwable localThrowable1)
      {
        localObject2 = null;
        continue;
      }
      int j;
      if (paramInt < 144)
      {
        try
        {
          long l = this.c;
          localObject3 = a.a().a(this.a, l, 3, null, false);
          paramInt = 0;
          int k = this.h;
          localObject2 = localObject3;
          j = paramInt;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            j = paramInt;
            if (k != 0)
            {
              localObject2 = d.a((Bitmap)localObject3, this.h);
              j = 0;
            }
          }
          localObject3 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          localObject3 = localObject2;
          if (j != 0) {
            continue;
          }
          localObject3 = localObject2;
          if (!com.whatsapp.memory.a.b()) {
            continue;
          }
          return MediaFileUtils.b((Bitmap)localObject2);
        }
        catch (Throwable localThrowable2)
        {
          Log.d("miniThumbBitmap got exception", localThrowable2);
          return null;
        }
      }
      else
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inDither = false;
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (Build.VERSION.SDK_INT <= 18)
        {
          j = 1;
          label335:
          if (j == 0) {
            break label464;
          }
          localOptions.inInputShareable = true;
          localOptions.inPurgeable = true;
        }
        label464:
        for (j = 1;; j = 0)
        {
          localObject3 = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.a, this.c, 1, i);
          if (localObject3 != null)
          {
            if (((Cursor)localObject3).moveToFirst())
            {
              localOptions.outWidth = ((Cursor)localObject3).getInt(1);
              localOptions.outHeight = ((Cursor)localObject3).getInt(2);
              localOptions.inSampleSize = d.a(localOptions, paramInt, paramInt * paramInt << 1);
            }
            ((Cursor)localObject3).close();
          }
          localObject3 = a.a().a(this.a, this.c, 1, localOptions, false);
          paramInt = j;
          break;
          j = 0;
          break label335;
        }
        label469:
        localObject3 = null;
      }
    }
  }
  
  public final int f()
  {
    return this.h;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */