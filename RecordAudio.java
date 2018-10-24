package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.b.a;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.whatsapp.data.l;
import com.whatsapp.o.a;
import com.whatsapp.protocol.j;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.f;
import com.whatsapp.util.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecordAudio
  extends nh
{
  private Button A;
  private Button B;
  private View C;
  private String D;
  private final ahx E = ahx.a();
  private final l F = l.a();
  private final bb G = bb.a();
  int n = 0;
  long o;
  a p;
  f q;
  ImageButton r;
  ProgressBar s;
  SeekBar t;
  File u;
  boolean v;
  Handler w;
  final h x = h.a();
  private TextView y;
  private TextView z;
  
  private void p()
  {
    this.p = a.a(MediaFileUtils.a(this, this.au, "", (byte)2, 0, false).getAbsolutePath(), "audio/ogg; codecs=opus");
    this.y.setText(DateUtils.formatElapsedTime(900L));
    this.z.setText(DateUtils.formatElapsedTime(0L));
  }
  
  public final void c(int paramInt)
  {
    if ((paramInt == 2131296754) || (paramInt == 2131296742) || (paramInt == 2131296813)) {
      finish();
    }
  }
  
  final void d(int paramInt)
  {
    int j = 0;
    int i = 0;
    SeekBar localSeekBar;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.A.setText(2131297510);
      this.B.setVisibility(0);
      this.C.setVisibility(0);
      this.r.setVisibility(8);
      this.z.setVisibility(0);
      this.s.setVisibility(0);
      this.t.setVisibility(4);
      this.s.setProgress(0);
      return;
    case 1: 
      this.A.setText(2131297512);
      this.B.setVisibility(8);
      this.C.setVisibility(8);
      this.r.setVisibility(8);
      this.z.setVisibility(0);
      this.s.setVisibility(0);
      this.t.setVisibility(4);
      return;
    case 3: 
      this.A.setText(2131297511);
      this.B.setVisibility(0);
      this.C.setVisibility(0);
      this.r.setVisibility(0);
      this.r.setImageResource(2130840400);
      this.z.setVisibility(8);
      this.s.setVisibility(4);
      this.t.setVisibility(0);
      localSeekBar = this.t;
      paramInt = i;
      if (this.q != null) {
        paramInt = this.q.g();
      }
      localSeekBar.setMax(paramInt);
      return;
    case 4: 
      this.A.setText(2131297511);
      this.B.setVisibility(0);
      this.C.setVisibility(0);
      this.r.setVisibility(0);
      this.r.setImageResource(2130840401);
      this.z.setVisibility(8);
      this.s.setVisibility(4);
      this.t.setVisibility(0);
      localSeekBar = this.t;
      paramInt = j;
      if (this.q != null) {
        paramInt = this.q.g();
      }
      localSeekBar.setMax(paramInt);
      return;
    }
    this.r.setImageResource(2130840401);
  }
  
  final void l()
  {
    for (;;)
    {
      try
      {
        long l = getIntent().getLongExtra("quoted_message_row_id", 0L);
        if (l == 0L) {
          continue;
        }
        localj = this.F.a(l);
        this.E.a(this.D, this.u, this.v, localj, false);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        j localj;
        Log.e(localFileNotFoundException);
        pv.a(getBaseContext(), 2131297841, 0);
        continue;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
        if ((localIOException.getMessage() == null) || (!localIOException.getMessage().contains("No space"))) {
          continue;
        }
        pv.a(getBaseContext(), 2131296742, 1);
        continue;
        pv.a(getBaseContext(), 2131297841, 1);
        continue;
      }
      if ((this.q != null) && (this.q.e())) {
        this.q.c();
      }
      finish();
      return;
      localj = null;
    }
  }
  
  final void m()
  {
    if (this.p != null) {}
    try
    {
      this.p.c();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.p.d();
          this.p = null;
          this.s.setProgress(this.s.getMax());
          n();
          return;
          localException1 = localException1;
          Log.e(localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e(localException2);
        }
      }
    }
  }
  
  final void n()
  {
    try
    {
      if (this.q != null)
      {
        this.q.h();
        this.q = null;
      }
      this.q = f.a(this.u, 3);
      this.q.a(adu.a());
      this.q.a(adv.a());
      this.q.a();
      Log.i("recordaudio/prepare audio duration:" + this.q.g());
      this.n = 5;
      this.t.setMax(this.q.g());
      this.y.setText(DateUtils.formatElapsedTime(this.q.g() / 1000));
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e(localIOException);
        b_(2131296813);
      }
    }
    this.t.setProgress(0);
    this.r.setImageResource(2130840401);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        p();
        return;
      }
      finish();
      Log.i("recordaudio/closing due to lack of permissions");
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    b(1);
    super.onCreate(paramBundle);
    setContentView(2130903344);
    Log.i("recordaudio/create");
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      finish();
    }
    do
    {
      return;
      if ((this.ar.b == null) || (!this.G.b()))
      {
        finish();
        return;
      }
    } while (!this.aI.a(new vv.a()
    {
      public final void a()
      {
        d.a(RecordAudio.this, 0);
      }
      
      public final void b()
      {
        d.a(RecordAudio.this, 0);
      }
      
      public final void c()
      {
        RequestPermissionActivity.b(RecordAudio.this, 2131297439, 2131297436);
      }
      
      public final void d()
      {
        RequestPermissionActivity.b(RecordAudio.this, 2131297439, 2131297436);
      }
    }));
    this.v = getIntent().getBooleanExtra("playback_only", false);
    this.D = getIntent().getStringExtra("jid");
    this.y = ((TextView)findViewById(2131756057));
    this.z = ((TextView)findViewById(2131756055));
    this.B = ((Button)findViewById(2131756060));
    this.C = findViewById(2131756059);
    this.r = ((ImageButton)findViewById(2131756054));
    this.A = ((Button)findViewById(2131756058));
    this.s = ((ProgressBar)findViewById(2131756056));
    this.t = ((SeekBar)findViewById(2131755585));
    this.t.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          RecordAudio.a(RecordAudio.this).setText(DateUtils.formatElapsedTime(paramAnonymousInt / 1000));
        }
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        if ((RecordAudio.b(RecordAudio.this) != null) && (RecordAudio.b(RecordAudio.this).e())) {
          RecordAudio.b(RecordAudio.this).d();
        }
        RecordAudio.c(RecordAudio.this).removeMessages(0);
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        if ((RecordAudio.b(RecordAudio.this) == null) || (RecordAudio.d(RecordAudio.this) == 3)) {}
        try
        {
          RecordAudio.b(RecordAudio.this).a(paramAnonymousSeekBar.getProgress());
          RecordAudio.b(RecordAudio.this).b();
          RecordAudio.c(RecordAudio.this).sendEmptyMessage(0);
          RecordAudio.e(RecordAudio.this).setImageResource(2130840400);
          return;
        }
        catch (IllegalStateException paramAnonymousSeekBar)
        {
          RecordAudio.this.b_(2131296813);
          return;
          paramAnonymousSeekBar.setProgress(0);
          return;
        }
        catch (IOException paramAnonymousSeekBar)
        {
          for (;;) {}
        }
      }
    });
    if (this.v)
    {
      paramBundle = getIntent().getStringExtra("file_path");
      this.u = new File(paramBundle);
      Conversation.l locall = Conversation.l();
      if (locall.b) {
        locall.a().O = true;
      }
      this.A.setText(2131297656);
      findViewById(2131756053).setVisibility(0);
      ((TextView)findViewById(2131755474)).setText(2131297481);
      ((TextView)findViewById(2131756053)).setText(this.u.getName());
      Log.i("recordaudio/playback_file:" + paramBundle);
      n();
      this.n = 4;
      d(this.n);
      this.B.setOnClickListener(adr.a(this));
      this.A.setOnClickListener(ads.a(this));
      this.r.setOnClickListener(adt.a(this));
      this.w = new Handler(Looper.getMainLooper())
      {
        int a = 0;
        
        public final void handleMessage(Message paramAnonymousMessage)
        {
          int i;
          if (RecordAudio.d(RecordAudio.this) == 3)
          {
            i = RecordAudio.b(RecordAudio.this).f();
            if (i / 1000 != this.a)
            {
              RecordAudio.a(RecordAudio.this).setText(DateUtils.formatElapsedTime(i / 1000));
              this.a = (i / 1000);
            }
            RecordAudio.f(RecordAudio.this).setProgress(i);
            RecordAudio.g(RecordAudio.this).setProgress(i);
            i = 0;
          }
          while ((i == 0) && (!RecordAudio.this.isFinishing()) && (((RecordAudio.d(RecordAudio.this) == 3) && (RecordAudio.b(RecordAudio.this).e())) || (RecordAudio.d(RecordAudio.this) == 1)))
          {
            RecordAudio.c(RecordAudio.this).sendEmptyMessageDelayed(0, 50L);
            return;
            if (RecordAudio.d(RecordAudio.this) == 1)
            {
              long l1 = System.currentTimeMillis() - RecordAudio.h(RecordAudio.this);
              if (l1 > 900000L)
              {
                RecordAudio.i(RecordAudio.this);
                RecordAudio.j(RecordAudio.this);
                RecordAudio.a(RecordAudio.this, RecordAudio.d(RecordAudio.this));
                i = 1;
              }
              else
              {
                long l2 = l1 / 1000L;
                RecordAudio.a(RecordAudio.this).setText(DateUtils.formatElapsedTime(900L - l2));
                RecordAudio.k(RecordAudio.this).setText(DateUtils.formatElapsedTime(l2));
                RecordAudio.f(RecordAudio.this).setProgress((int)l1);
              }
            }
            else
            {
              i = 0;
            }
          }
          if (RecordAudio.d(RecordAudio.this) == 3) {
            RecordAudio.g(RecordAudio.this).setProgress(0);
          }
          for (;;)
          {
            RecordAudio.j(RecordAudio.this);
            RecordAudio.a(RecordAudio.this, RecordAudio.d(RecordAudio.this));
            return;
            if (RecordAudio.d(RecordAudio.this) == 1) {
              RecordAudio.f(RecordAudio.this).setProgress(RecordAudio.f(RecordAudio.this).getMax());
            }
          }
        }
      };
      return;
    }
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getCharSequence("external_file_path");; paramBundle = null)
    {
      if (paramBundle != null)
      {
        this.u = new File(paramBundle.toString());
        this.s.setProgress(this.s.getMax());
        n();
        this.o = 0L;
        this.n = 4;
      }
      while (vv.f() < aic.s << 10 << 10)
      {
        Log.w("recordaudio/create/no-space");
        b_(2131296742);
        return;
        if ((!this.v) && (this.aP.a("android.permission.RECORD_AUDIO") != 0)) {
          startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_id", 2130840440).putExtra("permissions", new String[] { "android.permission.RECORD_AUDIO" }).putExtra("message_id", 2131297387).putExtra("perm_denial_message_id", 2131297386), 1);
        } else {
          p();
        }
      }
      break;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    b.a locala = new b.a(this);
    if (vv.i())
    {
      paramInt = 2131297515;
      locala = locala.a(paramInt);
      if (!vv.i()) {
        break label87;
      }
    }
    label87:
    for (paramInt = 2131297513;; paramInt = 2131297514)
    {
      return locala.b(paramInt).a(2131297331, adw.a(this)).a();
      paramInt = 2131297516;
      break;
    }
  }
  
  public void onDestroy()
  {
    Log.i("recordaudio/destroy");
    super.onDestroy();
    if (this.n == 1) {
      Log.i("recordaudio/destroy/stoprecorder");
    }
    try
    {
      if (this.p != null) {
        this.p.c();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.p != null) {
            this.p.d();
          }
          if (this.q != null)
          {
            if (this.q.e())
            {
              Log.i("recordaudio/destroy/stopplayer");
              this.q.c();
            }
            this.q.h();
          }
          return;
          localException1 = localException1;
          Log.e(localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e(localException2);
        }
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((this.n != 0) && (this.u != null) && (!this.v)) {
      paramBundle.putCharSequence("external_file_path", this.u.getAbsolutePath());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (Voip.e())
    {
      if (this.n != 1) {
        break label42;
      }
      Log.i("recordaudio/onStop stop recording for WhatsApp call");
      m();
      this.n = 4;
      d(this.n);
    }
    label42:
    while ((this.n != 3) || (!this.q.e())) {
      return;
    }
    Log.i("recordaudio/onStop stop playing for WhatsApp call");
    this.w.removeMessages(0);
    this.q.d();
    this.n = 5;
    d(this.n);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/RecordAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */