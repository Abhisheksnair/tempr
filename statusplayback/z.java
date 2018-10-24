package com.whatsapp.statusplayback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.whatsapp.protocol.j;
import com.whatsapp.util.ag.a;

public final class z
  implements ag.a
{
  final int a;
  
  public z(Context paramContext)
  {
    this.a = paramContext.getResources().getDimensionPixelSize(2131362101);
  }
  
  public static int a(j paramj)
  {
    switch (paramj.s)
    {
    case 2: 
    default: 
      return 2130837735;
    }
    return 2130840260;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(View paramView)
  {
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageResource(2130837735);
    }
  }
  
  public final void a(View paramView, Bitmap paramBitmap, j paramj)
  {
    if (paramBitmap != null)
    {
      ((ImageView)paramView).setImageBitmap(paramBitmap);
      return;
    }
    ((ImageView)paramView).setImageResource(a(paramj));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */