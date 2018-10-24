package com.whatsapp.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.whatsapp.MediaData;
import com.whatsapp.and;
import com.whatsapp.anv;
import com.whatsapp.atv;
import com.whatsapp.cc;
import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.lt;
import com.whatsapp.pd;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.registration.bb;
import com.whatsapp.util.b;
import com.whatsapp.va;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public final class ag
  implements Runnable
{
  private static final String[] t = { "_id" };
  private static final HashMap<Uri, Boolean> u = new HashMap();
  private final j a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final pv e = pv.a();
  private final va f = va.a();
  private final anv g = anv.a();
  private final ad h = ad.a();
  private final e i = e.a();
  private final and j = and.a();
  private final b k = b.a();
  private final l l = l.a();
  private final cc m = cc.a();
  private final m n = m.a();
  private final f o = f.a();
  private final atv p = atv.a();
  private final lt q = lt.a();
  private final pd r = pd.a();
  private final bb s = bb.a();
  
  public ag(j paramj, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramj;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
  }
  
  private static Bitmap a(Context paramContext, j paramj)
  {
    paramj = paramj.b();
    if ((paramj.transferred) && (paramj.file != null) && (paramj.file.exists())) {
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        int i1 = paramContext.getWidth();
        int i2 = paramContext.getHeight();
        paramContext = new BitmapFactory.Options();
        paramContext.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramj.file.getAbsolutePath(), paramContext);
        i2 = i1 * i2;
        i1 = paramContext.outWidth * paramContext.outHeight;
        paramContext.inSampleSize = 1;
        if (i2 != 0) {
          while (i1 > i2)
          {
            paramContext.inSampleSize <<= 1;
            i1 /= 4;
          }
        }
        paramContext.inJustDecodeBounds = false;
        paramContext = BitmapFactory.decodeFile(paramj.file.getAbsolutePath(), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    }
    return null;
  }
  
  /* Error */
  public static boolean a(and paramand, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 66	com/whatsapp/notification/ag:u	Ljava/util/HashMap;
    //   5: aload_1
    //   6: invokevirtual 261	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: checkcast 263	java/lang/Boolean
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +8 -> 22
    //   17: aload_3
    //   18: invokevirtual 266	java/lang/Boolean:booleanValue	()Z
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 269	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +22 -> 50
    //   31: ldc_w 271
    //   34: invokestatic 277	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   37: getstatic 66	com/whatsapp/notification/ag:u	Ljava/util/HashMap;
    //   40: aload_1
    //   41: getstatic 281	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   44: invokevirtual 285	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: iconst_0
    //   49: ireturn
    //   50: aload_0
    //   51: aload_1
    //   52: getstatic 59	com/whatsapp/notification/ag:t	[Ljava/lang/String;
    //   55: ldc_w 287
    //   58: aconst_null
    //   59: ldc_w 289
    //   62: invokevirtual 295	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +35 -> 102
    //   70: aload_0
    //   71: invokeinterface 300 1 0
    //   76: ifle +26 -> 102
    //   79: getstatic 66	com/whatsapp/notification/ag:u	Ljava/util/HashMap;
    //   82: aload_1
    //   83: getstatic 303	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   86: invokevirtual 285	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: ifnull +9 -> 100
    //   94: aload_0
    //   95: invokeinterface 306 1 0
    //   100: iconst_1
    //   101: ireturn
    //   102: aload_0
    //   103: ifnull -66 -> 37
    //   106: aload_0
    //   107: invokeinterface 306 1 0
    //   112: goto -75 -> 37
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull -82 -> 37
    //   122: aload_0
    //   123: invokeinterface 306 1 0
    //   128: goto -91 -> 37
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +9 -> 144
    //   138: aload_0
    //   139: invokeinterface 306 1 0
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: goto -13 -> 134
    //   150: astore_2
    //   151: goto -33 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramand	and
    //   0	154	1	paramUri	Uri
    //   1	132	2	localObject	Object
    //   150	1	2	localException	Exception
    //   12	6	3	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   50	66	115	java/lang/Exception
    //   50	66	131	finally
    //   70	90	146	finally
    //   70	90	150	java/lang/Exception
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ag)paramObject;
    } while (((this.a == ((ag)paramObject).a) || ((this.a != null) && (((ag)paramObject).a != null) && (((ag)paramObject).a.e.equals(this.a.e)))) && (this.d == ((ag)paramObject).d) && (this.c == ((ag)paramObject).c) && (this.b == ((ag)paramObject).b));
    return false;
  }
  
  public final int hashCode()
  {
    int i4 = 1;
    int i1;
    int i2;
    label21:
    int i3;
    if (this.a == null)
    {
      i1 = 0;
      if (!this.b) {
        break label66;
      }
      i2 = 1;
      if (!this.c) {
        break label71;
      }
      i3 = 1;
      label30:
      if (!this.d) {
        break label76;
      }
    }
    for (;;)
    {
      return (i3 + (i2 + i1 * 31) * 31) * 31 + i4;
      i1 = this.a.hashCode();
      break;
      label66:
      i2 = 0;
      break label21;
      label71:
      i3 = 0;
      break label30;
      label76:
      i4 = 0;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 331	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 333
    //   7: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore 17
    //   12: aload_0
    //   13: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   16: ifnonnull +77 -> 93
    //   19: ldc_w 337
    //   22: astore 16
    //   24: aload 17
    //   26: aload 16
    //   28: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 343
    //   34: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 178	com/whatsapp/notification/ag:b	Z
    //   41: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc_w 348
    //   47: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 180	com/whatsapp/notification/ag:c	Z
    //   54: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc_w 350
    //   60: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 182	com/whatsapp/notification/ag:d	Z
    //   67: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   70: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 355	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 174	com/whatsapp/notification/ag:s	Lcom/whatsapp/registration/bb;
    //   80: invokevirtual 357	com/whatsapp/registration/bb:b	()Z
    //   83: ifne +22 -> 105
    //   86: ldc_w 359
    //   89: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   92: return
    //   93: aload_0
    //   94: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   97: invokestatic 364	com/whatsapp/util/Log:a	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   100: astore 16
    //   102: goto -78 -> 24
    //   105: aload_0
    //   106: getfield 132	com/whatsapp/notification/ag:m	Lcom/whatsapp/cc;
    //   109: invokevirtual 367	com/whatsapp/cc:e	()Lcom/whatsapp/cc$a;
    //   112: astore 20
    //   114: aload_0
    //   115: getfield 132	com/whatsapp/notification/ag:m	Lcom/whatsapp/cc;
    //   118: invokevirtual 369	com/whatsapp/cc:d	()Lcom/whatsapp/cc$a;
    //   121: astore 21
    //   123: aload 21
    //   125: invokevirtual 373	com/whatsapp/cc$a:g	()Ljava/lang/String;
    //   128: invokestatic 379	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: istore_1
    //   132: aload 20
    //   134: invokevirtual 373	com/whatsapp/cc$a:g	()Ljava/lang/String;
    //   137: invokestatic 379	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   140: istore_2
    //   141: aload 21
    //   143: invokevirtual 381	com/whatsapp/cc$a:d	()Ljava/lang/String;
    //   146: astore 16
    //   148: aload 20
    //   150: invokevirtual 381	com/whatsapp/cc$a:d	()Ljava/lang/String;
    //   153: astore 17
    //   155: aload 21
    //   157: invokevirtual 383	com/whatsapp/cc$a:f	()Ljava/lang/String;
    //   160: astore 18
    //   162: aload 20
    //   164: invokevirtual 383	com/whatsapp/cc$a:f	()Ljava/lang/String;
    //   167: astore 19
    //   169: aload 21
    //   171: invokevirtual 385	com/whatsapp/cc$a:e	()Ljava/lang/String;
    //   174: astore 21
    //   176: aload 20
    //   178: invokevirtual 385	com/whatsapp/cc$a:e	()Ljava/lang/String;
    //   181: astore 20
    //   183: iload_1
    //   184: ifne +80 -> 264
    //   187: iload_2
    //   188: ifne +76 -> 264
    //   191: aload 16
    //   193: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +68 -> 264
    //   199: aload 17
    //   201: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +60 -> 264
    //   207: ldc_w 393
    //   210: aload 18
    //   212: invokestatic 396	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   215: ifeq +49 -> 264
    //   218: ldc_w 393
    //   221: aload 19
    //   223: invokestatic 396	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   226: ifeq +38 -> 264
    //   229: ldc_w 398
    //   232: aload 21
    //   234: invokestatic 396	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   237: ifeq +27 -> 264
    //   240: ldc_w 398
    //   243: aload 20
    //   245: invokestatic 396	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   248: ifeq +16 -> 264
    //   251: iconst_1
    //   252: istore_1
    //   253: iload_1
    //   254: ifeq +15 -> 269
    //   257: ldc_w 400
    //   260: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   263: return
    //   264: iconst_0
    //   265: istore_1
    //   266: goto -13 -> 253
    //   269: aload_0
    //   270: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   273: ifnull +24 -> 297
    //   276: aload_0
    //   277: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   280: aload_0
    //   281: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   284: invokevirtual 403	com/whatsapp/notification/f:a	(Lcom/whatsapp/protocol/j;)Z
    //   287: ifne +10 -> 297
    //   290: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   293: invokestatic 413	com/whatsapp/appwidget/WidgetProvider:a	(Landroid/content/Context;)V
    //   296: return
    //   297: aload_0
    //   298: getfield 111	com/whatsapp/notification/ag:j	Lcom/whatsapp/and;
    //   301: getfield 416	com/whatsapp/and:c	Landroid/telephony/TelephonyManager;
    //   304: astore 25
    //   306: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   309: invokestatic 421	android/support/v4/app/aw:a	(Landroid/content/Context;)Landroid/support/v4/app/aw;
    //   312: astore 24
    //   314: aconst_null
    //   315: astore 16
    //   317: aconst_null
    //   318: astore 17
    //   320: new 331	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   327: astore 26
    //   329: new 331	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   336: astore 21
    //   338: aload_0
    //   339: getfield 160	com/whatsapp/notification/ag:q	Lcom/whatsapp/lt;
    //   342: invokevirtual 425	com/whatsapp/lt:j	()Ljava/util/ArrayList;
    //   345: astore 23
    //   347: aload 23
    //   349: invokevirtual 431	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   352: astore 20
    //   354: iconst_0
    //   355: istore_2
    //   356: iconst_0
    //   357: istore_3
    //   358: aload 20
    //   360: invokeinterface 436 1 0
    //   365: ifeq +210 -> 575
    //   368: aload 20
    //   370: invokeinterface 440 1 0
    //   375: checkcast 55	java/lang/String
    //   378: astore 19
    //   380: aload_0
    //   381: getfield 97	com/whatsapp/notification/ag:h	Lcom/whatsapp/data/ad;
    //   384: aload 19
    //   386: invokevirtual 442	com/whatsapp/data/ad:o	(Ljava/lang/String;)I
    //   389: istore_1
    //   390: iload_1
    //   391: ifle -33 -> 358
    //   394: aload_0
    //   395: getfield 97	com/whatsapp/notification/ag:h	Lcom/whatsapp/data/ad;
    //   398: aload 19
    //   400: iconst_1
    //   401: invokevirtual 445	com/whatsapp/data/ad:b	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   404: astore 18
    //   406: aload 18
    //   408: invokevirtual 447	java/util/ArrayList:isEmpty	()Z
    //   411: ifeq +116 -> 527
    //   414: aconst_null
    //   415: astore 18
    //   417: aload 18
    //   419: ifnull +122 -> 541
    //   422: aload_0
    //   423: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   426: aload 18
    //   428: invokevirtual 403	com/whatsapp/notification/f:a	(Lcom/whatsapp/protocol/j;)Z
    //   431: ifeq -73 -> 358
    //   434: aload 17
    //   436: ifnull +17 -> 453
    //   439: aload 17
    //   441: getfield 451	com/whatsapp/protocol/j:Q	J
    //   444: aload 18
    //   446: getfield 451	com/whatsapp/protocol/j:Q	J
    //   449: lcmp
    //   450: ifge +4793 -> 5243
    //   453: aload_0
    //   454: getfield 104	com/whatsapp/notification/ag:i	Lcom/whatsapp/data/e;
    //   457: aload 19
    //   459: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   462: astore 17
    //   464: aload 18
    //   466: astore 16
    //   468: aload 21
    //   470: aload 18
    //   472: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   475: getfield 457	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   478: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload 18
    //   483: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   486: getfield 458	com/whatsapp/protocol/j$b:b	Z
    //   489: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: aload 18
    //   494: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   497: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   500: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 17
    //   506: astore 18
    //   508: iload_1
    //   509: iload_2
    //   510: iadd
    //   511: istore_2
    //   512: iload_3
    //   513: iconst_1
    //   514: iadd
    //   515: istore_3
    //   516: aload 16
    //   518: astore 17
    //   520: aload 18
    //   522: astore 16
    //   524: goto -166 -> 358
    //   527: aload 18
    //   529: iconst_0
    //   530: invokevirtual 463	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   533: checkcast 187	com/whatsapp/protocol/j
    //   536: astore 18
    //   538: goto -121 -> 417
    //   541: new 331	java/lang/StringBuilder
    //   544: dup
    //   545: ldc_w 465
    //   548: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   551: aload 19
    //   553: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 467
    //   559: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload_1
    //   563: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 277	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   572: goto -214 -> 358
    //   575: aload_0
    //   576: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   579: ifnull +4653 -> 5232
    //   582: aload_0
    //   583: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   586: astore 20
    //   588: aload_0
    //   589: getfield 104	com/whatsapp/notification/ag:i	Lcom/whatsapp/data/e;
    //   592: aload_0
    //   593: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   596: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   599: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   602: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   605: astore 19
    //   607: aload 21
    //   609: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 475	com/whatsapp/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   615: astore 27
    //   617: aload 27
    //   619: aload_0
    //   620: getfield 153	com/whatsapp/notification/ag:p	Lcom/whatsapp/atv;
    //   623: getfield 478	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   626: ldc_w 480
    //   629: aconst_null
    //   630: invokeinterface 486 3 0
    //   635: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   638: ifeq +25 -> 663
    //   641: new 331	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 489
    //   648: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload 27
    //   653: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   662: return
    //   663: iload_3
    //   664: ifeq +8 -> 672
    //   667: aload 19
    //   669: ifnonnull +29 -> 698
    //   672: aload 24
    //   674: iconst_1
    //   675: invokevirtual 492	android/support/v4/app/aw:a	(I)V
    //   678: aload_0
    //   679: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   682: ifnull +9 -> 691
    //   685: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   688: invokestatic 413	com/whatsapp/appwidget/WidgetProvider:a	(Landroid/content/Context;)V
    //   691: ldc_w 494
    //   694: invokestatic 355	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   697: return
    //   698: aload 20
    //   700: ifnull +15 -> 715
    //   703: aload_0
    //   704: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   707: aload 20
    //   709: invokevirtual 403	com/whatsapp/notification/f:a	(Lcom/whatsapp/protocol/j;)Z
    //   712: ifne +41 -> 753
    //   715: new 331	java/lang/StringBuilder
    //   718: dup
    //   719: ldc_w 496
    //   722: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   725: aload 19
    //   727: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   730: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   739: aload_0
    //   740: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   743: ifnull -651 -> 92
    //   746: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   749: invokestatic 413	com/whatsapp/appwidget/WidgetProvider:a	(Landroid/content/Context;)V
    //   752: return
    //   753: aload_0
    //   754: getfield 132	com/whatsapp/notification/ag:m	Lcom/whatsapp/cc;
    //   757: aload 19
    //   759: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   762: invokevirtual 503	com/whatsapp/cc:a	(Ljava/lang/String;)Lcom/whatsapp/cc$a;
    //   765: astore 28
    //   767: iload_3
    //   768: iconst_1
    //   769: if_icmpne +434 -> 1203
    //   772: aload 19
    //   774: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   777: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   780: invokestatic 509	com/whatsapp/emoji/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 18
    //   785: iload_2
    //   786: iconst_1
    //   787: if_icmpne +387 -> 1174
    //   790: aload_0
    //   791: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   794: aload 20
    //   796: aload 19
    //   798: iconst_0
    //   799: iconst_0
    //   800: invokevirtual 512	com/whatsapp/notification/m:a	(Lcom/whatsapp/protocol/j;Lcom/whatsapp/data/cs;ZZ)Ljava/lang/CharSequence;
    //   803: astore 17
    //   805: new 514	android/support/v4/app/an$d
    //   808: dup
    //   809: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   812: invokespecial 516	android/support/v4/app/an$d:<init>	(Landroid/content/Context;)V
    //   815: astore 29
    //   817: aload 29
    //   819: ldc_w 518
    //   822: invokevirtual 521	android/support/v4/app/an$d:a	(Ljava/lang/String;)Landroid/support/v4/app/an$d;
    //   825: pop
    //   826: aload 19
    //   828: invokevirtual 523	com/whatsapp/data/cs:d	()Z
    //   831: ifne +23 -> 854
    //   834: aload_0
    //   835: getfield 111	com/whatsapp/notification/ag:j	Lcom/whatsapp/and;
    //   838: getfield 269	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   841: astore 16
    //   843: aload 16
    //   845: ifnonnull +429 -> 1274
    //   848: ldc_w 525
    //   851: invokestatic 277	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   854: aload 29
    //   856: ldc_w 527
    //   859: invokevirtual 529	android/support/v4/app/an$d:c	(Ljava/lang/String;)Landroid/support/v4/app/an$d;
    //   862: pop
    //   863: aload 29
    //   865: iconst_1
    //   866: invokevirtual 532	android/support/v4/app/an$d:d	(Z)Landroid/support/v4/app/an$d;
    //   869: pop
    //   870: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   873: bipush 16
    //   875: if_icmplt +4351 -> 5226
    //   878: iload_3
    //   879: iconst_1
    //   880: if_icmpne +4346 -> 5226
    //   883: aload 20
    //   885: getfield 540	com/whatsapp/protocol/j:s	B
    //   888: iconst_1
    //   889: if_icmpne +4337 -> 5226
    //   892: aload 20
    //   894: getfield 544	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   897: ifnull +4329 -> 5226
    //   900: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   903: aload 20
    //   905: invokestatic 546	com/whatsapp/notification/ag:a	(Landroid/content/Context;Lcom/whatsapp/protocol/j;)Landroid/graphics/Bitmap;
    //   908: astore 22
    //   910: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   913: invokevirtual 550	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   916: ldc_w 551
    //   919: invokevirtual 557	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   922: istore 4
    //   924: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   927: invokevirtual 550	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   930: ldc_w 558
    //   933: invokevirtual 557	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   936: istore 5
    //   938: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   941: bipush 11
    //   943: if_icmplt +384 -> 1327
    //   946: iload_3
    //   947: iconst_1
    //   948: if_icmpne +379 -> 1327
    //   951: aload 19
    //   953: iload 4
    //   955: iload 5
    //   957: invokevirtual 561	com/whatsapp/data/cs:c	(II)Landroid/graphics/Bitmap;
    //   960: astore 16
    //   962: aload 16
    //   964: ifnull +338 -> 1302
    //   967: aload 26
    //   969: ldc_w 563
    //   972: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: aload 29
    //   978: aload 16
    //   980: invokevirtual 566	android/support/v4/app/an$d:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$d;
    //   983: pop
    //   984: invokestatic 569	com/whatsapp/notification/AndroidWear:b	()Z
    //   987: istore 8
    //   989: aconst_null
    //   990: astore 21
    //   992: invokestatic 571	com/whatsapp/notification/AndroidWear:a	()Z
    //   995: ifeq +16 -> 1011
    //   998: aload 19
    //   1000: sipush 400
    //   1003: sipush 400
    //   1006: invokevirtual 561	com/whatsapp/data/cs:c	(II)Landroid/graphics/Bitmap;
    //   1009: astore 21
    //   1011: aload_0
    //   1012: getfield 90	com/whatsapp/notification/ag:g	Lcom/whatsapp/anv;
    //   1015: invokevirtual 573	com/whatsapp/anv:e	()Z
    //   1018: istore 9
    //   1020: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   1023: bipush 16
    //   1025: if_icmplt +1984 -> 3009
    //   1028: iload_3
    //   1029: iconst_1
    //   1030: if_icmpne +39 -> 1069
    //   1033: iload 9
    //   1035: ifeq +34 -> 1069
    //   1038: aload 19
    //   1040: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   1043: invokestatic 576	com/whatsapp/data/e:b	(Ljava/lang/String;)Z
    //   1046: ifne +23 -> 1069
    //   1049: invokestatic 579	com/whatsapp/notification/DirectReplyService:a	()Z
    //   1052: ifeq +281 -> 1333
    //   1055: aload 29
    //   1057: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1060: aload 19
    //   1062: invokestatic 582	com/whatsapp/notification/DirectReplyService:a	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/support/v4/app/an$a;
    //   1065: invokevirtual 585	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$a;)Landroid/support/v4/app/an$d;
    //   1068: pop
    //   1069: iload_2
    //   1070: iconst_1
    //   1071: if_icmple +1470 -> 2541
    //   1074: new 427	java/util/ArrayList
    //   1077: dup
    //   1078: invokespecial 586	java/util/ArrayList:<init>	()V
    //   1081: astore 22
    //   1083: new 427	java/util/ArrayList
    //   1086: dup
    //   1087: invokespecial 586	java/util/ArrayList:<init>	()V
    //   1090: astore 30
    //   1092: aload 23
    //   1094: invokevirtual 431	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1097: astore 23
    //   1099: aload 23
    //   1101: invokeinterface 436 1 0
    //   1106: ifeq +303 -> 1409
    //   1109: aload 23
    //   1111: invokeinterface 440 1 0
    //   1116: checkcast 55	java/lang/String
    //   1119: astore 31
    //   1121: aload_0
    //   1122: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   1125: aload 31
    //   1127: invokevirtual 589	com/whatsapp/notification/f:b	(Ljava/lang/String;)Ljava/util/List;
    //   1130: astore 31
    //   1132: aload 31
    //   1134: invokeinterface 594 1 0
    //   1139: ifle +24 -> 1163
    //   1142: aload 30
    //   1144: aload 31
    //   1146: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1149: pop
    //   1150: aload 31
    //   1152: new 10	com/whatsapp/notification/ag$a
    //   1155: dup
    //   1156: aload_0
    //   1157: invokespecial 600	com/whatsapp/notification/ag$a:<init>	(Lcom/whatsapp/notification/ag;)V
    //   1160: invokestatic 606	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1163: aload 22
    //   1165: aload 31
    //   1167: invokevirtual 610	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1170: pop
    //   1171: goto -72 -> 1099
    //   1174: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   1177: ldc_w 614
    //   1180: iload_2
    //   1181: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   1184: iconst_1
    //   1185: anewarray 4	java/lang/Object
    //   1188: dup
    //   1189: iconst_0
    //   1190: iload_2
    //   1191: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1194: aastore
    //   1195: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1198: astore 17
    //   1200: goto -395 -> 805
    //   1203: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1206: ldc_w 628
    //   1209: invokevirtual 631	android/content/Context:getString	(I)Ljava/lang/String;
    //   1212: astore 18
    //   1214: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   1217: ldc_w 632
    //   1220: iload_2
    //   1221: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   1224: iconst_1
    //   1225: anewarray 4	java/lang/Object
    //   1228: dup
    //   1229: iconst_0
    //   1230: iload_2
    //   1231: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1234: aastore
    //   1235: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1238: astore 16
    //   1240: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   1243: ldc_w 633
    //   1246: iload_3
    //   1247: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   1250: iconst_2
    //   1251: anewarray 4	java/lang/Object
    //   1254: dup
    //   1255: iconst_0
    //   1256: aload 16
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_1
    //   1261: iload_3
    //   1262: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1265: aastore
    //   1266: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1269: astore 17
    //   1271: goto -466 -> 805
    //   1274: aload 19
    //   1276: aload 16
    //   1278: invokevirtual 636	com/whatsapp/data/cs:b	(Landroid/content/ContentResolver;)Landroid/net/Uri;
    //   1281: astore 16
    //   1283: aload 16
    //   1285: ifnull -431 -> 854
    //   1288: aload 29
    //   1290: aload 16
    //   1292: invokevirtual 639	android/net/Uri:toString	()Ljava/lang/String;
    //   1295: invokevirtual 641	android/support/v4/app/an$d:b	(Ljava/lang/String;)Landroid/support/v4/app/an$d;
    //   1298: pop
    //   1299: goto -445 -> 854
    //   1302: aload 19
    //   1304: iload 4
    //   1306: iload 5
    //   1308: invokestatic 647	java/lang/Math:min	(II)I
    //   1311: invokevirtual 650	com/whatsapp/data/cs:a	(I)Landroid/graphics/Bitmap;
    //   1314: astore 16
    //   1316: aload 29
    //   1318: aload 16
    //   1320: invokevirtual 566	android/support/v4/app/an$d:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$d;
    //   1323: pop
    //   1324: goto -340 -> 984
    //   1327: aconst_null
    //   1328: astore 16
    //   1330: goto -346 -> 984
    //   1333: new 652	android/content/Intent
    //   1336: dup
    //   1337: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1340: ldc_w 654
    //   1343: invokespecial 657	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1346: astore 30
    //   1348: aload 30
    //   1350: ldc_w 659
    //   1353: aload 19
    //   1355: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   1358: invokevirtual 663	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1361: pop
    //   1362: aload 30
    //   1364: ldc_w 665
    //   1367: iconst_1
    //   1368: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1371: pop
    //   1372: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1375: iconst_0
    //   1376: aload 30
    //   1378: ldc_w 669
    //   1381: invokestatic 675	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   1384: astore 30
    //   1386: aload 29
    //   1388: ldc_w 676
    //   1391: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1394: ldc_w 677
    //   1397: invokevirtual 631	android/content/Context:getString	(I)Ljava/lang/String;
    //   1400: aload 30
    //   1402: invokevirtual 680	android/support/v4/app/an$d:a	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/support/v4/app/an$d;
    //   1405: pop
    //   1406: goto -337 -> 1069
    //   1409: aload 22
    //   1411: new 10	com/whatsapp/notification/ag$a
    //   1414: dup
    //   1415: aload_0
    //   1416: invokespecial 600	com/whatsapp/notification/ag$a:<init>	(Lcom/whatsapp/notification/ag;)V
    //   1419: invokestatic 606	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1422: aload 22
    //   1424: invokevirtual 681	java/util/ArrayList:size	()I
    //   1427: iconst_1
    //   1428: if_icmple +216 -> 1644
    //   1431: new 683	android/support/v4/app/an$h
    //   1434: dup
    //   1435: invokespecial 684	android/support/v4/app/an$h:<init>	()V
    //   1438: astore 23
    //   1440: iconst_0
    //   1441: aload 22
    //   1443: invokevirtual 681	java/util/ArrayList:size	()I
    //   1446: bipush 7
    //   1448: isub
    //   1449: invokestatic 687	java/lang/Math:max	(II)I
    //   1452: istore_1
    //   1453: iload_1
    //   1454: aload 22
    //   1456: invokevirtual 681	java/util/ArrayList:size	()I
    //   1459: if_icmpge +147 -> 1606
    //   1462: aload 22
    //   1464: iload_1
    //   1465: invokevirtual 463	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1468: checkcast 187	com/whatsapp/protocol/j
    //   1471: astore 31
    //   1473: aload_0
    //   1474: getfield 104	com/whatsapp/notification/ag:i	Lcom/whatsapp/data/e;
    //   1477: aload 31
    //   1479: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1482: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1485: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   1488: astore 32
    //   1490: aload_0
    //   1491: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   1494: astore 33
    //   1496: iload_3
    //   1497: iconst_1
    //   1498: if_icmple +102 -> 1600
    //   1501: iconst_1
    //   1502: istore 7
    //   1504: aload 33
    //   1506: aload 31
    //   1508: aload 32
    //   1510: iload 7
    //   1512: iconst_0
    //   1513: invokevirtual 512	com/whatsapp/notification/m:a	(Lcom/whatsapp/protocol/j;Lcom/whatsapp/data/cs;ZZ)Ljava/lang/CharSequence;
    //   1516: astore 32
    //   1518: aload 23
    //   1520: aload 32
    //   1522: invokevirtual 690	android/support/v4/app/an$h:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$h;
    //   1525: pop
    //   1526: aload 26
    //   1528: ldc_w 692
    //   1531: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: iload_1
    //   1535: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1538: ldc_w 694
    //   1541: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: aload 32
    //   1546: invokeinterface 699 1 0
    //   1551: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1554: bipush 47
    //   1556: invokevirtual 702	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1559: aload 31
    //   1561: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1564: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1567: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: bipush 47
    //   1572: invokevirtual 702	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1575: aload 31
    //   1577: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1580: getfield 457	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   1583: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: ldc_w 704
    //   1589: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: iload_1
    //   1594: iconst_1
    //   1595: iadd
    //   1596: istore_1
    //   1597: goto -144 -> 1453
    //   1600: iconst_0
    //   1601: istore 7
    //   1603: goto -99 -> 1504
    //   1606: aload 23
    //   1608: aload 17
    //   1610: invokevirtual 706	android/support/v4/app/an$h:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$h;
    //   1613: pop
    //   1614: aload 29
    //   1616: aload 23
    //   1618: invokevirtual 709	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$r;)Landroid/support/v4/app/an$d;
    //   1621: pop
    //   1622: aload 26
    //   1624: ldc_w 711
    //   1627: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: bipush 8
    //   1632: aload 22
    //   1634: invokevirtual 681	java/util/ArrayList:size	()I
    //   1637: invokestatic 647	java/lang/Math:min	(II)I
    //   1640: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1643: pop
    //   1644: invokestatic 571	com/whatsapp/notification/AndroidWear:a	()Z
    //   1647: ifeq +1362 -> 3009
    //   1650: aload_0
    //   1651: getfield 182	com/whatsapp/notification/ag:d	Z
    //   1654: ifeq +8 -> 1662
    //   1657: iload_3
    //   1658: iconst_1
    //   1659: if_icmpgt +1350 -> 3009
    //   1662: aload 30
    //   1664: new 8	com/whatsapp/notification/ag$1
    //   1667: dup
    //   1668: aload_0
    //   1669: invokespecial 712	com/whatsapp/notification/ag$1:<init>	(Lcom/whatsapp/notification/ag;)V
    //   1672: invokestatic 606	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1675: new 514	android/support/v4/app/an$d
    //   1678: dup
    //   1679: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1682: invokespecial 516	android/support/v4/app/an$d:<init>	(Landroid/content/Context;)V
    //   1685: astore 31
    //   1687: aload 31
    //   1689: ldc_w 527
    //   1692: invokevirtual 529	android/support/v4/app/an$d:c	(Ljava/lang/String;)Landroid/support/v4/app/an$d;
    //   1695: pop
    //   1696: aload 31
    //   1698: ldc_w 713
    //   1701: invokevirtual 716	android/support/v4/app/an$d:a	(I)Landroid/support/v4/app/an$d;
    //   1704: pop
    //   1705: aload 31
    //   1707: invokevirtual 719	android/support/v4/app/an$d:a	()Landroid/support/v4/app/an$d;
    //   1710: pop
    //   1711: iconst_0
    //   1712: istore_1
    //   1713: iload_1
    //   1714: iconst_0
    //   1715: aload 30
    //   1717: invokevirtual 681	java/util/ArrayList:size	()I
    //   1720: bipush 7
    //   1722: isub
    //   1723: invokestatic 687	java/lang/Math:max	(II)I
    //   1726: if_icmpge +3497 -> 5223
    //   1729: aload 24
    //   1731: aload 30
    //   1733: iload_1
    //   1734: invokevirtual 463	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1737: checkcast 591	java/util/List
    //   1740: iconst_0
    //   1741: invokeinterface 720 2 0
    //   1746: checkcast 187	com/whatsapp/protocol/j
    //   1749: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1752: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1755: iconst_1
    //   1756: invokevirtual 723	android/support/v4/app/aw:a	(Ljava/lang/String;I)V
    //   1759: iload_1
    //   1760: iconst_1
    //   1761: iadd
    //   1762: istore_1
    //   1763: goto -50 -> 1713
    //   1766: aload 32
    //   1768: iload 4
    //   1770: iload 5
    //   1772: invokevirtual 561	com/whatsapp/data/cs:c	(II)Landroid/graphics/Bitmap;
    //   1775: astore 23
    //   1777: aload 23
    //   1779: astore 22
    //   1781: aload 23
    //   1783: ifnonnull +17 -> 1800
    //   1786: aload 32
    //   1788: iload 4
    //   1790: iload 5
    //   1792: invokestatic 647	java/lang/Math:min	(II)I
    //   1795: invokevirtual 650	com/whatsapp/data/cs:a	(I)Landroid/graphics/Bitmap;
    //   1798: astore 22
    //   1800: aload 35
    //   1802: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1805: ldc_w 724
    //   1808: invokestatic 729	android/support/v4/content/b:c	(Landroid/content/Context;I)I
    //   1811: invokevirtual 735	android/app/Notification$Builder:setColor	(I)Landroid/app/Notification$Builder;
    //   1814: pop
    //   1815: aload 35
    //   1817: aload 22
    //   1819: invokevirtual 739	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   1822: pop
    //   1823: aload 35
    //   1825: aload 36
    //   1827: invokevirtual 743	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   1830: pop
    //   1831: aload 35
    //   1833: invokevirtual 747	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   1836: astore 22
    //   1838: aload 24
    //   1840: aload 32
    //   1842: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   1845: iconst_1
    //   1846: aload 22
    //   1848: invokevirtual 750	android/support/v4/app/aw:a	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   1851: iload_1
    //   1852: iconst_1
    //   1853: iadd
    //   1854: istore_1
    //   1855: iload_1
    //   1856: aload 30
    //   1858: invokevirtual 681	java/util/ArrayList:size	()I
    //   1861: if_icmpge +1148 -> 3009
    //   1864: aload 30
    //   1866: iload_1
    //   1867: invokevirtual 463	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1870: checkcast 591	java/util/List
    //   1873: astore 33
    //   1875: aload 33
    //   1877: iconst_0
    //   1878: invokeinterface 720 2 0
    //   1883: checkcast 187	com/whatsapp/protocol/j
    //   1886: astore 34
    //   1888: aload_0
    //   1889: getfield 104	com/whatsapp/notification/ag:i	Lcom/whatsapp/data/e;
    //   1892: aload 34
    //   1894: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1897: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1900: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   1903: astore 32
    //   1905: aload 31
    //   1907: aload 16
    //   1909: invokevirtual 566	android/support/v4/app/an$d:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$d;
    //   1912: pop
    //   1913: aload 31
    //   1915: aload 34
    //   1917: getfield 752	com/whatsapp/protocol/j:n	J
    //   1920: invokevirtual 755	android/support/v4/app/an$d:a	(J)Landroid/support/v4/app/an$d;
    //   1923: pop
    //   1924: aload_0
    //   1925: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   1928: aload 34
    //   1930: aload 32
    //   1932: invokevirtual 758	com/whatsapp/notification/m:a	(Lcom/whatsapp/protocol/j;Lcom/whatsapp/data/cs;)Lcom/whatsapp/notification/m$a;
    //   1935: astore 22
    //   1937: aload 31
    //   1939: aload 22
    //   1941: getfield 761	com/whatsapp/notification/m$a:a	Ljava/lang/String;
    //   1944: invokevirtual 764	android/support/v4/app/an$d:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   1947: pop
    //   1948: aload 31
    //   1950: aload 22
    //   1952: getfield 767	com/whatsapp/notification/m$a:b	Ljava/lang/CharSequence;
    //   1955: invokevirtual 769	android/support/v4/app/an$d:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   1958: pop
    //   1959: iload 9
    //   1961: ifeq +61 -> 2022
    //   1964: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   1967: astore 22
    //   1969: aload_0
    //   1970: getfield 97	com/whatsapp/notification/ag:h	Lcom/whatsapp/data/ad;
    //   1973: astore 23
    //   1975: aload_0
    //   1976: getfield 125	com/whatsapp/notification/ag:l	Lcom/whatsapp/data/l;
    //   1979: astore 35
    //   1981: aload_0
    //   1982: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   1985: astore 36
    //   1987: iload_3
    //   1988: iconst_1
    //   1989: if_icmpne +131 -> 2120
    //   1992: iconst_1
    //   1993: istore 7
    //   1995: aload 31
    //   1997: aload 22
    //   1999: aload 23
    //   2001: aload 35
    //   2003: aload 36
    //   2005: aload 32
    //   2007: iconst_0
    //   2008: aconst_null
    //   2009: iload 7
    //   2011: aload 21
    //   2013: iload 8
    //   2015: invokestatic 772	com/whatsapp/notification/AndroidWear:a	(Landroid/content/Context;Lcom/whatsapp/data/ad;Lcom/whatsapp/data/l;Lcom/whatsapp/notification/m;Lcom/whatsapp/data/cs;ZLcom/whatsapp/protocol/j;ZLandroid/graphics/Bitmap;Z)Landroid/support/v4/app/an$s;
    //   2018: invokevirtual 775	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$g;)Landroid/support/v4/app/an$d;
    //   2021: pop
    //   2022: new 777	android/support/v4/app/an$f$a$a
    //   2025: dup
    //   2026: aload 32
    //   2028: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2031: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2034: invokespecial 778	android/support/v4/app/an$f$a$a:<init>	(Ljava/lang/String;)V
    //   2037: astore 23
    //   2039: new 427	java/util/ArrayList
    //   2042: dup
    //   2043: aload_0
    //   2044: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   2047: aload 32
    //   2049: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   2052: invokevirtual 589	com/whatsapp/notification/f:b	(Ljava/lang/String;)Ljava/util/List;
    //   2055: invokespecial 781	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   2058: astore 22
    //   2060: aload 22
    //   2062: invokestatic 785	java/util/Collections:reverse	(Ljava/util/List;)V
    //   2065: aload 22
    //   2067: invokevirtual 431	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2070: astore 35
    //   2072: aload 35
    //   2074: invokeinterface 436 1 0
    //   2079: ifeq +60 -> 2139
    //   2082: aload 35
    //   2084: invokeinterface 440 1 0
    //   2089: checkcast 187	com/whatsapp/protocol/j
    //   2092: astore 22
    //   2094: aload 22
    //   2096: getfield 540	com/whatsapp/protocol/j:s	B
    //   2099: ifne +27 -> 2126
    //   2102: aload 22
    //   2104: invokevirtual 786	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   2107: astore 22
    //   2109: aload 23
    //   2111: aload 22
    //   2113: invokevirtual 789	android/support/v4/app/an$f$a$a:a	(Ljava/lang/String;)Landroid/support/v4/app/an$f$a$a;
    //   2116: pop
    //   2117: goto -45 -> 2072
    //   2120: iconst_0
    //   2121: istore 7
    //   2123: goto -128 -> 1995
    //   2126: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2129: aload 22
    //   2131: invokestatic 792	com/whatsapp/notification/m:a	(Landroid/content/Context;Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   2134: astore 22
    //   2136: goto -27 -> 2109
    //   2139: aload 23
    //   2141: aload 34
    //   2143: getfield 752	com/whatsapp/protocol/j:n	J
    //   2146: invokevirtual 795	android/support/v4/app/an$f$a$a:a	(J)Landroid/support/v4/app/an$f$a$a;
    //   2149: pop
    //   2150: iload 9
    //   2152: ifeq +39 -> 2191
    //   2155: aload 23
    //   2157: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2160: aload 32
    //   2162: invokestatic 798	com/whatsapp/notification/AndroidWear:a	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/app/PendingIntent;
    //   2165: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2168: aload 32
    //   2170: invokestatic 801	com/whatsapp/notification/AndroidWear:b	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/support/v4/app/ay;
    //   2173: invokevirtual 804	android/support/v4/app/an$f$a$a:a	(Landroid/app/PendingIntent;Landroid/support/v4/app/ay;)Landroid/support/v4/app/an$f$a$a;
    //   2176: pop
    //   2177: aload 23
    //   2179: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2182: aload 32
    //   2184: invokestatic 806	com/whatsapp/notification/AndroidWear:c	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/app/PendingIntent;
    //   2187: invokevirtual 809	android/support/v4/app/an$f$a$a:a	(Landroid/app/PendingIntent;)Landroid/support/v4/app/an$f$a$a;
    //   2190: pop
    //   2191: new 811	android/support/v4/app/an$f
    //   2194: dup
    //   2195: invokespecial 812	android/support/v4/app/an$f:<init>	()V
    //   2198: astore 22
    //   2200: aload 22
    //   2202: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2205: ldc_w 813
    //   2208: invokestatic 729	android/support/v4/content/b:c	(Landroid/content/Context;I)I
    //   2211: invokevirtual 816	android/support/v4/app/an$f:a	(I)Landroid/support/v4/app/an$f;
    //   2214: pop
    //   2215: aload 22
    //   2217: aload 23
    //   2219: invokevirtual 819	android/support/v4/app/an$f$a$a:a	()Landroid/support/v4/app/an$f$a;
    //   2222: invokevirtual 822	android/support/v4/app/an$f:a	(Landroid/support/v4/app/an$f$a;)Landroid/support/v4/app/an$f;
    //   2225: pop
    //   2226: aload 22
    //   2228: aload 32
    //   2230: iload 4
    //   2232: iload 5
    //   2234: invokevirtual 824	com/whatsapp/data/cs:b	(II)Landroid/graphics/Bitmap;
    //   2237: invokevirtual 827	android/support/v4/app/an$f:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$f;
    //   2240: pop
    //   2241: aload 31
    //   2243: aload 22
    //   2245: invokevirtual 775	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$g;)Landroid/support/v4/app/an$d;
    //   2248: pop
    //   2249: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2252: aload 32
    //   2254: invokestatic 832	com/whatsapp/Conversation:a	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/content/Intent;
    //   2257: astore 22
    //   2259: aload 31
    //   2261: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2264: iconst_0
    //   2265: aload 22
    //   2267: iconst_0
    //   2268: invokestatic 675	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   2271: invokevirtual 835	android/support/v4/app/an$d:a	(Landroid/app/PendingIntent;)Landroid/support/v4/app/an$d;
    //   2274: pop
    //   2275: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   2278: bipush 24
    //   2280: if_icmplt +251 -> 2531
    //   2283: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2286: aload 31
    //   2288: invokevirtual 837	android/support/v4/app/an$d:e	()Landroid/app/Notification;
    //   2291: invokestatic 841	android/app/Notification$Builder:recoverBuilder	(Landroid/content/Context;Landroid/app/Notification;)Landroid/app/Notification$Builder;
    //   2294: astore 35
    //   2296: new 843	android/app/Notification$MessagingStyle
    //   2299: dup
    //   2300: aload 32
    //   2302: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2305: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2308: invokespecial 846	android/app/Notification$MessagingStyle:<init>	(Ljava/lang/CharSequence;)V
    //   2311: astore 36
    //   2313: aload 32
    //   2315: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2318: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2321: astore 23
    //   2323: aload_0
    //   2324: getfield 97	com/whatsapp/notification/ag:h	Lcom/whatsapp/data/ad;
    //   2327: aload 34
    //   2329: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2332: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   2335: invokevirtual 442	com/whatsapp/data/ad:o	(Ljava/lang/String;)I
    //   2338: istore 6
    //   2340: aload 23
    //   2342: astore 22
    //   2344: iload 6
    //   2346: iconst_1
    //   2347: if_icmple +61 -> 2408
    //   2350: new 331	java/lang/StringBuilder
    //   2353: dup
    //   2354: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   2357: aload 23
    //   2359: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: ldc_w 848
    //   2365: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2368: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   2371: ldc_w 632
    //   2374: iload 6
    //   2376: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   2379: iconst_1
    //   2380: anewarray 4	java/lang/Object
    //   2383: dup
    //   2384: iconst_0
    //   2385: iload 6
    //   2387: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2390: aastore
    //   2391: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2394: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: ldc_w 704
    //   2400: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2403: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2406: astore 22
    //   2408: aload 36
    //   2410: aload 22
    //   2412: invokevirtual 852	android/app/Notification$MessagingStyle:setConversationTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$MessagingStyle;
    //   2415: pop
    //   2416: aload 33
    //   2418: invokeinterface 853 1 0
    //   2423: astore 23
    //   2425: aload 23
    //   2427: invokeinterface 436 1 0
    //   2432: ifeq -666 -> 1766
    //   2435: aload 23
    //   2437: invokeinterface 440 1 0
    //   2442: checkcast 187	com/whatsapp/protocol/j
    //   2445: astore 33
    //   2447: aload_0
    //   2448: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   2451: aload 33
    //   2453: aload 32
    //   2455: invokevirtual 758	com/whatsapp/notification/m:a	(Lcom/whatsapp/protocol/j;Lcom/whatsapp/data/cs;)Lcom/whatsapp/notification/m$a;
    //   2458: astore 34
    //   2460: aload 33
    //   2462: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2465: getfield 460	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   2468: invokestatic 857	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   2471: ifeq +52 -> 2523
    //   2474: aload 33
    //   2476: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   2479: ifnull +44 -> 2523
    //   2482: aload_0
    //   2483: getfield 104	com/whatsapp/notification/ag:i	Lcom/whatsapp/data/e;
    //   2486: aload 33
    //   2488: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   2491: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   2494: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2497: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2500: astore 22
    //   2502: aload 36
    //   2504: aload 34
    //   2506: getfield 767	com/whatsapp/notification/m$a:b	Ljava/lang/CharSequence;
    //   2509: aload 33
    //   2511: getfield 752	com/whatsapp/protocol/j:n	J
    //   2514: aload 22
    //   2516: invokevirtual 863	android/app/Notification$MessagingStyle:addMessage	(Ljava/lang/CharSequence;JLjava/lang/CharSequence;)Landroid/app/Notification$MessagingStyle;
    //   2519: pop
    //   2520: goto -95 -> 2425
    //   2523: ldc_w 865
    //   2526: astore 22
    //   2528: goto -26 -> 2502
    //   2531: aload 31
    //   2533: invokevirtual 837	android/support/v4/app/an$d:e	()Landroid/app/Notification;
    //   2536: astore 22
    //   2538: goto -700 -> 1838
    //   2541: new 777	android/support/v4/app/an$f$a$a
    //   2544: dup
    //   2545: aload 19
    //   2547: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2550: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2553: invokespecial 778	android/support/v4/app/an$f$a$a:<init>	(Ljava/lang/String;)V
    //   2556: astore 16
    //   2558: aload 16
    //   2560: aload 17
    //   2562: invokeinterface 866 1 0
    //   2567: invokevirtual 789	android/support/v4/app/an$f$a$a:a	(Ljava/lang/String;)Landroid/support/v4/app/an$f$a$a;
    //   2570: pop
    //   2571: aload 16
    //   2573: aload 20
    //   2575: getfield 752	com/whatsapp/protocol/j:n	J
    //   2578: invokevirtual 795	android/support/v4/app/an$f$a$a:a	(J)Landroid/support/v4/app/an$f$a$a;
    //   2581: pop
    //   2582: iload 9
    //   2584: ifeq +79 -> 2663
    //   2587: aload 16
    //   2589: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2592: aload 19
    //   2594: invokestatic 798	com/whatsapp/notification/AndroidWear:a	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/app/PendingIntent;
    //   2597: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2600: aload 19
    //   2602: invokestatic 801	com/whatsapp/notification/AndroidWear:b	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/support/v4/app/ay;
    //   2605: invokevirtual 804	android/support/v4/app/an$f$a$a:a	(Landroid/app/PendingIntent;Landroid/support/v4/app/ay;)Landroid/support/v4/app/an$f$a$a;
    //   2608: pop
    //   2609: aload 16
    //   2611: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2614: aload 19
    //   2616: invokestatic 806	com/whatsapp/notification/AndroidWear:c	(Landroid/content/Context;Lcom/whatsapp/data/cs;)Landroid/app/PendingIntent;
    //   2619: invokevirtual 809	android/support/v4/app/an$f$a$a:a	(Landroid/app/PendingIntent;)Landroid/support/v4/app/an$f$a$a;
    //   2622: pop
    //   2623: invokestatic 571	com/whatsapp/notification/AndroidWear:a	()Z
    //   2626: ifeq +37 -> 2663
    //   2629: aload 29
    //   2631: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2634: aload_0
    //   2635: getfield 97	com/whatsapp/notification/ag:h	Lcom/whatsapp/data/ad;
    //   2638: aload_0
    //   2639: getfield 125	com/whatsapp/notification/ag:l	Lcom/whatsapp/data/l;
    //   2642: aload_0
    //   2643: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   2646: aload 19
    //   2648: iconst_1
    //   2649: aload 20
    //   2651: iconst_1
    //   2652: aload 21
    //   2654: iload 8
    //   2656: invokestatic 772	com/whatsapp/notification/AndroidWear:a	(Landroid/content/Context;Lcom/whatsapp/data/ad;Lcom/whatsapp/data/l;Lcom/whatsapp/notification/m;Lcom/whatsapp/data/cs;ZLcom/whatsapp/protocol/j;ZLandroid/graphics/Bitmap;Z)Landroid/support/v4/app/an$s;
    //   2659: invokevirtual 775	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$g;)Landroid/support/v4/app/an$d;
    //   2662: pop
    //   2663: new 811	android/support/v4/app/an$f
    //   2666: dup
    //   2667: invokespecial 812	android/support/v4/app/an$f:<init>	()V
    //   2670: astore 21
    //   2672: aload 21
    //   2674: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2677: ldc_w 813
    //   2680: invokestatic 729	android/support/v4/content/b:c	(Landroid/content/Context;I)I
    //   2683: invokevirtual 816	android/support/v4/app/an$f:a	(I)Landroid/support/v4/app/an$f;
    //   2686: pop
    //   2687: aload 21
    //   2689: aload 16
    //   2691: invokevirtual 819	android/support/v4/app/an$f$a$a:a	()Landroid/support/v4/app/an$f$a;
    //   2694: invokevirtual 822	android/support/v4/app/an$f:a	(Landroid/support/v4/app/an$f$a;)Landroid/support/v4/app/an$f;
    //   2697: pop
    //   2698: aload 21
    //   2700: aload 19
    //   2702: iload 4
    //   2704: iload 5
    //   2706: invokevirtual 824	com/whatsapp/data/cs:b	(II)Landroid/graphics/Bitmap;
    //   2709: invokevirtual 827	android/support/v4/app/an$f:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$f;
    //   2712: pop
    //   2713: aload 29
    //   2715: aload 21
    //   2717: invokevirtual 775	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$g;)Landroid/support/v4/app/an$d;
    //   2720: pop
    //   2721: iconst_0
    //   2722: istore_1
    //   2723: aload 22
    //   2725: ifnull +47 -> 2772
    //   2728: new 868	android/support/v4/app/an$b
    //   2731: dup
    //   2732: invokespecial 869	android/support/v4/app/an$b:<init>	()V
    //   2735: astore 16
    //   2737: aload 16
    //   2739: aload 17
    //   2741: invokevirtual 872	android/support/v4/app/an$b:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$b;
    //   2744: pop
    //   2745: aload 16
    //   2747: aload 22
    //   2749: invokevirtual 875	android/support/v4/app/an$b:a	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/an$b;
    //   2752: pop
    //   2753: aload 29
    //   2755: aload 16
    //   2757: invokevirtual 709	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$r;)Landroid/support/v4/app/an$d;
    //   2760: pop
    //   2761: iconst_1
    //   2762: istore_1
    //   2763: aload 26
    //   2765: ldc_w 877
    //   2768: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2771: pop
    //   2772: iload_1
    //   2773: ifne +77 -> 2850
    //   2776: new 879	android/support/v4/app/an$c
    //   2779: dup
    //   2780: invokespecial 880	android/support/v4/app/an$c:<init>	()V
    //   2783: astore 16
    //   2785: aload 16
    //   2787: aload 17
    //   2789: invokevirtual 883	android/support/v4/app/an$c:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$c;
    //   2792: pop
    //   2793: aload 16
    //   2795: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   2798: ldc_w 614
    //   2801: iload_2
    //   2802: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   2805: iconst_1
    //   2806: anewarray 4	java/lang/Object
    //   2809: dup
    //   2810: iconst_0
    //   2811: iload_2
    //   2812: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2815: aastore
    //   2816: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2819: invokevirtual 885	android/support/v4/app/an$c:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$c;
    //   2822: pop
    //   2823: aload 29
    //   2825: aload 16
    //   2827: invokevirtual 709	android/support/v4/app/an$d:a	(Landroid/support/v4/app/an$r;)Landroid/support/v4/app/an$d;
    //   2830: pop
    //   2831: aload 26
    //   2833: ldc_w 887
    //   2836: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: aload 17
    //   2841: invokeinterface 699 1 0
    //   2846: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2849: pop
    //   2850: aload 20
    //   2852: getfield 540	com/whatsapp/protocol/j:s	B
    //   2855: iconst_2
    //   2856: if_icmpeq +12 -> 2868
    //   2859: aload 20
    //   2861: getfield 540	com/whatsapp/protocol/j:s	B
    //   2864: iconst_1
    //   2865: if_icmpne +144 -> 3009
    //   2868: aload 20
    //   2870: invokevirtual 190	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   2873: ifnull +136 -> 3009
    //   2876: aload 20
    //   2878: invokevirtual 190	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   2881: astore 16
    //   2883: aload 16
    //   2885: getfield 195	com/whatsapp/MediaData:transferred	Z
    //   2888: ifeq +121 -> 3009
    //   2891: aload 16
    //   2893: getfield 199	com/whatsapp/MediaData:file	Ljava/io/File;
    //   2896: ifnull +113 -> 3009
    //   2899: aload 16
    //   2901: getfield 199	com/whatsapp/MediaData:file	Ljava/io/File;
    //   2904: invokevirtual 205	java/io/File:exists	()Z
    //   2907: ifeq +102 -> 3009
    //   2910: aload 19
    //   2912: invokestatic 890	com/whatsapp/Conversation:a	(Lcom/whatsapp/data/cs;)Landroid/content/Intent;
    //   2915: astore 16
    //   2917: aload 16
    //   2919: getstatic 892	com/whatsapp/Conversation:n	Ljava/lang/String;
    //   2922: invokevirtual 896	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   2925: pop
    //   2926: aload 16
    //   2928: ldc_w 898
    //   2931: new 900	com/whatsapp/FMessageKey
    //   2934: dup
    //   2935: aload 20
    //   2937: getfield 315	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2940: invokespecial 903	com/whatsapp/FMessageKey:<init>	(Lcom/whatsapp/protocol/j$b;)V
    //   2943: invokevirtual 906	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   2946: pop
    //   2947: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2950: iconst_0
    //   2951: aload 16
    //   2953: ldc_w 907
    //   2956: invokestatic 675	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   2959: astore 16
    //   2961: aload 20
    //   2963: getfield 540	com/whatsapp/protocol/j:s	B
    //   2966: iconst_1
    //   2967: if_icmpne +1550 -> 4517
    //   2970: ldc_w 908
    //   2973: istore_1
    //   2974: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   2977: astore 21
    //   2979: aload 20
    //   2981: getfield 540	com/whatsapp/protocol/j:s	B
    //   2984: iconst_1
    //   2985: if_icmpne +1539 -> 4524
    //   2988: ldc_w 909
    //   2991: istore 4
    //   2993: aload 29
    //   2995: iload_1
    //   2996: aload 21
    //   2998: iload 4
    //   3000: invokevirtual 631	android/content/Context:getString	(I)Ljava/lang/String;
    //   3003: aload 16
    //   3005: invokevirtual 680	android/support/v4/app/an$d:a	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/support/v4/app/an$d;
    //   3008: pop
    //   3009: invokestatic 915	java/lang/System:currentTimeMillis	()J
    //   3012: lstore 12
    //   3014: aload_0
    //   3015: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   3018: getfield 917	com/whatsapp/notification/f:a	J
    //   3021: lstore 14
    //   3023: aload 29
    //   3025: ldc_w 713
    //   3028: invokevirtual 716	android/support/v4/app/an$d:a	(I)Landroid/support/v4/app/an$d;
    //   3031: pop
    //   3032: aload_0
    //   3033: getfield 182	com/whatsapp/notification/ag:d	Z
    //   3036: ifne +58 -> 3094
    //   3039: aload_0
    //   3040: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   3043: astore 21
    //   3045: aload 19
    //   3047: invokevirtual 523	com/whatsapp/data/cs:d	()Z
    //   3050: ifne +1482 -> 4532
    //   3053: aload 21
    //   3055: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   3058: ldc_w 921
    //   3061: iconst_1
    //   3062: anewarray 4	java/lang/Object
    //   3065: dup
    //   3066: iconst_0
    //   3067: aload 19
    //   3069: aload 21
    //   3071: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   3074: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   3077: aastore
    //   3078: invokevirtual 924	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3081: astore 16
    //   3083: aload 29
    //   3085: aload 16
    //   3087: invokestatic 509	com/whatsapp/emoji/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3090: invokevirtual 926	android/support/v4/app/an$d:c	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   3093: pop
    //   3094: aload 29
    //   3096: lload 12
    //   3098: invokevirtual 755	android/support/v4/app/an$d:a	(J)Landroid/support/v4/app/an$d;
    //   3101: pop
    //   3102: aload_0
    //   3103: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   3106: astore 16
    //   3108: aload 19
    //   3110: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   3113: astore 21
    //   3115: aload 16
    //   3117: getfield 928	com/whatsapp/notification/m:h	Lcom/whatsapp/cc;
    //   3120: aload 21
    //   3122: invokevirtual 929	com/whatsapp/cc:b	(Ljava/lang/String;)Z
    //   3125: ifne +29 -> 3154
    //   3128: aload 16
    //   3130: getfield 931	com/whatsapp/notification/m:a	Ljava/util/HashMap;
    //   3133: aload 21
    //   3135: invokevirtual 261	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3138: checkcast 933	java/lang/Long
    //   3141: astore 22
    //   3143: aload 22
    //   3145: ifnonnull +1597 -> 4742
    //   3148: iconst_0
    //   3149: istore_1
    //   3150: iload_1
    //   3151: ifeq +1624 -> 4775
    //   3154: iconst_1
    //   3155: istore_1
    //   3156: aload 20
    //   3158: getfield 937	com/whatsapp/protocol/j:P	Ljava/util/List;
    //   3161: ifnull +1619 -> 4780
    //   3164: aload 20
    //   3166: getfield 937	com/whatsapp/protocol/j:P	Ljava/util/List;
    //   3169: new 331	java/lang/StringBuilder
    //   3172: dup
    //   3173: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   3176: aload_0
    //   3177: getfield 83	com/whatsapp/notification/ag:f	Lcom/whatsapp/va;
    //   3180: invokevirtual 939	com/whatsapp/va:b	()Ljava/lang/String;
    //   3183: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: ldc_w 941
    //   3189: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3192: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3195: invokeinterface 944 2 0
    //   3200: ifeq +1580 -> 4780
    //   3203: iconst_1
    //   3204: istore 4
    //   3206: aload 20
    //   3208: getfield 947	com/whatsapp/protocol/j:V	Lcom/whatsapp/protocol/j;
    //   3211: ifnull +1575 -> 4786
    //   3214: aload 20
    //   3216: getfield 947	com/whatsapp/protocol/j:V	Lcom/whatsapp/protocol/j;
    //   3219: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   3222: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3225: ifeq +1561 -> 4786
    //   3228: iconst_1
    //   3229: istore 5
    //   3231: iload_1
    //   3232: ifeq +1985 -> 5217
    //   3235: aload 19
    //   3237: invokevirtual 523	com/whatsapp/data/cs:d	()Z
    //   3240: ifeq +1977 -> 5217
    //   3243: iload 4
    //   3245: ifne +8 -> 3253
    //   3248: iload 5
    //   3250: ifeq +1967 -> 5217
    //   3253: aload_0
    //   3254: getfield 132	com/whatsapp/notification/ag:m	Lcom/whatsapp/cc;
    //   3257: aload 20
    //   3259: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   3262: invokevirtual 929	com/whatsapp/cc:b	(Ljava/lang/String;)Z
    //   3265: ifne +1952 -> 5217
    //   3268: iconst_0
    //   3269: istore 4
    //   3271: lload 12
    //   3273: lload 14
    //   3275: lsub
    //   3276: ldc2_w 948
    //   3279: lcmp
    //   3280: ifle +450 -> 3730
    //   3283: aload_0
    //   3284: getfield 178	com/whatsapp/notification/ag:b	Z
    //   3287: ifne +443 -> 3730
    //   3290: invokestatic 952	com/whatsapp/Voip:e	()Z
    //   3293: istore 10
    //   3295: invokestatic 954	com/whatsapp/Voip:f	()Z
    //   3298: istore 11
    //   3300: iload 10
    //   3302: ifeq +1490 -> 4792
    //   3305: iload 11
    //   3307: ifne +1485 -> 4792
    //   3310: iconst_1
    //   3311: istore 7
    //   3313: aload 25
    //   3315: ifnull +1483 -> 4798
    //   3318: aload 25
    //   3320: invokevirtual 959	android/telephony/TelephonyManager:getCallState	()I
    //   3323: ifeq +1475 -> 4798
    //   3326: iconst_1
    //   3327: istore 8
    //   3329: iload 10
    //   3331: ifne +8 -> 3339
    //   3334: iload 8
    //   3336: ifeq +1468 -> 4804
    //   3339: aload 26
    //   3341: ldc_w 961
    //   3344: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: iload 7
    //   3349: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3352: bipush 32
    //   3354: invokevirtual 702	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3357: iload 8
    //   3359: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3362: bipush 41
    //   3364: invokevirtual 702	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3367: pop
    //   3368: aload 29
    //   3370: iconst_1
    //   3371: newarray <illegal type>
    //   3373: dup
    //   3374: iconst_0
    //   3375: lconst_0
    //   3376: lastore
    //   3377: invokevirtual 964	android/support/v4/app/an$d:a	([J)Landroid/support/v4/app/an$d;
    //   3380: pop
    //   3381: iload 8
    //   3383: ifne +254 -> 3637
    //   3386: iload 11
    //   3388: ifne +249 -> 3637
    //   3391: invokestatic 969	b/a/a/c:a	()Lb/a/a/c;
    //   3394: ldc_w 971
    //   3397: invokevirtual 974	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   3400: checkcast 971	com/whatsapp/g/l
    //   3403: astore 16
    //   3405: invokestatic 977	com/whatsapp/Conversation:l	()Lcom/whatsapp/Conversation$l;
    //   3408: astore 20
    //   3410: aload 16
    //   3412: getfield 979	com/whatsapp/g/l:a	Z
    //   3415: ifne +1618 -> 5033
    //   3418: aload_0
    //   3419: getfield 167	com/whatsapp/notification/ag:r	Lcom/whatsapp/pd;
    //   3422: invokevirtual 980	com/whatsapp/pd:d	()Z
    //   3425: ifeq +1608 -> 5033
    //   3428: aload 20
    //   3430: aload 19
    //   3432: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   3435: invokevirtual 984	com/whatsapp/Conversation$l:a	(Ljava/lang/String;)Z
    //   3438: ifeq +1595 -> 5033
    //   3441: getstatic 986	com/whatsapp/Conversation:w	Z
    //   3444: ifeq +1767 -> 5211
    //   3447: aload 26
    //   3449: ldc_w 988
    //   3452: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3455: pop
    //   3456: ldc_w 990
    //   3459: astore 16
    //   3461: aload 16
    //   3463: astore 20
    //   3465: iload 7
    //   3467: ifeq +20 -> 3487
    //   3470: aload 16
    //   3472: astore 20
    //   3474: aload 16
    //   3476: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3479: ifne +8 -> 3487
    //   3482: ldc_w 992
    //   3485: astore 20
    //   3487: aload 20
    //   3489: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3492: ifne +145 -> 3637
    //   3495: aload 20
    //   3497: invokestatic 996	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3500: astore 16
    //   3502: aload 26
    //   3504: ldc_w 998
    //   3507: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3510: aload 16
    //   3512: invokevirtual 1001	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3515: pop
    //   3516: aload 16
    //   3518: ifnull +119 -> 3637
    //   3521: iload 4
    //   3523: ifne +114 -> 3637
    //   3526: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   3529: bipush 22
    //   3531: if_icmpge +34 -> 3565
    //   3534: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   3537: bipush 21
    //   3539: if_icmpne +1543 -> 5082
    //   3542: getstatic 1007	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   3545: aload 16
    //   3547: invokevirtual 1008	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   3550: ifne +15 -> 3565
    //   3553: aload_0
    //   3554: getfield 111	com/whatsapp/notification/ag:j	Lcom/whatsapp/and;
    //   3557: aload 16
    //   3559: invokestatic 1010	com/whatsapp/notification/ag:a	(Lcom/whatsapp/and;Landroid/net/Uri;)Z
    //   3562: ifeq +1520 -> 5082
    //   3565: invokestatic 969	b/a/a/c:a	()Lb/a/a/c;
    //   3568: ldc_w 1012
    //   3571: invokevirtual 974	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   3574: checkcast 1012	com/whatsapp/g/o
    //   3577: getfield 1013	com/whatsapp/g/o:a	Z
    //   3580: ifne +57 -> 3637
    //   3583: ldc_w 1014
    //   3586: aload 16
    //   3588: invokevirtual 1017	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3591: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3594: ifeq +1485 -> 5079
    //   3597: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   3600: bipush 24
    //   3602: if_icmplt +1477 -> 5079
    //   3605: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   3608: new 201	java/io/File
    //   3611: dup
    //   3612: aload 16
    //   3614: invokevirtual 1020	android/net/Uri:getPath	()Ljava/lang/String;
    //   3617: invokespecial 1021	java/io/File:<init>	(Ljava/lang/String;)V
    //   3620: invokestatic 1026	a/a/a/a/d:a	(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;
    //   3623: astore 20
    //   3625: aload 20
    //   3627: astore 16
    //   3629: aload 29
    //   3631: aload 16
    //   3633: invokevirtual 1029	android/support/v4/app/an$d:a	(Landroid/net/Uri;)Landroid/support/v4/app/an$d;
    //   3636: pop
    //   3637: invokestatic 969	b/a/a/c:a	()Lb/a/a/c;
    //   3640: ldc_w 971
    //   3643: invokevirtual 974	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   3646: checkcast 971	com/whatsapp/g/l
    //   3649: astore 16
    //   3651: aload 16
    //   3653: getfield 979	com/whatsapp/g/l:a	Z
    //   3656: ifne +18 -> 3674
    //   3659: getstatic 1032	com/whatsapp/notification/PopupNotification:n	Lcom/whatsapp/notification/PopupNotification;
    //   3662: ifnull +1453 -> 5115
    //   3665: getstatic 1032	com/whatsapp/notification/PopupNotification:n	Lcom/whatsapp/notification/PopupNotification;
    //   3668: instanceof 1034
    //   3671: ifeq +1444 -> 5115
    //   3674: aload 28
    //   3676: invokevirtual 383	com/whatsapp/cc$a:f	()Ljava/lang/String;
    //   3679: astore 16
    //   3681: aload 16
    //   3683: ifnull +1420 -> 5103
    //   3686: aload 16
    //   3688: bipush 16
    //   3690: invokestatic 1037	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   3693: istore_1
    //   3694: iload_1
    //   3695: ldc_w 1038
    //   3698: ior
    //   3699: istore_1
    //   3700: iload_1
    //   3701: ldc_w 1038
    //   3704: if_icmpeq +26 -> 3730
    //   3707: aload 29
    //   3709: iload_1
    //   3710: invokevirtual 1040	android/support/v4/app/an$d:b	(I)Landroid/support/v4/app/an$d;
    //   3713: pop
    //   3714: aload 26
    //   3716: ldc_w 1042
    //   3719: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3722: iload_1
    //   3723: invokestatic 1045	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   3726: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3729: pop
    //   3730: iload_3
    //   3731: iconst_1
    //   3732: if_icmpne +1400 -> 5132
    //   3735: aload 19
    //   3737: invokestatic 890	com/whatsapp/Conversation:a	(Lcom/whatsapp/data/cs;)Landroid/content/Intent;
    //   3740: astore 16
    //   3742: aload 29
    //   3744: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   3747: iconst_0
    //   3748: aload 16
    //   3750: ldc_w 907
    //   3753: invokestatic 675	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   3756: invokevirtual 835	android/support/v4/app/an$d:a	(Landroid/app/PendingIntent;)Landroid/support/v4/app/an$d;
    //   3759: pop
    //   3760: aload 29
    //   3762: aload 18
    //   3764: invokevirtual 764	android/support/v4/app/an$d:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   3767: pop
    //   3768: aload 29
    //   3770: aload 17
    //   3772: invokevirtual 769	android/support/v4/app/an$d:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   3775: pop
    //   3776: invokestatic 1048	com/whatsapp/av:d	()Z
    //   3779: ifeq +17 -> 3796
    //   3782: aload 26
    //   3784: ldc_w 1050
    //   3787: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3790: aload 17
    //   3792: invokevirtual 1053	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3795: pop
    //   3796: aload 26
    //   3798: ldc_w 1055
    //   3801: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3804: aload 27
    //   3806: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3809: ldc_w 1057
    //   3812: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3815: iload_2
    //   3816: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3819: ldc_w 1059
    //   3822: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3825: iload_3
    //   3826: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3829: pop
    //   3830: aload_0
    //   3831: getfield 146	com/whatsapp/notification/ag:o	Lcom/whatsapp/notification/f;
    //   3834: invokestatic 915	java/lang/System:currentTimeMillis	()J
    //   3837: putfield 917	com/whatsapp/notification/f:a	J
    //   3840: new 331	java/lang/StringBuilder
    //   3843: dup
    //   3844: ldc_w 1061
    //   3847: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3850: aload 26
    //   3852: invokevirtual 1001	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3855: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3858: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3861: aload_0
    //   3862: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   3865: ifnull +49 -> 3914
    //   3868: aload_0
    //   3869: getfield 178	com/whatsapp/notification/ag:b	Z
    //   3872: ifne +42 -> 3914
    //   3875: new 331	java/lang/StringBuilder
    //   3878: dup
    //   3879: ldc_w 1063
    //   3882: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3885: aload_0
    //   3886: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   3889: invokestatic 364	com/whatsapp/util/Log:a	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   3892: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3895: ldc_w 343
    //   3898: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3901: aload_0
    //   3902: getfield 178	com/whatsapp/notification/ag:b	Z
    //   3905: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3908: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3911: invokestatic 361	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3914: getstatic 1032	com/whatsapp/notification/PopupNotification:n	Lcom/whatsapp/notification/PopupNotification;
    //   3917: ifnull +1288 -> 5205
    //   3920: getstatic 1032	com/whatsapp/notification/PopupNotification:n	Lcom/whatsapp/notification/PopupNotification;
    //   3923: getfield 1065	com/whatsapp/notification/PopupNotification:B	Ljava/lang/String;
    //   3926: astore 16
    //   3928: aload 16
    //   3930: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3933: ifne +1226 -> 5159
    //   3936: aload 19
    //   3938: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   3941: aload 16
    //   3943: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3946: ifeq +1213 -> 5159
    //   3949: iconst_1
    //   3950: istore_1
    //   3951: aload 28
    //   3953: invokevirtual 373	com/whatsapp/cc$a:g	()Ljava/lang/String;
    //   3956: invokestatic 379	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3959: istore_3
    //   3960: aload_0
    //   3961: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   3964: ifnull +1200 -> 5164
    //   3967: aload 25
    //   3969: ifnull +1195 -> 5164
    //   3972: aload 25
    //   3974: invokevirtual 959	android/telephony/TelephonyManager:getCallState	()I
    //   3977: ifne +1187 -> 5164
    //   3980: invokestatic 952	com/whatsapp/Voip:e	()Z
    //   3983: ifne +1181 -> 5164
    //   3986: aload_0
    //   3987: getfield 180	com/whatsapp/notification/ag:c	Z
    //   3990: ifne +1174 -> 5164
    //   3993: aload 28
    //   3995: invokevirtual 1066	com/whatsapp/cc$a:b	()Z
    //   3998: ifeq +8 -> 4006
    //   4001: iload 4
    //   4003: ifne +1161 -> 5164
    //   4006: iload 9
    //   4008: ifeq +1156 -> 5164
    //   4011: iload_3
    //   4012: ifne +7 -> 4019
    //   4015: iload_1
    //   4016: ifeq +1148 -> 5164
    //   4019: iconst_1
    //   4020: istore_1
    //   4021: iload_1
    //   4022: ifne +36 -> 4058
    //   4025: aload_0
    //   4026: getfield 182	com/whatsapp/notification/ag:d	Z
    //   4029: ifne +29 -> 4058
    //   4032: iload 4
    //   4034: ifne +24 -> 4058
    //   4037: aload_0
    //   4038: getfield 178	com/whatsapp/notification/ag:b	Z
    //   4041: ifne +17 -> 4058
    //   4044: aload_0
    //   4045: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   4048: ifnull +10 -> 4058
    //   4051: aload 29
    //   4053: iconst_1
    //   4054: invokevirtual 1068	android/support/v4/app/an$d:d	(I)Landroid/support/v4/app/an$d;
    //   4057: pop
    //   4058: new 652	android/content/Intent
    //   4061: dup
    //   4062: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4065: ldc_w 1070
    //   4068: invokespecial 657	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   4071: astore 18
    //   4073: aload 18
    //   4075: ldc_w 480
    //   4078: aload 27
    //   4080: invokevirtual 663	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4083: pop
    //   4084: aload 29
    //   4086: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4089: iconst_1
    //   4090: aload 18
    //   4092: ldc_w 669
    //   4095: invokestatic 1073	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   4098: invokevirtual 1075	android/support/v4/app/an$d:b	(Landroid/app/PendingIntent;)Landroid/support/v4/app/an$d;
    //   4101: pop
    //   4102: aload 29
    //   4104: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4107: ldc_w 724
    //   4110: invokestatic 729	android/support/v4/content/b:c	(Landroid/content/Context;I)I
    //   4113: invokevirtual 1077	android/support/v4/app/an$d:e	(I)Landroid/support/v4/app/an$d;
    //   4116: pop
    //   4117: getstatic 537	android/os/Build$VERSION:SDK_INT	I
    //   4120: bipush 21
    //   4122: if_icmplt +109 -> 4231
    //   4125: new 514	android/support/v4/app/an$d
    //   4128: dup
    //   4129: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4132: invokespecial 516	android/support/v4/app/an$d:<init>	(Landroid/content/Context;)V
    //   4135: astore 18
    //   4137: aload 18
    //   4139: ldc_w 518
    //   4142: invokevirtual 521	android/support/v4/app/an$d:a	(Ljava/lang/String;)Landroid/support/v4/app/an$d;
    //   4145: pop
    //   4146: aload 18
    //   4148: ldc_w 713
    //   4151: invokevirtual 716	android/support/v4/app/an$d:a	(I)Landroid/support/v4/app/an$d;
    //   4154: pop
    //   4155: aload 18
    //   4157: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4160: ldc_w 628
    //   4163: invokevirtual 631	android/content/Context:getString	(I)Ljava/lang/String;
    //   4166: invokevirtual 764	android/support/v4/app/an$d:a	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   4169: pop
    //   4170: iload_2
    //   4171: iconst_1
    //   4172: if_icmpne +997 -> 5169
    //   4175: aload 18
    //   4177: getstatic 613	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   4180: ldc_w 614
    //   4183: iload_2
    //   4184: invokevirtual 619	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   4187: iconst_1
    //   4188: anewarray 4	java/lang/Object
    //   4191: dup
    //   4192: iconst_0
    //   4193: iload_2
    //   4194: invokestatic 623	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4197: aastore
    //   4198: invokestatic 627	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4201: invokevirtual 769	android/support/v4/app/an$d:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   4204: pop
    //   4205: aload 18
    //   4207: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4210: ldc_w 724
    //   4213: invokestatic 729	android/support/v4/content/b:c	(Landroid/content/Context;I)I
    //   4216: invokevirtual 1077	android/support/v4/app/an$d:e	(I)Landroid/support/v4/app/an$d;
    //   4219: pop
    //   4220: aload 29
    //   4222: aload 18
    //   4224: invokevirtual 837	android/support/v4/app/an$d:e	()Landroid/app/Notification;
    //   4227: invokevirtual 1080	android/support/v4/app/an$d:a	(Landroid/app/Notification;)Landroid/support/v4/app/an$d;
    //   4230: pop
    //   4231: aload 29
    //   4233: invokevirtual 837	android/support/v4/app/an$d:e	()Landroid/app/Notification;
    //   4236: astore 17
    //   4238: aload_0
    //   4239: getfield 182	com/whatsapp/notification/ag:d	Z
    //   4242: ifeq +14 -> 4256
    //   4245: iload_2
    //   4246: iconst_1
    //   4247: if_icmpne +9 -> 4256
    //   4250: aload 24
    //   4252: iconst_1
    //   4253: invokevirtual 492	android/support/v4/app/aw:a	(I)V
    //   4256: aload 24
    //   4258: iconst_1
    //   4259: aload 17
    //   4261: invokevirtual 1083	android/support/v4/app/aw:a	(ILandroid/app/Notification;)V
    //   4264: aload_0
    //   4265: getfield 182	com/whatsapp/notification/ag:d	Z
    //   4268: ifne -4176 -> 92
    //   4271: invokestatic 977	com/whatsapp/Conversation:l	()Lcom/whatsapp/Conversation$l;
    //   4274: astore 17
    //   4276: aload 17
    //   4278: getfield 1084	com/whatsapp/Conversation$l:b	Z
    //   4281: ifeq +918 -> 5199
    //   4284: aload 17
    //   4286: invokevirtual 1087	com/whatsapp/Conversation$l:a	()Lcom/whatsapp/Conversation;
    //   4289: astore 17
    //   4291: aload 19
    //   4293: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   4296: astore 18
    //   4298: invokestatic 969	b/a/a/c:a	()Lb/a/a/c;
    //   4301: ldc_w 971
    //   4304: invokevirtual 974	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   4307: checkcast 971	com/whatsapp/g/l
    //   4310: getfield 979	com/whatsapp/g/l:a	Z
    //   4313: ifeq +78 -> 4391
    //   4316: new 331	java/lang/StringBuilder
    //   4319: dup
    //   4320: ldc_w 1089
    //   4323: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4326: aload 18
    //   4328: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4331: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4334: invokestatic 355	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   4337: aload 17
    //   4339: iconst_1
    //   4340: putfield 1092	com/whatsapp/Conversation:E	Z
    //   4343: aload 18
    //   4345: ifnull +16 -> 4361
    //   4348: aload 18
    //   4350: aload 17
    //   4352: getfield 1093	com/whatsapp/Conversation:t	Ljava/lang/String;
    //   4355: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4358: ifne +33 -> 4391
    //   4361: aload 17
    //   4363: iconst_0
    //   4364: putfield 1096	com/whatsapp/Conversation:F	Z
    //   4367: new 331	java/lang/StringBuilder
    //   4370: dup
    //   4371: ldc_w 1098
    //   4374: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4377: aload 17
    //   4379: getfield 1096	com/whatsapp/Conversation:F	Z
    //   4382: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4385: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4388: invokestatic 355	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   4391: iload_1
    //   4392: ifeq +27 -> 4419
    //   4395: aload_0
    //   4396: getfield 76	com/whatsapp/notification/ag:e	Lcom/whatsapp/pv;
    //   4399: new 1100	com/whatsapp/notification/af
    //   4402: dup
    //   4403: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4406: aload_0
    //   4407: getfield 167	com/whatsapp/notification/ag:r	Lcom/whatsapp/pd;
    //   4410: iload_3
    //   4411: aload 16
    //   4413: invokespecial 1103	com/whatsapp/notification/af:<init>	(Landroid/content/Context;Lcom/whatsapp/pd;ILjava/lang/String;)V
    //   4416: invokevirtual 1106	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
    //   4419: aload_0
    //   4420: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   4423: ifnull +80 -> 4503
    //   4426: aload 19
    //   4428: invokevirtual 523	com/whatsapp/data/cs:d	()Z
    //   4431: ifeq +72 -> 4503
    //   4434: aload_0
    //   4435: getfield 139	com/whatsapp/notification/ag:n	Lcom/whatsapp/notification/m;
    //   4438: astore 16
    //   4440: aload 19
    //   4442: getfield 500	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   4445: astore 17
    //   4447: invokestatic 915	java/lang/System:currentTimeMillis	()J
    //   4450: lstore 12
    //   4452: ldc2_w 1107
    //   4455: ldc2_w 1109
    //   4458: aload 16
    //   4460: getfield 1113	com/whatsapp/notification/m:i	Lcom/whatsapp/rh;
    //   4463: aload 17
    //   4465: invokevirtual 1118	com/whatsapp/rh:a	(Ljava/lang/String;)Lcom/whatsapp/rg;
    //   4468: invokevirtual 1122	com/whatsapp/rg:c	()I
    //   4471: i2l
    //   4472: lmul
    //   4473: ladd
    //   4474: lconst_1
    //   4475: lsub
    //   4476: ldc2_w 1123
    //   4479: invokestatic 1127	java/lang/Math:min	(JJ)J
    //   4482: lstore 14
    //   4484: aload 16
    //   4486: getfield 931	com/whatsapp/notification/m:a	Ljava/util/HashMap;
    //   4489: aload 17
    //   4491: lload 12
    //   4493: lload 14
    //   4495: ladd
    //   4496: invokestatic 1130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4499: invokevirtual 285	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4502: pop
    //   4503: aload_0
    //   4504: getfield 176	com/whatsapp/notification/ag:a	Lcom/whatsapp/protocol/j;
    //   4507: ifnull -4415 -> 92
    //   4510: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   4513: invokestatic 413	com/whatsapp/appwidget/WidgetProvider:a	(Landroid/content/Context;)V
    //   4516: return
    //   4517: ldc_w 1131
    //   4520: istore_1
    //   4521: goto -1547 -> 2974
    //   4524: ldc_w 1132
    //   4527: istore 4
    //   4529: goto -1536 -> 2993
    //   4532: aload 20
    //   4534: getfield 1134	com/whatsapp/protocol/j:d	I
    //   4537: bipush 6
    //   4539: if_icmpne +43 -> 4582
    //   4542: aload 21
    //   4544: getfield 1136	com/whatsapp/notification/m:c	Lcom/whatsapp/pv;
    //   4547: aload 21
    //   4549: getfield 1138	com/whatsapp/notification/m:d	Lcom/whatsapp/va;
    //   4552: aload 21
    //   4554: getfield 1141	com/whatsapp/notification/m:e	Lcom/whatsapp/data/d;
    //   4557: aload 21
    //   4559: getfield 1143	com/whatsapp/notification/m:f	Lcom/whatsapp/data/e;
    //   4562: aload 21
    //   4564: getfield 1146	com/whatsapp/notification/m:g	Lcom/whatsapp/aus;
    //   4567: aload 21
    //   4569: getfield 1113	com/whatsapp/notification/m:i	Lcom/whatsapp/rh;
    //   4572: aload 20
    //   4574: invokestatic 1151	com/whatsapp/ip:a	(Lcom/whatsapp/pv;Lcom/whatsapp/va;Lcom/whatsapp/data/d;Lcom/whatsapp/data/e;Lcom/whatsapp/aus;Lcom/whatsapp/rh;Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   4577: astore 16
    //   4579: goto -1496 -> 3083
    //   4582: aload 20
    //   4584: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   4587: ifnull +83 -> 4670
    //   4590: new 331	java/lang/StringBuilder
    //   4593: dup
    //   4594: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   4597: aload 21
    //   4599: getfield 1143	com/whatsapp/notification/m:f	Lcom/whatsapp/data/e;
    //   4602: aload 20
    //   4604: getfield 859	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   4607: invokevirtual 454	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   4610: aload 21
    //   4612: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   4615: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   4618: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4621: ldc_w 1153
    //   4624: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4627: aload 19
    //   4629: aload 21
    //   4631: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   4634: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   4637: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4640: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4643: astore 16
    //   4645: aload 21
    //   4647: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   4650: ldc_w 921
    //   4653: iconst_1
    //   4654: anewarray 4	java/lang/Object
    //   4657: dup
    //   4658: iconst_0
    //   4659: aload 16
    //   4661: aastore
    //   4662: invokevirtual 924	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4665: astore 16
    //   4667: goto -1584 -> 3083
    //   4670: new 331	java/lang/StringBuilder
    //   4673: dup
    //   4674: ldc_w 1155
    //   4677: invokespecial 335	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4680: aload 20
    //   4682: invokestatic 364	com/whatsapp/util/Log:a	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   4685: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4688: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4691: invokestatic 1157	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4694: new 331	java/lang/StringBuilder
    //   4697: dup
    //   4698: invokespecial 422	java/lang/StringBuilder:<init>	()V
    //   4701: aload 21
    //   4703: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   4706: ldc_w 1158
    //   4709: invokevirtual 631	android/content/Context:getString	(I)Ljava/lang/String;
    //   4712: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4715: ldc_w 1153
    //   4718: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4721: aload 19
    //   4723: aload 21
    //   4725: getfield 920	com/whatsapp/notification/m:b	Landroid/content/Context;
    //   4728: invokevirtual 506	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   4731: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4734: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4737: astore 16
    //   4739: goto -94 -> 4645
    //   4742: aload 22
    //   4744: invokevirtual 1161	java/lang/Long:longValue	()J
    //   4747: invokestatic 915	java/lang/System:currentTimeMillis	()J
    //   4750: lcmp
    //   4751: ifgt +19 -> 4770
    //   4754: aload 16
    //   4756: getfield 931	com/whatsapp/notification/m:a	Ljava/util/HashMap;
    //   4759: aload 21
    //   4761: invokevirtual 1164	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4764: pop
    //   4765: iconst_0
    //   4766: istore_1
    //   4767: goto -1617 -> 3150
    //   4770: iconst_1
    //   4771: istore_1
    //   4772: goto -1622 -> 3150
    //   4775: iconst_0
    //   4776: istore_1
    //   4777: goto -1621 -> 3156
    //   4780: iconst_0
    //   4781: istore 4
    //   4783: goto -1577 -> 3206
    //   4786: iconst_0
    //   4787: istore 5
    //   4789: goto -1558 -> 3231
    //   4792: iconst_0
    //   4793: istore 7
    //   4795: goto -1482 -> 3313
    //   4798: iconst_0
    //   4799: istore 8
    //   4801: goto -1472 -> 3329
    //   4804: iload 4
    //   4806: ifne -1425 -> 3381
    //   4809: aload 28
    //   4811: invokevirtual 385	com/whatsapp/cc$a:e	()Ljava/lang/String;
    //   4814: astore 16
    //   4816: aload 26
    //   4818: ldc_w 1166
    //   4821: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4824: aload 16
    //   4826: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4829: pop
    //   4830: iconst_m1
    //   4831: istore_1
    //   4832: aload 16
    //   4834: invokevirtual 1167	java/lang/String:hashCode	()I
    //   4837: tableswitch	default:+27->4864, 49:+68->4905, 50:+84->4921, 51:+100->4937
    //   4864: iload_1
    //   4865: tableswitch	default:+27->4892, 0:+30->4895, 1:+88->4953, 2:+128->4993
    //   4892: goto -1511 -> 3381
    //   4895: aload 29
    //   4897: iconst_2
    //   4898: invokevirtual 1169	android/support/v4/app/an$d:c	(I)Landroid/support/v4/app/an$d;
    //   4901: pop
    //   4902: goto -1521 -> 3381
    //   4905: aload 16
    //   4907: ldc_w 1171
    //   4910: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4913: ifeq -49 -> 4864
    //   4916: iconst_0
    //   4917: istore_1
    //   4918: goto -54 -> 4864
    //   4921: aload 16
    //   4923: ldc_w 1173
    //   4926: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4929: ifeq -65 -> 4864
    //   4932: iconst_1
    //   4933: istore_1
    //   4934: goto -70 -> 4864
    //   4937: aload 16
    //   4939: ldc_w 1175
    //   4942: invokevirtual 487	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4945: ifeq -81 -> 4864
    //   4948: iconst_2
    //   4949: istore_1
    //   4950: goto -86 -> 4864
    //   4953: aload 29
    //   4955: iconst_5
    //   4956: newarray <illegal type>
    //   4958: dup
    //   4959: iconst_0
    //   4960: lconst_0
    //   4961: lastore
    //   4962: dup
    //   4963: iconst_1
    //   4964: ldc2_w 1176
    //   4967: lastore
    //   4968: dup
    //   4969: iconst_2
    //   4970: ldc2_w 948
    //   4973: lastore
    //   4974: dup
    //   4975: iconst_3
    //   4976: ldc2_w 1176
    //   4979: lastore
    //   4980: dup
    //   4981: iconst_4
    //   4982: ldc2_w 948
    //   4985: lastore
    //   4986: invokevirtual 964	android/support/v4/app/an$d:a	([J)Landroid/support/v4/app/an$d;
    //   4989: pop
    //   4990: goto -1609 -> 3381
    //   4993: aload 29
    //   4995: iconst_5
    //   4996: newarray <illegal type>
    //   4998: dup
    //   4999: iconst_0
    //   5000: lconst_0
    //   5001: lastore
    //   5002: dup
    //   5003: iconst_1
    //   5004: ldc2_w 1178
    //   5007: lastore
    //   5008: dup
    //   5009: iconst_2
    //   5010: ldc2_w 1180
    //   5013: lastore
    //   5014: dup
    //   5015: iconst_3
    //   5016: ldc2_w 1178
    //   5019: lastore
    //   5020: dup
    //   5021: iconst_4
    //   5022: ldc2_w 1180
    //   5025: lastore
    //   5026: invokevirtual 964	android/support/v4/app/an$d:a	([J)Landroid/support/v4/app/an$d;
    //   5029: pop
    //   5030: goto -1649 -> 3381
    //   5033: aload 26
    //   5035: ldc_w 1183
    //   5038: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5041: pop
    //   5042: aload 28
    //   5044: invokevirtual 381	com/whatsapp/cc$a:d	()Ljava/lang/String;
    //   5047: astore 20
    //   5049: aload 20
    //   5051: astore 16
    //   5053: aload 20
    //   5055: ifnonnull -1594 -> 3461
    //   5058: getstatic 1007	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   5061: invokevirtual 639	android/net/Uri:toString	()Ljava/lang/String;
    //   5064: astore 16
    //   5066: goto -1605 -> 3461
    //   5069: astore 20
    //   5071: ldc_w 1185
    //   5074: aload 20
    //   5076: invokestatic 1188	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5079: goto -1450 -> 3629
    //   5082: aload_0
    //   5083: getfield 118	com/whatsapp/notification/ag:k	Lcom/whatsapp/util/b;
    //   5086: aload 16
    //   5088: invokevirtual 1191	com/whatsapp/util/b:a	(Landroid/net/Uri;)V
    //   5091: goto -1454 -> 3637
    //   5094: astore 16
    //   5096: ldc_w 1192
    //   5099: istore_1
    //   5100: goto -1406 -> 3694
    //   5103: aload 26
    //   5105: ldc_w 1194
    //   5108: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5111: pop
    //   5112: goto -1382 -> 3730
    //   5115: aload 26
    //   5117: ldc_w 1196
    //   5120: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5123: aload 16
    //   5125: invokevirtual 1001	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5128: pop
    //   5129: goto -1399 -> 3730
    //   5132: new 652	android/content/Intent
    //   5135: dup
    //   5136: invokestatic 408	com/whatsapp/u:a	()Landroid/content/Context;
    //   5139: invokestatic 1200	com/whatsapp/Main:n	()Ljava/lang/Class;
    //   5142: invokespecial 657	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5145: astore 16
    //   5147: aload 16
    //   5149: getstatic 1203	com/whatsapp/HomeActivity:t	Ljava/lang/String;
    //   5152: invokevirtual 896	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   5155: pop
    //   5156: goto -1414 -> 3742
    //   5159: iconst_0
    //   5160: istore_1
    //   5161: goto -1210 -> 3951
    //   5164: iconst_0
    //   5165: istore_1
    //   5166: goto -1145 -> 4021
    //   5169: aload 18
    //   5171: aload 17
    //   5173: invokevirtual 769	android/support/v4/app/an$d:b	(Ljava/lang/CharSequence;)Landroid/support/v4/app/an$d;
    //   5176: pop
    //   5177: goto -972 -> 4205
    //   5180: astore 17
    //   5182: aload 17
    //   5184: invokevirtual 1204	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   5187: ldc_w 1206
    //   5190: invokevirtual 1208	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5193: ifne -929 -> 4264
    //   5196: aload 17
    //   5198: athrow
    //   5199: invokestatic 1210	com/whatsapp/Conversation:E	()V
    //   5202: goto -811 -> 4391
    //   5205: aconst_null
    //   5206: astore 16
    //   5208: goto -1280 -> 3928
    //   5211: aconst_null
    //   5212: astore 16
    //   5214: goto -1753 -> 3461
    //   5217: iload_1
    //   5218: istore 4
    //   5220: goto -1949 -> 3271
    //   5223: goto -3368 -> 1855
    //   5226: aconst_null
    //   5227: astore 22
    //   5229: goto -4319 -> 910
    //   5232: aload 17
    //   5234: astore 20
    //   5236: aload 16
    //   5238: astore 19
    //   5240: goto -4633 -> 607
    //   5243: aload 16
    //   5245: astore 19
    //   5247: aload 17
    //   5249: astore 16
    //   5251: aload 19
    //   5253: astore 17
    //   5255: goto -4787 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5258	0	this	ag
    //   131	5087	1	i1	int
    //   140	4108	2	i2	int
    //   357	4054	3	i3	int
    //   922	4297	4	i4	int
    //   936	3852	5	i5	int
    //   2338	48	6	i6	int
    //   1502	3292	7	bool1	boolean
    //   987	3813	8	bool2	boolean
    //   1018	2989	9	bool3	boolean
    //   3293	37	10	bool4	boolean
    //   3298	89	11	bool5	boolean
    //   3012	1480	12	l1	long
    //   3021	1473	14	l2	long
    //   22	5065	16	localObject1	Object
    //   5094	30	16	localNumberFormatException	NumberFormatException
    //   5145	105	16	localObject2	Object
    //   10	5162	17	localObject3	Object
    //   5180	68	17	localSecurityException1	SecurityException
    //   5253	1	17	localObject4	Object
    //   160	5010	18	localObject5	Object
    //   167	5085	19	localObject6	Object
    //   112	4942	20	localObject7	Object
    //   5069	6	20	localIllegalArgumentException	IllegalArgumentException
    //   5234	1	20	localSecurityException2	SecurityException
    //   121	4639	21	localObject8	Object
    //   908	4320	22	localObject9	Object
    //   345	2091	23	localObject10	Object
    //   312	3945	24	localaw	android.support.v4.app.aw
    //   304	3669	25	localTelephonyManager	android.telephony.TelephonyManager
    //   327	4789	26	localStringBuilder	StringBuilder
    //   615	3464	27	str	String
    //   765	4278	28	locala	com.whatsapp.cc.a
    //   815	4179	29	locald	android.support.v4.app.an.d
    //   1090	775	30	localObject11	Object
    //   1119	1413	31	localObject12	Object
    //   1488	966	32	localObject13	Object
    //   1494	1016	33	localObject14	Object
    //   1886	619	34	localObject15	Object
    //   1800	495	35	localObject16	Object
    //   1825	678	36	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   3605	3625	5069	java/lang/IllegalArgumentException
    //   3686	3694	5094	java/lang/NumberFormatException
    //   4256	4264	5180	java/lang/SecurityException
  }
  
  final class a
    implements Comparator<j>
  {
    a() {}
    
    public static int a(j paramj1, j paramj2)
    {
      if (paramj1.n == paramj2.n) {
        return 0;
      }
      if (paramj1.n < paramj2.n) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */