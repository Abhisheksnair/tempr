package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.whatsapp.GifHelper;
import com.whatsapp.pj;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

final class c
  extends ac
  implements r
{
  private static final String[] a = { "_id", "_data", "mime_type", "media_type", "date_modified", "datetaken", "orientation" };
  
  c(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    super(paramContentResolver, paramUri, paramInt, paramString);
  }
  
  private String i()
  {
    if (this.f == null) {
      return "media_type in (1, 3)";
    }
    return "media_type in (1, 3) and bucket_id=?";
  }
  
  private String[] j()
  {
    if (this.f == null) {
      return null;
    }
    return new String[] { this.f };
  }
  
  protected final q a(Cursor paramCursor)
  {
    int j = 1;
    k = 0;
    long l3 = paramCursor.getLong(0);
    String str1 = paramCursor.getString(1);
    long l2 = paramCursor.getLong(5);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = paramCursor.getLong(4) * 1000L;
    }
    String str2 = paramCursor.getString(2);
    i = paramCursor.getInt(3);
    File localFile;
    if (str1 != null) {
      localFile = new File(str1);
    }
    while (i == 3) {
      if ((localFile != null) && (GifHelper.a(localFile)))
      {
        return new n(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1);
        localFile = null;
      }
      else
      {
        return new at(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1);
      }
    }
    i = k;
    if ("image/gif".equals(str2))
    {
      i = k;
      if (localFile != null)
      {
        i = k;
        if (!pj.b(localFile)) {}
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = pj.a(localFile);
        if (bool) {
          continue;
        }
        i = j;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = k;
        continue;
      }
      if (i == 0) {
        continue;
      }
      return new n(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1);
      i = 0;
    }
    return new s(this, this.b, l3, paramCursor.getPosition(), a(l3), str1, str2, l1, paramCursor.getInt(6));
  }
  
  public final HashMap<String, String> a()
  {
    Object localObject1 = this.d.buildUpon().appendQueryParameter("distinct", "true").build();
    Object localObject3 = this.b;
    Object localObject4 = i();
    Object localObject5 = j();
    localObject4 = ((ContentResolver)localObject3).query((Uri)localObject1, new String[] { "bucket_display_name", "bucket_id" }, (String)localObject4, (String[])localObject5, null);
    localObject5 = new HashMap();
    if (localObject4 == null) {
      return (HashMap<String, String>)localObject5;
    }
    try
    {
      while (((Cursor)localObject4).moveToNext())
      {
        localObject3 = ((Cursor)localObject4).getString(0);
        String str = ((Cursor)localObject4).getString(1);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((HashMap)localObject5).put(str, localObject1);
      }
    }
    finally
    {
      ((Cursor)localObject4).close();
    }
    return (HashMap<String, String>)localObject5;
  }
  
  protected final Cursor f()
  {
    return this.b.query(this.d, a, i(), j(), h());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */