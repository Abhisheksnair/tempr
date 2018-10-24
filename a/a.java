package com.whatsapp.a;

import java.util.Date;
import org.whispersystems.a.c;

public final class a
{
  public final c a;
  private final Date b;
  
  public a(c paramc, Date paramDate)
  {
    this.a = paramc;
    this.b = paramDate;
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
      paramObject = (a)paramObject;
      if (this.b != null)
      {
        if (this.b.equals(((a)paramObject).b)) {}
      }
      else {
        while (((a)paramObject).b != null) {
          return false;
        }
      }
      if (this.a == null) {
        break;
      }
    } while (this.a.equals(((a)paramObject).a));
    for (;;)
    {
      return false;
      if (((a)paramObject).a == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 31 + j;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */