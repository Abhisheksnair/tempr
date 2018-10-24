package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import java.util.HashMap;

public final class aq
  implements r
{
  private q a;
  private Uri b;
  
  public aq(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.b = paramUri;
    this.a = new as(this, paramContentResolver, paramUri);
  }
  
  public final HashMap<String, String> a()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void a(ContentObserver paramContentObserver) {}
  
  public final int b()
  {
    return 1;
  }
  
  public final q b(int paramInt)
  {
    if (paramInt == 0) {
      return this.a;
    }
    return null;
  }
  
  public final void b(ContentObserver paramContentObserver) {}
  
  public final boolean c()
  {
    return false;
  }
  
  public final void d()
  {
    this.a = null;
    this.b = null;
  }
  
  public final void e() {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */