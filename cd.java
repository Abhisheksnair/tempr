package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.os.AsyncTask;
import java.util.HashMap;

public final class cd
  extends AsyncTask<String, Void, Integer>
{
  private final boolean a;
  private final Activity b;
  private final ng c;
  private final boolean d;
  private final String e;
  private HashMap<String, Boolean> f;
  private final and g;
  private final aat h;
  private final atu i;
  private final atv j;
  
  public cd(Activity paramActivity, and paramand, aat paramaat, atu paramatu, atv paramatv, ng paramng, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramActivity;
    this.g = paramand;
    this.h = paramaat;
    this.i = paramatu;
    this.j = paramatv;
    this.c = paramng;
    this.a = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramString;
  }
  
  /* Error */
  private Integer a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 61	com/whatsapp/i/b:b	()Ljava/util/HashMap;
    //   4: putfield 63	com/whatsapp/cd:f	Ljava/util/HashMap;
    //   7: aload_0
    //   8: getfield 44	com/whatsapp/cd:a	Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +136 -> 149
    //   16: aload_0
    //   17: getfield 32	com/whatsapp/cd:b	Landroid/app/Activity;
    //   20: invokevirtual 69	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   23: ldc 71
    //   25: invokestatic 77	android/provider/Settings$System:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   28: tableswitch	default:+239->267, 0:+126->154, 1:+132->160, 2:+245->273
    //   56: new 79	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 81
    //   62: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 96	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   75: new 79	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 98
    //   81: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 34	com/whatsapp/cd:g	Lcom/whatsapp/and;
    //   88: aload_0
    //   89: getfield 38	com/whatsapp/cd:i	Lcom/whatsapp/atu;
    //   92: getstatic 103	com/whatsapp/contact/sync/p:c	Lcom/whatsapp/contact/sync/p;
    //   95: invokestatic 108	a/a/a/a/d:a	(Lcom/whatsapp/and;Lcom/whatsapp/atu;Lcom/whatsapp/contact/sync/p;)Ljava/lang/Integer;
    //   98: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: ldc 113
    //   103: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 34	com/whatsapp/cd:g	Lcom/whatsapp/and;
    //   110: aload_0
    //   111: getfield 38	com/whatsapp/cd:i	Lcom/whatsapp/atu;
    //   114: getstatic 115	com/whatsapp/contact/sync/p:a	Lcom/whatsapp/contact/sync/p;
    //   117: invokestatic 108	a/a/a/a/d:a	(Lcom/whatsapp/and;Lcom/whatsapp/atu;Lcom/whatsapp/contact/sync/p;)Ljava/lang/Integer;
    //   120: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: ldc 117
    //   125: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: getfield 40	com/whatsapp/cd:j	Lcom/whatsapp/atv;
    //   132: invokevirtual 122	com/whatsapp/atv:b	()Z
    //   135: invokevirtual 125	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: ldc 127
    //   140: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 96	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   149: iconst_0
    //   150: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: areturn
    //   154: ldc -121
    //   156: astore_2
    //   157: goto -101 -> 56
    //   160: ldc -119
    //   162: astore_2
    //   163: goto -107 -> 56
    //   166: astore_2
    //   167: ldc -117
    //   169: invokestatic 96	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   172: goto -97 -> 75
    //   175: astore_2
    //   176: new 79	java/lang/StringBuilder
    //   179: dup
    //   180: ldc -115
    //   182: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_2
    //   186: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   189: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 145	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 63	com/whatsapp/cd:f	Ljava/util/HashMap;
    //   203: iconst_m1
    //   204: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: areturn
    //   208: astore_2
    //   209: new 79	java/lang/StringBuilder
    //   212: dup
    //   213: ldc -109
    //   215: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_2
    //   219: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 96	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   231: goto -156 -> 75
    //   234: astore_2
    //   235: new 79	java/lang/StringBuilder
    //   238: dup
    //   239: ldc -106
    //   241: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_2
    //   245: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 145	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   257: aload_0
    //   258: aconst_null
    //   259: putfield 63	com/whatsapp/cd:f	Ljava/util/HashMap;
    //   262: iconst_m1
    //   263: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: areturn
    //   267: ldc -104
    //   269: astore_2
    //   270: goto -214 -> 56
    //   273: ldc -102
    //   275: astore_2
    //   276: goto -220 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	cd
    //   11	2	1	bool	boolean
    //   65	98	2	str1	String
    //   166	1	2	localSettingNotFoundException	android.provider.Settings.SettingNotFoundException
    //   175	11	2	localIOException	java.io.IOException
    //   208	11	2	localException1	Exception
    //   234	11	2	localException2	Exception
    //   269	7	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   16	56	166	android/provider/Settings$SettingNotFoundException
    //   56	75	166	android/provider/Settings$SettingNotFoundException
    //   0	12	175	java/io/IOException
    //   16	56	175	java/io/IOException
    //   56	75	175	java/io/IOException
    //   75	149	175	java/io/IOException
    //   167	172	175	java/io/IOException
    //   209	231	175	java/io/IOException
    //   16	56	208	java/lang/Exception
    //   56	75	208	java/lang/Exception
    //   0	12	234	java/lang/Exception
    //   75	149	234	java/lang/Exception
    //   167	172	234	java/lang/Exception
    //   209	231	234	java/lang/Exception
  }
  
  protected final void onPreExecute()
  {
    d.a(this.b, 122);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */