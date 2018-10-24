package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.MediaStore.Images.Media;
import java.util.HashMap;

public final class o
  extends ac
  implements r
{
  static final String[] a = { "_id", "_data", "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified" };
  private static final String[] h = { "image/gif" };
  
  public o(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    super(paramContentResolver, paramUri, paramInt, paramString);
  }
  
  private String i()
  {
    if (this.f == null) {
      return "(mime_type in (?))";
    }
    return "(mime_type in (?)) AND bucket_id = ?";
  }
  
  private String[] j()
  {
    if (this.f != null)
    {
      int i = h.length;
      String[] arrayOfString = new String[i + 1];
      System.arraycopy(h, 0, arrayOfString, 0, i);
      arrayOfString[i] = this.f;
      return arrayOfString;
    }
    return h;
  }
  
  public final HashMap<String, String> a()
  {
    Object localObject1 = this.d.buildUpon().appendQueryParameter("distinct", "true").build();
    Object localObject3 = this.b;
    Object localObject4 = i();
    Object localObject5 = j();
    localObject4 = MediaStore.Images.Media.query((ContentResolver)localObject3, (Uri)localObject1, new String[] { "bucket_display_name", "bucket_id" }, (String)localObject4, (String[])localObject5, null);
    try
    {
      localObject5 = new HashMap();
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
    return MediaStore.Images.Media.query(this.b, this.d, a, i(), j(), h());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */