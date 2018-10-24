package com.whatsapp;

import android.text.TextUtils;
import com.whatsapp.l.h;
import com.whatsapp.messaging.ar;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;

public class MediaDownloadConnection
{
  static
  {
    if (!MediaDownloadConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static HttpsURLConnection a(MediaData paramMediaData, URL paramURL, long paramLong1, long paramLong2, h paramh)
  {
    HttpsURLConnection localHttpsURLConnection;
    try
    {
      Object localObject = paramURL.openConnection();
      if ((localObject instanceof HttpsURLConnection))
      {
        localHttpsURLConnection = (HttpsURLConnection)localObject;
        localHttpsURLConnection.setSSLSocketFactory(ar.a());
        localHttpsURLConnection.setConnectTimeout(15000);
        localHttpsURLConnection.setReadTimeout(30000);
        localHttpsURLConnection.setRequestProperty("User-Agent", ape.a());
        localHttpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
        if (paramh != null) {
          localHttpsURLConnection.setRequestProperty("Host", paramh.a);
        }
        if (paramLong1 != 0L)
        {
          localObject = "bytes=" + paramLong1 + "-";
          paramh = (h)localObject;
          if (paramLong2 != -1L) {
            paramh = (String)localObject + paramLong2;
          }
          localHttpsURLConnection.setRequestProperty("Range", paramh);
        }
        if ((!a) && (paramMediaData == null)) {
          throw new AssertionError();
        }
      }
      else
      {
        throw new ConnectionFailureException("failed to open http url connection");
      }
    }
    catch (IOException paramMediaData)
    {
      throw new ConnectionFailureException(paramMediaData, "failed to open http url connection");
    }
    if (paramMediaData.failErrorCode >= 0)
    {
      paramMediaData = vk.d.a(paramMediaData.failErrorCode);
      if (paramMediaData != null) {
        localHttpsURLConnection.setRequestProperty("X-WA-MMS-Retry", paramMediaData.o);
      }
    }
    int i;
    try
    {
      i = localHttpsURLConnection.getResponseCode();
      if ((i == 200) || (i == 206)) {
        break label451;
      }
      Log.w("MediaDownloadConnection/download failed; url=" + MediaFileUtils.a(paramURL) + " responseCode=" + i);
      if ((i == 404) || (i == 410)) {
        throw new ConnectionFailureException(vk.d.f, "failed to download; too old");
      }
    }
    catch (IOException paramMediaData)
    {
      Log.c("MediaDownloadConnection/exception while getting response code", paramMediaData);
      if ((paramMediaData instanceof UnknownHostException)) {
        throw new ConnectionFailureException(vk.d.b, "failed with IOException while retrieving response");
      }
      if (((paramMediaData instanceof SocketTimeoutException)) || ((paramMediaData instanceof ConnectException))) {
        throw new ConnectionFailureException(vk.d.c, "failed with IOException while retrieving response");
      }
      throw new ConnectionFailureException("failed with IOException while retrieving response");
    }
    if (i == 415) {
      throw new ConnectionFailureException(vk.d.k, "failed to download; bad media");
    }
    if (i == 416)
    {
      paramMediaData = localHttpsURLConnection.getHeaderField("Content-Range");
      if ((TextUtils.isEmpty(paramMediaData)) || (!paramMediaData.startsWith("*/"))) {
        throw new ConnectionFailureException(vk.d.g, "failed to download; unable to resume download");
      }
    }
    else
    {
      throw new ConnectionFailureException(vk.d.k, "failed to download; unknown reason");
    }
    label451:
    return localHttpsURLConnection;
  }
  
  public static class ConnectionFailureException
    extends Exception
  {
    public final vk.d code;
    public Exception e;
    public final String message;
    
    public ConnectionFailureException(vk.d paramd, String paramString)
    {
      this.code = paramd;
      this.message = paramString;
    }
    
    public ConnectionFailureException(Exception paramException, String paramString)
    {
      this.e = paramException;
      this.message = paramString;
      this.code = vk.d.a;
    }
    
    public ConnectionFailureException(String paramString)
    {
      this.message = paramString;
      this.code = vk.d.a;
    }
    
    public Exception getException()
    {
      Object localObject = this;
      if (this.e != null) {
        localObject = this.e;
      }
      return (Exception)localObject;
    }
    
    public String toString()
    {
      return this.message;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaDownloadConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */