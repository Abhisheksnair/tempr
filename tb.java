package com.whatsapp;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.w;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.util.Log;

public final class tb
  extends w
{
  public w a;
  
  public tb(w paramw)
  {
    this.a = paramw;
  }
  
  public final int a(Object paramObject)
  {
    return this.a.a(paramObject);
  }
  
  public final Parcelable a()
  {
    return this.a.a();
  }
  
  public final Object a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a.b() <= 0)
    {
      Log.i("infinitepageadapter/instantiateitem/count is zero");
      return null;
    }
    int i = this.a.b();
    return this.a.a(paramViewGroup, paramInt % i);
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    this.a.a(paramDataSetObserver);
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    this.a.a(paramParcelable, paramClassLoader);
  }
  
  public final void a(ViewGroup paramViewGroup)
  {
    this.a.a(paramViewGroup);
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.a.b() <= 0)
    {
      Log.i("infinitepageadapter/destroyitem/count is zero");
      return;
    }
    int i = this.a.b();
    this.a.a(paramViewGroup, paramInt % i, paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return this.a.a(paramView, paramObject);
  }
  
  public final int b()
  {
    if (this.a.b() > 0) {
      return Integer.MAX_VALUE;
    }
    return this.a.b();
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    this.a.b(paramDataSetObserver);
  }
  
  public final void b(ViewGroup paramViewGroup)
  {
    this.a.b(paramViewGroup);
  }
  
  public final void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.a.b(paramViewGroup, paramInt, paramObject);
  }
  
  public final CharSequence c(int paramInt)
  {
    if (this.a.b() <= 0)
    {
      Log.i("infinitepageadapter/getpagetitle/count is zero");
      return null;
    }
    int i = this.a.b();
    return this.a.c(paramInt % i);
  }
  
  public final void c()
  {
    this.a.c();
  }
  
  public final float d(int paramInt)
  {
    return this.a.d(paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/tb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */