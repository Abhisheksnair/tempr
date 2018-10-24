package com.whatsapp.messaging;

import android.net.SSLSessionCache;
import com.whatsapp.util.Log;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

final class ad
  extends a
{
  private static final TrustManager[] a = { new X509TrustManager()
  {
    public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  } };
  private static ad b = new ad();
  
  public static ad a()
  {
    return b;
  }
  
  protected final SSLSocketFactory a(SSLContext paramSSLContext, SSLSessionCache paramSSLSessionCache)
  {
    try
    {
      paramSSLContext.init(null, a, null);
      paramSSLContext = paramSSLContext.getSocketFactory();
      return paramSSLContext;
    }
    catch (KeyManagementException paramSSLContext)
    {
      Log.e(paramSSLContext);
      throw new RuntimeException(paramSSLContext);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */