package com.whatsapp.i;

import a.a.a.a.a.a.d;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.whatsapp.l.h;
import com.whatsapp.messaging.ar;
import com.whatsapp.util.Log;
import com.whatsapp.util.NativeUtils;
import com.whatsapp.util.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class d
{
  protected final b a;
  protected final boolean b;
  protected final List<Pair<String, String>> c = new LinkedList();
  protected final List<Pair<String, Callable<String>>> d = new LinkedList();
  protected final List<a> e = new LinkedList();
  public final AtomicBoolean f = new AtomicBoolean();
  protected int g;
  protected long h;
  protected long i;
  protected long j = 0L;
  protected String k;
  private final String l;
  private final boolean m;
  private final List<Pair<String, String>> n = new LinkedList();
  private final AtomicReference<Socket> o = new AtomicReference();
  
  public d(String paramString, b paramb, boolean paramBoolean)
  {
    this.l = paramString;
    this.a = paramb;
    this.m = paramBoolean;
    this.b = false;
  }
  
  /* Error */
  private int a(String paramString, h paramh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokespecial 82	com/whatsapp/i/d:f	()Ljava/net/URL;
    //   7: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   10: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   13: astore 9
    //   15: invokestatic 95	com/whatsapp/av:l	()Z
    //   18: ifeq +280 -> 298
    //   21: aload_0
    //   22: getfield 73	com/whatsapp/i/d:b	Z
    //   25: ifeq +249 -> 274
    //   28: new 97	com/whatsapp/messaging/j
    //   31: dup
    //   32: aload_0
    //   33: getfield 58	com/whatsapp/i/d:o	Ljava/util/concurrent/atomic/AtomicReference;
    //   36: invokespecial 100	com/whatsapp/messaging/j:<init>	(Ljava/util/concurrent/atomic/AtomicReference;)V
    //   39: astore 7
    //   41: aload 9
    //   43: aload 7
    //   45: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   48: aload 9
    //   50: sipush 15000
    //   53: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   56: aload 9
    //   58: ldc 109
    //   60: invokevirtual 112	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   63: aload 9
    //   65: ldc 114
    //   67: invokestatic 119	com/whatsapp/ape:a	()Ljava/lang/String;
    //   70: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 9
    //   75: ldc 125
    //   77: ldc 127
    //   79: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_2
    //   83: ifnull +245 -> 328
    //   86: aload 9
    //   88: new 129	com/whatsapp/i/f
    //   91: dup
    //   92: aload_2
    //   93: getfield 133	com/whatsapp/l/h:a	Ljava/lang/String;
    //   96: invokespecial 136	com/whatsapp/i/f:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   102: aload 9
    //   104: ldc -114
    //   106: aload_2
    //   107: getfield 133	com/whatsapp/l/h:a	Ljava/lang/String;
    //   110: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   117: invokeinterface 147 1 0
    //   122: ifne +67 -> 189
    //   125: aload_0
    //   126: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   129: iconst_0
    //   130: invokeinterface 151 2 0
    //   135: checkcast 8	com/whatsapp/i/d$a
    //   138: getfield 153	com/whatsapp/i/d$a:d	J
    //   141: lconst_0
    //   142: lcmp
    //   143: ifle +46 -> 189
    //   146: aload 9
    //   148: ldc -101
    //   150: new 157	java/lang/StringBuilder
    //   153: dup
    //   154: ldc -97
    //   156: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   163: iconst_0
    //   164: invokeinterface 151 2 0
    //   169: checkcast 8	com/whatsapp/i/d$a
    //   172: getfield 153	com/whatsapp/i/d$a:d	J
    //   175: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc -90
    //   180: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 9
    //   191: iconst_1
    //   192: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   195: aload 9
    //   197: iconst_0
    //   198: invokevirtual 179	javax/net/ssl/HttpsURLConnection:setChunkedStreamingMode	(I)V
    //   201: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   204: lstore 4
    //   206: aload 9
    //   208: invokevirtual 188	javax/net/ssl/HttpsURLConnection:connect	()V
    //   211: aload_0
    //   212: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   215: lload 4
    //   217: lsub
    //   218: putfield 190	com/whatsapp/i/d:h	J
    //   221: aload_0
    //   222: aload 9
    //   224: invokevirtual 195	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   227: invokestatic 198	com/whatsapp/i/d:a	(Ljava/net/URL;)Ljava/lang/String;
    //   230: putfield 200	com/whatsapp/i/d:k	Ljava/lang/String;
    //   233: new 202	java/io/BufferedOutputStream
    //   236: dup
    //   237: aload 9
    //   239: invokevirtual 206	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   242: invokespecial 209	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   245: astore 7
    //   247: aload_0
    //   248: aload_1
    //   249: aload 7
    //   251: aload_2
    //   252: invokespecial 212	com/whatsapp/i/d:a	(Ljava/lang/String;Ljava/io/OutputStream;Lcom/whatsapp/l/h;)Z
    //   255: istore 6
    //   257: iload 6
    //   259: ifne +120 -> 379
    //   262: aload 7
    //   264: invokevirtual 217	java/io/OutputStream:close	()V
    //   267: aload 9
    //   269: invokevirtual 220	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   272: iconst_m1
    //   273: ireturn
    //   274: new 222	com/whatsapp/messaging/ar
    //   277: dup
    //   278: aload_0
    //   279: getfield 58	com/whatsapp/i/d:o	Ljava/util/concurrent/atomic/AtomicReference;
    //   282: invokespecial 223	com/whatsapp/messaging/ar:<init>	(Ljava/util/concurrent/atomic/AtomicReference;)V
    //   285: astore 7
    //   287: goto -246 -> 41
    //   290: astore_1
    //   291: aload 9
    //   293: invokevirtual 220	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   296: aload_1
    //   297: athrow
    //   298: aload_0
    //   299: getfield 73	com/whatsapp/i/d:b	Z
    //   302: ifeq +18 -> 320
    //   305: invokestatic 226	com/whatsapp/messaging/j:a	()Lcom/whatsapp/messaging/j;
    //   308: astore 7
    //   310: aload 9
    //   312: aload 7
    //   314: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   317: goto -269 -> 48
    //   320: invokestatic 229	com/whatsapp/messaging/ar:a	()Lcom/whatsapp/messaging/ar;
    //   323: astore 7
    //   325: goto -15 -> 310
    //   328: aload 9
    //   330: ldc -25
    //   332: new 157	java/lang/StringBuilder
    //   335: dup
    //   336: ldc -23
    //   338: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   341: aload_1
    //   342: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -162 -> 189
    //   354: astore_1
    //   355: aload_0
    //   356: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   359: lload 4
    //   361: lsub
    //   362: putfield 190	com/whatsapp/i/d:h	J
    //   365: aload_0
    //   366: aload 9
    //   368: invokevirtual 195	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   371: invokestatic 198	com/whatsapp/i/d:a	(Ljava/net/URL;)Ljava/lang/String;
    //   374: putfield 200	com/whatsapp/i/d:k	Ljava/lang/String;
    //   377: aload_1
    //   378: athrow
    //   379: aload 7
    //   381: invokevirtual 217	java/io/OutputStream:close	()V
    //   384: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   387: lstore 4
    //   389: aload_0
    //   390: aload 9
    //   392: invokevirtual 237	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   395: putfield 239	com/whatsapp/i/d:g	I
    //   398: aload_0
    //   399: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   402: lload 4
    //   404: lsub
    //   405: putfield 241	com/whatsapp/i/d:i	J
    //   408: aload_0
    //   409: getfield 239	com/whatsapp/i/d:g	I
    //   412: sipush 400
    //   415: if_icmplt +51 -> 466
    //   418: aload_0
    //   419: getfield 239	com/whatsapp/i/d:g	I
    //   422: istore_3
    //   423: aload 9
    //   425: invokevirtual 220	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   428: iload_3
    //   429: ireturn
    //   430: astore_2
    //   431: aload_2
    //   432: athrow
    //   433: astore_1
    //   434: aload_2
    //   435: ifnull +10 -> 445
    //   438: aload 7
    //   440: invokevirtual 217	java/io/OutputStream:close	()V
    //   443: aload_1
    //   444: athrow
    //   445: aload 7
    //   447: invokevirtual 217	java/io/OutputStream:close	()V
    //   450: goto -7 -> 443
    //   453: astore_1
    //   454: aload_0
    //   455: invokestatic 185	android/os/SystemClock:uptimeMillis	()J
    //   458: lload 4
    //   460: lsub
    //   461: putfield 241	com/whatsapp/i/d:i	J
    //   464: aload_1
    //   465: athrow
    //   466: aload 9
    //   468: invokevirtual 245	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   471: astore_2
    //   472: new 247	java/io/InputStreamReader
    //   475: dup
    //   476: new 249	java/io/BufferedInputStream
    //   479: dup
    //   480: aload 9
    //   482: invokevirtual 253	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   485: invokespecial 256	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   488: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   491: astore 7
    //   493: aload 8
    //   495: astore_1
    //   496: aload_0
    //   497: aload_2
    //   498: aload 7
    //   500: invokespecial 260	com/whatsapp/i/d:a	(Ljava/util/Map;Ljava/io/InputStreamReader;)Z
    //   503: istore 6
    //   505: iload 6
    //   507: ifne +15 -> 522
    //   510: aload 7
    //   512: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   515: aload 9
    //   517: invokevirtual 220	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   520: iconst_m1
    //   521: ireturn
    //   522: aload 7
    //   524: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   527: aload 9
    //   529: invokevirtual 220	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   532: aload_0
    //   533: getfield 239	com/whatsapp/i/d:g	I
    //   536: ireturn
    //   537: astore_2
    //   538: aload_2
    //   539: astore_1
    //   540: aload_2
    //   541: athrow
    //   542: astore_2
    //   543: aload_1
    //   544: ifnull +10 -> 554
    //   547: aload 7
    //   549: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   552: aload_2
    //   553: athrow
    //   554: aload 7
    //   556: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   559: goto -7 -> 552
    //   562: astore_2
    //   563: goto -120 -> 443
    //   566: astore_1
    //   567: goto -15 -> 552
    //   570: astore_1
    //   571: aconst_null
    //   572: astore_2
    //   573: goto -139 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	d
    //   0	576	1	paramString	String
    //   0	576	2	paramh	h
    //   422	7	3	i1	int
    //   204	255	4	l1	long
    //   255	251	6	bool	boolean
    //   39	516	7	localObject1	Object
    //   1	493	8	localObject2	Object
    //   13	515	9	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   15	41	290	finally
    //   41	48	290	finally
    //   48	82	290	finally
    //   86	189	290	finally
    //   189	206	290	finally
    //   206	233	290	finally
    //   233	247	290	finally
    //   262	267	290	finally
    //   274	287	290	finally
    //   298	310	290	finally
    //   310	317	290	finally
    //   320	325	290	finally
    //   328	351	290	finally
    //   355	379	290	finally
    //   379	389	290	finally
    //   389	408	290	finally
    //   408	423	290	finally
    //   438	443	290	finally
    //   443	445	290	finally
    //   445	450	290	finally
    //   454	466	290	finally
    //   466	493	290	finally
    //   510	515	290	finally
    //   522	527	290	finally
    //   547	552	290	finally
    //   552	554	290	finally
    //   554	559	290	finally
    //   206	233	354	java/io/IOException
    //   247	257	430	java/lang/Throwable
    //   431	433	433	finally
    //   389	408	453	java/io/IOException
    //   496	505	537	java/lang/Throwable
    //   496	505	542	finally
    //   540	542	542	finally
    //   438	443	562	java/lang/Throwable
    //   547	552	566	java/lang/Throwable
    //   247	257	570	finally
  }
  
  public static String a(URL paramURL)
  {
    if ((paramURL == null) || (paramURL.getHost() == null)) {
      return null;
    }
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost());
      return paramURL.getHostAddress();
    }
    catch (UnknownHostException paramURL) {}
    return null;
  }
  
  public static SchemeRegistry a(boolean paramBoolean)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("https", new LayeredSocketFactory()
    {
      private final SSLSocketFactory b;
      
      public final Socket connectSocket(Socket paramAnonymousSocket, String paramAnonymousString, int paramAnonymousInt1, InetAddress paramAnonymousInetAddress, int paramAnonymousInt2, HttpParams paramAnonymousHttpParams)
      {
        Socket localSocket = paramAnonymousSocket;
        if (paramAnonymousSocket == null) {
          localSocket = createSocket();
        }
        localSocket.bind(new InetSocketAddress(paramAnonymousInetAddress, paramAnonymousInt2));
        localSocket.connect(new InetSocketAddress(paramAnonymousString, paramAnonymousInt1), HttpConnectionParams.getConnectionTimeout(paramAnonymousHttpParams));
        localSocket.setSoTimeout(HttpConnectionParams.getSoTimeout(paramAnonymousHttpParams));
        return this.b.createSocket(localSocket, paramAnonymousString, paramAnonymousInt1, true);
      }
      
      public final Socket createSocket()
      {
        return this.b.createSocket();
      }
      
      public final Socket createSocket(Socket paramAnonymousSocket, String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        return this.b.createSocket(paramAnonymousSocket, paramAnonymousString, paramAnonymousInt, paramAnonymousBoolean);
      }
      
      public final boolean isSecure(Socket paramAnonymousSocket)
      {
        return paramAnonymousSocket instanceof SSLSocket;
      }
    }, 443));
    return localSchemeRegistry;
  }
  
  private static void a(String paramString1, String paramString2, OutputStream paramOutputStream)
  {
    paramOutputStream.write(("\r\n--" + paramString2 + "\r\n").getBytes());
    paramOutputStream.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n\r\ntrue").getBytes());
    paramOutputStream.write(("\r\n--" + paramString2 + "--\r\n").getBytes());
  }
  
  private boolean a(a parama, OutputStream paramOutputStream, AtomicLong paramAtomicLong, Pair<Integer, Boolean> paramPair)
  {
    int i2 = ((Integer)paramPair.first).intValue();
    boolean bool = ((Boolean)paramPair.second).booleanValue();
    for (long l1 = parama.d; l1 > 0L; l1 -= parama.a.skip(l1)) {}
    l1 = parama.d;
    paramPair = new byte['䀀'];
    int i1 = parama.a.read(paramPair);
    if (i1 != -1)
    {
      paramOutputStream.write(paramPair, 0, i1);
      l1 += i1;
      if ((this.a == null) || (bool)) {}
      for (;;)
      {
        try
        {
          i1 = NativeUtils.getBytesInSocketOutputQueue(i2);
          this.j = (l1 - i1);
          this.a.a(this.j);
          if (!Thread.currentThread().isInterrupted()) {
            break;
          }
          return false;
        }
        catch (UnsupportedOperationException localUnsupportedOperationException) {}
        i1 = 0;
      }
    }
    paramAtomicLong.set(l1);
    return true;
  }
  
  private boolean a(String paramString, OutputStream paramOutputStream)
  {
    Object localObject1 = e();
    byte[] arrayOfByte = new byte[2];
    byte[] tmp13_11 = arrayOfByte;
    tmp13_11[0] = 13;
    byte[] tmp19_13 = tmp13_11;
    tmp19_13[1] = 10;
    tmp19_13;
    Object localObject2 = this.e.iterator();
    Object localObject3;
    for (int i1 = 0; ((Iterator)localObject2).hasNext(); i1 = 1)
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (i1 != 0) {
        paramOutputStream.write(arrayOfByte);
      }
      paramOutputStream.write(("--" + paramString + "\r\n").getBytes());
      String str1 = ((a)localObject3).b.replace("\\", "\\\\").replace("\"", "\\\"");
      if (!TextUtils.isEmpty(((a)localObject3).c))
      {
        String str2 = ((a)localObject3).c.replace("\\", "\\\\").replace("\"", "\\\"");
        paramOutputStream.write(("Content-Disposition: form-data; name=\"" + str1 + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
        paramOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes());
        if (((a)localObject3).d > 0L) {
          paramOutputStream.write(("Content-Range: bytes " + ((a)localObject3).d + "-*/*\r\n").getBytes());
        }
        paramOutputStream.write(arrayOfByte);
        if (a((a)localObject3, paramOutputStream, new AtomicLong(), (Pair)localObject1)) {
          break label337;
        }
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (this.m)
          {
            b(paramString, paramOutputStream);
            return false;
            paramOutputStream.write(("Content-Disposition: form-data; name=\"" + str1 + "\"\r\n").getBytes());
            break;
            label337:
            i1 = 0;
            continue;
          }
          a("interrupt", paramString, paramOutputStream);
          return false;
        }
      }
      if (this.f.get())
      {
        b(paramString, paramOutputStream);
        return false;
      }
    }
    localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = ((String)((Pair)localObject2).first).replace("\\", "\\\\").replace("\"", "\\\"");
      if (i1 != 0) {
        paramOutputStream.write(arrayOfByte);
      }
      paramOutputStream.write(("--" + paramString + "\r\n").getBytes());
      paramOutputStream.write(("Content-Disposition: form-data; name=\"" + (String)localObject3 + "\"\r\n\r\n").getBytes());
      paramOutputStream.write(((String)((Pair)localObject2).second).getBytes());
      i1 = 1;
    }
    localObject2 = this.d.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Pair)((Iterator)localObject2).next();
      localObject3 = ((String)((Pair)localObject1).first).replace("\\", "\\\\").replace("\"", "\\\"");
      if (i1 != 0) {
        paramOutputStream.write(arrayOfByte);
      }
      paramOutputStream.write(("--" + paramString + "\r\n").getBytes());
      paramOutputStream.write(("Content-Disposition: form-data; name=\"" + (String)localObject3 + "\"\r\n\r\n").getBytes());
      try
      {
        paramOutputStream.write(((String)((Callable)((Pair)localObject1).second).call()).getBytes());
        i1 = 1;
      }
      catch (Exception paramString)
      {
        throw new IOException("failure during latePostParam call; name=" + (String)((Pair)localObject1).first, paramString);
      }
    }
    if (i1 != 0) {
      paramOutputStream.write(arrayOfByte);
    }
    paramOutputStream.write(("--" + paramString + "--\r\n").getBytes());
    return true;
  }
  
  private boolean a(String paramString, OutputStream paramOutputStream, h paramh)
  {
    if (paramh != null)
    {
      if (this.e.size() != 0)
      {
        boolean bool;
        int i1;
        if (this.e.size() == 1)
        {
          bool = true;
          a.d.a(bool, "MMS4 upload only supports a single file; we have been given " + this.e.size());
          if (a((a)this.e.get(0), paramOutputStream, new AtomicLong(), e())) {
            break label110;
          }
          i1 = 1;
          label97:
          if (i1 == 0) {
            break label116;
          }
        }
        label110:
        label116:
        while (this.f.get())
        {
          return false;
          bool = false;
          break;
          i1 = 0;
          break label97;
        }
      }
      return true;
    }
    return a(paramString, paramOutputStream);
  }
  
  private boolean a(Map<String, List<String>> paramMap, InputStreamReader paramInputStreamReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = new char[' '];
    try
    {
      boolean bool;
      do
      {
        int i1 = paramInputStreamReader.read(arrayOfChar);
        if (i1 == -1) {
          break;
        }
        localStringBuilder.append(arrayOfChar, 0, i1);
        bool = Thread.currentThread().isInterrupted();
      } while (!bool);
      return false;
    }
    catch (ProtocolException paramMap)
    {
      Log.e("httpformpost/protocol-error/response_so_far=" + localStringBuilder.toString());
      throw paramMap;
    }
    if (this.a != null) {
      this.a.a(paramMap, localStringBuilder.toString());
    }
    return true;
  }
  
  /* Error */
  private int b(String paramString, h paramh)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 490	org/apache/http/params/BasicHttpParams
    //   5: dup
    //   6: invokespecial 491	org/apache/http/params/BasicHttpParams:<init>	()V
    //   9: astore 6
    //   11: aload 6
    //   13: iconst_0
    //   14: invokestatic 497	org/apache/http/params/HttpConnectionParams:setStaleCheckingEnabled	(Lorg/apache/http/params/HttpParams;Z)V
    //   17: aload 6
    //   19: sipush 15000
    //   22: invokestatic 501	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   25: aload 6
    //   27: sipush 30000
    //   30: invokestatic 504	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   33: aload 6
    //   35: sipush 8192
    //   38: invokestatic 507	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   41: aload 6
    //   43: iconst_0
    //   44: invokestatic 512	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   47: aload 6
    //   49: invokestatic 119	com/whatsapp/ape:a	()Ljava/lang/String;
    //   52: invokestatic 518	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   55: aload 6
    //   57: ldc_w 520
    //   60: invokestatic 523	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   63: aload 6
    //   65: getstatic 529	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   68: invokestatic 533	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   71: new 535	org/apache/http/impl/client/DefaultHttpClient
    //   74: dup
    //   75: new 537	org/apache/http/impl/conn/SingleClientConnManager
    //   78: dup
    //   79: aload 6
    //   81: iconst_1
    //   82: invokestatic 539	com/whatsapp/i/d:a	(Z)Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   85: invokespecial 542	org/apache/http/impl/conn/SingleClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   88: aload 6
    //   90: invokespecial 545	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   93: astore 6
    //   95: new 547	org/apache/http/entity/EntityTemplate
    //   98: dup
    //   99: aload_0
    //   100: aload_1
    //   101: aload_2
    //   102: invokestatic 552	com/whatsapp/i/e:a	(Lcom/whatsapp/i/d;Ljava/lang/String;Lcom/whatsapp/l/h;)Lorg/apache/http/entity/ContentProducer;
    //   105: invokespecial 555	org/apache/http/entity/EntityTemplate:<init>	(Lorg/apache/http/entity/ContentProducer;)V
    //   108: astore 7
    //   110: aload 7
    //   112: iconst_1
    //   113: invokevirtual 558	org/apache/http/entity/EntityTemplate:setChunked	(Z)V
    //   116: new 560	org/apache/http/client/methods/HttpPost
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 82	com/whatsapp/i/d:f	()Ljava/net/URL;
    //   124: invokevirtual 561	java/net/URL:toString	()Ljava/lang/String;
    //   127: invokespecial 562	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   130: astore 8
    //   132: aload 8
    //   134: ldc 125
    //   136: ldc 127
    //   138: invokevirtual 565	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_2
    //   142: ifnull +119 -> 261
    //   145: aload 8
    //   147: ldc -114
    //   149: aload_2
    //   150: getfield 133	com/whatsapp/l/h:a	Ljava/lang/String;
    //   153: invokevirtual 565	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_0
    //   157: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   160: invokeinterface 147 1 0
    //   165: ifne +67 -> 232
    //   168: aload_0
    //   169: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   172: iconst_0
    //   173: invokeinterface 151 2 0
    //   178: checkcast 8	com/whatsapp/i/d$a
    //   181: getfield 153	com/whatsapp/i/d$a:d	J
    //   184: lconst_0
    //   185: lcmp
    //   186: ifle +46 -> 232
    //   189: aload 8
    //   191: ldc -101
    //   193: new 157	java/lang/StringBuilder
    //   196: dup
    //   197: ldc -97
    //   199: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 53	com/whatsapp/i/d:e	Ljava/util/List;
    //   206: iconst_0
    //   207: invokeinterface 151 2 0
    //   212: checkcast 8	com/whatsapp/i/d$a
    //   215: getfield 153	com/whatsapp/i/d$a:d	J
    //   218: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc -90
    //   223: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 565	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 8
    //   234: aload 7
    //   236: invokevirtual 569	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   239: aload 6
    //   241: aload 8
    //   243: invokeinterface 575 2 0
    //   248: astore 7
    //   250: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   253: invokevirtual 369	java/lang/Thread:isInterrupted	()Z
    //   256: ifeq +29 -> 285
    //   259: iconst_m1
    //   260: ireturn
    //   261: aload 7
    //   263: new 157	java/lang/StringBuilder
    //   266: dup
    //   267: ldc -23
    //   269: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: aload_1
    //   273: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokevirtual 578	org/apache/http/entity/EntityTemplate:setContentType	(Ljava/lang/String;)V
    //   282: goto -50 -> 232
    //   285: aload_0
    //   286: aload 7
    //   288: invokeinterface 584 1 0
    //   293: invokeinterface 589 1 0
    //   298: putfield 239	com/whatsapp/i/d:g	I
    //   301: aload_0
    //   302: getfield 239	com/whatsapp/i/d:g	I
    //   305: sipush 400
    //   308: if_icmplt +8 -> 316
    //   311: aload_0
    //   312: getfield 239	com/whatsapp/i/d:g	I
    //   315: ireturn
    //   316: new 591	java/util/HashMap
    //   319: dup
    //   320: invokespecial 592	java/util/HashMap:<init>	()V
    //   323: astore 6
    //   325: aload 7
    //   327: invokeinterface 596 1 0
    //   332: astore 8
    //   334: aload 8
    //   336: arraylength
    //   337: istore 4
    //   339: iload_3
    //   340: iload 4
    //   342: if_icmpge +78 -> 420
    //   345: aload 8
    //   347: iload_3
    //   348: aaload
    //   349: astore 9
    //   351: aload 6
    //   353: aload 9
    //   355: invokeinterface 601 1 0
    //   360: invokeinterface 606 2 0
    //   365: checkcast 144	java/util/List
    //   368: astore_2
    //   369: aload_2
    //   370: astore_1
    //   371: aload_2
    //   372: ifnonnull +27 -> 399
    //   375: new 44	java/util/LinkedList
    //   378: dup
    //   379: invokespecial 45	java/util/LinkedList:<init>	()V
    //   382: astore_1
    //   383: aload 6
    //   385: aload 9
    //   387: invokeinterface 601 1 0
    //   392: aload_1
    //   393: invokeinterface 610 3 0
    //   398: pop
    //   399: aload_1
    //   400: aload 9
    //   402: invokeinterface 613 1 0
    //   407: invokeinterface 617 2 0
    //   412: pop
    //   413: iload_3
    //   414: iconst_1
    //   415: iadd
    //   416: istore_3
    //   417: goto -78 -> 339
    //   420: new 247	java/io/InputStreamReader
    //   423: dup
    //   424: new 249	java/io/BufferedInputStream
    //   427: dup
    //   428: aload 7
    //   430: invokeinterface 621 1 0
    //   435: invokeinterface 626 1 0
    //   440: invokespecial 256	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   443: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   446: astore 7
    //   448: aload_0
    //   449: aload 6
    //   451: aload 7
    //   453: invokespecial 260	com/whatsapp/i/d:a	(Ljava/util/Map;Ljava/io/InputStreamReader;)Z
    //   456: istore 5
    //   458: iload 5
    //   460: ifne +10 -> 470
    //   463: aload 7
    //   465: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   468: iconst_m1
    //   469: ireturn
    //   470: aload 7
    //   472: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   475: aload_0
    //   476: getfield 239	com/whatsapp/i/d:g	I
    //   479: ireturn
    //   480: astore_2
    //   481: aload_2
    //   482: athrow
    //   483: astore_1
    //   484: aload_2
    //   485: ifnull +10 -> 495
    //   488: aload 7
    //   490: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   493: aload_1
    //   494: athrow
    //   495: aload 7
    //   497: invokevirtual 261	java/io/InputStreamReader:close	()V
    //   500: goto -7 -> 493
    //   503: astore_2
    //   504: goto -11 -> 493
    //   507: astore_1
    //   508: aconst_null
    //   509: astore_2
    //   510: goto -26 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	d
    //   0	513	1	paramString	String
    //   0	513	2	paramh	h
    //   1	416	3	i1	int
    //   337	6	4	i2	int
    //   456	3	5	bool	boolean
    //   9	441	6	localObject1	Object
    //   108	388	7	localObject2	Object
    //   130	216	8	localObject3	Object
    //   349	52	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   448	458	480	java/lang/Throwable
    //   481	483	483	finally
    //   488	493	503	java/lang/Throwable
    //   448	458	507	finally
  }
  
  private static void b(String paramString, OutputStream paramOutputStream)
  {
    a("cancel", paramString, paramOutputStream);
  }
  
  private Pair<Integer, Boolean> e()
  {
    boolean bool = false;
    int i1 = 0;
    Socket localSocket = (Socket)this.o.get();
    if (localSocket != null) {}
    for (;;)
    {
      try
      {
        i1 = NativeUtils.getFileDescriptorForSocket(localSocket);
        bool = true;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.w(localUnsupportedOperationException);
        i1 = 0;
        continue;
      }
      return new Pair(Integer.valueOf(i1), Boolean.valueOf(bool));
      bool = false;
    }
  }
  
  private URL f()
  {
    Uri.Builder localBuilder = Uri.parse(this.l).buildUpon();
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      localBuilder.appendQueryParameter((String)localPair.first, (String)localPair.second);
    }
    return new URL(localBuilder.toString());
  }
  
  public final int a(h paramh)
  {
    if (paramh != null) {
      this.n.add(new Pair("auth", paramh.f));
    }
    try
    {
      Object localObject = UUID.randomUUID().toString();
      if (a.b()) {}
      for (int i1 = b((String)localObject, paramh);; i1 = a((String)localObject, paramh))
      {
        paramh = this.e.iterator();
        while (paramh.hasNext())
        {
          localObject = (a)paramh.next();
          if (((a)localObject).a != null) {
            ((a)localObject).a.close();
          }
        }
      }
      a locala;
      return i1;
    }
    finally
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locala = (a)((Iterator)localObject).next();
        if (locala.a != null) {
          locala.a.close();
        }
      }
    }
  }
  
  public final long a()
  {
    return this.h;
  }
  
  public final void a(InputStream paramInputStream, String paramString1, String paramString2, long paramLong)
  {
    this.e.add(new a(paramInputStream, paramString1, paramString2, paramLong, (byte)0));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.n.add(Pair.create(paramString1, paramString2));
  }
  
  public final void a(String paramString, Callable<String> paramCallable)
  {
    this.d.add(Pair.create(paramString, paramCallable));
  }
  
  public final long b()
  {
    return this.i;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    this.c.add(Pair.create(paramString1, paramString2));
  }
  
  public final long c()
  {
    return this.j;
  }
  
  public final String d()
  {
    return this.k;
  }
  
  public static final class a
  {
    public InputStream a;
    public String b;
    public String c;
    public long d;
    
    private a(InputStream paramInputStream, String paramString1, String paramString2, long paramLong)
    {
      this.a = paramInputStream;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong);
    
    public abstract void a(Map<String, List<String>> paramMap, String paramString);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */