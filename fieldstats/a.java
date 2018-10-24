package com.whatsapp.fieldstats;

final class a
{
  final Object a;
  
  a(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      for (;;)
      {
        this.a = localObject;
        return;
        if ((paramObject instanceof Boolean))
        {
          if (((Boolean)paramObject).booleanValue()) {}
          for (double d = 1.0D;; d = 0.0D)
          {
            localObject = Double.valueOf(d);
            break;
          }
        }
        if (!(paramObject instanceof Number)) {
          break;
        }
        localObject = Double.valueOf(((Number)paramObject).doubleValue());
      }
      localObject = paramObject;
    } while ((paramObject instanceof String));
    throw new IllegalArgumentException("Attribute type must be Boolean, Number, or String");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
        if ((this.a != null) && (((a)paramObject).a != null)) {
          break;
        }
      } while (this.a == ((a)paramObject).a);
      return false;
    } while ((this.a == ((a)paramObject).a) || (this.a.equals(((a)paramObject).a)));
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */