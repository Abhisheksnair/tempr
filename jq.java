package com.whatsapp;

import android.content.Context;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public final class jq
  extends hy
{
  private final TextEmojiLabel O = (TextEmojiLabel)findViewById(2131755603);
  private final String P;
  
  public jq(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (paramj.e.b) {}
    for (paramContext = paramContext.getString(2131297624);; paramContext = paramContext.getString(2131297623))
    {
      this.P = paramContext;
      p();
      return;
    }
  }
  
  private void p()
  {
    this.O.setText(this.P);
  }
  
  protected final int a(int paramInt)
  {
    if (!this.a.e.b) {}
    for (int i = 0;; i = 2130840369)
    {
      int j = i;
      if (av.d())
      {
        j = i;
        if (paramInt == 7) {
          j = 2130840369;
        }
      }
      return j;
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
    return 2130903165;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903165;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903166;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */