package com.whatsapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.whatsapp.protocol.j.b;

public class FMessageKey
  implements Parcelable
{
  public static final Parcelable.Creator<FMessageKey> CREATOR = new Parcelable.Creator() {};
  public final j.b a;
  
  public FMessageKey(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.a = new j.b(str, bool, paramParcel.readString());
      return;
      bool = false;
    }
  }
  
  public FMessageKey(j.b paramb)
  {
    this.a = paramb;
  }
  
  public static j.b a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    return ((FMessageKey)CREATOR.createFromParcel(localParcel)).a;
  }
  
  public static byte[] a(j.b paramb)
  {
    Object localObject = new FMessageKey(paramb);
    paramb = Parcel.obtain();
    ((FMessageKey)localObject).writeToParcel(paramb, 0);
    localObject = paramb.marshall();
    paramb.recycle();
    return (byte[])localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.a);
    if (this.a.b) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.a.c);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/FMessageKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */