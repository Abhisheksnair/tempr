package com.whatsapp.notification.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class b
  extends f
{
  private static Pattern b;
  private float a = -1.0F;
  
  /* Error */
  private static Set<Integer> b()
  {
    // Byte code:
    //   0: invokestatic 24	com/whatsapp/u:a	()Landroid/content/Context;
    //   3: invokevirtual 30	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: new 32	java/util/HashSet
    //   10: dup
    //   11: invokespecial 33	java/util/HashSet:<init>	()V
    //   14: astore_3
    //   15: ldc 35
    //   17: invokestatic 41	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 4
    //   22: new 43	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 45
    //   28: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: invokestatic 24	com/whatsapp/u:a	()Landroid/content/Context;
    //   34: invokevirtual 52	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 45
    //   42: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload_2
    //   51: aload 4
    //   53: iconst_2
    //   54: anewarray 61	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: ldc 63
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: ldc 65
    //   66: aastore
    //   67: ldc 67
    //   69: iconst_1
    //   70: anewarray 61	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: aload 5
    //   77: aastore
    //   78: aconst_null
    //   79: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_2
    //   83: aload_2
    //   84: ldc 63
    //   86: invokeinterface 79 2 0
    //   91: istore_0
    //   92: aload_2
    //   93: ldc 65
    //   95: invokeinterface 79 2 0
    //   100: istore_1
    //   101: aload_2
    //   102: invokeinterface 83 1 0
    //   107: pop
    //   108: aload_2
    //   109: invokeinterface 86 1 0
    //   114: ifne +106 -> 220
    //   117: aload_2
    //   118: iload_1
    //   119: invokeinterface 90 2 0
    //   124: astore 4
    //   126: aload 4
    //   128: iconst_0
    //   129: invokestatic 96	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   132: astore 4
    //   134: aload 4
    //   136: invokevirtual 100	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   139: astore 4
    //   141: aload 4
    //   143: ifnull +48 -> 191
    //   146: invokestatic 24	com/whatsapp/u:a	()Landroid/content/Context;
    //   149: invokevirtual 52	android/content/Context:getPackageName	()Ljava/lang/String;
    //   152: aload 4
    //   154: invokevirtual 103	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   157: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +31 -> 191
    //   163: ldc 109
    //   165: aload 4
    //   167: invokevirtual 112	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   170: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +18 -> 191
    //   176: aload_3
    //   177: aload_2
    //   178: iload_0
    //   179: invokeinterface 116 2 0
    //   184: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: invokevirtual 125	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: aload_2
    //   192: invokeinterface 128 1 0
    //   197: pop
    //   198: goto -90 -> 108
    //   201: astore 4
    //   203: aload_2
    //   204: astore_3
    //   205: aload 4
    //   207: astore_2
    //   208: aload_3
    //   209: ifnull +9 -> 218
    //   212: aload_3
    //   213: invokeinterface 131 1 0
    //   218: aload_2
    //   219: athrow
    //   220: aload_2
    //   221: ifnull +9 -> 230
    //   224: aload_2
    //   225: invokeinterface 131 1 0
    //   230: aload_3
    //   231: areturn
    //   232: astore 4
    //   234: goto -43 -> 191
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -32 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   91	88	0	i	int
    //   100	19	1	j	int
    //   6	219	2	localObject1	Object
    //   237	1	2	localObject2	Object
    //   14	226	3	localObject3	Object
    //   20	146	4	localObject4	Object
    //   201	5	4	localObject5	Object
    //   232	1	4	localURISyntaxException	java.net.URISyntaxException
    //   48	28	5	str	String
    // Exception table:
    //   from	to	target	type
    //   83	108	201	finally
    //   108	126	201	finally
    //   126	134	201	finally
    //   134	141	201	finally
    //   146	191	201	finally
    //   191	198	201	finally
    //   126	134	232	java/net/URISyntaxException
    //   15	83	237	finally
  }
  
  private final float c()
  {
    if (this.a >= 0.0F) {
      return this.a;
    }
    this.a = 0.0F;
    FeatureInfo[] arrayOfFeatureInfo = u.a().getPackageManager().getSystemAvailableFeatures();
    int j = arrayOfFeatureInfo.length;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < j) {
        localObject = arrayOfFeatureInfo[i];
      }
      try
      {
        localObject = ((FeatureInfo)localObject).name;
        float f;
        if ((localObject != null) && (((String)localObject).startsWith("com.htc.software.Sense")))
        {
          if (b == null) {
            b = Pattern.compile("com\\.htc\\.software\\.Sense(\\d+(?:\\.\\d+)?).*");
          }
          localObject = b.matcher((CharSequence)localObject);
          if (!((Matcher)localObject).matches()) {
            throw new NumberFormatException("could not find version");
          }
          f = Float.parseFloat(((Matcher)localObject).group(1));
        }
        for (localObject = Float.valueOf(f); localObject != null; localObject = null)
        {
          this.a = ((Float)localObject).floatValue();
          Log.i("badger/htc/sense " + this.a);
          return this.a;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i += 1;
      }
    }
  }
  
  public final List<String> a()
  {
    if (c() >= 4.0F) {
      return Arrays.asList(new String[] { "com.htc.launcher" });
    }
    return new ArrayList();
  }
  
  public final void a(int paramInt)
  {
    float f = c();
    Intent localIntent1;
    if (f >= 5.0F)
    {
      localIntent1 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
      if (Build.VERSION.SDK_INT >= 12) {
        localIntent1.setFlags(16);
      }
      localIntent1.putExtra("com.htc.launcher.extra.COMPONENT", new ComponentName(u.a().getPackageName(), "com.whatsapp.Main").flattenToShortString());
      localIntent1.putExtra("com.htc.launcher.extra.COUNT", paramInt);
      u.a().sendBroadcast(localIntent1);
    }
    for (;;)
    {
      return;
      if (f >= 4.0F)
      {
        localIntent1 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        if (Build.VERSION.SDK_INT >= 12) {
          localIntent1.setFlags(16);
        }
        localIntent1.putExtra("packagename", u.a().getPackageName());
        localIntent1.putExtra("count", paramInt);
        u.a().sendBroadcast(localIntent1);
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Integer)localIterator.next();
          Intent localIntent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
          if (Build.VERSION.SDK_INT >= 12) {
            localIntent1.setFlags(16);
          }
          localIntent2.putExtra("packagename", u.a().getPackageName());
          localIntent2.putExtra("favorite_item_id", ((Integer)localObject).longValue());
          localObject = new ComponentName(u.a().getPackageName(), "com.whatsapp.Main");
          localIntent2.putExtra("selectArgs", new String[] { "%" + ((ComponentName)localObject).flattenToShortString() + "%" });
          localIntent2.putExtra("count", paramInt);
          u.a().sendBroadcast(localIntent2);
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */