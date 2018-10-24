package com.whatsapp.registration;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.b.a;
import android.telephony.TelephonyManager;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.a.c;
import com.whatsapp.and;
import com.whatsapp.i.b;
import com.whatsapp.i.b.b;
import com.whatsapp.i.b.c;
import com.whatsapp.i.b.d;
import com.whatsapp.ly;
import com.whatsapp.nh;
import com.whatsapp.util.Log;
import java.io.IOException;

public class u
  extends nh
{
  protected static String o = null;
  protected static String p = null;
  protected static int q = 7;
  protected static long r;
  protected final bb A = bb.a();
  private final bc.a n = new bc.a(this);
  protected c s;
  protected boolean t = false;
  protected boolean u = true;
  protected String v;
  protected ProgressDialog w;
  protected final b x = b.a();
  protected final aw y = aw.a();
  protected final c z = c.a();
  
  public static int c(String paramString1, String paramString2)
  {
    try
    {
      if ((paramString1.length() <= 0) || (paramString1.length() > 3))
      {
        Log.w("enterphone/cc/bad-length cc=" + paramString1);
        return 2;
      }
      if (ly.a(paramString1) == null)
      {
        Log.w("enterphone/cc/bad-name " + paramString1);
        return 3;
      }
    }
    catch (IOException paramString1)
    {
      Log.e("enterphone/error trimLeadingZero or lookupCountryName from CountryPhoneInfo IOException" + paramString1);
      return 7;
    }
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.replaceAll("\\D", "").length() == 0))
    {
      Log.w("enterphone/num/error/empty cc=" + paramString1);
      return 4;
    }
    int i = Integer.parseInt(paramString1);
    paramString2 = ly.a(i, paramString2.replaceAll("\\D", ""));
    int j = ly.a(i, paramString2.length());
    if (j != 0)
    {
      Log.w("enterphone/num/error/invalid cc=" + i + " phone=" + paramString2 + " res=" + j);
      if (j < 0) {
        return 5;
      }
    }
    else
    {
      if ((paramString1.length() + paramString2.length() > 15) || (paramString1.length() + paramString2.length() < 8))
      {
        Log.w("enterphone/num/error/length cc=" + paramString1 + " ph=" + paramString2);
        return 7;
      }
      return 1;
    }
    return 6;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3) {}
  
  protected void o() {}
  
  @SuppressLint({"HardwareIds"})
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject1 = null;
    Object localObject3;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 9: 
      localObject1 = new ProgressDialog(this);
      ((ProgressDialog)localObject1).setMessage(getString(2131297530));
      ((ProgressDialog)localObject1).setIndeterminate(true);
      ((ProgressDialog)localObject1).setCancelable(false);
      this.w = ((ProgressDialog)localObject1);
      return (Dialog)localObject1;
    case 22: 
      Log.w("enterphone/dialog/unrecoverable-error");
      localObject2 = getString(2131297575);
      localObject3 = this.aE.c;
      if (localObject3 != null) {
        localObject1 = ((TelephonyManager)localObject3).getSubscriberId();
      }
      if (("15555218135".equals(bc.a(this.aE, this.aP))) && ("310995000000000".equals(localObject1)))
      {
        localObject1 = (String)localObject2 + "\n\n" + getString(2131296764);
        Log.i("enterphone/unrecoverable/possible-tablet");
      }
      break;
    }
    for (Object localObject2 = "register-phone3";; localObject2 = localObject3)
    {
      localObject2 = (String)localObject2 + " +" + o + p;
      return new b.a(this).b((CharSequence)localObject1).a(2131297531, v.a(this, (String)localObject2)).b(2131296398, w.a(this)).a();
      return bc.a(this, this.aq, o, p, null);
      return d.b(this);
      return bc.a(this, this.aE, this.aM, this.aP, this.aQ);
      localObject3 = "register-phone2";
      localObject1 = localObject2;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.n.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.n.a();
  }
  
  protected final void p()
  {
    d.b(this, 9);
    this.w = null;
  }
  
  public final class a
    extends AsyncTask<byte[], Void, Integer>
  {
    private byte[] b;
    private byte[] c;
    private String d;
    private boolean e;
    private String f;
    private int g;
    private int h;
    private String i;
    private String j;
    private String k;
    private String l;
    private long m;
    private boolean n;
    private Runnable o;
    private u.b p;
    
    a(Runnable paramRunnable, u.b paramb)
    {
      this.p = paramb;
      this.o = paramRunnable;
    }
    
    private Integer a(byte[]... paramVarArgs)
    {
      this.b = paramVarArgs[0];
      this.c = paramVarArgs[1];
      for (;;)
      {
        try
        {
          long l1 = SystemClock.elapsedRealtime();
          if (l1 < u.r)
          {
            this.f = ((u.r - l1) / 1000L);
            return Integer.valueOf(11);
          }
          bj localbj = bj.a(u.this, new String(paramVarArgs[1]));
          if (paramVarArgs[3] != null) {
            break label498;
          }
          arrayOfByte = "-1".getBytes();
          paramVarArgs = u.this.x.a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], localbj.toString(), arrayOfByte);
          if (paramVarArgs.a == b.d.a)
          {
            this.d = paramVarArgs.c;
            this.e = paramVarArgs.d;
            this.n = paramVarArgs.o;
            u.this.u = false;
            u.this.t = true;
            return Integer.valueOf(1);
          }
          if (paramVarArgs.a == b.d.b)
          {
            this.g = paramVarArgs.f;
            this.h = paramVarArgs.g;
            if (paramVarArgs.b == 0) {
              return Integer.valueOf(4);
            }
            if (paramVarArgs.b == b.b.b) {
              return Integer.valueOf(5);
            }
            if (paramVarArgs.b == b.b.c)
            {
              u.this.t = false;
              return Integer.valueOf(6);
            }
            if (paramVarArgs.b == b.b.d)
            {
              u.this.t = false;
              return Integer.valueOf(7);
            }
            if (paramVarArgs.b == b.b.e)
            {
              u.this.t = false;
              return Integer.valueOf(8);
            }
            if (paramVarArgs.b == b.b.f)
            {
              this.f = paramVarArgs.e;
              return Integer.valueOf(9);
            }
            if (paramVarArgs.b == b.b.g) {
              return Integer.valueOf(12);
            }
            if (paramVarArgs.b == b.b.h) {
              return Integer.valueOf(14);
            }
            if (paramVarArgs.b == b.b.i) {
              return Integer.valueOf(15);
            }
            if (paramVarArgs.b == b.b.j)
            {
              this.k = paramVarArgs.k;
              this.l = paramVarArgs.l;
              this.m = paramVarArgs.m;
              return Integer.valueOf(16);
            }
            this.i = paramVarArgs.h;
            this.j = paramVarArgs.i;
            this.n = paramVarArgs.o;
            return Integer.valueOf(2);
          }
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs = paramVarArgs.toString();
          Log.e("enterphone/checkreinstalled/ioerror " + paramVarArgs);
          if ((paramVarArgs != null) && (paramVarArgs.contains(" refused"))) {
            return Integer.valueOf(4);
          }
          return Integer.valueOf(3);
        }
        catch (Exception paramVarArgs)
        {
          Log.d("enterphone/checkreinstalled/error", paramVarArgs);
        }
        return Integer.valueOf(4);
        label498:
        byte[] arrayOfByte = paramVarArgs[3];
      }
    }
    
    protected final void onCancelled()
    {
      u.this.p();
    }
    
    protected final void onPreExecute()
    {
      d.a(u.this, 9);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  public static final class c
  {
    TextWatcher a;
    TextWatcher b;
    String c;
    int d;
    int e;
    TextView f;
    EditText g;
    EditText h;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */