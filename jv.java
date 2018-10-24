package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public final class jv
  extends ig
{
  private final ImageView aa;
  private final ImageView ab;
  private final ImageView ac;
  private final VoiceNoteSeekBar ad;
  private final di.e ae;
  
  jv(Context paramContext, j paramj, di.e parame)
  {
    super(paramContext, paramj);
    this.ae = parame;
    this.aa = ((ImageView)findViewById(2131755467));
    this.ab = ((ImageView)findViewById(2131755589));
    this.ac = ((ImageView)findViewById(2131755645));
    this.ad = ((VoiceNoteSeekBar)findViewById(2131755585));
    r();
  }
  
  private void r()
  {
    if (this.a.e.b) {
      if (this.a.d == 8)
      {
        this.ac.setImageResource(2130840378);
        this.ad.setProgressColor(getContext().getResources().getColor(2131624132));
      }
    }
    for (;;)
    {
      localObject = this.a.b();
      if ((!((MediaData)localObject).transferring) && (!((MediaData)localObject).transferred) && ((!this.a.E) || (!this.a.e.b) || (j.b(this.a.e.a)))) {
        this.ad.setProgressColor(0);
      }
      if (!this.a.e.b) {
        break;
      }
      this.ae.a(this.w.c(), this.aa);
      return;
      this.ac.setImageResource(2130840371);
      this.ad.setProgressColor(getContext().getResources().getColor(2131624134));
      continue;
      if ((this.a.d == 9) || (this.a.d == 10))
      {
        this.ac.setImageResource(2130840378);
        this.ad.setProgressColor(getContext().getResources().getColor(2131624132));
      }
      else
      {
        this.ac.setImageResource(2130840377);
        this.ad.setProgressColor(getContext().getResources().getColor(2131624133));
      }
    }
    ImageView localImageView;
    if (qz.e(this.a.e.a))
    {
      this.ab.setVisibility(0);
      this.aa.setVisibility(8);
      localImageView = this.ab;
    }
    for (Object localObject = this.a.f;; localObject = this.a.e.a)
    {
      this.ae.a(this.F.d((String)localObject), localImageView);
      return;
      this.ab.setVisibility(8);
      this.aa.setVisibility(0);
      localImageView = this.aa;
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
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
  
  public final void a(String paramString)
  {
    String str;
    if ((this.a != null) && (!this.a.e.b))
    {
      boolean bool = qz.e(this.a.e.a);
      if (!bool) {
        break label80;
      }
      str = this.a.f;
      if (paramString.equals(str)) {
        if (!bool) {
          break label94;
        }
      }
    }
    label80:
    label94:
    for (paramString = this.ab;; paramString = this.aa)
    {
      this.ae.a(this.F.d(str), paramString);
      return;
      str = this.a.e.a;
      break;
    }
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903174;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903176;
  }
  
  public final void i()
  {
    super.i();
    r();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */