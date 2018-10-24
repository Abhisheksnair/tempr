package com.whatsapp.gallerypicker;

import android.content.Context;
import com.whatsapp.aus;
import com.whatsapp.u;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class ar
{
  private a a;
  private a b;
  private a c;
  private Calendar d;
  private final aus e;
  
  public ar(aus paramaus)
  {
    this.e = paramaus;
    this.a = new a(paramaus, 1, Calendar.getInstance());
    this.a.add(6, -2);
    this.b = new a(paramaus, 2, Calendar.getInstance());
    this.b.add(6, -7);
    this.c = new a(paramaus, 3, Calendar.getInstance());
    this.c.add(6, -28);
    this.d = Calendar.getInstance();
    this.d.add(6, 65170);
  }
  
  public final a a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramLong));
    if (localCalendar.after(this.a)) {
      return this.a;
    }
    if (localCalendar.after(this.b)) {
      return this.b;
    }
    if (localCalendar.after(this.c)) {
      return this.c;
    }
    if (localCalendar.after(this.d)) {
      return new a(this.e, 4, new GregorianCalendar(localCalendar.get(1), localCalendar.get(2), 1));
    }
    return new a(this.e, 5, new GregorianCalendar(localCalendar.get(1), 1, 1));
  }
  
  public static final class a
    extends GregorianCalendar
  {
    public int a;
    public int b;
    private final transient SimpleDateFormat c;
    
    public a(aus paramaus, int paramInt, Calendar paramCalendar)
    {
      this.c = a(paramaus);
      this.a = paramInt;
      setTime(paramCalendar.getTime());
    }
    
    public a(aus paramaus, a parama)
    {
      this.c = a(paramaus);
      this.a = parama.a;
      this.b = parama.b;
      setTime(parama.getTime());
    }
    
    private static SimpleDateFormat a(aus paramaus)
    {
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("LLLL", paramaus.b());
        return localSimpleDateFormat;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
      return new SimpleDateFormat("MMMM", paramaus.b());
    }
    
    public final String toString()
    {
      switch (this.a)
      {
      default: 
        return Integer.toString(get(1));
      case 1: 
        return u.a().getString(2131297506);
      case 2: 
        return u.a().getString(2131298199);
      case 3: 
        return u.a().getString(2131297189);
      }
      return this.c.format(getTime());
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */