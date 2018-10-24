package com.whatsapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import b.a.a.c;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.d;
import com.whatsapp.data.e;
import com.whatsapp.jobqueue.job.SendE2EMessageJob;
import com.whatsapp.messaging.w;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.Chat.a;
import com.whatsapp.proto.E2E.Message.a;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public final class aau
{
  private static List<String> a;
  private static String b = "nfc_ids";
  
  public static void a(Activity paramActivity, va paramva, d paramd, w paramw, ad paramad, att paramatt, e parame, atu paramatu, atv paramatv)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (paramatu.a("android.permission.NFC") == 0))
    {
      paramatu = NfcAdapter.getDefaultAdapter(paramActivity);
      if (paramatu == null) {}
    }
    try
    {
      paramatu.setNdefPushMessageCallback(aav.a(paramva, paramActivity, paramatv), paramActivity, new Activity[0]);
      if ("android.nfc.action.NDEF_DISCOVERED".equals(paramActivity.getIntent().getAction())) {
        a(paramActivity, paramva, paramd, paramw, paramad, paramatt, parame, paramatv, paramActivity.getIntent());
      }
      return;
    }
    catch (IllegalStateException paramatu)
    {
      for (;;)
      {
        Log.b("newchatnfc/ ", paramatu);
      }
    }
    catch (SecurityException paramatu)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 141	com/whatsapp/aau:a	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 143	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 149	android/content/Context:getFilesDir	()Ljava/io/File;
    //   23: getstatic 18	com/whatsapp/aau:b	Ljava/lang/String;
    //   26: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_3
    //   30: new 154	java/io/BufferedWriter
    //   33: dup
    //   34: new 156	java/io/FileWriter
    //   37: dup
    //   38: aload_3
    //   39: iconst_0
    //   40: invokespecial 159	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   43: invokespecial 162	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: getstatic 141	com/whatsapp/aau:a	Ljava/util/List;
    //   52: invokeinterface 168 1 0
    //   57: astore_2
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: invokeinterface 174 1 0
    //   66: ifeq +66 -> 132
    //   69: aload_1
    //   70: astore_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokeinterface 178 1 0
    //   78: checkcast 44	java/lang/String
    //   81: invokevirtual 181	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: invokevirtual 184	java/io/BufferedWriter:newLine	()V
    //   90: goto -32 -> 58
    //   93: astore_2
    //   94: aload_1
    //   95: astore_0
    //   96: new 186	java/lang/StringBuilder
    //   99: dup
    //   100: ldc -68
    //   102: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokevirtual 193	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aload_2
    //   116: invokestatic 136	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_1
    //   120: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   123: goto -112 -> 11
    //   126: astore_0
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    //   132: aload_1
    //   133: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   136: goto -125 -> 11
    //   139: aload_0
    //   140: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: goto -7 -> 139
    //   149: astore_2
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -58 -> 94
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: goto -19 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   6	138	1	localObject1	Object
    //   145	1	1	localObject2	Object
    //   151	1	1	localObject3	Object
    //   155	1	1	localObject4	Object
    //   57	16	2	localIterator	java.util.Iterator
    //   93	23	2	localIOException1	java.io.IOException
    //   149	1	2	localIOException2	java.io.IOException
    //   29	77	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   49	58	93	java/io/IOException
    //   60	69	93	java/io/IOException
    //   71	84	93	java/io/IOException
    //   86	90	93	java/io/IOException
    //   3	7	126	finally
    //   15	30	126	finally
    //   119	123	126	finally
    //   132	136	126	finally
    //   139	145	126	finally
    //   49	58	145	finally
    //   60	69	145	finally
    //   71	84	145	finally
    //   86	90	145	finally
    //   96	119	145	finally
    //   30	47	149	java/io/IOException
    //   30	47	155	finally
  }
  
  public static void a(Context paramContext, pv parampv, d paramd, w paramw, ad paramad, e parame, String paramString1, String paramString2, String paramString3)
  {
    Log.i("newchatnfc/processchatreply");
    if (TextUtils.isEmpty(paramString1))
    {
      Log.e("newchatnfc/ no jid");
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      Log.e("newchatnfc/ no id");
      return;
    }
    if (!b(paramContext, paramString2))
    {
      Log.e("newchatnfc/ no id:" + paramString2);
      return;
    }
    if (!paramd.a(paramString1))
    {
      paramd = parame.c(paramString1);
      paramContext = paramString3;
      if (paramd != null) {
        if (paramd.d != null) {
          break label144;
        }
      }
    }
    label144:
    for (paramContext = paramString3;; paramContext = null)
    {
      paramad.c(paramString1, paramContext);
      paramw.a(new String[] { paramString1 });
      if (!(parampv.e instanceof HomeActivity)) {
        break;
      }
      ((HomeActivity)parampv.e).startActivity(Conversation.a(paramString1));
      return;
    }
  }
  
  public static void a(Context paramContext, va paramva, d paramd, w paramw, ad paramad, att paramatt, e parame, atv paramatv, Intent paramIntent)
  {
    if (!"android.nfc.action.NDEF_DISCOVERED".equals(paramIntent.getAction())) {}
    do
    {
      return;
      Log.i("newchatnfc/processnfcintent");
      paramIntent = (NdefMessage)paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0];
    } while (!"application/com.whatsapp.chat".equals(new String(paramIntent.getRecords()[0].getType(), Charset.forName("US-ASCII"))));
    Object localObject3 = new String(paramIntent.getRecords()[0].getPayload(), Charset.forName("US-ASCII"));
    String str1 = null;
    String str2 = null;
    paramIntent = str2;
    Object localObject1 = str1;
    try
    {
      localObject3 = new JSONObject((String)localObject3);
      paramIntent = str2;
      localObject1 = str1;
      str1 = ((JSONObject)localObject3).getString("jid");
      paramIntent = str2;
      localObject1 = str1;
      str2 = ((JSONObject)localObject3).getString("id");
      paramIntent = str2;
      localObject1 = str1;
      localObject3 = ((JSONObject)localObject3).getString("name");
      localObject1 = localObject3;
      paramIntent = str2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.d("newchatnfc/processnfcintent", localJSONException);
        str2 = null;
        localObject2 = localObject1;
        localObject1 = str2;
      }
    }
    if ((str1 == null) || (paramIntent == null))
    {
      Log.i("newchatnfc/processnfcintent jid:" + str1 + " id:" + paramIntent);
      return;
    }
    Object localObject2;
    if (!paramd.a((String)localObject2))
    {
      parame = parame.c((String)localObject2);
      paramd = (d)localObject1;
      if (parame != null) {
        if (parame.d != null) {
          break label399;
        }
      }
    }
    label399:
    for (paramd = (d)localObject1;; paramd = null)
    {
      paramad.c((String)localObject2, paramd);
      paramw.a(new String[] { localObject2 });
      paramd = E2E.Message.newBuilder();
      paramw = paramd.getChatBuilder();
      paramw.setDisplayName(paramatv.l());
      paramw.setId(paramIntent);
      long l = ((com.whatsapp.g.j)c.a().a(com.whatsapp.g.j.class)).a();
      paramatt.a(new SendE2EMessageJob(paramd.build(), com.whatsapp.protocol.j.a(paramva, (String)localObject2, false).c, (String)localObject2, null, 0, null, null, null, false, l + 86400000L, 0L, 0, 0, null, false));
      paramContext.startActivity(Conversation.a((String)localObject2));
      return;
    }
  }
  
  private static void a(Context paramContext, String paramString)
  {
    try
    {
      if (a == null) {
        b(paramContext);
      }
      a.add(0, paramString);
      if (a.size() > 16) {
        a.remove(a.size() - 1);
      }
      a(paramContext);
      return;
    }
    finally {}
  }
  
  private static byte[] a(Context paramContext, va paramva, atv paramatv)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("jid", paramva.c().t);
      paramva = com.whatsapp.protocol.j.a(paramva, paramva.c().t, true).c;
      localJSONObject.put("id", paramva);
      localJSONObject.put("name", paramatv.l());
      a(paramContext, paramva);
      return localJSONObject.toString().getBytes(Charset.forName("US-ASCII"));
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        Log.d("newchatnfc/", paramContext);
      }
    }
  }
  
  /* Error */
  private static void b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 406	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 407	java/util/ArrayList:<init>	()V
    //   10: putstatic 141	com/whatsapp/aau:a	Ljava/util/List;
    //   13: new 143	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 149	android/content/Context:getFilesDir	()Ljava/io/File;
    //   21: getstatic 18	com/whatsapp/aau:b	Ljava/lang/String;
    //   24: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 410	java/io/File:exists	()Z
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +78 -> 114
    //   39: new 412	java/io/BufferedReader
    //   42: dup
    //   43: new 414	java/io/FileReader
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 417	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   52: invokespecial 420	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore_2
    //   56: aload_2
    //   57: astore_0
    //   58: aload_2
    //   59: invokevirtual 423	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +54 -> 118
    //   67: aload_2
    //   68: astore_0
    //   69: getstatic 141	com/whatsapp/aau:a	Ljava/util/List;
    //   72: aload_3
    //   73: invokeinterface 425 2 0
    //   78: pop
    //   79: goto -23 -> 56
    //   82: astore_3
    //   83: aload_2
    //   84: astore_0
    //   85: new 186	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 427
    //   92: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload 4
    //   97: invokevirtual 193	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_3
    //   107: invokestatic 136	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_2
    //   111: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   114: ldc 2
    //   116: monitorexit
    //   117: return
    //   118: aload_2
    //   119: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   122: goto -8 -> 114
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: invokestatic 205	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: goto -7 -> 134
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -64 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   34	2	1	bool	boolean
    //   55	64	2	localBufferedReader	java.io.BufferedReader
    //   131	8	2	localObject1	Object
    //   140	1	2	localObject2	Object
    //   146	1	2	localObject3	Object
    //   62	11	3	str	String
    //   82	25	3	localIOException1	java.io.IOException
    //   144	1	3	localIOException2	java.io.IOException
    //   27	69	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   58	63	82	java/io/IOException
    //   69	79	82	java/io/IOException
    //   3	35	125	finally
    //   110	114	125	finally
    //   118	122	125	finally
    //   134	140	125	finally
    //   39	56	131	finally
    //   58	63	140	finally
    //   69	79	140	finally
    //   85	110	140	finally
    //   39	56	144	java/io/IOException
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    try
    {
      if (a == null) {
        b(paramContext);
      }
      boolean bool = a.remove(paramString);
      if (bool) {
        a(paramContext);
      }
      return bool;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */