package com.whatsapp.emoji.search;

import android.support.v7.widget.RecyclerView.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.whatsapp.al;
import com.whatsapp.emoji.a;
import com.whatsapp.pv;

public final class c
  extends RecyclerView.p
{
  final i.a n;
  final ViewGroup o;
  final ImageView p;
  a q;
  
  public c(pv parampv, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, i.a parama, int paramInt)
  {
    super(al.a(parampv, paramLayoutInflater, 2130903219, paramViewGroup, false));
    this.n = parama;
    parampv = this.a.getLayoutParams();
    parampv.height = paramInt;
    this.a.setLayoutParams(parampv);
    this.o = ((ViewGroup)this.a.findViewById(2131755767));
    this.p = ((ImageView)this.a.findViewById(2131755768));
    this.o.setVisibility(0);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */