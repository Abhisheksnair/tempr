package com.whatsapp.gif_search;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.whatsapp.MediaData;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.c.a;
import com.whatsapp.fieldstats.events.ae;
import com.whatsapp.fieldstats.events.y;
import com.whatsapp.fieldstats.l;
import com.whatsapp.oz;
import com.whatsapp.r;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bi;
import com.whatsapp.util.bi.b;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h
{
  private static volatile h g;
  private static final d h = ;
  public final ThreadPoolExecutor a = d.a(4, 4, TimeUnit.SECONDS, "Gif cache Worker#");
  public final ant b;
  public final a c;
  public final va d;
  public final oz e;
  public final vv f;
  private bi i;
  
  private h(ant paramant, a parama, va paramva, oz paramoz, vv paramvv)
  {
    this.b = paramant;
    this.c = parama;
    this.d = paramva;
    this.e = paramoz;
    this.f = paramvv;
  }
  
  public static h a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new h(ant.a(), a.a(), va.a(), oz.a(), vv.a());
      }
      return g;
    }
    finally {}
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getExternalCacheDir(), "gif/gif_preview_cache");
  }
  
  public final File a(String paramString, int paramInt)
  {
    a.d.c();
    b localb = this.c.d;
    b localb1 = new b(this.d, this.e, this.f, paramString, paramInt, this.b, localb, h);
    localb1.b(localb1.b());
    paramString = localb.a(paramString);
    if (paramString != null) {
      return paramString.getFile();
    }
    return null;
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    
    if (this.i == null)
    {
      Object localObject = new File(u.a().getCacheDir(), "GifsCache");
      if ((!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory())) {
        Log.w("gif/cache/unable to create gifs directory");
      }
      localObject = new bi.b((File)localObject);
      ((bi.b)localObject).f = ((int)(aoa.a().a * 48.0F));
      this.i = ((bi.b)localObject).b();
    }
    this.i.a(paramString, paramImageView);
  }
  
  public final byte[] a(String paramString)
  {
    a.d.b();
    paramString = this.c.c.a(paramString);
    if (paramString != null) {
      return paramString.thumbnail;
    }
    return null;
  }
  
  public final void b()
  {
    if (this.i != null)
    {
      this.i.a(false);
      this.i = null;
    }
  }
  
  static final class a
  {
    final File a;
    final long b;
    final long c;
    final byte[] d;
    
    private a(File paramFile, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
    {
      this.a = paramFile;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramArrayOfByte;
    }
    
    public final String toString()
    {
      return "DownloadResult{fileSize=" + this.b + ", roundTripTime=" + this.c + '}';
    }
  }
  
  public static final class b
    extends h.e
  {
    private final va e;
    private final oz f;
    
    public b(va paramva, oz paramoz, vv paramvv, String paramString, int paramInt, ant paramant, b paramb, h.d paramd)
    {
      super(paramString, true, paramInt, paramant, paramb, paramd);
      this.e = paramva;
      this.f = paramoz;
    }
    
    protected final File a()
    {
      return this.f.a(MediaFileUtils.a(this.e) + ".mp4");
    }
    
    protected final void a(h.a parama)
    {
      if ((parama == null) || (parama.a == null) || (parama.c < 0L) || (this.c == 0)) {
        return;
      }
      y localy = new y();
      localy.a = Integer.valueOf(MediaData.getStatsGifProvider(this.c));
      localy.b = Long.valueOf(parama.b);
      localy.c = Double.valueOf(parama.c);
      l.a(u.a(), localy);
    }
  }
  
  static final class c
    extends h.e
  {
    public c(vv paramvv, String paramString, int paramInt, ant paramant, b paramb, h.d paramd)
    {
      super(paramString, false, paramInt, paramant, paramb, paramd);
    }
    
    protected final File a()
    {
      File localFile = h.a(u.a());
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("gifcache/gifpreviewdownloadaction/createtempfile/error creating directory");
      }
      return new File(localFile, r.a(this.b) + ".gif");
    }
    
    protected final void a(h.a parama)
    {
      if ((parama == null) || (parama.a == null) || (parama.c < 0L) || (this.c == 0)) {
        return;
      }
      ae localae = new ae();
      localae.a = Integer.valueOf(MediaData.getStatsGifProvider(this.c));
      localae.b = Long.valueOf(parama.b);
      localae.c = Double.valueOf(parama.c);
      l.a(u.a(), localae);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(String paramString, File paramFile, byte[] paramArrayOfByte);
  }
  
  static abstract class e
    extends AsyncTask<Void, Object, h.a>
  {
    protected final vv a;
    protected final String b;
    final int c;
    final b d;
    private final h.d e;
    private final boolean f;
    private final ant g;
    
    public e(vv paramvv, String paramString, boolean paramBoolean, int paramInt, ant paramant, b paramb, h.d paramd)
    {
      this.a = paramvv;
      this.b = paramString;
      this.c = paramInt;
      this.e = paramd;
      this.f = paramBoolean;
      this.d = paramb;
      this.g = paramant;
    }
    
    protected abstract File a();
    
    protected abstract void a(h.a parama);
    
    /* Error */
    protected final h.a b()
    {
      // Byte code:
      //   0: new 50	java/lang/StringBuilder
      //   3: dup
      //   4: ldc 52
      //   6: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   9: aload_0
      //   10: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   13: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   19: invokestatic 67	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   22: aload_0
      //   23: invokevirtual 71	com/whatsapp/gif_search/h$e:isCancelled	()Z
      //   26: ifeq +31 -> 57
      //   29: new 50	java/lang/StringBuilder
      //   32: dup
      //   33: ldc 73
      //   35: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   38: aload_0
      //   39: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   42: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   48: invokestatic 67	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   51: aconst_null
      //   52: astore 11
      //   54: aload 11
      //   56: areturn
      //   57: aload_0
      //   58: getfield 38	com/whatsapp/gif_search/h$e:d	Lcom/whatsapp/gif_search/b;
      //   61: aload_0
      //   62: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   65: invokevirtual 78	com/whatsapp/gif_search/b:a	(Ljava/lang/String;)Lcom/whatsapp/gif_search/GifCacheItemSerializable;
      //   68: astore 10
      //   70: aload 10
      //   72: ifnull +28 -> 100
      //   75: new 80	com/whatsapp/gif_search/h$a
      //   78: dup
      //   79: aload 10
      //   81: invokevirtual 85	com/whatsapp/gif_search/GifCacheItemSerializable:getFile	()Ljava/io/File;
      //   84: ldc2_w 86
      //   87: ldc2_w 86
      //   90: aload 10
      //   92: getfield 91	com/whatsapp/gif_search/GifCacheItemSerializable:thumbnail	[B
      //   95: iconst_0
      //   96: invokespecial 94	com/whatsapp/gif_search/h$a:<init>	(Ljava/io/File;JJ[BB)V
      //   99: areturn
      //   100: aload_0
      //   101: getfield 40	com/whatsapp/gif_search/h$e:g	Lcom/whatsapp/ant;
      //   104: invokevirtual 99	com/whatsapp/ant:b	()J
      //   107: lstore 5
      //   109: aconst_null
      //   110: astore 14
      //   112: aconst_null
      //   113: astore 11
      //   115: new 101	java/net/URL
      //   118: dup
      //   119: aload_0
      //   120: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   123: invokespecial 102	java/net/URL:<init>	(Ljava/lang/String;)V
      //   126: invokevirtual 106	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   129: checkcast 108	java/net/HttpURLConnection
      //   132: astore 10
      //   134: aload 10
      //   136: astore 11
      //   138: aload 10
      //   140: astore 14
      //   142: aload 10
      //   144: invokevirtual 111	java/net/HttpURLConnection:connect	()V
      //   147: aload 10
      //   149: astore 11
      //   151: aload 10
      //   153: astore 14
      //   155: aload 10
      //   157: invokevirtual 115	java/net/HttpURLConnection:getResponseCode	()I
      //   160: istore_1
      //   161: iload_1
      //   162: sipush 200
      //   165: if_icmpeq +15 -> 180
      //   168: aload 10
      //   170: ifnull +8 -> 178
      //   173: aload 10
      //   175: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   178: aconst_null
      //   179: areturn
      //   180: aload 10
      //   182: astore 11
      //   184: aload 10
      //   186: astore 14
      //   188: aload 10
      //   190: invokevirtual 121	java/net/HttpURLConnection:getContentLength	()I
      //   193: istore_1
      //   194: aload 10
      //   196: astore 11
      //   198: aload 10
      //   200: astore 14
      //   202: aload 10
      //   204: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   207: astore 12
      //   209: aload 12
      //   211: astore 11
      //   213: aload_0
      //   214: invokevirtual 127	com/whatsapp/gif_search/h$e:a	()Ljava/io/File;
      //   217: astore 12
      //   219: new 129	java/io/FileOutputStream
      //   222: dup
      //   223: aload 12
      //   225: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   228: astore 13
      //   230: sipush 4096
      //   233: newarray <illegal type>
      //   235: astore 14
      //   237: lconst_0
      //   238: lstore_3
      //   239: aload 11
      //   241: aload 14
      //   243: invokevirtual 138	java/io/InputStream:read	([B)I
      //   246: istore_2
      //   247: iload_2
      //   248: iconst_m1
      //   249: if_icmpeq +137 -> 386
      //   252: aload_0
      //   253: invokevirtual 71	com/whatsapp/gif_search/h$e:isCancelled	()Z
      //   256: ifeq +35 -> 291
      //   259: aload 11
      //   261: invokevirtual 141	java/io/InputStream:close	()V
      //   264: aload 13
      //   266: invokevirtual 144	java/io/OutputStream:close	()V
      //   269: aload 11
      //   271: ifnull +8 -> 279
      //   274: aload 11
      //   276: invokevirtual 141	java/io/InputStream:close	()V
      //   279: aload 10
      //   281: ifnull +8 -> 289
      //   284: aload 10
      //   286: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   289: aconst_null
      //   290: areturn
      //   291: lload_3
      //   292: iload_2
      //   293: i2l
      //   294: ladd
      //   295: lstore_3
      //   296: iload_1
      //   297: ifle +26 -> 323
      //   300: aload_0
      //   301: iconst_1
      //   302: anewarray 146	java/lang/Object
      //   305: dup
      //   306: iconst_0
      //   307: ldc2_w 147
      //   310: lload_3
      //   311: lmul
      //   312: iload_1
      //   313: i2l
      //   314: ldiv
      //   315: l2i
      //   316: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   319: aastore
      //   320: invokevirtual 158	com/whatsapp/gif_search/h$e:publishProgress	([Ljava/lang/Object;)V
      //   323: aload 13
      //   325: aload 14
      //   327: iconst_0
      //   328: iload_2
      //   329: invokevirtual 162	java/io/OutputStream:write	([BII)V
      //   332: goto -93 -> 239
      //   335: astore 14
      //   337: aload 11
      //   339: astore 12
      //   341: aload 13
      //   343: astore 11
      //   345: aload 14
      //   347: astore 13
      //   349: aload 13
      //   351: invokestatic 166	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
      //   354: aload 11
      //   356: ifnull +8 -> 364
      //   359: aload 11
      //   361: invokevirtual 144	java/io/OutputStream:close	()V
      //   364: aload 12
      //   366: ifnull +8 -> 374
      //   369: aload 12
      //   371: invokevirtual 141	java/io/InputStream:close	()V
      //   374: aload 10
      //   376: ifnull +8 -> 384
      //   379: aload 10
      //   381: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   384: aconst_null
      //   385: areturn
      //   386: aload 12
      //   388: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   391: lconst_0
      //   392: invokestatic 176	com/whatsapp/util/MediaFileUtils:a	(Ljava/lang/String;J)[B
      //   395: astore 15
      //   397: aload_0
      //   398: getfield 40	com/whatsapp/gif_search/h$e:g	Lcom/whatsapp/ant;
      //   401: invokevirtual 99	com/whatsapp/ant:b	()J
      //   404: lstore 7
      //   406: aload_0
      //   407: getfield 36	com/whatsapp/gif_search/h$e:f	Z
      //   410: ifeq +21 -> 431
      //   413: aload_0
      //   414: getfield 28	com/whatsapp/gif_search/h$e:a	Lcom/whatsapp/vv;
      //   417: aload 12
      //   419: invokestatic 181	com/whatsapp/GifHelper:b	(Lcom/whatsapp/vv;Ljava/io/File;)V
      //   422: aload_0
      //   423: getfield 28	com/whatsapp/gif_search/h$e:a	Lcom/whatsapp/vv;
      //   426: aload 12
      //   428: invokestatic 183	com/whatsapp/GifHelper:a	(Lcom/whatsapp/vv;Ljava/io/File;)V
      //   431: aload_0
      //   432: invokevirtual 71	com/whatsapp/gif_search/h$e:isCancelled	()Z
      //   435: istore 9
      //   437: iload 9
      //   439: ifeq +30 -> 469
      //   442: aload 13
      //   444: invokevirtual 144	java/io/OutputStream:close	()V
      //   447: aload 11
      //   449: ifnull +8 -> 457
      //   452: aload 11
      //   454: invokevirtual 141	java/io/InputStream:close	()V
      //   457: aload 10
      //   459: ifnull +8 -> 467
      //   462: aload 10
      //   464: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   467: aconst_null
      //   468: areturn
      //   469: aload_0
      //   470: getfield 38	com/whatsapp/gif_search/h$e:d	Lcom/whatsapp/gif_search/b;
      //   473: astore 14
      //   475: aload 14
      //   477: monitorenter
      //   478: aload_0
      //   479: getfield 38	com/whatsapp/gif_search/h$e:d	Lcom/whatsapp/gif_search/b;
      //   482: aload_0
      //   483: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   486: invokevirtual 78	com/whatsapp/gif_search/b:a	(Ljava/lang/String;)Lcom/whatsapp/gif_search/GifCacheItemSerializable;
      //   489: astore 16
      //   491: aload 16
      //   493: ifnull +86 -> 579
      //   496: aload 16
      //   498: invokevirtual 85	com/whatsapp/gif_search/GifCacheItemSerializable:getFile	()Ljava/io/File;
      //   501: invokevirtual 186	java/io/File:exists	()Z
      //   504: ifeq +75 -> 579
      //   507: aload 13
      //   509: invokevirtual 144	java/io/OutputStream:close	()V
      //   512: aload 12
      //   514: invokestatic 191	a/a/a/a/d:d	(Ljava/io/File;)Z
      //   517: pop
      //   518: new 80	com/whatsapp/gif_search/h$a
      //   521: dup
      //   522: aload 16
      //   524: invokevirtual 85	com/whatsapp/gif_search/GifCacheItemSerializable:getFile	()Ljava/io/File;
      //   527: ldc2_w 86
      //   530: ldc2_w 86
      //   533: aload 16
      //   535: getfield 91	com/whatsapp/gif_search/GifCacheItemSerializable:thumbnail	[B
      //   538: iconst_0
      //   539: invokespecial 94	com/whatsapp/gif_search/h$a:<init>	(Ljava/io/File;JJ[BB)V
      //   542: astore 12
      //   544: aload 14
      //   546: monitorexit
      //   547: aload 13
      //   549: invokevirtual 144	java/io/OutputStream:close	()V
      //   552: aload 11
      //   554: ifnull +8 -> 562
      //   557: aload 11
      //   559: invokevirtual 141	java/io/InputStream:close	()V
      //   562: aload 12
      //   564: astore 11
      //   566: aload 10
      //   568: ifnull -514 -> 54
      //   571: aload 10
      //   573: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   576: aload 12
      //   578: areturn
      //   579: aload_0
      //   580: getfield 38	com/whatsapp/gif_search/h$e:d	Lcom/whatsapp/gif_search/b;
      //   583: astore 16
      //   585: aload_0
      //   586: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   589: astore 17
      //   591: new 82	com/whatsapp/gif_search/GifCacheItemSerializable
      //   594: dup
      //   595: aload 12
      //   597: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   600: aload 15
      //   602: aload_0
      //   603: getfield 30	com/whatsapp/gif_search/h$e:b	Ljava/lang/String;
      //   606: invokespecial 194	com/whatsapp/gif_search/GifCacheItemSerializable:<init>	(Ljava/lang/String;[BLjava/lang/String;)V
      //   609: astore 18
      //   611: aload 16
      //   613: invokevirtual 196	com/whatsapp/gif_search/b:a	()V
      //   616: aload 16
      //   618: getfield 199	com/whatsapp/gif_search/b:a	Lcom/whatsapp/gif_search/q;
      //   621: aload 17
      //   623: aload 18
      //   625: invokevirtual 204	com/whatsapp/gif_search/q:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   628: pop
      //   629: aload 16
      //   631: invokevirtual 207	com/whatsapp/gif_search/b:c	()Ljava/util/concurrent/ThreadPoolExecutor;
      //   634: aload 16
      //   636: invokestatic 212	com/whatsapp/gif_search/d:a	(Lcom/whatsapp/gif_search/b;)Ljava/lang/Runnable;
      //   639: invokevirtual 218	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
      //   642: aload 14
      //   644: monitorexit
      //   645: new 80	com/whatsapp/gif_search/h$a
      //   648: dup
      //   649: aload 12
      //   651: lload_3
      //   652: lload 7
      //   654: lload 5
      //   656: lsub
      //   657: aload 15
      //   659: iconst_0
      //   660: invokespecial 94	com/whatsapp/gif_search/h$a:<init>	(Ljava/io/File;JJ[BB)V
      //   663: astore 12
      //   665: aload 13
      //   667: invokevirtual 144	java/io/OutputStream:close	()V
      //   670: aload 11
      //   672: ifnull +8 -> 680
      //   675: aload 11
      //   677: invokevirtual 141	java/io/InputStream:close	()V
      //   680: aload 12
      //   682: astore 11
      //   684: aload 10
      //   686: ifnull -632 -> 54
      //   689: aload 10
      //   691: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   694: aload 12
      //   696: areturn
      //   697: astore 12
      //   699: aload 14
      //   701: monitorexit
      //   702: aload 12
      //   704: athrow
      //   705: astore 12
      //   707: aload 13
      //   709: ifnull +8 -> 717
      //   712: aload 13
      //   714: invokevirtual 144	java/io/OutputStream:close	()V
      //   717: aload 11
      //   719: ifnull +8 -> 727
      //   722: aload 11
      //   724: invokevirtual 141	java/io/InputStream:close	()V
      //   727: aload 10
      //   729: ifnull +8 -> 737
      //   732: aload 10
      //   734: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
      //   737: aload 12
      //   739: athrow
      //   740: astore 11
      //   742: goto -15 -> 727
      //   745: astore 12
      //   747: aconst_null
      //   748: astore 13
      //   750: aconst_null
      //   751: astore 14
      //   753: aload 11
      //   755: astore 10
      //   757: aload 14
      //   759: astore 11
      //   761: goto -54 -> 707
      //   764: astore 12
      //   766: aconst_null
      //   767: astore 13
      //   769: goto -62 -> 707
      //   772: astore 13
      //   774: aload 12
      //   776: astore 14
      //   778: aload 13
      //   780: astore 12
      //   782: aload 11
      //   784: astore 13
      //   786: aload 14
      //   788: astore 11
      //   790: goto -83 -> 707
      //   793: astore 11
      //   795: goto -421 -> 374
      //   798: astore 13
      //   800: aconst_null
      //   801: astore 12
      //   803: aconst_null
      //   804: astore 11
      //   806: aload 14
      //   808: astore 10
      //   810: goto -461 -> 349
      //   813: astore 13
      //   815: aconst_null
      //   816: astore 14
      //   818: aload 11
      //   820: astore 12
      //   822: aload 14
      //   824: astore 11
      //   826: goto -477 -> 349
      //   829: astore 11
      //   831: goto -151 -> 680
      //   834: astore 11
      //   836: goto -274 -> 562
      //   839: astore 11
      //   841: goto -384 -> 457
      //   844: astore 11
      //   846: goto -567 -> 279
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	849	0	this	e
      //   160	153	1	i	int
      //   246	83	2	j	int
      //   238	414	3	l1	long
      //   107	548	5	l2	long
      //   404	249	7	l3	long
      //   435	3	9	bool	boolean
      //   68	741	10	localObject1	Object
      //   52	671	11	localObject2	Object
      //   740	14	11	localIOException1	IOException
      //   759	30	11	localObject3	Object
      //   793	1	11	localIOException2	IOException
      //   804	21	11	localObject4	Object
      //   829	1	11	localIOException3	IOException
      //   834	1	11	localIOException4	IOException
      //   839	1	11	localIOException5	IOException
      //   844	1	11	localIOException6	IOException
      //   207	488	12	localObject5	Object
      //   697	6	12	localObject6	Object
      //   705	33	12	localObject7	Object
      //   745	1	12	localObject8	Object
      //   764	11	12	localObject9	Object
      //   780	41	12	localObject10	Object
      //   228	540	13	localObject11	Object
      //   772	7	13	localObject12	Object
      //   784	1	13	localObject13	Object
      //   798	1	13	localException1	Exception
      //   813	1	13	localException2	Exception
      //   110	216	14	localObject14	Object
      //   335	11	14	localException3	Exception
      //   395	263	15	arrayOfByte	byte[]
      //   489	146	16	localObject16	Object
      //   589	33	17	str	String
      //   609	15	18	localGifCacheItemSerializable	GifCacheItemSerializable
      // Exception table:
      //   from	to	target	type
      //   230	237	335	java/lang/Exception
      //   239	247	335	java/lang/Exception
      //   252	264	335	java/lang/Exception
      //   300	323	335	java/lang/Exception
      //   323	332	335	java/lang/Exception
      //   386	431	335	java/lang/Exception
      //   431	437	335	java/lang/Exception
      //   469	478	335	java/lang/Exception
      //   645	665	335	java/lang/Exception
      //   702	705	335	java/lang/Exception
      //   478	491	697	finally
      //   496	547	697	finally
      //   579	645	697	finally
      //   699	702	697	finally
      //   230	237	705	finally
      //   239	247	705	finally
      //   252	264	705	finally
      //   300	323	705	finally
      //   323	332	705	finally
      //   386	431	705	finally
      //   431	437	705	finally
      //   469	478	705	finally
      //   645	665	705	finally
      //   702	705	705	finally
      //   712	717	740	java/io/IOException
      //   722	727	740	java/io/IOException
      //   115	134	745	finally
      //   142	147	745	finally
      //   155	161	745	finally
      //   188	194	745	finally
      //   202	209	745	finally
      //   213	230	764	finally
      //   349	354	772	finally
      //   359	364	793	java/io/IOException
      //   369	374	793	java/io/IOException
      //   115	134	798	java/lang/Exception
      //   142	147	798	java/lang/Exception
      //   155	161	798	java/lang/Exception
      //   188	194	798	java/lang/Exception
      //   202	209	798	java/lang/Exception
      //   213	230	813	java/lang/Exception
      //   665	670	829	java/io/IOException
      //   675	680	829	java/io/IOException
      //   547	552	834	java/io/IOException
      //   557	562	834	java/io/IOException
      //   442	447	839	java/io/IOException
      //   452	457	839	java/io/IOException
      //   264	269	844	java/io/IOException
      //   274	279	844	java/io/IOException
    }
    
    protected final void b(h.a parama)
    {
      byte[] arrayOfByte = null;
      super.onPostExecute(parama);
      h.d locald = this.e;
      String str = this.b;
      File localFile;
      if (parama == null)
      {
        localFile = null;
        if (parama != null) {
          break label85;
        }
      }
      for (;;)
      {
        locald.a(str, localFile, arrayOfByte);
        Log.d("gif/cache/" + parama + " for " + this.b);
        a(parama);
        return;
        localFile = parama.a;
        break;
        label85:
        arrayOfByte = parama.d;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */