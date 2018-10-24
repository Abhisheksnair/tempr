package com.whatsapp.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.whatsapp.atv;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;

public class RegistrationIntentService
  extends IntentService
{
  private final w a = w.a();
  private final atv b = atv.a();
  
  public RegistrationIntentService()
  {
    super(RegistrationIntentService.class.getName());
    setIntentRedelivery(true);
  }
  
  public static void a(Context paramContext)
  {
    Log.i("GCM: refreshing gcm token");
    paramContext.startService(new Intent("com.whatsapp.action.REFRESH", null, paramContext, RegistrationIntentService.class));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Log.i("GCM: verifying registration; serverRegistrationId=" + paramString);
    Intent localIntent = new Intent("com.whatsapp.action.VERIFY", null, paramContext, RegistrationIntentService.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("registrationId", paramString);
    }
    paramContext.startService(localIntent);
  }
  
  /* Error */
  public void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 98	android/os/Binder:clearCallingIdentity	()J
    //   6: lstore 6
    //   8: aload_1
    //   9: ifnonnull +14 -> 23
    //   12: ldc 100
    //   14: invokestatic 103	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   17: lload 6
    //   19: invokestatic 107	android/os/Binder:restoreCallingIdentity	(J)V
    //   22: return
    //   23: ldc 50
    //   25: aload_1
    //   26: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   29: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +15 -> 47
    //   35: ldc 74
    //   37: aload_1
    //   38: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   41: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifeq +917 -> 961
    //   47: aload_1
    //   48: ldc 82
    //   50: invokevirtual 120	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 13
    //   55: aload_0
    //   56: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   59: invokevirtual 123	com/whatsapp/atv:I	()Ljava/lang/String;
    //   62: astore 14
    //   64: aload_0
    //   65: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   68: invokevirtual 127	com/whatsapp/atv:J	()I
    //   71: istore 4
    //   73: ldc 74
    //   75: aload_1
    //   76: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   79: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +140 -> 222
    //   85: aload 13
    //   87: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +132 -> 222
    //   93: iconst_1
    //   94: istore_2
    //   95: ldc 74
    //   97: aload_1
    //   98: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   101: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +123 -> 227
    //   107: aload 13
    //   109: aload 14
    //   111: invokestatic 130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   114: ifne +113 -> 227
    //   117: iconst_1
    //   118: istore_3
    //   119: aload 14
    //   121: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: istore 10
    //   126: ldc -125
    //   128: iload 4
    //   130: if_icmpeq +102 -> 232
    //   133: iconst_1
    //   134: istore 4
    //   136: goto +848 -> 984
    //   139: iload_2
    //   140: ifne +19 -> 159
    //   143: ldc 50
    //   145: aload_1
    //   146: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   149: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: istore 11
    //   154: iload 11
    //   156: ifeq -139 -> 17
    //   159: aload_0
    //   160: invokestatic 137	com/google/android/gms/iid/a:c	(Landroid/content/Context;)Lcom/google/android/gms/iid/a;
    //   163: aload_0
    //   164: ldc -118
    //   166: invokevirtual 142	com/whatsapp/gcm/RegistrationIntentService:getString	(I)Ljava/lang/String;
    //   169: ldc -112
    //   171: invokevirtual 147	com/google/android/gms/iid/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 12
    //   176: aload 12
    //   178: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifeq +62 -> 243
    //   184: new 149	java/lang/AssertionError
    //   187: dup
    //   188: ldc -105
    //   190: invokespecial 154	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   193: athrow
    //   194: astore 12
    //   196: aload 12
    //   198: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   201: ifnonnull +278 -> 479
    //   204: new 149	java/lang/AssertionError
    //   207: dup
    //   208: aload 12
    //   210: invokespecial 154	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   213: athrow
    //   214: astore_1
    //   215: lload 6
    //   217: invokestatic 107	android/os/Binder:restoreCallingIdentity	(J)V
    //   220: aload_1
    //   221: athrow
    //   222: iconst_0
    //   223: istore_2
    //   224: goto -129 -> 95
    //   227: iconst_0
    //   228: istore_3
    //   229: goto -110 -> 119
    //   232: iconst_0
    //   233: istore 4
    //   235: goto +749 -> 984
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -101 -> 139
    //   243: new 62	java/lang/StringBuilder
    //   246: dup
    //   247: ldc -97
    //   249: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: aload 12
    //   254: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc -95
    //   259: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 46	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   268: iload 10
    //   270: ifeq +16 -> 286
    //   273: ldc -93
    //   275: invokestatic 46	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   282: iconst_0
    //   283: invokevirtual 166	com/whatsapp/atv:a	(I)V
    //   286: iload_2
    //   287: ifne +13 -> 300
    //   290: aload 12
    //   292: aload 14
    //   294: invokestatic 130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   297: ifne -280 -> 17
    //   300: aload_0
    //   301: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   304: invokevirtual 169	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   307: ldc -85
    //   309: aload 12
    //   311: invokeinterface 177 3 0
    //   316: ldc -77
    //   318: ldc -125
    //   320: invokeinterface 183 3 0
    //   325: invokeinterface 186 1 0
    //   330: ldc 50
    //   332: aload_1
    //   333: invokevirtual 110	android/content/Intent:getAction	()Ljava/lang/String;
    //   336: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifne +13 -> 352
    //   342: aload 12
    //   344: aload 13
    //   346: invokestatic 130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   349: ifne -332 -> 17
    //   352: new 62	java/lang/StringBuilder
    //   355: dup
    //   356: ldc -68
    //   358: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload 12
    //   363: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 46	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   372: aload_0
    //   373: getfield 26	com/whatsapp/gcm/RegistrationIntentService:a	Lcom/whatsapp/messaging/w;
    //   376: astore 13
    //   378: aload 13
    //   380: getfield 191	com/whatsapp/messaging/w:b	Lcom/whatsapp/messaging/m;
    //   383: getfield 197	com/whatsapp/messaging/m:d	Z
    //   386: ifeq -369 -> 17
    //   389: ldc -57
    //   391: invokestatic 201	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   394: aload 13
    //   396: getfield 191	com/whatsapp/messaging/w:b	Lcom/whatsapp/messaging/m;
    //   399: astore 13
    //   401: new 203	android/os/Bundle
    //   404: dup
    //   405: invokespecial 205	android/os/Bundle:<init>	()V
    //   408: astore 14
    //   410: aload 14
    //   412: ldc -49
    //   414: aload 12
    //   416: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 14
    //   421: ldc -44
    //   423: ldc -42
    //   425: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: aload 13
    //   430: aconst_null
    //   431: iconst_0
    //   432: iconst_1
    //   433: iconst_0
    //   434: aload 14
    //   436: invokestatic 220	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   439: invokevirtual 223	com/whatsapp/messaging/m:a	(Landroid/os/Message;)V
    //   442: goto -425 -> 17
    //   445: astore_1
    //   446: aload_1
    //   447: invokevirtual 224	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   450: ifnull +27 -> 477
    //   453: aload_1
    //   454: invokevirtual 224	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   457: ldc -30
    //   459: invokevirtual 229	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifne +482 -> 944
    //   465: aload_1
    //   466: invokevirtual 224	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   469: ldc -25
    //   471: invokevirtual 229	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   474: ifne +470 -> 944
    //   477: aload_1
    //   478: athrow
    //   479: aload 12
    //   481: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   484: astore 13
    //   486: aload 13
    //   488: invokevirtual 234	java/lang/String:hashCode	()I
    //   491: lookupswitch	default:+516->1007, -2146020875:+123->614, -1992442893:+138->629, -1943616152:+262->753, -1800638118:+168->659, -1579216525:+246->737, -1515255836:+214->705, -829011630:+230->721, -595928767:+107->598, 855732677:+183->674, 901541140:+198->689, 1750400351:+153->644
    //   588: new 149	java/lang/AssertionError
    //   591: dup
    //   592: aload 12
    //   594: invokespecial 154	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   597: athrow
    //   598: aload 13
    //   600: ldc -20
    //   602: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   605: ifeq +402 -> 1007
    //   608: iload 5
    //   610: istore_2
    //   611: goto +398 -> 1009
    //   614: aload 13
    //   616: ldc -18
    //   618: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +386 -> 1007
    //   624: iconst_1
    //   625: istore_2
    //   626: goto +383 -> 1009
    //   629: aload 13
    //   631: ldc -16
    //   633: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   636: ifeq +371 -> 1007
    //   639: iconst_2
    //   640: istore_2
    //   641: goto +368 -> 1009
    //   644: aload 13
    //   646: ldc -14
    //   648: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   651: ifeq +356 -> 1007
    //   654: iconst_3
    //   655: istore_2
    //   656: goto +353 -> 1009
    //   659: aload 13
    //   661: ldc -12
    //   663: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +341 -> 1007
    //   669: iconst_4
    //   670: istore_2
    //   671: goto +338 -> 1009
    //   674: aload 13
    //   676: ldc -10
    //   678: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifeq +326 -> 1007
    //   684: iconst_5
    //   685: istore_2
    //   686: goto +323 -> 1009
    //   689: aload 13
    //   691: ldc -8
    //   693: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifeq +311 -> 1007
    //   699: bipush 6
    //   701: istore_2
    //   702: goto +307 -> 1009
    //   705: aload 13
    //   707: ldc -6
    //   709: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq +295 -> 1007
    //   715: bipush 7
    //   717: istore_2
    //   718: goto +291 -> 1009
    //   721: aload 13
    //   723: ldc -4
    //   725: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   728: ifeq +279 -> 1007
    //   731: bipush 8
    //   733: istore_2
    //   734: goto +275 -> 1009
    //   737: aload 13
    //   739: ldc -2
    //   741: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   744: ifeq +263 -> 1007
    //   747: bipush 9
    //   749: istore_2
    //   750: goto +259 -> 1009
    //   753: aload 13
    //   755: ldc_w 256
    //   758: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifeq +246 -> 1007
    //   764: bipush 10
    //   766: istore_2
    //   767: goto +242 -> 1009
    //   770: aload_1
    //   771: ldc_w 258
    //   774: ldc2_w 259
    //   777: invokevirtual 264	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   780: ldc2_w 265
    //   783: invokestatic 272	java/lang/Math:max	(JJ)J
    //   786: lstore 8
    //   788: aload_1
    //   789: ldc_w 258
    //   792: ldc2_w 273
    //   795: lload 8
    //   797: lmul
    //   798: invokevirtual 277	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   801: pop
    //   802: aload_0
    //   803: ldc_w 279
    //   806: invokevirtual 283	com/whatsapp/gcm/RegistrationIntentService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   809: checkcast 285	android/app/AlarmManager
    //   812: astore 12
    //   814: aload_0
    //   815: iconst_0
    //   816: aload_1
    //   817: iconst_0
    //   818: invokestatic 291	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   821: astore_1
    //   822: aload 12
    //   824: aload_1
    //   825: invokevirtual 295	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
    //   828: aload 12
    //   830: iconst_3
    //   831: lload 8
    //   833: invokestatic 300	android/os/SystemClock:elapsedRealtime	()J
    //   836: ladd
    //   837: aload_1
    //   838: invokevirtual 304	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   841: goto -824 -> 17
    //   844: ldc_w 306
    //   847: invokestatic 309	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   850: aload_0
    //   851: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   854: invokevirtual 312	com/whatsapp/atv:K	()V
    //   857: goto -840 -> 17
    //   860: new 62	java/lang/StringBuilder
    //   863: dup
    //   864: ldc_w 314
    //   867: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   870: aload 12
    //   872: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   875: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 309	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   884: aload_0
    //   885: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   888: invokevirtual 312	com/whatsapp/atv:K	()V
    //   891: goto -874 -> 17
    //   894: new 62	java/lang/StringBuilder
    //   897: dup
    //   898: ldc_w 316
    //   901: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   904: aload 12
    //   906: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   909: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: ldc_w 318
    //   915: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokestatic 323	com/google/android/gms/common/b:a	()Lcom/google/android/gms/common/b;
    //   921: aload_0
    //   922: invokevirtual 326	com/google/android/gms/common/b:a	(Landroid/content/Context;)I
    //   925: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   928: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 309	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   934: aload_0
    //   935: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   938: invokevirtual 312	com/whatsapp/atv:K	()V
    //   941: goto -924 -> 17
    //   944: ldc_w 331
    //   947: aload_1
    //   948: invokestatic 334	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   951: aload_0
    //   952: getfield 33	com/whatsapp/gcm/RegistrationIntentService:b	Lcom/whatsapp/atv;
    //   955: invokevirtual 312	com/whatsapp/atv:K	()V
    //   958: goto -941 -> 17
    //   961: new 62	java/lang/StringBuilder
    //   964: dup
    //   965: ldc_w 336
    //   968: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   971: aload_1
    //   972: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokestatic 103	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   981: goto -964 -> 17
    //   984: iload_2
    //   985: ifne +17 -> 1002
    //   988: iload 10
    //   990: ifne +12 -> 1002
    //   993: iload_3
    //   994: ifne +8 -> 1002
    //   997: iload 4
    //   999: ifeq -761 -> 238
    //   1002: iconst_1
    //   1003: istore_2
    //   1004: goto -865 -> 139
    //   1007: iconst_m1
    //   1008: istore_2
    //   1009: iload_2
    //   1010: tableswitch	default:+58->1068, 0:+-240->770, 1:+-240->770, 2:+-240->770, 3:+-166->844, 4:+-150->860, 5:+-150->860, 6:+-116->894, 7:+-116->894, 8:+-116->894, 9:+-116->894, 10:+-116->894
    //   1068: goto -480 -> 588
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	this	RegistrationIntentService
    //   0	1071	1	paramIntent	Intent
    //   94	916	2	i	int
    //   118	876	3	j	int
    //   71	927	4	k	int
    //   1	608	5	m	int
    //   6	210	6	l1	long
    //   786	46	8	l2	long
    //   124	865	10	bool1	boolean
    //   152	3	11	bool2	boolean
    //   174	3	12	str	String
    //   194	399	12	localIOException	java.io.IOException
    //   812	93	12	localAlarmManager	android.app.AlarmManager
    //   53	701	13	localObject1	Object
    //   62	373	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   159	194	194	java/io/IOException
    //   243	268	194	java/io/IOException
    //   273	286	194	java/io/IOException
    //   290	300	194	java/io/IOException
    //   300	352	194	java/io/IOException
    //   352	442	194	java/io/IOException
    //   12	17	214	finally
    //   23	47	214	finally
    //   47	93	214	finally
    //   95	117	214	finally
    //   119	126	214	finally
    //   143	154	214	finally
    //   159	194	214	finally
    //   196	214	214	finally
    //   243	268	214	finally
    //   273	286	214	finally
    //   290	300	214	finally
    //   300	352	214	finally
    //   352	442	214	finally
    //   446	477	214	finally
    //   477	479	214	finally
    //   479	588	214	finally
    //   588	598	214	finally
    //   598	608	214	finally
    //   614	624	214	finally
    //   629	639	214	finally
    //   644	654	214	finally
    //   659	669	214	finally
    //   674	684	214	finally
    //   689	699	214	finally
    //   705	715	214	finally
    //   721	731	214	finally
    //   737	747	214	finally
    //   753	764	214	finally
    //   770	841	214	finally
    //   844	857	214	finally
    //   860	891	214	finally
    //   894	941	214	finally
    //   944	958	214	finally
    //   961	981	214	finally
    //   159	194	445	java/lang/SecurityException
    //   243	268	445	java/lang/SecurityException
    //   273	286	445	java/lang/SecurityException
    //   290	300	445	java/lang/SecurityException
    //   300	352	445	java/lang/SecurityException
    //   352	442	445	java/lang/SecurityException
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/RegistrationIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */