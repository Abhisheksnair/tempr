package com.whatsapp;

import java.nio.ByteBuffer;

public class VideoFrameConverter
{
  int a = create();
  
  private static native void configure(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  private static native void convertFrame(int paramInt, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  private static native int create();
  
  static native void release(int paramInt);
  
  public static native void setLogFilePath(String paramString);
  
  private static native void setOverlay(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    configure(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public final void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    setOverlay(this.a, paramByteBuffer, 0, 0, paramInt1, paramInt2);
  }
  
  public final void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    convertFrame(this.a, paramByteBuffer1, paramByteBuffer2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VideoFrameConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */