package com.whatsapp.data;

import android.database.Cursor;

public final class cu
{
  public static final String[] a = { "_id", "jid", "serial", "issuer", "expires", "verified_name", "industry", "city", "country" };
  public final long b;
  public final String c;
  public final long d;
  public final String e;
  public final long f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  
  private cu(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.c = paramCursor.getString(1);
    this.d = paramCursor.getLong(2);
    this.e = paramCursor.getString(3);
    this.f = paramCursor.getLong(4);
    this.g = paramCursor.getString(5);
    this.h = paramCursor.getString(6);
    this.i = paramCursor.getString(7);
    this.j = paramCursor.getString(8);
  }
  
  public static cu a(Cursor paramCursor)
  {
    return new cu(paramCursor);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */