package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.az;
import com.whatsapp.util.h;
import com.whatsapp.util.z;
import java.io.File;

public class ig
  extends jm
{
  private static z<j.b, Integer> ai = new z(250);
  atw O;
  protected final h P = h.a();
  protected final w Q = w.a();
  protected final com.whatsapp.util.b R = com.whatsapp.util.b.a();
  protected final rl S = rl.a();
  private final ImageButton aa = (ImageButton)findViewById(2131755580);
  private final ImageView ab = (ImageView)findViewById(2131755467);
  private final ImageView ac;
  private final ImageView ad;
  private final CircularProgressBar ae;
  private final VoiceNoteSeekBar af;
  private final TextView ag;
  private final TextView ah;
  
  ig(Context paramContext, final j paramj)
  {
    super(paramContext, paramj);
    this.ab.setImageDrawable(android.support.v4.content.b.a(paramContext, 2130837614));
    this.ac = ((ImageView)findViewById(2131755589));
    if (this.ac != null) {
      this.ac.setImageDrawable(android.support.v4.content.b.a(paramContext, 2130837614));
    }
    this.ad = ((ImageView)findViewById(2131755176));
    this.ae = ((CircularProgressBar)findViewById(2131755584));
    this.af = ((VoiceNoteSeekBar)findViewById(2131755585));
    this.ag = ((TextView)findViewById(2131755322));
    this.ah = ((TextView)findViewById(2131755591));
    this.ae.setMax(100);
    this.ae.setProgressBarColor(android.support.v4.content.b.c(paramContext, 2131624069));
    this.ae.setProgressBarBackgroundColor(536870912);
    paramContext = new SeekBar.OnSeekBarChangeListener()
    {
      boolean a;
      
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        this.a = false;
        if ((yx.b(paramj)) && (yx.h()))
        {
          yx.a.c();
          this.a = true;
        }
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        if ((yx.b(paramj)) && (!yx.h()) && (this.a))
        {
          this.a = false;
          yx.a.a(ig.a(ig.this).getProgress());
          yx.a.b();
        }
        ig.q().put(paramj.e, Integer.valueOf(ig.a(ig.this).getProgress()));
      }
    };
    this.af.setOnSeekBarChangeListener(paramContext);
    r();
  }
  
  public static void p()
  {
    ai.clear();
  }
  
  private void r()
  {
    int i = 0;
    final Object localObject1 = this.a.b();
    if (!this.a.e.b)
    {
      if (qz.e(this.a.e.a))
      {
        this.ac.setVisibility(0);
        this.ab.setVisibility(8);
        findViewById(2131755583).setPadding(0, (int)(aoa.a().a * 8.0F), 0, 0);
      }
    }
    else
    {
      this.ag.setVisibility(8);
      this.af.setProgressColor(0);
      if (this.a.w == 0) {
        this.a.w = MediaFileUtils.b(((MediaData)localObject1).file);
      }
      if (!((MediaData)localObject1).transferring) {
        break label234;
      }
      f();
      this.ag.setVisibility(0);
      this.ag.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
      this.aa.setImageResource(2130840293);
      this.aa.setOnClickListener(this.V);
      label179:
      g();
      if (this.a.w == 0) {
        break label718;
      }
    }
    label234:
    label718:
    for (localObject1 = DateUtils.formatElapsedTime(this.a.w);; localObject1 = Formatter.formatShortFileSize(u.a(), this.a.t))
    {
      this.ah.setText((CharSequence)localObject1);
      return;
      this.ac.setVisibility(8);
      this.ab.setVisibility(0);
      break;
      if ((((MediaData)localObject1).transferred) || ((this.a.E) && (this.a.e.b) && (!j.b(this.a.e.a))))
      {
        e();
        this.af.setProgressColor(android.support.v4.content.b.c(getContext(), 2131624084));
        Object localObject2;
        if (!yx.b(this.a))
        {
          if (this.O == null)
          {
            localObject1 = (ViewGroup)findViewById(2131755590);
            if (localObject1 != null)
            {
              this.O = new atw(getContext());
              this.O.setColor(-1);
              ((ViewGroup)localObject1).addView(this.O, -1, -1);
            }
          }
          this.aa.setImageDrawable(new az(android.support.v4.content.b.a(getContext(), 2130840302)));
          this.af.setMax(this.a.w * 1000);
          localObject1 = (Integer)ai.get(this.a.e);
          localObject2 = this.af;
          if (localObject1 != null) {}
          for (i = ((Integer)localObject1).intValue();; i = 0)
          {
            ((VoiceNoteSeekBar)localObject2).setProgress(i);
            t();
            this.aa.setOnClickListener(this.W);
            break;
          }
        }
        localObject1 = yx.a;
        if (!((yx)localObject1).f())
        {
          this.aa.setImageDrawable(new az(android.support.v4.content.b.a(getContext(), 2130840302)));
          localObject2 = (Integer)ai.get(this.a.e);
          VoiceNoteSeekBar localVoiceNoteSeekBar = this.af;
          if (localObject2 != null) {
            i = ((Integer)localObject2).intValue();
          }
          localVoiceNoteSeekBar.setProgress(i);
          t();
        }
        for (;;)
        {
          this.af.setMax(((yx)localObject1).d);
          if (this.O != null) {
            ((yx)localObject1).e = new ih(this);
          }
          ((yx)localObject1).c = new yx.b()
          {
            int a = -1;
            
            public final void a()
            {
              if (!localObject1.a(ig.this.a)) {
                return;
              }
              ig.b(ig.this).setImageResource(2130840299);
              ig.a(ig.this).setMax(localObject1.d);
              ig.q().remove(ig.this.a.e);
              this.a = -1;
              ig.c(ig.this);
            }
            
            public final void a(int paramAnonymousInt)
            {
              if (!localObject1.a(ig.this.a)) {
                return;
              }
              if (this.a != paramAnonymousInt / 1000)
              {
                this.a = (paramAnonymousInt / 1000);
                ig.d(ig.this).setText(DateUtils.formatElapsedTime(this.a));
              }
              ig.a(ig.this).setProgress(paramAnonymousInt);
            }
            
            public final void a(boolean paramAnonymousBoolean)
            {
              if (!localObject1.k()) {
                ig.a(ig.this, paramAnonymousBoolean);
              }
            }
            
            public final void b()
            {
              if (!localObject1.a(ig.this.a)) {
                return;
              }
              ig.b(ig.this).setImageDrawable(new az(android.support.v4.content.b.a(ig.this.getContext(), 2130840302)));
              if (ig.this.a.w != 0) {
                ig.d(ig.this).setText(DateUtils.formatElapsedTime(ig.this.a.w));
              }
              for (;;)
              {
                if (!ig.q().containsKey(ig.this.a.e))
                {
                  ig.a(ig.this).setProgress(0);
                  ig.q().remove(ig.this.a.e);
                }
                ig.e(ig.this);
                ig.a(ig.this, false);
                return;
                ig.d(ig.this).setText(DateUtils.formatElapsedTime(localObject1.d / 1000));
              }
            }
            
            public final void c()
            {
              if (!localObject1.a(ig.this.a)) {
                return;
              }
              ig.b(ig.this).setImageResource(2130840299);
              ig.q().remove(ig.this.a.e);
              ig.c(ig.this);
            }
            
            public final void d()
            {
              if (!localObject1.a(ig.this.a)) {
                return;
              }
              ig.q().put(ig.this.a.e, Integer.valueOf(localObject1.e()));
              ig.b(ig.this).setImageDrawable(new az(android.support.v4.content.b.a(ig.this.getContext(), 2130840302)));
              this.a = (localObject1.e() / 1000);
              ig.d(ig.this).setText(DateUtils.formatElapsedTime(this.a));
              ig.a(ig.this).setProgress(localObject1.e());
              ig.e(ig.this);
            }
          };
          break;
          this.aa.setImageResource(2130840299);
          this.af.setProgress(((yx)localObject1).e());
          s();
        }
      }
      f();
      this.ag.setVisibility(0);
      this.ag.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
      if ((this.a.e.b) && (((MediaData)localObject1).file != null))
      {
        this.aa.setImageResource(2130840305);
        this.aa.setOnClickListener(this.U);
        break label179;
      }
      this.aa.setImageResource(2130840296);
      this.aa.setOnClickListener(this.T);
      break label179;
    }
  }
  
  private void s()
  {
    if (this.O != null) {
      this.O.setVisibility(0);
    }
    if (this.ad != null) {
      this.ad.setVisibility(8);
    }
  }
  
  private void t()
  {
    if (this.O != null) {
      this.O.setVisibility(8);
    }
    if (this.ad != null) {
      this.ad.setVisibility(0);
    }
  }
  
  public void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        r();
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.e.b) {
      if (paramString.equals(this.w.c().t)) {
        h();
      }
    }
    for (;;)
    {
      return;
      if (qz.e(this.a.e.a)) {}
      for (String str = this.a.f; paramString.equals(str); str = this.a.e.a)
      {
        h();
        return;
      }
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final void b()
  {
    Log.i("conversationrowvoicenote/viewmessage " + this.a.e);
    Object localObject = this.a.b();
    if (((MediaData)localObject).transferring) {}
    do
    {
      return;
      if (((MediaData)localObject).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
      {
        this.l.b(getContext(), 2131296829, 1);
        return;
      }
      if ((!((MediaData)localObject).transferred) || (((MediaData)localObject).file == null)) {
        break;
      }
      localObject = new File(Uri.fromFile(((MediaData)localObject).file).getPath());
      if ((((File)localObject).exists()) && (((File)localObject).canRead())) {
        break;
      }
    } while (!(getContext() instanceof nh));
    this.l.a((nh)getContext());
    return;
    if (yx.b(this.a)) {
      localObject = yx.a;
    }
    for (;;)
    {
      Integer localInteger = (Integer)ai.get(this.a.e);
      if (localInteger != null) {
        ((yx)localObject).a(localInteger.intValue());
      }
      if (this.O != null) {
        ((yx)localObject).e = new ii(this);
      }
      ((yx)localObject).a();
      i();
      return;
      localObject = new yx((Activity)getContext(), this.l, this.P, this.Q, this.E, this.G, this.R, this.S);
      ((yx)localObject).b = this.a;
    }
  }
  
  public final void g()
  {
    a(this.ae, this.a.b());
  }
  
  protected int getCenteredLayoutId()
  {
    return 2130903136;
  }
  
  protected int getIncomingLayoutId()
  {
    return 2130903136;
  }
  
  protected int getOutgoingLayoutId()
  {
    return 2130903137;
  }
  
  public void i()
  {
    super.i();
    r();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */