package com.whatsapp;

import android.annotation.TargetApi;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.net.Uri;
import com.whatsapp.data.l;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import java.io.File;

public final class vj
  extends AbstractCursor
{
  public static final String[] c = { "_id", "_data", "date", "title", "mime_type", "media_type", "media_type", "duration" };
  Cursor a;
  int b = -1;
  private final String d;
  private boolean e;
  private final l f;
  
  public vj(l paraml, String paramString, Cursor paramCursor)
  {
    this(paraml, paramString, paramCursor, false);
  }
  
  public vj(l paraml, String paramString, Cursor paramCursor, boolean paramBoolean)
  {
    this.f = paraml;
    this.a = paramCursor;
    this.d = paramString;
    this.e = paramBoolean;
    moveToPosition(0);
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (this.a.moveToPrevious())
      {
        if (c()) {
          bool1 = true;
        }
      }
      else
      {
        if (i > 0) {
          Log.i("mediacursor/prev/skip " + i);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean c()
  {
    j localj = this.f.a(this.a, this.d);
    if ((localj.N instanceof MediaData))
    {
      MediaData localMediaData = localj.b();
      if (((localj.e.b) || (localMediaData.transferred)) && (localMediaData.file != null))
      {
        if (!new File(Uri.fromFile(localMediaData.file).getPath()).exists()) {}
      }
      else {
        while ((this.e) && (m.e(localj))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final j a()
  {
    return this.f.a(this.a, this.d);
  }
  
  public final void close()
  {
    super.close();
    this.a.close();
  }
  
  public final String[] getColumnNames()
  {
    return c;
  }
  
  public final int getCount()
  {
    if (this.b < 0) {
      return this.a.getCount();
    }
    return this.b;
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
    switch (paramInt)
    {
    default: 
      return 0L;
    case 0: 
      return this.a.getLong(this.a.getColumnIndex("_id"));
    case 2: 
      return this.f.a(this.a, this.d).n;
    }
    j localj = this.f.a(this.a, this.d);
    if (localj.s == 9) {
      return localj.x;
    }
    return localj.w;
  }
  
  public final short getShort(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    }
    return (short)this.f.a(this.a, this.d).s;
  }
  
  public final String getString(int paramInt)
  {
    switch (paramInt)
    {
    }
    Object localObject;
    for (;;)
    {
      return "";
      return Long.toString(this.a.getLong(this.a.getColumnIndex("_id")));
      localObject = this.f.a(this.a, this.d);
      if (localObject != null)
      {
        localObject = ((j)localObject).b();
        if ((localObject != null) && (((MediaData)localObject).file != null))
        {
          return ((MediaData)localObject).file.getAbsolutePath();
          localObject = this.f.a(this.a, this.d);
          if (localObject != null)
          {
            return Long.toString(((j)localObject).n);
            return this.f.a(this.a, this.d).z;
            localObject = this.f.a(this.a, this.d);
            switch (((j)localObject).s)
            {
            }
          }
        }
      }
    }
    return "image/*";
    return "audio/*";
    return "image/gif";
    return "video/*";
    return ((j)localObject).r;
  }
  
  @TargetApi(11)
  public final int getType(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 3;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      return i;
    case 1: 
      return 3;
    case 3: 
      return 3;
    }
    return 3;
  }
  
  public final boolean isNull(int paramInt)
  {
    return false;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2 << 1)
    {
      this.a.moveToPosition(-1);
      paramInt1 = -1;
    }
    for (;;)
    {
      int j;
      if (paramInt2 > paramInt1)
      {
        int i = 0;
        for (;;)
        {
          if (this.a.moveToNext())
          {
            if (c())
            {
              j = 1;
              if (i > 0) {
                Log.i("mediacursor/next/skip " + i);
              }
              if (j == 0)
              {
                this.b = (paramInt1 + 1);
                this.a.moveToPosition(-1);
                Log.i("mediacursor/next/realcount " + this.b);
                onChange(true);
                return false;
              }
            }
            else
            {
              i += 1;
              continue;
            }
            paramInt1 += 1;
            break;
            label138:
            paramInt1 -= 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < paramInt1)
        {
          if (b()) {
            break label138;
          }
          this.a.moveToPosition(-1);
          Log.i("mediacursor/prev/notfound");
          onChange(true);
          return false;
        }
        return true;
        j = 0;
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */