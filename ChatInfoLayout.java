package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.util.Log;

public class ChatInfoLayout
  extends ViewGroup
{
  View a;
  ListView b;
  private int c;
  private int d;
  private float e;
  private float f;
  private View g;
  private View h;
  private TextView i;
  private CharSequence j;
  private TextView k;
  private View l;
  private ScalingFrameLayout m;
  private int n;
  private int o;
  private boolean p;
  private int q;
  private int r;
  private View.OnClickListener s;
  private final pv t;
  private final ViewTreeObserver.OnGlobalLayoutListener u;
  
  public ChatInfoLayout(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.t = localpv;
      this.u = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          ChatInfoLayout.a(ChatInfoLayout.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          if (ChatInfoLayout.d(ChatInfoLayout.this)) {
            return;
          }
          int i = (int)(ChatInfoLayout.this.getMeasuredWidth() * 0.5625F) - ChatInfoLayout.this.getMeasuredWidth();
          ChatInfoLayout.a(ChatInfoLayout.this).setSelectionFromTop(0, i);
          ChatInfoLayout.this.setScrollPos(i);
        }
      };
      a(paramContext);
      return;
    }
  }
  
  public ChatInfoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (paramAttributeSet = null;; paramAttributeSet = pv.a())
    {
      this.t = paramAttributeSet;
      this.u = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          ChatInfoLayout.a(ChatInfoLayout.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          if (ChatInfoLayout.d(ChatInfoLayout.this)) {
            return;
          }
          int i = (int)(ChatInfoLayout.this.getMeasuredWidth() * 0.5625F) - ChatInfoLayout.this.getMeasuredWidth();
          ChatInfoLayout.a(ChatInfoLayout.this).setSelectionFromTop(0, i);
          ChatInfoLayout.this.setScrollPos(i);
        }
      };
      a(paramContext);
      return;
    }
  }
  
  public ChatInfoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramAttributeSet = null;; paramAttributeSet = pv.a())
    {
      this.t = paramAttributeSet;
      this.u = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          ChatInfoLayout.a(ChatInfoLayout.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          if (ChatInfoLayout.d(ChatInfoLayout.this)) {
            return;
          }
          int i = (int)(ChatInfoLayout.this.getMeasuredWidth() * 0.5625F) - ChatInfoLayout.this.getMeasuredWidth();
          ChatInfoLayout.a(ChatInfoLayout.this).setSelectionFromTop(0, i);
          ChatInfoLayout.this.setScrollPos(i);
        }
      };
      a(paramContext);
      return;
    }
  }
  
  private void a(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(2130772044, localTypedValue, true)) {
      this.c = TypedValue.complexToDimensionPixelSize(localTypedValue.data, getResources().getDisplayMetrics());
    }
    this.e = getResources().getDimensionPixelSize(2131361915);
    this.d = 0;
  }
  
  public final void a()
  {
    this.g = findViewById(2131755469);
    this.h = findViewById(2131755470);
    this.i = ((TextView)findViewById(2131755460));
    this.m = ((ScalingFrameLayout)findViewById(2131755471));
    this.k = ((TextView)findViewById(2131755461));
    this.a = findViewById(2131755386);
    this.b = ((ListView)findViewById(16908298));
    this.l = findViewById(2131755462);
    this.f = this.i.getTextSize();
    Display localDisplay = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
    int i1 = localDisplay.getWidth();
    int i2 = localDisplay.getHeight();
    this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.min(i1, i2)));
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        ChatInfoLayout.a(ChatInfoLayout.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ChatInfoLayout.b(ChatInfoLayout.this);
      }
    });
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, Adapter paramAdapter)
  {
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(ca.a(this, paramView1, paramAdapter, paramView2, paramView3));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("contactinfolayout/onLayout:" + paramInt1 + " " + paramInt2 + " " + paramInt3 + " " + paramInt4 + " headerHeight:" + this.n);
    if (paramInt4 - paramInt2 > paramInt3 - paramInt1)
    {
      this.a.layout(paramInt1, paramInt2, paramInt3, this.a.getMeasuredHeight() + paramInt2);
      this.b.layout(this.d + paramInt1, paramInt2, paramInt3 - this.d, paramInt4);
      return;
    }
    if (this.t.a)
    {
      this.b.layout(this.d + paramInt1, paramInt2, this.b.getMeasuredWidth() + paramInt1, paramInt4);
      this.a.layout(this.b.getMeasuredWidth() + paramInt1 + this.d, paramInt2, paramInt3, paramInt4);
      return;
    }
    this.a.layout(paramInt1, paramInt2, this.a.getMeasuredWidth() + paramInt1, paramInt4);
    this.b.layout(this.a.getMeasuredWidth() + paramInt1 + this.d, paramInt2, paramInt3 - this.d, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    int i1 = getMeasuredHeight();
    Log.d("contactinfolayout/onMeasure:" + paramInt1 + "x" + i1 + " headerHeight:" + this.n);
    if (i1 >= paramInt1)
    {
      if (this.l.getVisibility() != 0)
      {
        this.g.setOnClickListener(null);
        this.g.setClickable(false);
        this.l.setVisibility(0);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(this.u);
      }
      this.a.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(this.c, this.n), 1073741824));
      this.b.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824) - this.d * 2, paramInt2);
      return;
    }
    if (this.l.getVisibility() != 8)
    {
      this.g.setOnClickListener(this.s);
      this.g.setClickable(true);
      this.i.setOnClickListener(this.s);
      this.k.setOnClickListener(this.s);
      this.l.setVisibility(8);
      this.b.post(cb.a(this));
    }
    this.a.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - (int)(paramInt1 * 0.618F), 1073741824), paramInt2);
    this.b.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 0.618F) - this.d * 2, 1073741824), paramInt2);
  }
  
  public void setColor(int paramInt)
  {
    this.o = (this.o & 0xFF000000 | 0xFFFFFF & paramInt);
    this.g.setBackgroundColor(this.o);
  }
  
  public void setOnPhotoClickListener(View.OnClickListener paramOnClickListener)
  {
    this.s = paramOnClickListener;
    this.l.setOnClickListener(paramOnClickListener);
  }
  
  public void setScrollPos(int paramInt)
  {
    if (getWidth() >= getHeight())
    {
      if (!this.p)
      {
        Log.d("contactinfolayout/landscape");
        this.p = true;
        this.l.setVisibility(8);
        this.g.setBackgroundColor(0);
        this.m.setScale(1.0F);
        this.i.setSingleLine(false);
        this.i.setEllipsize(null);
        this.k.setSingleLine(false);
        al.a(this.t, this.h, 0, 0);
      }
      return;
    }
    if (this.p)
    {
      Log.d("contactinfolayout/portrait");
      this.n = 0;
    }
    this.p = false;
    if (this.l.getVisibility() != 0) {
      this.l.setVisibility(0);
    }
    Log.d("contactinfolayout/setScrollPos:" + paramInt);
    paramInt = Math.max(this.c, getWidth() + paramInt);
    int i1 = (int)(getWidth() * 0.5625F);
    float f1 = Math.max(0.0F, (i1 - paramInt) / (i1 - this.c));
    TextUtils.TruncateAt localTruncateAt = this.i.getEllipsize();
    if (paramInt < this.c << 1)
    {
      this.i.setSingleLine(true);
      this.i.setEllipsize(TextUtils.TruncateAt.END);
      this.k.setSingleLine(true);
    }
    for (;;)
    {
      if (localTruncateAt != this.i.getEllipsize()) {
        this.i.setText(this.j);
      }
      if (this.n != paramInt) {
        break;
      }
      Log.d("contactinfolayout/setScrollPos return");
      return;
      this.i.setSingleLine(false);
      this.i.setEllipsize(null);
      this.k.setSingleLine(false);
    }
    this.n = paramInt;
    i1 = this.o >> 24;
    if (paramInt == this.c) {
      if (i1 != -1)
      {
        this.i.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        this.k.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
    }
    for (;;)
    {
      paramInt = (int)(255.0F * f1);
      i1 = (int)(this.q * f1 * f1);
      int i2 = (int)(this.r * f1 * f1);
      f1 = (this.f - f1 * (this.f - this.e)) / this.f;
      this.m.setScale(f1);
      this.o = (paramInt << 24 | this.o & 0xFFFFFF);
      this.g.setBackgroundColor(this.o);
      al.a(this.t, this.h, i1, i2);
      requestLayout();
      return;
      if (i1 == -1)
      {
        this.i.setShadowLayer(1.0F, 1.0F, 1.0F, -10066330);
        this.k.setShadowLayer(1.0F, 1.0F, 1.0F, -10066330);
      }
    }
  }
  
  public void setSubtitleText(String paramString)
  {
    this.k.setText(paramString);
    TextView localTextView = this.k;
    if (TextUtils.isEmpty(paramString)) {}
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.k.setOnClickListener(this.s);
      return;
    }
  }
  
  public void setTitleText(String paramString)
  {
    this.j = com.whatsapp.emoji.c.a(paramString, getContext(), this.i.getPaint(), 0.9F);
    this.i.setText(this.j);
    this.i.setOnClickListener(this.s);
  }
  
  public void setTitleVerified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      al.a(this.t, this.i, 2130840264);
      this.i.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131362112));
      return;
    }
    this.i.setCompoundDrawables(null, null, null, null);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ChatInfoLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */