package com.whatsapp;

import android.support.v4.app.n;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.ad;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab
  extends kd
{
  private final ad an = ad.a();
  private final lt ao = lt.a();
  
  protected final void R()
  {
    this.ac.setVisibility(8);
    this.ab.setVisibility(8);
    this.aa.setVisibility(8);
  }
  
  public final void S()
  {
    super.S();
    if (this.ao.e() == 0) {
      l().finish();
    }
  }
  
  protected final ArrayList<kd.k> c()
  {
    Object localObject = this.ao.d();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new kd.d((String)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  protected final void c(View paramView)
  {
    super.c(paramView);
    if (this.ao.e() != 0)
    {
      final int i = paramView.getTop();
      b().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          ab.this.b().getViewTreeObserver().removeGlobalOnLayoutListener(this);
          ab.this.d(i);
        }
      });
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */