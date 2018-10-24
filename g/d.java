package com.whatsapp.g;

import android.content.Intent;

public final class d
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public d(Intent paramIntent)
  {
    if (!"android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction())) {
      throw new IllegalArgumentException("Intent must be android.intent.action.BATTERY_CHANGED");
    }
    this.a = paramIntent.getIntExtra("health", 1);
    this.b = paramIntent.getIntExtra("level", -1);
    this.c = paramIntent.getIntExtra("plugged", 0);
    this.d = paramIntent.getIntExtra("scale", -1);
  }
  
  public final double a()
  {
    if ((this.b >= 0) && (this.d > 0)) {
      return this.b * 100.0D / this.d;
    }
    return NaN.0D;
  }
  
  public final boolean b()
  {
    return this.c != 0;
  }
  
  public final boolean c()
  {
    double d1 = a();
    return (b()) || ((d1 != NaN.0D) && (d1 > 20.0D));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.a == ((d)paramObject).a) && (this.b == ((d)paramObject).b) && (this.c == ((d)paramObject).c) && (this.d == ((d)paramObject).d));
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BatteryChange{health=");
    String str;
    switch (this.a)
    {
    default: 
      str = "other(" + this.a + ')';
    }
    for (;;)
    {
      return str + ", level=" + this.b + ", plugged=" + this.c + ", scale=" + this.d + ", percent=" + a() + '}';
      str = "unknown";
      continue;
      str = "good";
      continue;
      str = "overheat";
      continue;
      str = "dead";
      continue;
      str = "over_voltage";
      continue;
      str = "unspecified_failure";
      continue;
      str = "cold";
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */