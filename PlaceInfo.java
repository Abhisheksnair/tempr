package com.whatsapp;

import android.location.Location;
import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlaceInfo
  implements Serializable
{
  public static final int SOURCES_COUNT = 3;
  public static final int SOURCE_FACEBOOK = 1;
  public static final int SOURCE_FOURSQUARE = 3;
  public static final int SOURCE_GOOGLE = 2;
  public static final int SOURCE_UNDEFINED = 0;
  private static final long serialVersionUID = 1L;
  public String address;
  public double dist;
  public boolean hasDetails;
  public String icon;
  public double lat;
  private transient Location location;
  public double lon;
  public String name;
  public String phone;
  public String placeId;
  public String rating;
  public int source;
  public transient Object tag;
  public String url;
  public String vicinity;
  
  /* Error */
  private void downloadDetailsGoogle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 52	org/apache/http/params/BasicHttpParams
    //   5: dup
    //   6: invokespecial 53	org/apache/http/params/BasicHttpParams:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: sipush 15000
    //   14: invokestatic 59	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   17: aload_1
    //   18: sipush 30000
    //   21: invokestatic 62	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   24: aload_1
    //   25: invokestatic 68	com/whatsapp/ape:a	()Ljava/lang/String;
    //   28: invokestatic 74	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   31: new 76	org/apache/http/impl/client/DefaultHttpClient
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 79	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   39: astore_3
    //   40: new 81	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   47: getstatic 87	com/whatsapp/aut:j	Ljava/lang/String;
    //   50: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: getfield 93	com/whatsapp/PlaceInfo:placeId	Ljava/lang/String;
    //   57: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_2
    //   64: invokestatic 101	com/whatsapp/u:a	()Landroid/content/Context;
    //   67: invokevirtual 107	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   70: invokevirtual 113	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   73: getfield 119	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   76: astore 4
    //   78: aload_2
    //   79: astore_1
    //   80: aload 4
    //   82: ifnull +31 -> 113
    //   85: new 81	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 121
    //   98: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 4
    //   103: invokevirtual 126	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   106: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_1
    //   113: new 128	org/apache/http/client/methods/HttpGet
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 131	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_3
    //   123: aload_1
    //   124: invokevirtual 135	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 141 1 0
    //   134: invokeinterface 147 1 0
    //   139: sipush 200
    //   142: if_icmpne +56 -> 198
    //   145: new 149	org/json/JSONObject
    //   148: dup
    //   149: aload_1
    //   150: invokeinterface 153 1 0
    //   155: invokestatic 158	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   158: invokespecial 159	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   161: astore_1
    //   162: ldc -95
    //   164: aload_1
    //   165: ldc -93
    //   167: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +25 -> 198
    //   176: aload_1
    //   177: ldc -81
    //   179: invokevirtual 179	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +14 -> 198
    //   187: aload_0
    //   188: aload_1
    //   189: iconst_1
    //   190: invokevirtual 183	com/whatsapp/PlaceInfo:fromJsonGoogle	(Lorg/json/JSONObject;Z)V
    //   193: aload_0
    //   194: iconst_1
    //   195: putfield 185	com/whatsapp/PlaceInfo:hasDetails	Z
    //   198: aload_0
    //   199: monitorexit
    //   200: return
    //   201: astore_1
    //   202: aload_1
    //   203: invokestatic 191	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   206: goto -8 -> 198
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload_1
    //   216: invokestatic 191	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   219: goto -21 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	PlaceInfo
    //   9	180	1	localObject1	Object
    //   201	2	1	localIOException	java.io.IOException
    //   209	4	1	localObject2	Object
    //   214	2	1	localJSONException	org.json.JSONException
    //   63	30	2	str	String
    //   39	84	3	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   76	26	4	localLocale	java.util.Locale
    // Exception table:
    //   from	to	target	type
    //   122	183	201	java/io/IOException
    //   187	198	201	java/io/IOException
    //   2	78	209	finally
    //   85	113	209	finally
    //   113	122	209	finally
    //   122	183	209	finally
    //   187	198	209	finally
    //   202	206	209	finally
    //   215	219	209	finally
    //   122	183	214	org/json/JSONException
    //   187	198	214	org/json/JSONException
  }
  
  public void downloadDetails()
  {
    try
    {
      boolean bool = this.hasDetails;
      if (bool) {}
      for (;;)
      {
        return;
        switch (this.source)
        {
        case 2: 
          downloadDetailsGoogle();
        }
      }
    }
    finally {}
  }
  
  public void fromJsonFacebook(JSONObject paramJSONObject)
  {
    this.source = 1;
    this.name = paramJSONObject.getString("name");
    this.placeId = paramJSONObject.optString("id");
    this.url = paramJSONObject.optString("link");
    this.icon = "https://www.facebook.com/images/places/topics/pin_72.png";
    Object localObject = paramJSONObject.getJSONObject("location");
    if (localObject != null)
    {
      this.lat = ((JSONObject)localObject).optDouble("latitude");
      this.lon = ((JSONObject)localObject).optDouble("longitude");
      this.address = ((JSONObject)localObject).optString("street");
      String str = ((JSONObject)localObject).optString("city");
      if (!TextUtils.isEmpty(str))
      {
        if ((!TextUtils.isEmpty(this.address)) && (!this.address.endsWith(","))) {
          this.address += ", ";
        }
        this.address += str;
      }
      this.vicinity = this.address;
      localObject = ((JSONObject)localObject).optString("state");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!TextUtils.isEmpty(this.address)) {
          this.address += ", ";
        }
        this.address += (String)localObject;
      }
    }
    paramJSONObject = paramJSONObject.optJSONObject("place_topics");
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramJSONObject = paramJSONObject.optJSONObject(0);
        if (paramJSONObject != null) {
          this.icon = (paramJSONObject.optString("icon_url") + "_72.png");
        }
      }
    }
    this.hasDetails = true;
  }
  
  public void fromJsonFoursquare(JSONObject paramJSONObject)
  {
    int i = 0;
    this.source = 3;
    this.name = paramJSONObject.getString("name");
    this.url = paramJSONObject.optString("url");
    this.placeId = paramJSONObject.optString("id");
    if (TextUtils.isEmpty(this.url)) {
      this.url = ("https://foursquare.com/v/" + this.placeId);
    }
    Object localObject1 = paramJSONObject.getJSONObject("location");
    if (localObject1 != null)
    {
      this.lat = ((JSONObject)localObject1).optDouble("lat");
      this.lon = ((JSONObject)localObject1).optDouble("lng");
      this.address = ((JSONObject)localObject1).optString("address");
      this.vicinity = this.address;
      localObject2 = ((JSONObject)localObject1).optString("city");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!TextUtils.isEmpty(this.address)) {
          this.address += ", ";
        }
        this.address += (String)localObject2;
      }
      localObject2 = ((JSONObject)localObject1).optString("state");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!TextUtils.isEmpty(this.address)) {
          this.address += ", ";
        }
        this.address += (String)localObject2;
      }
      localObject1 = ((JSONObject)localObject1).optString("postalCode");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.isEmpty(this.address)) {
          this.address += " ";
        }
        this.address += (String)localObject1;
      }
      this.hasDetails = true;
    }
    Object localObject2 = paramJSONObject.optJSONArray("categories");
    if (localObject2 != null)
    {
      paramJSONObject = ((JSONArray)localObject2).optJSONObject(0);
      if (i >= ((JSONArray)localObject2).length()) {
        break label484;
      }
      localObject1 = ((JSONArray)localObject2).optJSONObject(i);
      if ((localObject1 == null) || (!((JSONObject)localObject1).optBoolean("primary"))) {
        break label477;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    label477:
    label484:
    for (;;)
    {
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("icon");
        if (paramJSONObject != null)
        {
          this.icon = paramJSONObject.optString("prefix");
          if (this.icon != null) {
            this.icon += "64.png";
          }
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void fromJsonGoogle(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.source = 2;
    this.name = paramJSONObject.getString("name");
    this.placeId = paramJSONObject.optString("place_id");
    this.vicinity = paramJSONObject.optString("vicinity");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("geometry");
    if (localJSONObject != null)
    {
      localJSONObject = localJSONObject.getJSONObject("location");
      if (localJSONObject != null)
      {
        this.lat = localJSONObject.getDouble("lat");
        this.lon = localJSONObject.getDouble("lng");
      }
    }
    this.icon = paramJSONObject.optString("icon");
    if (paramBoolean)
    {
      this.url = paramJSONObject.optString("url");
      this.phone = paramJSONObject.optString("formatted_phone_number");
      this.address = paramJSONObject.optString("formatted_address");
      this.rating = paramJSONObject.optString("rating");
      if (this.address != null) {
        this.address = this.address.replace(", United States", "");
      }
      this.hasDetails = true;
    }
  }
  
  public Location getLocation()
  {
    if (this.location == null)
    {
      this.location = new Location("");
      this.location.setLatitude(this.lat);
      this.location.setLongitude(this.lon);
    }
    return this.location;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/PlaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */