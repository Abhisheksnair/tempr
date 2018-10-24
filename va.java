package com.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.whatsapp.data.cs;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class va
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile va c;
  final Context a;
  public Me b;
  private final atv d;
  private a e;
  
  private va(Context paramContext, atv paramatv)
  {
    this.a = paramContext;
    this.d = paramatv;
  }
  
  public static va a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new va(u.a(), atv.a());
      }
      return c;
    }
    finally {}
  }
  
  final ObjectInputStream a(InputStream paramInputStream)
  {
    new ObjectInputStream(paramInputStream)
    {
      protected final ObjectStreamClass readClassDescriptor()
      {
        ObjectStreamClass localObjectStreamClass2 = super.readClassDescriptor();
        ObjectStreamClass localObjectStreamClass1 = localObjectStreamClass2;
        if (localObjectStreamClass2.getName().equals("com.whatsapp.App$Me")) {
          localObjectStreamClass1 = ObjectStreamClass.lookup(Me.class);
        }
        return localObjectStreamClass1;
      }
    };
  }
  
  /* Error */
  public final boolean a(Me paramMe, String paramString)
  {
    // Byte code:
    //   0: new 57	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 59
    //   6: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16: invokestatic 74	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: new 76	java/io/ObjectOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 28	com/whatsapp/va:a	Landroid/content/Context;
    //   33: aload_2
    //   34: iconst_0
    //   35: invokevirtual 82	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   38: invokespecial 85	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore_3
    //   42: aload_3
    //   43: astore 4
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 89	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   50: aload_3
    //   51: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_3
    //   59: aload_3
    //   60: astore 4
    //   62: new 57	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 96
    //   68: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_2
    //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: aload_1
    //   79: invokestatic 99	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_3
    //   83: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_3
    //   89: aload 5
    //   91: astore_1
    //   92: aload_1
    //   93: astore 4
    //   95: new 57	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 101
    //   101: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_2
    //   105: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_3
    //   112: invokestatic 99	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_1
    //   116: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_1
    //   122: aload 4
    //   124: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -8 -> 122
    //   133: astore 4
    //   135: aload_3
    //   136: astore_1
    //   137: aload 4
    //   139: astore_3
    //   140: goto -48 -> 92
    //   143: astore_1
    //   144: goto -85 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	va
    //   0	147	1	paramMe	Me
    //   0	147	2	paramString	String
    //   41	42	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   88	48	3	localIOException1	java.io.IOException
    //   139	1	3	localIOException2	java.io.IOException
    //   20	103	4	localObject1	Object
    //   133	5	4	localIOException3	java.io.IOException
    //   23	67	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	42	56	java/io/FileNotFoundException
    //   25	42	88	java/io/IOException
    //   25	42	121	finally
    //   95	115	121	finally
    //   45	50	129	finally
    //   62	82	129	finally
    //   45	50	133	java/io/IOException
    //   45	50	143	java/io/FileNotFoundException
  }
  
  public final boolean a(String paramString)
  {
    if (paramString == null) {}
    a locala;
    do
    {
      return false;
      locala = c();
    } while ((locala == null) || (!paramString.equals(locala.t)));
    return true;
  }
  
  public final String b()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.jabber_id;
  }
  
  public final a c()
  {
    if (b() == null) {
      return null;
    }
    if ((this.e == null) || (!this.e.t.equals(b() + "@s.whatsapp.net"))) {
      this.e = new a(this.d.l());
    }
    return this.e;
  }
  
  public final void d()
  {
    Log.i("memanager/deleteoldme");
    new File(this.a.getFilesDir(), "me_old").delete();
  }
  
  /* Error */
  public final Me e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc -93
    //   4: invokestatic 143	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   7: new 145	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 28	com/whatsapp/va:a	Landroid/content/Context;
    //   15: invokevirtual 149	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: ldc -105
    //   20: invokespecial 154	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: invokevirtual 166	java/io/File:exists	()Z
    //   26: ifeq +116 -> 142
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 28	com/whatsapp/va:a	Landroid/content/Context;
    //   34: ldc -105
    //   36: invokevirtual 170	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   39: invokevirtual 172	com/whatsapp/va:a	(Ljava/io/InputStream;)Ljava/io/ObjectInputStream;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 178	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   49: checkcast 121	com/whatsapp/Me
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_1
    //   56: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_2
    //   66: new 57	java/lang/StringBuilder
    //   69: dup
    //   70: ldc -76
    //   72: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_3
    //   76: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 186	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: astore_2
    //   96: new 57	java/lang/StringBuilder
    //   99: dup
    //   100: ldc -68
    //   102: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 190	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: invokestatic 94	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: goto -7 -> 124
    //   134: astore_3
    //   135: goto -41 -> 94
    //   138: astore_3
    //   139: goto -75 -> 64
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -89 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	va
    //   42	74	1	localObjectInputStream	ObjectInputStream
    //   121	8	1	localObject1	Object
    //   130	1	1	localObject2	Object
    //   143	1	1	localObject3	Object
    //   1	124	2	localObject4	Object
    //   52	2	3	localMe	Me
    //   61	15	3	localClassNotFoundException1	ClassNotFoundException
    //   91	15	3	localIOException1	java.io.IOException
    //   134	1	3	localIOException2	java.io.IOException
    //   138	1	3	localClassNotFoundException2	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   7	43	61	java/lang/ClassNotFoundException
    //   7	43	91	java/io/IOException
    //   7	43	121	finally
    //   45	53	130	finally
    //   66	85	130	finally
    //   96	115	130	finally
    //   45	53	134	java/io/IOException
    //   45	53	138	java/lang/ClassNotFoundException
  }
  
  public final class a
    extends cs
  {
    a(String paramString)
    {
      super();
      this$1 = u.a().getSharedPreferences("com.whatsapp_preferences", 0);
      this.m = va.this.getInt("profile_photo_thumb_id", 0);
      this.l = va.this.getInt("profile_photo_full_id", 0);
      this.q = paramString;
    }
    
    protected final InputStream a(boolean paramBoolean)
    {
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      this.l = paramInt1;
      this.m = paramInt2;
      u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("profile_photo_thumb_id", this.m).putInt("profile_photo_full_id", this.l).apply();
    }
    
    public final boolean a()
    {
      return false;
    }
    
    public final File b()
    {
      return new File(u.a().getFilesDir(), "me.jpg");
    }
    
    public final File c()
    {
      return c("me");
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/va.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */