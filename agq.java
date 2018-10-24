package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.a.c;
import com.whatsapp.g.l;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;

public final class agq
  extends m
{
  private final pv aa = pv.a();
  private final atv ab = atv.a();
  
  public final Dialog c(Bundle paramBundle)
  {
    Dialog localDialog = new Dialog(l());
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.setCancelable(false);
    localDialog.setCanceledOnTouchOutside(false);
    localDialog.setContentView(al.a(this.aa, l().getLayoutInflater(), 2130903331, null, false));
    paramBundle = i();
    final Object localObject = paramBundle.getIntArray("drawables");
    if (localObject != null)
    {
      if (localObject.length != 1) {
        break label176;
      }
      ((ImageView)localDialog.findViewById(2131756004)).setImageResource(localObject[0]);
      localDialog.findViewById(2131755899).setVisibility(8);
      localDialog.findViewById(2131756005).setVisibility(8);
    }
    for (;;)
    {
      localDialog.findViewById(2131755378).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          agq.this.a();
        }
      });
      localObject = paramBundle.getStringArray("permissions");
      if (localObject != null) {
        break;
      }
      Log.e("permissions/dialog/fragment/no permissions provided");
      return localDialog;
      label176:
      ((ImageView)localDialog.findViewById(2131755899)).setImageResource(localObject[0]);
      ((ImageView)localDialog.findViewById(2131756004)).setImageResource(localObject[1]);
      ((ImageView)localDialog.findViewById(2131756005)).setImageResource(localObject[2]);
      localDialog.findViewById(2131755899).setVisibility(0);
      localDialog.findViewById(2131756005).setVisibility(0);
    }
    Button localButton = (Button)localDialog.findViewById(2131755379);
    boolean bool1 = RequestPermissionActivity.a(l(), (String[])localObject);
    TextView localTextView = (TextView)localDialog.findViewById(2131756006);
    boolean bool2 = ((l)c.a().a(l.class)).a;
    Bundle localBundle;
    int i;
    if (bool1)
    {
      localBundle = i();
      if (bool2)
      {
        paramBundle = "locked_msg_id";
        i = localBundle.getInt(paramBundle);
        localTextView.setText(i);
        if (!bool1) {
          break label391;
        }
        localButton.setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            agq.this.a();
            RequestPermissionActivity.a(agq.this.l(), agq.a(agq.this), localObject);
          }
        });
      }
    }
    for (;;)
    {
      return localDialog;
      paramBundle = "msg_id";
      break;
      localBundle = i();
      if (bool2) {}
      for (paramBundle = "locked_perm_denial_msg_id";; paramBundle = "perm_denial_msg_id")
      {
        i = localBundle.getInt(paramBundle);
        break;
      }
      label391:
      localButton.setText(2131297401);
      localButton.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          agq.this.a();
          d.d(agq.this.l());
        }
      });
    }
  }
  
  public final void e()
  {
    super.e();
    c().getWindow().setLayout(m().getDisplayMetrics().widthPixels, m().getDisplayMetrics().heightPixels);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/agq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */