package com.whatsapp.util;

import java.io.Closeable;

public class OpusPlayer
  implements Closeable
{
  private long nativeHandle;
  
  public OpusPlayer(String paramString, int paramInt)
  {
    allocateNative(paramString, paramInt);
  }
  
  private native void allocateNative(String paramString, int paramInt);
  
  private native void freeNative();
  
  public void close()
  {
    freeNative();
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.nativeHandle != 0L)
    {
      Log.d("OpusPlayer not closed before finalize");
      freeNative();
    }
  }
  
  public native long getCurrentPosition();
  
  public native long getLength();
  
  public native boolean isPlaying();
  
  public native void pause();
  
  public native void prepare();
  
  public native void resume();
  
  public native void seek(long paramLong);
  
  public native void start();
  
  public native void stop();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/OpusPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */