package com.whatsapp.gdrive;

import android.text.TextUtils;
import android.text.format.Time;
import android.util.Pair;
import com.google.a.b.a;
import com.whatsapp.av;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

final class bb
  implements Comparable
{
  private static final String h = TextUtils.join(",", new String[] { "description", "id", "fileSize", "title", "md5Checksum", "mimeType", "modifiedDate", String.format(Locale.ENGLISH, "%s(%s)", new Object[] { "parents", "id" }) });
  private static final String i = TextUtils.join(",", new String[] { h, String.format(Locale.ENGLISH, "%s(%s,%s)", new Object[] { "properties", "key", "value" }) });
  private static final String l;
  final long a;
  final boolean b;
  final String c;
  final String d;
  final long e;
  final String f;
  final String g;
  private final String[] j;
  private HashMap<String, String> k;
  
  static
  {
    String[] arrayOfString;
    if (av.l())
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "id";
      arrayOfString[1] = "fileSize";
      arrayOfString[2] = "md5Checksum";
    }
    for (;;)
    {
      l = TextUtils.join(",", arrayOfString);
      return;
      arrayOfString = new String[2];
      arrayOfString[0] = "id";
      arrayOfString[1] = "md5Checksum";
    }
  }
  
  private bb(a parama)
  {
    long l1 = -1L;
    long l2 = -1L;
    boolean bool = false;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    Object localObject1 = null;
    HashMap localHashMap = null;
    label34:
    while (parama.e())
    {
      Object localObject2 = parama.f();
      int m = -1;
      switch (((String)localObject2).hashCode())
      {
      }
      for (;;)
      {
        switch (m)
        {
        default: 
          parama.j();
          break label34;
          if (((String)localObject2).equals("id"))
          {
            m = 0;
            continue;
            if (((String)localObject2).equals("title"))
            {
              m = 1;
              continue;
              if (((String)localObject2).equals("description"))
              {
                m = 2;
                continue;
                if (((String)localObject2).equals("md5Checksum"))
                {
                  m = 3;
                  continue;
                  if (((String)localObject2).equals("fileSize"))
                  {
                    m = 4;
                    continue;
                    if (((String)localObject2).equals("mimeType"))
                    {
                      m = 5;
                      continue;
                      if (((String)localObject2).equals("modifiedDate"))
                      {
                        m = 6;
                        continue;
                        if (((String)localObject2).equals("parents"))
                        {
                          m = 7;
                          continue;
                          if (((String)localObject2).equals("properties")) {
                            m = 8;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      str1 = parama.g();
      continue;
      str2 = parama.g();
      continue;
      str3 = parama.g();
      continue;
      str4 = parama.g();
      continue;
      l2 = parama.h();
      continue;
      bool = "application/vnd.google-apps.folder".equals(parama.g());
      continue;
      l1 = c(parama.g());
      continue;
      parama.a();
      localObject1 = new ArrayList();
      while (parama.e())
      {
        parama.c();
        localObject2 = b(parama);
        parama.d();
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
      }
      parama.b();
      localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
      continue;
      parama.a();
      localHashMap = new HashMap();
      while (parama.e())
      {
        parama.c();
        localObject2 = c(parama);
        if (((Pair)localObject2).first != null) {
          localHashMap.put(((Pair)localObject2).first, ((Pair)localObject2).second);
        }
        parama.d();
      }
      parama.b();
    }
    this.c = str1;
    this.d = str2;
    this.g = str3;
    this.f = str4;
    this.a = l2;
    this.b = bool;
    this.e = l1;
    this.j = ((String[])localObject1);
    this.k = localHashMap;
    if (str2 == null) {
      Log.e("gdrive-file/construct/weird-object/title-is-null " + toString());
    }
  }
  
  private bb(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, boolean paramBoolean, long paramLong2, String[] paramArrayOfString, HashMap<String, String> paramHashMap)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.g = paramString3;
    this.f = paramString4;
    this.a = paramLong1;
    this.b = paramBoolean;
    this.e = paramLong2;
    this.j = paramArrayOfString;
    this.k = paramHashMap;
  }
  
  /* Error */
  static a a(a parama, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 36
    //   4: aconst_null
    //   5: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8: putfield 218	com/whatsapp/gdrive/bb$a:d	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_1
    //   13: ldc 34
    //   15: aconst_null
    //   16: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: putfield 219	com/whatsapp/gdrive/bb$a:g	Ljava/lang/String;
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 42
    //   26: aconst_null
    //   27: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: putfield 220	com/whatsapp/gdrive/bb$a:f	Ljava/lang/String;
    //   33: aload_1
    //   34: ldc 38
    //   36: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   39: ifeq +16 -> 55
    //   42: aload_0
    //   43: aload_1
    //   44: ldc 38
    //   46: ldc2_w 91
    //   49: invokevirtual 228	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   52: putfield 230	com/whatsapp/gdrive/bb$a:b	J
    //   55: aload_1
    //   56: ldc 40
    //   58: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   61: ifeq +14 -> 75
    //   64: aload_0
    //   65: aload_1
    //   66: ldc 40
    //   68: aconst_null
    //   69: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 232	com/whatsapp/gdrive/bb$a:e	Ljava/lang/String;
    //   75: aload_1
    //   76: ldc 44
    //   78: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   81: ifeq +19 -> 100
    //   84: aload_0
    //   85: ldc 116
    //   87: aload_1
    //   88: ldc 44
    //   90: aconst_null
    //   91: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: putfield 234	com/whatsapp/gdrive/bb$a:c	Z
    //   100: aload_1
    //   101: ldc 46
    //   103: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +17 -> 123
    //   109: aload_0
    //   110: aload_1
    //   111: ldc 46
    //   113: aconst_null
    //   114: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: invokestatic 119	com/whatsapp/gdrive/bb:c	(Ljava/lang/String;)J
    //   120: putfield 235	com/whatsapp/gdrive/bb$a:a	J
    //   123: aload_1
    //   124: ldc 56
    //   126: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   129: ifeq +69 -> 198
    //   132: aload_1
    //   133: ldc 56
    //   135: invokevirtual 239	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   138: astore 5
    //   140: aload 5
    //   142: invokevirtual 244	org/json/JSONArray:length	()I
    //   145: anewarray 32	java/lang/String
    //   148: astore 4
    //   150: iconst_0
    //   151: istore_2
    //   152: aload 4
    //   154: arraylength
    //   155: istore_3
    //   156: iload_2
    //   157: iload_3
    //   158: if_icmpge +34 -> 192
    //   161: aload 4
    //   163: iload_2
    //   164: aload 5
    //   166: iload_2
    //   167: invokevirtual 248	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   170: ldc 36
    //   172: invokevirtual 252	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: aastore
    //   176: iload_2
    //   177: iconst_1
    //   178: iadd
    //   179: istore_2
    //   180: goto -28 -> 152
    //   183: astore 5
    //   185: ldc -2
    //   187: aload 5
    //   189: invokestatic 257	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_0
    //   193: aload 4
    //   195: putfield 259	com/whatsapp/gdrive/bb$a:h	[Ljava/lang/String;
    //   198: aload_1
    //   199: ldc 72
    //   201: invokevirtual 224	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   204: ifeq +81 -> 285
    //   207: aload_1
    //   208: ldc 72
    //   210: invokevirtual 239	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   213: astore_1
    //   214: new 148	java/util/HashMap
    //   217: dup
    //   218: invokespecial 149	java/util/HashMap:<init>	()V
    //   221: astore 4
    //   223: iconst_0
    //   224: istore_2
    //   225: iload_2
    //   226: aload_1
    //   227: invokevirtual 244	org/json/JSONArray:length	()I
    //   230: if_icmpge +49 -> 279
    //   233: aload_1
    //   234: iload_2
    //   235: invokevirtual 248	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   238: astore 5
    //   240: aload 4
    //   242: aload 5
    //   244: ldc 74
    //   246: invokevirtual 252	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: aload 5
    //   251: ldc 76
    //   253: invokevirtual 252	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokevirtual 165	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: iload_2
    //   261: iconst_1
    //   262: iadd
    //   263: istore_2
    //   264: goto -39 -> 225
    //   267: astore 4
    //   269: ldc -2
    //   271: aload 4
    //   273: invokestatic 257	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: goto -78 -> 198
    //   279: aload_0
    //   280: aload 4
    //   282: putfield 261	com/whatsapp/gdrive/bb$a:i	Ljava/util/HashMap;
    //   285: aload_0
    //   286: areturn
    //   287: astore_1
    //   288: ldc -2
    //   290: aload_1
    //   291: invokestatic 257	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_0
    //   295: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	parama	a
    //   0	296	1	paramJSONObject	JSONObject
    //   151	113	2	m	int
    //   155	4	3	n	int
    //   148	93	4	localObject	Object
    //   267	14	4	localJSONException1	org.json.JSONException
    //   138	27	5	localJSONArray	org.json.JSONArray
    //   183	5	5	localJSONException2	org.json.JSONException
    //   238	12	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   161	176	183	org/json/JSONException
    //   132	150	267	org/json/JSONException
    //   152	156	267	org/json/JSONException
    //   185	192	267	org/json/JSONException
    //   192	198	267	org/json/JSONException
    //   207	223	287	org/json/JSONException
    //   225	260	287	org/json/JSONException
    //   279	285	287	org/json/JSONException
  }
  
  static bb a(a parama)
  {
    return new bb(parama);
  }
  
  static bb a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    return new bb(paramString1, paramString2, null, paramString3, paramLong, false, -1L, null, null);
  }
  
  static bb a(JSONObject paramJSONObject)
  {
    return a(new a(), paramJSONObject).a();
  }
  
  static String a()
  {
    return l;
  }
  
  static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return i;
    }
    return h;
  }
  
  private static String b(a parama)
  {
    String str1 = null;
    label2:
    while (parama.e())
    {
      String str2 = parama.f();
      int m = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (m)
        {
        default: 
          parama.j();
          break label2;
          if (str2.equals("id")) {
            m = 0;
          }
          break;
        }
      }
      str1 = parama.g();
    }
    return str1;
  }
  
  private static long c(String paramString)
  {
    Time localTime = new Time();
    localTime.parse3339(paramString);
    return localTime.toMillis(true);
  }
  
  private static Pair<String, String> c(a parama)
  {
    String str2 = null;
    String str1 = null;
    while (parama.e())
    {
      String str3 = parama.f();
      int m = -1;
      switch (str3.hashCode())
      {
      }
      for (;;)
      {
        switch (m)
        {
        default: 
          break;
        case 0: 
          str1 = parama.g();
          break;
          if (str3.equals("key"))
          {
            m = 0;
            continue;
            if (str3.equals("value")) {
              m = 1;
            }
          }
          break;
        }
      }
      str2 = parama.g();
    }
    return Pair.create(str1, str2);
  }
  
  final void a(String paramString1, String paramString2)
  {
    if (this.k == null)
    {
      Log.i("gdrive-file/set-property/not-initialized/initializing-now");
      this.k = new HashMap();
    }
    this.k.put(paramString1, paramString2);
  }
  
  final boolean a(String paramString)
  {
    boolean bool2 = false;
    if (this.j == null) {
      throw new IllegalStateException("parents were not provided at the time of creation.");
    }
    String[] arrayOfString = this.j;
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfString[m].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  final String b(String paramString)
  {
    if (this.k == null)
    {
      Log.e("gdrive-file/get-property/not-initialized/" + paramString);
      return null;
    }
    return (String)this.k.get(paramString);
  }
  
  public final int compareTo(Object paramObject)
  {
    if (!(paramObject instanceof bb)) {
      throw new ClassCastException("GoogleDriveFile can only be compared to another GoogleDriveFile: " + paramObject + " is not GoogleDriveFile object.");
    }
    return this.d.compareTo(((bb)paramObject).d);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof bb));
      paramObject = (bb)paramObject;
    } while ((!TextUtils.equals(this.c, ((bb)paramObject).c)) || (!TextUtils.equals(this.d, ((bb)paramObject).d)) || (!TextUtils.equals(this.f, ((bb)paramObject).f)));
    return true;
  }
  
  public final int hashCode()
  {
    if (this.f == null) {}
    for (int m = 0;; m = this.f.hashCode()) {
      return m ^ this.c.hashCode() ^ this.d.hashCode();
    }
  }
  
  public final String toString()
  {
    Object localObject1;
    Object localObject3;
    String str1;
    String str2;
    String str3;
    long l1;
    if (this.j == null)
    {
      localObject1 = "Unknown";
      localObject3 = Locale.ENGLISH;
      str1 = this.c;
      str2 = this.d;
      str3 = this.f;
      l1 = this.a;
      if (!this.b) {
        break label229;
      }
    }
    label229:
    for (Object localObject2 = "folder";; localObject2 = "file")
    {
      localObject2 = String.format((Locale)localObject3, "resId: %s title:%s md5:%s size:%d type:%s parents:%s", new Object[] { str1, str2, str3, Long.valueOf(l1), localObject2, localObject1 });
      localObject1 = localObject2;
      if (this.k == null) {
        break label237;
      }
      localObject2 = (String)localObject2 + " properties:";
      localObject3 = this.k.keySet().iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject3).next();
        localObject2 = (String)localObject2 + String.format(" (%s, %s)", new Object[] { localObject1, this.k.get(localObject1) });
      }
      localObject1 = TextUtils.join(",", this.j);
      break;
    }
    label237:
    localObject2 = localObject1;
    if (this.g != null) {
      localObject2 = (String)localObject1 + " description:" + this.g;
    }
    return (String)localObject2;
  }
  
  static final class a
  {
    long a = -1L;
    long b = -1L;
    boolean c;
    String d;
    String e;
    String f;
    String g;
    String[] h;
    HashMap<String, String> i;
    
    public final bb a()
    {
      if (this.d == null) {
        throw new IllegalStateException("resId of google drive file must not be null");
      }
      if (this.e == null) {
        throw new IllegalStateException("title of google drive file must not be null");
      }
      if ((this.f == null) && (!this.c)) {
        throw new IllegalStateException("md5Checksum of google drive file must not be null");
      }
      return new bb(this.d, this.e, this.g, this.f, this.b, this.c, this.a, this.h, this.i, (byte)0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */