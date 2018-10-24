package com.whatsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;

public abstract class mc<VH extends RecyclerView.p>
  extends RecyclerView.a<VH>
{
  boolean c;
  private Context d;
  private Cursor e;
  private int f;
  private DataSetObserver g;
  
  public mc(Context paramContext)
  {
    this.d = paramContext;
    this.e = null;
    this.c = false;
    if (this.c) {}
    for (int i = this.e.getColumnIndex("_id");; i = -1)
    {
      this.f = i;
      this.g = new a((byte)0);
      super.a(true);
      if (this.e != null) {
        this.e.registerDataSetObserver(this.g);
      }
      return;
    }
  }
  
  public final int a()
  {
    if ((this.c) && (this.e != null)) {
      return this.e.getCount();
    }
    return 0;
  }
  
  public final void a(Cursor paramCursor)
  {
    if (paramCursor == this.e) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.e;
      if ((localCursor != null) && (this.g != null)) {
        localCursor.unregisterDataSetObserver(this.g);
      }
      this.e = paramCursor;
      if (this.e != null)
      {
        if (this.g != null) {
          this.e.registerDataSetObserver(this.g);
        }
        this.f = paramCursor.getColumnIndexOrThrow("_id");
        this.c = true;
        c();
        paramCursor = localCursor;
      }
      else
      {
        this.f = -1;
        this.c = false;
        c();
        paramCursor = localCursor;
      }
    }
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    if (!this.c) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.e.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    a(paramVH, this.e);
  }
  
  public abstract void a(VH paramVH, Cursor paramCursor);
  
  public final void a(boolean paramBoolean)
  {
    super.a(true);
  }
  
  public final long b(int paramInt)
  {
    if ((this.c) && (this.e != null) && (this.e.moveToPosition(paramInt))) {
      return this.e.getLong(this.f);
    }
    return 0L;
  }
  
  final class a
    extends DataSetObserver
  {
    private a() {}
    
    public final void onChanged()
    {
      super.onChanged();
      mc.this.c = true;
      mc.this.c();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      mc.this.c = false;
      mc.this.c();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/mc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */