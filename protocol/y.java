package com.whatsapp.protocol;

import java.util.Iterator;
import java.util.List;

public abstract class y
{
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt);
  }
  
  public void a(ak paramak)
  {
    paramak = paramak.f("error").iterator();
    while (paramak.hasNext())
    {
      Object localObject = (ak)paramak.next();
      if (localObject != null)
      {
        String str = ((ak)localObject).a("code", null);
        localObject = ((ak)localObject).a("text", null);
        if (str != null) {
          a(Integer.parseInt(str), (String)localObject);
        }
      }
    }
  }
  
  public abstract void a(ak paramak, String paramString);
  
  public void a(Exception paramException) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */