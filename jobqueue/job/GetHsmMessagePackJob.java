package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.text.TextUtils;
import com.whatsapp.b.a;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class GetHsmMessagePackJob
  extends Job
  implements b
{
  private static final HashSet<GetHsmMessagePackJob> activePackJobs = new HashSet();
  private static final long serialVersionUID = 1L;
  private transient m a;
  private transient a b;
  private final String elementName;
  private final Locale[] locales;
  private final String namespace;
  
  public GetHsmMessagePackJob(Locale[] arg1, String paramString1, String paramString2)
  {
    super(JobParameters.a().a(paramString1).a().a(new ChatConnectionRequirement()).b());
    this.locales = ((Locale[])a.d.a(???));
    this.namespace = ((String)a.d.a(paramString1));
    this.elementName = ((String)a.d.a(paramString2));
    synchronized (activePackJobs)
    {
      activePackJobs.add(this);
      return;
    }
  }
  
  public static boolean a(Locale[] paramArrayOfLocale, String paramString1, String paramString2)
  {
    synchronized (activePackJobs)
    {
      Iterator localIterator = activePackJobs.iterator();
      while (localIterator.hasNext())
      {
        GetHsmMessagePackJob localGetHsmMessagePackJob = (GetHsmMessagePackJob)localIterator.next();
        if ((Arrays.equals(localGetHsmMessagePackJob.locales, paramArrayOfLocale)) && (TextUtils.equals(localGetHsmMessagePackJob.namespace, paramString1)) && (TextUtils.equals(localGetHsmMessagePackJob.elementName, paramString2))) {
          return true;
        }
      }
      return false;
    }
  }
  
  private String g()
  {
    return "; namespace=" + this.namespace + "; element=" + this.elementName + "; locales=" + Arrays.toString(this.locales) + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Log.i("get hsm message pack job added" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.a = m.a();
    this.b = a.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running get hsm message pack job" + g(), paramException);
    return true;
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: new 107	java/lang/StringBuilder
    //   3: dup
    //   4: ldc -86
    //   6: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 139	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:g	()Ljava/lang/String;
    //   13: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 144	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 159	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:b	Lcom/whatsapp/b/a;
    //   26: aload_0
    //   27: getfield 64	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:locales	[Ljava/util/Locale;
    //   30: aload_0
    //   31: getfield 71	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:namespace	Ljava/lang/String;
    //   34: invokevirtual 173	com/whatsapp/b/a:a	([Ljava/util/Locale;Ljava/lang/String;)Lcom/whatsapp/proto/a;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +208 -> 249
    //   44: aload 4
    //   46: invokevirtual 178	com/whatsapp/proto/a:f	()I
    //   49: ifle +140 -> 189
    //   52: aload 4
    //   54: aload_0
    //   55: getfield 73	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:elementName	Ljava/lang/String;
    //   58: invokestatic 181	com/whatsapp/b/a:a	(Lcom/whatsapp/proto/a;Ljava/lang/String;)Lcom/whatsapp/proto/a$b;
    //   61: ifnonnull +128 -> 189
    //   64: new 183	java/util/Locale
    //   67: dup
    //   68: aload 4
    //   70: invokevirtual 186	com/whatsapp/proto/a:d	()Ljava/lang/String;
    //   73: aload 4
    //   75: invokevirtual 189	com/whatsapp/proto/a:e	()Ljava/lang/String;
    //   78: invokespecial 192	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: astore 4
    //   83: new 107	java/lang/StringBuilder
    //   86: dup
    //   87: ldc -62
    //   89: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload 4
    //   94: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokespecial 139	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:g	()Ljava/lang/String;
    //   101: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 144	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 159	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:b	Lcom/whatsapp/b/a;
    //   114: aload_0
    //   115: getfield 64	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:locales	[Ljava/util/Locale;
    //   118: aload_0
    //   119: getfield 71	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:namespace	Ljava/lang/String;
    //   122: invokevirtual 200	com/whatsapp/b/a:b	([Ljava/util/Locale;Ljava/lang/String;)[Ljava/lang/String;
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 152	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:a	Lcom/whatsapp/messaging/m;
    //   131: invokevirtual 202	com/whatsapp/messaging/m:f	()Ljava/lang/String;
    //   134: astore 5
    //   136: aload_0
    //   137: getfield 152	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:a	Lcom/whatsapp/messaging/m;
    //   140: aload 5
    //   142: aload 5
    //   144: aload_0
    //   145: getfield 64	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:locales	[Ljava/util/Locale;
    //   148: aload 4
    //   150: aload_0
    //   151: getfield 71	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:namespace	Ljava/lang/String;
    //   154: ldc -52
    //   156: invokestatic 209	a/a/a/a/d:a	(Ljava/lang/String;[Ljava/util/Locale;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Message;
    //   159: iconst_0
    //   160: invokevirtual 212	com/whatsapp/messaging/m:a	(Ljava/lang/String;Landroid/os/Message;Z)Ljava/util/concurrent/Future;
    //   163: invokeinterface 217 1 0
    //   168: pop
    //   169: getstatic 31	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:activePackJobs	Ljava/util/HashSet;
    //   172: astore 4
    //   174: aload 4
    //   176: monitorenter
    //   177: getstatic 31	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:activePackJobs	Ljava/util/HashSet;
    //   180: aload_0
    //   181: invokevirtual 220	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload 4
    //   187: monitorexit
    //   188: return
    //   189: new 107	java/lang/StringBuilder
    //   192: dup
    //   193: ldc -34
    //   195: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: invokespecial 139	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:g	()Ljava/lang/String;
    //   202: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 144	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   211: goto -42 -> 169
    //   214: astore 4
    //   216: aload 4
    //   218: athrow
    //   219: astore 4
    //   221: iconst_1
    //   222: istore_1
    //   223: iload_1
    //   224: ifne +22 -> 246
    //   227: getstatic 31	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:activePackJobs	Ljava/util/HashSet;
    //   230: astore 5
    //   232: aload 5
    //   234: monitorenter
    //   235: getstatic 31	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:activePackJobs	Ljava/util/HashSet;
    //   238: aload_0
    //   239: invokevirtual 220	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   242: pop
    //   243: aload 5
    //   245: monitorexit
    //   246: aload 4
    //   248: athrow
    //   249: aload_0
    //   250: getfield 159	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:b	Lcom/whatsapp/b/a;
    //   253: astore 4
    //   255: aload_0
    //   256: getfield 71	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:namespace	Ljava/lang/String;
    //   259: astore 5
    //   261: aload 4
    //   263: getfield 225	com/whatsapp/b/a:a	Lcom/whatsapp/b/b;
    //   266: getfield 230	com/whatsapp/b/b:a	Lcom/whatsapp/b/b$a;
    //   269: invokevirtual 236	com/whatsapp/b/b$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   272: ldc -18
    //   274: iconst_1
    //   275: anewarray 69	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc -16
    //   282: aastore
    //   283: ldc -14
    //   285: iconst_1
    //   286: anewarray 69	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: aload 5
    //   293: aastore
    //   294: aconst_null
    //   295: aconst_null
    //   296: aconst_null
    //   297: invokevirtual 248	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   300: astore 4
    //   302: aload 4
    //   304: ifnull +126 -> 430
    //   307: aload 4
    //   309: invokeinterface 253 1 0
    //   314: ifeq +111 -> 425
    //   317: aload 4
    //   319: iconst_0
    //   320: invokeinterface 257 2 0
    //   325: lstore_2
    //   326: aload 4
    //   328: invokeinterface 260 1 0
    //   333: goto +99 -> 432
    //   336: aload_0
    //   337: getfield 152	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:a	Lcom/whatsapp/messaging/m;
    //   340: invokevirtual 202	com/whatsapp/messaging/m:f	()Ljava/lang/String;
    //   343: astore 5
    //   345: aload_0
    //   346: getfield 152	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:a	Lcom/whatsapp/messaging/m;
    //   349: astore 6
    //   351: aload_0
    //   352: getfield 64	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:locales	[Ljava/util/Locale;
    //   355: astore 7
    //   357: aload_0
    //   358: getfield 71	com/whatsapp/jobqueue/job/GetHsmMessagePackJob:namespace	Ljava/lang/String;
    //   361: astore 8
    //   363: iload_1
    //   364: ifeq +37 -> 401
    //   367: ldc_w 262
    //   370: astore 4
    //   372: aload 6
    //   374: aload 5
    //   376: aload 5
    //   378: aload 7
    //   380: aconst_null
    //   381: aload 8
    //   383: aload 4
    //   385: invokestatic 209	a/a/a/a/d:a	(Ljava/lang/String;[Ljava/util/Locale;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Message;
    //   388: iconst_0
    //   389: invokevirtual 212	com/whatsapp/messaging/m:a	(Ljava/lang/String;Landroid/os/Message;Z)Ljava/util/concurrent/Future;
    //   392: invokeinterface 217 1 0
    //   397: pop
    //   398: goto -229 -> 169
    //   401: ldc_w 264
    //   404: astore 4
    //   406: goto -34 -> 372
    //   409: astore 5
    //   411: aload 4
    //   413: monitorexit
    //   414: aload 5
    //   416: athrow
    //   417: astore 4
    //   419: aload 5
    //   421: monitorexit
    //   422: aload 4
    //   424: athrow
    //   425: lconst_0
    //   426: lstore_2
    //   427: goto -101 -> 326
    //   430: lconst_0
    //   431: lstore_2
    //   432: lload_2
    //   433: lconst_0
    //   434: lcmp
    //   435: ifle +15 -> 450
    //   438: iconst_1
    //   439: istore_1
    //   440: goto -104 -> 336
    //   443: astore 4
    //   445: iconst_0
    //   446: istore_1
    //   447: goto -224 -> 223
    //   450: iconst_0
    //   451: istore_1
    //   452: goto -116 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	GetHsmMessagePackJob
    //   222	230	1	i	int
    //   325	108	2	l	long
    //   214	3	4	localException	Exception
    //   219	28	4	localObject2	Object
    //   253	159	4	localObject3	Object
    //   417	6	4	localObject4	Object
    //   443	1	4	localObject5	Object
    //   409	11	5	localObject7	Object
    //   349	24	6	localm	m
    //   355	24	7	arrayOfLocale	Locale[]
    //   361	21	8	str	String
    // Exception table:
    //   from	to	target	type
    //   22	39	214	java/lang/Exception
    //   44	169	214	java/lang/Exception
    //   189	211	214	java/lang/Exception
    //   249	302	214	java/lang/Exception
    //   307	326	214	java/lang/Exception
    //   326	333	214	java/lang/Exception
    //   336	363	214	java/lang/Exception
    //   372	398	214	java/lang/Exception
    //   216	219	219	finally
    //   177	188	409	finally
    //   411	414	409	finally
    //   235	246	417	finally
    //   419	422	417	finally
    //   22	39	443	finally
    //   44	169	443	finally
    //   189	211	443	finally
    //   249	302	443	finally
    //   307	326	443	finally
    //   326	333	443	finally
    //   336	363	443	finally
    //   372	398	443	finally
  }
  
  public final void c()
  {
    Log.w("canceled get hsm message pack job" + g());
    synchronized (activePackJobs)
    {
      activePackJobs.remove(this);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/GetHsmMessagePackJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */