package com.whatsapp.util;

import java.io.Closeable;

public class OpusRecorder
  implements Closeable
{
  private long nativeHandle;
  
  public OpusRecorder(String paramString, int paramInt)
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
      Log.d("OpusRecorder not closed before finalize");
      freeNative();
    }
  }
  
  public native void prepare();
  
  public native void start();
  
  public native void stop();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/OpusRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */