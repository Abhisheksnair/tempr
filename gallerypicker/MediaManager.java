package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.whatsapp.atu;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class MediaManager
{
  public static final String a;
  public static final String b;
  
  static
  {
    String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
    a = str;
    b = String.valueOf(str.toLowerCase().hashCode());
  }
  
  private static Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString)
  {
    if (paramContentResolver == null) {
      return null;
    }
    try
    {
      paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString, null, null, null);
      return paramContentResolver;
    }
    catch (UnsupportedOperationException paramContentResolver) {}
    return null;
  }
  
  public static MediaListParam a()
  {
    MediaListParam localMediaListParam = new MediaListParam();
    localMediaListParam.f = true;
    return localMediaListParam;
  }
  
  public static MediaListParam a(a parama, int paramInt, String paramString)
  {
    MediaListParam localMediaListParam = new MediaListParam();
    localMediaListParam.a = parama;
    localMediaListParam.b = paramInt;
    localMediaListParam.c = 2;
    localMediaListParam.d = paramString;
    return localMediaListParam;
  }
  
  public static r a(ContentResolver paramContentResolver, atu paramatu, MediaListParam paramMediaListParam)
  {
    a locala = paramMediaListParam.a;
    int j = paramMediaListParam.b;
    int k = paramMediaListParam.c;
    String str = paramMediaListParam.d;
    Uri localUri = paramMediaListParam.e;
    if ((paramMediaListParam.f) || (paramContentResolver == null)) {
      return new b((byte)0);
    }
    if (localUri != null) {
      return new aq(paramContentResolver, localUri);
    }
    paramMediaListParam = Environment.getExternalStorageState();
    int i;
    if (paramatu.b(paramMediaListParam))
    {
      i = 1;
      paramatu = new ArrayList();
      if ((i != 0) && (locala != a.b))
      {
        if ((j != 7) || (Build.VERSION.SDK_INT <= 10)) {
          break label318;
        }
        paramatu.add(new c(paramContentResolver, MediaStore.Files.getContentUri("external"), k, str));
      }
    }
    for (;;)
    {
      if ((locala == a.b) || (locala == a.d))
      {
        if ((j & 0x1) != 0) {
          paramatu.add(new t(paramContentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, k, str));
        }
        if ((j & 0x2) != 0) {
          paramatu.add(new o(paramContentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, k, str));
        }
      }
      paramContentResolver = paramatu.iterator();
      while (paramContentResolver.hasNext())
      {
        paramMediaListParam = (ac)paramContentResolver.next();
        if (paramMediaListParam.c())
        {
          paramMediaListParam.d();
          paramContentResolver.remove();
        }
      }
      if ((("mounted_ro".equals(paramMediaListParam)) && (paramatu.a("android.permission.READ_EXTERNAL_STORAGE") == 0)) || (("mounted".equals(paramMediaListParam)) && (paramatu.a("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramatu.a("android.permission.WRITE_EXTERNAL_STORAGE") == -1))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label313;
        }
        i = 1;
        break;
      }
      label313:
      i = 0;
      break;
      label318:
      if ((j & 0x1) != 0) {
        paramatu.add(new t(paramContentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, k, str));
      }
      if ((j & 0x4) != 0) {
        paramatu.add(new au(paramContentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, k, str));
      }
      if ((j & 0x2) != 0) {
        paramatu.add(new o(paramContentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, k, str));
      }
    }
    if (paramatu.size() == 1) {
      return (r)paramatu.get(0);
    }
    return new ad((r[])paramatu.toArray(new r[paramatu.size()]), k);
  }
  
  public static r a(ContentResolver paramContentResolver, atu paramatu, a parama, int paramInt, String paramString)
  {
    return a(paramContentResolver, paramatu, a(parama, paramInt, paramString));
  }
  
  public static r a(atu paramatu)
  {
    return a(null, paramatu, a());
  }
  
  public static boolean a(ContentResolver paramContentResolver)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramContentResolver = a(paramContentResolver, MediaStore.getMediaScannerUri(), new String[] { "volume" });
    if (paramContentResolver != null)
    {
      bool1 = bool2;
      if (paramContentResolver.getCount() == 1)
      {
        paramContentResolver.moveToFirst();
        bool1 = "external".equals(paramContentResolver.getString(0));
      }
      paramContentResolver.close();
    }
    return bool1;
  }
  
  public static class MediaListParam
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {};
    public MediaManager.a a;
    public int b;
    public int c;
    public String d;
    public Uri e;
    public boolean f;
    
    public MediaListParam() {}
    
    private MediaListParam(Parcel paramParcel)
    {
      this.a = MediaManager.a.values()[paramParcel.readInt()];
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readString();
      this.e = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.f = bool;
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return String.format(Locale.US, "ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%b,single=%s}", new Object[] { this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), this.d, Boolean.valueOf(this.f), this.e });
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a.ordinal());
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeParcelable(this.e, paramInt);
      if (this.f) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  static final class b
    implements r
  {
    public final HashMap<String, String> a()
    {
      return new HashMap();
    }
    
    public final void a(ContentObserver paramContentObserver) {}
    
    public final int b()
    {
      return 0;
    }
    
    public final q b(int paramInt)
    {
      return null;
    }
    
    public final void b(ContentObserver paramContentObserver) {}
    
    public final boolean c()
    {
      return true;
    }
    
    public final void d() {}
    
    public final void e() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/MediaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */