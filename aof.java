package com.whatsapp;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.r;
import android.support.v4.f.e;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public abstract class aof
  extends android.support.v4.view.w
{
  private final r a;
  private android.support.v4.app.w b = null;
  private Fragment c = null;
  private final e<Fragment> d = new e();
  private final e<Fragment.SavedState> e = new e();
  
  public aof(r paramr)
  {
    this.a = paramr;
  }
  
  public final Parcelable a()
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if (this.e.a() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new long[this.e.a()];
      i = 0;
      while (i < this.e.a())
      {
        localObject3 = (Fragment.SavedState)this.e.c(i);
        localObject2[i] = this.e.b(i);
        ((Bundle)localObject1).putParcelable(Long.toString(localObject2[i]), (Parcelable)localObject3);
        i += 1;
      }
      ((Bundle)localObject1).putLongArray("states", (long[])localObject2);
    }
    int i = j;
    while (i < this.d.a())
    {
      localObject3 = (Fragment)this.d.c(i);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((Fragment)localObject3).o())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = "f" + this.d.b(i);
          this.a.a((Bundle)localObject2, (String)localObject1, (Fragment)localObject3);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (Parcelable)localObject1;
  }
  
  public abstract Fragment a(int paramInt);
  
  public final Object a(ViewGroup paramViewGroup, int paramInt)
  {
    long l = b(paramInt);
    Fragment localFragment = (Fragment)this.d.a(l);
    if (localFragment != null) {
      return localFragment;
    }
    if (this.b == null) {
      this.b = this.a.a();
    }
    localFragment = a(paramInt);
    Fragment.SavedState localSavedState = (Fragment.SavedState)this.e.a(l);
    if (localSavedState != null) {
      localFragment.a(localSavedState);
    }
    localFragment.b(false);
    localFragment.c(false);
    this.d.a(l, localFragment);
    this.b.a(paramViewGroup.getId(), localFragment, "f" + l);
    return localFragment;
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getLongArray("states");
      this.e.b();
      this.d.b();
      if (paramClassLoader != null)
      {
        int j = paramClassLoader.length;
        int i = 0;
        while (i < j)
        {
          long l = paramClassLoader[i];
          this.e.a(l, (Fragment.SavedState)paramParcelable.getParcelable(Long.toString(l)));
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          Fragment localFragment = this.a.a(paramParcelable, str);
          if (localFragment != null)
          {
            localFragment.b(false);
            this.d.a(Long.parseLong(str.substring(1)), localFragment);
          }
          else
          {
            Log.w("FragmentPagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramInt = a(paramViewGroup);
    int i = this.d.a(paramViewGroup);
    long l = -1L;
    if (i != -1)
    {
      l = this.d.b(i);
      this.d.a(i);
    }
    if ((paramViewGroup.o()) && (paramInt != -2)) {
      this.e.a(l, this.a.a(paramViewGroup));
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = this.a.a();
      }
      this.b.a(paramViewGroup);
      return;
      this.e.c(l);
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).x() == paramView;
  }
  
  public long b(int paramInt)
  {
    return paramInt;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (this.b != null)
    {
      this.b.f();
      this.b = null;
    }
  }
  
  public final void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.c)
    {
      if (this.c != null)
      {
        this.c.b(false);
        this.c.c(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.b(true);
        paramViewGroup.c(true);
      }
      this.c = paramViewGroup;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */