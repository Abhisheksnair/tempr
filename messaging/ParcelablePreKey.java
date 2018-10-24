package com.whatsapp.messaging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.whatsapp.protocol.aj;

public final class ParcelablePreKey
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelablePreKey> CREATOR = new Parcelable.Creator() {};
  public final aj a;
  
  public ParcelablePreKey(Parcel paramParcel)
  {
    this.a = new aj(paramParcel.createByteArray(), paramParcel.createByteArray(), paramParcel.createByteArray());
  }
  
  public ParcelablePreKey(aj paramaj)
  {
    this.a = paramaj;
  }
  
  public static ParcelablePreKey[] a(aj[] paramArrayOfaj)
  {
    ParcelablePreKey[] arrayOfParcelablePreKey = new ParcelablePreKey[paramArrayOfaj.length];
    int i = 0;
    while (i < paramArrayOfaj.length)
    {
      arrayOfParcelablePreKey[i] = new ParcelablePreKey(paramArrayOfaj[i]);
      i += 1;
    }
    return arrayOfParcelablePreKey;
  }
  
  public static aj[] a(ParcelablePreKey[] paramArrayOfParcelablePreKey)
  {
    aj[] arrayOfaj = new aj[paramArrayOfParcelablePreKey.length];
    int i = 0;
    while (i < paramArrayOfParcelablePreKey.length)
    {
      arrayOfaj[i] = paramArrayOfParcelablePreKey[i].a;
      i += 1;
    }
    return arrayOfaj;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.a.a);
    paramParcel.writeByteArray(this.a.b);
    paramParcel.writeByteArray(this.a.c);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ParcelablePreKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */