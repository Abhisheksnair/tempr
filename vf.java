package com.whatsapp;

import android.content.Context;
import android.database.AbstractCursor;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import java.util.ArrayList;

public final class vf
  extends AbstractCursor
{
  private static final String[] a = { "jid", "name" };
  private final Context b;
  private final e c;
  private final lt d;
  
  public vf(Context paramContext, e parame, lt paramlt)
  {
    this.b = paramContext;
    this.c = parame;
    this.d = paramlt;
  }
  
  public final String[] getColumnNames()
  {
    return a;
  }
  
  public final int getCount()
  {
    return this.d.i();
  }
  
  public final double getDouble(int paramInt)
  {
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    switch (paramInt)
    {
    }
    ArrayList localArrayList;
    do
    {
      return "";
      localArrayList = this.d.j();
      paramInt = getPosition();
      if (localArrayList.size() > paramInt) {
        return (String)localArrayList.get(paramInt);
      }
      localArrayList = this.d.j();
      paramInt = getPosition();
    } while (localArrayList.size() <= paramInt);
    return this.c.d((String)localArrayList.get(paramInt)).a(this.b);
  }
  
  public final boolean isNull(int paramInt)
  {
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */