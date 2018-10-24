package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.MediaStore.Images.Media;
import com.whatsapp.GifHelper;
import java.io.File;
import java.util.HashMap;

public final class au
  extends ac
{
  private static final String[] a = { "_id", "_data", "datetaken", "title", "mini_thumb_magic", "mime_type", "date_modified" };
  
  public au(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    super(paramContentResolver, paramUri, paramInt, paramString);
  }
  
  private String i()
  {
    if (this.f != null) {
      return "bucket_id = '" + this.f + "'";
    }
    return null;
  }
  
  protected final q a(Cursor paramCursor)
  {
    long l3 = paramCursor.getLong(0);
    String str1 = paramCursor.getString(1);
    long l2 = paramCursor.getLong(2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = paramCursor.getLong(6) * 1000L;
    }
    String str2 = paramCursor.getString(5);
    if ((str1 != null) && (GifHelper.a(new File(str1)))) {
      return new n(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1);
    }
    return new at(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1);
  }
  
  public final HashMap<String, String> a()
  {
    Object localObject1 = this.d.buildUpon().appendQueryParameter("distinct", "true").build();
    Object localObject2 = this.b;
    String str1 = i();
    String str2 = h();
    localObject1 = MediaStore.Images.Media.query((ContentResolver)localObject2, (Uri)localObject1, new String[] { "bucket_display_name", "bucket_id" }, str1, null, str2);
    try
    {
      localObject2 = new HashMap();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashMap)localObject2).put(((Cursor)localObject1).getString(1), ((Cursor)localObject1).getString(0));
      }
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    return localHashMap;
  }
  
  protected final Cursor f()
  {
    return MediaStore.Images.Media.query(this.b, this.d, a, i(), null, h());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */