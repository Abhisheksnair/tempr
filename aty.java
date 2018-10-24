package com.whatsapp;

public final class aty
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (aty)paramObject;
      if (this.b != null) {
        break;
      }
    } while (((aty)paramObject).b == null);
    return false;
    return this.b.equals(((aty)paramObject).b);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */