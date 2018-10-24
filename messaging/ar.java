package com.whatsapp.messaging;

import a.a.a.a.d;
import android.net.SSLSessionCache;
import com.whatsapp.util.Log;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class ar
  extends a
{
  private static final X509Certificate[] a;
  private static final TrustManager[] b;
  private static ar c;
  private final AtomicReference<Socket> d;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   5: astore_0
    //   6: aload_0
    //   7: new 33	java/io/ByteArrayInputStream
    //   10: dup
    //   11: ldc 35
    //   13: ldc 37
    //   15: invokevirtual 43	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   18: invokespecial 47	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: invokevirtual 51	java/security/cert/CertificateFactory:generateCertificates	(Ljava/io/InputStream;)Ljava/util/Collection;
    //   24: astore_0
    //   25: aload_0
    //   26: aload_0
    //   27: invokeinterface 57 1 0
    //   32: anewarray 59	java/security/cert/X509Certificate
    //   35: invokeinterface 63 2 0
    //   40: checkcast 64	[Ljava/security/cert/X509Certificate;
    //   43: putstatic 66	com/whatsapp/messaging/ar:a	[Ljava/security/cert/X509Certificate;
    //   46: iconst_1
    //   47: anewarray 68	javax/net/ssl/TrustManager
    //   50: dup
    //   51: iconst_0
    //   52: new 6	com/whatsapp/messaging/ar$1
    //   55: dup
    //   56: invokespecial 70	com/whatsapp/messaging/ar$1:<init>	()V
    //   59: aastore
    //   60: putstatic 72	com/whatsapp/messaging/ar:b	[Ljavax/net/ssl/TrustManager;
    //   63: new 2	com/whatsapp/messaging/ar
    //   66: dup
    //   67: aconst_null
    //   68: invokespecial 75	com/whatsapp/messaging/ar:<init>	(Ljava/util/concurrent/atomic/AtomicReference;)V
    //   71: putstatic 77	com/whatsapp/messaging/ar:c	Lcom/whatsapp/messaging/ar;
    //   74: return
    //   75: astore_0
    //   76: new 79	java/lang/RuntimeException
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 82	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   84: athrow
    //   85: astore_0
    //   86: new 79	java/lang/RuntimeException
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 82	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   94: athrow
    //   95: astore_0
    //   96: new 84	java/lang/Error
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 85	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	22	0	localObject	Object
    //   75	6	0	localCertificateException1	CertificateException
    //   85	6	0	localCertificateException2	CertificateException
    //   95	6	0	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   0	6	75	java/security/cert/CertificateException
    //   6	46	85	java/security/cert/CertificateException
    //   6	46	95	java/io/UnsupportedEncodingException
  }
  
  public ar(AtomicReference<Socket> paramAtomicReference)
  {
    this.d = paramAtomicReference;
  }
  
  public static ar a()
  {
    return c;
  }
  
  protected final SSLSocketFactory a(final SSLContext paramSSLContext, final SSLSessionCache paramSSLSessionCache)
  {
    try
    {
      paramSSLContext.init(null, b, null);
      if (paramSSLSessionCache != null) {
        d.a(paramSSLContext, paramSSLSessionCache);
      }
      paramSSLContext = new SSLSocketFactory()
      {
        public final Socket createSocket(String paramAnonymousString, int paramAnonymousInt)
        {
          Socket localSocket = this.a.createSocket(paramAnonymousString, paramAnonymousInt);
          d.a(paramSSLContext, paramSSLSessionCache, paramAnonymousString, paramAnonymousInt);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).set(localSocket);
          }
          return localSocket;
        }
        
        public final Socket createSocket(String paramAnonymousString, int paramAnonymousInt1, InetAddress paramAnonymousInetAddress, int paramAnonymousInt2)
        {
          paramAnonymousInetAddress = this.a.createSocket(paramAnonymousString, paramAnonymousInt1, paramAnonymousInetAddress, paramAnonymousInt2);
          d.a(paramSSLContext, paramSSLSessionCache, paramAnonymousString, paramAnonymousInt1);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).set(paramAnonymousInetAddress);
          }
          return paramAnonymousInetAddress;
        }
        
        public final Socket createSocket(InetAddress paramAnonymousInetAddress, int paramAnonymousInt)
        {
          Socket localSocket = this.a.createSocket(paramAnonymousInetAddress, paramAnonymousInt);
          d.a(paramSSLContext, paramSSLSessionCache, paramAnonymousInetAddress.getHostName(), paramAnonymousInt);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).set(localSocket);
          }
          return localSocket;
        }
        
        public final Socket createSocket(InetAddress paramAnonymousInetAddress1, int paramAnonymousInt1, InetAddress paramAnonymousInetAddress2, int paramAnonymousInt2)
        {
          paramAnonymousInetAddress1 = this.a.createSocket(paramAnonymousInetAddress1, paramAnonymousInt1, paramAnonymousInetAddress2, paramAnonymousInt2);
          d.a(paramSSLContext, paramSSLSessionCache, paramAnonymousInetAddress2.getHostName(), paramAnonymousInt1);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).set(paramAnonymousInetAddress1);
          }
          return paramAnonymousInetAddress1;
        }
        
        public final Socket createSocket(Socket paramAnonymousSocket, String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          paramAnonymousSocket = this.a.createSocket(paramAnonymousSocket, paramAnonymousString, paramAnonymousInt, paramAnonymousBoolean);
          d.a(paramSSLContext, paramSSLSessionCache, paramAnonymousString, paramAnonymousInt);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).set(paramAnonymousSocket);
          }
          return paramAnonymousSocket;
        }
        
        public final String[] getDefaultCipherSuites()
        {
          return this.a.getDefaultCipherSuites();
        }
        
        public final String[] getSupportedCipherSuites()
        {
          return this.a.getSupportedCipherSuites();
        }
      };
      return paramSSLContext;
    }
    catch (KeyManagementException paramSSLContext)
    {
      Log.e(paramSSLContext);
      throw new RuntimeException(paramSSLContext);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */