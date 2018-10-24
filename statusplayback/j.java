package com.whatsapp.statusplayback;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.al;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.data.e;
import com.whatsapp.di;
import com.whatsapp.di.e;
import com.whatsapp.pv;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  final View a;
  public final TextView b;
  public final TextView c;
  public final b d;
  final ant e = ant.a();
  final pv f = pv.a();
  final e g = e.a();
  final aus h = aus.a();
  final di.e i = di.a().b();
  private final atv j = atv.a();
  private final Runnable k = new Runnable()
  {
    public final void run()
    {
      j.this.d.c();
      j.this.a();
    }
  };
  
  public j(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    Object localObject = al.a(this.f, LayoutInflater.from(paramViewGroup.getContext()), 2130903371, paramViewGroup, true);
    RecyclerView localRecyclerView = (RecyclerView)((View)localObject).findViewById(16908298);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramViewGroup.getContext()));
    this.c = ((TextView)((View)localObject).findViewById(16908292));
    localObject = this.c;
    if (this.j.e()) {}
    for (int m = 2131297300;; m = 2131297301)
    {
      ((TextView)localObject).setText(m);
      this.d = new b((byte)0);
      this.b = ((TextView)paramViewGroup.findViewById(2131755177));
      aoa.b(this.b);
      localRecyclerView.setAdapter(this.d);
      return;
    }
  }
  
  public final void a()
  {
    this.a.removeCallbacks(this.k);
    long l;
    if (this.d.a() > 0)
    {
      Iterator localIterator = this.d.c.iterator();
      l = 0L;
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b <= l) {
          break label101;
        }
        l = locala.b;
      }
    }
    label101:
    for (;;)
    {
      break;
      this.a.postDelayed(this.k, l.e(l) - System.currentTimeMillis() + 1000L);
      return;
    }
  }
  
  public static final class a
  {
    public final String a;
    public final long b;
    
    public a(String paramString, long paramLong)
    {
      this.a = paramString;
      this.b = paramLong;
    }
  }
  
  public final class b
    extends RecyclerView.a<j.c>
  {
    public List<j.a> c = new ArrayList();
    
    private b() {}
    
    public final int a()
    {
      return this.c.size();
    }
  }
  
  static final class c
    extends RecyclerView.p
  {
    String n;
    final ImageView o;
    final TextEmojiLabel p;
    final TextView q;
    
    public c(View paramView)
    {
      super();
      this.o = ((ImageView)paramView.findViewById(2131755363));
      this.o.setEnabled(false);
      this.p = ((TextEmojiLabel)paramView.findViewById(2131755397));
      aoa.b(this.p);
      this.q = ((TextView)paramView.findViewById(2131755399));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */