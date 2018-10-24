package com.whatsapp;

import a.a.a.a.a.a.d;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.whatsapp.e.d;
import com.whatsapp.g.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public final class Statistics
{
  public static Data a;
  private static final Handler b;
  private static File c;
  private static d d;
  private static boolean e;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("stat-save", 10);
    localHandlerThread.start();
    b = new Handler(localHandlerThread.getLooper(), new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return false;
        }
        try
        {
          Statistics.a(vv.a());
          if (Statistics.a() == null) {
            Statistics.a(new d((com.whatsapp.util.a.c)a.d.a(com.whatsapp.util.a.c.a()), (aat)a.d.a(aat.a())));
          }
          Statistics.a().a(Statistics.a);
          return true;
        }
        catch (IOException paramAnonymousMessage)
        {
          for (;;)
          {
            Log.d("error saving statistics file", paramAnonymousMessage);
          }
        }
      }
    });
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {
      return;
    }
    Data localData;
    if (e)
    {
      localData = a;
      localData.rx_roaming_bytes += paramLong;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      c();
      return;
      localData = a;
      localData.rx_media_bytes += paramLong;
      continue;
      localData = a;
      localData.rx_message_service_bytes += paramLong;
      continue;
      localData = a;
      localData.rx_voip_bytes += paramLong;
      continue;
      localData = a;
      localData.rx_google_drive_bytes += paramLong;
      continue;
      localData = a;
      localData.rx_status_bytes += paramLong;
    }
  }
  
  public static void a(j paramj)
  {
    long l1 = System.currentTimeMillis() - paramj.n;
    if (l1 > 1000L)
    {
      Data localData1 = a;
      long l2 = a.rx_offline_delay;
      long l3 = a.rx_offline_msgs;
      Data localData2 = a;
      long l4 = localData2.rx_offline_msgs + 1L;
      localData2.rx_offline_msgs = l4;
      localData1.rx_offline_delay = ((l1 + l2 * l3) / l4);
    }
    if (paramj.a())
    {
      paramj = a;
      paramj.rx_statuses += 1L;
    }
    for (;;)
    {
      c();
      return;
      if (paramj.s == 0)
      {
        paramj = a;
        paramj.rx_text_msgs += 1L;
      }
      else
      {
        paramj = a;
        paramj.rx_media_msgs += 1L;
      }
    }
  }
  
  public static void a(vv paramvv)
  {
    ObjectOutputStream localObjectOutputStream;
    try
    {
      localObjectOutputStream = new ObjectOutputStream(paramvv.a(c));
      if (localObjectOutputStream == null) {
        break label38;
      }
    }
    finally
    {
      try
      {
        localObjectOutputStream.writeObject(a);
        localObjectOutputStream.close();
        return;
      }
      finally {}
      paramvv = finally;
      localObjectOutputStream = null;
    }
    localObjectOutputStream.close();
    label38:
    throw paramvv;
  }
  
  public static void a(File paramFile)
  {
    c = new File(paramFile, "statistics");
    if (!b()) {
      a = new Data(false);
    }
    new Object()
    {
      public final void onEventAsync(f paramAnonymousf)
      {
        Statistics.a(paramAnonymousf.b);
      }
    };
    Log.i("statistics " + a.toString());
  }
  
  public static void a(String paramString, byte paramByte)
  {
    if (j.c(paramString))
    {
      paramString = a;
      paramString.tx_statuses += 1L;
    }
    for (;;)
    {
      c();
      return;
      if (paramByte == 0)
      {
        paramString = a;
        paramString.tx_text_msgs += 1L;
      }
      else
      {
        paramString = a;
        paramString.tx_media_msgs += 1L;
      }
    }
  }
  
  public static void b(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {
      return;
    }
    Data localData;
    if (e)
    {
      localData = a;
      localData.tx_roaming_bytes += paramLong;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      c();
      return;
      localData = a;
      localData.tx_media_bytes += paramLong;
      continue;
      localData = a;
      localData.tx_message_service_bytes += paramLong;
      continue;
      localData = a;
      localData.tx_voip_bytes += paramLong;
      continue;
      localData = a;
      localData.tx_google_drive_bytes += paramLong;
      continue;
      localData = a;
      localData.tx_status_bytes += paramLong;
    }
  }
  
  public static void b(j paramj)
  {
    if (paramj.s == 8)
    {
      if (!paramj.e.b) {
        break label37;
      }
      paramj = a;
      paramj.tx_voip_calls += 1L;
    }
    for (;;)
    {
      c();
      return;
      label37:
      paramj = a;
      paramj.rx_voip_calls += 1L;
    }
  }
  
  public static void b(vv paramvv)
  {
    a = new Data(true);
    try
    {
      a(paramvv);
      return;
    }
    catch (IOException paramvv)
    {
      Log.d("error saving statistics file", paramvv);
    }
  }
  
  /* Error */
  private static boolean b()
  {
    // Byte code:
    //   0: getstatic 123	com/whatsapp/Statistics:c	Ljava/io/File;
    //   3: invokevirtual 234	java/io/File:exists	()Z
    //   6: ifeq +201 -> 207
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_2
    //   15: new 236	java/io/ObjectInputStream
    //   18: dup
    //   19: new 238	java/io/FileInputStream
    //   22: dup
    //   23: getstatic 123	com/whatsapp/Statistics:c	Ljava/io/File;
    //   26: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 243	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_0
    //   33: aload_0
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual 247	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   39: checkcast 10	com/whatsapp/Statistics$Data
    //   42: putstatic 61	com/whatsapp/Statistics:a	Lcom/whatsapp/Statistics$Data;
    //   45: aload_0
    //   46: invokevirtual 248	java/io/ObjectInputStream:close	()V
    //   49: iconst_1
    //   50: ireturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: astore_1
    //   56: new 154	java/lang/StringBuilder
    //   59: dup
    //   60: ldc -6
    //   62: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 256	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: astore_1
    //   77: new 10	com/whatsapp/Statistics$Data
    //   80: dup
    //   81: iconst_1
    //   82: invokespecial 151	com/whatsapp/Statistics$Data:<init>	(Z)V
    //   85: putstatic 61	com/whatsapp/Statistics:a	Lcom/whatsapp/Statistics$Data;
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 248	java/io/ObjectInputStream:close	()V
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_1
    //   99: aload_2
    //   100: astore_0
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: new 154	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 258
    //   112: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 256	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: astore_1
    //   127: new 10	com/whatsapp/Statistics$Data
    //   130: dup
    //   131: iconst_1
    //   132: invokespecial 151	com/whatsapp/Statistics$Data:<init>	(Z)V
    //   135: putstatic 61	com/whatsapp/Statistics:a	Lcom/whatsapp/Statistics$Data;
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 248	java/io/ObjectInputStream:close	()V
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_2
    //   149: aload_3
    //   150: astore_0
    //   151: aload_0
    //   152: astore_1
    //   153: new 154	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 260
    //   160: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_2
    //   164: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 256	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: astore_1
    //   175: new 10	com/whatsapp/Statistics$Data
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 151	com/whatsapp/Statistics$Data:<init>	(Z)V
    //   183: putstatic 61	com/whatsapp/Statistics:a	Lcom/whatsapp/Statistics$Data;
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 248	java/io/ObjectInputStream:close	()V
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_0
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 248	java/io/ObjectInputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_0
    //   210: goto -161 -> 49
    //   213: astore_0
    //   214: goto -118 -> 96
    //   217: astore_0
    //   218: goto -72 -> 146
    //   221: astore_0
    //   222: goto -28 -> 194
    //   225: astore_1
    //   226: goto -21 -> 205
    //   229: astore_0
    //   230: goto -33 -> 197
    //   233: astore_2
    //   234: goto -83 -> 151
    //   237: astore_2
    //   238: goto -135 -> 103
    //   241: astore_2
    //   242: goto -188 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	159	0	localObject1	Object
    //   196	10	0	localObject2	Object
    //   209	1	0	localIOException1	IOException
    //   213	1	0	localIOException2	IOException
    //   217	1	0	localIOException3	IOException
    //   221	1	0	localIOException4	IOException
    //   229	1	0	localObject3	Object
    //   12	65	1	localObject4	Object
    //   98	4	1	localInvalidClassException1	java.io.InvalidClassException
    //   104	98	1	localObject5	Object
    //   225	1	1	localIOException5	IOException
    //   14	1	2	localObject6	Object
    //   51	49	2	localClassNotFoundException1	ClassNotFoundException
    //   102	14	2	localInvalidClassException2	java.io.InvalidClassException
    //   148	16	2	localIOException6	IOException
    //   233	1	2	localIOException7	IOException
    //   237	1	2	localInvalidClassException3	java.io.InvalidClassException
    //   241	1	2	localClassNotFoundException2	ClassNotFoundException
    //   10	140	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   15	33	51	java/lang/ClassNotFoundException
    //   15	33	98	java/io/InvalidClassException
    //   15	33	148	java/io/IOException
    //   15	33	196	finally
    //   105	125	196	finally
    //   127	138	196	finally
    //   153	173	196	finally
    //   175	186	196	finally
    //   45	49	209	java/io/IOException
    //   92	96	213	java/io/IOException
    //   142	146	217	java/io/IOException
    //   190	194	221	java/io/IOException
    //   201	205	225	java/io/IOException
    //   35	45	229	finally
    //   56	75	229	finally
    //   77	88	229	finally
    //   35	45	233	java/io/IOException
    //   35	45	237	java/io/InvalidClassException
    //   35	45	241	java/lang/ClassNotFoundException
  }
  
  private static void c()
  {
    b.removeMessages(0);
    b.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public static class Data
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    final long last_reset;
    long rx_google_drive_bytes = 0L;
    long rx_media_bytes = 0L;
    long rx_media_msgs = 0L;
    long rx_message_service_bytes = 0L;
    long rx_offline_delay = 0L;
    long rx_offline_msgs = 0L;
    long rx_roaming_bytes = 0L;
    long rx_status_bytes = 0L;
    long rx_statuses = 0L;
    long rx_text_msgs = 0L;
    long rx_voip_bytes = 0L;
    long rx_voip_calls = 0L;
    long tx_google_drive_bytes = 0L;
    long tx_media_bytes = 0L;
    long tx_media_msgs = 0L;
    long tx_message_service_bytes = 0L;
    long tx_roaming_bytes = 0L;
    long tx_status_bytes = 0L;
    long tx_statuses = 0L;
    long tx_text_msgs = 0L;
    long tx_voip_bytes = 0L;
    long tx_voip_calls = 0L;
    
    Data(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.last_reset = System.currentTimeMillis();
        return;
      }
      this.last_reset = Long.MIN_VALUE;
    }
    
    public long getIncomingVoipCalls()
    {
      return this.rx_voip_calls;
    }
    
    public long getLastReset()
    {
      return this.last_reset;
    }
    
    public long getMediaBytesReceived()
    {
      return this.rx_media_bytes;
    }
    
    public long getMediaBytesSent()
    {
      return this.tx_media_bytes;
    }
    
    public long getMessageBytesReceived()
    {
      return this.rx_message_service_bytes;
    }
    
    public long getMessageBytesSent()
    {
      return this.tx_message_service_bytes;
    }
    
    public long getOutgoingVoipCalls()
    {
      return this.tx_voip_calls;
    }
    
    public long getRoamingBytesReceived()
    {
      return this.rx_roaming_bytes;
    }
    
    public long getRoamingBytesSent()
    {
      return this.tx_roaming_bytes;
    }
    
    public long getStatusBytesReceived()
    {
      return this.rx_status_bytes;
    }
    
    public long getStatusBytesSent()
    {
      return this.tx_status_bytes;
    }
    
    public long getTotalBytesReceived()
    {
      return this.rx_media_bytes + this.rx_message_service_bytes + this.rx_voip_bytes + this.rx_google_drive_bytes + this.rx_status_bytes;
    }
    
    public long getTotalBytesReceivedFromGoogleDrive()
    {
      return this.rx_google_drive_bytes;
    }
    
    public long getTotalBytesSent()
    {
      return this.tx_media_bytes + this.tx_message_service_bytes + this.tx_voip_bytes + this.tx_google_drive_bytes + this.tx_status_bytes;
    }
    
    public long getTotalBytesSentToGoogleDrive()
    {
      return this.tx_google_drive_bytes;
    }
    
    public long getTotalMediaMessagesReceived()
    {
      return this.rx_media_msgs;
    }
    
    public long getTotalMediaMessagesSent()
    {
      return this.tx_media_msgs;
    }
    
    public long getTotalMessagesReceived()
    {
      return this.rx_text_msgs + this.rx_media_msgs;
    }
    
    public long getTotalMessagesSent()
    {
      return this.tx_text_msgs + this.tx_media_msgs;
    }
    
    public long getTotalStatusesReceived()
    {
      return this.rx_statuses;
    }
    
    public long getTotalStatusesSent()
    {
      return this.tx_statuses;
    }
    
    public long getTotalTextMessagesReceived()
    {
      return this.rx_text_msgs;
    }
    
    public long getTotalTextMessagesSent()
    {
      return this.tx_text_msgs;
    }
    
    public long getTotalVoipBytes()
    {
      return this.rx_voip_bytes + this.tx_voip_bytes;
    }
    
    public long getTotalVoipCalls()
    {
      return this.tx_voip_calls + this.rx_voip_calls;
    }
    
    public long getVoipBytesReceived()
    {
      return this.rx_voip_bytes;
    }
    
    public long getVoipBytesSent()
    {
      return this.tx_voip_bytes;
    }
    
    public String toString()
    {
      return "Text Messages: " + this.tx_text_msgs + " sent, " + this.rx_text_msgs + " received / Media Messages: " + this.tx_media_msgs + " sent (" + this.tx_media_bytes + " bytes), " + this.rx_media_msgs + " received (" + this.rx_media_bytes + " bytes) / Offline Messages: " + this.rx_offline_msgs + " received (" + this.rx_offline_delay + " msec average delay) / Status : " + this.tx_statuses + " sent (" + this.tx_status_bytes + " bytes), " + this.rx_statuses + " received (" + this.rx_status_bytes + " bytes) / Message Service: " + this.tx_message_service_bytes + " bytes sent, " + this.rx_message_service_bytes + " bytes received / Voip Calls: " + this.tx_voip_calls + " outgoing calls, " + this.rx_voip_calls + " incoming calls, " + this.tx_voip_bytes + " bytes sent, " + this.rx_voip_bytes + " bytes received / Google Drive: " + this.tx_google_drive_bytes + " bytes sent, " + this.rx_google_drive_bytes + " bytes received / Roaming: " + this.tx_roaming_bytes + " bytes sent, " + this.rx_roaming_bytes + " bytes received / Total Data: " + getTotalBytesSent() + " bytes sent, " + getTotalBytesReceived() + " bytes received";
    }
  }
  
  public static final class a
    extends InputStream
  {
    final int a;
    final InputStream b;
    
    public a(InputStream paramInputStream, int paramInt)
    {
      this.b = paramInputStream;
      this.a = paramInt;
    }
    
    public final void mark(int paramInt)
    {
      Log.w("mark called in MessageInputStream");
    }
    
    public final boolean markSupported()
    {
      return false;
    }
    
    public final int read()
    {
      int i = this.b.read();
      if (i != -1) {
        Statistics.a(1L, this.a);
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte)
    {
      int i = this.b.read(paramArrayOfByte);
      if (i > 0) {
        Statistics.a(i, this.a);
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        Statistics.a(paramInt1, this.a);
      }
      return paramInt1;
    }
    
    public final void reset()
    {
      try
      {
        Log.w("reset called in MessageInputStream");
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final long skip(long paramLong)
    {
      paramLong = this.b.skip(paramLong);
      Statistics.a(paramLong, this.a);
      return paramLong;
    }
  }
  
  public static final class b
    extends FilterOutputStream
  {
    final int a;
    
    public b(OutputStream paramOutputStream, int paramInt)
    {
      super();
      this.a = paramInt;
    }
    
    public final void write(int paramInt)
    {
      super.write(paramInt);
      Statistics.b(1L, this.a);
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      super.write(paramArrayOfByte);
      Statistics.b(paramArrayOfByte.length, this.a);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      Statistics.b(paramInt2, this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Statistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */