package com.whatsapp.protocol;

public final class z
{
  public final String a;
  public final String b;
  
  public z(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      throw new NullPointerException();
    }
    this.a = paramString1;
    this.b = paramString2;
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
        paramObject = (z)paramObject;
        if (this.a == null)
        {
          if (((z)paramObject).a != null) {
            return false;
          }
        }
        else if (!this.a.equals(((z)paramObject).a)) {
          return false;
        }
        if (this.b != null) {
          break;
        }
      } while (((z)paramObject).b == null);
      return false;
    } while (this.b.equals(((z)paramObject).b));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.b != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (i + 31) * 31 + j;
      i = this.a.hashCode();
      break;
      label39:
      j = this.b.hashCode();
    }
  }
  
  public final String toString()
  {
    return "KeyValue{key='" + this.a + '\'' + ", value='" + this.b + '\'' + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */