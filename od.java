package com.whatsapp;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.whatsapp.data.ct;
import com.whatsapp.data.cu;
import com.whatsapp.data.e;
import com.whatsapp.fieldstats.events.WamCall;
import com.whatsapp.g.f;
import com.whatsapp.i.d.b;
import com.whatsapp.registration.RegisterPhone;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bc;
import com.whatsapp.registration.x;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ad;
import com.whatsapp.util.bf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class od
{
  private static od a;
  private final pv b;
  private final com.whatsapp.util.a.c c;
  private final va d;
  private final oz e;
  private final ox f;
  private final bf g;
  private final x h;
  private final e i;
  private final and j;
  private final auu k;
  private final vv l;
  private final aw m;
  private final atu n;
  private final atv o;
  
  private od(pv parampv, com.whatsapp.util.a.c paramc, va paramva, oz paramoz, ox paramox, bf parambf, x paramx, e parame, and paramand, auu paramauu, vv paramvv, aw paramaw, atu paramatu, atv paramatv)
  {
    this.b = parampv;
    this.c = paramc;
    this.d = paramva;
    this.e = paramoz;
    this.f = paramox;
    this.g = parambf;
    this.h = paramx;
    this.i = parame;
    this.j = paramand;
    this.k = paramauu;
    this.l = paramvv;
    this.m = paramaw;
    this.n = paramatu;
    this.o = paramatv;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    if (paramString2.length() == 0) {
      return paramString1.length();
    }
    if (paramString1.length() == 0) {
      return paramString2.length();
    }
    int i1 = paramString1.length();
    int i2 = paramString2.length();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1 + 1, i2 + 1 });
    i1 = 0;
    while (i1 <= paramString1.length())
    {
      arrayOfInt[i1][0] = i1;
      i1 += 1;
    }
    i1 = 0;
    while (i1 <= paramString2.length())
    {
      arrayOfInt[0][i1] = i1;
      i1 += 1;
    }
    i1 = 1;
    while (i1 <= paramString2.length())
    {
      i2 = 1;
      if (i2 <= paramString1.length())
      {
        if (paramString1.charAt(i2 - 1) == paramString2.charAt(i1 - 1)) {
          arrayOfInt[i2][i1] = arrayOfInt[(i2 - 1)][(i1 - 1)];
        }
        for (;;)
        {
          i2 += 1;
          break;
          arrayOfInt[i2][i1] = Math.min(arrayOfInt[(i2 - 1)][(i1 - 1)] + 1, Math.min(arrayOfInt[(i2 - 1)][i1] + 1, arrayOfInt[i2][(i1 - 1)] + 1));
        }
      }
      i1 += 1;
    }
    return arrayOfInt[paramString1.length()][paramString2.length()];
  }
  
  public static od a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new od(pv.a(), com.whatsapp.util.a.c.a(), va.a(), oz.a(), ox.a(), bf.a(), x.a(), e.a(), and.a(), auu.a(), vv.a(), aw.a(), atu.a(), atv.a());
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public static File a(String paramString)
  {
    // Byte code:
    //   0: new 183	java/io/File
    //   3: dup
    //   4: invokestatic 188	com/whatsapp/u:a	()Landroid/content/Context;
    //   7: invokevirtual 194	android/content/Context:getFilesDir	()Ljava/io/File;
    //   10: ldc -60
    //   12: invokespecial 199	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 203	java/io/File:exists	()Z
    //   20: ifeq +17 -> 37
    //   23: aload_3
    //   24: invokevirtual 206	java/io/File:delete	()Z
    //   27: ifne +10 -> 37
    //   30: ldc -48
    //   32: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   35: aconst_null
    //   36: areturn
    //   37: new 215	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: iconst_1
    //   43: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 222	java/lang/String:getBytes	()[B
    //   54: invokevirtual 226	java/io/FileOutputStream:write	([B)V
    //   57: aload_2
    //   58: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   61: aload_3
    //   62: astore_0
    //   63: aload_0
    //   64: areturn
    //   65: astore_0
    //   66: new 231	java/lang/StringBuilder
    //   69: dup
    //   70: ldc -23
    //   72: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   85: aconst_null
    //   86: astore_0
    //   87: goto -24 -> 63
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_1
    //   95: new 231	java/lang/StringBuilder
    //   98: dup
    //   99: ldc -11
    //   101: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_3
    //   105: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   122: aconst_null
    //   123: astore_0
    //   124: goto -61 -> 63
    //   127: astore_0
    //   128: new 231	java/lang/StringBuilder
    //   131: dup
    //   132: ldc -23
    //   134: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -86 -> 63
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: astore_1
    //   166: new 231	java/lang/StringBuilder
    //   169: dup
    //   170: ldc -23
    //   172: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   185: goto -22 -> 163
    //   188: astore_0
    //   189: goto -34 -> 155
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -102 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   48	112	1	localObject	Object
    //   165	11	1	localIOException1	IOException
    //   46	148	2	localFileOutputStream	java.io.FileOutputStream
    //   15	47	3	localFile	File
    //   90	15	3	localIOException2	IOException
    //   192	1	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   57	61	65	java/io/IOException
    //   37	47	90	java/io/IOException
    //   118	122	127	java/io/IOException
    //   37	47	152	finally
    //   159	163	165	java/io/IOException
    //   49	57	188	finally
    //   95	114	188	finally
    //   49	57	192	java/io/IOException
  }
  
  /* Error */
  private File a(List<File> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 253 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 53	com/whatsapp/od:f	Lcom/whatsapp/ox;
    //   19: ldc -1
    //   21: invokevirtual 257	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   24: astore 4
    //   26: new 259	java/util/zip/ZipOutputStream
    //   29: dup
    //   30: new 261	java/io/BufferedOutputStream
    //   33: dup
    //   34: new 215	java/io/FileOutputStream
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 267	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: invokespecial 268	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_3
    //   50: sipush 16384
    //   53: newarray <illegal type>
    //   55: astore 5
    //   57: aload_1
    //   58: invokeinterface 272 1 0
    //   63: astore_1
    //   64: aload_1
    //   65: invokeinterface 277 1 0
    //   70: ifeq +169 -> 239
    //   73: aload_1
    //   74: invokeinterface 281 1 0
    //   79: checkcast 183	java/io/File
    //   82: astore 7
    //   84: new 283	java/io/BufferedInputStream
    //   87: dup
    //   88: new 285	java/io/FileInputStream
    //   91: dup
    //   92: aload 7
    //   94: invokespecial 286	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: sipush 16384
    //   100: invokespecial 289	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   103: astore 6
    //   105: aload_3
    //   106: new 291	java/util/zip/ZipEntry
    //   109: dup
    //   110: aload 7
    //   112: invokevirtual 294	java/io/File:getName	()Ljava/lang/String;
    //   115: invokespecial 295	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   118: invokevirtual 299	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   121: aload 6
    //   123: aload 5
    //   125: iconst_0
    //   126: sipush 16384
    //   129: invokevirtual 303	java/io/BufferedInputStream:read	([BII)I
    //   132: istore_2
    //   133: iload_2
    //   134: iconst_m1
    //   135: if_icmpeq +77 -> 212
    //   138: aload_3
    //   139: aload 5
    //   141: iconst_0
    //   142: iload_2
    //   143: invokevirtual 306	java/util/zip/ZipOutputStream:write	([BII)V
    //   146: goto -25 -> 121
    //   149: astore_1
    //   150: aload_1
    //   151: athrow
    //   152: astore 4
    //   154: aload_1
    //   155: astore 5
    //   157: aload 4
    //   159: astore_1
    //   160: aload 5
    //   162: ifnull +69 -> 231
    //   165: aload 6
    //   167: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore 4
    //   174: aload_3
    //   175: astore_1
    //   176: aload 4
    //   178: astore_3
    //   179: new 231	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 309
    //   186: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_3
    //   190: invokevirtual 310	java/io/IOException:toString	()Ljava/lang/String;
    //   193: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 314	java/util/zip/ZipOutputStream:close	()V
    //   210: aconst_null
    //   211: areturn
    //   212: aload 6
    //   214: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   217: goto -153 -> 64
    //   220: astore_1
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 314	java/util/zip/ZipOutputStream:close	()V
    //   229: aload_1
    //   230: athrow
    //   231: aload 6
    //   233: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   236: goto -66 -> 170
    //   239: aload_3
    //   240: invokevirtual 314	java/util/zip/ZipOutputStream:close	()V
    //   243: aload 4
    //   245: areturn
    //   246: astore_1
    //   247: new 231	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 316
    //   254: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload_1
    //   258: invokevirtual 310	java/io/IOException:toString	()Ljava/lang/String;
    //   261: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_1
    //   273: new 231	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 316
    //   280: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokevirtual 310	java/io/IOException:toString	()Ljava/lang/String;
    //   287: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_3
    //   299: new 231	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 316
    //   306: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload_3
    //   310: invokevirtual 310	java/io/IOException:toString	()Ljava/lang/String;
    //   313: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 213	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   322: goto -93 -> 229
    //   325: astore 4
    //   327: goto -157 -> 170
    //   330: astore_1
    //   331: aconst_null
    //   332: astore_3
    //   333: goto -112 -> 221
    //   336: astore 4
    //   338: aload_1
    //   339: astore_3
    //   340: aload 4
    //   342: astore_1
    //   343: goto -122 -> 221
    //   346: astore_3
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -170 -> 179
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 5
    //   356: goto -196 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	od
    //   0	359	1	paramList	List<File>
    //   132	11	2	i1	int
    //   49	191	3	localObject1	Object
    //   298	12	3	localIOException1	IOException
    //   332	8	3	localList	List<File>
    //   346	1	3	localIOException2	IOException
    //   24	15	4	localFile1	File
    //   152	6	4	localObject2	Object
    //   172	72	4	localIOException3	IOException
    //   325	1	4	localThrowable	Throwable
    //   336	5	4	localObject3	Object
    //   55	300	5	localObject4	Object
    //   103	129	6	localBufferedInputStream	java.io.BufferedInputStream
    //   82	29	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   105	121	149	java/lang/Throwable
    //   121	133	149	java/lang/Throwable
    //   138	146	149	java/lang/Throwable
    //   150	152	152	finally
    //   50	64	172	java/io/IOException
    //   64	105	172	java/io/IOException
    //   165	170	172	java/io/IOException
    //   170	172	172	java/io/IOException
    //   212	217	172	java/io/IOException
    //   231	236	172	java/io/IOException
    //   50	64	220	finally
    //   64	105	220	finally
    //   165	170	220	finally
    //   170	172	220	finally
    //   212	217	220	finally
    //   231	236	220	finally
    //   239	243	246	java/io/IOException
    //   206	210	272	java/io/IOException
    //   225	229	298	java/io/IOException
    //   165	170	325	java/lang/Throwable
    //   15	50	330	finally
    //   179	202	336	finally
    //   15	50	346	java/io/IOException
    //   105	121	352	finally
    //   121	133	352	finally
    //   138	146	352	finally
  }
  
  @TargetApi(23)
  private static String a(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext == null)
        {
          Log.e("findmissingpermissions/no-package-manager");
          return "";
        }
        paramContext = paramContext.getPackageInfo(au.b(), 4096);
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < paramContext.requestedPermissionsFlags.length)
        {
          if ((paramContext.requestedPermissionsFlags[i1] & 0x2) == 0)
          {
            if (localStringBuilder.length() != 0) {
              localStringBuilder.append(", ");
            }
            localStringBuilder.append(paramContext.requestedPermissions[i1]);
          }
        }
        else
        {
          paramContext = localStringBuilder.toString();
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.e(paramContext);
        return "";
      }
      i1 += 1;
    }
  }
  
  private static void a(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 instanceof JSONObject)) {
      paramObject2 = (JSONObject)paramObject2;
    }
    while (!(paramObject2 instanceof StringBuilder)) {
      try
      {
        ((JSONObject)paramObject2).put(paramString, paramObject1);
        return;
      }
      catch (JSONException paramString)
      {
        Log.e("emailsender/json/error " + paramString);
        return;
      }
    }
    ((StringBuilder)paramObject2).append(paramString).append(": ").append(paramObject1).append('\n');
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramString.length())
      {
        paramStringBuilder.append(paramString.charAt(i1)).append('.');
        i1 += 1;
      }
    }
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() * 2);
    a(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: new 231	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 385	java/io/BufferedReader
    //   11: dup
    //   12: new 387	java/io/FileReader
    //   15: dup
    //   16: ldc_w 389
    //   19: invokespecial 390	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 393	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 396	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 397	java/io/BufferedReader:close	()V
    //   41: aload_1
    //   42: astore_0
    //   43: new 385	java/io/BufferedReader
    //   46: dup
    //   47: new 387	java/io/FileReader
    //   50: dup
    //   51: ldc_w 399
    //   54: invokespecial 390	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   57: invokespecial 393	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_1
    //   61: aload_3
    //   62: bipush 32
    //   64: invokevirtual 376	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 396	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 397	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: areturn
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: astore_0
    //   93: aload_1
    //   94: invokevirtual 397	java/io/BufferedReader:close	()V
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_3
    //   103: ldc_w 401
    //   106: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   114: goto -71 -> 43
    //   117: astore_2
    //   118: aload_0
    //   119: astore_1
    //   120: aload_2
    //   121: astore_0
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 397	java/io/BufferedReader:close	()V
    //   130: aload_0
    //   131: athrow
    //   132: astore_0
    //   133: aload_3
    //   134: ldc_w 403
    //   137: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_0
    //   142: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   145: goto -66 -> 79
    //   148: astore_0
    //   149: goto -27 -> 122
    //   152: astore_2
    //   153: goto -66 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	95	0	localObject1	Object
    //   132	10	0	localIOException1	IOException
    //   148	1	0	localObject2	Object
    //   25	73	1	localBufferedReader	java.io.BufferedReader
    //   101	10	1	localIOException2	IOException
    //   119	8	1	localObject3	Object
    //   84	16	2	localObject4	Object
    //   117	4	2	localObject5	Object
    //   152	1	2	localObject6	Object
    //   7	127	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	26	84	finally
    //   37	41	101	java/io/IOException
    //   93	97	101	java/io/IOException
    //   99	101	101	java/io/IOException
    //   43	61	117	finally
    //   75	79	132	java/io/IOException
    //   126	130	132	java/io/IOException
    //   130	132	132	java/io/IOException
    //   61	75	148	finally
    //   26	35	152	finally
  }
  
  /* Error */
  private String d()
  {
    // Byte code:
    //   0: new 231	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 55	com/whatsapp/od:g	Lcom/whatsapp/util/bf;
    //   12: iconst_0
    //   13: getstatic 413	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   16: invokevirtual 416	com/whatsapp/util/bf:a	(ILjava/util/concurrent/TimeUnit;)Lcom/whatsapp/util/bf$b;
    //   19: astore_2
    //   20: aload_2
    //   21: getfield 421	com/whatsapp/util/bf$b:a	Ljava/util/Set;
    //   24: ifnull +28 -> 52
    //   27: aload_1
    //   28: ldc_w 423
    //   31: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: getfield 421	com/whatsapp/util/bf$b:a	Ljava/util/Set;
    //   38: invokeinterface 426 1 0
    //   43: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: bipush 32
    //   48: invokevirtual 376	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: getfield 431	com/whatsapp/util/bf$b:b	Ljava/util/Set;
    //   56: ifnull +28 -> 84
    //   59: aload_1
    //   60: ldc_w 433
    //   63: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_2
    //   67: getfield 431	com/whatsapp/util/bf$b:b	Ljava/util/Set;
    //   70: invokeinterface 426 1 0
    //   75: invokevirtual 429	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: bipush 32
    //   80: invokevirtual 376	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc_w 435
    //   87: invokestatic 441	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   90: pop
    //   91: aload_1
    //   92: ldc_w 443
    //   95: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: getfield 61	com/whatsapp/od:j	Lcom/whatsapp/and;
    //   103: aload_0
    //   104: getfield 69	com/whatsapp/od:n	Lcom/whatsapp/atu;
    //   107: invokestatic 448	com/whatsapp/r:a	(Lcom/whatsapp/and;Lcom/whatsapp/atu;)Z
    //   110: ifeq +11 -> 121
    //   113: aload_1
    //   114: ldc_w 450
    //   117: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: invokestatic 452	com/whatsapp/r:a	()Z
    //   124: ifeq +11 -> 135
    //   127: aload_1
    //   128: ldc_w 454
    //   131: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: ldc_w 456
    //   139: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: invokestatic 460	com/whatsapp/gdrive/GoogleDriveService:c	()Z
    //   146: ifeq +58 -> 204
    //   149: aload_1
    //   150: ldc_w 462
    //   153: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc_w 464
    //   160: invokestatic 466	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   163: invokestatic 470	com/whatsapp/br:b	()Z
    //   166: ifeq +47 -> 213
    //   169: aload_1
    //   170: ldc_w 472
    //   173: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 474
    //   180: invokestatic 466	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: invokevirtual 350	java/lang/StringBuilder:length	()I
    //   187: ifne +35 -> 222
    //   190: aconst_null
    //   191: areturn
    //   192: astore_2
    //   193: aload_1
    //   194: ldc_w 476
    //   197: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: goto -117 -> 84
    //   204: ldc_w 478
    //   207: invokestatic 466	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   210: goto -47 -> 163
    //   213: ldc_w 480
    //   216: invokestatic 466	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   219: goto -36 -> 183
    //   222: aload_1
    //   223: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: areturn
    //   227: astore_2
    //   228: goto -129 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	od
    //   7	216	1	localStringBuilder	StringBuilder
    //   19	48	2	localb	com.whatsapp.util.bf.b
    //   192	1	2	localException	Exception
    //   227	1	2	localClassNotFoundException	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   8	52	192	java/lang/Exception
    //   52	84	192	java/lang/Exception
    //   84	99	227	java/lang/ClassNotFoundException
  }
  
  public final File a(File paramFile, boolean paramBoolean)
  {
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = Log.a(3);
      if (paramFile != null) {
        localArrayList.add(paramFile);
      }
      paramFile = com.whatsapp.util.a.a.b();
      if (paramFile == null) {
        break label56;
      }
      Log.d("email-sender/upload-zipped-log-files adding ANR traces");
      localArrayList.add(paramFile);
    }
    for (;;)
    {
      return a(localArrayList);
      localArrayList = new ArrayList();
      break;
      label56:
      Log.w("email-sender/upload-zipped-log-files no ANR traces to send");
    }
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, String paramString4)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBoolean, paramLong1, paramLong2, paramString4, false);
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, String paramString4, boolean paramBoolean2)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
      localLocale = paramContext.getResources().getConfiguration().locale;
      str5 = this.o.F();
      str6 = this.o.G();
      str7 = au.c();
      str8 = au.e();
      localObject3 = this.j.c;
      if (localObject3 == null) {
        break label2586;
      }
      switch (((TelephonyManager)localObject3).getPhoneType())
      {
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        SimpleDateFormat localSimpleDateFormat;
        Locale localLocale;
        String str5;
        String str6;
        String str7;
        String str8;
        Object localObject3;
        label192:
        String str3;
        String str2;
        String str1;
        Object localObject2;
        Object localObject8;
        Object localObject1;
        Object localObject7;
        label233:
        label251:
        int i1;
        Object localObject4;
        int i2;
        label310:
        label399:
        String str4;
        label449:
        label565:
        label625:
        Object localObject6;
        label666:
        label705:
        label899:
        label921:
        label1453:
        label1577:
        label1672:
        label1716:
        label1774:
        label1891:
        label1956:
        label1986:
        label1994:
        Log.d("exception during email composition", paramContext);
        localStringBuilder.append("\n\n\n\n{{email_exception}}\n");
        localStringBuilder.append(paramContext);
        continue;
        if (auj.b())
        {
          a("Web session", "token saved", localObject6);
          continue;
          a("CCode", str5 + " " + str6, localObject6);
          continue;
          paramString1 = paramString4.getActiveNetworkInfo();
          continue;
          ((StringBuilder)localObject1).append("NONE");
          continue;
          paramContext = paramString1;
          if (str6.endsWith((String)localObject2))
          {
            paramContext = paramString1;
            if (com.whatsapp.registration.u.c(str5, (String)localObject2) == 5) {
              paramContext = null;
            }
          }
          while (paramContext != null)
          {
            paramContext = String.valueOf(paramContext);
            break label1672;
            localObject1 = paramString4.getAllNetworks();
            int i3 = localObject1.length;
            i2 = 0;
            i1 = 0;
            if (i1 >= i3) {
              break label1716;
            }
            localObject3 = localObject1[i1];
            if (i2 != 0)
            {
              paramContext.append(';');
              paramString1.append(';');
            }
            localObject2 = paramString4.getNetworkCapabilities((Network)localObject3);
            if (localObject2 == null) {
              break label2687;
            }
            localObject4 = ((Network)localObject3).toString();
            if (((NetworkCapabilities)localObject2).hasCapability(11)) {
              break label2702;
            }
            paramBoolean2 = true;
            paramContext.append(String.format("%s:%s", new Object[] { localObject4, String.valueOf(paramBoolean2) }));
            localObject3 = ((Network)localObject3).toString();
            if (((NetworkCapabilities)localObject2).hasCapability(13)) {
              break label2708;
            }
            paramBoolean2 = true;
            paramString1.append(String.format("%s:%s", new Object[] { localObject3, String.valueOf(paramBoolean2) }));
            break label2687;
            paramContext = String.valueOf(paramString2.isNetworkRoaming());
            break label1774;
            a("Video transcode", "supported", localObject6);
            break label1956;
            a("Video transcode", "old api", localObject6);
            break label1956;
            a("Video transcode", "unsupported device", localObject6);
            break label1956;
            a("Video transcode", "no encoders", localObject6);
            break label1956;
            break label2622;
            break label251;
            localObject2 = "UNKNOWN";
            break;
            localObject1 = "UNKNOWN";
            break label192;
            for (;;)
            {
              if (paramLong2 != -1L) {
                break label399;
              }
              str4 = "Not Calculated";
              if (paramLong1 != -1L) {
                break label449;
              }
              localObject1 = "Not Calculated";
              break label251;
              localObject2 = "NONE";
              break;
              localObject2 = "GSM";
              break;
              localObject2 = "CDMA";
              break;
              localObject2 = "SIP";
              break;
              localObject1 = "GPRS";
              break label192;
              localObject1 = "EDGE";
              break label192;
              localObject1 = "UMTS";
              break label192;
              localObject1 = "HSDPA";
              break label192;
              localObject1 = "HSUPA";
              break label192;
              localObject1 = "HSPA";
              break label192;
              localObject1 = "CDMA";
              break label192;
              localObject1 = "CDMA - EvDo rev. 0";
              break label192;
              localObject1 = "CDMA - EvDo rev. A";
              break label192;
              localObject1 = "CDMA - EvDo rev. B";
              break label192;
              localObject1 = "CDMA - 1xRTT";
              break label192;
              localObject1 = "LTE";
              break label192;
              localObject1 = "CDMA - eHRPD";
              break label192;
              localObject1 = "iDEN";
              break label192;
              localObject1 = "HSPA+";
              break label192;
              str1 = "UNKNOWN (no telephony manager)";
              str2 = "N/A (no telephony manager)";
              str3 = "N/A (no telephony manager)";
              localObject7 = "UNKNOWN (no telephony manager)";
              localObject8 = "UNKNOWN (no telephony manager)";
              break label233;
              localObject2 = "DN";
            }
            break label310;
          }
          paramContext = "unknown";
          continue;
          for (;;)
          {
            if (i1 == 0) {
              break label2720;
            }
            paramContext = "Yes";
            break label1891;
            break label1956;
            localObject4 = "";
            break;
            localObject4 = "zz";
            break label899;
            localObject4 = "zz";
            break label921;
            paramContext = null;
            break label1453;
            paramContext = "true";
            break label1577;
            i2 += 1;
            i1 += 1;
            break label2168;
            paramBoolean2 = false;
            break label2235;
            paramBoolean2 = false;
            break label2283;
            i1 = 0;
          }
          paramContext = "No";
        }
      }
    }
    switch (((TelephonyManager)localObject3).getNetworkType())
    {
    default: 
      str3 = ad.a(((TelephonyManager)localObject3).getNetworkOperator(), "N/A");
      str2 = ad.a(((TelephonyManager)localObject3).getSimOperator(), "N/A");
      str1 = ((TelephonyManager)localObject3).getNetworkOperatorName();
      localObject8 = localObject2;
      localObject7 = localObject1;
      if (this.k.a)
      {
        localObject2 = "UP";
        break label2403;
        if (!(paramContext instanceof SearchFAQ)) {
          break label565;
        }
        i1 = ((SearchFAQ)paramContext).o;
        paramString4 = Integer.valueOf(((SearchFAQ)paramContext).n.size());
        localObject3 = Integer.valueOf(i1);
      }
      Object localObject5;
      for (;;)
      {
        i1 = 0;
        localObject4 = this.i.b.b().iterator();
        i2 = 0;
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label625;
          }
          localObject5 = (cu)((Iterator)localObject4).next();
          if (((cu)localObject5).e != null)
          {
            if (!((cu)localObject5).e.startsWith("smb:")) {
              break;
            }
            i2 += 1;
          }
        }
        if (this.k.b)
        {
          localObject2 = "SC/XC";
          break label2403;
        }
        if (!this.h.a) {
          break label2614;
        }
        localObject2 = "PW";
        break label2403;
        localObject1 = Long.toString(paramLong2);
        str4 = (String)localObject1 + " (" + Formatter.formatFileSize(u.a(), paramLong2) + ")";
        break label2417;
        if (paramLong1 == -2L)
        {
          localObject1 = paramString4;
          if (!"removed".equals(paramString4)) {
            break;
          }
          localObject1 = "Not present";
          break;
        }
        localObject1 = Long.toString(paramLong1);
        localObject1 = (String)localObject1 + " (" + Formatter.formatFileSize(u.a(), paramLong1) + ")";
        if (!"mounted_ro".equals(paramString4)) {
          break label2384;
        }
        localObject1 = (String)localObject1 + " (read-only)";
        break;
        if ((paramContext instanceof DescribeProblemActivity))
        {
          paramString4 = Integer.valueOf(-1);
          localObject3 = Integer.valueOf(0);
        }
        else
        {
          paramString4 = Integer.valueOf(-1);
          localObject3 = Integer.valueOf(-1);
        }
      }
      if (((cu)localObject5).e.startsWith("ent:"))
      {
        i1 += 1;
        break label2622;
        if (!paramBoolean1)
        {
          localStringBuilder.append("\n\n\n\n");
          localStringBuilder.append("--Support Info--\n");
        }
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean1)
        {
          localObject6 = localJSONObject;
          if (!paramBoolean2)
          {
            localObject4 = this.d.b();
            if (localObject4 == null) {
              break label1986;
            }
            localObject5 = "+" + (String)localObject4;
            localObject4 = localObject5;
            if (this.m.m())
            {
              localObject5 = "chnum " + (String)localObject5;
              Me localMe = this.d.e();
              localObject4 = localObject5;
              if (localMe != null)
              {
                localObject4 = localObject5;
                if (localMe.jabber_id != null) {
                  localObject4 = (String)localObject5 + " (" + localMe.jabber_id + ")";
                }
              }
            }
            a("Debug info", localObject4, localObject6);
          }
          a("Description", au.d(), localObject6);
          localObject5 = new StringBuilder().append(au.d());
          if (!av.d()) {
            break label2651;
          }
          localObject4 = " " + au.f();
          a("Version", (String)localObject4, localObject6);
          if (localLocale == null) {
            break label2659;
          }
          localObject4 = localLocale.getCountry();
          a("LC", localObject4, localObject6);
          if (localLocale == null) {
            break label2667;
          }
          localObject4 = localLocale.getLanguage();
          a("LG", localObject4, localObject6);
          a("Context", paramString1, localObject6);
          a("Carrier", str1, localObject6);
          a("Manufacturer", Build.MANUFACTURER, localObject6);
          a("Model", Build.MODEL, localObject6);
          a("OS", Build.VERSION.RELEASE, localObject6);
          a("Socket Conn", localObject2, localObject6);
          a("Radio MCC-MNC", str3, localObject6);
          a("SIM MCC-MNC", str2, localObject6);
          a("Free Space Built-In", str4, localObject6);
          a("Free Space Removable", localObject1, localObject6);
          if (((Integer)localObject3).intValue() != -1)
          {
            a("FAQ Results Returned", localObject3, localObject6);
            if (((Integer)localObject3).intValue() != 0) {
              break label1994;
            }
            a("FAQ Results Read", "n/a", localObject6);
          }
        }
        for (;;)
        {
          if (!auj.j()) {
            break label2034;
          }
          a("Web session", "active", localObject6);
          a("Smb count", Integer.toString(i2), localObject6);
          a("Ent count", Integer.toString(i1), localObject6);
          if (!paramBoolean2) {
            break label2054;
          }
          a("CCode", str5, localObject6);
          a("Target", str7, localObject6);
          a("Distribution", str8, localObject6);
          a("Product", Build.PRODUCT, localObject6);
          a("Device", Build.DEVICE, localObject6);
          a("Build", Build.DISPLAY, localObject6);
          a("Board", Build.BOARD, localObject6);
          a("Kernel", c(), localObject6);
          paramString4 = this.j.e;
          localObject1 = new StringBuilder();
          if (paramString4 != null) {
            break label2091;
          }
          Log.w("emailsender/formatted-connection-info cm=null");
          paramString1 = null;
          if (paramString1 == null) {
            break label2100;
          }
          a((StringBuilder)localObject1, paramString1.getTypeName());
          paramString1 = paramString1.getSubtypeName();
          if (!TextUtils.isEmpty(paramString1))
          {
            ((StringBuilder)localObject1).append(" (");
            a((StringBuilder)localObject1, paramString1);
            ((StringBuilder)localObject1).append(')');
          }
          a("Connection", ((StringBuilder)localObject1).toString(), localObject6);
          if (paramString2 != null) {
            a("Server", paramString2, localObject6);
          }
          a("Device ISO8601", localSimpleDateFormat.format(new Date()), localObject6);
          a("Phone Type", b((String)localObject8), localObject6);
          a("Network Type", b((String)localObject7), localObject6);
          if (Build.VERSION.SDK_INT >= 23) {
            a("Missing Permissions", a(paramContext), localObject6);
          }
          a("Architecture", System.getProperty("os.arch"), localObject6);
          paramContext = d();
          if (!TextUtils.isEmpty(paramContext)) {
            a("Diagnostic Codes", paramContext, localObject6);
          }
          paramString2 = this.j.c;
          if (this.d.b == null)
          {
            localObject1 = bc.a(this.j, this.n);
            if (paramString2 == null) {
              break label2675;
            }
            paramContext = Integer.valueOf(paramString2.getSimState());
            localObject2 = new StringBuilder().append((String)localObject1).append(" ");
            paramString1 = paramContext;
            if (paramContext == null) {
              paramString1 = "";
            }
            a("Sim", paramString1, localObject6);
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).replaceAll("\\D", "");
              a("L Distance", Integer.valueOf(a(str6, (String)localObject1)), localObject6);
              paramString1 = Boolean.valueOf(true);
              i1 = RegisterPhone.a(str6, (String)localObject1);
              if ((i1 == 0) || (i1 == 1))
              {
                if (RegisterPhone.b(str6, str5, (String)localObject1) != null) {
                  break label2680;
                }
                paramContext = "false";
                a("Mistyped", paramContext, localObject6);
                paramContext = paramString1;
                if (i1 != 0) {
                  break label2625;
                }
                localObject2 = a.a.a.a.d.a(str5, (String)localObject1);
                paramContext = a.a.a.a.d.a(str5, str6);
                localObject3 = str5 + paramContext;
                if ((!((String)localObject2).equals(paramContext)) && (!((String)localObject2).equals(localObject3)) && (!a.a.a.a.d.a((String)localObject1, str6, (String)localObject2, str5))) {
                  break label2112;
                }
                paramContext = Boolean.valueOf(false);
                break label2625;
                a("Mistyped Last6", paramContext, localObject6);
              }
            }
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramContext = new StringBuilder();
            paramString1 = new StringBuilder();
            if (paramString4 != null) {
              break label2150;
            }
            Log.w("emailsender/get-debug-info cm=null");
            a("Network metered", paramContext.toString(), localObject6);
            a("Network restricted", paramString1.toString(), localObject6);
          }
          a("Data roaming", String.valueOf(((f)b.a.a.c.a().a(f.class)).b), localObject6);
          if (paramString2 != null) {
            break label2314;
          }
          paramContext = "unknown";
          a("Tel roaming", paramContext, localObject6);
          paramContext = pb.a;
          if (paramContext != null)
          {
            if (paramContext.callSide != null) {
              a("voip call side", paramContext.callSide, localObject6);
            }
            if (paramContext.callResult != null) {
              a("voip call result", paramContext.callResult, localObject6);
            }
            if (paramContext.callSetupErrorType != null) {
              a("voip call setup error", paramContext.callSetupErrorType, localObject6);
            }
            if (paramContext.callTermReason != null) {
              a("voip call terminate reason", paramContext.callTermReason, localObject6);
            }
            if ((paramContext.callRelayBindStatus == null) || (paramContext.callRelayBindStatus.intValue() != 2)) {
              break label2714;
            }
            i1 = 1;
            break label2636;
            a("voip bind to any relay", paramContext, localObject6);
          }
          if (paramString3 != null) {
            a("ref", paramString3, localObject6);
          }
          switch (2.a[(aqe.a() - 1)])
          {
          case 1: 
            if (paramBoolean1) {
              localStringBuilder.append(localJSONObject.toString(1));
            }
            return localStringBuilder.toString();
            localObject6 = localStringBuilder;
            break label666;
            localObject5 = "unregistered";
            break label705;
            a("FAQ Results Read", paramString4, localObject6);
          }
        }
      }
      break;
    }
  }
  
  public final boolean a(Intent paramIntent, Context paramContext, ng paramng, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((ResolveInfo)((Iterator)localObject1).next()).activityInfo;
        Object localObject3 = ((ActivityInfo)localObject2).name;
        Object localObject4 = ((ActivityInfo)localObject2).applicationInfo.packageName;
        Log.i("email-sender/app " + (String)localObject4 + " | " + (String)localObject3);
        if ((((String)localObject4).contains("gm")) || (((String)localObject4).contains("email")) || (((String)localObject4).contains("fsck.k9")) || (((String)localObject4).contains("maildroid")) || (((String)localObject4).contains("hotmail")) || (((String)localObject4).contains("android.mail")) || (((String)localObject4).contains("com.baydin.boomerang")) || (((String)localObject4).contains("yandex.mail")) || (((String)localObject4).contains("com.google.android.apps.inbox")) || (((String)localObject4).contains("com.microsoft.office.outlook")) || (((String)localObject4).contains("com.asus.email")) || (((String)localObject4).equals("org.kman.AquaMail")))
        {
          localObject2 = (Intent)paramIntent.clone();
          ((Intent)localObject2).setClassName((String)localObject4, (String)localObject3);
          ((Intent)localObject2).setPackage((String)localObject4);
          int i2 = 0;
          int i1 = i2;
          if (Build.VERSION.SDK_INT < 23)
          {
            i1 = i2;
            if (Build.VERSION.SDK_INT > 10) {
              if (!((String)localObject4).equals("com.google.android.gm"))
              {
                i1 = i2;
                if (!((String)localObject4).equals("com.google.android.apps.inbox")) {}
              }
              else
              {
                i1 = 1;
              }
            }
          }
          if (i1 != 0)
          {
            localObject4 = ((Intent)localObject2).getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (localObject4 != null)
            {
              localObject3 = new ArrayList(((ArrayList)localObject4).size());
              localObject4 = ((ArrayList)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Uri localUri = (Uri)((Iterator)localObject4).next();
                Object localObject5 = localUri.getPath();
                String str = com.whatsapp.emoji.c.a((CharSequence)localObject5, true);
                if (("file".equals(localUri.getScheme())) && (!str.equals(localObject5))) {
                  try
                  {
                    localObject5 = this.e.a(com.whatsapp.emoji.c.a(localUri.getLastPathSegment(), true));
                    MediaFileUtils.a(new File(localUri.getPath()), (File)localObject5);
                    ((ArrayList)localObject3).add(a.a.a.a.d.a(paramContext, (File)localObject5));
                  }
                  catch (IOException localIOException)
                  {
                    ((ArrayList)localObject3).add(localUri);
                    Log.e(localIOException);
                  }
                } else {
                  ((ArrayList)localObject3).add(localUri);
                }
              }
              ((Intent)localObject2).putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject3);
            }
          }
          localArrayList.add(localObject2);
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      if (paramng != null) {
        paramng.b_(2131296743);
      }
      for (;;)
      {
        return false;
        pv.a(paramContext, 2131296743, 0);
      }
    }
    if (localArrayList.size() > 1)
    {
      paramIntent = Intent.createChooser((Intent)localArrayList.get(localArrayList.size() - 1), paramString);
      localArrayList.remove(localArrayList.size() - 1);
      paramIntent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[localArrayList.size()]));
      paramContext.startActivity(paramIntent);
    }
    for (;;)
    {
      return true;
      paramContext.startActivity((Intent)localArrayList.get(0));
    }
  }
  
  public final boolean a(nh paramnh, String paramString1, String paramString2, ArrayList<Uri> paramArrayList, String paramString3, String paramString4, File paramFile, long paramLong1, long paramLong2, String paramString5, String paramString6)
  {
    String str = paramnh.getString(2131296711);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append(a(paramnh, paramString1, paramString3, paramString4, false, paramLong1, paramLong2, paramString5));
    paramString3 = new StringBuilder(localStringBuilder.toString());
    int i1;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label323;
      }
      paramString1 = "android.intent.action.SEND_MULTIPLE";
      label91:
      paramString2 = new Intent(paramString1);
      Log.d("email-sender/send-email uploadedLogsId is " + paramString4);
      if (paramFile != null) {
        break label330;
      }
      paramString2.setType("plain/text");
      paramString3.append("No log file to attach.\n");
    }
    for (;;)
    {
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "android@support.whatsapp.com";
      }
      paramString2.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
      paramString2.putExtra("android.intent.extra.SUBJECT", str);
      paramString2.putExtra("android.intent.extra.TEXT", paramString3.toString());
      if (i1 == 0) {
        break label404;
      }
      paramString2.putParcelableArrayListExtra("android.intent.extra.STREAM", paramArrayList);
      if (Build.VERSION.SDK_INT < 16) {
        break label404;
      }
      paramString1 = new ArrayList(paramArrayList);
      paramArrayList = new ClipData.Item((Uri)paramString1.get(0));
      paramArrayList = new ClipData(str, new String[] { "application/zip", "image/*" }, paramArrayList);
      paramString1.remove(0);
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        paramArrayList.addItem(new ClipData.Item((Uri)paramString1.next()));
      }
      i1 = 0;
      break;
      label323:
      paramString1 = "android.intent.action.SEND";
      break label91;
      label330:
      if (i1 != 0) {}
      for (paramString1 = "*/*";; paramString1 = "application/zip")
      {
        paramString2.setType(paramString1);
        paramString2.setFlags(1);
        paramString1 = a.a.a.a.d.a(paramnh, paramFile);
        if (i1 == 0) {
          break label380;
        }
        paramArrayList.add(paramString1);
        break;
      }
      label380:
      paramString2.putExtra("android.intent.extra.STREAM", paramString1);
    }
    paramString2.setClipData(paramArrayList);
    paramString2.setFlags(1);
    label404:
    return a(paramString2, paramnh, paramnh, paramnh.getString(2131296536));
  }
  
  public final String b()
  {
    Object localObject1 = Log.a(1);
    if (((List)localObject1).size() <= 0)
    {
      Log.e("email-sender/upload-logs no logs found to be uploaded.");
      return null;
    }
    File localFile = (File)((List)localObject1).get(0);
    if (localFile.length() > 8388608L)
    {
      localObject1 = a.a.a.a.d.a(this.l, localFile);
      if (localObject1 == null) {
        return null;
      }
    }
    for (;;)
    {
      final StringBuffer localStringBuffer = new StringBuffer();
      final ConditionVariable localConditionVariable = new ConditionVariable();
      Object localObject3 = new d.b()
      {
        public final void a(long paramAnonymousLong)
        {
          Log.d("sent " + paramAnonymousLong);
        }
        
        public final void a(Map<String, List<String>> paramAnonymousMap, String paramAnonymousString)
        {
          Log.d("Response received: " + paramAnonymousString);
          paramAnonymousString = paramAnonymousMap.entrySet().iterator();
          while (paramAnonymousString.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramAnonymousString.next();
            Log.d("Header: " + localEntry);
          }
          paramAnonymousMap = (List)paramAnonymousMap.get("X-Uploaded-File-Id");
          if ((paramAnonymousMap != null) && (!paramAnonymousMap.isEmpty())) {
            localStringBuffer.append((String)paramAnonymousMap.get(0));
          }
          localConditionVariable.open();
        }
      };
      try
      {
        Log.d("Uploading logs from " + localObject1 + " to https://crashlogs.whatsapp.net/wa_clb_data");
        com.whatsapp.i.a.a();
        localObject3 = com.whatsapp.i.a.a("https://crashlogs.whatsapp.net/wa_clb_data", (d.b)localObject3, false);
        ((com.whatsapp.i.d)localObject3).a("access_token", "1063127757113399|745146ffa34413f9dbb5469f5370b7af");
        ((com.whatsapp.i.d)localObject3).a(new FileInputStream((File)localObject1), "file", ((File)localObject1).getName(), 0L);
        ((com.whatsapp.i.d)localObject3).a("type", "support");
        ((com.whatsapp.i.d)localObject3).a("from", this.c.d());
        ((com.whatsapp.i.d)localObject3).a("forced", "true");
        ((com.whatsapp.i.d)localObject3).a(null);
        localConditionVariable.block(100000L);
        Log.d("returning " + localStringBuffer);
        if (localStringBuffer.length() == 0) {
          return null;
        }
      }
      catch (Exception localException)
      {
        Log.e(localException);
        return null;
      }
      if (!localException.getAbsolutePath().equals(localFile.getAbsolutePath())) {
        localException.delete();
      }
      return localStringBuffer.toString();
      Object localObject2 = localFile;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/od.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */