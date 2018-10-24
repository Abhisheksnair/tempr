package com.whatsapp.gif_search;

import a.a.a.a.d;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.whatsapp.MediaData;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.fieldstats.events.ac;
import com.whatsapp.pv;
import com.whatsapp.util.at;

public final class l
  extends RecyclerView.p
{
  final ImageView n;
  final View o;
  final h p;
  final ViewGroup q;
  String r;
  final boolean s;
  j t;
  AsyncTask<?, ?, ?> u;
  final s v;
  private final f.a w;
  
  public l(pv parampv, and paramand, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, f.a parama, int paramInt, boolean paramBoolean)
  {
    super(al.a(parampv, paramLayoutInflater, 2130903240, paramViewGroup, false));
    this.w = parama;
    this.p = h.a();
    parampv = this.a.getLayoutParams();
    parampv.height = paramInt;
    this.a.setLayoutParams(parampv);
    this.n = ((ImageView)this.a.findViewById(2131755794));
    this.o = this.a.findViewById(2131755795);
    this.q = ((ViewGroup)this.a.findViewById(2131755793));
    this.s = paramBoolean;
    if ((Build.VERSION.SDK_INT >= 14) && (d.b(this.a.getContext(), paramand) >= 2012))
    {
      parampv = this.a.getContext();
      if (Build.VERSION.SDK_INT < 14) {
        throw new IllegalStateException("Must not be called for old Android versions");
      }
      this.v = new s(parampv);
      this.q.addView(this.v.a, new FrameLayout.LayoutParams(-1, -1));
      this.q.setVisibility(0);
      return;
    }
    this.v = null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */