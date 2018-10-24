package com.whatsapp.i;

import android.os.Build.VERSION;
import com.whatsapp.MediaData;
import com.whatsapp.MediaDownloadConnection;
import com.whatsapp.aic;
import com.whatsapp.ape;
import com.whatsapp.l.h;
import com.whatsapp.messaging.ar;
import com.whatsapp.util.Log;
import java.io.Closeable;
import java.lang.reflect.Constructor;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class a
{
  private static a a;
  
  public static a a(MediaData paramMediaData, URL paramURL, long paramLong1, long paramLong2, h paramh)
  {
    return new a(MediaDownloadConnection.a(paramMediaData, paramURL, paramLong1, paramLong2, paramh), (byte)0);
  }
  
  public static a a(URL paramURL, String paramString1, String paramString2)
  {
    paramURL = (HttpsURLConnection)paramURL.openConnection();
    paramURL.setSSLSocketFactory(ar.a());
    paramURL.setHostnameVerifier(new f(paramString1));
    paramURL.setConnectTimeout(15000);
    paramURL.setReadTimeout(30000);
    paramURL.setRequestMethod(paramString2);
    paramURL.setRequestProperty("Host", paramString1);
    paramURL.setRequestProperty("User-Agent", ape.a());
    paramURL.connect();
    return new a(paramURL, (byte)0);
  }
  
  public static a a()
  {
    if (((a != null) && (aic.V == 0)) || (aic.V == 1)) {}
    for (;;)
    {
      try
      {
        a = (a)Class.forName("com.whatsapp.http.okhttp.OkHttpClientFactory").getConstructor(new Class[0]).newInstance(new Object[0]);
        if (a == null) {
          a = new a();
        }
        return a;
      }
      catch (Exception localException1)
      {
        Log.d("http/client/unable to find ok http", localException1);
        continue;
      }
      if ((aic.V == 2) && (Build.VERSION.SDK_INT >= 15)) {
        try
        {
          a = (a)Class.forName("com.whatsapp.http.liger.LigerHttpClientFactory").getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception localException2)
        {
          Log.d("http/client/unable to find liger", localException2);
        }
      }
    }
  }
  
  public static d a(String paramString, d.b paramb, boolean paramBoolean)
  {
    return new d(paramString, paramb, paramBoolean);
  }
  
  public static final class a
    implements Closeable
  {
    public final HttpsURLConnection a;
    
    private a(HttpsURLConnection paramHttpsURLConnection)
    {
      this.a = paramHttpsURLConnection;
    }
    
    public final long a()
    {
      return this.a.getContentLength();
    }
    
    public final String a(String paramString)
    {
      return this.a.getHeaderField(paramString);
    }
    
    public final void close()
    {
      this.a.disconnect();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */