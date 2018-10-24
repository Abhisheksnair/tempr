package com.whatsapp.util.dns;

import com.whatsapp.util.Log;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Locale;

public final class DnsCacheEntrySerializable
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final Long expirationTime;
  public final boolean forceOverride;
  public final InetAddress inetAddress;
  public final Short portNumber;
  public final boolean secureSocket;
  
  public DnsCacheEntrySerializable(Long paramLong, InetAddress paramInetAddress)
  {
    this(paramLong, paramInetAddress, null, false, false);
  }
  
  public DnsCacheEntrySerializable(Long paramLong, InetAddress paramInetAddress, Short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.expirationTime = paramLong;
    this.inetAddress = paramInetAddress;
    this.portNumber = paramShort;
    this.secureSocket = paramBoolean1;
    this.forceOverride = paramBoolean2;
  }
  
  public static DnsCacheEntrySerializable parseFallbackIpString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.split("\\|", 6);
    if (localObject.length != 6)
    {
      Log.e("DnsCacheEntrySerializable/parseFallbackIpString/" + paramString);
      return null;
    }
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(localObject[0]);
      short s = Short.parseShort(localObject[1]);
      localObject = new DnsCacheEntrySerializable(Long.valueOf((Long.parseLong(localObject[2]) + Long.parseLong(localObject[3])) * 1000L), localInetAddress, Short.valueOf(s), Boolean.parseBoolean(localObject[4]), Boolean.parseBoolean(localObject[5]));
      return (DnsCacheEntrySerializable)localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.d("DnsCacheEntrySerializable/parseFallbackIpString/" + paramString, localNumberFormatException);
      return null;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;) {}
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof DnsCacheEntrySerializable))) {}
    do
    {
      return false;
      paramObject = (DnsCacheEntrySerializable)paramObject;
    } while (((this.expirationTime != ((DnsCacheEntrySerializable)paramObject).expirationTime) && ((this.expirationTime == null) || (!this.expirationTime.equals(((DnsCacheEntrySerializable)paramObject).expirationTime)))) || ((this.inetAddress != ((DnsCacheEntrySerializable)paramObject).inetAddress) && ((this.inetAddress == null) || (!this.inetAddress.equals(((DnsCacheEntrySerializable)paramObject).inetAddress)))) || ((this.portNumber != ((DnsCacheEntrySerializable)paramObject).portNumber) && ((this.portNumber == null) || (!this.portNumber.equals(((DnsCacheEntrySerializable)paramObject).portNumber)))));
    return true;
  }
  
  public final InetSocketAddress getInetSocketAddress()
  {
    if ((this.inetAddress == null) || (this.portNumber == null)) {
      return null;
    }
    return new InetSocketAddress(this.inetAddress, this.portNumber.shortValue());
  }
  
  public final int hashCode()
  {
    int k = 0;
    int i;
    if (this.expirationTime != null)
    {
      i = this.expirationTime.hashCode();
      if (this.inetAddress == null) {
        break label67;
      }
    }
    label67:
    for (int j = this.inetAddress.hashCode();; j = 0)
    {
      if (this.portNumber != null) {
        k = this.portNumber.hashCode();
      }
      return (j + (i + 41) * 41) * 41 + k;
      i = 0;
      break;
    }
  }
  
  public final boolean isExpired()
  {
    return (this.expirationTime != null) && (System.currentTimeMillis() >= this.expirationTime.longValue());
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "%s:%d EXPIRE: %tc", new Object[] { this.inetAddress, this.portNumber, this.expirationTime });
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/dns/DnsCacheEntrySerializable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */