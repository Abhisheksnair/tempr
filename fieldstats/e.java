package com.whatsapp.fieldstats;

public abstract class e
  implements Cloneable
{
  final int code;
  
  public e(int paramInt)
  {
    this.code = paramInt;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public abstract void serialize(d paramd, g paramg);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */