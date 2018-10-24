package com.whatsapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.ox;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.vk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class l
{
  private static volatile l a;
  private final d b;
  private final ox c;
  private final co d;
  private final z e;
  private final Map<j.b, j> f;
  private final n g;
  private final ReentrantReadWriteLock.ReadLock h;
  
  private l(d paramd, ox paramox, co paramco, aa paramaa, ch paramch)
  {
    this.b = paramd;
    this.c = paramox;
    this.d = paramco;
    this.e = paramaa.a;
    this.f = paramaa.b;
    this.g = paramch.a;
    this.h = paramch.b.readLock();
  }
  
  public static l a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new l(d.a(), ox.a(), co.a(), aa.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  private void a(Cursor paramCursor, j paramj)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_2
    //   4: aload_1
    //   5: bipush 8
    //   7: invokeinterface 97 2 0
    //   12: i2b
    //   13: putfield 103	com/whatsapp/protocol/j:s	B
    //   16: aload_2
    //   17: getfield 103	com/whatsapp/protocol/j:s	B
    //   20: iconst_1
    //   21: if_icmpeq +72 -> 93
    //   24: aload_2
    //   25: getfield 103	com/whatsapp/protocol/j:s	B
    //   28: iconst_5
    //   29: if_icmpeq +64 -> 93
    //   32: aload_2
    //   33: getfield 103	com/whatsapp/protocol/j:s	B
    //   36: iconst_3
    //   37: if_icmpeq +56 -> 93
    //   40: aload_2
    //   41: getfield 103	com/whatsapp/protocol/j:s	B
    //   44: iconst_2
    //   45: if_icmpeq +48 -> 93
    //   48: aload_2
    //   49: getfield 103	com/whatsapp/protocol/j:s	B
    //   52: bipush 9
    //   54: if_icmpeq +39 -> 93
    //   57: aload_2
    //   58: getfield 103	com/whatsapp/protocol/j:s	B
    //   61: bipush 13
    //   63: if_icmpeq +30 -> 93
    //   66: aload_2
    //   67: getfield 103	com/whatsapp/protocol/j:s	B
    //   70: bipush 14
    //   72: if_icmpeq +21 -> 93
    //   75: aload_2
    //   76: getfield 103	com/whatsapp/protocol/j:s	B
    //   79: bipush 12
    //   81: if_icmpeq +12 -> 93
    //   84: aload_2
    //   85: getfield 103	com/whatsapp/protocol/j:s	B
    //   88: bipush 16
    //   90: if_icmpne +407 -> 497
    //   93: aload_1
    //   94: bipush 19
    //   96: invokeinterface 107 2 0
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +378 -> 483
    //   108: aload_2
    //   109: aload 6
    //   111: invokevirtual 110	com/whatsapp/protocol/j:a	([B)V
    //   114: aload_2
    //   115: iconst_1
    //   116: putfield 114	com/whatsapp/protocol/j:m	I
    //   119: aload_2
    //   120: getfield 114	com/whatsapp/protocol/j:m	I
    //   123: ifne +16 -> 139
    //   126: aload_2
    //   127: invokevirtual 117	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   130: ifnonnull +9 -> 139
    //   133: aload_2
    //   134: ldc 119
    //   136: invokevirtual 122	com/whatsapp/protocol/j:e	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: aload_1
    //   141: bipush 29
    //   143: invokeinterface 126 2 0
    //   148: putfield 130	com/whatsapp/protocol/j:Q	J
    //   151: aload_1
    //   152: iconst_3
    //   153: invokeinterface 97 2 0
    //   158: iconst_2
    //   159: if_icmpne +352 -> 511
    //   162: iconst_1
    //   163: istore 4
    //   165: aload_2
    //   166: iload 4
    //   168: putfield 134	com/whatsapp/protocol/j:E	Z
    //   171: aload_2
    //   172: aload_1
    //   173: iconst_2
    //   174: invokeinterface 97 2 0
    //   179: putfield 136	com/whatsapp/protocol/j:d	I
    //   182: aload_2
    //   183: aload_1
    //   184: iconst_5
    //   185: invokeinterface 126 2 0
    //   190: putfield 139	com/whatsapp/protocol/j:n	J
    //   193: aload_2
    //   194: aload_1
    //   195: bipush 6
    //   197: invokeinterface 143 2 0
    //   202: putfield 147	com/whatsapp/protocol/j:p	Ljava/lang/String;
    //   205: aload_2
    //   206: aload_1
    //   207: bipush 7
    //   209: invokeinterface 143 2 0
    //   214: putfield 150	com/whatsapp/protocol/j:r	Ljava/lang/String;
    //   217: aload_2
    //   218: aload_1
    //   219: bipush 9
    //   221: invokeinterface 126 2 0
    //   226: putfield 153	com/whatsapp/protocol/j:t	J
    //   229: aload_2
    //   230: aload_1
    //   231: bipush 10
    //   233: invokeinterface 143 2 0
    //   238: putfield 156	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   241: aload_2
    //   242: aload_1
    //   243: bipush 11
    //   245: invokeinterface 143 2 0
    //   250: putfield 159	com/whatsapp/protocol/j:z	Ljava/lang/String;
    //   253: aload_2
    //   254: aload_1
    //   255: bipush 12
    //   257: invokeinterface 143 2 0
    //   262: putfield 162	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   265: aload_2
    //   266: aload_1
    //   267: bipush 28
    //   269: invokeinterface 143 2 0
    //   274: putfield 165	com/whatsapp/protocol/j:v	Ljava/lang/String;
    //   277: aload_2
    //   278: getfield 103	com/whatsapp/protocol/j:s	B
    //   281: bipush 9
    //   283: if_icmpne +234 -> 517
    //   286: aload_2
    //   287: aload_1
    //   288: bipush 13
    //   290: invokeinterface 97 2 0
    //   295: putfield 168	com/whatsapp/protocol/j:x	I
    //   298: aload_2
    //   299: aload_1
    //   300: bipush 14
    //   302: invokeinterface 97 2 0
    //   307: putfield 171	com/whatsapp/protocol/j:o	I
    //   310: aload_2
    //   311: aload_1
    //   312: bipush 15
    //   314: invokeinterface 175 2 0
    //   319: putfield 178	com/whatsapp/protocol/j:B	D
    //   322: aload_2
    //   323: aload_1
    //   324: bipush 16
    //   326: invokeinterface 175 2 0
    //   331: putfield 181	com/whatsapp/protocol/j:C	D
    //   334: aload_2
    //   335: aload_1
    //   336: bipush 18
    //   338: invokeinterface 143 2 0
    //   343: putfield 183	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   346: aload_2
    //   347: aload_1
    //   348: bipush 20
    //   350: invokeinterface 97 2 0
    //   355: putfield 186	com/whatsapp/protocol/j:F	I
    //   358: aload_2
    //   359: aload_1
    //   360: bipush 21
    //   362: invokeinterface 143 2 0
    //   367: putfield 188	com/whatsapp/protocol/j:g	Ljava/lang/String;
    //   370: aload_1
    //   371: bipush 22
    //   373: invokeinterface 97 2 0
    //   378: iconst_1
    //   379: if_icmpne +153 -> 532
    //   382: iload 5
    //   384: istore 4
    //   386: aload_2
    //   387: iload 4
    //   389: putfield 191	com/whatsapp/protocol/j:T	Z
    //   392: aload_2
    //   393: aload_1
    //   394: bipush 23
    //   396: invokeinterface 126 2 0
    //   401: putfield 194	com/whatsapp/protocol/j:U	J
    //   404: aload_2
    //   405: aload_1
    //   406: bipush 25
    //   408: invokeinterface 143 2 0
    //   413: putfield 197	com/whatsapp/protocol/j:W	Ljava/lang/String;
    //   416: aload_2
    //   417: aload_1
    //   418: bipush 26
    //   420: invokeinterface 97 2 0
    //   425: putfield 200	com/whatsapp/protocol/j:ab	I
    //   428: aload_2
    //   429: aload_1
    //   430: bipush 27
    //   432: invokeinterface 126 2 0
    //   437: putfield 202	com/whatsapp/protocol/j:I	J
    //   440: aload_1
    //   441: bipush 24
    //   443: invokeinterface 143 2 0
    //   448: astore 6
    //   450: aload 6
    //   452: ifnull +12 -> 464
    //   455: aload_2
    //   456: aload 6
    //   458: invokestatic 207	com/whatsapp/yr:a	(Ljava/lang/String;)Ljava/util/List;
    //   461: putfield 211	com/whatsapp/protocol/j:P	Ljava/util/List;
    //   464: aload_1
    //   465: bipush 17
    //   467: invokeinterface 107 2 0
    //   472: astore_1
    //   473: aload_1
    //   474: ifnonnull +64 -> 538
    //   477: aload_2
    //   478: aconst_null
    //   479: putfield 215	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   482: return
    //   483: aload_2
    //   484: aload_1
    //   485: iconst_4
    //   486: invokeinterface 143 2 0
    //   491: invokevirtual 122	com/whatsapp/protocol/j:e	(Ljava/lang/String;)V
    //   494: goto -375 -> 119
    //   497: aload_2
    //   498: aload_1
    //   499: iconst_4
    //   500: invokeinterface 143 2 0
    //   505: invokevirtual 122	com/whatsapp/protocol/j:e	(Ljava/lang/String;)V
    //   508: goto -389 -> 119
    //   511: iconst_0
    //   512: istore 4
    //   514: goto -349 -> 165
    //   517: aload_2
    //   518: aload_1
    //   519: bipush 13
    //   521: invokeinterface 97 2 0
    //   526: putfield 218	com/whatsapp/protocol/j:w	I
    //   529: goto -231 -> 298
    //   532: iconst_0
    //   533: istore 4
    //   535: goto -149 -> 386
    //   538: aconst_null
    //   539: astore 6
    //   541: aconst_null
    //   542: astore 8
    //   544: new 220	java/io/ObjectInputStream
    //   547: dup
    //   548: new 222	java/io/ByteArrayInputStream
    //   551: dup
    //   552: aload_1
    //   553: invokespecial 224	java/io/ByteArrayInputStream:<init>	([B)V
    //   556: invokespecial 227	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   559: astore_1
    //   560: aload_2
    //   561: aload_1
    //   562: invokevirtual 231	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   565: putfield 215	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   568: aload_1
    //   569: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   572: aload_2
    //   573: getfield 215	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   576: instanceof 236
    //   579: ifeq -97 -> 482
    //   582: aload_2
    //   583: invokevirtual 239	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   586: astore_1
    //   587: aload_1
    //   588: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   591: ifnull -109 -> 482
    //   594: aload_1
    //   595: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   598: invokevirtual 249	java/io/File:isAbsolute	()Z
    //   601: ifne +110 -> 711
    //   604: aload_1
    //   605: aload_0
    //   606: getfield 30	com/whatsapp/data/l:c	Lcom/whatsapp/ox;
    //   609: aload_1
    //   610: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   613: invokevirtual 252	java/io/File:getPath	()Ljava/lang/String;
    //   616: invokevirtual 255	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   619: putfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   622: return
    //   623: astore_1
    //   624: aload_1
    //   625: invokestatic 260	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   628: goto -56 -> 572
    //   631: astore 6
    //   633: aconst_null
    //   634: astore_1
    //   635: aload 6
    //   637: astore 7
    //   639: aload_1
    //   640: astore 6
    //   642: aload 7
    //   644: invokestatic 260	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   647: aload_1
    //   648: astore 6
    //   650: aload_2
    //   651: getfield 103	com/whatsapp/protocol/j:s	B
    //   654: ifeq +17 -> 671
    //   657: aload_1
    //   658: astore 6
    //   660: aload_2
    //   661: new 236	com/whatsapp/MediaData
    //   664: dup
    //   665: invokespecial 261	com/whatsapp/MediaData:<init>	()V
    //   668: putfield 215	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   671: aload_1
    //   672: ifnull -100 -> 572
    //   675: aload_1
    //   676: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   679: goto -107 -> 572
    //   682: astore_1
    //   683: aload_1
    //   684: invokestatic 260	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   687: goto -115 -> 572
    //   690: astore_1
    //   691: aload 6
    //   693: ifnull +8 -> 701
    //   696: aload 6
    //   698: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   701: aload_1
    //   702: athrow
    //   703: astore_2
    //   704: aload_2
    //   705: invokestatic 260	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   708: goto -7 -> 701
    //   711: aload_1
    //   712: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   715: invokevirtual 264	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   718: invokestatic 270	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   721: invokevirtual 264	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   724: invokevirtual 276	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   727: ifne -245 -> 482
    //   730: aload_1
    //   731: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   734: invokevirtual 264	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   737: ldc_w 278
    //   740: invokevirtual 282	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   743: istore_3
    //   744: iload_3
    //   745: ifle -263 -> 482
    //   748: aload_1
    //   749: aload_0
    //   750: getfield 30	com/whatsapp/data/l:c	Lcom/whatsapp/ox;
    //   753: aload_1
    //   754: getfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   757: invokevirtual 264	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   760: iload_3
    //   761: invokevirtual 285	java/lang/String:substring	(I)Ljava/lang/String;
    //   764: invokevirtual 255	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   767: putfield 243	com/whatsapp/MediaData:file	Ljava/io/File;
    //   770: return
    //   771: astore_2
    //   772: aload_1
    //   773: astore 6
    //   775: aload_2
    //   776: astore_1
    //   777: goto -86 -> 691
    //   780: astore 7
    //   782: aload 8
    //   784: astore_1
    //   785: goto -146 -> 639
    //   788: astore 7
    //   790: goto -151 -> 639
    //   793: astore 6
    //   795: goto -160 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	l
    //   0	798	1	paramCursor	Cursor
    //   0	798	2	paramj	j
    //   743	18	3	i	int
    //   163	371	4	bool1	boolean
    //   1	382	5	bool2	boolean
    //   101	439	6	localObject1	Object
    //   631	5	6	localIOException1	java.io.IOException
    //   640	134	6	localCursor	Cursor
    //   793	1	6	localIOException2	java.io.IOException
    //   637	6	7	localIOException3	java.io.IOException
    //   780	1	7	localClassNotFoundException1	ClassNotFoundException
    //   788	1	7	localClassNotFoundException2	ClassNotFoundException
    //   542	241	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   568	572	623	java/io/IOException
    //   544	560	631	java/io/IOException
    //   675	679	682	java/io/IOException
    //   544	560	690	finally
    //   642	647	690	finally
    //   650	657	690	finally
    //   660	671	690	finally
    //   696	701	703	java/io/IOException
    //   560	568	771	finally
    //   544	560	780	java/lang/ClassNotFoundException
    //   560	568	788	java/lang/ClassNotFoundException
    //   560	568	793	java/io/IOException
  }
  
  private j b(long paramLong)
  {
    boolean bool = true;
    Object localObject5 = null;
    Object localObject1 = null;
    this.h.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.g.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages_quotes WHERE _id=?", new String[] { String.valueOf(paramLong) });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToLast())
            {
              localObject1 = localCursor.getString(1);
              if (localCursor.getInt(0) == 1)
              {
                localObject1 = new j(new j.b(localCursor.getString(localCursor.getColumnIndex("key_remote_jid")), bool, (String)localObject1));
                a(localCursor, (j)localObject1);
                localCursor.close();
                return (j)localObject1;
              }
              bool = false;
              continue;
            }
            Log.w("msgstore/getquoted no quote");
            continue;
            localObject3 = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.e("msgstore/getquoted no cursor!");
      }
      finally
      {
        this.h.unlock();
      }
      Object localObject4 = localObject5;
    }
  }
  
  private j b(j.b paramb)
  {
    j localj = this.e.b(paramb);
    Object localObject = localj;
    if (localj == null)
    {
      localj = vk.a(paramb);
      if (localj != null) {
        return localj;
      }
      localObject = (ad.d)this.b.a.get(paramb.a);
      if ((localObject == null) || (((ad.d)localObject).b == null) || (!paramb.equals(((ad.d)localObject).b.e))) {
        break label173;
      }
      localj = ((ad.d)localObject).b;
    }
    label173:
    for (;;)
    {
      localObject = localj;
      if (localj == null)
      {
        localj = (j)this.f.get(paramb);
        localObject = localj;
        if (localj == null)
        {
          localObject = localj;
          if (this.d.c != null)
          {
            ad.n localn = (ad.n)this.d.c.get(paramb.a);
            localObject = localj;
            if (localn != null)
            {
              localObject = localj;
              if (localn.c != null)
              {
                localObject = localj;
                if (paramb.equals(localn.c.e)) {
                  localObject = localn.c;
                }
              }
            }
          }
        }
      }
      return (j)localObject;
    }
    return localj;
  }
  
  public final j a(long paramLong)
  {
    Object localObject4 = null;
    j localj = null;
    this.h.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.g.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE _id=?", new String[] { String.valueOf(paramLong) });
        if (localCursor != null)
        {
          int i = localCursor.getColumnIndex("key_remote_jid");
          try
          {
            if (localCursor.moveToLast()) {
              localj = a(localCursor, localCursor.getString(i));
            }
            localCursor.close();
            return localj;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.e("msgstore/getmessage no cursor!");
      }
      finally
      {
        this.h.unlock();
      }
      Object localObject3 = localObject4;
    }
  }
  
  public final j a(Cursor paramCursor, String paramString)
  {
    boolean bool = true;
    if ((paramCursor == null) || (paramString == null)) {
      paramString = null;
    }
    j.b localb;
    do
    {
      return paramString;
      if (paramCursor.getColumnCount() == 1) {
        return a(paramCursor.getLong(0));
      }
      ??? = paramCursor.getString(1);
      if ((??? == null) || (((String)???).equals("-1")))
      {
        Log.w("msgstore/getmsg/id is null or no messages for jid=" + paramString);
        return null;
      }
      if (paramCursor.getInt(0) != 1) {
        break;
      }
      localb = new j.b(paramString, bool, (String)???);
      ??? = b(localb);
      paramString = (String)???;
    } while (??? != null);
    paramString = new j(localb);
    a(paramCursor, paramString);
    if (paramString.U != 0L) {
      paramString.V = b(paramString.U);
    }
    for (;;)
    {
      synchronized (this.e)
      {
        paramCursor = b(localb);
        if (paramCursor == null) {
          break label196;
        }
        return paramCursor;
      }
      bool = false;
      break;
      label196:
      this.e.a(paramString.e, paramString);
      paramCursor = paramString;
    }
  }
  
  public final j a(j.b paramb)
  {
    int i = 1;
    if (paramb == null) {
      return null;
    }
    this.h.lock();
    for (;;)
    {
      try
      {
        j localj = b(paramb);
        if (localj != null) {
          return localj;
        }
        Object localObject = this.g.getReadableDatabase();
        String str = paramb.a;
        if (paramb.b)
        {
          localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? AND key_from_me=? AND key_id=?", new String[] { str, String.valueOf(i), paramb.c });
          if (localObject == null) {}
        }
        else
        {
          try
          {
            if (((Cursor)localObject).moveToLast()) {
              localj = a((Cursor)localObject, paramb.a);
            }
            ((Cursor)localObject).close();
            return localj;
          }
          finally
          {
            ((Cursor)localObject).close();
          }
          i = 0;
          continue;
        }
        Log.e("msgstore/getmessage no cursor!");
      }
      finally
      {
        this.h.unlock();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */