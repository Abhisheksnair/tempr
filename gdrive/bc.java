package com.whatsapp.gdrive;

import android.content.Context;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.data.ad;
import com.whatsapp.ox;
import com.whatsapp.oz;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class bc
{
  final at a;
  bb b;
  JSONObject c;
  JSONObject d;
  ConcurrentHashMap<String, bb> e;
  final File f;
  final List<bb> g = new ArrayList();
  private final String h;
  private final String i;
  private final c j;
  private final oz k;
  private final ox l;
  private final ad m;
  private final atu n;
  private final atv o;
  
  public bc(c paramc, oz paramoz, ox paramox, ad paramad, atu paramatu, atv paramatv, at paramat, String paramString1, String paramString2, bb parambb)
  {
    this.j = paramc;
    this.k = paramoz;
    this.l = paramox;
    this.m = paramad;
    this.n = paramatu;
    this.o = paramatv;
    this.a = paramat;
    this.b = parambb;
    this.h = paramString1;
    this.i = paramString2;
    if (parambb != null) {
      a();
    }
    this.f = new File(u.a().getCacheDir(), "gdrive_file_map");
  }
  
  private boolean a(File paramFile)
  {
    try
    {
      boolean bool = this.k.a(paramFile);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("gdrive-map/calc-approx-media-download-size/in-media-folder " + paramFile);
    }
    return false;
  }
  
  private boolean b(bb parambb)
  {
    if (this.e.remove(parambb.d, parambb))
    {
      this.g.add(parambb);
      return true;
    }
    Log.e("gdrive-map/remove/not-found " + parambb);
    return false;
  }
  
  private boolean b(ev paramev)
  {
    Log.i("gdrive-map/listing-all-entries current count of entries in gdriveFileMap: " + this.e.size());
    if (this.i != null) {}
    for (paramev = this.a.a(new String[] { this.h, this.i }, paramev); paramev == null; paramev = this.a.a(new String[] { this.h }, paramev))
    {
      Log.i("gdrive-map/listing-all-entries driveApi.listFiles (primary base folder, secondary base folder) returned null.");
      return false;
    }
    Iterator localIterator = paramev.iterator();
    while (localIterator.hasNext())
    {
      bb localbb = (bb)localIterator.next();
      paramev = localbb.d;
      if (this.e.containsKey(paramev))
      {
        if (localbb.f != null)
        {
          String str = localbb.f;
          paramev = localbb.d;
          paramev = (bb)this.e.get(paramev);
          if (paramev != null) {}
          for (paramev = paramev.f;; paramev = null)
          {
            if (!str.equals(paramev)) {
              break label225;
            }
            Log.i("gdrive-map/listing-all-entries/duplicate " + localbb + " gdriveFileMap.size: " + this.e.size());
            break;
          }
        }
        label225:
        Log.e("gdrive-map/listing-all-entries we have two files (different md5) with same title: " + localbb.d);
        paramev = a(localbb.d);
        if ((paramev == null) || (paramev.e < localbb.e)) {
          a(localbb);
        }
      }
      else
      {
        a(localbb);
      }
    }
    return true;
  }
  
  /* Error */
  private boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/whatsapp/gdrive/bc:f	Ljava/io/File;
    //   4: astore 7
    //   6: new 99	java/lang/StringBuilder
    //   9: dup
    //   10: ldc -49
    //   12: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload 7
    //   17: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 212	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   29: new 214	com/google/a/b/a
    //   32: dup
    //   33: new 216	java/io/InputStreamReader
    //   36: dup
    //   37: new 218	java/io/FileInputStream
    //   40: dup
    //   41: aload 7
    //   43: invokespecial 221	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: invokespecial 227	com/google/a/b/a:<init>	(Ljava/io/Reader;)V
    //   52: astore 11
    //   54: aload 11
    //   56: invokevirtual 229	com/google/a/b/a:a	()V
    //   59: aload 11
    //   61: invokevirtual 231	com/google/a/b/a:e	()Z
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq +396 -> 462
    //   69: ldc2_w 232
    //   72: lstore_3
    //   73: aload 11
    //   75: invokevirtual 235	com/google/a/b/a:c	()V
    //   78: aconst_null
    //   79: astore 9
    //   81: aconst_null
    //   82: astore 8
    //   84: aconst_null
    //   85: astore 7
    //   87: aload 11
    //   89: invokevirtual 231	com/google/a/b/a:e	()Z
    //   92: ifeq +263 -> 355
    //   95: aload 11
    //   97: invokevirtual 237	com/google/a/b/a:f	()Ljava/lang/String;
    //   100: astore 10
    //   102: aload 10
    //   104: invokevirtual 240	java/lang/String:hashCode	()I
    //   107: lookupswitch	default:+381->488, 102:+126->233, 109:+158->265, 114:+142->249, 115:+174->281
    //   148: new 99	java/lang/StringBuilder
    //   151: dup
    //   152: ldc -14
    //   154: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 10
    //   159: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc -12
    //   164: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 11
    //   169: invokevirtual 246	com/google/a/b/a:g	()Ljava/lang/String;
    //   172: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   181: goto -94 -> 87
    //   184: astore 10
    //   186: ldc -8
    //   188: aload 10
    //   190: invokestatic 251	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: aload 7
    //   195: ifnonnull +197 -> 392
    //   198: ldc -3
    //   200: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   203: goto -144 -> 59
    //   206: astore 7
    //   208: ldc -8
    //   210: aload 7
    //   212: invokestatic 251	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload 11
    //   217: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   220: iconst_0
    //   221: ireturn
    //   222: astore 7
    //   224: ldc -8
    //   226: aload 7
    //   228: invokestatic 251	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: aload 10
    //   235: ldc_w 259
    //   238: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +247 -> 488
    //   244: iconst_0
    //   245: istore_1
    //   246: goto +244 -> 490
    //   249: aload 10
    //   251: ldc_w 261
    //   254: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifeq +231 -> 488
    //   260: iconst_1
    //   261: istore_1
    //   262: goto +228 -> 490
    //   265: aload 10
    //   267: ldc_w 262
    //   270: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: ifeq +215 -> 488
    //   276: iconst_2
    //   277: istore_1
    //   278: goto +212 -> 490
    //   281: aload 10
    //   283: ldc_w 264
    //   286: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   289: ifeq +199 -> 488
    //   292: iconst_3
    //   293: istore_1
    //   294: goto +196 -> 490
    //   297: aload 11
    //   299: invokevirtual 246	com/google/a/b/a:g	()Ljava/lang/String;
    //   302: astore 10
    //   304: aload 10
    //   306: astore 7
    //   308: goto -221 -> 87
    //   311: aload 11
    //   313: invokevirtual 246	com/google/a/b/a:g	()Ljava/lang/String;
    //   316: astore 10
    //   318: aload 10
    //   320: astore 8
    //   322: goto -235 -> 87
    //   325: aload 11
    //   327: invokevirtual 246	com/google/a/b/a:g	()Ljava/lang/String;
    //   330: astore 10
    //   332: aload 10
    //   334: astore 9
    //   336: goto -249 -> 87
    //   339: aload 11
    //   341: invokevirtual 246	com/google/a/b/a:g	()Ljava/lang/String;
    //   344: invokestatic 270	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   347: lstore 5
    //   349: lload 5
    //   351: lstore_3
    //   352: goto -265 -> 87
    //   355: aload 11
    //   357: invokevirtual 272	com/google/a/b/a:d	()V
    //   360: goto -167 -> 193
    //   363: astore 7
    //   365: ldc -8
    //   367: aload 7
    //   369: invokestatic 251	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: aload_0
    //   373: getfield 48	com/whatsapp/gdrive/bc:j	Lcom/whatsapp/util/a/c;
    //   376: ldc_w 274
    //   379: iconst_0
    //   380: aconst_null
    //   381: iconst_m1
    //   382: invokevirtual 279	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   385: aload 11
    //   387: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   390: iconst_0
    //   391: ireturn
    //   392: aload 8
    //   394: ifnonnull +12 -> 406
    //   397: ldc_w 281
    //   400: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   403: goto -344 -> 59
    //   406: aload 9
    //   408: ifnonnull +22 -> 430
    //   411: ldc_w 283
    //   414: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   417: goto -358 -> 59
    //   420: astore 7
    //   422: aload 11
    //   424: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   427: aload 7
    //   429: athrow
    //   430: lload_3
    //   431: lconst_0
    //   432: lcmp
    //   433: ifge +12 -> 445
    //   436: ldc_w 285
    //   439: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   442: goto -383 -> 59
    //   445: aload_0
    //   446: aload 8
    //   448: aload 7
    //   450: aload 9
    //   452: lload_3
    //   453: invokestatic 288	com/whatsapp/gdrive/bb:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/whatsapp/gdrive/bb;
    //   456: invokevirtual 201	com/whatsapp/gdrive/bc:a	(Lcom/whatsapp/gdrive/bb;)V
    //   459: goto -400 -> 59
    //   462: aload 11
    //   464: invokevirtual 290	com/google/a/b/a:b	()V
    //   467: aload 11
    //   469: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   472: iconst_1
    //   473: ireturn
    //   474: astore 10
    //   476: aconst_null
    //   477: astore 9
    //   479: aconst_null
    //   480: astore 8
    //   482: aconst_null
    //   483: astore 7
    //   485: goto -299 -> 186
    //   488: iconst_m1
    //   489: istore_1
    //   490: iload_1
    //   491: tableswitch	default:+29->520, 0:+-194->297, 1:+-180->311, 2:+-166->325, 3:+-152->339
    //   520: goto -372 -> 148
    //   523: astore 7
    //   525: goto -160 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	bc
    //   245	246	1	i1	int
    //   64	2	2	bool	boolean
    //   72	381	3	l1	long
    //   347	3	5	l2	long
    //   4	190	7	localFile	File
    //   206	5	7	localIOException1	IOException
    //   222	5	7	localIOException2	IOException
    //   306	1	7	localObject1	Object
    //   363	5	7	localNumberFormatException	NumberFormatException
    //   420	29	7	str1	String
    //   483	1	7	localObject2	Object
    //   523	1	7	localIllegalStateException1	IllegalStateException
    //   82	399	8	localObject3	Object
    //   79	399	9	localObject4	Object
    //   100	58	10	str2	String
    //   184	98	10	localIllegalStateException2	IllegalStateException
    //   302	31	10	str3	String
    //   474	1	10	localIllegalStateException3	IllegalStateException
    //   52	416	11	locala	com.google.a.b.a
    // Exception table:
    //   from	to	target	type
    //   87	148	184	java/lang/IllegalStateException
    //   148	181	184	java/lang/IllegalStateException
    //   233	244	184	java/lang/IllegalStateException
    //   249	260	184	java/lang/IllegalStateException
    //   265	276	184	java/lang/IllegalStateException
    //   281	292	184	java/lang/IllegalStateException
    //   297	304	184	java/lang/IllegalStateException
    //   311	318	184	java/lang/IllegalStateException
    //   325	332	184	java/lang/IllegalStateException
    //   339	349	184	java/lang/IllegalStateException
    //   355	360	184	java/lang/IllegalStateException
    //   54	59	206	java/io/IOException
    //   59	65	206	java/io/IOException
    //   73	78	206	java/io/IOException
    //   87	148	206	java/io/IOException
    //   148	181	206	java/io/IOException
    //   186	193	206	java/io/IOException
    //   198	203	206	java/io/IOException
    //   233	244	206	java/io/IOException
    //   249	260	206	java/io/IOException
    //   265	276	206	java/io/IOException
    //   281	292	206	java/io/IOException
    //   297	304	206	java/io/IOException
    //   311	318	206	java/io/IOException
    //   325	332	206	java/io/IOException
    //   339	349	206	java/io/IOException
    //   355	360	206	java/io/IOException
    //   397	403	206	java/io/IOException
    //   411	417	206	java/io/IOException
    //   436	442	206	java/io/IOException
    //   445	459	206	java/io/IOException
    //   462	467	206	java/io/IOException
    //   29	54	222	java/io/IOException
    //   54	59	363	java/lang/NumberFormatException
    //   59	65	363	java/lang/NumberFormatException
    //   73	78	363	java/lang/NumberFormatException
    //   87	148	363	java/lang/NumberFormatException
    //   148	181	363	java/lang/NumberFormatException
    //   186	193	363	java/lang/NumberFormatException
    //   198	203	363	java/lang/NumberFormatException
    //   233	244	363	java/lang/NumberFormatException
    //   249	260	363	java/lang/NumberFormatException
    //   265	276	363	java/lang/NumberFormatException
    //   281	292	363	java/lang/NumberFormatException
    //   297	304	363	java/lang/NumberFormatException
    //   311	318	363	java/lang/NumberFormatException
    //   325	332	363	java/lang/NumberFormatException
    //   339	349	363	java/lang/NumberFormatException
    //   355	360	363	java/lang/NumberFormatException
    //   397	403	363	java/lang/NumberFormatException
    //   411	417	363	java/lang/NumberFormatException
    //   436	442	363	java/lang/NumberFormatException
    //   445	459	363	java/lang/NumberFormatException
    //   462	467	363	java/lang/NumberFormatException
    //   54	59	420	finally
    //   59	65	420	finally
    //   73	78	420	finally
    //   87	148	420	finally
    //   148	181	420	finally
    //   186	193	420	finally
    //   198	203	420	finally
    //   208	215	420	finally
    //   233	244	420	finally
    //   249	260	420	finally
    //   265	276	420	finally
    //   281	292	420	finally
    //   297	304	420	finally
    //   311	318	420	finally
    //   325	332	420	finally
    //   339	349	420	finally
    //   355	360	420	finally
    //   365	385	420	finally
    //   397	403	420	finally
    //   411	417	420	finally
    //   436	442	420	finally
    //   445	459	420	finally
    //   462	467	420	finally
    //   73	78	474	java/lang/IllegalStateException
    //   54	59	523	java/lang/IllegalStateException
    //   59	65	523	java/lang/IllegalStateException
    //   186	193	523	java/lang/IllegalStateException
    //   198	203	523	java/lang/IllegalStateException
    //   397	403	523	java/lang/IllegalStateException
    //   411	417	523	java/lang/IllegalStateException
    //   436	442	523	java/lang/IllegalStateException
    //   445	459	523	java/lang/IllegalStateException
    //   462	467	523	java/lang/IllegalStateException
  }
  
  public final int a(String paramString, bb parambb)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return 1;
    }
    if (parambb == null) {
      return 2;
    }
    if (paramString.length() != parambb.a) {
      return 4;
    }
    String str = ch.a(this.l, this.n, paramString);
    if (str == null)
    {
      Log.i("gdrive-map/md5-is-null/ " + paramString);
      return 1;
    }
    if (str.equals(parambb.f)) {
      return 3;
    }
    return 4;
  }
  
  final long a(long paramLong, boolean paramBoolean, BlockingQueue<Boolean> paramBlockingQueue, AtomicBoolean paramAtomicBoolean)
  {
    if (!this.k.d().exists()) {
      return paramLong;
    }
    long l4 = 0L;
    long l3 = 0L;
    String[] arrayOfString = (String[])this.e.keySet().toArray(new String[this.e.size()]);
    if (this.e.size() < 10) {}
    for (int i1 = 1;; i1 = 20)
    {
      int i2 = 0;
      if (i2 < arrayOfString.length)
      {
        if (paramAtomicBoolean.get())
        {
          Log.i("gdrive-map/calc-approx-media-download-size/interrupted");
          return -1L;
        }
        Object localObject = arrayOfString[i2];
        long l1;
        long l2;
        if (localObject == null)
        {
          Log.e("gdrive-map/calc-approx-media-download-size file upload path is null, unexpected.");
          l1 = l4;
          l2 = l3;
        }
        for (;;)
        {
          i2 += 1;
          l3 = l2;
          l4 = l1;
          break;
          String str = ch.a(this.j, this.l, (String)localObject);
          if (str == null)
          {
            Log.i("gdrive-map/calc-approx-media-download-size/no-local-path-mapping " + (String)localObject);
            l2 = l3;
            l1 = l4;
          }
          else
          {
            localObject = (bb)this.e.get(localObject);
            File localFile = new File(str);
            l2 = l3;
            l1 = l4;
            if (a(localFile)) {
              if ((!localFile.exists()) || (localFile.length() == 0L))
              {
                l4 += ((bb)localObject).a;
                l3 += ((bb)localObject).a;
                l2 = l3;
                l1 = l4;
                if (paramBlockingQueue.isEmpty())
                {
                  paramBlockingQueue.add(Boolean.valueOf(false));
                  l2 = l3;
                  l1 = l4;
                }
              }
              else if (!paramBoolean)
              {
                l1 = l4 + ((bb)localObject).a;
                l2 = l3;
              }
              else
              {
                l2 = l3;
                l1 = l4;
                if (i2 % i1 == 0)
                {
                  l4 += ((bb)localObject).a;
                  l2 = l3;
                  l1 = l4;
                  if (a(str, (bb)localObject) == 4)
                  {
                    l3 += ((bb)localObject).a;
                    l2 = l3;
                    l1 = l4;
                    if (paramBlockingQueue.isEmpty())
                    {
                      paramBlockingQueue.add(Boolean.valueOf(false));
                      l2 = l3;
                      l1 = l4;
                    }
                  }
                }
              }
            }
          }
        }
      }
      Log.d("gdrive-map/calc-approx-media-download toBeDownloadedSampleSize: " + l3 + " totalSampleSize:" + l4 + " totalSize: " + paramLong);
      if (l4 == 0L)
      {
        if (l3 > 0L) {
          Log.e("gdrive-map/calc-approx-media-download unexpected situation, how can toBeDownloadedSampleSize=" + l3 + " be greater than totalSampleSize=" + l4);
        }
        return 0L;
      }
      return (l3 / l4 * paramLong);
    }
  }
  
  public final bb a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (bb)this.e.get(paramString);
  }
  
  /* Error */
  public final File a(ev paramev)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 371	org/json/JSONObject
    //   4: dup
    //   5: invokespecial 372	org/json/JSONObject:<init>	()V
    //   8: putfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   11: new 376	com/google/a/b/c
    //   14: dup
    //   15: new 378	java/io/FileWriter
    //   18: dup
    //   19: aload_0
    //   20: getfield 89	com/whatsapp/gdrive/bc:f	Ljava/io/File;
    //   23: invokespecial 379	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   26: invokespecial 382	com/google/a/b/c:<init>	(Ljava/io/Writer;)V
    //   29: astore 17
    //   31: aload 17
    //   33: astore 16
    //   35: aload 17
    //   37: invokevirtual 383	com/google/a/b/c:a	()V
    //   40: aload 17
    //   42: astore 16
    //   44: aload 17
    //   46: iconst_1
    //   47: ldc_w 385
    //   50: invokevirtual 388	com/google/a/b/c:a	(ILjava/lang/String;)Lcom/google/a/b/c;
    //   53: pop
    //   54: aload 17
    //   56: astore 16
    //   58: aload_0
    //   59: getfield 119	com/whatsapp/gdrive/bc:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: invokevirtual 392	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   65: invokeinterface 395 1 0
    //   70: astore 18
    //   72: lconst_0
    //   73: lstore 10
    //   75: lconst_0
    //   76: lstore 12
    //   78: lconst_0
    //   79: lstore 6
    //   81: iconst_0
    //   82: istore 5
    //   84: iconst_0
    //   85: istore_2
    //   86: lconst_0
    //   87: lstore 8
    //   89: aload 17
    //   91: astore 16
    //   93: aload 18
    //   95: invokeinterface 167 1 0
    //   100: ifeq +733 -> 833
    //   103: aload 17
    //   105: astore 16
    //   107: aload 18
    //   109: invokeinterface 171 1 0
    //   114: checkcast 121	com/whatsapp/gdrive/bb
    //   117: astore 19
    //   119: aload 17
    //   121: astore 16
    //   123: aload_1
    //   124: invokevirtual 398	com/whatsapp/gdrive/ev:a	()Z
    //   127: ifne +37 -> 164
    //   130: aload 17
    //   132: astore 16
    //   134: new 99	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 400
    //   141: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 401	com/whatsapp/gdrive/ev:toString	()Ljava/lang/String;
    //   148: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   157: aload 17
    //   159: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 17
    //   166: astore 16
    //   168: aload 19
    //   170: getfield 123	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   173: astore 20
    //   175: aload 17
    //   177: astore 16
    //   179: aload 19
    //   181: getfield 403	com/whatsapp/gdrive/bb:c	Ljava/lang/String;
    //   184: astore 21
    //   186: aload 17
    //   188: astore 16
    //   190: aload 19
    //   192: getfield 176	com/whatsapp/gdrive/bb:f	Ljava/lang/String;
    //   195: astore 22
    //   197: aload 17
    //   199: astore 16
    //   201: aload_0
    //   202: getfield 48	com/whatsapp/gdrive/bc:j	Lcom/whatsapp/util/a/c;
    //   205: aload_0
    //   206: getfield 52	com/whatsapp/gdrive/bc:l	Lcom/whatsapp/ox;
    //   209: aload 20
    //   211: invokestatic 334	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/util/a/c;Lcom/whatsapp/ox;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 23
    //   216: aload 23
    //   218: ifnull +22 -> 240
    //   221: aload 17
    //   223: astore 16
    //   225: new 71	java/io/File
    //   228: dup
    //   229: aload 23
    //   231: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: invokevirtual 295	java/io/File:exists	()Z
    //   237: ifne +79 -> 316
    //   240: aload 17
    //   242: astore 16
    //   244: new 99	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 405
    //   251: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload 23
    //   256: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 407
    //   262: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 410	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   271: aload 17
    //   273: astore 16
    //   275: aload_0
    //   276: aload 19
    //   278: invokespecial 412	com/whatsapp/gdrive/bc:b	(Lcom/whatsapp/gdrive/bb;)Z
    //   281: pop
    //   282: goto -193 -> 89
    //   285: astore 16
    //   287: aload 17
    //   289: astore_1
    //   290: aload 16
    //   292: astore 17
    //   294: aload_1
    //   295: astore 16
    //   297: aload 17
    //   299: invokestatic 415	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   302: aload_1
    //   303: astore 16
    //   305: aload_0
    //   306: aconst_null
    //   307: putfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   310: aload_1
    //   311: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   314: aconst_null
    //   315: areturn
    //   316: aload 22
    //   318: ifnonnull +45 -> 363
    //   321: aload 17
    //   323: astore 16
    //   325: new 99	java/lang/StringBuilder
    //   328: dup
    //   329: ldc_w 417
    //   332: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload 23
    //   337: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 419
    //   343: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 410	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   352: goto -263 -> 89
    //   355: astore_1
    //   356: aload 16
    //   358: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   361: aload_1
    //   362: athrow
    //   363: aload 17
    //   365: astore 16
    //   367: new 71	java/io/File
    //   370: dup
    //   371: aload 23
    //   373: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   376: astore 23
    //   378: aload 17
    //   380: astore 16
    //   382: aload_0
    //   383: getfield 50	com/whatsapp/gdrive/bc:k	Lcom/whatsapp/oz;
    //   386: aload 23
    //   388: invokevirtual 97	com/whatsapp/oz:a	(Ljava/io/File;)Z
    //   391: ifeq +79 -> 470
    //   394: aload 17
    //   396: astore 16
    //   398: aload 23
    //   400: aload_0
    //   401: getfield 58	com/whatsapp/gdrive/bc:o	Lcom/whatsapp/atv;
    //   404: aload_0
    //   405: getfield 50	com/whatsapp/gdrive/bc:k	Lcom/whatsapp/oz;
    //   408: invokestatic 424	com/whatsapp/gdrive/GoogleDriveService:a	(Ljava/io/File;Lcom/whatsapp/atv;Lcom/whatsapp/oz;)Z
    //   411: ifne +59 -> 470
    //   414: aload 17
    //   416: astore 16
    //   418: new 99	java/lang/StringBuilder
    //   421: dup
    //   422: ldc_w 426
    //   425: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload 23
    //   430: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 428
    //   439: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 23
    //   444: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   447: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 410	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   456: aload 17
    //   458: astore 16
    //   460: aload_0
    //   461: aload 19
    //   463: invokespecial 412	com/whatsapp/gdrive/bc:b	(Lcom/whatsapp/gdrive/bb;)Z
    //   466: pop
    //   467: goto -378 -> 89
    //   470: aload 17
    //   472: astore 16
    //   474: aload 17
    //   476: invokevirtual 383	com/google/a/b/c:a	()V
    //   479: aload 17
    //   481: astore 16
    //   483: aload 17
    //   485: iconst_3
    //   486: ldc_w 430
    //   489: invokevirtual 388	com/google/a/b/c:a	(ILjava/lang/String;)Lcom/google/a/b/c;
    //   492: pop
    //   493: aload 17
    //   495: astore 16
    //   497: aload 17
    //   499: ldc_w 259
    //   502: invokevirtual 433	com/google/a/b/c:a	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   505: aload 20
    //   507: invokevirtual 435	com/google/a/b/c:b	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   510: pop
    //   511: aload 17
    //   513: astore 16
    //   515: aload 17
    //   517: ldc_w 261
    //   520: invokevirtual 433	com/google/a/b/c:a	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   523: aload 21
    //   525: invokevirtual 435	com/google/a/b/c:b	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   528: pop
    //   529: aload 17
    //   531: astore 16
    //   533: aload 17
    //   535: ldc_w 262
    //   538: invokevirtual 433	com/google/a/b/c:a	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   541: aload 22
    //   543: invokevirtual 435	com/google/a/b/c:b	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   546: pop
    //   547: aload 17
    //   549: astore 16
    //   551: aload 17
    //   553: ldc_w 264
    //   556: invokevirtual 433	com/google/a/b/c:a	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   559: aload 19
    //   561: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   564: invokestatic 438	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   567: invokevirtual 435	com/google/a/b/c:b	(Ljava/lang/String;)Lcom/google/a/b/c;
    //   570: pop
    //   571: aload 17
    //   573: astore 16
    //   575: aload 17
    //   577: iconst_3
    //   578: iconst_5
    //   579: ldc_w 440
    //   582: invokevirtual 443	com/google/a/b/c:a	(IILjava/lang/String;)Lcom/google/a/b/c;
    //   585: pop
    //   586: aload 17
    //   588: astore 16
    //   590: aload 19
    //   592: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   595: lconst_0
    //   596: lcmp
    //   597: ifge +31 -> 628
    //   600: aload 17
    //   602: astore 16
    //   604: new 99	java/lang/StringBuilder
    //   607: dup
    //   608: ldc_w 445
    //   611: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   614: aload 19
    //   616: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   625: goto -536 -> 89
    //   628: aload 17
    //   630: astore 16
    //   632: aload_0
    //   633: getfield 54	com/whatsapp/gdrive/bc:m	Lcom/whatsapp/data/ad;
    //   636: getfield 450	com/whatsapp/data/ad:c	Lcom/whatsapp/data/cb;
    //   639: invokevirtual 455	com/whatsapp/data/cb:c	()[Ljava/io/File;
    //   642: invokestatic 461	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   645: aload 23
    //   647: invokeinterface 464 2 0
    //   652: ifeq +14 -> 666
    //   655: aload 17
    //   657: astore 16
    //   659: aload 19
    //   661: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   664: lstore 12
    //   666: aload 17
    //   668: astore 16
    //   670: lload 10
    //   672: lstore 14
    //   674: iload 5
    //   676: istore_3
    //   677: aload_0
    //   678: getfield 50	com/whatsapp/gdrive/bc:k	Lcom/whatsapp/oz;
    //   681: aload 23
    //   683: invokevirtual 97	com/whatsapp/oz:a	(Ljava/io/File;)Z
    //   686: ifeq +22 -> 708
    //   689: aload 17
    //   691: astore 16
    //   693: lload 10
    //   695: aload 19
    //   697: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   700: ladd
    //   701: lstore 14
    //   703: iload 5
    //   705: iconst_1
    //   706: iadd
    //   707: istore_3
    //   708: aload 17
    //   710: astore 16
    //   712: lload 8
    //   714: lstore 10
    //   716: aload_0
    //   717: getfield 50	com/whatsapp/gdrive/bc:k	Lcom/whatsapp/oz;
    //   720: aload 23
    //   722: invokevirtual 466	com/whatsapp/oz:b	(Ljava/io/File;)Z
    //   725: ifeq +17 -> 742
    //   728: aload 17
    //   730: astore 16
    //   732: lload 8
    //   734: aload 19
    //   736: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   739: ladd
    //   740: lstore 10
    //   742: aload 17
    //   744: astore 16
    //   746: aload_0
    //   747: getfield 50	com/whatsapp/gdrive/bc:k	Lcom/whatsapp/oz;
    //   750: astore 20
    //   752: aload 17
    //   754: astore 16
    //   756: aload 20
    //   758: getfield 469	com/whatsapp/oz:l	Z
    //   761: ifne +12 -> 773
    //   764: aload 17
    //   766: astore 16
    //   768: aload 20
    //   770: invokevirtual 471	com/whatsapp/oz:j	()V
    //   773: aload 17
    //   775: astore 16
    //   777: aload 23
    //   779: invokevirtual 474	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   782: aload 20
    //   784: getfield 476	com/whatsapp/oz:c	Ljava/io/File;
    //   787: invokevirtual 474	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   790: invokevirtual 480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   793: ifeq +544 -> 1337
    //   796: iconst_1
    //   797: istore 5
    //   799: goto +522 -> 1321
    //   802: aload 17
    //   804: astore 16
    //   806: lload 6
    //   808: aload 19
    //   810: getfield 301	com/whatsapp/gdrive/bb:a	J
    //   813: ladd
    //   814: lstore 6
    //   816: lload 10
    //   818: lstore 8
    //   820: lload 14
    //   822: lstore 10
    //   824: iload_3
    //   825: istore 5
    //   827: iload 4
    //   829: istore_2
    //   830: goto -741 -> 89
    //   833: aload 17
    //   835: astore 16
    //   837: aload 17
    //   839: iconst_1
    //   840: iconst_2
    //   841: ldc_w 482
    //   844: invokevirtual 443	com/google/a/b/c:a	(IILjava/lang/String;)Lcom/google/a/b/c;
    //   847: pop
    //   848: aload 17
    //   850: astore 16
    //   852: aload 17
    //   854: invokevirtual 485	com/google/a/b/c:close	()V
    //   857: aload 17
    //   859: astore 16
    //   861: new 99	java/lang/StringBuilder
    //   864: dup
    //   865: ldc_w 487
    //   868: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   871: iload_2
    //   872: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   875: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   881: aload 17
    //   883: astore 16
    //   885: new 99	java/lang/StringBuilder
    //   888: dup
    //   889: ldc_w 489
    //   892: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   895: iload 5
    //   897: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   900: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   906: aload 17
    //   908: astore 16
    //   910: new 99	java/lang/StringBuilder
    //   913: dup
    //   914: ldc_w 491
    //   917: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: lload 12
    //   922: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   925: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   931: aload 17
    //   933: astore 16
    //   935: new 99	java/lang/StringBuilder
    //   938: dup
    //   939: ldc_w 493
    //   942: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   945: lload 8
    //   947: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   950: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   956: aload 17
    //   958: astore 16
    //   960: new 99	java/lang/StringBuilder
    //   963: dup
    //   964: ldc_w 495
    //   967: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   970: lload 6
    //   972: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   975: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   981: aload 17
    //   983: astore 16
    //   985: new 99	java/lang/StringBuilder
    //   988: dup
    //   989: ldc_w 497
    //   992: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   995: lload 10
    //   997: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1000: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1006: aload 17
    //   1008: astore 16
    //   1010: aload_0
    //   1011: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1014: ldc_w 499
    //   1017: iload_2
    //   1018: invokevirtual 503	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1021: pop
    //   1022: aload 17
    //   1024: astore 16
    //   1026: aload_0
    //   1027: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1030: ldc_w 505
    //   1033: iload 5
    //   1035: invokevirtual 503	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1038: pop
    //   1039: aload 17
    //   1041: astore 16
    //   1043: aload_0
    //   1044: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1047: ldc_w 507
    //   1050: lload 6
    //   1052: invokevirtual 510	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1055: pop
    //   1056: aload 17
    //   1058: astore 16
    //   1060: aload_0
    //   1061: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1064: ldc_w 512
    //   1067: lload 12
    //   1069: invokevirtual 510	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1072: pop
    //   1073: aload 17
    //   1075: astore 16
    //   1077: aload_0
    //   1078: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1081: ldc_w 514
    //   1084: lload 10
    //   1086: invokevirtual 510	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1089: pop
    //   1090: aload 17
    //   1092: astore 16
    //   1094: aload_0
    //   1095: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1098: ldc_w 516
    //   1101: lload 8
    //   1103: invokevirtual 510	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1106: pop
    //   1107: aload 17
    //   1109: astore 16
    //   1111: aload_0
    //   1112: getfield 58	com/whatsapp/gdrive/bc:o	Lcom/whatsapp/atv;
    //   1115: invokevirtual 521	com/whatsapp/atv:w	()Lorg/json/JSONObject;
    //   1118: astore_1
    //   1119: aload 17
    //   1121: astore 16
    //   1123: new 99	java/lang/StringBuilder
    //   1126: dup
    //   1127: ldc_w 523
    //   1130: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1133: aload_1
    //   1134: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 149	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1143: aload 17
    //   1145: astore 16
    //   1147: aload_0
    //   1148: getfield 374	com/whatsapp/gdrive/bc:d	Lorg/json/JSONObject;
    //   1151: ldc_w 525
    //   1154: aload_1
    //   1155: invokevirtual 528	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1158: pop
    //   1159: lload 6
    //   1161: lconst_0
    //   1162: lcmp
    //   1163: iflt +24 -> 1187
    //   1166: lload 12
    //   1168: lconst_0
    //   1169: lcmp
    //   1170: iflt +17 -> 1187
    //   1173: lload 10
    //   1175: lconst_0
    //   1176: lcmp
    //   1177: iflt +10 -> 1187
    //   1180: lload 8
    //   1182: lconst_0
    //   1183: lcmp
    //   1184: ifge +72 -> 1256
    //   1187: aload 17
    //   1189: astore 16
    //   1191: getstatic 534	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   1194: ldc_w 536
    //   1197: iconst_4
    //   1198: anewarray 4	java/lang/Object
    //   1201: dup
    //   1202: iconst_0
    //   1203: lload 6
    //   1205: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1208: aastore
    //   1209: dup
    //   1210: iconst_1
    //   1211: lload 12
    //   1213: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1216: aastore
    //   1217: dup
    //   1218: iconst_2
    //   1219: lload 10
    //   1221: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_3
    //   1227: lload 8
    //   1229: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1232: aastore
    //   1233: invokestatic 543	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1236: invokestatic 116	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1239: aload 17
    //   1241: astore 16
    //   1243: aload_0
    //   1244: getfield 48	com/whatsapp/gdrive/bc:j	Lcom/whatsapp/util/a/c;
    //   1247: ldc_w 545
    //   1250: iconst_0
    //   1251: aconst_null
    //   1252: iconst_m1
    //   1253: invokevirtual 279	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1256: aload 17
    //   1258: invokestatic 258	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1261: new 99	java/lang/StringBuilder
    //   1264: dup
    //   1265: ldc_w 547
    //   1268: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1271: aload_0
    //   1272: getfield 89	com/whatsapp/gdrive/bc:f	Ljava/io/File;
    //   1275: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1278: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: invokestatic 212	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1287: aload_0
    //   1288: getfield 89	com/whatsapp/gdrive/bc:f	Ljava/io/File;
    //   1291: areturn
    //   1292: astore_1
    //   1293: aload 17
    //   1295: astore 16
    //   1297: ldc_w 549
    //   1300: aload_1
    //   1301: invokestatic 251	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1304: goto -48 -> 1256
    //   1307: astore_1
    //   1308: aconst_null
    //   1309: astore 16
    //   1311: goto -955 -> 356
    //   1314: astore 17
    //   1316: aconst_null
    //   1317: astore_1
    //   1318: goto -1024 -> 294
    //   1321: iload_2
    //   1322: istore 4
    //   1324: iload 5
    //   1326: ifeq -524 -> 802
    //   1329: iload_2
    //   1330: iconst_1
    //   1331: iadd
    //   1332: istore 4
    //   1334: goto -532 -> 802
    //   1337: iconst_0
    //   1338: istore 5
    //   1340: goto -19 -> 1321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1343	0	this	bc
    //   0	1343	1	paramev	ev
    //   85	1247	2	i1	int
    //   676	149	3	i2	int
    //   827	506	4	i3	int
    //   82	1257	5	i4	int
    //   79	1125	6	l1	long
    //   87	1141	8	l2	long
    //   73	1147	10	l3	long
    //   76	1136	12	l4	long
    //   672	149	14	l5	long
    //   33	241	16	localObject1	Object
    //   285	6	16	localIOException1	IOException
    //   295	1015	16	localObject2	Object
    //   29	1265	17	localObject3	Object
    //   1314	1	17	localIOException2	IOException
    //   70	38	18	localIterator	Iterator
    //   117	692	19	localbb	bb
    //   173	610	20	localObject4	Object
    //   184	340	21	str1	String
    //   195	347	22	str2	String
    //   214	564	23	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	285	java/io/IOException
    //   44	54	285	java/io/IOException
    //   58	72	285	java/io/IOException
    //   93	103	285	java/io/IOException
    //   107	119	285	java/io/IOException
    //   123	130	285	java/io/IOException
    //   134	157	285	java/io/IOException
    //   168	175	285	java/io/IOException
    //   179	186	285	java/io/IOException
    //   190	197	285	java/io/IOException
    //   201	216	285	java/io/IOException
    //   225	240	285	java/io/IOException
    //   244	271	285	java/io/IOException
    //   275	282	285	java/io/IOException
    //   325	352	285	java/io/IOException
    //   367	378	285	java/io/IOException
    //   382	394	285	java/io/IOException
    //   398	414	285	java/io/IOException
    //   418	456	285	java/io/IOException
    //   460	467	285	java/io/IOException
    //   474	479	285	java/io/IOException
    //   483	493	285	java/io/IOException
    //   497	511	285	java/io/IOException
    //   515	529	285	java/io/IOException
    //   533	547	285	java/io/IOException
    //   551	571	285	java/io/IOException
    //   575	586	285	java/io/IOException
    //   590	600	285	java/io/IOException
    //   604	625	285	java/io/IOException
    //   632	655	285	java/io/IOException
    //   659	666	285	java/io/IOException
    //   677	689	285	java/io/IOException
    //   693	703	285	java/io/IOException
    //   716	728	285	java/io/IOException
    //   732	742	285	java/io/IOException
    //   746	752	285	java/io/IOException
    //   756	764	285	java/io/IOException
    //   768	773	285	java/io/IOException
    //   777	796	285	java/io/IOException
    //   806	816	285	java/io/IOException
    //   837	848	285	java/io/IOException
    //   852	857	285	java/io/IOException
    //   861	881	285	java/io/IOException
    //   885	906	285	java/io/IOException
    //   910	931	285	java/io/IOException
    //   935	956	285	java/io/IOException
    //   960	981	285	java/io/IOException
    //   985	1006	285	java/io/IOException
    //   1010	1022	285	java/io/IOException
    //   1026	1039	285	java/io/IOException
    //   1043	1056	285	java/io/IOException
    //   1060	1073	285	java/io/IOException
    //   1077	1090	285	java/io/IOException
    //   1094	1107	285	java/io/IOException
    //   1111	1119	285	java/io/IOException
    //   1123	1143	285	java/io/IOException
    //   1147	1159	285	java/io/IOException
    //   1191	1239	285	java/io/IOException
    //   1243	1256	285	java/io/IOException
    //   1297	1304	285	java/io/IOException
    //   35	40	355	finally
    //   44	54	355	finally
    //   58	72	355	finally
    //   93	103	355	finally
    //   107	119	355	finally
    //   123	130	355	finally
    //   134	157	355	finally
    //   168	175	355	finally
    //   179	186	355	finally
    //   190	197	355	finally
    //   201	216	355	finally
    //   225	240	355	finally
    //   244	271	355	finally
    //   275	282	355	finally
    //   297	302	355	finally
    //   305	310	355	finally
    //   325	352	355	finally
    //   367	378	355	finally
    //   382	394	355	finally
    //   398	414	355	finally
    //   418	456	355	finally
    //   460	467	355	finally
    //   474	479	355	finally
    //   483	493	355	finally
    //   497	511	355	finally
    //   515	529	355	finally
    //   533	547	355	finally
    //   551	571	355	finally
    //   575	586	355	finally
    //   590	600	355	finally
    //   604	625	355	finally
    //   632	655	355	finally
    //   659	666	355	finally
    //   677	689	355	finally
    //   693	703	355	finally
    //   716	728	355	finally
    //   732	742	355	finally
    //   746	752	355	finally
    //   756	764	355	finally
    //   768	773	355	finally
    //   777	796	355	finally
    //   806	816	355	finally
    //   837	848	355	finally
    //   852	857	355	finally
    //   861	881	355	finally
    //   885	906	355	finally
    //   910	931	355	finally
    //   935	956	355	finally
    //   960	981	355	finally
    //   985	1006	355	finally
    //   1010	1022	355	finally
    //   1026	1039	355	finally
    //   1043	1056	355	finally
    //   1060	1073	355	finally
    //   1077	1090	355	finally
    //   1094	1107	355	finally
    //   1111	1119	355	finally
    //   1123	1143	355	finally
    //   1147	1159	355	finally
    //   1191	1239	355	finally
    //   1243	1256	355	finally
    //   1297	1304	355	finally
    //   861	881	1292	org/json/JSONException
    //   885	906	1292	org/json/JSONException
    //   910	931	1292	org/json/JSONException
    //   935	956	1292	org/json/JSONException
    //   960	981	1292	org/json/JSONException
    //   985	1006	1292	org/json/JSONException
    //   1010	1022	1292	org/json/JSONException
    //   1026	1039	1292	org/json/JSONException
    //   1043	1056	1292	org/json/JSONException
    //   1060	1073	1292	org/json/JSONException
    //   1077	1090	1292	org/json/JSONException
    //   1094	1107	1292	org/json/JSONException
    //   1111	1119	1292	org/json/JSONException
    //   1123	1143	1292	org/json/JSONException
    //   1147	1159	1292	org/json/JSONException
    //   1191	1239	1292	org/json/JSONException
    //   1243	1256	1292	org/json/JSONException
    //   11	31	1307	finally
    //   11	31	1314	java/io/IOException
  }
  
  public final void a(bb parambb)
  {
    parambb = (bb)this.e.put(parambb.d, parambb);
    if (parambb != null) {
      this.g.add(parambb);
    }
  }
  
  final boolean a()
  {
    if (this.b != null)
    {
      try
      {
        if (this.b.g == null) {
          throw new IllegalStateException("GD-file description is not initialized for map file");
        }
      }
      catch (JSONException localJSONException)
      {
        Log.d("gdrive-map/init-meta", localJSONException);
        return false;
      }
      this.c = new JSONObject(this.b.g);
      this.d = null;
      return true;
    }
    Log.e("gdrive-map/init-meta mDriveFile is null.");
    return false;
  }
  
  public final boolean a(boolean paramBoolean, final ev paramev)
  {
    for (;;)
    {
      try
      {
        this.e = new ConcurrentHashMap();
        if (paramBoolean)
        {
          paramBoolean = b(paramev);
          return paramBoolean;
        }
        if (this.b == null)
        {
          Log.d("gdrive-map/init getFileId of gdrive_file_map returned null.");
          paramBoolean = b(paramev);
          continue;
        }
        Object localObject;
        try
        {
          localObject = ch.a(this.l, this.n, this.f);
          if ((localObject != null) && (((String)localObject).equals(this.b.f)))
          {
            Log.d("gdrive-map/init no need to download, we already have latest file on the disk.");
            if (h()) {
              break label227;
            }
            Log.e("gdrive-map/init failed to read gdriveFileMap.");
            paramBoolean = b(paramev);
          }
        }
        catch (a paramev)
        {
          throw new IllegalStateException(this.f + " is stored on internal storage, read storage permission cannot interfere with that");
        }
        try
        {
          localBoolean = (Boolean)cs.a(paramev, new cf() {}, "gdrive-map/init/download-gdrive-file-map-file/" + paramev);
          localObject = localBoolean;
          if (localBoolean == null) {
            localObject = Boolean.valueOf(false);
          }
          if (((Boolean)localObject).booleanValue()) {
            continue;
          }
          paramBoolean = b(paramev);
        }
        catch (be localbe)
        {
          for (;;) {}
        }
        catch (a locala)
        {
          for (;;) {}
        }
      }
      finally {}
      for (;;)
      {
        Boolean localBoolean;
        Log.d("gdrive-map/init/file-not-found", (Throwable)localObject);
        localObject = Boolean.valueOf(false);
      }
      label227:
      Log.d("# of entries in gdriveFileMap: " + this.e.size());
      if (this.e.size() == 0)
      {
        Log.e("gdrive-map/init found gdrive_file_map but still the number of entries in gdriveFileMap is zero. We will generate a new map by reading all entries.");
        paramBoolean = b(paramev);
      }
      else
      {
        paramBoolean = true;
      }
    }
  }
  
  public final long b()
  {
    if (this.c != null) {
      return this.c.optLong("backupSize", -1L);
    }
    Log.e("gdrive-map/download-size metadata is null.");
    return -1L;
  }
  
  public final long c()
  {
    if (this.c != null) {
      return this.c.optLong("chatdbSize", -1L);
    }
    Log.e("gdrive-map/chat-size metadata is null.");
    return -1L;
  }
  
  public final long d()
  {
    if (this.c != null) {
      return this.c.optLong("mediaSize", -1L);
    }
    Log.e("gdrive-map/media-size metadata is null.");
    return -1L;
  }
  
  public final long e()
  {
    if (this.c != null) {
      return this.c.optLong("videoSize", -1L);
    }
    Log.e("gdrive-map/video-size metadata is null.");
    return -1L;
  }
  
  public final boolean f()
  {
    if (this.c != null) {
      return this.c.optBoolean("includeVideosInBackup", true);
    }
    Log.e("gdrive-map/include-videos-settings metadata is null.");
    return true;
  }
  
  public final JSONObject g()
  {
    if (this.c != null)
    {
      if (this.c.has("localSettings")) {
        try
        {
          JSONObject localJSONObject = this.c.getJSONObject("localSettings");
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          Log.d("gdrive-map/get-local-settings", localJSONException);
          return null;
        }
      }
      Log.i("gdrive-map/get-local-settings/localSettings-is-missing");
    }
    Log.e("gdrive-map/get-local-settings metadata is null.");
    return null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */