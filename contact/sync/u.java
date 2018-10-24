package com.whatsapp.contact.sync;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

public final class u
{
  private t a = null;
  private Set<t> b = new HashSet();
  private Map<t, Runnable> c = new HashMap();
  
  private void c()
  {
    SharedPreferences.Editor localEditor = com.whatsapp.u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit();
    try
    {
      if ((this.a != null) && (this.a.b()))
      {
        localEditor.putString("current_running_sync", this.a.c());
        if (this.b.isEmpty()) {
          break label228;
        }
        localHashSet = new HashSet();
        Iterator localIterator = b().iterator();
        if (!localIterator.hasNext()) {
          break label151;
        }
        localt = (t)localIterator.next();
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        try
        {
          HashSet localHashSet;
          t localt;
          if (localt.a()) {
            localHashSet.add(localt.c());
          }
        }
        catch (JSONException localJSONException2)
        {
          continue;
          localEditor.remove("current_running_sync");
          continue;
          localJSONException1 = localJSONException1;
          localEditor.remove("current_running_sync");
          continue;
          if (!localJSONException1.isEmpty())
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              localEditor.putStringSet("queued_running_sync_set", localJSONException1);
              if (!localEditor.commit()) {
                Log.w("SyncRequestStorage/save-failed");
              }
              return;
            }
            localEditor.putString("queued_running_sync_set", (String)localJSONException1.toArray()[0]);
            continue;
          }
          localEditor.remove("queued_running_sync_set");
          continue;
          localEditor.remove("queued_running_sync_set");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2) {}
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label151:
      label228:
      for (;;) {}
    }
  }
  
  public final Runnable a(t paramt)
  {
    try
    {
      paramt = (Runnable)this.c.get(paramt);
      return paramt;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  /* Error */
  public final java.util.List<t> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 38	com/whatsapp/u:a	()Landroid/content/Context;
    //   5: ldc 40
    //   7: iconst_0
    //   8: invokevirtual 46	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: astore_2
    //   12: new 144	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 145	java/util/ArrayList:<init>	()V
    //   19: astore 4
    //   21: aload_2
    //   22: ldc 59
    //   24: invokeinterface 149 2 0
    //   29: ifeq +29 -> 58
    //   32: aload_2
    //   33: ldc 59
    //   35: aconst_null
    //   36: invokeinterface 153 3 0
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +15 -> 58
    //   46: aload 4
    //   48: aload_3
    //   49: invokestatic 156	com/whatsapp/contact/sync/t:a	(Ljava/lang/String;)Lcom/whatsapp/contact/sync/t;
    //   52: invokeinterface 159 2 0
    //   57: pop
    //   58: aload_2
    //   59: ldc 107
    //   61: invokeinterface 149 2 0
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +76 -> 144
    //   71: getstatic 105	android/os/Build$VERSION:SDK_INT	I
    //   74: bipush 11
    //   76: if_icmplt +87 -> 163
    //   79: aload_2
    //   80: ldc 107
    //   82: aconst_null
    //   83: invokeinterface 163 3 0
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +54 -> 144
    //   93: aload_2
    //   94: invokeinterface 80 1 0
    //   99: astore_2
    //   100: aload_2
    //   101: invokeinterface 85 1 0
    //   106: ifeq +38 -> 144
    //   109: aload_2
    //   110: invokeinterface 89 1 0
    //   115: checkcast 128	java/lang/String
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull -20 -> 100
    //   123: aload 4
    //   125: aload_3
    //   126: invokestatic 156	com/whatsapp/contact/sync/t:a	(Ljava/lang/String;)Lcom/whatsapp/contact/sync/t;
    //   129: invokeinterface 159 2 0
    //   134: pop
    //   135: goto -35 -> 100
    //   138: astore_2
    //   139: ldc -91
    //   141: invokestatic 122	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: monitorexit
    //   146: aload 4
    //   148: areturn
    //   149: astore_3
    //   150: ldc -89
    //   152: invokestatic 122	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   155: goto -97 -> 58
    //   158: astore_2
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: aload_2
    //   164: ldc 107
    //   166: aconst_null
    //   167: invokeinterface 153 3 0
    //   172: astore 5
    //   174: new 20	java/util/HashSet
    //   177: dup
    //   178: invokespecial 21	java/util/HashSet:<init>	()V
    //   181: astore_3
    //   182: aload_3
    //   183: astore_2
    //   184: aload 5
    //   186: ifnull -97 -> 89
    //   189: aload_3
    //   190: aload 5
    //   192: invokeinterface 95 2 0
    //   197: pop
    //   198: aload_3
    //   199: astore_2
    //   200: goto -111 -> 89
    //   203: astore_2
    //   204: goto -65 -> 139
    //   207: astore_2
    //   208: goto -69 -> 139
    //   211: astore_3
    //   212: goto -62 -> 150
    //   215: astore_3
    //   216: goto -66 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	u
    //   66	2	1	bool	boolean
    //   11	99	2	localObject1	Object
    //   138	1	2	localClassCastException1	ClassCastException
    //   158	6	2	localObject2	Object
    //   183	17	2	localObject3	Object
    //   203	1	2	localJSONException1	JSONException
    //   207	1	2	localDecoderException1	org.apache.commons.codec.DecoderException
    //   41	85	3	str1	String
    //   149	1	3	localClassCastException2	ClassCastException
    //   181	18	3	localHashSet	HashSet
    //   211	1	3	localJSONException2	JSONException
    //   215	1	3	localDecoderException2	org.apache.commons.codec.DecoderException
    //   19	128	4	localArrayList	java.util.ArrayList
    //   172	19	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   71	89	138	java/lang/ClassCastException
    //   93	100	138	java/lang/ClassCastException
    //   100	119	138	java/lang/ClassCastException
    //   123	135	138	java/lang/ClassCastException
    //   163	182	138	java/lang/ClassCastException
    //   189	198	138	java/lang/ClassCastException
    //   46	58	149	java/lang/ClassCastException
    //   2	42	158	finally
    //   46	58	158	finally
    //   58	67	158	finally
    //   71	89	158	finally
    //   93	100	158	finally
    //   100	119	158	finally
    //   123	135	158	finally
    //   139	144	158	finally
    //   150	155	158	finally
    //   163	182	158	finally
    //   189	198	158	finally
    //   71	89	203	org/json/JSONException
    //   93	100	203	org/json/JSONException
    //   100	119	203	org/json/JSONException
    //   123	135	203	org/json/JSONException
    //   163	182	203	org/json/JSONException
    //   189	198	203	org/json/JSONException
    //   71	89	207	org/apache/commons/codec/DecoderException
    //   93	100	207	org/apache/commons/codec/DecoderException
    //   100	119	207	org/apache/commons/codec/DecoderException
    //   123	135	207	org/apache/commons/codec/DecoderException
    //   163	182	207	org/apache/commons/codec/DecoderException
    //   189	198	207	org/apache/commons/codec/DecoderException
    //   46	58	211	org/json/JSONException
    //   46	58	215	org/apache/commons/codec/DecoderException
  }
  
  public final void a(t paramt, Runnable paramRunnable)
  {
    try
    {
      this.b.add(paramt);
      this.c.put(paramt, paramRunnable);
      c();
      return;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  public final Set<t> b()
  {
    try
    {
      Set localSet = this.b;
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(t paramt)
  {
    try
    {
      this.a = paramt;
      c();
      return;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  public final Runnable c(t paramt)
  {
    try
    {
      this.b.remove(paramt);
      paramt = (Runnable)this.c.remove(paramt);
      c();
      return paramt;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */