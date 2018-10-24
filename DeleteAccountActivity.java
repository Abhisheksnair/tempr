package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.support.v7.widget.m;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.registration.RegisterPhone;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.aw.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DeleteAccountActivity
  extends nh
{
  static String n = null;
  static String o = null;
  private final aw.a A = new aw.a()
  {
    public final void a()
    {
      DeleteAccountActivity.b(DeleteAccountActivity.this).sendEmptyMessage(3);
    }
    
    public final void a(String paramAnonymousString)
    {
      if (DeleteAccountActivity.a(DeleteAccountActivity.this).b().equals(paramAnonymousString)) {}
      for (int i = 1;; i = 2)
      {
        DeleteAccountActivity.b(DeleteAccountActivity.this).sendEmptyMessage(i);
        return;
      }
    }
  };
  TextWatcher p;
  EditText q;
  TextView r;
  EditText s;
  final Handler t = new a(this);
  final va u = va.a();
  private TextWatcher v;
  private String w;
  private int x;
  private int y;
  private final aw z = aw.a();
  
  private void a(String paramString)
  {
    try
    {
      Log.i("delete-account/country:" + paramString + " | " + ly.e(paramString));
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (this.v != null) {
            this.s.removeTextChangedListener(this.v);
          }
          this.v = new abl(ly.e(paramString));
          this.s.addTextChangedListener(this.v);
          return;
        }
        catch (NullPointerException paramString)
        {
          Log.d("delete-account/formatter-exception", paramString);
          return;
        }
        catch (IOException localIOException2)
        {
          Log.d("delete-account/country:" + paramString + " caused an IOException", localIOException2);
        }
        localIOException1 = localIOException1;
        Log.e("delete-account/country: " + paramString + "failed to lookupCountryAbbrByName from CountryPhoneInfo " + localIOException1.toString());
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      n = paramIntent.getStringExtra("cc");
      this.w = paramIntent.getStringExtra("country_name");
      this.q.setText(n);
      this.r.setText(this.w);
      a(this.w);
      if (this.y == -1) {
        this.y = Integer.MAX_VALUE;
      }
      this.x = -1;
    }
    this.q.addTextChangedListener(this.p);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("delete-account/create");
    super.onCreate(paramBundle);
    pb.a(12);
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903188, null, false, new int[] { 2131755448 }));
    this.q = ((EditText)findViewById(2131755449));
    this.r = ((TextView)findViewById(2131755683));
    this.r.setBackgroundDrawable(new az(m.a().a(this)));
    this.s = ((EditText)findViewById(2131755450));
    ((TextView)findViewById(2131755682)).setText(2131296617);
    paramBundle = new InputFilter.LengthFilter(3);
    this.q.setFilters(new InputFilter[] { paramBundle });
    paramBundle = new InputFilter.LengthFilter(17);
    this.s.setFilters(new InputFilter[] { paramBundle });
    paramBundle = this.aE.c;
    if (paramBundle == null) {
      Log.w("delete-account tm=null");
    }
    for (;;)
    {
      this.p = new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          Object localObject = null;
          for (;;)
          {
            try
            {
              if (DeleteAccountActivity.c(DeleteAccountActivity.this) == null) {
                continue;
              }
              str = ly.c(DeleteAccountActivity.c(DeleteAccountActivity.this));
              if ((DeleteAccountActivity.c(DeleteAccountActivity.this) == null) || (str == null) || (!str.equalsIgnoreCase(paramAnonymousEditable.toString()))) {
                continue;
              }
              paramAnonymousEditable = DeleteAccountActivity.c(DeleteAccountActivity.this);
            }
            catch (IOException paramAnonymousEditable)
            {
              String str;
              Log.d("delete-account/watcher/aftertextchanged failed lookupCountryCode from CountryPhoneInfo", paramAnonymousEditable);
              paramAnonymousEditable = (Editable)localObject;
              continue;
              if (paramAnonymousEditable != null) {
                continue;
              }
              DeleteAccountActivity.e(DeleteAccountActivity.this).setText(DeleteAccountActivity.this.getString(2131297538));
              return;
              DeleteAccountActivity.e(DeleteAccountActivity.this).setText(paramAnonymousEditable);
              DeleteAccountActivity.a(DeleteAccountActivity.this, paramAnonymousEditable);
              paramAnonymousEditable = DeleteAccountActivity.f(DeleteAccountActivity.this).getText().toString().replaceAll("\\D", "");
              DeleteAccountActivity.f(DeleteAccountActivity.this).setText(paramAnonymousEditable);
              if (!DeleteAccountActivity.d(DeleteAccountActivity.this).hasFocus()) {
                continue;
              }
              DeleteAccountActivity.f(DeleteAccountActivity.this).requestFocus();
            }
            if (!DeleteAccountActivity.d(DeleteAccountActivity.this).getText().toString().equals("")) {
              continue;
            }
            DeleteAccountActivity.e(DeleteAccountActivity.this).setText(DeleteAccountActivity.this.getString(2131297529));
            return;
            str = null;
            continue;
            if ((DeleteAccountActivity.c(DeleteAccountActivity.this) == null) || ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))) {
              paramAnonymousEditable = ly.a(paramAnonymousEditable.toString());
            } else {
              paramAnonymousEditable = DeleteAccountActivity.c(DeleteAccountActivity.this);
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      };
      this.q.addTextChangedListener(this.p);
      this.r.setOnClickListener(ml.a(this));
      this.s.requestFocus();
      this.y = RegisterPhone.a(this.s);
      this.x = RegisterPhone.a(this.q);
      findViewById(2131755681).setOnClickListener(mm.a(this));
      ((Button)findViewById(2131755684)).setOnClickListener(mn.a(this));
      if (n != null) {
        this.q.setText(n);
      }
      paramBundle = this.r.getText().toString();
      if (!TextUtils.isEmpty(paramBundle)) {}
      try
      {
        Log.i("delete-account/country:" + paramBundle + " | " + ly.e(paramBundle));
        a(paramBundle);
        if ((!GoogleDriveService.c()) || (this.aQ.ac() == null)) {
          findViewById(2131755680).setVisibility(8);
        }
        this.z.a(this.A);
        return;
        paramBundle = paramBundle.getNetworkCountryIso();
        if (paramBundle == null) {
          continue;
        }
        try
        {
          n = ly.d(paramBundle);
        }
        catch (IOException paramBundle)
        {
          Log.e("delete-account/iso/code failed to get code from CountryPhoneInfo");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.d("delete-account/country:" + paramBundle + " failed CountryPhoneInfo.lookupCountryAbbrByName()", localIOException);
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
    return new b.a(this).b(2131297572).a(2131296428, mj.a(this)).b(2131296398, mk.a(this)).a();
  }
  
  protected void onDestroy()
  {
    Log.i("delete-account/destroy");
    this.z.b(this.A);
    this.t.removeMessages(4);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.y = RegisterPhone.a(this.s);
    this.x = RegisterPhone.a(this.q);
    Log.i("delete-account/pause ");
  }
  
  public void onResume()
  {
    super.onResume();
    if (n != null) {
      this.q.setText(n);
    }
    if (this.w != null) {
      this.r.setText(this.w);
    }
    RegisterPhone.a(this.q, this.x);
    RegisterPhone.a(this.s, this.y);
    Log.i("delete-account/phone/resume");
  }
  
  static final class a
    extends Handler
  {
    private final WeakReference<DeleteAccountActivity> a;
    
    public a(DeleteAccountActivity paramDeleteAccountActivity)
    {
      super();
      this.a = new WeakReference(paramDeleteAccountActivity);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      DeleteAccountActivity localDeleteAccountActivity = (DeleteAccountActivity)this.a.get();
      if (localDeleteAccountActivity == null) {
        Log.w("delete account was garbage collected with active messages still enqueued: " + paramMessage);
      }
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              Log.w("delete-account/check-number/match");
              removeMessages(4);
            } while (localDeleteAccountActivity == null);
            d.b(localDeleteAccountActivity, 1);
            localDeleteAccountActivity.startActivity(new Intent(localDeleteAccountActivity, DeleteAccountFeedback.class));
            localDeleteAccountActivity.finish();
            return;
            Log.w("delete-account/check-number/mismatch");
            removeMessages(4);
          } while (localDeleteAccountActivity == null);
          d.b(localDeleteAccountActivity, 1);
          localDeleteAccountActivity.b_(2131296622);
          return;
          Log.e("delete-account/error");
        } while (localDeleteAccountActivity == null);
        d.b(localDeleteAccountActivity, 1);
        d.a(localDeleteAccountActivity, 109);
        return;
        Log.e("delete-account/timeout");
        removeMessages(4);
      } while (localDeleteAccountActivity == null);
      d.b(localDeleteAccountActivity, 1);
      d.a(localDeleteAccountActivity, 109);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DeleteAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */