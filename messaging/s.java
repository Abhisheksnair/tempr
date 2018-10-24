package com.whatsapp.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class s
  extends FilterInputStream
{
  private boolean a;
  private int b;
  
  public s(InputStream paramInputStream)
  {
    super(paramInputStream);
    if (paramInputStream == null) {
      throw new NullPointerException("in may not be null");
    }
  }
  
  public final int available()
  {
    return 0;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  public final int read()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1024);
    byte[] arrayOfByte = localByteBuffer.array();
    for (;;)
    {
      int i = super.read();
      if (i == -1) {
        break;
      }
      String str;
      if (!this.a)
      {
        if (localByteBuffer.remaining() == 0) {
          throw new IOException("corrupt pseudo http input [max http header length exceeded]");
        }
        localByteBuffer.put((byte)i);
        if ((localByteBuffer.position() >= 2) && (arrayOfByte[(localByteBuffer.position() - 1)] == 10) && (arrayOfByte[(localByteBuffer.position() - 2)] == 13))
        {
          if (localByteBuffer.position() == 2) {
            this.a = true;
          }
          Object localObject;
          do
          {
            do
            {
              localByteBuffer.clear();
              break;
              localObject = new String(arrayOfByte, 0, localByteBuffer.position() - 2, "UTF-8").split(":", 2);
            } while (localObject.length != 2);
            str = localObject[0].trim();
            localObject = localObject[1].trim();
          } while ((!str.equalsIgnoreCase("Transfer-Encoding")) || (((String)localObject).equalsIgnoreCase("chunked")));
          throw new IOException("Unexpect transfer encoding encountered: " + (String)localObject);
        }
      }
      else
      {
        if (this.b > 0)
        {
          this.b -= 1;
          return i;
        }
        if (localByteBuffer.remaining() == 0) {
          throw new IOException("corrupt pseudo http input [max chunk header length exceeded]");
        }
        localByteBuffer.put((byte)i);
        if ((localByteBuffer.position() >= 2) && (arrayOfByte[(localByteBuffer.position() - 1)] == 10) && (arrayOfByte[(localByteBuffer.position() - 2)] == 13))
        {
          if (localByteBuffer.position() > 2)
          {
            str = new String(arrayOfByte, 0, localByteBuffer.position() - 2, "UTF-8");
            try
            {
              this.b = Integer.parseInt(str, 16);
              if (this.b != 0) {
                break label394;
              }
              if (super.read() == -1) {
                throw new IOException("stream ended early during parse final chunk");
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              throw new IOException("chunk length " + str + " failed to parse");
            }
            if (super.read() == -1) {
              throw new IOException("stream ended early during parse final chunk");
            }
            return -1;
          }
          label394:
          localNumberFormatException.clear();
        }
      }
    }
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      int j = paramInt2;
      if (i < paramInt2)
      {
        j = read();
        if (j != -1) {
          break label38;
        }
        if (i > 0) {
          j = i;
        }
      }
      else
      {
        return j;
      }
      return -1;
      label38:
      paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
      i += 1;
    }
  }
  
  public final void reset()
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public final long skip(long paramLong)
  {
    for (long l1 = 0L;; l1 += 1L)
    {
      long l2 = paramLong;
      if (l1 < paramLong)
      {
        if (read() == -1) {
          l2 = l1;
        }
      }
      else {
        return l2;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */