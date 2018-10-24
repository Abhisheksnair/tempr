package com.whatsapp.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import com.whatsapp.u;

public final class f
  extends g
{
  private static f a;
  private int b;
  
  private f(Paint paramPaint)
  {
    super(paramPaint);
  }
  
  public static e a()
  {
    int i = u.a().getResources().getDimensionPixelSize(2131361979);
    if ((a == null) || (u.a().getResources().getDimensionPixelSize(2131361979) != a.b))
    {
      Object localObject = new Paint();
      ((Paint)localObject).setTextSize(u.a().getResources().getDimensionPixelSize(2131361979));
      localObject = new f((Paint)localObject);
      a = (f)localObject;
      ((f)localObject).b = i;
    }
    return a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */