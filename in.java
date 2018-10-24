package com.whatsapp;

import a.a.a.a.a.a;
import a.a.a.a.a.a.e;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whatsapp.data.cm;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.util.at;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class in
  extends hy
{
  private final TextView O;
  private final ImageView[] P = new ImageView[3];
  private final TextView Q;
  private final c R = c.a();
  private final cm S = cm.a();
  private final e T = e.a();
  private final di.e U;
  
  in(Context paramContext, j paramj, di.e parame)
  {
    super(paramContext, paramj);
    this.U = parame;
    this.O = ((TextView)findViewById(2131755594));
    this.P[0] = ((ImageView)findViewById(2131755467));
    this.P[1] = ((ImageView)findViewById(2131755600));
    this.P[2] = ((ImageView)findViewById(2131755599));
    this.Q = ((TextView)findViewById(2131755601));
    paramContext = (LinearLayout)findViewById(2131755593);
    paramContext.setOnClickListener(new a((byte)0));
    paramContext.setOnLongClickListener(this.u);
    e();
    p();
  }
  
  private boolean a(a parama)
  {
    if ((parama.f != null) && (parama.f.length > 0))
    {
      Log.d("conversationrowcontactsarray/hasphoto/contact " + parama.a() + " has photo bytes");
      return true;
    }
    if (parama.h != null)
    {
      Iterator localIterator = parama.h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (a.e)localIterator.next();
        if (((a.e)localObject).e != null)
        {
          cs localcs = this.T.c(((a.e)localObject).e + "@s.whatsapp.net");
          if (localcs != null)
          {
            File localFile = localcs.c();
            if (localFile != null)
            {
              localObject = localFile;
              if (localFile.exists()) {}
            }
            else
            {
              localObject = localcs.b();
            }
            if ((localObject != null) && (((File)localObject).exists())) {}
            for (int i = 1; i != 0; i = 0)
            {
              Log.d("conversationrowcontactsarray/hasphoto/contact " + parama.a() + " has wa photo");
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: iconst_3
    //   4: if_icmpge +24 -> 28
    //   7: aload_0
    //   8: getfield 29	com/whatsapp/in:P	[Landroid/widget/ImageView;
    //   11: iload_1
    //   12: aaload
    //   13: ldc -75
    //   15: invokestatic 184	com/whatsapp/data/cs:b	(I)Landroid/graphics/Bitmap;
    //   18: invokevirtual 188	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   21: iload_1
    //   22: iconst_1
    //   23: iadd
    //   24: istore_1
    //   25: goto -23 -> 2
    //   28: new 190	java/util/ArrayList
    //   31: dup
    //   32: new 192	java/io/ObjectInputStream
    //   35: dup
    //   36: new 194	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_0
    //   41: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   44: invokevirtual 202	com/whatsapp/protocol/j:h	()[B
    //   47: invokespecial 205	java/io/ByteArrayInputStream:<init>	([B)V
    //   50: invokespecial 208	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: invokevirtual 211	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   56: checkcast 130	java/util/List
    //   59: invokespecial 214	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   62: astore 13
    //   64: aload 13
    //   66: ifnull +345 -> 411
    //   69: aconst_null
    //   70: astore 8
    //   72: aconst_null
    //   73: astore 9
    //   75: iconst_0
    //   76: istore_1
    //   77: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   80: lstore 4
    //   82: iconst_0
    //   83: istore_2
    //   84: iload_2
    //   85: aload 13
    //   87: invokevirtual 224	java/util/ArrayList:size	()I
    //   90: if_icmpge +191 -> 281
    //   93: iload_2
    //   94: bipush 100
    //   96: if_icmpge +185 -> 281
    //   99: iload_1
    //   100: iconst_3
    //   101: if_icmpge +180 -> 281
    //   104: aload_0
    //   105: invokevirtual 228	com/whatsapp/in:getContext	()Landroid/content/Context;
    //   108: aload_0
    //   109: getfield 50	com/whatsapp/in:T	Lcom/whatsapp/data/e;
    //   112: aload 13
    //   114: iload_2
    //   115: invokevirtual 232	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   118: checkcast 234	java/lang/String
    //   121: invokestatic 237	a/a/a/a/a/a:a	(Landroid/content/Context;Lcom/whatsapp/data/e;Ljava/lang/String;)La/a/a/a/a/a;
    //   124: astore 11
    //   126: aload 9
    //   128: astore 12
    //   130: aload 11
    //   132: ifnull +567 -> 699
    //   135: aload 9
    //   137: astore 10
    //   139: aload 9
    //   141: ifnonnull +10 -> 151
    //   144: aload 11
    //   146: invokevirtual 110	a/a/a/a/a/a:a	()Ljava/lang/String;
    //   149: astore 10
    //   151: aload 10
    //   153: astore 12
    //   155: aload_0
    //   156: aload 11
    //   158: invokespecial 239	com/whatsapp/in:a	(La/a/a/a/a/a;)Z
    //   161: ifeq +538 -> 699
    //   164: aload_0
    //   165: getfield 52	com/whatsapp/in:U	Lcom/whatsapp/di$e;
    //   168: aload 11
    //   170: aload_0
    //   171: getfield 29	com/whatsapp/in:P	[Landroid/widget/ImageView;
    //   174: iload_1
    //   175: aaload
    //   176: invokevirtual 244	com/whatsapp/di$e:a	(La/a/a/a/a/a;Landroid/widget/ImageView;)V
    //   179: aload 8
    //   181: ifnonnull +515 -> 696
    //   184: aload 11
    //   186: invokevirtual 110	a/a/a/a/a/a:a	()Ljava/lang/String;
    //   189: astore 8
    //   191: iload_1
    //   192: iconst_1
    //   193: iadd
    //   194: istore_1
    //   195: aload 10
    //   197: astore 9
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -119 -> 84
    //   206: astore 8
    //   208: ldc -10
    //   210: aload 8
    //   212: invokestatic 249	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: aconst_null
    //   216: astore 13
    //   218: goto -154 -> 64
    //   221: astore 10
    //   223: ldc -5
    //   225: aload 10
    //   227: invokestatic 249	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aconst_null
    //   231: astore 11
    //   233: goto -107 -> 126
    //   236: astore 10
    //   238: ldc -3
    //   240: aload 10
    //   242: invokestatic 249	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload_0
    //   246: getfield 36	com/whatsapp/in:R	Lcom/whatsapp/util/a/c;
    //   249: new 102	java/lang/StringBuilder
    //   252: dup
    //   253: ldc -1
    //   255: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload 10
    //   260: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: iconst_0
    //   270: aconst_null
    //   271: iconst_m1
    //   272: invokevirtual 261	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   275: aconst_null
    //   276: astore 11
    //   278: goto -152 -> 126
    //   281: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   284: lstore 6
    //   286: new 102	java/lang/StringBuilder
    //   289: dup
    //   290: ldc_w 263
    //   293: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: lload 6
    //   298: lload 4
    //   300: lsub
    //   301: invokevirtual 266	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: ldc_w 268
    //   307: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload_2
    //   311: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc_w 273
    //   317: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 13
    //   322: invokevirtual 224	java/util/ArrayList:size	()I
    //   325: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 275
    //   331: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 124	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   340: aload 13
    //   342: invokevirtual 224	java/util/ArrayList:size	()I
    //   345: iconst_1
    //   346: isub
    //   347: istore_1
    //   348: aload 8
    //   350: ifnonnull +339 -> 689
    //   353: getstatic 280	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   356: ldc_w 281
    //   359: iload_1
    //   360: invokevirtual 286	com/whatsapp/j/a/a:a	(II)Ljava/lang/String;
    //   363: iconst_2
    //   364: anewarray 288	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 9
    //   371: aastore
    //   372: dup
    //   373: iconst_1
    //   374: iload_1
    //   375: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: aastore
    //   379: invokestatic 298	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   382: aload_0
    //   383: invokevirtual 228	com/whatsapp/in:getContext	()Landroid/content/Context;
    //   386: aload_0
    //   387: getfield 61	com/whatsapp/in:O	Landroid/widget/TextView;
    //   390: invokevirtual 302	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   393: invokestatic 307	com/whatsapp/emoji/c:a	(Ljava/lang/String;Landroid/content/Context;Landroid/graphics/Paint;)Ljava/lang/CharSequence;
    //   396: astore 8
    //   398: aload_0
    //   399: getfield 61	com/whatsapp/in:O	Landroid/widget/TextView;
    //   402: aload_0
    //   403: aload 8
    //   405: invokevirtual 310	com/whatsapp/in:a	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   408: invokevirtual 314	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   411: aload 13
    //   413: ifnull +194 -> 607
    //   416: aload 13
    //   418: invokevirtual 224	java/util/ArrayList:size	()I
    //   421: iconst_2
    //   422: if_icmpne +185 -> 607
    //   425: aload_0
    //   426: getfield 29	com/whatsapp/in:P	[Landroid/widget/ImageView;
    //   429: iconst_2
    //   430: aaload
    //   431: iconst_4
    //   432: invokevirtual 318	android/widget/ImageView:setVisibility	(I)V
    //   435: iconst_0
    //   436: istore_1
    //   437: aload_0
    //   438: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   441: getfield 321	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   444: getfield 326	com/whatsapp/protocol/j$b:b	Z
    //   447: ifne +122 -> 569
    //   450: iconst_1
    //   451: istore_1
    //   452: aload_0
    //   453: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   456: getfield 321	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   459: getfield 328	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   462: invokestatic 333	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   465: ifeq +165 -> 630
    //   468: aload_0
    //   469: getfield 50	com/whatsapp/in:T	Lcom/whatsapp/data/e;
    //   472: aload_0
    //   473: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   476: getfield 335	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   479: invokevirtual 337	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   482: astore 8
    //   484: aload_0
    //   485: getfield 43	com/whatsapp/in:S	Lcom/whatsapp/data/cm;
    //   488: aload_0
    //   489: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   492: getfield 321	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   495: getfield 328	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   498: invokevirtual 340	com/whatsapp/data/cm:a	(Ljava/lang/String;)I
    //   501: iconst_1
    //   502: if_icmpeq +118 -> 620
    //   505: iconst_1
    //   506: istore_1
    //   507: aload_0
    //   508: getfield 344	com/whatsapp/in:J	Lcom/whatsapp/qz;
    //   511: aload_0
    //   512: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   515: getfield 321	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   518: getfield 328	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   521: invokevirtual 346	com/whatsapp/qz:a	(Ljava/lang/String;)Z
    //   524: ifne +101 -> 625
    //   527: iconst_1
    //   528: istore_2
    //   529: iload_2
    //   530: iload_1
    //   531: iconst_1
    //   532: iand
    //   533: iand
    //   534: istore_1
    //   535: aload 8
    //   537: getfield 349	com/whatsapp/data/cs:d	Lcom/whatsapp/data/cs$a;
    //   540: ifnonnull +112 -> 652
    //   543: iconst_1
    //   544: istore_2
    //   545: aload_0
    //   546: getfield 43	com/whatsapp/in:S	Lcom/whatsapp/data/cm;
    //   549: aload 8
    //   551: getfield 352	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   554: invokevirtual 340	com/whatsapp/data/cm:a	(Ljava/lang/String;)I
    //   557: iconst_1
    //   558: if_icmpeq +99 -> 657
    //   561: iconst_1
    //   562: istore_3
    //   563: iload_3
    //   564: iload_1
    //   565: iload_2
    //   566: iand
    //   567: iand
    //   568: istore_1
    //   569: aload_0
    //   570: ldc_w 353
    //   573: invokevirtual 57	com/whatsapp/in:findViewById	(I)Landroid/view/View;
    //   576: astore 8
    //   578: iload_1
    //   579: ifne +83 -> 662
    //   582: aload_0
    //   583: getfield 67	com/whatsapp/in:Q	Landroid/widget/TextView;
    //   586: iconst_0
    //   587: invokevirtual 354	android/widget/TextView:setVisibility	(I)V
    //   590: aload_0
    //   591: getfield 67	com/whatsapp/in:Q	Landroid/widget/TextView;
    //   594: new 6	com/whatsapp/in$a
    //   597: dup
    //   598: aload_0
    //   599: iconst_0
    //   600: invokespecial 73	com/whatsapp/in$a:<init>	(Lcom/whatsapp/in;B)V
    //   603: invokevirtual 355	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   606: return
    //   607: aload_0
    //   608: getfield 29	com/whatsapp/in:P	[Landroid/widget/ImageView;
    //   611: iconst_2
    //   612: aaload
    //   613: iconst_0
    //   614: invokevirtual 318	android/widget/ImageView:setVisibility	(I)V
    //   617: goto -182 -> 435
    //   620: iconst_0
    //   621: istore_1
    //   622: goto -115 -> 507
    //   625: iconst_0
    //   626: istore_2
    //   627: goto -98 -> 529
    //   630: aload_0
    //   631: getfield 50	com/whatsapp/in:T	Lcom/whatsapp/data/e;
    //   634: aload_0
    //   635: getfield 197	com/whatsapp/in:a	Lcom/whatsapp/protocol/j;
    //   638: getfield 321	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   641: getfield 328	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   644: invokevirtual 337	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   647: astore 8
    //   649: goto -114 -> 535
    //   652: iconst_0
    //   653: istore_2
    //   654: goto -109 -> 545
    //   657: iconst_0
    //   658: istore_3
    //   659: goto -96 -> 563
    //   662: aload_0
    //   663: getfield 67	com/whatsapp/in:Q	Landroid/widget/TextView;
    //   666: bipush 8
    //   668: invokevirtual 354	android/widget/TextView:setVisibility	(I)V
    //   671: aload 8
    //   673: bipush 8
    //   675: invokevirtual 358	android/view/View:setVisibility	(I)V
    //   678: return
    //   679: astore 10
    //   681: goto -458 -> 223
    //   684: astore 8
    //   686: goto -478 -> 208
    //   689: aload 8
    //   691: astore 9
    //   693: goto -340 -> 353
    //   696: goto -505 -> 191
    //   699: aload 12
    //   701: astore 9
    //   703: goto -504 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	in
    //   1	621	1	i	int
    //   83	571	2	j	int
    //   562	97	3	k	int
    //   80	219	4	l1	long
    //   284	13	6	l2	long
    //   70	120	8	str	String
    //   206	143	8	localClassNotFoundException	ClassNotFoundException
    //   396	276	8	localObject1	Object
    //   684	6	8	localIOException1	java.io.IOException
    //   73	629	9	localObject2	Object
    //   137	59	10	localObject3	Object
    //   221	5	10	locald	a.a.a.a.a.d
    //   236	23	10	localException	Exception
    //   679	1	10	localIOException2	java.io.IOException
    //   124	153	11	locala	a
    //   128	572	12	localObject4	Object
    //   62	355	13	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   28	64	206	java/lang/ClassNotFoundException
    //   104	126	221	a/a/a/a/a/d
    //   104	126	236	java/lang/Exception
    //   104	126	679	java/io/IOException
    //   28	64	684	java/io/IOException
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        p();
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903142;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903142;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903143;
  }
  
  public final void i()
  {
    super.i();
    p();
  }
  
  final class a
    extends at
  {
    private a() {}
    
    public final void a(View paramView)
    {
      paramView = new Intent(in.this.getContext(), ViewSharedContactArrayActivity.class);
      paramView.putExtra("edit_mode", false);
      try
      {
        paramView.putStringArrayListExtra("vcard_array", new ArrayList((List)new ObjectInputStream(new ByteArrayInputStream(in.this.a.h())).readObject()));
        in.this.getContext().startActivity(paramView);
        return;
      }
      catch (Exception paramView)
      {
        Log.d("conversationrowcontactsarray/viewcontactonclicklistener error opening vcard array", paramView);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */