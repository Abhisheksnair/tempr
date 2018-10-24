package com.whatsapp.gdrive;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.a;
import android.support.v7.widget.AppCompatSpinner;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.whatsapp.ahc;
import com.whatsapp.al;
import com.whatsapp.atv;
import com.whatsapp.data.ad;
import com.whatsapp.data.n;
import com.whatsapp.pv;
import com.whatsapp.registration.bb;
import com.whatsapp.registration.x;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import java.util.ArrayList;
import java.util.List;

public final class GoogleDriveNewUserSetupActivity
  extends SettingsGoogleDrive
{
  private static SharedPreferences E;
  private View A;
  private RadioGroup B;
  private AppCompatSpinner C;
  private List<String> D;
  private final ViewTreeObserver.OnGlobalLayoutListener F = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      int k = 8;
      int m = ((ScrollView)GoogleDriveNewUserSetupActivity.this.findViewById(2131755288)).getChildAt(0).getMeasuredHeight();
      int j;
      label63:
      label98:
      Object localObject;
      if (GoogleDriveNewUserSetupActivity.a(GoogleDriveNewUserSetupActivity.this).getVisibility() == 0)
      {
        i = GoogleDriveNewUserSetupActivity.a(GoogleDriveNewUserSetupActivity.this).getMeasuredHeight();
        if (GoogleDriveNewUserSetupActivity.b(GoogleDriveNewUserSetupActivity.this).getVisibility() != 0) {
          break label184;
        }
        j = 0;
        if (GoogleDriveNewUserSetupActivity.this.getWindowManager().getDefaultDisplay().getHeight() >= 0.7D * (j + (m - i))) {
          break label198;
        }
        i = 1;
        localObject = GoogleDriveNewUserSetupActivity.a(GoogleDriveNewUserSetupActivity.this);
        if (i == 0) {
          break label203;
        }
        j = 0;
        label113:
        ((AppCompatSpinner)localObject).setVisibility(j);
        localObject = GoogleDriveNewUserSetupActivity.b(GoogleDriveNewUserSetupActivity.this);
        if (i == 0) {
          break label209;
        }
        j = 8;
        label135:
        ((RadioGroup)localObject).setVisibility(j);
        localObject = GoogleDriveNewUserSetupActivity.this.findViewById(2131755291);
        if (i == 0) {
          break label214;
        }
      }
      label184:
      label198:
      label203:
      label209:
      label214:
      for (int i = k;; i = 0)
      {
        ((View)localObject).setVisibility(i);
        GoogleDriveNewUserSetupActivity.b(GoogleDriveNewUserSetupActivity.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        return;
        i = 0;
        break;
        j = GoogleDriveNewUserSetupActivity.b(GoogleDriveNewUserSetupActivity.this).getMeasuredHeight();
        break label63;
        i = 0;
        break label98;
        j = 8;
        break label113;
        j = 0;
        break label135;
      }
    }
  };
  private final a G = new a();
  private final x H = x.a();
  private final bb I = bb.a();
  int n = -1;
  private RadioButton[] y;
  private Button z;
  
  private void C()
  {
    int j = getWindowManager().getDefaultDisplay().getWidth();
    int k = getResources().getDimensionPixelSize(2131362010);
    RadioButton[] arrayOfRadioButton = this.y;
    int m = arrayOfRadioButton.length;
    int i = 0;
    while (i < m)
    {
      arrayOfRadioButton[i].setWidth(j - k);
      i += 1;
    }
  }
  
  private static boolean D()
  {
    long l1;
    long l2;
    try
    {
      l1 = n();
      l2 = System.currentTimeMillis();
      if (l1 < 0L) {
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.d("gdrive-new-user-setup/sufficient-time-passed-since-last-user-prompt/", localNumberFormatException);
      return true;
    }
    if (l2 - l1 > 0L)
    {
      Log.i("gdrive-new-user-setup/sufficient-time-passed-since-last-user-prompt/true");
      return true;
    }
    return false;
  }
  
  private void E()
  {
    this.B.clearCheck();
    this.C.setSelection(this.D.size() - 1, true);
  }
  
  private void a(RadioButton paramRadioButton)
  {
    paramRadioButton.toggle();
    this.C.setSelection(this.D.indexOf(paramRadioButton.getText().toString()));
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences.Editor localEditor = m().edit();
    Log.i("gdrive-new-user-setup/save-user-prompt-again-timestamp/" + paramLong + " " + ch.a(paramLong));
    localEditor.putLong("gdrive_next_prompt_for_setup_timestamp", paramLong);
    if (!localEditor.commit())
    {
      Log.w("gdrive-new-user-setup/save-user-prompt-again-timestamp/unable-to-commit");
      return false;
    }
    return true;
  }
  
  public static boolean a(ahc paramahc, x paramx, ad paramad, bb parambb, atv paramatv)
  {
    if (!GoogleDriveService.c())
    {
      Log.i("gdrive-new-user-setup/should-start/false/gdrive-access-not-allowed");
      return false;
    }
    if (!parambb.b())
    {
      Log.i("gdrive-new-user-setup/should-start/false/reg-not-verified");
      return false;
    }
    if (paramx.a)
    {
      Log.i("gdrive-new-user-setup/should-start/false/login-failed");
      return false;
    }
    if (paramahc.b())
    {
      Log.i("gdrive-new-user-setup/should-start/false/clock-wrong");
      return false;
    }
    if (paramahc.c())
    {
      Log.i("gdrive-new-user-setup/should-start/false/software-expired");
      return false;
    }
    if ((paramad == null) || (paramad.z.a.g <= 1))
    {
      Log.i("gdrive-new-user-setup/should-start/false/message-count-low");
      return false;
    }
    int i = paramatv.R();
    switch (i)
    {
    default: 
      Log.e("gdrive-new-user-setup/should-start/unexpected-backup-freq/" + i);
      i = 1;
    }
    while ((i != 0) && (D()))
    {
      return true;
      i = 1;
      continue;
      if (paramatv.ac() == null) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.z == null)
    {
      Log.e("gdrive-new-user-setup/update-setup-btn/setup-btn-is-null");
      return;
    }
    az localaz = new az(getResources().getDrawable(2130837733));
    if (paramBoolean)
    {
      this.z.setTextColor(getResources().getColor(2131623944));
      localaz.setColorFilter(getResources().getColor(2131623944), PorterDuff.Mode.SRC_ATOP);
      localaz.setAlpha(255);
    }
    while (this.aq.d())
    {
      this.z.setCompoundDrawablesWithIntrinsicBounds(null, null, localaz, null);
      return;
      int i = getResources().getColor(2131624036);
      this.z.setTextColor(i);
      localaz.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      localaz.setAlpha(i >>> 24);
    }
    this.z.setCompoundDrawablesWithIntrinsicBounds(localaz, null, null, null);
  }
  
  static int l()
  {
    return m().getInt("gdrive_setup_user_prompted_count", 0);
  }
  
  static SharedPreferences m()
  {
    if (E == null) {
      E = u.a().getSharedPreferences("com.whatsapp_preferences", 0);
    }
    return E;
  }
  
  static long n()
  {
    return m().getLong("gdrive_next_prompt_for_setup_timestamp", -1L);
  }
  
  final void a(String paramString, RadioButton paramRadioButton)
  {
    int i;
    if (getString(2131297735).equals(paramString)) {
      i = 1;
    }
    for (;;)
    {
      int j = this.n;
      this.n = i;
      if (paramRadioButton != null)
      {
        E();
        a(paramRadioButton);
      }
      c(true);
      if (((j == -1) || (j == 0) || (this.aQ.ac() == null)) && (i != 0) && (i != -1)) {
        this.A.performClick();
      }
      return;
      if (getString(2131297739).equals(paramString))
      {
        i = 2;
      }
      else if (getString(2131297737).equals(paramString))
      {
        i = 3;
      }
      else if (getString(2131297738).equals(paramString))
      {
        i = 0;
      }
      else
      {
        Log.i("gdrive-new-user-setup/create/unexpected-backup-frequency/" + paramString);
        i = -1;
      }
    }
  }
  
  public final void f(int paramInt)
  {
    if (paramInt == 14)
    {
      this.n = 0;
      this.z.performClick();
      return;
    }
    super.f(paramInt);
  }
  
  protected final void o()
  {
    this.aQ.h(0);
    if (this.n != 0)
    {
      c(false);
      E();
      this.n = -1;
    }
  }
  
  public final void onBackPressed()
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.d("gdrive-new-user-setup/back-pressed", localActivityNotFoundException);
      Toast.makeText(this, 2131296898, 1).show();
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.i("gdrive-new-user-setup/config-change");
    C();
    int i = -1;
    switch (this.n)
    {
    default: 
      if (i >= 0)
      {
        a(this.y[i]);
        this.C.setSelection(i);
      }
      break;
    }
    for (;;)
    {
      this.B.getViewTreeObserver().addOnGlobalLayoutListener(this.F);
      return;
      i = this.D.indexOf(getString(2131297735));
      break;
      i = this.D.indexOf(getString(2131297739));
      break;
      i = this.D.indexOf(getString(2131297737));
      break;
      i = this.D.indexOf(getString(2131297738));
      break;
      E();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("gdrive-new-user-setup/create");
    if (!a(this.av, this.H, this.w, this.I, this.aQ))
    {
      Log.i("gdrive-new-user-setup/create no need to display GoogleDriveNewUserSetupActivity, exiting.");
      setResult(-1);
      finish();
      return;
    }
    setTitle(2131296903);
    i().a(false);
    findViewById(2131755294).setVisibility(8);
    findViewById(2131755303).setVisibility(8);
    findViewById(2131755304).setVisibility(8);
    findViewById(2131755310).setVisibility(8);
    findViewById(2131755313).setVisibility(8);
    findViewById(2131755290).setVisibility(0);
    findViewById(2131755291).setVisibility(0);
    paramBundle = (TextView)findViewById(2131755315);
    paramBundle.setText(getString(2131296900, new Object[] { getString(2131297775), getString(2131297714), getString(2131297703) }));
    paramBundle.setVisibility(0);
    findViewById(2131755309).setVisibility(0);
    paramBundle = (TextView)findViewById(2131755289);
    paramBundle.setVisibility(0);
    paramBundle.setText(2131296899);
    paramBundle = (TextView)findViewById(2131755307);
    paramBundle.setText(2131296897);
    paramBundle.setTextColor(getResources().getColorStateList(2131624166));
    ((TextView)findViewById(2131755308)).setTextColor(getResources().getColorStateList(2131624165));
    this.A = findViewById(2131755306);
    this.B = ((RadioGroup)findViewById(2131755292));
    this.D = new ArrayList();
    paramBundle = getResources().getStringArray(2131689483);
    int j = paramBundle.length;
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = paramBundle[i];
      if ((!((String)localObject).equals(getString(2131297736))) && (!((String)localObject).equals(getString(2131297738)))) {
        this.D.add(localObject);
      }
      i += 1;
    }
    this.D.add(getString(2131297738));
    this.D.add(getString(2131296902));
    this.B.setVisibility(0);
    paramBundle = new ArrayAdapter(this, 17367048, this.D);
    paramBundle.setDropDownViewResource(17367049);
    this.C = ((AppCompatSpinner)findViewById(2131755293));
    this.C.setAdapter(paramBundle);
    this.C.setSelection(this.D.size() - 1);
    this.C.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (GoogleDriveNewUserSetupActivity.a(GoogleDriveNewUserSetupActivity.this).getVisibility() == 0)
        {
          paramAnonymousAdapterView = String.valueOf(paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt));
          GoogleDriveNewUserSetupActivity.a(GoogleDriveNewUserSetupActivity.this, paramAnonymousAdapterView);
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    paramBundle = (LayoutInflater)getSystemService("layout_inflater");
    this.y = new RadioButton[this.D.size() - 1];
    this.B.addView(al.a(this.aq, paramBundle, 2130903244));
    i = 0;
    while (i < this.y.length)
    {
      localObject = (String)this.D.get(i);
      RadioButton localRadioButton = (RadioButton)al.a(this.aq, paramBundle, 2130903245);
      localRadioButton.setText((CharSequence)localObject);
      this.B.addView(localRadioButton);
      this.B.addView(al.a(this.aq, paramBundle, 2130903244));
      this.y[i] = localRadioButton;
      localRadioButton.setOnClickListener(bh.a(this, (String)localObject, localRadioButton));
      i += 1;
    }
    C();
    this.z = ((Button)findViewById(2131755316));
    this.z.setVisibility(0);
    c(false);
    this.z.setOnClickListener(bi.a(this));
    this.B.getViewTreeObserver().addOnGlobalLayoutListener(this.F);
  }
  
  protected final void onDestroy()
  {
    Log.i("gdrive-new-user-setup/destroy");
    super.onDestroy();
  }
  
  protected final void p() {}
  
  static final class a {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/GoogleDriveNewUserSetupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */