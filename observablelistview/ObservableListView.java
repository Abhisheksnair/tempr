package com.whatsapp.observablelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.f.a;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.whatsapp.f.c;
import com.whatsapp.f.d;
import com.whatsapp.f.e;

public class ObservableListView
  extends ListView
  implements f.a, c, b.a
{
  private int a;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  private SparseIntArray f;
  private a g;
  private b h;
  private e i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  private MotionEvent n;
  private ViewGroup o;
  private AbsListView.OnScrollListener p;
  private AbsListView.OnScrollListener q = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (ObservableListView.a(ObservableListView.this) != null) {
        ObservableListView.a(ObservableListView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
      ObservableListView.c(ObservableListView.this);
    }
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if (ObservableListView.a(ObservableListView.this) != null) {
        ObservableListView.a(ObservableListView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
      }
      if ((ObservableListView.b(ObservableListView.this) != null) && (paramAnonymousInt == 0)) {
        ObservableListView.b(ObservableListView.this).a(ObservableListView.this);
      }
    }
  };
  
  public ObservableListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ObservableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ObservableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.f = new SparseIntArray();
    this.h = new b();
    this.i = new e();
    super.setOnScrollListener(this.q);
  }
  
  public final void a(d paramd)
  {
    this.i.a(paramd);
  }
  
  public final void a(b.b paramb)
  {
    this.h.a(paramb);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.i.a();
  }
  
  public int getCurrentScrollY()
  {
    return this.e;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.g != null) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.l = true;
      this.k = true;
      continue;
      this.l = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h.a();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h.b();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    this.a = paramParcelable.a;
    this.b = paramParcelable.b;
    this.c = paramParcelable.c;
    this.d = paramParcelable.d;
    this.e = paramParcelable.e;
    this.f = paramParcelable.f;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), (byte)0);
    localSavedState.a = this.a;
    localSavedState.b = this.b;
    localSavedState.c = this.c;
    localSavedState.d = this.d;
    localSavedState.e = this.e;
    localSavedState.f = this.f;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if (this.g != null) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    float f2;
    float f3;
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.m = false;
        this.l = false;
      }
      if (this.n == null) {
        this.n = paramMotionEvent;
      }
      f2 = paramMotionEvent.getY();
      f3 = this.n.getY();
      this.n = MotionEvent.obtainNoHistory(paramMotionEvent);
    } while (getCurrentScrollY() - (f2 - f3) > 0.0F);
    if (this.m) {
      return false;
    }
    if (this.o == null) {}
    for (final ViewGroup localViewGroup = (ViewGroup)getParent();; localViewGroup = this.o)
    {
      localObject = this;
      f2 = 0.0F;
      while ((localObject != null) && (localObject != localViewGroup))
      {
        f2 += ((View)localObject).getLeft() - ((View)localObject).getScrollX();
        f1 += ((View)localObject).getTop() - ((View)localObject).getScrollY();
        localObject = (View)((View)localObject).getParent();
      }
    }
    final Object localObject = MotionEvent.obtainNoHistory(paramMotionEvent);
    ((MotionEvent)localObject).offsetLocation(f2, f1);
    if (localViewGroup.onInterceptTouchEvent((MotionEvent)localObject))
    {
      this.m = true;
      ((MotionEvent)localObject).setAction(0);
      post(new Runnable()
      {
        public final void run()
        {
          localViewGroup.dispatchTouchEvent(localObject);
        }
      });
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.p = paramOnScrollListener;
  }
  
  public void setScrollViewCallbacks(a parama)
  {
    this.g = parama;
  }
  
  public void setTouchInterceptionViewGroup(ViewGroup paramViewGroup)
  {
    this.o = paramViewGroup;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int a;
    int b = -1;
    int c;
    int d;
    int e;
    SparseIntArray f;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = new SparseIntArray();
      int j = paramParcel.readInt();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          int k = paramParcel.readInt();
          int m = paramParcel.readInt();
          this.f.put(k, m);
          i += 1;
        }
      }
    }
    
    private SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 0;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      if (this.f == null) {}
      for (paramInt = 0;; paramInt = this.f.size())
      {
        paramParcel.writeInt(paramInt);
        if (paramInt <= 0) {
          break;
        }
        while (i < paramInt)
        {
          paramParcel.writeInt(this.f.keyAt(i));
          paramParcel.writeInt(this.f.valueAt(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/observablelistview/ObservableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */