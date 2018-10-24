package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.b.a;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.InsufficientStorageSpaceActivity;
import com.whatsapp.Main;
import com.whatsapp.ahc;
import com.whatsapp.anv;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.i.b;
import com.whatsapp.nh;
import com.whatsapp.util.Log;
import com.whatsapp.util.bf;
import com.whatsapp.util.bf.a;
import com.whatsapp.util.bf.b;
import com.whatsapp.util.bf.c;
import com.whatsapp.vv;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EULA
  extends nh
{
  int n = a.a;
  au o = new au(this.q, this.aE, this.aM, this.aP, this.aQ);
  private final bf p = bf.a();
  private final b q = b.a();
  private final bk r = bk.a();
  private final bb s = bb.a();
  
  final void l()
  {
    Log.i("register/eula/accept");
    this.at.j();
    this.s.a(1);
    Intent localIntent = new Intent(this, RegisterPhone.class);
    localIntent.putExtra("com.whatsapp.registration.RegisterPhone.resetstate", true);
    startActivity(localIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("eula/create");
    this.al = false;
    super.onCreate(paramBundle);
    setContentView(2130903222);
    this.aQ.a(null);
    if (vv.e() < 1048576L) {
      startActivity(new Intent(this, InsufficientStorageSpaceActivity.class).setFlags(268435456).putExtra("spaceNeededInBytes", 1048576L));
    }
    if (this.s.c() != 0)
    {
      Log.e("eula/create/wrong-state bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    try
    {
      paramBundle = this.p.a(10, TimeUnit.SECONDS);
      if ((paramBundle != null) && (paramBundle.a != null))
      {
        d.a(this, 6);
        paramBundle = new SpannableString(Html.fromHtml(getString(2131296765, new Object[] { getString(2131296763) })));
        Object localObject1 = (URLSpan[])paramBundle.getSpans(0, paramBundle.length(), URLSpan.class);
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!"terms-and-privacy-policy".equals(((URLSpan)localObject2).getURL())) {
              break label420;
            }
            i = paramBundle.getSpanStart(localObject2);
            j = paramBundle.getSpanEnd(localObject2);
            int k = paramBundle.getSpanFlags(localObject2);
            paramBundle.removeSpan(localObject2);
            paramBundle.setSpan(new ClickableSpan()
            {
              public final void onClick(View paramAnonymousView)
              {
                paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse("https://www.whatsapp.com/legal/"));
                EULA.this.startActivity(paramAnonymousView);
              }
              
              public final void updateDrawState(TextPaint paramAnonymousTextPaint)
              {
                paramAnonymousTextPaint.setColor(-13322255);
              }
            }, i, j, k);
          }
        }
        localObject1 = (TextView)a.d.a(findViewById(2131755771));
        ((TextView)localObject1).setMovementMethod(new LinkMovementMethod());
        ((TextView)localObject1).setText(paramBundle);
        ((TextView)localObject1).setHighlightColor(0);
        ((Button)a.d.a(findViewById(2131755772))).setOnClickListener(l.a(this));
        if (getIntent().getBooleanExtra("show_registration_first_dlg", false)) {
          d.a(this, 1);
        }
        this.s.a(0);
        if (this.av.b())
        {
          Log.w("eula/clock-wrong");
          f();
        }
        paramBundle = this.aQ;
        Log.d("wa-shared-prefs/setenter-is-send false");
        paramBundle.c().putBoolean("input_enter_send", false).apply();
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int i;
        Log.c("exception while waiting on task killers thread to finish during onCreate ", paramBundle);
        paramBundle = null;
        continue;
        if (com.whatsapp.r.a())
        {
          d.a(this, 8);
          continue;
          label420:
          i += 1;
        }
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return super.onCreateDialog(paramInt);
    case 9: 
      return new b.a(this).a(2131296307).b(2131296439).a(2131297331, j.a(this)).a();
    case 1: 
      return new b.a(this).b(2131297535).a(2131297331, m.a(this)).a();
    case 2: 
      return new b.a(this).a(2131296307).b(2131297594).a(2131297331, n.a(this)).a();
    case 3: 
      return new b.a(this).a(2131296307).b(getString(2131296764)).a(2131297331, o.a(this)).a();
    case 5: 
      for (;;)
      {
        try
        {
          localObject1 = this.p;
          Log.d("taskkillers/get");
          localObject3 = ((bf)localObject1).a.a();
          localObject4 = new StringBuilder("taskkillers/scan results=");
          if (((bf.b)localObject3).a == null) {
            continue;
          }
          localObject1 = Integer.valueOf(((bf.b)localObject3).a.size());
          localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" ");
          if (((bf.b)localObject3).b == null) {
            continue;
          }
          localObject1 = Integer.valueOf(((bf.b)localObject3).b.size());
          Log.d(localObject1);
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          Object localObject1;
          Log.w("exception while waiting on task killers thread to finish during onCreate " + localException);
          Object localObject2 = null;
          continue;
          Object localObject3 = new StringBuilder();
          localObject2 = ((bf.b)localObject2).a.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          Object localObject4 = (bf.a)((Iterator)localObject2).next();
          ((StringBuilder)localObject3).append('\t').append(((bf.a)localObject4).a).append('\n');
          continue;
          ((StringBuilder)localObject3).setLength(((StringBuilder)localObject3).length() - 1);
          localObject2 = ((StringBuilder)localObject3).toString();
          continue;
        }
        if ((localObject1 != null) && (((bf.b)localObject1).a != null) && (!((bf.b)localObject1).a.isEmpty())) {
          continue;
        }
        localObject1 = "";
        return new b.a(this).b(getString(2131297977, new Object[] { localObject1 })).a(p.a(this)).a();
        localObject1 = "null";
        continue;
        localObject1 = "null";
      }
    case 6: 
      this.n = a.b;
      return new b.a(this).a(2131296307).b(2131297976).a(false).a(2131296660, q.a(this)).b(2131297331, r.a(this)).a();
    case 7: 
      return new b.a(this).b(2131296604).a(s.a(this)).a();
    }
    this.n = a.c;
    return new b.a(this).a(2131296307).b(2131296603).a(false).a(2131296660, t.a(this)).b(2131297331, k.a(this)).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131297595);
    if (av.d()) {
      paramMenu.add(0, 1, 0, "Reset Recovery");
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    this.o.a();
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 0: 
      this.r.a("eula");
      this.o.a(this, this.r, "eula");
      return true;
    }
    com.whatsapp.r.j();
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    switch (2.a[(this.n - 1)])
    {
    default: 
      return;
    case 1: 
      d.a(this, 6);
      return;
    }
    d.a(this, 8);
  }
  
  static enum a
  {
    public static int[] a()
    {
      return (int[])d.clone();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/EULA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */