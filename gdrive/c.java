package com.whatsapp.gdrive;

import com.whatsapp.Statistics.a;
import com.whatsapp.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;

final class c
  implements HttpResponseInterceptor
{
  private final int a = 3;
  
  public final void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpResponse.getEntity() == null) {
      if ((RequestWrapper)paramHttpContext.getAttribute("http.request") == null) {
        Log.e("gdrive-response-interceptor/process/response-without-entity-and-request-is-null");
      }
    }
    long l;
    do
    {
      return;
      l = paramHttpResponse.getEntity().getContentLength();
      if (l > 0L) {
        break;
      }
    } while ((RequestWrapper)paramHttpContext.getAttribute("http.request") != null);
    Log.e("gdrive-response-interceptor/process/length/" + l + "/request-is-null");
    return;
    paramHttpResponse.setEntity(new HttpEntity()
    {
      public final void consumeContent()
      {
        this.a.consumeContent();
      }
      
      public final InputStream getContent()
      {
        return new Statistics.a(this.a.getContent(), c.a(c.this));
      }
      
      public final Header getContentEncoding()
      {
        return this.a.getContentEncoding();
      }
      
      public final long getContentLength()
      {
        return this.a.getContentLength();
      }
      
      public final Header getContentType()
      {
        return this.a.getContentType();
      }
      
      public final boolean isChunked()
      {
        return this.a.isChunked();
      }
      
      public final boolean isRepeatable()
      {
        return this.a.isRepeatable();
      }
      
      public final boolean isStreaming()
      {
        return this.a.isStreaming();
      }
      
      public final void writeTo(OutputStream paramAnonymousOutputStream)
      {
        InputStream localInputStream = getContent();
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i < 0) {
            break;
          }
          paramAnonymousOutputStream.write(arrayOfByte, 0, i);
        }
      }
    });
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */