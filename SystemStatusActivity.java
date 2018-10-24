package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.a;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SystemStatusActivity
  extends nh
{
  String n;
  String o;
  int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private ArrayList<String> t;
  private final List<String> u = Arrays.asList(new String[] { "broadcast", "registration", "sync", "status" });
  
  public static void a(Context paramContext, String paramString, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2, ArrayList<String> paramArrayList, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(paramContext, SystemStatusActivity.class);
    localIntent.putExtra("com.whatsapp.SystemStatusActivity.from", paramString);
    localIntent.putExtra("com.whatsapp.SystemStatusActivity.email", paramBoolean1);
    localIntent.putExtra("com.whatsapp.SystemStatusActivity.version", paramBoolean2);
    localIntent.putStringArrayListExtra("com.whatsapp.SystemStatusActivity.serverfeaturesunavailable", paramArrayList);
    localIntent.putExtra("com.whatsapp.SystemStatusActivity.statusonly", paramBoolean3);
    if (paramInteger != null) {
      localIntent.putExtra("com.whatsapp.SystemStatusActivity.type", paramInteger);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 2131297932;
    Log.i("sysstatus/create");
    super.onCreate(paramBundle);
    i().a(true);
    i().c();
    setContentView(2130903382);
    paramBundle = getIntent();
    this.n = paramBundle.getStringExtra("com.whatsapp.SystemStatusActivity.from");
    this.p = paramBundle.getIntExtra("com.whatsapp.SystemStatusActivity.type", 0);
    i().a(2131297963);
    this.q = paramBundle.getBooleanExtra("com.whatsapp.SystemStatusActivity.email", true);
    this.r = paramBundle.getBooleanExtra("com.whatsapp.SystemStatusActivity.version", true);
    this.s = paramBundle.getBooleanExtra("com.whatsapp.SystemStatusActivity.statusonly", false);
    this.t = paramBundle.getStringArrayListExtra("com.whatsapp.SystemStatusActivity.serverfeaturesunavailable");
    boolean bool = this.t.remove("registration");
    int i;
    if (!this.r) {
      if (av.g())
      {
        paramBundle = getString(2131297561);
        if (!this.q) {
          break label332;
        }
        i = 2131297965;
        label153:
        paramBundle = getString(i, new Object[] { paramBundle });
        label167:
        if (paramBundle != null) {
          break label967;
        }
        if (!this.s) {
          break label943;
        }
        paramBundle = getString(2131297785);
      }
    }
    label332:
    label799:
    label887:
    label908:
    label938:
    label943:
    label967:
    for (;;)
    {
      ((TextView)findViewById(2131756125)).setText(paramBundle);
      if ((this.s) || (!this.q)) {
        break label970;
      }
      if (this.o == null)
      {
        this.o = ("+" + TextUtils.join("+", this.t));
        if (!this.r) {
          this.o += "+version";
        }
      }
      ((Button)findViewById(2131756127)).setOnClickListener(ang.a(this));
      ((Button)findViewById(2131756128)).setOnClickListener(anh.a(this));
      return;
      paramBundle = getString(2131297562, new Object[] { "https://whatsapp.com/android" });
      break;
      i = 2131297964;
      break label153;
      if (this.p != 1)
      {
        if (!bool) {
          break label938;
        }
        if (!this.q)
        {
          paramBundle = new StringBuilder().append(getString(2131297956)).append(" ");
          if (this.u.contains("registration")) {}
          for (i = 2131297932;; i = 2131297930)
          {
            paramBundle = getString(i);
            break;
          }
        }
        this.o = "registration";
        paramBundle = null;
        break label167;
      }
      if (this.t.contains("chat"))
      {
        if (this.q) {}
        for (i = 2131297929;; i = 2131297928)
        {
          paramBundle = getString(i);
          break;
        }
      }
      if (this.t.size() > 0)
      {
        Object localObject2 = this.t.iterator();
        paramBundle = null;
        i = 0;
        Object localObject1 = "";
        String str;
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          int k = getResources().getIdentifier("system_status_" + str + "_feature", "string", getPackageName());
          if (k != 0)
          {
            localObject1 = (String)localObject1 + "  • " + getString(k) + "\n";
            i += 1;
            paramBundle = str;
          }
          else
          {
            Log.e("sysstatus/create/m-down/string-not-found " + str);
          }
        }
        if (i > 1)
        {
          paramBundle = (String)localObject1 + "\n";
          if (this.q)
          {
            paramBundle = getString(2131297944) + "\n\n" + paramBundle + getString(2131297946);
            break label167;
          }
          paramBundle = getString(2131297943) + "\n\n" + paramBundle + getString(2131297945);
          break label167;
        }
        if (i > 0)
        {
          str = getPackageName();
          localObject2 = new StringBuilder("system_status_").append(paramBundle).append("_description");
          if (this.q)
          {
            localObject1 = "_recently";
            localObject1 = (String)localObject1;
            i = getResources().getIdentifier((String)localObject1, "string", str);
            if (i == 0) {
              break label908;
            }
            localObject1 = new StringBuilder().append(getString(i)).append(" ");
            if (!this.q) {
              break label887;
            }
            i = 2131297931;
          }
          for (;;)
          {
            paramBundle = getString(i);
            break;
            localObject1 = "";
            break label799;
            i = j;
            if (!this.u.contains(paramBundle)) {
              i = 2131297930;
            }
          }
          Log.e("sysstatus/create/down/string-not-found " + (String)this.t.get(0));
        }
      }
      paramBundle = null;
      break label167;
      d.a(this, this.n, this.o, Integer.valueOf(this.p), null);
      finish();
    }
    label970:
    findViewById(2131756126).setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("sysstatus/destroy");
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("sysstatus/pause");
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("sysstatus/resume");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SystemStatusActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */