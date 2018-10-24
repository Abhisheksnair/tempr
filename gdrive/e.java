package com.whatsapp.gdrive;

import com.whatsapp.util.Log;
import java.util.Random;

final class e
{
  private static volatile e b;
  private static final Random c = new Random();
  final int a;
  
  private e(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static e a(int paramInt)
  {
    if (paramInt == 14)
    {
      if (b == null) {}
      try
      {
        if (b == null) {
          b = new e(14);
        }
        return b;
      }
      finally {}
    }
    return new e(paramInt);
  }
  
  public static void b(int paramInt)
  {
    paramInt = (1 << paramInt) * 1000;
    int i = paramInt / 2;
    paramInt = c.nextInt(paramInt) + i;
    Log.i("gdrive/backoff-policy/backoff/" + paramInt + " milliseconds");
    Thread.sleep(paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */