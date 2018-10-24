package com.whatsapp;

import a.a.a.a.a.a.d;
import android.media.MediaPlayer;
import android.view.Surface;
import com.whatsapp.util.Log;

public final class ami
  extends MediaPlayer
{
  a a = a.a;
  private final boolean b;
  
  public ami()
  {
    this(true);
  }
  
  public ami(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private void a(a parama)
  {
    if (!this.b) {
      a.d.c();
    }
    this.a = parama;
  }
  
  public final int getCurrentPosition()
  {
    if (this.a == a.f) {
      return 1;
    }
    try
    {
      int i = super.getCurrentPosition();
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (this.a == null) {
        throw localIllegalStateException;
      }
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
    return -1;
  }
  
  public final void pause()
  {
    if ((this.a == a.a) || (this.a == a.f)) {
      return;
    }
    try
    {
      super.pause();
      a(a.e);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
  }
  
  public final void prepare()
  {
    try
    {
      super.prepare();
      a(a.c);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
  }
  
  public final void release()
  {
    super.release();
    a(a.f);
  }
  
  public final void reset()
  {
    try
    {
      super.reset();
      a(a.a);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
  }
  
  public final void setDataSource(String paramString)
  {
    try
    {
      super.setDataSource(paramString);
      a(a.b);
      return;
    }
    catch (IllegalStateException paramString)
    {
      Log.d("Illegal state " + this.a.name(), paramString);
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    try
    {
      super.setSurface(paramSurface);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (paramSurface == null) {}
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
  }
  
  public final void start()
  {
    try
    {
      super.start();
      a(a.d);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.d("Illegal state " + this.a.name(), localIllegalStateException);
    }
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ami.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */