package com.whatsapp.registration;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.aw;
import android.support.v7.app.b.a;
import android.support.v7.app.n.b;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.google.b.a.f;
import com.google.b.a.f.c;
import com.whatsapp.Main;
import com.whatsapp.aat;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.ly;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bc
{
  static String a = "";
  
  static long a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramString != null) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      Log.w(paramString);
    }
    return paramLong;
  }
  
  static Dialog a(nh paramnh, and paramand, aat paramaat, atu paramatu, atv paramatv)
  {
    Log.i("registrationutils/dialog/cant-connect");
    return new b.a(paramnh).b(2131297572).a(2131296428, bd.a(paramnh, paramand, paramaat, paramatu, paramatv)).b(2131296398, be.a(paramnh)).a(bf.a()).a();
  }
  
  static Dialog a(nh paramnh, pv parampv, String paramString1, String paramString2, Runnable paramRunnable)
  {
    if (paramRunnable != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("registrationutils/dialog/ban cancelable=" + bool);
      parampv = al.a(parampv, a(paramString1, paramString2));
      parampv = paramnh.getString(2131297577) + "\n" + parampv + "\n" + paramnh.getString(2131297576);
      return new b.a(paramnh).b(parampv).a(bool).a(2131296398, bg.a(paramnh, paramRunnable)).c(2131297578, bh.a(paramnh, paramRunnable, paramString1, paramString2)).a();
    }
  }
  
  public static SpannableStringBuilder a(String paramString1, String paramString2, Runnable paramRunnable)
  {
    int i = 0;
    Object localObject1 = Html.fromHtml(paramString1);
    paramString1 = new SpannableStringBuilder((CharSequence)localObject1);
    localObject1 = (URLSpan[])((Spanned)localObject1).getSpans(0, ((Spanned)localObject1).length(), URLSpan.class);
    if (localObject1 != null)
    {
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (paramString2.equals(((URLSpan)localObject2).getURL()))
        {
          int k = paramString1.getSpanStart(localObject2);
          int m = paramString1.getSpanEnd(localObject2);
          int n = paramString1.getSpanFlags(localObject2);
          paramString1.removeSpan(localObject2);
          paramString1.setSpan(new ClickableSpan()
          {
            public final void onClick(View paramAnonymousView)
            {
              this.a.run();
            }
            
            public final void updateDrawState(TextPaint paramAnonymousTextPaint)
            {
              super.updateDrawState(paramAnonymousTextPaint);
              paramAnonymousTextPaint.setUnderlineText(false);
            }
          }, k, m, n);
        }
        i += 1;
      }
    }
    return paramString1;
  }
  
  @SuppressLint({"HardwareIds"})
  public static String a(and paramand, atu paramatu)
  {
    if ((paramatu.a("android.permission.READ_PHONE_STATE") != 0) && (paramatu.a("android.permission.READ_SMS") != 0)) {
      Log.i("verifynumber/getphonennumber/permission denied");
    }
    for (;;)
    {
      return null;
      try
      {
        paramand = paramand.c;
        if (paramand != null)
        {
          paramand = paramand.getLine1Number();
          return paramand;
        }
      }
      catch (Exception paramand)
      {
        Log.w("verifynumber/getphonennumber/error " + paramand.toString());
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject = Pattern.compile("^([17]|2[07]|3[0123469]|4[013456789]|5[12345678]|6[0123456]|8[1246]|9[0123458]|\\d{3})\\d*?(\\d{4,6})$").matcher(paramString);
    if (((Matcher)localObject).find())
    {
      paramString = ((Matcher)localObject).group(1);
      localObject = ((Matcher)localObject).group(2);
      paramString = paramString + (String)localObject;
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.e("verifynumber/prettyprint/cc-or-phnum-is-null");
      return null;
    }
    String str = "+" + paramString1 + " " + paramString2;
    f localf = f.a();
    try
    {
      paramString1 = localf.a(localf.a("+" + paramString1 + paramString2, "ZZ"), f.c.b);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.d("verifynumber/formatter-exception", paramString1);
      return str;
    }
    catch (ExceptionInInitializerError paramString1)
    {
      Log.d("verifynumber/formatter-init-exception", paramString1);
    }
    return str;
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "(null)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static void a(Context paramContext)
  {
    a(paramContext, -1);
  }
  
  static void a(Context paramContext, int paramInt)
  {
    Log.i("registrationutils/notify/unverified");
    long l = System.currentTimeMillis();
    Object localObject = paramContext.getString(2131297861);
    String str1 = paramContext.getString(2131297865);
    String str2 = paramContext.getString(2131297863);
    n.b localb = new n.b(paramContext);
    localb.a(2130840424);
    localb.c((CharSequence)localObject);
    localb.a(l);
    localb.c(3);
    localb.c(true);
    localObject = new Intent(paramContext, paramContext.getClass());
    if (paramInt != -1) {
      ((Intent)localObject).putExtra("com.whatsapp.verifynumber.dialog", paramInt);
    }
    ((Intent)localObject).addFlags(536870912);
    Log.d("registrationutils/notify/notifyNotVerified " + localObject);
    localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 268435456);
    localb.a(str1);
    localb.b(str2);
    localb.a((PendingIntent)localObject);
    aw.a(paramContext).a(1, localb.e());
  }
  
  static void a(Context paramContext, bb parambb, boolean paramBoolean)
  {
    Log.i("registrationutils/notify/verified");
    long l = System.currentTimeMillis();
    Object localObject = paramContext.getString(2131297862);
    String str1 = paramContext.getString(2131297866);
    String str2 = paramContext.getString(2131297864);
    n.b localb = new n.b(paramContext);
    localb.a(2130840424);
    localb.c((CharSequence)localObject);
    localb.a(l);
    localb.c(3);
    localb.c(true);
    if (paramBoolean) {}
    for (parambb = new Intent(paramContext, Main.class);; parambb = (bb)localObject)
    {
      parambb = PendingIntent.getActivity(paramContext, 0, parambb, 268435456);
      localb.a(str1);
      localb.b(str2);
      localb.a(parambb);
      aw.a(paramContext).a(1, localb.e());
      return;
      localObject = new Intent(paramContext, RegisterName.class);
      parambb.a(2);
    }
  }
  
  static void a(atv paramatv)
  {
    a(paramatv, a);
  }
  
  static void a(atv paramatv, String paramString)
  {
    a = paramString;
    paramatv.a.edit().putString("registration_failure_reason", paramString).apply();
  }
  
  static void a(c paramc, atv paramatv)
  {
    if ("2".equals(paramatv.H())) {
      paramc.a("mistyped=2 (7d)", false, null, 7);
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str2 = paramString2.replaceAll("\\D", "");
    int i = Integer.parseInt(paramString1);
    paramString2 = null;
    try
    {
      str1 = ly.a(i, str2);
      paramString2 = str1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str1;
        Log.d("verify/number/trim/error", localIOException);
      }
    }
    str1 = str2;
    if (paramString2 != null) {
      str1 = a(paramString1, str2.substring(paramString1.length()));
    }
    return str1;
  }
  
  /* Error */
  public static void b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 508	com/whatsapp/registration/aw:a	()Lcom/whatsapp/registration/aw;
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +104 -> 109
    //   8: ldc_w 510
    //   11: invokestatic 39	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 515	com/whatsapp/proto/c:a	([B)Lcom/whatsapp/proto/c;
    //   18: astore_1
    //   19: new 517	java/io/FileOutputStream
    //   22: dup
    //   23: invokestatic 521	com/whatsapp/registration/aw:g	()Ljava/io/File;
    //   26: invokespecial 524	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_0
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 528	com/whatsapp/proto/c:writeTo	(Ljava/io/OutputStream;)V
    //   37: aload_2
    //   38: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: ifnull +53 -> 102
    //   52: aload_2
    //   53: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: astore_0
    //   59: new 81	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 533
    //   66: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 254	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   79: return
    //   80: astore_0
    //   81: new 81	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 535
    //   88: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 254	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   101: return
    //   102: aload_2
    //   103: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   106: goto -50 -> 56
    //   109: aload_1
    //   110: invokevirtual 538	com/whatsapp/registration/aw:k	()V
    //   113: return
    //   114: astore_0
    //   115: goto -59 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramArrayOfByte	byte[]
    //   3	30	1	localObject1	Object
    //   42	4	1	localThrowable	Throwable
    //   47	63	1	localObject2	Object
    //   29	74	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   32	37	42	java/lang/Throwable
    //   32	37	47	finally
    //   45	47	47	finally
    //   19	30	58	java/lang/Exception
    //   37	41	58	java/lang/Exception
    //   52	56	58	java/lang/Exception
    //   56	58	58	java/lang/Exception
    //   102	106	58	java/lang/Exception
    //   14	19	80	java/lang/Exception
    //   59	79	80	java/lang/Exception
    //   52	56	114	java/lang/Throwable
  }
  
  static final class a
  {
    boolean a;
    private String b;
    private int c = -1;
    private final nh d;
    private final atv e = atv.a();
    
    a(nh paramnh)
    {
      this.d = paramnh;
    }
    
    final void a()
    {
      this.a = false;
      bc.a = this.e.a.getString("registration_failure_reason", "");
      if (this.b != null) {
        this.d.d(this.b);
      }
      if (this.c != -1) {
        d.a(this.d, this.c);
      }
      this.b = null;
      this.c = -1;
    }
    
    final void a(int paramInt)
    {
      if ((!this.a) && (!this.d.isFinishing()))
      {
        this.d.b_(paramInt);
        return;
      }
      this.b = this.d.getString(paramInt);
    }
    
    final void a(String paramString)
    {
      if ((!this.a) && (!this.d.isFinishing()))
      {
        this.d.d(paramString);
        return;
      }
      this.b = paramString;
    }
    
    public final void b()
    {
      this.a = true;
      bc.a(this.e);
    }
    
    final void b(int paramInt)
    {
      if (!this.a)
      {
        d.a(this.d, paramInt);
        return;
      }
      this.c = paramInt;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */