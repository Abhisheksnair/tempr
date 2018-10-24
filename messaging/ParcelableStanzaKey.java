package com.whatsapp.messaging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.whatsapp.protocol.al;

public final class ParcelableStanzaKey
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableStanzaKey> CREATOR = new Parcelable.Creator() {};
  public final al a;
  
  private ParcelableStanzaKey(Parcel paramParcel)
  {
    this.a = new al();
    this.a.a = paramParcel.readString();
    this.a.b = paramParcel.readString();
    this.a.c = paramParcel.readString();
    this.a.d = paramParcel.readString();
    this.a.e = paramParcel.readString();
    this.a.f = paramParcel.readString();
  }
  
  public ParcelableStanzaKey(al paramal)
  {
    this.a = paramal;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.a);
    paramParcel.writeString(this.a.b);
    paramParcel.writeString(this.a.c);
    paramParcel.writeString(this.a.d);
    paramParcel.writeString(this.a.e);
    paramParcel.writeString(this.a.f);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ParcelableStanzaKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */