package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.a;
import android.support.v7.app.c;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestPermissionActivity
  extends c
{
  private static final Map<Integer, int[]> n;
  private final e o = e.a();
  private final aus p = aus.a();
  private final atu q = atu.a();
  private final atv r = atv.a();
  private final pv s = pv.a();
  private boolean t;
  
  static
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put(Integer.valueOf(30), new int[] { 2131297408, 2131297407, 2131297427, 2131297426, 2131297363, 2131297348 });
    localHashMap.put(Integer.valueOf(31), new int[] { 2131297404, 2131297403, 2131297421, 2131297420, 2131297350, 2131297349 });
    localHashMap.put(Integer.valueOf(32), new int[] { 2131297406, 2131297405, 2131297423, 2131297422, 2131297352, 2131297351 });
    localHashMap.put(Integer.valueOf(33), new int[] { 2131297410, 2131297409, 2131297433, 2131297432, 2131297365, 2131297364 });
    n = Collections.unmodifiableMap(localHashMap);
  }
  
  private static Intent a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new Intent(paramContext, RequestPermissionActivity.class).putExtra("drawable_id", 2130840438).putExtra("permissions", new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS" }).putExtra("message_id", paramInt1).putExtra("perm_denial_message_id", paramInt2).putExtra("force_ui", paramBoolean);
  }
  
  @SuppressLint({"InlinedApi"})
  private static Intent a(Context paramContext, atu paramatu, int paramInt)
  {
    int i;
    if (!paramatu.b())
    {
      i = 1;
      if (paramatu.a("android.permission.CAMERA") == 0) {
        break label67;
      }
    }
    label67:
    for (int j = 1;; j = 0)
    {
      paramatu = (int[])n.get(Integer.valueOf(paramInt));
      if (paramatu != null) {
        break label73;
      }
      Log.e("conversation/check/camera/storage/permissions/unexpected request code " + paramInt);
      return null;
      i = 0;
      break;
    }
    label73:
    if ((j != 0) && (i != 0)) {
      return new Intent(paramContext, RequestPermissionActivity.class).putExtra("drawable_ids", new int[] { 2130840443, 2130840441, 2130840436 }).putExtra("permissions", new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }).putExtra("message_id", paramatu[0]).putExtra("perm_denial_message_id", paramatu[1]);
    }
    if (i != 0) {
      return b(paramContext, paramatu[2], paramatu[3], false);
    }
    if (j != 0) {
      return new Intent(paramContext, RequestPermissionActivity.class).putExtra("drawable_id", 2130840436).putExtra("message_id", paramatu[4]).putExtra("perm_denial_message_id", paramatu[5]).putExtra("permissions", new String[] { "android.permission.CAMERA" });
    }
    return null;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramInt1, paramInt2, false);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramInt1, paramInt2, false, paramInt3);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity.isFinishing())
    {
      Log.d("request/permission/activity/contacts passed activity is finishing: do nothing");
      return;
    }
    paramActivity.startActivityForResult(a(paramActivity, paramInt1, paramInt2, paramBoolean), 150);
  }
  
  @TargetApi(16)
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramActivity.isFinishing())
    {
      Log.d("request/permission/activity/storage passed activity is finishing: do nothing");
      return;
    }
    paramActivity.startActivityForResult(b(paramActivity, paramInt1, paramInt2, paramBoolean), paramInt3);
  }
  
  public static void a(Activity paramActivity, atv paramatv, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      Log.d("wa-shared-prefs/set-permission-requested " + str);
      paramatv.c().putBoolean(str, true).apply();
      i += 1;
    }
    a.a(paramActivity, paramArrayOfString);
  }
  
  public static void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (paramFragment.k() == null)
    {
      Log.d("request/permission/activity/contacts passed activity is finishing: do nothing");
      return;
    }
    paramFragment.startActivityForResult(a(paramFragment.k(), paramInt1, paramInt2, false), 150);
  }
  
  public static boolean a(Activity paramActivity, atu paramatu, int paramInt)
  {
    paramatu = a(paramActivity, paramatu, paramInt);
    if (paramatu == null) {
      return true;
    }
    paramActivity.startActivityForResult(paramatu, paramInt);
    return false;
  }
  
  public static boolean a(Activity paramActivity, pv parampv, atu paramatu, String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (((Build.VERSION.SDK_INT < 23) && (!paramatu.e())) || ((Build.VERSION.SDK_INT >= 23) && (paramatu.a("android.permission.RECORD_AUDIO") != 0)))
    {
      bool = true;
      if ((!paramBoolean) || (((Build.VERSION.SDK_INT >= 23) || (paramatu.f())) && ((Build.VERSION.SDK_INT < 23) || (paramatu.a("android.permission.CAMERA") == 0)))) {
        break label234;
      }
      paramBoolean = true;
      label76:
      Log.i("request/permission/checkCameraAndMicPermissionsForVoipCall needMicPerm = " + bool + ", needCameraPerm = " + paramBoolean);
      if (Build.VERSION.SDK_INT < 23) {
        break label392;
      }
      if ((!paramBoolean) || (!bool)) {
        break label240;
      }
      paramActivity.startActivityForResult(new Intent(paramActivity, RequestPermissionActivity.class).putExtra("drawable_ids", new int[] { 2130840440, 2130840441, 2130840436 }).putExtra("permissions", new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }).putExtra("message_id", 2131297400).putExtra("perm_denial_message_id", 2131297399).putExtra("jid", paramString).putExtra("force_ui", true), 152);
    }
    for (;;)
    {
      if ((paramBoolean) || (bool)) {
        break label448;
      }
      return true;
      bool = false;
      break;
      label234:
      paramBoolean = false;
      break label76;
      label240:
      if (bool)
      {
        paramActivity.startActivityForResult(new Intent(paramActivity, RequestPermissionActivity.class).putExtra("drawable_id", 2130840440).putExtra("message_id", 2131297394).putExtra("perm_denial_message_id", 2131297385).putExtra("permissions", new String[] { "android.permission.RECORD_AUDIO" }).putExtra("jid", paramString).putExtra("force_ui", true), 152);
      }
      else if (paramBoolean)
      {
        paramActivity.startActivityForResult(new Intent(paramActivity, RequestPermissionActivity.class).putExtra("drawable_id", 2130840436).putExtra("message_id", 2131297360).putExtra("perm_denial_message_id", 2131297359).putExtra("permissions", new String[] { "android.permission.CAMERA" }).putExtra("jid", paramString).putExtra("force_ui", true), 152);
        continue;
        label392:
        if ((paramBoolean) && (bool)) {
          parampv.b(paramActivity, 2131296394, 1);
        } else if (paramBoolean) {
          parampv.b(paramActivity, 2131296393, 1);
        } else if (bool) {
          parampv.b(paramActivity, 2131296397, 1);
        }
      }
    }
    label448:
    return false;
  }
  
  public static boolean a(Activity paramActivity, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!a.a(paramActivity, paramArrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(Fragment paramFragment, atu paramatu)
  {
    paramatu = a(paramFragment.k(), paramatu, 33);
    if (paramatu == null) {
      return true;
    }
    paramFragment.startActivityForResult(paramatu, 33);
    return false;
  }
  
  public static boolean a(atv paramatv, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      boolean bool = paramatv.a.getBoolean(str, false);
      Log.d("wa-shared-prefs/is-permission-requested " + str + " - " + bool);
      if (bool) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @SuppressLint({"InlinedApi"})
  private static Intent b(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new Intent(paramContext, RequestPermissionActivity.class).putExtra("drawable_id", 2130840443).putExtra("permissions", new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }).putExtra("message_id", paramInt1).putExtra("perm_denial_message_id", paramInt2).putExtra("force_ui", paramBoolean);
  }
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    b(paramActivity, paramInt1, paramInt2, false);
  }
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramActivity, paramInt1, paramInt2, paramBoolean, 151);
  }
  
  public final void a(String[] paramArrayOfString)
  {
    this.t = true;
    a(this, this.r, paramArrayOfString);
    ((View)a.d.a(findViewById(2131756003))).setVisibility(8);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.p.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("request/permission/activity/create");
    this.p.e();
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131624090)));
    setContentView(al.a(this.s, getLayoutInflater(), 2130903331, null, false));
    ((View)a.d.a(findViewById(2131755378))).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        RequestPermissionActivity.this.finish();
      }
    });
    Object localObject = getIntent().getExtras();
    final String[] arrayOfString = ((Bundle)localObject).getStringArray("permissions");
    if (arrayOfString == null)
    {
      Log.e("request/permission/activity/no-permissions-passed");
      finish();
      return;
    }
    int i = ((Bundle)localObject).getInt("drawable_id");
    label240:
    boolean bool2;
    if (i != 0)
    {
      ((ImageView)a.d.a((ImageView)findViewById(2131756004))).setImageResource(i);
      ((View)a.d.a(findViewById(2131755899))).setVisibility(8);
      ((View)a.d.a(findViewById(2131756005))).setVisibility(8);
      if (paramBundle != null) {
        this.t = paramBundle.getBoolean("permissions_requested", false);
      }
      boolean bool1 = a(this, arrayOfString);
      if ((!((Bundle)localObject).getBoolean("force_ui", false)) && (((Bundle)localObject).getInt("perm_denial_message_id") != 0) && (!bool1)) {
        break label436;
      }
      i = 1;
      bool2 = a(this.r, arrayOfString);
      if ((bool1) || (bool2)) {
        break label441;
      }
    }
    label436:
    label441:
    for (int j = 1;; j = 0)
    {
      if ((!this.t) && ((i != 0) || (!bool2))) {
        break label446;
      }
      a(arrayOfString);
      ((View)a.d.a(findViewById(2131756007))).getViewTreeObserver().addOnGlobalLayoutListener(agp.a(this));
      return;
      int[] arrayOfInt = ((Bundle)localObject).getIntArray("drawable_ids");
      if ((arrayOfInt == null) || (arrayOfInt.length != 3)) {
        break;
      }
      ((ImageView)a.d.a((ImageView)findViewById(2131755899))).setImageResource(arrayOfInt[0]);
      ((View)a.d.a(findViewById(2131755899))).setVisibility(0);
      ((ImageView)a.d.a((ImageView)findViewById(2131756004))).setImageResource(arrayOfInt[1]);
      ((ImageView)a.d.a((ImageView)findViewById(2131756005))).setImageResource(arrayOfInt[2]);
      ((View)a.d.a(findViewById(2131756005))).setVisibility(0);
      break;
      i = 0;
      break label240;
    }
    label446:
    if (j != 0)
    {
      paramBundle = "perm_denial_message_id";
      label453:
      i = ((Bundle)localObject).getInt(paramBundle);
      if (i == 0) {
        break label606;
      }
      paramBundle = (TextView)a.d.a((TextView)findViewById(2131756006));
      localObject = ((Bundle)localObject).getString("jid");
      if (localObject != null) {
        break label567;
      }
      paramBundle.setText(i);
      label501:
      paramBundle = (Button)a.d.a((Button)findViewById(2131755379));
      if (j == 0) {
        break label642;
      }
      paramBundle.setText(2131297401);
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          d.d(RequestPermissionActivity.this);
        }
      });
    }
    for (;;)
    {
      ((View)a.d.a(findViewById(2131756003))).setVisibility(0);
      break;
      paramBundle = "message_id";
      break label453;
      label567:
      localObject = this.o.d((String)localObject);
      paramBundle.setText(getResources().getString(i, new Object[] { ((cs)localObject).a(this) }));
      break label501;
      label606:
      Log.e("request/permission/activity/there is no message id for " + Arrays.toString(((Bundle)localObject).getStringArray("permissions")));
      finish();
      break label501;
      label642:
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          RequestPermissionActivity.this.a(arrayOfString);
        }
      });
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt != 0) {
      return;
    }
    setResult(-1);
    paramInt = 0;
    if (paramInt < paramArrayOfString.length)
    {
      if (paramArrayOfInt[paramInt] == 0) {
        this.r.a(paramArrayOfString[paramInt]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        Log.i("request/permission/activity/" + paramArrayOfString[paramInt] + " denied");
        setResult(0);
      }
    }
    finish();
  }
  
  protected void onResume()
  {
    int j = 0;
    super.onResume();
    String[] arrayOfString = getIntent().getExtras().getStringArray("permissions");
    String str;
    if (arrayOfString != null)
    {
      int k = arrayOfString.length;
      i = 0;
      if (i >= k) {
        break label92;
      }
      str = arrayOfString[i];
      if (this.q.a(str) == 0) {
        break label76;
      }
    }
    label76:
    label92:
    for (int i = j;; i = 1)
    {
      if (i != 0)
      {
        Log.i("request/permission/activity/permissions has been granted while we were paused");
        setResult(-1);
        finish();
      }
      return;
      this.r.a(str);
      i += 1;
      break;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("permissions_requested", this.t);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/RequestPermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */