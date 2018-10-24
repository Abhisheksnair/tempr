package com.whatsapp;

import a.a.a.a.d;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;

public final class al
{
  public static final boolean a;
  private static final String[] b;
  private static Boolean c;
  
  static
  {
    boolean bool = true;
    b = new String[] { "GINGERBREAD.HZLC1", "GINGERBREAD.JHKG2", "GINGERBREAD.JHKJ1", "GINGERBREAD.JHLB2", "GINGERBREAD.JIKG3", "GINGERBREAD.JIKJ1", "GINGERBREAD.JJKG1", "GINGERBREAD.JJKJ1", "IZADOR.V.4.FINAL", "FIREFDS.V1.GINGERBREAD.XILA2", "GINGERBREAD.JHLM1", "XWKTH.HEBREW", "GINGERBREAD.JHKE4", "FRG83", "NextRom", "4.5.1-134_DFP-231", "SKARBNIK ROM 1.3.0", "FROYO.JHJPC", "GINGERBREAD.JIJV8", "GINGERBREAD.JHJVB", "GINGERBREAD.JHJV9", "GINGERBREAD.JHJVG", "6.5.1_73-SPD-IRD-21", "GINGERBREAD.JJJVB", "GINGERBREAD.JIJVG", "GINGERBREAD.XXKI6", "JRDNEM_U3_2.59.0", "FROYO.JIJPC", "GINGERBREAD.JHKQ4", "GINGERBREAD.XXLM6", "6.5.1-167-SPD-IRD-40", "FROYO.JHJPD", "GINGERBREAD.XXKPK", "GINGERBREAD.JIKQ7", "FIREFDS.V1.GINGERBREAD.XWKL1", "OLYEM_U4_4.8.0", "GINGERBREAD.JJKQ5", "4.0.2.A.0.62", "HebMIUI V6", "GINGERBREAD.JILB3", "FIREFDS.V1.GINGERBREAD.XWKJ2", "GRJ90", "4.0.A.2.368", "GINGERBREAD.JPLA2", "GINGERBREAD.JPKP2", "GINGERBREAD.JPKPE", "GINGERBREAD.JPLC1", "GINGERBREAD.JPKJ2" };
    if (Build.VERSION.SDK_INT >= 17) {}
    for (;;)
    {
      a = bool;
      return;
      bool = false;
    }
  }
  
  public static char a(aus paramaus)
  {
    paramaus = paramaus.d();
    if (("ar".equals(paramaus)) || ("fa".equals(paramaus)) || ("ur".equals(paramaus))) {
      return '،';
    }
    return ',';
  }
  
  private static int a(int paramInt)
  {
    if ((0x800000 & paramInt) != 0) {}
    do
    {
      return paramInt;
      if ((paramInt & 0x7) == 5) {
        return paramInt & 0xFFFFFFF8 | 0x3;
      }
    } while ((paramInt & 0x7) != 3);
    return paramInt & 0xFFFFFFF8 | 0x5;
  }
  
  public static View a(pv parampv, LayoutInflater paramLayoutInflater, int paramInt)
  {
    return a(parampv, paramLayoutInflater, paramInt, null, false);
  }
  
  public static View a(pv parampv, LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return a(parampv, paramLayoutInflater, paramInt, paramViewGroup, paramBoolean, null);
  }
  
  public static View a(pv parampv, LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup, boolean paramBoolean, int[] paramArrayOfInt)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(paramInt, paramViewGroup, paramBoolean);
    a(parampv, paramLayoutInflater, paramArrayOfInt);
    return paramLayoutInflater;
  }
  
  public static String a(pv parampv, String paramString)
  {
    if ((parampv.d()) || (paramString == null)) {
      return paramString;
    }
    return "‏‪" + paramString + "‬";
  }
  
  @TargetApi(17)
  public static void a(Window paramWindow)
  {
    if (a) {
      paramWindow.getDecorView().setLayoutDirection(3);
    }
  }
  
  public static void a(pv parampv, View paramView)
  {
    a(parampv, paramView, null);
  }
  
  public static void a(pv parampv, View paramView, int paramInt1, int paramInt2)
  {
    a(parampv, paramView, paramInt1, paramView.getPaddingTop(), paramInt2, paramView.getPaddingBottom());
  }
  
  public static void a(pv parampv, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (parampv.a)
    {
      i = paramInt3;
      if (!parampv.a) {
        break label35;
      }
    }
    for (;;)
    {
      paramView.setPadding(i, paramInt2, paramInt1, paramInt4);
      return;
      i = paramInt1;
      break;
      label35:
      paramInt1 = paramInt3;
    }
  }
  
  /* Error */
  private static void a(pv parampv, View paramView, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 162	com/whatsapp/pv:d	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: ifnull +36 -> 45
    //   12: aload_1
    //   13: invokevirtual 222	android/view/View:getId	()I
    //   16: istore 4
    //   18: aload_2
    //   19: arraylength
    //   20: istore 5
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_3
    //   25: iload 5
    //   27: if_icmpge +18 -> 45
    //   30: aload_2
    //   31: iload_3
    //   32: iaload
    //   33: iload 4
    //   35: if_icmpeq -28 -> 7
    //   38: iload_3
    //   39: iconst_1
    //   40: iadd
    //   41: istore_3
    //   42: goto -18 -> 24
    //   45: aload_1
    //   46: aload_1
    //   47: invokevirtual 225	android/view/View:getPaddingRight	()I
    //   50: aload_1
    //   51: invokevirtual 202	android/view/View:getPaddingTop	()I
    //   54: aload_1
    //   55: invokevirtual 228	android/view/View:getPaddingLeft	()I
    //   58: aload_1
    //   59: invokevirtual 205	android/view/View:getPaddingBottom	()I
    //   62: invokevirtual 213	android/view/View:setPadding	(IIII)V
    //   65: aload_1
    //   66: invokevirtual 232	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   69: astore 6
    //   71: aload 6
    //   73: instanceof 234
    //   76: ifeq +111 -> 187
    //   79: aload 6
    //   81: checkcast 234	android/view/ViewGroup$MarginLayoutParams
    //   84: astore 7
    //   86: aload 7
    //   88: getfield 237	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   91: aload 7
    //   93: getfield 240	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   96: if_icmpeq +91 -> 187
    //   99: aload 7
    //   101: aload 7
    //   103: getfield 240	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   106: aload 7
    //   108: getfield 243	android/view/ViewGroup$MarginLayoutParams:topMargin	I
    //   111: aload 7
    //   113: getfield 237	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   116: aload 7
    //   118: getfield 246	android/view/ViewGroup$MarginLayoutParams:bottomMargin	I
    //   121: invokevirtual 249	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   124: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   127: bipush 17
    //   129: if_icmpge +58 -> 187
    //   132: ldc -22
    //   134: ldc -5
    //   136: invokevirtual 257	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   139: astore 8
    //   141: aload 8
    //   143: iconst_1
    //   144: invokevirtual 263	java/lang/reflect/Field:setAccessible	(Z)V
    //   147: aload 8
    //   149: aload 7
    //   151: aload 7
    //   153: getfield 237	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   156: invokevirtual 267	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   159: ldc -22
    //   161: ldc_w 269
    //   164: invokevirtual 257	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   167: astore 8
    //   169: aload 8
    //   171: iconst_1
    //   172: invokevirtual 263	java/lang/reflect/Field:setAccessible	(Z)V
    //   175: aload 8
    //   177: aload 7
    //   179: aload 7
    //   181: getfield 240	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   184: invokevirtual 267	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   187: aload 6
    //   189: instanceof 271
    //   192: ifeq +85 -> 277
    //   195: aload 6
    //   197: checkcast 271	android/widget/RelativeLayout$LayoutParams
    //   200: astore 7
    //   202: aload 7
    //   204: invokevirtual 275	android/widget/RelativeLayout$LayoutParams:getRules	()[I
    //   207: astore 8
    //   209: aload 8
    //   211: iconst_0
    //   212: iaload
    //   213: istore_3
    //   214: aload 8
    //   216: iconst_1
    //   217: iaload
    //   218: istore 4
    //   220: aload 8
    //   222: iconst_1
    //   223: iload_3
    //   224: iastore
    //   225: aload 8
    //   227: iconst_0
    //   228: iload 4
    //   230: iastore
    //   231: aload 8
    //   233: iconst_5
    //   234: iaload
    //   235: istore_3
    //   236: aload 7
    //   238: iconst_5
    //   239: aload 8
    //   241: bipush 7
    //   243: iaload
    //   244: invokevirtual 279	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   247: aload 7
    //   249: bipush 7
    //   251: iload_3
    //   252: invokevirtual 279	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   255: aload 8
    //   257: bipush 9
    //   259: iaload
    //   260: istore_3
    //   261: aload 8
    //   263: bipush 9
    //   265: aload 8
    //   267: bipush 11
    //   269: iaload
    //   270: iastore
    //   271: aload 8
    //   273: bipush 11
    //   275: iload_3
    //   276: iastore
    //   277: aload 6
    //   279: instanceof 281
    //   282: ifeq +23 -> 305
    //   285: aload 6
    //   287: checkcast 281	android/widget/FrameLayout$LayoutParams
    //   290: astore 7
    //   292: aload 7
    //   294: aload 7
    //   296: getfield 284	android/widget/FrameLayout$LayoutParams:gravity	I
    //   299: invokestatic 286	com/whatsapp/al:a	(I)I
    //   302: putfield 284	android/widget/FrameLayout$LayoutParams:gravity	I
    //   305: aload 6
    //   307: instanceof 288
    //   310: ifeq +23 -> 333
    //   313: aload 6
    //   315: checkcast 288	android/widget/LinearLayout$LayoutParams
    //   318: astore 6
    //   320: aload 6
    //   322: aload 6
    //   324: getfield 289	android/widget/LinearLayout$LayoutParams:gravity	I
    //   327: invokestatic 286	com/whatsapp/al:a	(I)I
    //   330: putfield 289	android/widget/LinearLayout$LayoutParams:gravity	I
    //   333: aload_1
    //   334: instanceof 291
    //   337: ifeq +72 -> 409
    //   340: aload_1
    //   341: instanceof 293
    //   344: ifne +65 -> 409
    //   347: aload_1
    //   348: checkcast 291	android/widget/TextView
    //   351: astore 6
    //   353: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   356: bipush 11
    //   358: if_icmpge +10 -> 368
    //   361: aload_0
    //   362: invokestatic 296	com/whatsapp/al:a	(Lcom/whatsapp/pv;)Z
    //   365: ifne +16 -> 381
    //   368: aload 6
    //   370: aload 6
    //   372: invokevirtual 299	android/widget/TextView:getGravity	()I
    //   375: invokestatic 286	com/whatsapp/al:a	(I)I
    //   378: invokevirtual 302	android/widget/TextView:setGravity	(I)V
    //   381: aload 6
    //   383: invokevirtual 306	android/widget/TextView:getCompoundDrawables	()[Landroid/graphics/drawable/Drawable;
    //   386: astore 7
    //   388: aload 6
    //   390: aload 7
    //   392: iconst_2
    //   393: aaload
    //   394: aload 7
    //   396: iconst_1
    //   397: aaload
    //   398: aload 7
    //   400: iconst_0
    //   401: aaload
    //   402: aload 7
    //   404: iconst_3
    //   405: aaload
    //   406: invokevirtual 310	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   409: aload_1
    //   410: instanceof 312
    //   413: ifeq +30 -> 443
    //   416: aload_1
    //   417: checkcast 312	android/widget/RelativeLayout
    //   420: astore 6
    //   422: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   425: bipush 16
    //   427: if_icmplt +126 -> 553
    //   430: aload 6
    //   432: aload 6
    //   434: invokevirtual 313	android/widget/RelativeLayout:getGravity	()I
    //   437: invokestatic 286	com/whatsapp/al:a	(I)I
    //   440: invokevirtual 314	android/widget/RelativeLayout:setGravity	(I)V
    //   443: aload_1
    //   444: instanceof 316
    //   447: ifeq +187 -> 634
    //   450: aload_1
    //   451: checkcast 316	android/widget/LinearLayout
    //   454: astore 6
    //   456: ldc_w 316
    //   459: ldc_w 318
    //   462: invokevirtual 257	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   465: astore 7
    //   467: aload 7
    //   469: iconst_1
    //   470: invokevirtual 263	java/lang/reflect/Field:setAccessible	(Z)V
    //   473: aload 6
    //   475: aload 7
    //   477: aload 6
    //   479: invokevirtual 322	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   482: checkcast 324	java/lang/Integer
    //   485: invokevirtual 327	java/lang/Integer:intValue	()I
    //   488: invokestatic 286	com/whatsapp/al:a	(I)I
    //   491: invokevirtual 328	android/widget/LinearLayout:setGravity	(I)V
    //   494: aload 6
    //   496: invokevirtual 331	android/widget/LinearLayout:getOrientation	()I
    //   499: ifne +135 -> 634
    //   502: getstatic 120	com/whatsapp/al:a	Z
    //   505: ifne +129 -> 634
    //   508: aload 6
    //   510: invokevirtual 334	android/widget/LinearLayout:getChildCount	()I
    //   513: istore 4
    //   515: new 336	java/util/ArrayList
    //   518: dup
    //   519: iload 4
    //   521: invokespecial 338	java/util/ArrayList:<init>	(I)V
    //   524: astore 7
    //   526: iconst_0
    //   527: istore_3
    //   528: iload_3
    //   529: iload 4
    //   531: if_icmpge +68 -> 599
    //   534: aload 7
    //   536: aload 6
    //   538: iload_3
    //   539: invokevirtual 342	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   542: invokevirtual 345	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   545: pop
    //   546: iload_3
    //   547: iconst_1
    //   548: iadd
    //   549: istore_3
    //   550: goto -22 -> 528
    //   553: ldc_w 312
    //   556: ldc_w 318
    //   559: invokevirtual 257	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   562: astore 7
    //   564: aload 7
    //   566: iconst_1
    //   567: invokevirtual 263	java/lang/reflect/Field:setAccessible	(Z)V
    //   570: aload 6
    //   572: aload 7
    //   574: aload 6
    //   576: invokevirtual 322	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   579: checkcast 324	java/lang/Integer
    //   582: invokevirtual 327	java/lang/Integer:intValue	()I
    //   585: invokestatic 286	com/whatsapp/al:a	(I)I
    //   588: invokevirtual 314	android/widget/RelativeLayout:setGravity	(I)V
    //   591: goto -148 -> 443
    //   594: astore 6
    //   596: goto -153 -> 443
    //   599: aload 6
    //   601: invokevirtual 348	android/widget/LinearLayout:removeAllViews	()V
    //   604: iload 4
    //   606: iconst_1
    //   607: isub
    //   608: istore_3
    //   609: iload_3
    //   610: iflt +24 -> 634
    //   613: aload 6
    //   615: aload 7
    //   617: iload_3
    //   618: invokevirtual 351	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   621: checkcast 191	android/view/View
    //   624: invokevirtual 355	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   627: iload_3
    //   628: iconst_1
    //   629: isub
    //   630: istore_3
    //   631: goto -22 -> 609
    //   634: aload_1
    //   635: instanceof 357
    //   638: ifeq +35 -> 673
    //   641: aload_1
    //   642: checkcast 357	android/widget/ListView
    //   645: astore 6
    //   647: aload 6
    //   649: invokevirtual 361	android/widget/ListView:getDivider	()Landroid/graphics/drawable/Drawable;
    //   652: astore 7
    //   654: aload 7
    //   656: ifnull +17 -> 673
    //   659: aload 6
    //   661: new 363	com/whatsapp/util/az
    //   664: dup
    //   665: aload 7
    //   667: invokespecial 366	com/whatsapp/util/az:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   670: invokevirtual 369	android/widget/ListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   673: aload_1
    //   674: instanceof 371
    //   677: ifeq -670 -> 7
    //   680: aload_1
    //   681: checkcast 371	android/view/ViewGroup
    //   684: astore_1
    //   685: aload_1
    //   686: invokevirtual 372	android/view/ViewGroup:getChildCount	()I
    //   689: istore 4
    //   691: iconst_0
    //   692: istore_3
    //   693: iload_3
    //   694: iload 4
    //   696: if_icmpge -689 -> 7
    //   699: aload_0
    //   700: aload_1
    //   701: iload_3
    //   702: invokevirtual 373	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   705: aload_2
    //   706: invokestatic 156	com/whatsapp/al:a	(Lcom/whatsapp/pv;Landroid/view/View;[I)V
    //   709: iload_3
    //   710: iconst_1
    //   711: iadd
    //   712: istore_3
    //   713: goto -20 -> 693
    //   716: astore 7
    //   718: goto -224 -> 494
    //   721: astore 7
    //   723: goto -229 -> 494
    //   726: astore 7
    //   728: goto -234 -> 494
    //   731: astore 6
    //   733: goto -290 -> 443
    //   736: astore 6
    //   738: goto -295 -> 443
    //   741: astore 7
    //   743: goto -556 -> 187
    //   746: astore 7
    //   748: goto -561 -> 187
    //   751: astore 7
    //   753: goto -566 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	parampv	pv
    //   0	756	1	paramView	View
    //   0	756	2	paramArrayOfInt	int[]
    //   23	690	3	i	int
    //   16	681	4	j	int
    //   20	8	5	k	int
    //   69	506	6	localObject1	Object
    //   594	20	6	localNoSuchFieldException1	NoSuchFieldException
    //   645	15	6	localListView	android.widget.ListView
    //   731	1	6	localIllegalAccessException1	IllegalAccessException
    //   736	1	6	localIllegalArgumentException1	IllegalArgumentException
    //   84	582	7	localObject2	Object
    //   716	1	7	localNoSuchFieldException2	NoSuchFieldException
    //   721	1	7	localIllegalAccessException2	IllegalAccessException
    //   726	1	7	localIllegalArgumentException2	IllegalArgumentException
    //   741	1	7	localNoSuchFieldException3	NoSuchFieldException
    //   746	1	7	localIllegalAccessException3	IllegalAccessException
    //   751	1	7	localIllegalArgumentException3	IllegalArgumentException
    //   139	133	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   553	591	594	java/lang/NoSuchFieldException
    //   456	494	716	java/lang/NoSuchFieldException
    //   456	494	721	java/lang/IllegalAccessException
    //   456	494	726	java/lang/IllegalArgumentException
    //   553	591	731	java/lang/IllegalAccessException
    //   553	591	736	java/lang/IllegalArgumentException
    //   132	187	741	java/lang/NoSuchFieldException
    //   132	187	746	java/lang/IllegalAccessException
    //   132	187	751	java/lang/IllegalArgumentException
  }
  
  public static void a(pv parampv, EditText paramEditText)
  {
    if (parampv.a)
    {
      paramEditText.setPadding(paramEditText.getResources().getDimensionPixelSize(2131361947), paramEditText.getPaddingTop(), paramEditText.getPaddingRight(), paramEditText.getPaddingBottom());
      return;
    }
    paramEditText.setPadding(paramEditText.getPaddingLeft(), paramEditText.getPaddingTop(), paramEditText.getResources().getDimensionPixelSize(2131361947), paramEditText.getPaddingBottom());
  }
  
  public static void a(pv parampv, TextView paramTextView)
  {
    if (parampv.a)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, new az(b.a(paramTextView.getContext(), 2130840203)), null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130840203, 0, 0, 0);
  }
  
  public static void a(pv parampv, TextView paramTextView, int paramInt)
  {
    if (parampv.a)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(new az(b.a(paramTextView.getContext(), paramInt)), null, null, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
  }
  
  public static void a(pv parampv, TextView paramTextView, CharSequence paramCharSequence)
  {
    if (a(parampv)) {}
    while (paramTextView == null) {
      return;
    }
    int i = paramTextView.getGravity() & 0xFFFFFFF8;
    if (TextUtils.isEmpty(paramCharSequence)) {
      if (parampv.d()) {
        i |= 0x3;
      }
    }
    for (;;)
    {
      paramTextView.setGravity(i);
      return;
      i |= 0x5;
      continue;
      if (a(paramCharSequence)) {
        i |= 0x3;
      } else {
        i |= 0x5;
      }
    }
  }
  
  public static boolean a(pv parampv)
  {
    if (c == null) {
      c = Boolean.valueOf(b(parampv));
    }
    return c.booleanValue();
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      Log.w("TextEmojiLabel/isTextLTR text is empty or null");
    }
    int i;
    do
    {
      return true;
      i = paramCharSequence.toString().codePointAt(0);
    } while ((i < 1424) || (i > 1791));
    return false;
  }
  
  public static void b(pv parampv, TextView paramTextView)
  {
    if (paramTextView != null) {
      a(parampv, paramTextView, paramTextView.getText());
    }
  }
  
  private static boolean b(pv parampv)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {}
    while ((Build.DISPLAY != null) && (d.a(b, Build.DISPLAY))) {
      return true;
    }
    try
    {
      if (parampv.a) {}
      boolean bool2;
      for (parampv = u.a().getText(2131298213);; parampv = "أ")
      {
        Object localObject = new TextView(u.a());
        ((TextView)localObject).setGravity(5);
        ((TextView)localObject).setText(parampv);
        ((TextView)localObject).setTextColor(-16777216);
        ((TextView)localObject).setBackgroundColor(-1);
        ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec((int)((TextView)localObject).getPaint().measureText(parampv.toString()) * 3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        parampv = Bitmap.createBitmap(((TextView)localObject).getMeasuredWidth() / 2, ((TextView)localObject).getMeasuredHeight(), Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(parampv);
        localCanvas.drawColor(-1);
        ((TextView)localObject).getLayout().draw(localCanvas);
        localObject = new int[parampv.getWidth() * parampv.getHeight()];
        parampv.getPixels((int[])localObject, 0, parampv.getWidth(), 0, 0, parampv.getWidth(), parampv.getHeight());
        int j = localObject.length;
        boolean bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          if (localObject[i] != -1) {
            bool1 = true;
          }
          i += 1;
        }
      }
      return bool2;
    }
    catch (Exception parampv)
    {
      bool2 = false;
      Log.d("checkrtl", parampv);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */