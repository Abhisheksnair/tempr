package com.whatsapp.util.undobar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.animation.Animation;

public class UndoBarStyle
  implements Parcelable
{
  public static final Parcelable.Creator<UndoBarStyle> CREATOR = new Parcelable.Creator() {};
  int a;
  int b;
  int c;
  long d = 5000L;
  Animation e;
  Animation f;
  
  public UndoBarStyle(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public UndoBarStyle(int paramInt1, int paramInt2, long paramLong)
  {
    this(paramInt1, paramInt2);
  }
  
  public UndoBarStyle(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      paramObject = (UndoBarStyle)paramObject;
    } while ((this.c == ((UndoBarStyle)paramObject).c) && (this.d == ((UndoBarStyle)paramObject).d) && (this.a == ((UndoBarStyle)paramObject).a) && (this.b == ((UndoBarStyle)paramObject).b));
    return false;
  }
  
  public String toString()
  {
    return "UndoBarStyle{iconRes=" + this.a + ", titleRes=" + this.b + ", bgRes=" + this.c + ", duration=" + this.d + ", inAnimation=" + this.e + ", outAnimation=" + this.f + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.d);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/undobar/UndoBarStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */