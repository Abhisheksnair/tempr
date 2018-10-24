package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.whatsapp.abl;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.atv;
import com.whatsapp.data.ad;
import com.whatsapp.g.i;
import com.whatsapp.ly;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.r;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import java.io.IOException;

public class ChangeNumber
  extends u
{
  private static String B = null;
  private static String C = null;
  private u.c D;
  private final bc.a E = new bc.a(this);
  private final ad F = ad.a();
  private final m G = m.a();
  private final atv H = atv.a();
  private Runnable I = b.a(this);
  private final u.b J = new c(this);
  private final aw.a K = new aw.a()
  {
    public final void a()
    {
      ChangeNumber.b(ChangeNumber.this).sendEmptyMessage(3);
    }
    
    public final void a(String paramAnonymousString)
    {
      if (ChangeNumber.a(ChangeNumber.this).b().equals(paramAnonymousString))
      {
        ChangeNumber.b(ChangeNumber.this).sendEmptyMessage(1);
        return;
      }
      ChangeNumber.b(ChangeNumber.this).sendEmptyMessage(2);
    }
  };
  private Handler L = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        Log.w("changenumber/check-number/match");
        ChangeNumber.b(ChangeNumber.this).removeMessages(4);
        a.a.a.a.d.b(ChangeNumber.this, 1);
        if (!ChangeNumber.m().equals(u.o))
        {
          a.a.a.a.d.a(ChangeNumber.this, 2);
          return;
        }
        ChangeNumber.c(ChangeNumber.this);
        return;
      case 2: 
        Log.w("changenumber/check-number/mismatch");
        ChangeNumber.b(ChangeNumber.this).removeMessages(4);
        a.a.a.a.d.b(ChangeNumber.this, 1);
        ChangeNumber.this.b_(2131296622);
        return;
      case 3: 
        Log.e("changenumber/error");
        a.a.a.a.d.b(ChangeNumber.this, 1);
        a.a.a.a.d.a(ChangeNumber.this, 109);
        return;
      }
      Log.e("changenumber/timeout");
      ChangeNumber.b(ChangeNumber.this).removeMessages(4);
      a.a.a.a.d.b(ChangeNumber.this, 1);
      a.a.a.a.d.a(ChangeNumber.this, 109);
    }
  };
  private at M = new at()
  {
    public final void a(View paramAnonymousView)
    {
      String str2 = ChangeNumber.d(ChangeNumber.this).g.getText().toString().trim();
      paramAnonymousView = ChangeNumber.d(ChangeNumber.this).h.getText().toString();
      if (!ChangeNumber.a(ChangeNumber.this, str2, paramAnonymousView, ChangeNumber.d(ChangeNumber.this))) {}
      do
      {
        String str1;
        String str3;
        do
        {
          return;
          str1 = ChangeNumber.this.s.g.getText().toString().trim();
          str3 = ChangeNumber.this.s.h.getText().toString();
        } while (!ChangeNumber.a(ChangeNumber.this, str1, str3, ChangeNumber.this.s));
        int i = Integer.parseInt(str2);
        paramAnonymousView = paramAnonymousView.replaceAll("\\D", "");
        try
        {
          str1 = ly.a(i, paramAnonymousView);
          paramAnonymousView = str1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.d("changenumber/phone failed trimLeadingZero from CountryPhoneInfo", localIOException);
          }
          a.a.a.a.d.a(ChangeNumber.this, 1);
          ChangeNumber.b(ChangeNumber.this).sendEmptyMessageDelayed(4, 30000L);
        }
        Log.i("changenumber/phone/cc=" + str2 + "/number=" + paramAnonymousView);
        ChangeNumber.a(str2);
        ChangeNumber.b(paramAnonymousView);
        Log.w("changenumber/submit/cc " + ChangeNumber.m() + " ph=" + ChangeNumber.n() + " jid=" + ChangeNumber.a(ChangeNumber.this).b());
        if (!((i)b.a.a.c.a().a(i.class)).a)
        {
          Log.w("changenumber/submit/no-connectivity");
          ChangeNumber.this.d(ChangeNumber.this.getString(2131296412) + " " + ChangeNumber.this.getString(2131296505) + "\n\n" + ChangeNumber.this.getString(2131296506));
          return;
        }
      } while (ChangeNumber.e(ChangeNumber.this).b(str2, paramAnonymousView));
      ChangeNumber.b(ChangeNumber.this).removeMessages(4);
      a.a.a.a.d.b(ChangeNumber.this, 1);
      ChangeNumber.this.d(ChangeNumber.this.getString(2131297527, new Object[] { ChangeNumber.this.getString(2131296506) }));
    }
  };
  final va n = va.a();
  
  private boolean a(String paramString1, String paramString2, u.c paramc)
  {
    switch (RegisterPhone.c(paramString1, paramString2))
    {
    default: 
      return false;
    case 1: 
      int i = Integer.parseInt(paramString1);
      paramString2 = paramString2.replaceAll("\\D", "");
      try
      {
        paramc = ly.a(i, paramString2);
        paramString2 = paramc;
      }
      catch (IOException paramc)
      {
        for (;;)
        {
          Log.d("changenumber/cc failed trimLeadingZero from CountryPhoneInfo", paramc);
        }
      }
      Log.i("changenumber/cc=" + paramString1 + "/number=" + paramString2);
      o = paramString1;
      p = paramString2;
      return true;
    case 2: 
      b_(2131297519);
      paramc.g.requestFocus();
      return false;
    case 3: 
      b_(2131297520);
      paramc.g.setText("");
      paramc.g.requestFocus();
      return false;
    case 4: 
      b_(2131297533);
      paramc.h.requestFocus();
      return false;
    case 5: 
      d(getString(2131297525, new Object[] { paramc.c }));
      paramc.h.requestFocus();
      return false;
    case 6: 
      d(getString(2131297524, new Object[] { paramc.c }));
      paramc.h.requestFocus();
      return false;
    }
    d(getString(2131297523, new Object[] { paramc.c }));
    paramc.h.requestFocus();
    return false;
  }
  
  private static void b(String paramString, u.c paramc)
  {
    try
    {
      Log.i("changenumber/country:" + paramString + " | " + ly.e(paramString));
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          if (paramc.b != null) {
            paramc.h.removeTextChangedListener(paramc.b);
          }
          paramc.b = new abl(ly.e(paramString));
          paramc.h.addTextChangedListener(paramc.b);
          return;
        }
        catch (NullPointerException paramString)
        {
          Log.d("changenumber/formatter-exception", paramString);
          return;
        }
        catch (IOException paramc)
        {
          Log.d("changenumber/country:" + paramString + " caused an IOException", paramc);
        }
        localIOException = localIOException;
        Log.e("changenumber/country: " + paramString + "failed to lookupCountryAbbrByName from CountryPhoneInfo " + localIOException.toString());
      }
    }
  }
  
  private void r()
  {
    if (isFinishing())
    {
      Log.i("changenumber/verify/cancel");
      return;
    }
    r = 0L;
    this.H.h(null);
    String str = bc.a(o + p);
    byte[] arrayOfByte2 = r.c(str);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = r.i();
      r.a(arrayOfByte1, str);
    }
    bu.a(new u.a(this, this.I, this.J), new byte[][] { o.getBytes(), p.getBytes(), arrayOfByte1, null });
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3)
  {
    this.y.a(paramString1, paramString2, paramString3);
    this.y.a(this.F, this.aH);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    Log.i("changenumber/create");
    super.onCreate(paramBundle);
    a locala = (a)a.d.a(i());
    locala.a(true);
    locala.c();
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903104, null, false, new int[] { 2131755448, 2131755451 }));
    this.D = new u.c();
    this.s = new u.c();
    this.D.g = ((EditText)findViewById(2131755449));
    this.s.g = ((EditText)findViewById(2131755452));
    this.D.h = ((EditText)findViewById(2131755450));
    this.s.h = ((EditText)findViewById(2131755453));
    this.D.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });
    this.D.h.setFilters(new InputFilter[] { new InputFilter.LengthFilter(17) });
    TelephonyManager localTelephonyManager = this.aE.c;
    paramBundle = (Bundle)localObject;
    if (localTelephonyManager != null) {
      paramBundle = localTelephonyManager.getNetworkCountryIso();
    }
    if (paramBundle != null) {}
    try
    {
      B = ly.d(paramBundle);
      this.D.g.addTextChangedListener(new a(this.D));
      this.s.g.addTextChangedListener(new a(this.s));
      this.D.h.requestFocus();
      this.D.e = RegisterPhone.a(this.D.h);
      this.D.d = RegisterPhone.a(this.D.g);
      this.s.e = RegisterPhone.a(this.s.h);
      this.s.d = RegisterPhone.a(this.s.g);
      a.a.a.a.d.a(locala, this.aq, getString(2131296687).toUpperCase(), this.M);
      if (B != null)
      {
        this.D.g.setText(B);
        this.s.g.setText(B);
      }
      paramBundle = this.D.c;
      if ((paramBundle == null) || (paramBundle.length() <= 0)) {}
    }
    catch (IOException paramBundle)
    {
      try
      {
        Log.i("changenumber/country:" + paramBundle + " | " + ly.e(paramBundle));
        b(paramBundle, this.D);
        b(paramBundle, this.s);
        this.v = this.H.E();
        this.y.a(this.K);
        return;
        paramBundle = paramBundle;
        Log.e("changenumber/iso/code failed to get code from CountryPhoneInfo");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.d("changenumber/country:" + paramBundle + " failed CountryPhoneInfo.lookupCountryAbbrByName()", localIOException);
        }
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      ProgressDialog localProgressDialog = new ProgressDialog(this);
      localProgressDialog.setMessage(getString(2131297530));
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.setCancelable(false);
      return localProgressDialog;
    }
    return new b.a(this).b(2131296414).a(2131296364, d.a(this)).a();
  }
  
  protected void onDestroy()
  {
    Log.i("changenumber/destroy");
    this.y.b(this.K);
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("changenumber/pause");
    this.D.e = RegisterPhone.a(this.D.h);
    this.D.d = RegisterPhone.a(this.D.g);
    this.s.e = RegisterPhone.a(this.s.h);
    this.s.d = RegisterPhone.a(this.s.g);
    Object localObject = this.H.E();
    if (this.v != null)
    {
      localObject = this.H;
      str1 = o;
      str2 = p;
      ((atv)localObject).c().putString("change_number_new_number_banned", "+" + str1 + str2).apply();
    }
    while (localObject == null)
    {
      String str1;
      String str2;
      return;
    }
    this.H.c().remove("change_number_new_number_banned").apply();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    B = paramBundle.getString("country_code");
    C = paramBundle.getString("phone_number");
    o = paramBundle.getString("sCountryCode");
    p = paramBundle.getString("sPhoneNumber");
  }
  
  public void onResume()
  {
    super.onResume();
    if (B != null) {
      this.D.g.setText(B);
    }
    RegisterPhone.a(this.D.g, this.D.d);
    RegisterPhone.a(this.D.h, this.D.e);
    RegisterPhone.a(this.s.g, this.s.d);
    RegisterPhone.a(this.s.h, this.s.e);
    Log.i("changenumber/resume");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putCharSequence("country_code", B);
    paramBundle.putCharSequence("phone_number", C);
    paramBundle.putCharSequence("sCountryCode", o);
    paramBundle.putCharSequence("sPhoneNumber", p);
  }
  
  final class a
    implements TextWatcher
  {
    private u.c b;
    
    public a(u.c paramc)
    {
      this.b = paramc;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      if (paramEditable != null) {}
      for (Object localObject1 = localObject3;; localObject1 = localObject2)
      {
        try
        {
          if (paramEditable.length() <= 0) {
            break label134;
          }
          localObject1 = localObject3;
          paramEditable = ly.a(paramEditable.toString());
          localObject1 = paramEditable;
          this.b.c = paramEditable;
          localObject1 = paramEditable;
        }
        catch (IOException paramEditable)
        {
          for (;;)
          {
            label134:
            Log.d("changenumber/watcher/aftertextchanged failed lookupCountryCode from CountryPhoneInfo", paramEditable);
          }
        }
        if ((!this.b.g.getText().toString().equals("")) && (localObject1 != null))
        {
          ChangeNumber.a((String)localObject1, this.b);
          paramEditable = this.b.h.getText().toString().replaceAll("\\D", "");
          this.b.h.setText(paramEditable);
          if (this.b.g.hasFocus()) {
            this.b.h.requestFocus();
          }
        }
        return;
        localObject1 = localObject3;
        this.b.c = null;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/ChangeNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */