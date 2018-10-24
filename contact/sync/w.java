package com.whatsapp.contact.sync;

public enum w
{
  public final q h;
  public final r i;
  final int j;
  
  private w(q paramq, r paramr, int paramInt)
  {
    this.h = paramq;
    this.i = paramr;
    this.j = paramInt;
  }
  
  public static w a(int paramInt)
  {
    w[] arrayOfw = values();
    int n = arrayOfw.length;
    int m = 0;
    while (m < n)
    {
      w localw = arrayOfw[m];
      if (localw.j == paramInt) {
        return localw;
      }
      m += 1;
    }
    return null;
  }
  
  public static w a(w paramw1, w paramw2)
  {
    if ((paramw1 == paramw2) || (paramw2 == null)) {
      localObject1 = paramw1;
    }
    do
    {
      return (w)localObject1;
      localObject1 = paramw2;
    } while (paramw1 == null);
    Object localObject2 = paramw1.h;
    Object localObject1 = paramw2.h;
    if (((q)localObject2).compareTo((Enum)localObject1) < 0)
    {
      label44:
      paramw1 = paramw1.i;
      paramw2 = paramw2.i;
      if (paramw1.compareTo(paramw2) >= 0) {
        break label117;
      }
    }
    for (;;)
    {
      w[] arrayOfw = values();
      int n = arrayOfw.length;
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label122;
        }
        paramw2 = arrayOfw[m];
        if (paramw2.h == localObject2)
        {
          localObject1 = paramw2;
          if (paramw2.i == paramw1) {
            break;
          }
        }
        m += 1;
      }
      localObject2 = localObject1;
      break label44;
      label117:
      paramw1 = paramw2;
    }
    label122:
    throw new IllegalArgumentException("Context/Mode (" + localObject2 + "/" + paramw1 + ") do not represent a recognized SyncType");
  }
  
  public final boolean a()
  {
    return this.i == r.a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */