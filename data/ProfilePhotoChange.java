package com.whatsapp.data;

import java.io.Serializable;

public class ProfilePhotoChange
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  public byte[] newPhoto;
  public int newPhotoId;
  public byte[] oldPhoto;
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ProfilePhotoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */