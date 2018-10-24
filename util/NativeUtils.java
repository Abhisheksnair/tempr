package com.whatsapp.util;

import java.io.FileDescriptor;
import java.net.Socket;

public final class NativeUtils
{
  static {}
  
  public static native int getBytesInSocketOutputQueue(int paramInt);
  
  public static native int getFileDescriptorForFileDescriptor(FileDescriptor paramFileDescriptor);
  
  public static native int getFileDescriptorForSocket(Socket paramSocket);
  
  private static native void nativeInit();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/NativeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */