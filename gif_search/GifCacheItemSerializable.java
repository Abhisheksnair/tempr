package com.whatsapp.gif_search;

import java.io.File;
import java.io.Serializable;

public class GifCacheItemSerializable
  implements Serializable
{
  private static final long serialVersionUID = -1755176625502120361L;
  private String filePath;
  public transient byte[] thumbnail;
  String url;
  
  GifCacheItemSerializable(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.thumbnail = paramArrayOfByte;
    this.filePath = paramString1;
    this.url = paramString2;
  }
  
  public File getFile()
  {
    return new File(this.filePath);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/GifCacheItemSerializable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */