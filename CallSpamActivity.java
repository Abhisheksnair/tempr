package com.whatsapp;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.whatsapp.data.ad;
import com.whatsapp.data.cj;
import com.whatsapp.data.cm;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.messaging.aj;
import com.whatsapp.notification.f;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import java.util.ArrayList;
import java.util.List;

public class CallSpamActivity
  extends nh
{
  private static CallSpamActivity n;
  private final cm o = cm.a();
  private final ad p = ad.a();
  private final e q = e.a();
  
  public static void a(pv parampv)
  {
    if (n != null) {
      parampv.a(bh.a());
    }
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    Log.i("callspamactivity/create");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    final String str1 = paramBundle.getString("caller_jid");
    cs localcs = this.q.c(str1);
    String str2 = paramBundle.getString("call_id");
    if ((localcs == null) || (str2 == null))
    {
      Log.i("callspamactivity/create/not-creating/null-args");
      finish();
      return;
    }
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131624090)));
    getWindow().addFlags(2621440);
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903095, null, false));
    findViewById(2131755387).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        paramAnonymousView = new CallSpamActivity.a();
        paramAnonymousView.aa = true;
        paramAnonymousView.f(paramBundle);
        paramAnonymousView.a(CallSpamActivity.this.j_(), null);
      }
    });
    findViewById(2131755389).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        cm localcm;
        String str;
        if (!CallSpamActivity.a(CallSpamActivity.this).a(str1, true))
        {
          localcm = CallSpamActivity.b(CallSpamActivity.this);
          str = str1;
          if (!TextUtils.isEmpty(str)) {
            break label65;
          }
          Log.e("spamManager/setCallNotSpamProp/invalid jid: " + str);
        }
        for (;;)
        {
          CallSpamActivity.this.finish();
          return;
          label65:
          paramAnonymousView = localcm.b();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = new ArrayList();; paramAnonymousView = new ArrayList(paramAnonymousView))
          {
            if (paramAnonymousView.contains(str)) {
              break label172;
            }
            if (paramAnonymousView.size() + 1 > 50) {
              paramAnonymousView.remove(0);
            }
            paramAnonymousView.add(str);
            paramAnonymousView = TextUtils.join(",", paramAnonymousView);
            localcm.a.a("call_not_spam_jids", paramAnonymousView);
            Log.i("spamManager/setCallNotSpamProp/true: " + paramAnonymousView);
            break;
          }
          label172:
          Log.i("spamManager/setCallNotSpamProp/false/already contains jid in size: " + paramAnonymousView.size());
        }
      }
    });
    findViewById(2131755388).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        paramAnonymousView = new CallSpamActivity.a();
        paramAnonymousView.aa = false;
        paramAnonymousView.f(paramBundle);
        paramAnonymousView.a(CallSpamActivity.this.j_(), null);
      }
    });
    n = this;
  }
  
  public void onDestroy()
  {
    Log.i("callspamactivity/destroy");
    super.onDestroy();
    n = null;
  }
  
  protected void onStop()
  {
    Log.i("callspamactivity/pause");
    super.onStop();
    finish();
  }
  
  public static final class a
    extends m
  {
    boolean aa;
    String ab;
    cs ac;
    String ad;
    long ae;
    boolean af;
    String ag;
    boolean ah;
    final pv ai = pv.a();
    final aoj aj = aoj.a();
    final ad ak = ad.a();
    final aj al = aj.a();
    final aq am = aq.a();
    final f an = f.a();
    final aat ao = aat.a();
    final ka ap = ka.a();
    private final e ar = e.a();
    private final lt as = lt.a();
    
    static
    {
      if (!CallSpamActivity.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        aq = bool;
        return;
      }
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      Log.i("callspamactivity/createdialog");
      paramBundle = i();
      this.ab = paramBundle.getString("caller_jid");
      this.ac = this.ar.c(this.ab);
      this.ad = paramBundle.getString("call_id");
      this.ae = paramBundle.getLong("call_duration", -1L);
      this.af = paramBundle.getBoolean("call_terminator", false);
      this.ag = paramBundle.getString("call_termination_reason");
      this.ah = paramBundle.getBoolean("call_video", false);
      if ((!aq) && ((this.ab == null) || (this.ac == null) || (this.ad == null))) {
        throw new AssertionError();
      }
      DialogInterface.OnClickListener localOnClickListener = bi.a(this);
      b.a locala = new b.a(l());
      if (this.aa)
      {
        paramBundle = a(2131297613);
        return locala.b(paramBundle).a(2131297331, localOnClickListener).b(2131296398, null).a();
      }
      if (this.ac != null) {}
      for (paramBundle = this.ac.a(k());; paramBundle = "")
      {
        paramBundle = a(2131296351, new Object[] { paramBundle });
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CallSpamActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */