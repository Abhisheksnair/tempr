package com.whatsapp.gdrive;

import com.whatsapp.Statistics;
import com.whatsapp.Statistics.b;
import com.whatsapp.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;

final class b
  implements HttpRequestInterceptor
{
  int a;
  private final int b = 3;
  
  public final void process(HttpRequest paramHttpRequest, final HttpContext paramHttpContext)
  {
    this.a += 1;
    if ((paramHttpRequest instanceof EntityEnclosingRequestWrapper))
    {
      paramHttpContext = ((EntityEnclosingRequestWrapper)paramHttpRequest).getEntity();
      if (paramHttpContext != null) {}
    }
    while ((paramHttpRequest instanceof RequestWrapper))
    {
      return;
      long l = paramHttpContext.getContentLength();
      if (l <= 0L)
      {
        Log.e("gdrive-api/request-interceptor/process/length/" + l);
        return;
      }
      paramHttpContext = new HttpEntity()
      {
        public final void consumeContent()
        {
          paramHttpContext.consumeContent();
        }
        
        public final InputStream getContent()
        {
          new InputStream()
          {
            public final int available()
            {
              return this.a.available();
            }
            
            public final void close()
            {
              this.a.close();
            }
            
            public final void mark(int paramAnonymous2Int)
            {
              this.a.mark(paramAnonymous2Int);
            }
            
            public final boolean markSupported()
            {
              return this.a.markSupported();
            }
            
            public final int read()
            {
              int i = this.a.read();
              if (i >= 0) {
                Statistics.b(1L, b.a(b.this));
              }
              return i;
            }
            
            public final int read(byte[] paramAnonymous2ArrayOfByte)
            {
              int i = this.a.read(paramAnonymous2ArrayOfByte);
              if (i > 0) {
                Statistics.b(i, b.a(b.this));
              }
              return i;
            }
            
            public final int read(byte[] paramAnonymous2ArrayOfByte, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              paramAnonymous2Int1 = this.a.read(paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
              if (paramAnonymous2Int1 > 0) {
                Statistics.b(paramAnonymous2Int1, b.a(b.this));
              }
              return paramAnonymous2Int1;
            }
            
            public final void reset()
            {
              try
              {
                this.a.reset();
                return;
              }
              finally
              {
                localObject = finally;
                throw ((Throwable)localObject);
              }
            }
            
            public final long skip(long paramAnonymous2Long)
            {
              paramAnonymous2Long = this.a.skip(paramAnonymous2Long);
              Statistics.b(paramAnonymous2Long, b.a(b.this));
              return paramAnonymous2Long;
            }
          };
        }
        
        public final Header getContentEncoding()
        {
          return paramHttpContext.getContentEncoding();
        }
        
        public final long getContentLength()
        {
          return paramHttpContext.getContentLength();
        }
        
        public final Header getContentType()
        {
          return paramHttpContext.getContentType();
        }
        
        public final boolean isChunked()
        {
          return paramHttpContext.isChunked();
        }
        
        public final boolean isRepeatable()
        {
          return paramHttpContext.isRepeatable();
        }
        
        public final boolean isStreaming()
        {
          return paramHttpContext.isStreaming();
        }
        
        public final void writeTo(OutputStream paramAnonymousOutputStream)
        {
          paramHttpContext.writeTo(new Statistics.b(paramAnonymousOutputStream, b.a(b.this)));
        }
      };
      ((EntityEnclosingRequestWrapper)paramHttpRequest).setEntity(paramHttpContext);
      return;
    }
    Log.e("gdrive-request-interceptor/process/request-is-not-a-wrapper " + paramHttpRequest);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */