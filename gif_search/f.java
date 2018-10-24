package com.whatsapp.gif_search;

import a.a.a.a.d;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.and;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i;
import com.whatsapp.emoji.search.i.c;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.events.ad;
import com.whatsapp.fieldstats.l;
import com.whatsapp.pv;
import com.whatsapp.util.InterceptingEditText;

public final class f
  extends i
{
  final pv f = pv.a();
  final and g = and.a();
  public a h;
  private final GifSearchContainer i;
  private final Activity j;
  
  public f(final GifSearchContainer paramGifSearchContainer, EmojiSearchContainer paramEmojiSearchContainer, final a parama, final Activity paramActivity)
  {
    super(paramEmojiSearchContainer, parama, paramActivity);
    this.i = paramGifSearchContainer;
    this.j = paramActivity;
    parama.u = new b()
    {
      public final void a(j paramAnonymousj)
      {
        if (f.this.h != null) {
          f.this.h.a(paramAnonymousj);
        }
      }
      
      public final void a(p paramAnonymousp)
      {
        Object localObject = paramGifSearchContainer;
        f localf = f.this;
        pv localpv = f.this.f;
        and localand = f.this.g;
        Activity localActivity = paramActivity;
        g localg = new g(this, paramAnonymousp);
        ((GifSearchContainer)localObject).e = paramAnonymousp;
        ((GifSearchContainer)localObject).d = localActivity;
        ((GifSearchContainer)localObject).a = localpv;
        ((GifSearchContainer)localObject).b = localand;
        ((GifSearchContainer)localObject).m = localg;
        if (!((GifSearchContainer)localObject).c)
        {
          ((GifSearchContainer)localObject).c = true;
          localActivity.getLayoutInflater().inflate(2130903238, (ViewGroup)localObject, true);
          ((GifSearchContainer)localObject).f = ((GifSearchContainer)localObject).findViewById(2131755760);
          ((GifSearchContainer)localObject).h = ((GifSearchContainer)localObject).findViewById(2131755796);
          ((GifSearchContainer)localObject).g = ((RecyclerView)((GifSearchContainer)localObject).findViewById(2131755764));
          int i = ((GifSearchContainer)localObject).getResources().getDimensionPixelSize(2131362083);
          ((GifSearchContainer)localObject).g.a(new GifSearchContainer.1((GifSearchContainer)localObject, i));
          paramAnonymousp = new LinearLayoutManager(localActivity);
          paramAnonymousp.b(0);
          ((GifSearchContainer)localObject).g.setLayoutManager(paramAnonymousp);
          ((GifSearchContainer)localObject).findViewById(2131755797).setOnClickListener(new GifSearchContainer.2((GifSearchContainer)localObject));
          ((GifSearchContainer)localObject).k = ((GifSearchContainer)localObject).findViewById(2131755761);
          ((GifSearchContainer)localObject).i = ((InterceptingEditText)((GifSearchContainer)localObject).findViewById(2131755206));
          ((GifSearchContainer)localObject).i.setHint(localActivity.getString(2131296915, new Object[] { ((GifSearchContainer)localObject).e.d() }));
          ((GifSearchContainer)localObject).i.setOnBackButtonListener(new n(localf));
          paramAnonymousp = ((GifSearchContainer)localObject).findViewById(2131755766);
          paramAnonymousp.setOnClickListener(new GifSearchContainer.3((GifSearchContainer)localObject));
          ((GifSearchContainer)localObject).i.addTextChangedListener(new GifSearchContainer.4((GifSearchContainer)localObject, paramAnonymousp));
          ((GifSearchContainer)localObject).findViewById(2131755439).setOnClickListener(new GifSearchContainer.5((GifSearchContainer)localObject, localf));
        }
        ((GifSearchContainer)localObject).setVisibility(0);
        ((GifSearchContainer)localObject).k.setVisibility(8);
        ((GifSearchContainer)localObject).f.setVisibility(8);
        ((GifSearchContainer)localObject).h.setVisibility(8);
        ((GifSearchContainer)localObject).k.setVisibility(0);
        ((GifSearchContainer)localObject).j = ((GifSearchContainer)localObject).a();
        ((GifSearchContainer)localObject).g.setAdapter(((GifSearchContainer)localObject).j);
        ((GifSearchContainer)localObject).j.b(((GifSearchContainer)localObject).e.b());
        ((GifSearchContainer)localObject).l = "";
        ((GifSearchContainer)localObject).i.setText("");
        ((GifSearchContainer)localObject).i.requestFocus();
        d.a(((GifSearchContainer)localObject).getContext(), false);
        paramAnonymousp = ((GifSearchContainer)localObject).e;
        localObject = new ad();
        ((ad)localObject).a = Integer.valueOf(paramAnonymousp.e());
        l.a(localActivity, (e)localObject);
        parama.t = true;
        if (f.this.e != null) {
          f.this.e.m();
        }
      }
    };
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.i.getVisibility() == 0) {
      this.i.setVisibility(8);
    }
    for (;;)
    {
      if (paramBoolean) {
        d.a(this.j, p.a());
      }
      return;
      if (this.b.getVisibility() == 0) {
        this.b.setVisibility(8);
      }
    }
  }
  
  public final boolean a()
  {
    return (this.i.getVisibility() == 0) || (this.b.getVisibility() == 0);
  }
  
  public final boolean b()
  {
    if (this.i.getVisibility() == 0)
    {
      GifSearchContainer localGifSearchContainer = this.i;
      localGifSearchContainer.setVisibility(8);
      if (localGifSearchContainer.e != null) {
        d.a(localGifSearchContainer.d, localGifSearchContainer.e);
      }
      localGifSearchContainer.e = null;
      if (this.e != null) {
        this.e.n();
      }
    }
    do
    {
      return true;
      if (this.b.getVisibility() != 0) {
        break;
      }
      this.b.a();
    } while (this.e == null);
    this.e.n();
    return true;
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
  }
  
  public static abstract interface b
  {
    public abstract void a(j paramj);
    
    public abstract void a(p paramp);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */