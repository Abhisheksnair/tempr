package com.whatsapp.phoneid;

import android.content.SharedPreferences.Editor;
import com.facebook.phoneid.PhoneId;
import com.facebook.phoneid.PhoneIdStore;
import com.whatsapp.atv;

public class a
  implements PhoneIdStore
{
  public static volatile a a;
  private final atv b;
  
  private a(atv paramatv)
  {
    this.b = paramatv;
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(atv.a());
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public PhoneId getPhoneId()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/whatsapp/phoneid/a:b	Lcom/whatsapp/atv;
    //   6: getfield 33	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   9: ldc 35
    //   11: aconst_null
    //   12: invokeinterface 41 3 0
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 17	com/whatsapp/phoneid/a:b	Lcom/whatsapp/atv;
    //   22: getfield 33	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   25: ldc 43
    //   27: ldc2_w 44
    //   30: invokeinterface 49 4 0
    //   35: lstore_1
    //   36: aload_3
    //   37: ifnull +9 -> 46
    //   40: lload_1
    //   41: lconst_0
    //   42: lcmp
    //   43: ifge +40 -> 83
    //   46: new 51	com/facebook/phoneid/PhoneId
    //   49: dup
    //   50: invokestatic 57	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   53: invokevirtual 61	java/util/UUID:toString	()Ljava/lang/String;
    //   56: invokestatic 66	b/a/a/c:a	()Lb/a/a/c;
    //   59: ldc 68
    //   61: invokevirtual 71	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   64: checkcast 68	com/whatsapp/g/j
    //   67: invokevirtual 74	com/whatsapp/g/j:a	()J
    //   70: invokespecial 77	com/facebook/phoneid/PhoneId:<init>	(Ljava/lang/String;J)V
    //   73: astore_3
    //   74: aload_0
    //   75: aload_3
    //   76: invokevirtual 81	com/whatsapp/phoneid/a:setPhoneId	(Lcom/facebook/phoneid/PhoneId;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: areturn
    //   83: new 51	com/facebook/phoneid/PhoneId
    //   86: dup
    //   87: aload_3
    //   88: lload_1
    //   89: invokespecial 77	com/facebook/phoneid/PhoneId:<init>	(Ljava/lang/String;J)V
    //   92: astore_3
    //   93: goto -14 -> 79
    //   96: astore_3
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   35	54	1	l	long
    //   17	76	3	localObject1	Object
    //   96	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	96	finally
    //   46	79	96	finally
    //   83	93	96	finally
  }
  
  public void setPhoneId(PhoneId paramPhoneId)
  {
    try
    {
      this.b.c().putString("phoneid_id", paramPhoneId.id).putLong("phoneid_timestamp", paramPhoneId.timestamp).apply();
      return;
    }
    finally
    {
      paramPhoneId = finally;
      throw paramPhoneId;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/phoneid/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */