package com.whatsapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TosUpdateActivity
  extends nh
{
  private boolean n;
  private boolean o;
  
  private void l()
  {
    final View localView = findViewById(2131755602);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        localView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int j = localView.getMeasuredHeight();
        int k = TosUpdateActivity.this.findViewById(2131756133).getMeasuredHeight();
        int m = TosUpdateActivity.this.findViewById(2131755524).getMeasuredHeight();
        int n = TosUpdateActivity.this.findViewById(2131756131).getMeasuredHeight();
        View localView = TosUpdateActivity.this.findViewById(2131756132);
        int i = localView.getMeasuredHeight();
        j = j - k - m - n;
        float f = TosUpdateActivity.this.getResources().getDisplayMetrics().density;
        if (j < f * 64.0F)
        {
          localView.setVisibility(8);
          return;
        }
        if (j < i)
        {
          ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.width = j;
            localLayoutParams.height = j;
          }
          localView.setVisibility(0);
          localView.requestLayout();
          return;
        }
        localView.setVisibility(0);
      }
    });
  }
  
  private void m()
  {
    this.n = true;
    finish();
  }
  
  public void finish()
  {
    if (this.n) {
      super.finish();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramInt2 == 0) && (paramIntent != null)) {
      this.o = paramIntent.getBooleanExtra("opt_out", false);
    }
    Log.i("tosupdate/onactivityresult " + this.o);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("tosupdate/create");
    this.al = false;
    this.ak = false;
    super.onCreate(paramBundle);
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903385, null, false));
    int i;
    label100:
    int j;
    if (av.j())
    {
      i = getIntent().getIntExtra("automation_tos_update_stage", 1);
      if (i != 1) {
        break label305;
      }
      long l = this.at.f();
      paramBundle = getString(2131298002, new Object[] { SimpleDateFormat.getDateInstance(1).format(new Date(l)) });
      paramBundle = new SpannableStringBuilder(Html.fromHtml(paramBundle));
      Object localObject1 = (URLSpan[])paramBundle.getSpans(0, paramBundle.length(), URLSpan.class);
      if (localObject1 != null)
      {
        int k = localObject1.length;
        j = 0;
        label140:
        if (j < k)
        {
          Object localObject2 = localObject1[j];
          if (!"read-terms".equals(((URLSpan)localObject2).getURL())) {
            break label316;
          }
          j = paramBundle.getSpanStart(localObject2);
          k = paramBundle.getSpanEnd(localObject2);
          int m = paramBundle.getSpanFlags(localObject2);
          paramBundle.removeSpan(localObject2);
          paramBundle.setSpan(new ClickableSpan()
          {
            public final void onClick(View paramAnonymousView)
            {
              TosUpdateActivity.a(TosUpdateActivity.this);
            }
            
            public final void updateDrawState(TextPaint paramAnonymousTextPaint)
            {
              paramAnonymousTextPaint.setColor(-12417548);
            }
          }, j, k, m);
        }
      }
      localObject1 = (TextView)findViewById(2131756133);
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject1).setText(paramBundle);
      findViewById(2131756135).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          TosUpdateActivity.a(TosUpdateActivity.this);
        }
      });
      if (i != 0) {
        break label323;
      }
      m();
    }
    for (;;)
    {
      paramBundle = (Button)findViewById(2131756134);
      aoa.b(paramBundle);
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          TosUpdateActivity.this.at.a(TosUpdateActivity.c(TosUpdateActivity.this));
          TosUpdateActivity.this.ay.a(TosUpdateActivity.c(TosUpdateActivity.this));
          TosUpdateActivity.b(TosUpdateActivity.this);
        }
      });
      l();
      return;
      i = this.at.b();
      break;
      label305:
      paramBundle = getString(2131298003);
      break label100;
      label316:
      j += 1;
      break label140;
      label323:
      if (i == 1)
      {
        paramBundle = (TextView)findViewById(2131756131);
        if (this.aq.d()) {
          paramBundle.setCompoundDrawablesWithIntrinsicBounds(2130840140, 0, 0, 0);
        }
        for (;;)
        {
          paramBundle.setOnClickListener(new at()
          {
            public final void a(View paramAnonymousView)
            {
              TosUpdateActivity.this.at.l();
              TosUpdateActivity.b(TosUpdateActivity.this);
            }
          });
          break;
          paramBundle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840140, 0);
        }
      }
      findViewById(2131756131).setVisibility(4);
    }
  }
  
  public void onDestroy()
  {
    Log.i("tosupdate/destroy");
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("tosupdate/resume");
    if ((!av.j()) && (this.at.b() == 0)) {
      m();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/TosUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */