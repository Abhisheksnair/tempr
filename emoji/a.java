package com.whatsapp.emoji;

public final class a
{
  public final int[] a;
  
  public a(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (a)paramObject;
          if (this.a == ((a)paramObject).a) {
            return true;
          }
          bool1 = bool2;
        } while (this.a == null);
        bool1 = bool2;
      } while (((a)paramObject).a == null);
      bool1 = bool2;
    } while (this.a.length != ((a)paramObject).a.length);
    int i = 0;
    for (;;)
    {
      if (i >= this.a.length) {
        break label123;
      }
      bool1 = bool2;
      if (this.a[i] != paramObject.a[i]) {
        break;
      }
      i += 1;
    }
    label123:
    return true;
  }
  
  public final int hashCode()
  {
    int k = 1;
    int i = 1;
    if (this.a != null)
    {
      int[] arrayOfInt = this.a;
      int m = arrayOfInt.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        j += 1;
        i = k + i * 31;
      }
    }
    return k;
  }
  
  public final String toString()
  {
    if (this.a == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int[] arrayOfInt = this.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(k));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */