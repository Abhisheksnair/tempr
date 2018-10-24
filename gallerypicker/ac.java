package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.f.f;
import com.whatsapp.util.Log;
import java.util.regex.Pattern;

public abstract class ac
  implements r
{
  private static final Pattern h = Pattern.compile("(.*)/\\d+");
  private final f<Integer, q> a = new f(512);
  protected ContentResolver b;
  protected int c;
  protected Uri d;
  protected Cursor e;
  protected String f;
  protected boolean g = false;
  
  public ac(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramUri;
    this.f = paramString;
    this.b = paramContentResolver;
    this.e = f();
    if (this.e == null) {
      Log.w("medialist/createCursor returns null");
    }
    this.a.a(0);
  }
  
  private Cursor i()
  {
    try
    {
      if (this.e == null) {
        return null;
      }
      if (this.g)
      {
        this.e.requery();
        this.g = false;
      }
      Cursor localCursor = this.e;
      return localCursor;
    }
    finally {}
  }
  
  public final Uri a(long paramLong)
  {
    try
    {
      if (ContentUris.parseId(this.d) != paramLong) {
        Log.e("medialist/id mismatch");
      }
      Uri localUri = this.d;
      return localUri;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return ContentUris.withAppendedId(this.d, paramLong);
  }
  
  protected abstract q a(Cursor paramCursor);
  
  public void a(ContentObserver paramContentObserver) {}
  
  public final int b()
  {
    Cursor localCursor = i();
    if (localCursor == null) {
      return 0;
    }
    try
    {
      int i = localCursor.getCount();
      return i;
    }
    finally {}
  }
  
  public final q b(int paramInt)
  {
    q localq = (q)this.a.a(Integer.valueOf(paramInt));
    Object localObject1 = localq;
    if (localq == null)
    {
      localObject1 = i();
      if (localObject1 == null) {
        localObject1 = null;
      }
    }
    else
    {
      return (q)localObject1;
    }
    for (;;)
    {
      try
      {
        if (((Cursor)localObject1).moveToPosition(paramInt))
        {
          localObject1 = a((Cursor)localObject1);
          if (localObject1 != null) {
            this.a.a(Integer.valueOf(paramInt), localObject1);
          }
          return (q)localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public void b(ContentObserver paramContentObserver) {}
  
  public final boolean c()
  {
    return b() == 0;
  }
  
  public final void d()
  {
    try
    {
      g();
      this.b = null;
      if (this.e != null)
      {
        this.e.close();
        this.e = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.d("medialist/exception while deactivating cursor", localIllegalStateException);
      }
    }
  }
  
  public void e() {}
  
  protected abstract Cursor f();
  
  public final void g()
  {
    if (this.e == null) {
      return;
    }
    this.e.deactivate();
    this.g = true;
  }
  
  protected final String h()
  {
    if (this.c == 1) {}
    for (String str = " ASC";; str = " DESC") {
      return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */