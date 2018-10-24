package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.widget.TextView;
import com.whatsapp.protocol.j;
import com.whatsapp.util.l;

public final class jn
  extends hy
{
  final TextView O;
  
  jn(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    setClickable(false);
    setLongClickable(false);
    this.O = ((TextView)findViewById(2131755493));
    this.O.setBackgroundResource(2130837768);
    al.a(this.l, this.O);
    this.O.setCompoundDrawablePadding(paramContext.getResources().getDimensionPixelSize(2131361940));
    this.O.setTextSize(a(getResources()));
    this.O.setOnClickListener(jo.a(this, paramj));
    this.O.setOnLongClickListener(this.u);
    setLongClickable(true);
    setWillNotDraw(false);
    p();
  }
  
  private void p()
  {
    TextView localTextView = this.O;
    Context localContext = getContext();
    if (Voip.b(this.a)) {}
    for (int i = 2131298115;; i = 2131297188)
    {
      localTextView.setText(localContext.getString(i, new Object[] { l.a(getContext(), this.v.a(this.a)) }));
      return;
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        p();
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903146;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903146;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903146;
  }
  
  public final void i()
  {
    p();
    super.i();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */