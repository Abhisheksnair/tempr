package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.whatsapp.vj;
import java.util.HashMap;

public final class be
  extends ac
{
  public static final Uri a = Uri.parse("content://com.whatsapp.provider.media/items");
  
  public be(ContentResolver paramContentResolver, String paramString, int paramInt) {}
  
  protected final q a(Cursor paramCursor)
  {
    String str = paramCursor.getString(1);
    long l = paramCursor.getLong(2);
    switch (paramCursor.getShort(5))
    {
    default: 
      return null;
    case 1: 
      return new bc(this, this.b, str, l);
    case 3: 
      return new bf(this, str, l, paramCursor.getLong(6));
    }
    return new bb(this, str, l, paramCursor.getLong(6));
  }
  
  public final HashMap<String, String> a()
  {
    return new HashMap();
  }
  
  public final void a(ContentObserver paramContentObserver)
  {
    if (this.e != null) {
      this.e.registerContentObserver(paramContentObserver);
    }
  }
  
  public final void b(ContentObserver paramContentObserver)
  {
    if (this.e != null) {
      this.e.unregisterContentObserver(paramContentObserver);
    }
  }
  
  public final void e()
  {
    g();
  }
  
  protected final Cursor f()
  {
    return this.b.query(this.d, vj.c, null, null, h());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */